package org.example;

import java.util.Locale;
import java.util.Scanner;

public class App {

    private static int[] places =
            {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23};
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

        Locale.setDefault(new Locale("sv", "SE"));

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
        int sum = 0;

        for (int i = 0; i < hourlyPrice.length; i++) {
            if (hourlyPrice[i] < hourlyPrice[indexMinPrice]) {
                indexMinPrice = i;
            }
            if (hourlyPrice[i] > hourlyPrice[indexMaxPrice]) {
                indexMaxPrice = i;
            }
            sum += hourlyPrice[i];
        }

        double averagePrice = (double) sum / hourlyPrice.length;

        System.out.print("Lägsta pris: " + printHour(indexMinPrice) + ", " + hourlyPrice[indexMinPrice] + " öre/kWh\n");
        System.out.print("Högsta pris: " + printHour(indexMaxPrice) + ", " + hourlyPrice[indexMaxPrice] + " öre/kWh\n");
        System.out.print("Medelpris: " + String.format("%.2f", averagePrice) + " öre/kWh\n");
    }

    // 3
    private static void sortPrices() {
        System.out.println("3. Sortera");

        for (int i = 0; i < places.length; i++) {
            for (int j = 0; j < places.length - 1; j++) {
                if (hourlyPrice[places[j]] < hourlyPrice[places[j + 1]]) {
                    swapPlaces(j, j + 1);
                }
            }
        }

        for (int place : places) {
            System.out.print(printHour(place) + " " + hourlyPrice[place] + " öre\n");
        }
    }

    // 4
    private static void bestLoadTime() {
        System.out.println("4. Bästa Laddningstid (4)");

        double[] averagePrices = new double[24];

        // Calculate average load time prices:
        for (int i = 0; i < hourlyPrice.length; i++) {
            averagePrices[i] = (hourlyPrice[i % 24] + hourlyPrice[(i + 1) % 24] + hourlyPrice[(i + 2) % 24] + hourlyPrice[(i + 3) % 24]) / 4.0;
        }

        //  Find lowest average:
        int minStartHour = 0;
        for (int i = 1; i < averagePrices.length; i++) {
            if (averagePrices[i] < averagePrices[minStartHour]) {
                minStartHour = i;
            }
        }

        String response = """
                Påbörja laddning klockan %d
                Medelpris 4h: %.1f öre/kWh
                """;

        System.out.printf(response, minStartHour, averagePrices[minStartHour]);
    }

    private static void swapPlaces(int a, int b) {
        int temp = places[a];
        places[a] = places[b];
        places[b] = temp;
    }

    private static String printHour(int i) {
        return String.format("%02d-%02d", i, i + 1);
    }
}