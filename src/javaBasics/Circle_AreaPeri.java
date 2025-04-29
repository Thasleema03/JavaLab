package javaBasics;

import java.util.Scanner;

public class Circle_AreaPeri {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Radius: ");
        double radius = sc.nextDouble();

        double area = Math.PI * Math.pow(radius, 2);
        double perimeter = 2 * Math.PI * radius;

        System.out.printf("Area of the circle: %.2f\n", area);
        System.out.printf("Perimeter of the circle: %.2f\n", perimeter);

        sc.close();
    }
}
