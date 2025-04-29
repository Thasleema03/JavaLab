package javaBasics;

import java.util.Scanner;

public class NumberPalindrome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int num = scanner.nextInt();

        int originalNumber = num;
        int reversedNumber = 0;

        while (num > 0) {
            int lastDigit = num % 10;
            reversedNumber = reversedNumber * 10 + lastDigit;
            num /= 10;
        }


        if (originalNumber == reversedNumber) {
            System.out.println(originalNumber + " is a palindrome.");
        } else {
            System.out.println(originalNumber + " is not a palindrome.");
        }
    }
}