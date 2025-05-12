import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Date;

public class Menu {
    private Scanner scanner = new Scanner(System.in);
    private MedlemsListe medlemsListe = new MedlemsListe();
    private KontingentBeregner kontingentBeregner;
    private Traener traener;
    private Restance restance;
    private HashMap<String, String> adgangskoder = new HashMap<>();

    public static void main(String[] args) {
        Menu menu = new Menu();
    }

    public Menu() {
        // Initialize all components
        kontingentBeregner = new KontingentBeregner(medlemsListe);
        traener = new Traener(medlemsListe);
        restance = new Restance(medlemsListe);

        // Initialize passwords
        adgangskoder.put("Formand", "Formand123");
        adgangskoder.put("Kasserer", "Kasser456");
        adgangskoder.put("Træner", "Træner789");
    }

    public void start() {
        boolean kørMenu = true;

        while (kørMenu) {
            System.out.println("\nVelkommen til Svømmeklubben:");
            System.out.println("Log ind som:");
            System.out.println("1. Formand");
            System.out.println("2. Kasserer");
            System.out.println("3. Træner");
            System.out.println("4. Skift adgangskode");
            System.out.println("5. Afslut");

            try {
                int valg = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (valg) {
                    case 1:
                        if (verificerAdgangskode("Formand")) {
                            formandsMenu();
                        }
                        break;
                    case 2:
                        if (verificerAdgangskode("Kasserer")) {
                            kassererMenu();
                        }
                        break;
                    case 3:
                        if (verificerAdgangskode("Træner")) {
                            traenerMenu();
                        }
                        break;
                    case 4:
                        adgangskodeMenu();
                        break;
                    case 5:
                        System.out.println("Programmet afsluttes...");
                        kørMenu = false;
                        break;
                    default:
                        System.out.println("Ugyldigt valg, prøv igen :D");
                }
            } catch (Exception e) {
                System.out.println("Der opstod en fejl: " + e.getMessage());
                scanner.nextLine(); // Clear invalid input
            }
        }
        scanner.close();
    }

    private boolean verificerAdgangskode(String rolle) {
        System.out.print("Indtast adgangskode for " + rolle + ": ");
        String indtastetKode = scanner.nextLine();

        if (adgangskoder.get(rolle).equals(indtastetKode)) {
            return true;
        } else {
            System.out.println("Forkert adgangskode!");
            return false;
        }
    }

    private void adgangskodeMenu() {
        System.out.println("\nSkift adgangskode");
        System.out.println("1. Formand");
        System.out.println("2. Kasserer");
        System.out.println("3. Træner");
        System.out.println("4. Tilbage til hovedmenu");

        int valg = scanner.nextInt();
        scanner.nextLine();

        String rolle = "";
        switch (valg) {
            case 1: rolle = "Formand"; break;
            case 2: rolle = "Kasserer"; break;
            case 3: rolle = "Træner"; break;
            case 4: return;
            default:
                System.out.println("Ugyldigt valg!");
                return;
        }

        if (verificerAdgangskode(rolle)) {
            System.out.print("Indtast ny adgangskode: ");
            String nyKode = scanner.nextLine();
            adgangskoder.put(rolle, nyKode);
            System.out.println("Adgangskode ændret!");
        }
    }

    private void formandsMenu() {
        boolean kørMenu = true;
        while (kørMenu) {
            System.out.println("\nFORMAND MENU");
            System.out.println("1. Registrer nye medlemmer");
            System.out.println("2. Se medlemsliste");
            System.out.println("3. Ændre medlemsoplysninger");
            System.out.println("4. Slet medlem");
            System.out.println("5. Tilbage til hovedmenu");

            int valg = scanner.nextInt();
            scanner.nextLine();

            switch (valg) {
                case 1:
                    registrerNytMedlem();
                    break;
                case 2:
                    medlemsListe.udskrivAlleMedlemmer();
                    break;
                case 3:
                    ændreMedlemsoplysninger();
                    break;
                case 4:
                    sletMedlem();
                    break;
                case 5:
                    kørMenu = false;
                    break;
                default:
                    System.out.println("Ugyldigt valg!");
            }
        }
    }

    private void kassererMenu() {
        boolean kørMenu = true;
        while (kørMenu) {
            System.out.println("\nKASSERER MENU");
            System.out.println("1. Se medlemskontingenter");
            System.out.println("2. Registrer betaling");
            System.out.println("3. Se restanceoversigt");
            System.out.println("4. Se årsregnskab");
            System.out.println("5. Tilbage til hovedmenu");

            int valg = scanner.nextInt();
            scanner.nextLine();

            switch (valg) {
                case 1:
                    kontingentBeregner.visKontingentOversigt();
                    break;
                case 2:
                    registrerBetaling();
                    break;
                case 3:
                    restance.visRestanceListe();
                    break;
                case 4:
                    visÅrsregnskab();
                    break;
                case 5:
                    kørMenu = false;
                    break;
                default:
                    System.out.println("Ugyldigt valg!");
            }
        }
    }

    private void traenerMenu() {
        boolean kørMenu = true;
        while (kørMenu) {
            System.out.println("\nTRÆNER MENU");
            System.out.println("1. Registrer træningstid");
            System.out.println("2. Se medlemmers træningstider");
            System.out.println("3. Tilføj konkurrenceresultater");
            System.out.println("4. Se top 5 svømmere");
            System.out.println("5. Tilbage til hovedmenu");

            int valg = scanner.nextInt();
            scanner.nextLine();

            switch (valg) {
                case 1:
                    registrerTræningstid();
                    break;
                case 2:
                    visTræningstider();
                    break;
                case 3:
                    tilføjKonkurrenceresultat();
                    break;
                case 4:
                    visTop5();
                    break;
                case 5:
                    kørMenu = false;
                    break;
                default:
                    System.out.println("Ugyldigt valg!");
            }
        }
    }

