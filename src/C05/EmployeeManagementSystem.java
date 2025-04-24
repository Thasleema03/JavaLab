package C05;

import java.sql.*;
import java.util.Scanner;
import java.util.regex.Pattern;

public class EmployeeManagementSystem {
    static final String DB_URL = "jdbc:mysql://localhost:3306/";
    static final String DB_NAME = "employees";
    static final String USER = "root";
    static final String PASS = "";

    static Connection conn;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            // Step 1: Connect to MySQL server
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();

            // Step 2: Create DB and Table if not exists
            stmt.executeUpdate("CREATE DATABASE IF NOT EXISTS " + DB_NAME);
            stmt.execute("USE " + DB_NAME);
            String tableSQL = "CREATE TABLE IF NOT EXISTS employees (" +
                    "id INT PRIMARY KEY AUTO_INCREMENT," +
                    "name VARCHAR(100)," +
                    "email VARCHAR(100)," +
                    "salary DOUBLE)";
            stmt.executeUpdate(tableSQL);

            System.out.println("===== Employee Management System =====");

            int choice;
            do {
                System.out.println("\n1. Add Employee");
                System.out.println("2. View All Employees");
                System.out.println("3. Update Employee by ID");
                System.out.println("4. Delete Employee by ID");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");
                choice = sc.nextInt();
                sc.nextLine(); // clear buffer

                switch (choice) {
                    case 1:
                        addEmployee();
                        break;
                    case 2:
                        viewEmployees();
                        break;
                    case 3:
                        updateEmployee();
                        break;
                    case 4:
                        deleteEmployee();
                        break;
                    case 5:
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid choice!");
                }
            } while (choice != 5);

            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static void addEmployee() {
        try {
            System.out.print("Enter name: ");
            String name = sc.nextLine();

            String email;
            while (true) {
                System.out.print("Enter email: ");
                email = sc.nextLine();
                if (isValidEmail(email)) break;
                else System.out.println("Invalid email format. Try again.");
            }

            System.out.print("Enter salary: ");
            double salary = sc.nextDouble();

            String sql = "INSERT INTO employees (name, email, salary) VALUES (?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setDouble(3, salary);
            ps.executeUpdate();
            System.out.println("Employee added successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static void viewEmployees() {
        try {
            String sql = "SELECT * FROM employees";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            System.out.printf("\n%-5s %-20s %-30s %-10s\n", "ID", "Name", "Email", "Salary");
            System.out.println("--------------------------------------------------------------");

            while (rs.next()) {
                System.out.printf("%-5d %-20s %-30s %-10.2f\n",
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getDouble("salary"));
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static void updateEmployee() {
        try {
            System.out.print("Enter employee ID to update: ");
            int id = sc.nextInt();
            sc.nextLine(); // clear buffer

            System.out.print("Enter new name: ");
            String name = sc.nextLine();

            String email;
            while (true) {
                System.out.print("Enter new email: ");
                email = sc.nextLine();
                if (isValidEmail(email)) break;
                else System.out.println("Invalid email format. Try again.");
            }

            System.out.print("Enter new salary: ");
            double salary = sc.nextDouble();

            String sql = "UPDATE employees SET name=?, email=?, salary=? WHERE id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setDouble(3, salary);
            ps.setInt(4, id);

            int rows = ps.executeUpdate();
            if (rows > 0)
                System.out.println("Employee updated successfully.");
            else
                System.out.println("Employee ID not found.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static void deleteEmployee() {
        try {
            System.out.print("Enter employee ID to delete: ");
            int id = sc.nextInt();

            String sql = "DELETE FROM employees WHERE id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            int rows = ps.executeUpdate();
            if (rows > 0)
                System.out.println("Employee deleted successfully.");
            else
                System.out.println("Employee ID not found.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static boolean isValidEmail(String email) {
        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        return Pattern.matches(regex, email);
    }
}

