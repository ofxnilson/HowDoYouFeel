package HowDoYouFeel;
import generated.grpc.sentimentanalysis.*;
import io.grpc.stub.StreamObserver;
import java.text.SimpleDateFormat;
import java.util.*;

/*
 * @author Nilson Francisco
 */

public class SentimentServiceImpl extends SentimentServiceGrpc.SentimentServiceImplBase{
    /* Data structure to storage and track sentiments by user ID
    * HashMaps are more adequate for this app, as use the keys to store the entered values
    */
    private final Map<String, List<SentimentEntry>> userSentiments = new HashMap<>();

    // RPC: AnalyseSentiment > Analysis the sentiment by checking for keywords in the user text
    @Override
    public void analyseSentiment(SentimentRequest request, StreamObserver<SentimentResponse> responseObserver){
        String text = request.getText().toLowerCase();
        String sentiment;
        float confidence;

        if (text.contains("happy") || text.contains("great") || text.contains("love") || text.contains("enjoy") || text.contains("appreciate") || text.contains("gratefull") || text.contains("delighted") || text.contains("stunning")){
            sentiment = "positive";
            confidence = 0.95f;
        } 
        else if (text.contains("sad") || text.contains("depressed") || text.contains("angry") || text.contains("hate") || text.contains("disapointed") || text.contains ("solitude") || text.contains("death") || text.contains("sick") || text.contains("stressed") || text.contains("kill")){
            sentiment = "negative";
            confidence = 0.90f;
        } 
        else{
            sentiment = "neutral";
            confidence = 0.70f;
        }

        // Build and return the response with sentiment and confidence
        SentimentResponse response = SentimentResponse.newBuilder()
                .setSentiment(sentiment)
                .setConfidence(confidence)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    // RPC: SaveSentiment
    @Override
    public void saveSentiment(SentimentRequest request, StreamObserver<SaveSentimentResponse> responseObserver){
        // Get user ID from the request
        String userId = request.getUserId();

        // Use the sentiment analysis method to identify sentiment from text
        String sentiment = sentimentFromText(request.getText());

        // Get the current date
        String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());

        // Create a new SentimentEntry message
        SentimentEntry entry = SentimentEntry.newBuilder()
                .setDate(date)
                .setTimeOfDay(request.getTimeOfDay())
                .setSentiment(sentiment)
                .build();

        // Store the entry in the map of the user ID
        userSentiments.putIfAbsent(userId, new ArrayList<>());
        userSentiments.get(userId).add(entry);

        // Build a response message
        SaveSentimentResponse response;
        response = SaveSentimentResponse.newBuilder().setMessage("Your sentiment was saved!").build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    // RPC: GetWeeklyReport
    @Override
    public void getWeeklyReport(WeeklyReportRequest request, StreamObserver<WeeklyReportResponse> responseObserver){
        // Get stored sentiment entries for the requested user ID
        List<SentimentEntry> entries = userSentiments.getOrDefault(request.getUserId(), new ArrayList<>());

        // Build the weekly report response
        WeeklyReportResponse.Builder reportBuilder = WeeklyReportResponse.newBuilder();
        reportBuilder.addAllEntries(entries); // Add all entries to the response

        responseObserver.onNext(reportBuilder.build());
        responseObserver.onCompleted();
    }

    // RPC: ChatWithBot (Bidirectional Streaming) that simulates a simple chatbot that idenfies keywords on the user message
    @Override
    public StreamObserver<ChatRequest> chatWithBot(StreamObserver<ChatResponse> responseObserver){
        return new StreamObserver<ChatRequest>(){
            @Override
            public void onNext(ChatRequest request){
                // Process each message from the user
                String message = request.getMessage().toLowerCase();
                String reply;

                if (message.contains("sad") || message.contains("depressed") || message.contains("angry") || message.contains("hate") || message.contains("disapointed") || message.contains ("solitude") || message.contains("death") || message.contains("sick") || message.contains("stressed") || message.contains("kill")){
                    reply = "I'm here for you. Remember, you're not alone. Want to talk more?";
                }
                else if (message.contains("happy") || message.contains("great") || message.contains("love") || message.contains("enjoy") || message.contains("appreciate") || message.contains("gratefull") || message.contains("delighted") || message.contains("stunning")){
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
            // Throw and error message 
            public void onError(Throwable t){
                System.err.println("Chat error: " + t.getMessage());
            }

            @Override
            // End the streaming when the cliend is finishes it
            public void onCompleted(){
                responseObserver.onCompleted();
            }
        };
    }

    // Helper method to simulate sentiment analysis based on keywords
    private String sentimentFromText(String text){
        text = text.toLowerCase();
        if (text.contains("happy") || text.contains("great") || text.contains("love") || text.contains("enjoy") || text.contains("appreciate") || text.contains("gratefull") || text.contains("delighted") || text.contains("stunning")) return "positive";
        if (text.contains("sad") || text.contains("depressed") || text.contains("angry") || text.contains("hate") || text.contains("disapointed") || text.contains ("solitude") || text.contains("death") || text.contains("sick") || text.contains("stressed") || text.contains("kill")) return "negative";
        return "neutral";
    }
}