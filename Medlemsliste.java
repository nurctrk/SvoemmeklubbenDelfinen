import java.util.ArrayList;

class MedlemsListe {
    private ArrayList<Medlemmer> svoemmere;

    public MedlemsListe() {
        this.svoemmere = new ArrayList<>();

        svoemmere.add(new Medlemmer("Mads Jensen", 16, "madsjensen@mail.dk", "123456789", "Crawl", "Junior", "Aktiv"));
        svoemmere.add(new Medlemmer("Emma Sørensen", 17, "emma@mail.dk", "123456780", "Rygcrawl", "Junior", "Aktiv"));
        svoemmere.add(new Medlemmer("Anton Larsen", 18, "anton@mail.dk", "123456781", "Butterfly", "Senior", "Aktiv"));
        svoemmere.add(new Medlemmer("Laura Mikkelsen", 20, "laura@mail.dk", "123456782", "Crawl", "Senior", "Aktiv"));
        svoemmere.add(new Medlemmer("Tobias Andersen", 14, "tobias@mail.dk", "123456783", "Brystsvømning", "Junior", "Aktiv"));
        svoemmere.add(new Medlemmer("Freja Holm", 21, "freja@mail.dk", "123456784", "Butterfly", "Senior", "Aktiv"));
        svoemmere.add(new Medlemmer("Victor Kruse", 12, "victor@mail.dk", "123456785", "Crawl", "Junior", "Aktiv"));
        svoemmere.add(new Medlemmer("Sara Thomsen", 19, "sara@mail.dk", "123456786", "Rygcrawl", "Senior", "Aktiv"));
        svoemmere.add(new Medlemmer("Malthe Ravn", 13, "malthe@mail.dk", "123456787", "Butterfly", "Junior", "Aktiv"));
        svoemmere.add(new Medlemmer("Louise Bækgaard", 17, "louise@mail.dk", "123456788", "Crawl", "Junior", "Aktiv"));
    }

    public ArrayList<Medlemmer> getSvoemmere() {
        return svoemmere;
    }
}
