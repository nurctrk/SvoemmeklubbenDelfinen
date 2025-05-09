import java.util.Scanner;


public class Menu {
    public static void main(String[] args) {


    private MedlemsListe medlemsListe;
    private Restance restanceSystem;
    private KontingentBeregner kontingentBeregner;
    private Traener traener;
    private Scanner scanner;

    public Menu() {
            this.medlemsListe = new MedlemsListe();
            this.restanceSystem = new Restance(medlemsListe);
            this.kontingentBeregner = new KontingentBeregner(medlemsListe);
            this.traener = new Traener(medlemsListe);
            this.scanner = new Scanner(System.in);


    }
}
}
// ... rest of the existing code ...