    // Helper methods for formand menu
    private void registrerNytMedlem() {
        System.out.println("\nRegistrer nyt medlem:");
        System.out.print("Navn: ");
        String navn = scanner.nextLine();
        System.out.print("Alder: ");
        int alder = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Telefonnummer: ");
        String telefonnummer = scanner.nextLine();
        System.out.print("Disciplin: ");
        String disciplin = scanner.nextLine();
        System.out.print("Medlemstype (Junior/Senior): ");
        String medlemstype = scanner.nextLine();
        System.out.print("Aktivitet (Aktiv/Passiv): ");
        String aktivitet = scanner.nextLine();
        System.out.print("Restance (er i restance/ej i restance): ");
        String restance = scanner.nextLine();

        Medlemmer nytMedlem = new Medlemmer(navn, alder, email, telefonnummer,
                disciplin, medlemstype, aktivitet, restance);
        medlemsListe.getSvoemmere().add(nytMedlem);
        System.out.println("Nyt medlem registreret!");
    }

    private void ændreMedlemsoplysninger() {
        System.out.print("Indtast medlems navn: ");
        String navn = scanner.nextLine();

        for (Medlemmer medlem : medlemsListe.getSvoemmere()) {
            if (medlem.getNavn().equalsIgnoreCase(navn)) {
                System.out.println("Indtast nye oplysninger (tryk Enter for at beholde eksisterende):");

                System.out.print("Ny email [" + medlem.getEmail() + "]: ");
                String email = scanner.nextLine();
                if (!email.isEmpty()) medlem.setEmail(email);

                System.out.print("Nyt telefonnummer [" + medlem.getTelefonnummer() + "]: ");
                String telefonnummer = scanner.nextLine();
                if (!telefonnummer.isEmpty()) medlem.setTelefonnummer(telefonnummer);

                System.out.println("Medlemsoplysninger opdateret!");
                return;
            }
        }
        System.out.println("Medlem ikke fundet!");
    }

    private void sletMedlem() {
        System.out.print("Indtast medlems navn der skal slettes: ");
        String navn = scanner.nextLine();

        medlemsListe.getSvoemmere().removeIf(medlem ->
                medlem.getNavn().equalsIgnoreCase(navn));
        System.out.println("Medlem slettet!");
    }

    // Helper methods for kasserer menu
    private void registrerBetaling() {
        System.out.print("Indtast medlems navn: ");
        String navn = scanner.nextLine();

        for (Medlemmer medlem : medlemsListe.getSvoemmere()) {
            if (medlem.getNavn().equalsIgnoreCase(navn)) {
                System.out.println("Betaling registreret for " + navn);
                medlem.setRestance("ej i restance");
                return;
            }
        }
        System.out.println("Medlem ikke fundet!");
    }

    private void visÅrsregnskab() {
        System.out.println("\nÅrsregnskab");
        System.out.println("Total kontingentindtægt: " +
                kontingentBeregner.beregnTotalKontingent() + " kr.");
    }

    // Helper methods for træner menu
    private void registrerTræningstid() {
        System.out.print("Indtast medlems navn: ");
        String navn = scanner.nextLine();

        for (Medlemmer medlem : medlemsListe.getSvoemmere()) {
            if (medlem.getNavn().equalsIgnoreCase(navn)) {
                System.out.print("Disciplin: ");
                String disciplin = scanner.nextLine();
                System.out.print("Tid (sekunder): ");
                double tid = scanner.nextDouble();
                scanner.nextLine();

                TræningsResultater resultat = new TræningsResultater(disciplin, tid, new Date());
                medlem.tilfoejTraeningsResultat(resultat);
                System.out.println("Træningstid registreret!");
                return;
            }
        }
        System.out.println("Medlem ikke fundet!");
    }

    private void visTræningstider() {
        System.out.print("Indtast medlems navn: ");
        String navn = scanner.nextLine();

        for (Medlemmer medlem : medlemsListe.getSvoemmere()) {
            if (medlem.getNavn().equalsIgnoreCase(navn)) {
                System.out.println("\nTræningstider for " + navn + ":");
                for (TræningsResultater resultat : medlem.getTraeningsResultater()) {
                    System.out.printf("Disciplin: %s, Tid: %.2f sek, Dato: %s%n",
                            resultat.getDisciplin(), resultat.getTid(), resultat.getDato());
                }
                return;
            }
        }
        System.out.println("Medlem ikke fundet!");
    }

    private void tilføjKonkurrenceresultat() {
        System.out.print("Indtast medlems navn: ");
        String navn = scanner.nextLine();

        for (Medlemmer medlem : medlemsListe.getSvoemmere()) {
            if (medlem.getNavn().equalsIgnoreCase(navn)) {
                System.out.print("Disciplin: ");
                String disciplin = scanner.nextLine();
                System.out.print("Tid (sekunder): ");
                double tid = scanner.nextDouble();
                scanner.nextLine();

                Konkurrenceresultat resultat = new Konkurrenceresultat(disciplin, tid, new Date());
                medlem.tilfoejKonkurrenceresultat(resultat);
                System.out.println("Konkurrenceresultat registreret!");
                return;
            }
        }
        System.out.println("Medlem ikke fundet!");
    }

    private void visTop5() {
        System.out.print("Indtast disciplin: ");
        String disciplin = scanner.nextLine();
        System.out.print("Indtast aldersgruppe (Junior/Senior): ");
        String aldersgruppe = scanner.nextLine();

        traener.visTop5(disciplin, aldersgruppe);
    }
}