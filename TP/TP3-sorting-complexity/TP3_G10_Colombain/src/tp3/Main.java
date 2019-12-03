package tp3;

import java.util.*;
import java.time.*;

public class Main {
    static int[]tableau = new int[Integer.MAX_VALUE / 1000];
    static int SIZE = Integer.MAX_VALUE / 1000;

    public static void main(String[] args) {

        initialiserTableau();
        int[] tableauSelection = new int[SIZE];
    }

    public static void initialiserTableau() {
        Instant start = Instant.now();
        System.out.println("Debut d’initialisation...");
        Random random = new Random();
        for (int i = 0; i < tableau.length; i++) {
            tableau[i] = random.nextInt(SIZE);
        }
        Instant end = Instant.now();
        long duration = Duration.between(start, end).toMillis();
        System.out.println("L’initialisation a pris " + duration + " ms");
    }

    public static int[] selectionSort(int[] tableau) {
        Instant start = Instant.now();
        for (int i = 0; i < tableau.length - 1; i++) {
            int minIndex = i;
            for (int j = i; j < tableau.length; j++) {
                if (tableau[j] < tableau[minIndex]) {
                    minIndex = tableau[j];
                }
            }
            int swap = tableau[i];
            tableau[i] = minIndex;
            minIndex = swap;
        }
        Instant end = Instant.now();
        long duration = Duration.between(start, end).toMillis();
        System.out.println("L’initialisation a pris " + duration + " ms");
        return tableau;
    }

    public static int[] insertionSort(int[] tableau) {
        for (int i = 0; i < tableau.length - 1; i++) {
            for (int j = i; j < tableau.length - 1; j++) {
                if (tableau[j] < tableau[i]) {

                }
            }
        }
        return tableau;
    }

    public static int[] bubbleSort(int[] tableau) {

        return tableau;
    }
}
