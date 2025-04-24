package C03;

import java.util.Scanner;

// Custom exception class for invalid grade
class InvalidGradeException extends Exception {
    public InvalidGradeException(String message) {
        super(message);
    }
}

// Main class
public class GradeValidator {

    // Method to validate the grade
    public static void validateGrade(char grade) throws InvalidGradeException {
        // Check if the grade is between 'A' and 'F'
        if (grade < 'A' || grade > 'F') {
            throw new InvalidGradeException("Grade must be between A and F.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take grade input from user
        System.out.print("Enter the student's grade: ");
        char grade = scanner.nextLine().toUpperCase().charAt(0);  // Ensure grade is uppercase

        try {
            // Validate the grade
            validateGrade(grade);
            System.out.println("The grade " + grade + " is valid.");
        } catch (InvalidGradeException e) {
            // Handle invalid grade exception
            System.out.println("Error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
