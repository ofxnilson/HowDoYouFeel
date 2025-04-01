package HowDoYouFeel;

import io.grpc.Server;
import io.grpc.ServerBuilder;
/*
 * @author Nilson Francisco
 */
public class ServerApp {
    public static void main(String[] args) throws Exception {
        Server server = ServerBuilder.forPort(8080)
                .addService(new UserServiceImpl())
                .build();
        
        server.start();
        System.out.println("Server started, listening on 8080");
        server.awaitTermination();
    }
}
