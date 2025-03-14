package C01;

import java.util.Scanner;

public class Employee {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Display available job roles
        System.out.println("1. Manager");
        System.out.println("2. Developer");
        System.out.println("3. Intern");

        System.out.print("Choose your job role: ");
        int job = sc.nextInt();

        int currentSalary = 0;

        // Assign salary based on job role selection
        switch (job) {
            case 1:
                currentSalary = 60000; // Salary for Manager
                break;
            case 2:
                currentSalary = 40000; // Salary for Developer
                break;
            case 3:
                currentSalary = 25000; // Salary for Intern
                break;
            default:
                System.out.println("Invalid selection");
                return;
        }

        int bonus = 0;

        //Prompt the user to enter experience
        System.out.print("Enter your experience (in years): ");
        int exp = sc.nextInt();
        System.out.println();

        // Determine bonus percentage based on experience
        if (exp >= 0 && exp <= 2) {
            bonus = 0; // No bonus for 0-2 years of experience
        } else if (exp >= 3 && exp <= 5) {
            bonus = 10; // 10% bonus for 3-5 years of experience
        } else if (exp > 5) {
            bonus = 20; // 20% bonus for more than 5 years of experience
        } else {
            System.out.println("Invalid experience"); // Handle negative experience input
            return;
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
