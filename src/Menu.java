import java.util.*;

public class Menu {
    private Scanner scanner = new Scanner(System.in);
    private MedlemsListe medlemsListe = new MedlemsListe();
    private KontingentBeregner kontingentBeregner = new KontingentBeregner(medlemsListe);
    private Traener traener = new Traener(medlemsListe);
    private Restance restance = new Restance(medlemsListe);

    public static void main(String[] args) {
        new Menu().start();
    }

    public void start() {
        boolean kørMenu = true;

        while (kørMenu) {
            System.out.println("\n--- HOVEDMENU ---");
            System.out.println("1. Formandsfunktioner");
            System.out.println("2. Kassererfunktioner");
            System.out.println("3. Trænerfunktioner");
            System.out.println("4. Afslut");
            System.out.print("Vælg en funktion: ");

            int valg = scanner.nextInt();
            scanner.nextLine();

            switch (valg) {
                case 1 -> formandsMenu();
                case 2 -> kassererMenu();
                case 3 -> traenerMenu();
                case 4 -> {
                    System.out.println("Programmet afsluttes...");
                    kørMenu = false;
                }
                default -> System.out.println("Ugyldigt valg!");
            }
        }
    }

    private void formandsMenu() {
        boolean tilbage = false;
        while (!tilbage) {
            System.out.println("\n-- FORMAND --");
            System.out.println("1. Registrer nyt medlem");
            System.out.println("2. Se medlemsliste");
            System.out.println("3. Ændre medlemsoplysninger");
            System.out.println("4. Slet medlem");
            System.out.println("5. Tilbage");
            System.out.print("Vælg: ");

            int valg = scanner.nextInt();
            scanner.nextLine();

            switch (valg) {
                case 1 -> registrerNytMedlem();
                case 2 -> medlemsListe.udskrivAlleMedlemmer();
                case 3 -> ændreMedlemsoplysninger();
                case 4 -> sletMedlem();
                case 5 -> tilbage = true;
                default -> System.out.println("Ugyldigt valg!");
            }
        }
    }

    private void kassererMenu() {
        boolean tilbage = false;
        while (!tilbage) {
            System.out.println("\n-- KASSERER --");
            System.out.println("1. Se kontingentoversigt");
            System.out.println("2. Registrer betaling");
            System.out.println("3. Se restanceoversigt");
            System.out.println("4. Vis årsregnskab");
            System.out.println("5. Tilbage");
            System.out.print("Vælg: ");

            int valg = scanner.nextInt();
            scanner.nextLine();

            switch (valg) {
                case 1 -> kontingentBeregner.visKontingentOversigt();
                case 2 -> registrerBetaling();
                case 3 -> restance.visRestanceListe();
                case 4 -> visÅrsregnskab();
                case 5 -> tilbage = true;
                default -> System.out.println("Ugyldigt valg!");
            }
        }
    }

    private void traenerMenu() {
        boolean tilbage = false;
        while (!tilbage) {
            System.out.println("\n-- TRÆNER --");
            System.out.println("1. Registrer træningstid");
            System.out.println("2. Se træningstider");
            System.out.println("3. Tilføj konkurrenceresultat");
            System.out.println("4. Vis Top 5");
            System.out.println("5. Tilbage");
            System.out.print("Vælg: ");

            int valg = scanner.nextInt();
            scanner.nextLine();

            switch (valg) {
                case 1 -> registrerTræningstid();
                case 2 -> visTræningstider();
                case 3 -> tilføjKonkurrenceresultat();
                case 4 -> visTop5();
                case 5 -> tilbage = true;
                default -> System.out.println("Ugyldigt valg!");
            }
        }
    }

    // === FORMAND ===
    private void registrerNytMedlem() {
        System.out.println("\n--- Nyt medlem ---");
        System.out.print("Navn: ");
        String navn = scanner.nextLine();
        System.out.print("Alder: ");
        int alder = scanner.nextInt(); scanner.nextLine();
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

        Medlemmer medlem = new Medlemmer(navn, alder, email, telefonnummer,
                disciplin, medlemstype, aktivitet, restance);
        medlemsListe.getSvoemmere().add(medlem);
        System.out.println("Medlem oprettet!");
    }

