package C02;

import java.util.Scanner;
public class StringArraySort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input: Number of strings
        System.out.print("Enter the number of strings: ");
        int n = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        String[] arr = new String[n];

        // Input: Strings from the user
        System.out.println("Enter the strings:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLine();
        }

        // Bubble sort for string array
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    String temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        // Output: Display sorted strings
        System.out.println("Sorted strings:");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }


        sc.close();
    }
}
