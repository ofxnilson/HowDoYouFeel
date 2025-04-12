package servicesImpl;
import generated.grpc.userservice.*;
import generated.grpc.userservice.UserServiceGrpc;
import io.grpc.stub.StreamObserver;
import java.util.HashMap;
import java.util.Random;

/*
 * @author Nilson Francisco
 */

public class UserServiceImpl extends UserServiceGrpc.UserServiceImplBase{
    // Store user data using the generated user_id as the key
    private final HashMap<String, RegisterRequest> userDatabase = new HashMap<>();
    private final HashMap<String, String> userPasswords = new HashMap<>();

    // Generate a random unique user ID with 6 digits
    private String generateUserId(){
        Random rand = new Random();
        String id;
        do{
            id = String.format("%06d", rand.nextInt(1_000_000));
        } 
        while (userDatabase.containsKey(id)); // Check in the DB if the ID is unique
        return id;
    }

    // Validate the password with 8 digits
    private boolean isValidPassword(String password){
        return password != null && password.length() >= 8;
    }

    // Implement register new user
    @Override
    public void registerNewUser(RegisterRequest request, StreamObserver<RegisterResponse> responseObserver){
        RegisterResponse.Builder response = RegisterResponse.newBuilder();
        if (!isValidPassword(request.getPassword())){
            response.setMessage("Password must be at least 8 characters.");
        } 
        else{
            String userId = generateUserId();
            userDatabase.put(userId, request);
            userPasswords.put(userId, request.getPassword());

            response.setUserId(userId).setMessage("You are now successfully registered. Your user ID: " + userId);
        }

        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }

    // Implement of user login
    @Override
    public void loginUser(LoginRequest request, StreamObserver<LoginResponse> responseObserver){
        String userId = request.getUserId();
        String password = request.getPassword();

        LoginResponse.Builder response = LoginResponse.newBuilder();

        // Checks if the user has a valid id/password and return an error if not
        if (userPasswords.containsKey(userId) && userPasswords.get(userId).equals(password)){
            response.setUserId(userId).setMessage("Login successful.");
        } 
        else{
            response.setMessage("Invalid user ID or password.");
        }

        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }
}