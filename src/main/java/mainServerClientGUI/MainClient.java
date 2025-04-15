package mainServerClientGUI;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import generated.grpc.sentimentanalysis.SentimentServiceGrpc;
import generated.grpc.sentimentanalysis.SentimentServiceGrpc.SentimentServiceBlockingStub;
import generated.grpc.sentimentanalysis.SentimentServiceGrpc.SentimentServiceStub;
import generated.grpc.motivationalmessages.MotivationalMessagesGrpc;
import generated.grpc.motivationalmessages.MotivationalMessagesGrpc.MotivationalMessagesStub;
import generated.grpc.userservice.UserServiceGrpc;
import generated.grpc.userservice.UserServiceGrpc.UserServiceBlockingStub;
import javax.jmdns.JmDNS;
import javax.jmdns.ServiceEvent;
import javax.jmdns.ServiceInfo;
import javax.jmdns.ServiceListener;
import java.io.IOException;
import java.io.*;
import java.net.InetAddress;

/*
 * @author Nilson Francisco
 * Main gRPC client class that discover ther server via jmDNS and conncts to the services
 */
public class MainClient implements Serializable{
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
        this.channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();
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
    
    // Main method to discover the gRPC server using JmDNS ServiceListener
    public static void main(String[] args){
        final String serviceType = "_grpc._tcp.local.";
        final String serviceName = "HowDoYouFeelAppServices";

        try{
            JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());
            System.out.println("Listening for gRPC services on local network...");

            // Service listener that reacts when the service is discovered
            jmdns.addServiceListener(serviceType, new ServiceListener(){
                @Override
                public void serviceAdded(ServiceEvent event){
                    System.out.println("Service added: " + event.getName());
                    jmdns.requestServiceInfo(event.getType(), event.getName(), true);
                }

                @Override
                public void serviceRemoved(ServiceEvent event){
                    System.out.println("Service removed: " + event.getName());
                }

                @Override
                public void serviceResolved(ServiceEvent event){
                    ServiceInfo info = event.getInfo();
                    System.out.println("Service resolved: " + info.getName());
                    String host = info.getHostAddresses()[0];
                    int port = info.getPort();
                    System.out.println("Connecting to gRPC service at " + host + ":" + port);

                    // Initialize the client when the service is discovered
                    MainClient client = new MainClient(host, port);
                    System.out.println("Connected to gRPC service via JmDNS!");
           
                    client.shutdown();

                    try{
                        jmdns.close();
                    } 
                    catch (IOException e) {
                        System.err.println("Failed to close JmDNS: " + e.getMessage());
                    }
                }
            });

            // Thread to keep the program running until to discover the service
            Thread.sleep(1000); 
        } 
        catch (IOException | InterruptedException e){
            System.err.println("Client discovery error: " + e.getMessage());
        }
    }
}
