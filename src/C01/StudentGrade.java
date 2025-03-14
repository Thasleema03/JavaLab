package C01;

import java.util.Scanner; // Import Scanner class for user input

public class StudentGrade {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Prompt the user to enter their mark
        System.out.print("Enter your mark: ");
        float mark = sc.nextFloat();

        char grade;

        // Determine the grade based on the mark
        if (mark >= 90) {
            grade = 'A';
        } else if (mark >= 80) {
            grade = 'B';
        } else if (mark >= 70) {
            grade = 'C';
        } else if (mark >= 60) {
            grade = 'D';
        } else {
            grade = 'F';
        }

        // Display the assigned grade
        System.out.println("Grade: " + grade);

        // Provide feedback based on the grade
        switch (grade) {
            case 'A':
                System.out.println("Excellent work!");
                break;
            case 'B':
                System.out.println("Good job!");
                break;
            case 'C':
                System.out.println("You can do better");
                break;
            case 'D':
                System.out.println("Work harder");
                break;
            case 'F':
                System.out.println("Failed, Try again");
                break;
            default:
                System.out.println("Invalid grade");
        }

        sc.close();
    }
}
