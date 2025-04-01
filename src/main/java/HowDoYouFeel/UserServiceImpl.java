package HowDoYouFeel;
import generated.grpc.userservice.LoginRequest;
import generated.grpc.userservice.LoginResponse;
import generated.grpc.userservice.RegisterRequest;
import generated.grpc.userservice.RegisterResponse;
import io.grpc.stub.StreamObserver;
import generated.grpc.userservice.UserLoginGrpc;

/*
 * @author Nilson Francisco
 */
public class UserServiceImpl extends UserLoginGrpc.UserLoginImplBase {
    @Override
                // Register new user
    public void registerNewUser(RegisterRequest request, StreamObserver<RegisterResponse> responseObserver) {
        String username = request.getUsername();
        String password = request.getPassword();
        String dateOfBirth = request.getDateOfBirth();
        String therapistName = request.getTherapistName();

            // Perform validation logic (e.g., regex for username, password, etc.)
        if (!isValidUsername(username) || !isValidPassword(password)) {
            RegisterResponse response = RegisterResponse.newBuilder()
                    .setMessage("Invalid username or password.")
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
            return;
        }

            // Simulate user registration (generate user ID)
        String userId = generateUserId();

            // Create response
        RegisterResponse response = RegisterResponse.newBuilder()
                .setUserId(userId)
                .setMessage("User registration successful.")
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

            // Login user
    @Override
    public void loginUser(LoginRequest request, StreamObserver<LoginResponse> responseObserver) {
        String username = request.getUsername();
        String password = request.getPassword();

            // Authenticate (you can add a real authentication mechanism here)
        if (authenticateUser(username, password)) {
            String userId = getUserIdByUsername(username);

            LoginResponse response = LoginResponse.newBuilder()
                    .setUserId(userId)
                    .setMessage("Login successful.")
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        } else {
            LoginResponse response = LoginResponse.newBuilder()
                    .setMessage("Invalid credentials.")
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
    }

        // Regex to validate the user name
    private boolean isValidUsername(String username) {
        return username.matches("[a-zA-Z0-9_]+");
    }

        // Password validation: it must have at least 6 digits
    private boolean isValidPassword(String password) {
        return password.length() >= 6;
    }

        // Generate a random 6-digit user ID (for example)
    private String generateUserId() {
        return String.valueOf((int) (Math.random() * 1000));
    }
    
        // Authenticate user
    private boolean authenticateUser(String username, String password) {
        return "testuser".equals(username) && "password123".equals(password);
    }
    
        // Mock to return a user ID for the given username
    private String getUserIdByUsername(String username) {
        return "1234";
    }
}