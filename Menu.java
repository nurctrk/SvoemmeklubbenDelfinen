import java.util.Scanner;
import java.util.HashMap;

public class Menu {
    HashMap<String, String> adgangskoder = new HashMap<>();

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            adgangskode.put("Formand", "Formand123");
            adgangskode.put("Kasser", "Kasser456");
            adgangskode.put("Træner", "Træner789");

            boolean kørMenu = true;

            while(kørMenu) {
                System.out.println("\nVelkommen til Svømmeklubben:");
                System.out.println("Log ind som:");
                System.out.println("1. Formand");
                System.out.println("2. Kasserer");
                System.out.println("3. Træner");
                System.out.println("4. Skift adgangskode");
                System.out.println("5. Afslut");

                int valg = scanner.nextInt();
                scanner.nextLine();

                switch (valg) {
                    case 1:
                        formandsMenu(scanner);
                        break;

                    case 2:
                        kassererMenu(scanner);
                        break;

                    case 3:
                        traenerMenu(scanner);
                        break;

                    case 4:
                        adgangskodeMenu(scanner);
                        break;
                        
                    case 5:
                        System.out.println("Programmet afsluttes...");
                        kørMenu = false;
                        break;

                    default:
                        System.out.println("Ugyldigt valg, prøv igen :D");
                }
            }
        scanner.close();
        }

    private static void adgangskodeMenu(Scanner scanner) {
    }

    public static void traenerMenu(Scanner scanner) {
            System.out.println("\n FORMAND");
            System.out.println("1. Registrere nye medlemmer");
            System.out.println("2. ");
    }
    

    private static void kassererMenu(Scanner scanner) {
    }

    public static void formandsMenu(Scanner scanner) {}
}
