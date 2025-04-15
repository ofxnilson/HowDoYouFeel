package mainServerClient;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import servicesImpl.SentimentServiceImpl;
import servicesImpl.MotivationalServiceImpl;
import servicesImpl.UserServiceImpl;

/*
 * @author Nilson Francisco
 */

// Main gRPC server class that starts and run all the services
public class MainServer{
    public static void main(String[] args){
        // Create a server instance and add all the implemented services
        try{
            Server server = ServerBuilder.forPort(50051)
                    .addService(new SentimentServiceImpl())         // Add sentiment analysis and chatbot service
                    .addService(new MotivationalServiceImpl())      // Add motivational messages service
                    .addService(new UserServiceImpl())         // Add user login service
                    .build();

            // Start the server
            server.start();
            System.out.println("gRPC Server started on port 50051...");

            // Keep the server running
            server.awaitTermination();
        } 
        catch (Exception e){
            System.err.println("Error: This port is been used: " + e.getMessage());
        }
    }
}

