package C02;

import java.util.Scanner;

// Abstract class
abstract class Employee {
    String name;
    int id;

    Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    abstract double calculateSalary();

    void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
    }
}

// Full-time employee class
class FullTimeEmployee extends Employee {
    double monthlySalary;

    FullTimeEmployee(String name, int id, double monthlySalary) {
        super(name, id);
        this.monthlySalary = monthlySalary;
    }

    @Override
    double calculateSalary() {
        return monthlySalary;
    }
}

// Part-time employee class
class PartTimeEmployee extends Employee {
    double hourlyRate;
    int hoursWorked;

    PartTimeEmployee(String name, int id, double hourlyRate, int hoursWorked) {
        super(name, id);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    @Override
    double calculateSalary() {
        return hourlyRate * hoursWorked;
    }
}

// Main class with user input
public class EmployeeTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input for full-time employee
        System.out.println("Enter Full-Time Employee Details:");
        System.out.print("Name: ");
        String ftName = sc.nextLine();
        System.out.print("ID: ");
        int ftId = sc.nextInt();
        System.out.print("Monthly Salary: ");
        double ftSalary = sc.nextDouble();
        sc.nextLine(); // consume newline

        FullTimeEmployee fte = new FullTimeEmployee(ftName, ftId, ftSalary);

        // Input for part-time employee
        System.out.println("\nEnter Part-Time Employee Details:");
        System.out.print("Name: ");
        String ptName = sc.nextLine();
        System.out.print("ID: ");
        int ptId = sc.nextInt();
        System.out.print("Hourly Rate: ");
        double rate = sc.nextDouble();
        System.out.print("Hours Worked: ");
        int hours = sc.nextInt();

        PartTimeEmployee pte = new PartTimeEmployee(ptName, ptId, rate, hours);

        // Display info
        System.out.println("\n--- Full-Time Employee Info ---");
        fte.displayInfo();
        System.out.println("Salary: ₹" + fte.calculateSalary());

        System.out.println("\n--- Part-Time Employee Info ---");
        pte.displayInfo();
        System.out.println("Salary: ₹" + pte.calculateSalary());

        sc.close();
    }
}
