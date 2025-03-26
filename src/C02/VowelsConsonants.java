package C02;
import java.util.Scanner;

public class VowelsConsonants {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Prompt user to enter a string
        System.out.print("Enter a string: ");
        String str = sc.nextLine().toLowerCase();

        // Variables to count vowels and consonants
        int vowels = 0, consonants = 0;
        String vowelsList = "aeiou";

        // Loop through each character in the input string
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);  // Extract character at position i

            // Check if the character is a letter
            if (Character.isLetter(ch)) {
                if (vowelsList.indexOf(ch) != -1)  // Check if the character is a vowel
                    vowels++;
                else
                    consonants++;
            }
        }

        // Display the final count of vowels and consonants
        System.out.println("Vowels: " + vowels);
        System.out.println("Consonants: " + consonants);

        sc.close();  // Close the scanner to prevent resource leaks
    }
}
