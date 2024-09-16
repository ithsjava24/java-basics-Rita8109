package org.example;

import java.util.Scanner;

public class App {

    private static Scanner scanner;

    private static final String MENU = """
            Elpriser
            ========
            1. Inmatning
            2. Min, Max och Medel
            3. Sortera
            4. Bästa Laddningstid (4h)
            e. Avsluta
            """;
    private static int[] hourlyPrice;

    public static void main(String[] args) {

        scanner = new Scanner(System.in);

        // Print Menu by using switch statement
        while (true) {

            System.out.println(MENU);

            String choice = scanner.nextLine().toLowerCase();

            switch (choice) {
                case "1":
                    gatherInput();
                    break;
                case "2":
                    calculate();
                    break;
                case "3":
                    sortPrices();
                    break;
                case "4":
                    bestLoadTime();
                    break;
                case "e":
                    return;
                default:
                    System.out.println("Invalid choice");
            }

        }
    }

    // 1
    private static void gatherInput() {

        System.out.println("1. Inmatning");
        System.out.println("Vänligen fyll i pris per timme");

        hourlyPrice = new int[24];
        for (int i = 0; i < hourlyPrice.length; i++) {
            System.out.print(printHour(i) + ": ");
            hourlyPrice[i] = scanner.nextInt();
        }
    }

    // 2
    private static void calculate() {
        System.out.println("2. Min, Max och Medel");

        int indexMinPrice = 0;
        int indexMaxPrice = 0;

        for (int i = 0; i < hourlyPrice.length; i++) {
            if (hourlyPrice[i] < hourlyPrice[indexMinPrice]) {
                indexMinPrice = i;
            }
            if (hourlyPrice[i] > hourlyPrice[indexMaxPrice]) {
                indexMaxPrice = i;
            }
        }
        System.out.println("Lägsta pris: " + printHour(indexMinPrice) + ", " + hourlyPrice[indexMinPrice] + " öre/kWh");
        System.out.println("Högsta pris: " + printHour(indexMaxPrice) + ", " + hourlyPrice[indexMaxPrice] + " öre/kWh");
        //System.out.println("Medelpris:");
    }

    // 3
    private static void sortPrices() {
        System.out.println("3. Sortera");
    }

    // 4
    private static void bestLoadTime() {
        System.out.println("4. Bästa Laddningstid (4)");

    }

    private static String printHour(int i) {
        return String.format("%02d-%02d", i, i + 1);
    }

}