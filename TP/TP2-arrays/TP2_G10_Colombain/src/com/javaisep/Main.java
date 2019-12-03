package com.javaisep;

import java.util.*;
import java.lang.Math;

public class Main {

    public static void main(String[] args) {
	// main code here
        initialisationTableau();
    }

    public static void discriminant () {
        // this function calculates the discriminant of second degree polynomial
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter value for a: \n");
        int a = scanner.nextInt();
        System.out.println("Enter value for b: \n");
        int b = scanner.nextInt();
        System.out.println("Enter value for c: \n");
        int c = scanner.nextInt();
        double delta = Math.pow(b, 2) - 4 * a * c;
        if (delta < 0) {
            System.out.println("This polynomial doesn't have solutions.");
        }
        else if (delta == 0) {
            double solution1 = (-b - Math.sqrt(delta)) / 2*a;
            double solution2 = (-b + Math.sqrt(delta)) / 2*a;
            System.out.println("This polynomial has two solutions: " + solution1 + " and " + solution2);
        }
    }

    public static void isEven() {
        // this function tell us if an integer is even
        // returns true if integer is even, false if not
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter an integer: \n");
        int userInteger = scanner.nextInt();
        System.out.println(userInteger % 2 == 0);
    }

    public static void max() {
        // this function returns the maximum of 2 integers
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a first integer: \n");
        int firstInt = scanner.nextInt();
        System.out.println("Enter a second integer: \n");
        int secondInt = scanner.nextInt();
        int max = (firstInt > secondInt) ? firstInt : secondInt;
        System.out.println("The max is " + max + ".");
    }

    public static void strEquality() {
        // this function tells us if 2 strings are equals or not
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a first string: ");
        String firstString = scanner.nextLine();
        System.out.println("Enter a second string: ");
        String secondString = scanner.nextLine();
        if (firstString.length() != secondString.length()) {
            System.out.println("The two strings are not the same!");
        }
        else {
            for (int i = 0; i <  firstString.length();) {
                char[] firstStringArray = firstString.toCharArray();
                char[] secondStringArray = secondString.toCharArray();
                if (firstStringArray[i] == secondStringArray[i]) {
                    System.out.println("The two strings are the same!");
                    break; // breaking my infinite loop
                }
            }
        }
    }

    public static void factorial() {
        // this function calculates the factorial of an integer
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter an integer: \n");
        int number = scanner.nextInt();
        int factorial = 1;
        for (int i = 1; i <= number; i++) {
            factorial *= i;
        }
        System.out.println(number + "! = " + factorial);
    }

    public static void countdown() {
        // this function write down a countdown from 10 to 0 then display BOOM!
        Scanner scanner = new Scanner(System.in);
        int count = 10;
        while (count != 0) {
            System.out.println(count);
            count --;
        }
        System.out.println("BOOM!");
    }

    public static void squares() {
        // this function display a number and its square
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter an integer: ");
        int nb = scanner.nextInt();
        System.out.println("number value: " + nb + " square number value: " + nb * nb);
    }

    public static void multiplicationTable() {
        // this function display the multiplication table of a desired integer
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter an integer: ");
        int nb = scanner.nextInt();
        int[][] numberTable = new int[10][10];
        // numberTable[0] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(numberTable[0]);
        System.out.printf("\n");
        for (int i = 1; i <= 10; i++) {
            System.out.printf("  " + nb * i + "  ");
        }
    }

    public static void division() {
        // this function display the result a 2-integer division
        Scanner scanner = new Scanner(System.in);
        int firstInteger;
        do {
            System.out.println("Enter a first integer: ");
            firstInteger = scanner.nextInt();
        } while (firstInteger < 0);
        int secondInteger;
        do {
            System.out.println("Enter a second integer: ");
            secondInteger = scanner.nextInt();
        } while (secondInteger < 0);
        System.out.println("The result of " + firstInteger + " divided by " + secondInteger + " is: " + firstInteger / secondInteger);
    }

    public static void ruler() {
        // this function display a graduated ruler sized by choice of the user
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the size: ");
        int size = scanner.nextInt();
       for (int i = 0; i < size; i++ ) {
           if (i % 10 == 0) {
               System.out.printf("|");
           }
           System.out.printf("-");
       }
    }

    public static void primeNumber() {
        // this function tells us if an integer is a prime number or not
        Scanner scanner = new Scanner(System.in);
        int userNumber;
        do {
            System.out.println("Enter an integer: ");
            userNumber = scanner.nextInt();
        } while (userNumber < 0);
        if (userNumber == 1) {
            System.out.println("Not a prime number.");
        }
        if (userNumber == 2) {
            System.out.println("Prime number.");
        }
        for (int i = 1; i <= userNumber; i++) {
            if  (i != 1 && i != userNumber && userNumber % i == 0) {
                System.out.println("Not a prime number.");
                break;
            }

            else if ((userNumber % 1 == 0 && userNumber % userNumber == 0 && userNumber % i != 0)) {
                if (userNumber % 5 == 0 && userNumber != 5 ) {
                    System.out.println("Not a prime number");
                    break;
                }
                System.out.println("Prime number.");
                break;
            }
        }
    }

    public static void initialisationTableau() {
        int[] tableau = new int[20];
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < tableau.length; i++) {
            System.out.println("Enter an integer: ");
            int entier = scanner.nextInt();
            tableau[i] = entier;
        }
        for(int i = 0; i < tableau.length; i++) {
            for (int j = 0; j < tableau.length; j++) {
                if (tableau[i] < tableau[j]) {
                    int min = tableau[i];
                }
            }
        }
        System.out.println("Minimum: " + min);
        // System.out.println("Maximum: " + max);
    }
}
