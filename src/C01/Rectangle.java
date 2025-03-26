package C01;

public class Rectangle {
    double length;
    double width;

    // Default constructor (sets length and width to 1)
    public Rectangle() {
        this.length = 1.0;
        this.width = 1.0;
    }

    // Parameterized constructor
    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    // Method to calculate area
    public double calculateArea() {
        return length * width;
    }

    // Method to calculate perimeter
    public double calculatePerimeter() {
        return 2 * (length + width);
    }

    // Method to display rectangle details
    public void display() {
        System.out.printf("Length: %.2f%n", length);
        System.out.printf("Width: %.2f%n", width);
        System.out.printf("Area: %.2f%n", calculateArea());
        System.out.printf("Perimeter: %.2f%n", calculatePerimeter());
        System.out.println("----------------------------");
    }

    // Main method for testing
    public static void main(String[] args) {
        // Creating different rectangles
        Rectangle rect1 = new Rectangle(); // Default rectangle
        Rectangle rect2 = new Rectangle(5.0, 3.5);
        Rectangle rect3 = new Rectangle(10.2, 7.8);

        // Displaying rectangle details
        System.out.println("Default Rectangle:");
        rect1.display();

        System.out.println("Rectangle 1:");
        rect2.display();

        System.out.println("Rectangle 2:");
        rect3.display();
    }
}
