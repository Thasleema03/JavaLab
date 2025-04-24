package C02;

import java.util.Scanner;

// Base class
class Person {
    String name, gender, address;
    int age;

    Person(String name, String gender, String address, int age) {
        this.name = name;
        this.gender = gender;
        this.address = address;
        this.age = age;
    }
}

// Derived class from Person
class Employee extends Person {
    int empId;
    String companyName, qualification;
    double salary;

    Employee(String name, String gender, String address, int age,
             int empId, String companyName, String qualification, double salary) {
        super(name, gender, address, age);
        this.empId = empId;
        this.companyName = companyName;
        this.qualification = qualification;
        this.salary = salary;
    }
}

// Derived class from Employee
class Teacher extends Employee {
    String subject, department;
    int teacherId;

    Teacher(String name, String gender, String address, int age,
            int empId, String companyName, String qualification, double salary,
            String subject, String department, int teacherId) {

        super(name, gender, address, age, empId, companyName, qualification, salary);
        this.subject = subject;
        this.department = department;
        this.teacherId = teacherId;
    }

    void display() {
        System.out.println("\n--- Teacher Details ---");
        System.out.println("Name: " + name);
        System.out.println("Gender: " + gender);
        System.out.println("Address: " + address);
        System.out.println("Age: " + age);
        System.out.println("Emp ID: " + empId);
        System.out.println("Company Name: " + companyName);
        System.out.println("Qualification: " + qualification);
        System.out.println("Salary: ₹" + salary);
        System.out.println("Subject: " + subject);
        System.out.println("Department: " + department);
        System.out.println("Teacher ID: " + teacherId);
    }
}

// Main class
public class TeacherDetails {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of teachers: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        Teacher[] teachers = new Teacher[n];

        // Input teacher details
        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details of Teacher " + (i + 1) + ":");

            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Gender: ");
            String gender = sc.nextLine();

            System.out.print("Address: ");
            String address = sc.nextLine();

            System.out.print("Age: ");
            int age = sc.nextInt();

            System.out.print("Emp ID: ");
            int empId = sc.nextInt();
            sc.nextLine(); // consume newline

            System.out.print("Company Name: ");
            String companyName = sc.nextLine();

            System.out.print("Qualification: ");
            String qualification = sc.nextLine();

            System.out.print("Salary: ");
            double salary = sc.nextDouble();
            sc.nextLine(); // consume newline

            System.out.print("Subject: ");
            String subject = sc.nextLine();

            System.out.print("Department: ");
            String department = sc.nextLine();

            System.out.print("Teacher ID: ");
            int teacherId = sc.nextInt();
            sc.nextLine(); // consume newline

            teachers[i] = new Teacher(name, gender, address, age,
                    empId, companyName, qualification, salary,
                    subject, department, teacherId);
        }

        // Display teacher details
        for (int i = 0; i < n; i++) {
            teachers[i].display();
        }

        sc.close();
    }
}
