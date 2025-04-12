package mainServerClient;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import generated.grpc.sentimentanalysis.SentimentServiceGrpc;
import generated.grpc.sentimentanalysis.SentimentServiceGrpc.SentimentServiceBlockingStub;
import generated.grpc.sentimentanalysis.SentimentServiceGrpc.SentimentServiceStub;
import generated.grpc.motivationalmessages.MotivationalMessagesGrpc;
import generated.grpc.motivationalmessages.MotivationalMessagesGrpc.MotivationalMessagesStub;
import generated.grpc.userservice.UserServiceGrpc;
import generated.grpc.userservice.UserServiceGrpc.UserServiceBlockingStub;

/*
 * @author Nilson Francisco
 * Main gRPC client class that connects to the server and access the stubs for each service.
 */
public class MainClient{
    // gRPC channel to connect to the server
    private final ManagedChannel channel;

    // Sentiment analysis service stubs
    public final SentimentServiceStub sentimentAsyncStub;
    public final SentimentServiceBlockingStub sentimentBlockingStub;

    // Motivational messages service stub
    public final MotivationalMessagesStub motivationalStub;

    // User login service stub
    public final UserServiceBlockingStub userLoginStub;

    // Constructor to initialize the gRPC channel and stubs for services
    public MainClient(String host, int port){
        this.channel = ManagedChannelBuilder.forAddress(host, port)
                .usePlaintext()
                .build();

        // Initialize stubs for each gRPC service
        this.sentimentAsyncStub = SentimentServiceGrpc.newStub(channel);
        this.sentimentBlockingStub = SentimentServiceGrpc.newBlockingStub(channel);
        this.motivationalStub = MotivationalMessagesGrpc.newStub(channel);
        this.userLoginStub = UserServiceGrpc.newBlockingStub(channel);
    }

    // Shutdown the channel
    public void shutdown(){
        channel.shutdown();
    }
}