    private void ændreMedlemsoplysninger() {
        System.out.print("Navn på medlem: ");
        String navn = scanner.nextLine();
        for (Medlemmer medlem : medlemsListe.getSvoemmere()) {
            if (medlem.getNavn().equalsIgnoreCase(navn)) {
                System.out.print("Ny email (" + medlem.getEmail() + "): ");
                String email = scanner.nextLine();
                if (!email.isEmpty()) medlem.setEmail(email);

                System.out.print("Nyt telefonnummer (" + medlem.getTelefonnummer() + "): ");
                String tlf = scanner.nextLine();
                if (!tlf.isEmpty()) medlem.setTelefonnummer(tlf);

                System.out.println("Medlem opdateret.");
                return;
            }
        }
        System.out.println("Medlem ikke fundet.");
    }

    private void sletMedlem() {
        System.out.print("Navn på medlem der skal slettes: ");
        String navn = scanner.nextLine();
        medlemsListe.getSvoemmere().removeIf(m -> m.getNavn().equalsIgnoreCase(navn));
        System.out.println("Hvis medlem fandtes, er det nu slettet.");
    }

    // === KASSERER ===
    private void registrerBetaling() {
        System.out.print("Navn: ");
        String navn = scanner.nextLine();
        for (Medlemmer medlem : medlemsListe.getSvoemmere()) {
            if (medlem.getNavn().equalsIgnoreCase(navn)) {
                medlem.setRestance("ej i restance");
                System.out.println("Betaling registreret.");
                return;
            }
        }
        System.out.println("Medlem ikke fundet.");
    }

    private void visÅrsregnskab() {
        double total = kontingentBeregner.beregnTotalKontingent();
        System.out.println("Årets kontingentindtægt: " + total + " kr.");
    }

    // === TRÆNER ===
    private void registrerTræningstid() {
        System.out.print("Navn: ");
        String navn = scanner.nextLine();
        for (Medlemmer medlem : medlemsListe.getSvoemmere()) {
            if (medlem.getNavn().equalsIgnoreCase(navn)) {
                System.out.print("Disciplin: ");
                String disciplin = scanner.nextLine();
                System.out.print("Tid (sek): ");
                double tid = scanner.nextDouble(); scanner.nextLine();

                medlem.tilfoejTraeningsResultat(new TræningsResultater(disciplin, tid, new Date()));
                System.out.println("Træningstid registreret.");
                return;
            }
        }
        System.out.println("Medlem ikke fundet.");
    }

    private void visTræningstider() {
        System.out.print("Navn: ");
        String navn = scanner.nextLine();
        for (Medlemmer medlem : medlemsListe.getSvoemmere()) {
            if (medlem.getNavn().equalsIgnoreCase(navn)) {
                System.out.println("Træningstider for " + navn + ":");
                for (TræningsResultater r : medlem.getTraeningsResultater()) {
                    System.out.printf("%s - %.2f sek - %s%n", r.getDisciplin(), r.getTid(), r.getDato());
                }
                return;
            }
        }
        System.out.println("Medlem ikke fundet.");
    }

    private void tilføjKonkurrenceresultat() {
        System.out.print("Navn: ");
        String navn = scanner.nextLine();
        for (Medlemmer medlem : medlemsListe.getSvoemmere()) {
            if (medlem.getNavn().equalsIgnoreCase(navn)) {
                System.out.print("Disciplin: ");
                String disciplin = scanner.nextLine();
                System.out.print("Tid (sek): ");
                double tid = scanner.nextDouble(); scanner.nextLine();

                medlem.tilfoejKonkurrenceresultat(new Konkurrenceresultat(disciplin, tid, new Date()));
                System.out.println("Konkurrenceresultat tilføjet.");
                return;
            }
        }
        System.out.println("Medlem ikke fundet.");
    }

    private void visTop5() {
        System.out.print("Disciplin: ");
        String disciplin = scanner.nextLine();
        System.out.print("Aldersgruppe (Junior/Senior): ");
        String aldersgruppe = scanner.nextLine();
        traener.visTop5(disciplin, aldersgruppe);
    }
}
