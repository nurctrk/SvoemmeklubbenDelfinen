import java.util.ArrayList;

public class Restance {

    private ArrayList<Medlemmer> MedlemmeriRestance;
    private MedlemsListe medlemsListe;
    private KontingentBeregner KontigentBeregner;

    public Restance(MedlemsListe medlemsListe) {
        this.medlemsListe = medlemsListe;
        this.MedlemmeriRestance = new ArrayList<>();


    }



    public void visRestanceListe() {
        System.out.println("BetalingsOversigt");


        boolean RestanceFundet = false;
        for (Medlemmer Medlem : medlemsListe.getSvoemmere()){
            if (erIRestance(Medlem)){
                RestanceFundet = true;
                double SkyldtBeløb = beregner(Medlem);
                System.out.printf(

                        Medlem.getNavn(),
                        Medlem.getAlder(),
                        Medlem.getMedlemstype(),
                        Medlem.getAktivitet(),
                        SkyldtBeløb);
            }
        }
        if (!RestanceFundet){
            System.out.println("ingen medlemmer i Restence");

        }
    }
    private boolean erIRestance(Medlemmer medlem) {
        return medlemsListe.getSvoemmere().indexOf(medlem) % 2 == 0;

    }

}









