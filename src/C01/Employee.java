package C01;

import java.util.Scanner;

public class Employee {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Display available job roles
        System.out.println("1. Manager");
        System.out.println("2. Developer");
        System.out.println("3. Intern");

        System.out.print("Choose your job role (1-3): ");
        int job = sc.nextInt();

        int currentSalary;

        // Assign salary based on job role selection
        switch (job) {
            case 1:
                currentSalary = 50000; // Salary for Manager
                break;
            case 2:
                currentSalary = 30000; // Salary for Developer
                break;
            case 3:
                currentSalary = 15000; // Salary for Intern
                break;
            default:
                System.out.println("Invalid selection");
                return;
        }

        int bonus;

        // Prompt the user to enter experience
        System.out.print("Enter your experience (in years): ");
        int exp = sc.nextInt();
        System.out.println();

        // Determine bonus percentage based on experience
        if (exp < 3) {
            bonus = 0;  // Less than 3 years -> No bonus
        } else if (exp <= 5) {
            bonus = 10; // 3 to 5 years -> 10% bonus
        } else {
            bonus = 20; // More than 5 years -> 20% bonus
        }

        // Calculate final salary after adding the bonus
        int finalSalary = currentSalary + (currentSalary * bonus) / 100;

        // Display salary details
        System.out.println("Current Salary: " + currentSalary);
        System.out.printf("Bonus added: %d%%%n", bonus);
        System.out.println("Final Salary: " + finalSalary);

        sc.close();
    }
}