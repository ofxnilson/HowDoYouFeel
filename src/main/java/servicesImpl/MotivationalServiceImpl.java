package servicesImpl;
import generated.grpc.motivationalmessages.*;
import io.grpc.stub.StreamObserver;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
/*
 * @author Nilson Francisco
 */

public class MotivationalServiceImpl extends MotivationalMessagesGrpc.MotivationalMessagesImplBase {
    // Hashmap to store the user entries in the journal
    private final Map<Integer, List<String>> gratitudeJournal = new ConcurrentHashMap<>();

    // List of boost mood messages to send to the user
    private final List<String> motivationalMessages = List.of(
        "You are worthy of love—especially your own.",
        "Speak to yourself with the same kindness you offer others.",
        "You are enough, just as you are.",
        "Your value isn’t measured by your productivity.",
        "Be gentle with yourself—you’re doing the best you can.",
        "Loving yourself is the beginning of everything beautiful.",
        "You deserve rest, peace, and joy.",
        "Your imperfections make you beautifully human.",
        "Celebrate the little things you love about yourself.",
        "You are not behind—you're on your own unique path.",
        "Choosing yourself is never selfish.",
        "Your feelings matter. You matter.",
        "Let go of who you think you should be—embrace who you are.",
        "You are allowed to take up space and be heard.",
        "It’s okay to grow at your own pace.",
        "Your love for yourself sets the tone for every other relationship.",
        "The way you talk to yourself matters—make it loving.",
        "Self-love is not a destination—it’s a daily practice.",
        "You deserve the same love and care you give to others.",
        "You don’t need to earn your worth—it’s already yours.",
        "Be proud of how far you’ve come, even if it’s just getting through today.",
        "You are your own safe place.",
        "Your soul shines brighter than your doubts.",
        "Loving yourself is a radical act—keep going."
    );

    /*
     * Server-streaming RPC to send motivational messages to a user
     * @param request The MotivationRequest containing the user_id.
     * @param responseObserver StreamObserver to send multiple MotivationResponse messages.
     */
    @Override
    public void motivationalMessages(MotivationRequest request, StreamObserver<MotivationResponse> responseObserver){
        int userId = request.getUserId();

        System.out.println("Sending motivational messages to user: " + userId);

        for (String message : motivationalMessages){
            // Build and send each motivational message
            MotivationResponse response = MotivationResponse.newBuilder()
                .setMessage(message)
                .build();
            responseObserver.onNext(response);

            // Delay to simulate real-time message sending - in real world use it would be each hour or two
            try{
                Thread.sleep(2000);  
            } 
            catch (InterruptedException e){
                Thread.currentThread().interrupt();
                break;
            }
        }
        responseObserver.onCompleted();
    }

    /*
     * Client-streaming RPC where the user can submit multiple gratitude entries.
     * Stores entries per user and responds once all are received.
     * @param responseObserver StreamObserver to send a single GratitudeEntryResponse.
     * @return StreamObserver to receive GratitudeEntryRequest from the client.
     */
    @Override
    public StreamObserver<GratitudeEntryRequest> receiveGratitudeJournal(StreamObserver<GratitudeEntryResponse> responseObserver){
        return new StreamObserver<GratitudeEntryRequest>(){
            private final Map<Integer, List<String>> entriesBuffer = new HashMap<>(); // Buffer to hold the user entries

            @Override
            public void onNext(GratitudeEntryRequest request){
                int userId = request.getUserId();
                String entry = "[" + request.getTimestamp() + "] " + request.getGratitudeText();

                // Store in buffer
                entriesBuffer.putIfAbsent(userId, new ArrayList<>());
                entriesBuffer.get(userId).add(entry);

                System.out.println("Received gratitude from user " + userId + ": " + entry);
            }

            @Override
            public void onError(Throwable t){
                System.err.println("Error receiving gratitude entries: " + t.getMessage());
            }

            @Override
            public void onCompleted(){
                // Move entries from buffer to gratitude journal
                for (Map.Entry<Integer, List<String>> userEntries : entriesBuffer.entrySet()){
                    int userId = userEntries.getKey();
                    gratitudeJournal.putIfAbsent(userId, new ArrayList<>());
                    gratitudeJournal.get(userId).addAll(userEntries.getValue());
                }

                // Send confirmation message
                GratitudeEntryResponse response = GratitudeEntryResponse.newBuilder().setMessage("Keep being grateful for the little things! \nYour gratitude has been saved! \nThank you!").build();

                responseObserver.onNext(response);
                responseObserver.onCompleted();
            }
        };
    }
}
