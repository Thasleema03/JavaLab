package C03;

import java.util.Scanner;

// Custom exception class
class InvalidPasswordException extends Exception {
    public InvalidPasswordException(String message) {
        super(message);
    }
}

// Main class
public class PasswordValidator {

    // Method to validate password
    public static void validatePassword(String password) throws InvalidPasswordException {
        // Check if password is at least 8 characters long
        if (password.length() < 8) {
            throw new InvalidPasswordException("Password must be at least 8 characters long.");
        }

        // Check if password contains at least one number
        if (!password.matches(".*\\d.*")) {
            throw new InvalidPasswordException("Password must contain at least one numeric digit.");
        }

        // Check if password contains at least one special character from {$#&)
        if (!password.matches(".*[\\$#&)].*")) {
            throw new InvalidPasswordException("Password must contain at least one special character ($, #, &, ).");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take password input from user
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        try {
            // Validate the password
            validatePassword(password);
            System.out.println("Password is valid.");
        } catch (InvalidPasswordException e) {
            // Handle invalid password exception
            System.out.println("Error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
