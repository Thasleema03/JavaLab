package C02;

import java.util.Scanner;
public class StringPalindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input: Read string from user
        System.out.print("Enter a string: ");
        String str = sc.nextLine();

        // Convert the string to lowercase
        String lowerStr = str.toLowerCase();
        String reversed = ""; // Variable to store reversed string

        // Reverse the string
        for (int i = lowerStr.length() - 1; i >= 0; i--) {
            reversed += lowerStr.charAt(i);
        }

        // Check if the original and reversed strings are equal
        if (lowerStr.equals(reversed)) {
            System.out.println(str + " is a Palindrome");
        } else {
            System.out.println(str + " is not a Palindrome");
        }

        sc.close();
    }
}
