package C01;

public class Student {
    private final int studentId;
    private final String name;
    private final double marks;

    // Constructor to initialize all fields
    public Student(int studentId, String name, double marks) {
        this.studentId = studentId;
        this.name = name;
        this.marks = marks;
    }

    // Method to display student details
    public void displayDetails() {
        System.out.println("Student ID: " + studentId);
        System.out.println("Name: " + name);
        System.out.println("Marks: " + marks);
        System.out.println("Status: " + (isPassed() ? "Passed" : "Failed"));
        System.out.println("----------------------------");
    }

    // Method to check if student has passed
    public boolean isPassed() {
        return marks >= 40.0;
    }

    // Main method for testing
    public static void main(String[] args) {
        // Creating multiple Student objects
        Student student1 = new Student(101, "Anu", 85.5);
        Student student2 = new Student(102, "Arun", 39.0);
        Student student3 = new Student(103, "Manu", 56.2);
        Student student4 = new Student(104, "Divya", 20.5);

        // Displaying student details and pass status
        student1.displayDetails();
        student2.displayDetails();
        student3.displayDetails();
        student4.displayDetails();
    }
}
