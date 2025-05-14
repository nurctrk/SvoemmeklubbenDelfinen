import java.util.ArrayList;
import java.util.Comparator;

    public class Traener {
        private MedlemsListe medlemsListe;

        public Traener(MedlemsListe medlemsListe) {
            this.medlemsListe = medlemsListe;
        }

        public void visTop5(String disciplin, String aldersgruppe) {
            ArrayList<Medlemmer> kandidater = medlemsListe.findMedlemmerEfterAlderOgDisciplin(aldersgruppe, disciplin);
            ArrayList<Medlemmer> top5 = new ArrayList<>();
            kandidater.sort(Comparator.comparingDouble(m -> bedsteTid(m, disciplin)));
            System.out.println("Top 5 for disciplin: " + disciplin + ", aldersgruppe: " + aldersgruppe);
            System.out.println("------------------------------------------------------");
            int count = 0;
            for (Medlemmer m : kandidater) {
                double tid = bedsteTid(m, disciplin);
                if (tid < Double.MAX_VALUE) {
                    System.out.printf("%d. %s - Bedste tid: %.2f sek\n", ++count, m.getNavn(), tid);
                    if (count == 5) break;
                }
            }
            if (count == 0) {
                System.out.println("Ingen resultater for denne disciplin og aldersgruppe.");
            }
            System.out.println("------------------------------------------------------");
        }

        private double bedsteTid(Medlemmer medlem, String disciplin) {
            double bedste = Double.MAX_VALUE;
            for (Konkurrenceresultat r : medlem.getKonkurrenceresultat()) {
                if (r.getDisciplin().equalsIgnoreCase(disciplin) && r.getTid() < bedste) {
                    bedste = r.getTid();
                }
            }
            return bedste;
        }
    }

