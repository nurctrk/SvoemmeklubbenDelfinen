import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        try {
            // Opret et nyt Menu objekt
            Menu menu = new Menu();
            menu.start(); // Start the menu system

        } catch (Exception e) {
            // Hvis der opstår en fejl, vis den
            System.out.println("Der opstod en fejl: " + e.getMessage());
            e.printStackTrace();
        }
    }
}