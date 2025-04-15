package mainServerClientGUI;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import servicesImpl.SentimentServiceImpl;
import servicesImpl.MotivationalServiceImpl;
import servicesImpl.UserServiceImpl;
import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;
import java.io.IOException;
import java.net.InetAddress;

/*
 * @author Nilson Francisco
 */

// Main gRPC server class that starts the servuces and register them for self discover using jmDNS
public class MainServer{
    public static void main(String[] args) {
        int port = 30031;

        try{
            // Start the gRPC server
            Server server = ServerBuilder.forPort(port)
                    .addService(new SentimentServiceImpl())       // Sentiment service
                    .addService(new MotivationalServiceImpl())    // Motivational messages service
                    .addService(new UserServiceImpl())            // User login/registration service
                    .build()
                    .start();

            System.out.println("gRPC Server started on port " + port);

            // Create jmDNS instance 
            JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());

            // Registering a general service for all gRPC endpoints (could be split by name too)
            ServiceInfo grpcServiceInfo = ServiceInfo.create(
                    "_grpc._tcp.local.",        // Service type
                    "HowDoYouFeelAppServices",      // Service name
                    port,                       // Port number
                    "gRPC Services for HowDoYouFeel App"  // Description
            );

            jmdns.registerService(grpcServiceInfo);
            System.out.println("gRPC service registered with JmDNS.");

            // Keep the server running
            server.awaitTermination();
        } 
        catch (IOException e){
            System.err.println("JmDNS registration error: " + e.getMessage());
        } 
        catch (InterruptedException e){
            System.err.println("Server interrupted: " + e.getMessage());
        }
    }
}

