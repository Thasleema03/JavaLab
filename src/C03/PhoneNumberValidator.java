package C03;

import java.util.Scanner;

// Custom exception class for invalid phone number
class InvalidPhoneNumberException extends Exception {
    public InvalidPhoneNumberException(String message) {
        super(message);
    }
}

// Main class
public class PhoneNumberValidator {

    // Method to validate phone number
    public static void validatePhoneNumber(String phoneNumber) throws InvalidPhoneNumberException {
        // Check if the phone number has exactly 10 digits
        if (!phoneNumber.matches("\\d{10}")) {
            throw new InvalidPhoneNumberException("Phone number must have exactly 10 digits.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take phone number input from user
        System.out.print("Enter your phone number: ");
        String phoneNumber = scanner.nextLine();

        try {
            // Validate the phone number
            validatePhoneNumber(phoneNumber);
            System.out.println("Phone number is valid.");
        } catch (InvalidPhoneNumberException e) {
            // Handle invalid phone number exception
            System.out.println("Error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
