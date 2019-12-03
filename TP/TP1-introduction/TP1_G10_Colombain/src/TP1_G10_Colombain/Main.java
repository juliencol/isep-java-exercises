package TP1_G10_Colombain;

import java.util.*;

public class Main {
	// return an integer and a float entered by user
	public static void main(String[] args) {
		volume();
	}
	
	public static void sum() {
		// this function returns the sum of 2 integers
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a first integer");
		int number1 = scanner.nextInt();
		System.out.println("Enter a second integer");
		int number2 = scanner.nextInt();
		int result = number1 + number2;
		System.out.println("The sum of " + number1 + " and " + number2 + " is " + result + ".");
	}
	
	public static void division() {
		// this function returns the division of 2 integers
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a first integer");
		int number1 = scanner.nextInt();
		System.out.println("Enter a second integer");
		int number2 = scanner.nextInt();
		int result = number1 / number2;
		System.out.println("The sum of " + number1 + " and " + number2 + " is " + result + ".");
	}
	
	public static void volume() {
		// this function calculates the volume of a pave droit
		Scanner scanner = new Scanner(System.in);
		System.out.println("longueur: ");
		int longueur = scanner.nextInt();
		System.out.println("largeur: ");
		int largeur = scanner.nextInt();
		System.out.println("hauteur: ");
		int hauteur = scanner.nextInt();
		int result = longueur * hauteur * largeur;
		System.out.println(result);
	}
	
}
