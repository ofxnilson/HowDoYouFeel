package HowDoYouFeel;

import generated.grpc.userservice.LoginRequest;
import generated.grpc.userservice.LoginResponse;
import generated.grpc.userservice.UserLoginGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import java.util.Scanner;
/*
 * @author Nilson Francisco
 */

public class ClientApp {
    public static void main(String[] args) {
            // Channel to communicate with the server
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8080)
                .usePlaintext()  // Disable SSL for simplicity
                .build();

            // Create a stub for making blocking RPC calls
        UserLoginGrpc.UserLoginBlockingStub stub = UserLoginGrpc.newBlockingStub(channel);

            // Create a Scanner object to read user input
        Scanner scanner = new Scanner(System.in);

        try {
                // Prompt the user for their username and password
            System.out.print("Enter your username (or press Enter to skip): ");
            String username = getInputOrNull(scanner);

            System.out.print("Enter your password (or press Enter to skip): ");
            String password = getInputOrNull(scanner);

                // Login request
            LoginRequest loginRequest = LoginRequest.newBuilder()
                    .setUsername(username != null ? username : "")  // Handle null as empty string
                    .setPassword(password != null ? password : "")  // Handle null as empty string
                    .build();

                // Send the login request to the server and get the response
            LoginResponse loginResponse = stub.loginUser(loginRequest);

                // Print the server's response (success or failure message)
            System.out.println("Login Response: " + loginResponse.getMessage());
        } catch (StatusRuntimeException e) {
                // Handle gRPC errors (e.g., server is not reachable)
            System.err.println("RPC failed: " + e.getStatus());
        } finally {
                // Close the scanner and channel
            scanner.close();
            channel.shutdownNow();
        }
    }

        // Helper method to get input or return null if the input is empty
    private static String getInputOrNull(Scanner scanner) {
        String input = scanner.nextLine();
        return input.isEmpty() ? null : input;  // Return null if the input is empty
    }
}