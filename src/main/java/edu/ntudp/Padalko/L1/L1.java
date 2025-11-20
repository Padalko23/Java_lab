package edu.ntudp.Padalko.L1;

import java.util.Scanner;
import java.util.Random;

public class L1 {
    private static final int MIN_RANDOM_VALUE = -100;
    private static final int MAX_RANDOM_VALUE = 100;
    private static final int MAX_SIZE = 20;

    private static Scanner scanner = new Scanner(System.in);
    private static int[][] matrix;
    private static int rows;
    private static int cols;

    public static void main(String[] args) {
        System.out.println("=== Matrix Operations Program ===\n");

        inputMatrixSizeFromUser();
        int choice = chooseMatrixCreationMethod();

        if (choice == 1) {
            createMatrixByManualInput();
        } else {
            createMatrixWithRandomValues();
        }

        displayMatrixOnScreen();

        // ВИКЛИК НОВОЇ УНІВЕРСАЛЬНОЇ ФУНКЦІЇ
        MatrixStats stats = analyzeMatrix();

        System.out.println("\nMinimum element: " + stats.min);
        System.out.println("Maximum element: " + stats.max);
        System.out.printf("Average: %.2f%n", stats.avg);

        scanner.close();
    }

    // Клас для збереження результатів
    private static class MatrixStats {
        int min;
        int max;
        double avg;

        MatrixStats(int min, int max, double avg) {
            this.min = min;
            this.max = max;
            this.avg = avg;
        }
    }

    // --- НОВА ОБ'ЄДНАНА ФУНКЦІЯ ---
    private static MatrixStats analyzeMatrix() {
        int min = matrix[0][0];
        int max = matrix[0][0];
        int sum = 0;
        int count = 0;

        for (int[] row : matrix) {
            for (int value : row) {
                if (value < min) min = value;
                if (value > max) max = value;
                sum += value;
                count++;
            }
        }

        double avg = (double) sum / count;

        return new MatrixStats(min, max, avg);
    }

    private static void inputMatrixSizeFromUser() {
        do {
            System.out.print("Enter number of rows (1-" + MAX_SIZE + "): ");
            rows = scanner.nextInt();
        } while (rows < 1 || rows > MAX_SIZE);

        do {
            System.out.print("Enter number of columns (1-" + MAX_SIZE + "): ");
            cols = scanner.nextInt();
        } while (cols < 1 || cols > MAX_SIZE);

        matrix = new int[rows][cols];
    }

    private static int chooseMatrixCreationMethod() {
        int choice;
        do {
            System.out.println("\nChoose matrix creation method:");
            System.out.println("1 - Manual input");
            System.out.println("2 - Random generation");
            System.out.print("Your choice: ");
            choice = scanner.nextInt();
        } while (choice < 1 || choice > 2);
        return choice;
    }

    private static void createMatrixByManualInput() {
        System.out.println("\nEnter matrix elements:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print("Element [" + i + "][" + j + "]: ");
                matrix[i][j] = scanner.nextInt();
            }
        }
    }

    private static void createMatrixWithRandomValues() {
        Random random = new Random();
        System.out.println("\nGenerating matrix randomly...");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = random.nextInt(MAX_RANDOM_VALUE - MIN_RANDOM_VALUE + 1) + MIN_RANDOM_VALUE;
            }
        }
    }

    private static void displayMatrixOnScreen() {
        System.out.println("\nMatrix:");
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.printf("%6d ", value);
            }
            System.out.println();
        }
    }
}