package servicesImpl;
import generated.grpc.userservice.*;
import generated.grpc.userservice.UserServiceGrpc;
import io.grpc.stub.StreamObserver;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Random;

/*
 * @author Nilson Francisco
 */

public class UserServiceImpl extends UserServiceGrpc.UserServiceImplBase{
    // Create a userId with 6 digits ans checks in the .csv file if the user is unique
    private int generateUserId(){
        Random rand = new Random();
        int id;
        File file = new File("data/users.csv");

        while (true){
            id = rand.nextInt(1_000_000);
            boolean exists = false;

            try (BufferedReader reader = new BufferedReader(new FileReader(file))){
                reader.readLine(); 
                String line;
                while ((line = reader.readLine()) != null){
                    String[] parts = line.split(",", -1);
                    if (parts.length >= 1) {
                        int fileUserId = Integer.parseInt(parts[0].replace("\"", "").trim());
                        if (fileUserId == id){
                            exists = true;
                            break;
                        }
                    }
                }
            } 
            catch (IOException | NumberFormatException e){
            }
            if (!exists) break;
        }
        return id;
    }

    // Method to validate the password to have at least 8 digits
    private boolean isValidPassword(String password){
        return password != null && password.length() >= 8;
    }
    
    // Method to validate de date of birth to accept the pattern dd/MM/yyyy
    private boolean isValidDate(String dateOfBirth){
        if (dateOfBirth == null || dateOfBirth.trim().isEmpty()) return false;

        String noSpaces = dateOfBirth.replaceAll("\\s+", "");
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        try{
            LocalDate.parse(noSpaces, dateFormat);
            return true;
        } 
        catch (DateTimeParseException e){
            return false;
        }
    }
    
    // Implement register new user
    @Override
    public void registerNewUser(RegisterRequest request, StreamObserver<RegisterResponse> responseObserver){
        RegisterResponse.Builder response = RegisterResponse.newBuilder();

        if (!isValidPassword(request.getPassword())){
            response.setMessage("Password must be at least 8 characters.").setSuccess(false);
            responseObserver.onNext(response.build());
            responseObserver.onCompleted();
            return;
        }

        if (!isValidDate(request.getDateOfBirth())) {
            response.setMessage("Please enter the date in the format dd/MM/yyyy").setSuccess(false);
            responseObserver.onNext(response.build());
            responseObserver.onCompleted();
            return;
        }

        File file = new File("data/users.csv");

        synchronized (UserServiceImpl.class){
            try {
                // Create file with header if it doesn't exist
                if (!file.exists()){
                    file.getParentFile().mkdirs();
                    try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                        writer.write("userId,user_name,password,date_of_birth,therapist_name");
                        writer.newLine();
                    }
                }

                // Check if user already exists based on name and dat of birth
                try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                    String line;
                    reader.readLine(); // skip header
                    while ((line = reader.readLine()) != null) {
                        String[] parts = line.split(",", -1);
                        if (parts.length >= 4){
                            String existingName = parts[1].replace("\"", "").trim();
                            String existingDob = parts[3].replace("\"", "").trim();

                            if (existingName.equalsIgnoreCase(request.getUserName().trim()) &&
                                existingDob.equals(request.getDateOfBirth().trim())) {
                                response.setMessage("User already exists with this name and date of birth.").setSuccess(false);
                                responseObserver.onNext(response.build());
                                responseObserver.onCompleted();
                                return;
                            }
                        }
                    }
                }

                // Generate a unique user ID
                int userId = generateUserId();

                // Append new user
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))){
                    String line = String.format("%d,%s,%s,%s,%s", userId, request.getUserName(), request.getPassword(), request.getDateOfBirth(), request.getTherapistName());
                    writer.write(line);
                    writer.newLine();
                }
                response.setUserId(userId)
                        .setSuccess(true)
                        .setMessage("You are now successfully registered. Your user ID is: " + userId);
            } 
            catch (IOException e){
                response.setMessage("Failed to save user data: " + e.getMessage()).setSuccess(false);
            }
        }
        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }

    // Implement of user login
    public void loginUser(LoginRequest request, StreamObserver<LoginResponse> responseObserver) {
        int userId = request.getUserId();
        String password = request.getPassword();
        boolean success = false;
        String message = "Invalid user ID or password.";
        File file = new File("data/users.csv");

        if (!file.exists()){
            message = "User data file not found.";
        } 
        else{
            try (BufferedReader reader = new BufferedReader(new FileReader(file))){
                String line = reader.readLine(); // skip header
                if (line == null) {
                    message = "CSV file is empty.";
                } 
                else{
                    while ((line = reader.readLine()) != null){
                        String[] parts = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
                        if (parts.length >= 3) {
                            try{
                                int fileUserId = Integer.parseInt(parts[0].replace("\"", "").trim());
                                String filePassword = parts[2].replace("\"", "").trim();
                                if (fileUserId == userId && filePassword.equals(password)){
                                    success = true;
                                    message = "Login successful.";
                                    break;
                                }
                            } 
                            catch (NumberFormatException e){
                            }
                        }
                    }
                }
            } 
            catch (IOException e){
                message = "Error reading user data: " + e.getMessage();
            }
        }

        LoginResponse response = LoginResponse.newBuilder().setUserId(userId).setSuccess(success).setMessage(message).build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}