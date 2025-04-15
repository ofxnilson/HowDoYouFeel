package servicesImpl;
import generated.grpc.sentimentanalysis.*;
import io.grpc.stub.StreamObserver;
import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/*
 * @author Nilson Francisco
 */

public class SentimentServiceImpl extends SentimentServiceGrpc.SentimentServiceImplBase{
    // Hashmap to store the sentiments to a key based on a integer userId
    private final Map<Integer, List<SentimentEntry>> sentimentDatabase = new ConcurrentHashMap<>();

    /*
     * Unary RPC to analyze the user sentiment in the text
     * @param request
     * @param responseObserver
     */
    @Override
    public void analyseSaveSentiment(SentimentRequest request, StreamObserver<SentimentResponse> responseObserver){
        String text = request.getText().toLowerCase(); // Get the user text input
        int userId = request.getUserId();
        String activity = request.getActivity();
        String timeOfDay = request.getTimeOfDay();
        String sentiment;   
        float confidence;   // Value given to the sentiments found in the text

        if (text.contains("happy") 
                || text.contains("great") 
                || text.contains("love") 
                || text.contains("enjoy") 
                || text.contains("appreciate") 
                || text.contains("gratefull") 
                || text.contains("delighted") 
                || text.contains("stunning")){
            sentiment = "positive";
            confidence = 0.95f;
        } 
        else if (text.contains("sad") 
                || text.contains("depressed") 
                || text.contains("angry") 
                || text.contains("hate") 
                || text.contains("disapointed") 
                || text.contains ("solitude") 
                || text.contains("death") 
                || text.contains("sick") 
                || text.contains("stressed") 
                || text.contains("kill") 
                || text.contains("lonelly")){
            sentiment = "negative";
            confidence = 0.50f;
        } 
        else{
            sentiment = "neutral";
            confidence = 0.70f;
        }

        // Create a new sentiment entry with the current date and time that is stored and what happened to change the user mood
        SentimentEntry entry = SentimentEntry.newBuilder().setDate(LocalDate.now().toString()).setTimeOfDay(request.getTimeOfDay()).setSentiment(sentiment).setActivity(activity).build();

        // Store the entry in memory on the user ID
        sentimentDatabase.putIfAbsent(userId, new ArrayList<>());
        sentimentDatabase.get(userId).add(entry);

        // Build and return the response
        SentimentResponse response = SentimentResponse.newBuilder().setSentiment(sentiment).setConfidence(confidence).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    /*
     * Unary RPC to get a weekly sentiment report for a user.
     */
    @Override
    public void getWeeklyReport(WeeklyReportRequest request, StreamObserver<WeeklyReportResponse> responseObserver){
        int userId = request.getUserId();

        // Return the sentiment entries for the user
        List<SentimentEntry> entries = sentimentDatabase.getOrDefault(userId, new ArrayList<>());

        // Build the report
        WeeklyReportResponse.Builder reportBuilder = WeeklyReportResponse.newBuilder();
        reportBuilder.addAllEntries(entries); // Add all entries to the response

        // Send the report
        responseObserver.onNext(reportBuilder.build());
        responseObserver.onCompleted();
    }

    /*
     * Bidirectional streaming RPC that simulates a chatbot
     */
    @Override
    public StreamObserver<ChatRequest> chatWithBot(StreamObserver<ChatResponse> responseObserver){
        return new StreamObserver<ChatRequest>(){

            // Called every time the client sends a message.
            @Override
            public void onNext(ChatRequest chatRequest){
                String message = chatRequest.getMessage().toLowerCase(); // Get user message
                String reply;

                // Basic logic to respond to the user input
               if (message.contains("sad") 
                    || message.contains("depressed")
                    || message.contains("angry") 
                    || message.contains("hate") 
                    || message.contains("disapointed") 
                    || message.contains ("solitude") 
                    || message.contains("death") 
                    || message.contains("sick") 
                    || message.contains("stressed") 
                    || message.contains("kill")){
                    reply = "I'm here for you. Remember, you're not alone. Want to talk more?";
                }
                else if (message.contains("happy") 
                        || message.contains("great") 
                        || message.contains("love") 
                        || message.contains("enjoy") 
                        || message.contains("appreciate") 
                        || message.contains("gratefull") 
                        || message.contains("delighted") 
                        || message.contains("stunning")){
                    reply = "That's awesome! What made your day so good?";
                }
                else{
                    reply = "Tell me more about how you're feeling.";
                }

                // Send the chatbot response back to the client
                ChatResponse response = ChatResponse.newBuilder().setResponse(reply).build();

                responseObserver.onNext(response);
            }

            @Override
            public void onError(Throwable t){
                System.err.println("Chat error on: " + t.getMessage());
            }
           
            @Override
            public void onCompleted(){
                responseObserver.onCompleted();
            }
        };
    }
}


