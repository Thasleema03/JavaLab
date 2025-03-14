package javaBasics;

import java.util.Scanner;

public class Eligible {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Taking input for marks in Math, Physics, and Chemistry
        System.out.print("Enter Math marks: ");
        int math = sc.nextInt();
        System.out.print("Enter Physics marks: ");
        int physics = sc.nextInt();
        System.out.print("Enter Chemistry marks: ");
        int chemistry = sc.nextInt();
        System.out.println();

        // Calculating total marks of all subjects
        int total = math + physics + chemistry;

        // Calculating total marks of Math and Physics only
        int totalMathPhysics = math + physics;

        // Printing total marks
        System.out.println("Total Marks: " + total);
        System.out.println("Total marks of Math and Physics: "+totalMathPhysics);
        System.out.println();

        // Checking eligibility criteria
        // 1. Math >= 60, Physics >= 50, Chemistry >= 40, and total marks >= 200 OR
        // 2. The sum of Math and Physics marks is at least 150
        if ((math >= 60 && physics >= 50 && chemistry >= 40 && total >= 200) || (totalMathPhysics >= 150)) {
            System.out.println("*** The student is eligible **");
        } else {
            System.out.println("*** The student is not eligible ***");
        }

        sc.close();
    }
}
