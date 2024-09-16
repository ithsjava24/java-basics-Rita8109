package org.example;

import java.util.Scanner;

public class App {

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

        Scanner scanner = new Scanner(System.in);

        // Print Menu by using switch statement
        while (true) {

            System.out.println(MENU);

            String choice = scanner.nextLine().toLowerCase();

            switch (choice) {
                case "1":
                    gatherInput();
                    break;
                case "2":
                    analyze();
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

        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Inmatning");
        System.out.println("Vänligen fyll i pris per timme");

        hourlyPrice = new int[24];
        for (int i = 0; i < hourlyPrice.length; i++) {
            System.out.print(String.format("%02d-%02d: ", i, i + 1));
            hourlyPrice[i] = scanner.nextInt();
        }
    }

    // 2
    private static void analyze() {
        System.out.println("2. Min, Max och Medel");

        int indexMinPrice = 0;
        int indexMaxPrice = 0;

        for (int i = 1; i < hourlyPrice.length; i++) {
            if (hourlyPrice[i] < hourlyPrice[indexMinPrice]) {
                indexMinPrice = i;
            }
            if (hourlyPrice[i] > hourlyPrice[indexMaxPrice]) {
                indexMaxPrice = i;
            }
        }
        System.out.println("Lägsta pris: " + hourlyPrice[indexMinPrice] + "öre/kWh");
        System.out.println("Högsta pris: " + hourlyPrice[indexMaxPrice] + "öre/kWh");
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


}