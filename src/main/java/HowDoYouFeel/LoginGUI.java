package HowDoYouFeel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import generated.grpc.userservice.*;

/*
 * @author Nilson Franscisco
 */

public class LoginGUI {
    private JFrame frame;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JLabel statusLabel;
    
    private final UserLoginGrpc.UserLoginBlockingStub userStub;

    public LoginGUI() {
        // Create a gRPC channel
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051)
                .usePlaintext()
                .build();
        userStub = UserLoginGrpc.newBlockingStub(channel);

        // Initialize GUI components
        frame = new JFrame("User Login");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(4, 2));

        JLabel usernameLabel = new JLabel("User ID:");
        usernameField = new JTextField();

        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField();

        JButton loginButton = new JButton("Login");
        JButton registerButton = new JButton("Register");

        statusLabel = new JLabel("Enter your credentials");

        // Add action listeners
        loginButton.addActionListener(e -> loginUser());
        registerButton.addActionListener(e -> registerUser());

        // Add components to frame
        frame.add(usernameLabel);
        frame.add(usernameField);
        frame.add(passwordLabel);
        frame.add(passwordField);
        frame.add(loginButton);
        frame.add(registerButton);
        frame.add(statusLabel);

        frame.setVisible(true);
    }

    private void loginUser() {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        LoginRequest request = LoginRequest.newBuilder()
                .setUsername(username)
                .setPassword(password)
                .build();

        LoginResponse response = userStub.loginUser(request);

        if (response.getMessage().equals("Login successful!")) {
            statusLabel.setText("Login successful!");
            JOptionPane.showMessageDialog(frame, "Welcome, " + username + "!");
            frame.dispose(); // Close window
        } else {
            statusLabel.setText("Invalid credentials!");
        }
    }

    private void registerUser() {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        RegisterRequest request = RegisterRequest.newBuilder()
                .setUsername(username)
                .setPassword(password)
                .build();

        RegisterResponse response = userStub.registerNewUser(request);
        statusLabel.setText(response.getMessage());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(LoginGUI::new);
    }
}
