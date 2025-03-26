package C02;

import java.util.Scanner;
public class SearchReplace {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input: Original string
        System.out.print("Enter the original string: ");
        String original = sc.nextLine();

        // Input: Pattern to search
        System.out.print("Enter the pattern to search: ");
        String pattern = sc.nextLine();

        // Input: Replacement string
        System.out.print("Enter the replacement string: ");
        String replacement = sc.nextLine();

        // Perform search and replace operation
        String result = original.replace(pattern, replacement);

        //Display modified string
        System.out.println("Modified string: " + result);

        sc.close();
    }
}
