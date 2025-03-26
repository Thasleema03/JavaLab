package C02;

import java.util.Scanner;
public class SumRowCol {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input: Matrix dimensions
        System.out.print("Enter the number of rows: ");
        int row = sc.nextInt();
        System.out.print("Enter the number of columns: ");
        int col = sc.nextInt();

        int[][] arr = new int[row][col];

        // Input: Matrix elements
        System.out.println("Enter the array elements: ");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print("Element [" + i + "][" + j + "]: ");
                arr[i][j] = sc.nextInt();
            }
        }

        // Display matrix
        System.out.println("\nMATRIX:");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(arr[i][j] + "  ");
            }
            System.out.println();
        }
        System.out.println();

        // Calculate and display row sums
        for (int i = 0; i < row; i++) {
            int sum = 0;
            for (int j = 0; j < col; j++) {
                sum += arr[i][j];
            }
            System.out.println("Sum of row " + i + ": " + sum);
        }
        System.out.println();

        // Calculate and display column sums
        for (int j = 0; j < col; j++) {
            int sum = 0;
            for (int i = 0; i < row; i++) {
                sum += arr[i][j];
            }
            System.out.println("Sum of column " + j + ": " + sum);
        }

        sc.close();
    }
}
