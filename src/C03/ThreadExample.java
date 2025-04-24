package C03;

import java.util.Scanner;

// Fibonacci Generator Thread
class FibonacciGenerator extends Thread {
    private int limit;

    // Constructor to set the limit
    public FibonacciGenerator(int limit) {
        this.limit = limit;
    }

    // Method to generate Fibonacci numbers
    public void run() {
        int a = 0, b = 1, next;
        System.out.println("Fibonacci numbers up to " + limit + ":");
        while (a <= limit) {
            System.out.print(a + " ");
            next = a + b;
            a = b;
            b = next;
        }
        System.out.println(); // Newline after printing Fibonacci numbers
    }
}

// Even Number Display Thread
class EvenNumberDisplay extends Thread {
    private int start, end;

    // Constructor to set the range
    public EvenNumberDisplay(int start, int end) {
        this.start = start;
        this.end = end;
    }

    // Method to display even numbers in the given range
    public void run() {
        System.out.println("Even numbers between " + start + " and " + end + ":");
        for (int i = start; i <= end; i++) {
            if (i % 2 == 0) {
                System.out.print(i + " ");
            }
        }
        System.out.println(); // Newline after printing even numbers
    }
}

// Main class to demonstrate threads
public class ThreadExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking user input for Fibonacci limit
        System.out.print("Enter the limit for Fibonacci numbers: ");
        int fibLimit = scanner.nextInt();

        // Taking user input for the range of even numbers
        System.out.print("Enter the start value for even numbers: ");
        int evenStart = scanner.nextInt();
        System.out.print("Enter the end value for even numbers: ");
        int evenEnd = scanner.nextInt();

        // Create threads for FibonacciGenerator and EvenNumberDisplay
        FibonacciGenerator fibThread = new FibonacciGenerator(fibLimit);
        EvenNumberDisplay evenThread = new EvenNumberDisplay(evenStart, evenEnd);

        // Start the threads
        fibThread.start();
        evenThread.start();

        try {
            // Wait for both threads to finish
            fibThread.join();
            evenThread.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted.");
        }

        System.out.println("Both tasks completed.");
        scanner.close();
    }
}
