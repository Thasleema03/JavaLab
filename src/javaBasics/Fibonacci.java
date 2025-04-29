package javaBasics;

import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the limit: ");
        int limit = sc.nextInt();

        int first = 0, second = 1;
        System.out.print(first + " " + second + " ");

        for (int i = 2; i < limit; i++) {
            int nextTerm = first + second;
            first = second;
            second = nextTerm;
            System.out.print(nextTerm + " ");
        }

        sc.close();
    }
}
