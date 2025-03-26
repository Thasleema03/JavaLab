package C02;

import java.util.Scanner;
public class Symmetric {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input: Matrix dimensions
        System.out.print("Enter the number of rows: ");
        int rows = scanner.nextInt();
        System.out.print("Enter the number of columns: ");
        int cols = scanner.nextInt();

        // A symmetric matrix must be square
        if (rows != cols) {
            System.out.println("The matrix is not symmetric (not a square matrix).");
            scanner.close();
            return;
        }

        int[][] matrix = new int[rows][cols];

        // Input: Matrix elements
        System.out.println("Enter the elements of the matrix:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print("Element [" + i + "][" + j + "]: ");
                matrix[i][j] = scanner.nextInt();
            }
        }

        // Display matrix
        System.out.println("\nEntered Matrix:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(matrix[i][j] + "  ");
            }
            System.out.println();
        }

        // Check symmetry
        boolean isSymmetric = true;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < i; j++) {
                if (matrix[i][j] != matrix[j][i]) {
                    isSymmetric = false;
                    break;
                }
            }
            if (!isSymmetric) break;
        }

        // Output result
        System.out.println(isSymmetric ? "The matrix is symmetric." : "The matrix is not symmetric.");

        scanner.close();
    }
}
