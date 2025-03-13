package C01;


import java.util.Scanner; // Import Scanner class for user input

public class Armstrong {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Create Scanner object for input

        // Prompt the user to enter a number
        System.out.print("Enter a number: ");
        int number = sc.nextInt(); // Read the input number

        int originalNumber = number; // Store the original number for later comparison
        int result = 0; // Variable to store the sum of powered digits
        int n = String.valueOf(number).length(); // Determine the number of digits in the number

        // Loop to extract each digit, raise it to the power of 'n', and sum it
        while (number > 0) {
            int digit = number % 10; // Get the last digit
            result += Math.pow(digit, n); // Add digit^n to the result
            number /= 10; // Remove the last digit from the number
        }

        // Check Cycle1.Armstrong or not
        if (result == originalNumber) {
            System.out.println(originalNumber + " is an Armstrong number.");
        } else {
            System.out.println(originalNumber + " is not an Armstrong number.");
        }

        sc.close(); // Close the Scanner
    }
}
