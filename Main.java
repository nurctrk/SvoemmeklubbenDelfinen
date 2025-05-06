public class Main {


    public static void main(String[] args) {
        MedlemsListe medlemsListe = new MedlemsListe();
        Restance restanceSystem = new Restance(medlemsListe);
        restanceSystem.visRestanceListe();
    }
}



