package javaBasics;

import java.util.Scanner;

public class Rect_AreaPeri {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Length: ");
        double length = sc.nextDouble();
        System.out.print("Breadth: ");
        double breadth = sc.nextDouble();

        double area = length * breadth;
        double perimeter = 2 * (length + breadth);

        System.out.printf("Area of the rectangle: %.2f\n", area);
        System.out.printf("Perimeter of the rectangle: %.2f\n", perimeter);

        sc.close();
    }
}
