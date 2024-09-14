package org.example;

import java.util.Scanner;

public class App {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        // Print Menu by using switch statement

        System.out.println("Vänligen gör ett val från menyn nedan:");

        System.out.println("Elpriser");
        System.out.println("========");
        System.out.println("1. Inmatning");
        System.out.println("2. Min, Max och Medel");
        System.out.println("3. Sortera");
        System.out.println("4. Bästa Laddningstid (4)");
        System.out.println("e. Avsluta");

        String choice = scanner.nextLine().toLowerCase();

        switch (choice) {
            case "1":
                System.out.println("1. Inmatning");
                break;
            case "2":
                System.out.println("2. Min, Max och Medel");
                break;
            case "3":
                System.out.println("3. Sortera");
            case "4":
                System.out.println("4. Bästa Laddningstid (4)");
                break;
            case "e":
                System.out.println("e. Avsluta");
            default:

        }
        ;

    }
}
