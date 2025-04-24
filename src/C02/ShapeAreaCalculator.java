package C02;

import java.util.Scanner;

// Interface
interface Shape {
    void calculateArea();
}

// Triangle class implementing Shape
class Triangle implements Shape {
    double base, height;

    Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    public void calculateArea() {
        double area = 0.5 * base * height;
        System.out.println("Area of Triangle: " + area);
    }
}

// Rectangle class implementing Shape
class Rectangle implements Shape {
    double length, width;

    Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public void calculateArea() {
        double area = length * width;
        System.out.println("Area of Rectangle: " + area);
    }
}

// Main class
public class ShapeAreaCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input for triangle
        System.out.println("Enter base of triangle:");
        double base = sc.nextDouble();
        System.out.println("Enter height of triangle:");
        double height = sc.nextDouble();
        Shape triangle = new Triangle(base, height);

        // Input for rectangle
        System.out.println("Enter length of rectangle:");
        double length = sc.nextDouble();
        System.out.println("Enter width of rectangle:");
        double width = sc.nextDouble();
        Shape rectangle = new Rectangle(length, width);

        // Polymorphism demonstration
        System.out.println("\n--- Calculating Areas ---");
        triangle.calculateArea();
        rectangle.calculateArea();

        sc.close();
    }
}
