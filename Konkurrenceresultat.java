import java.util.Date;

public class Konkurrenceresultat {
    private String disciplin;
    private double tid; // sekunder
    private int placering;
    private String staevne;
    private Date dato;

    public Konkurrenceresultat(String disciplin, double tid, int placering, String staevne, Date dato) {
        this.disciplin = disciplin;
        this.tid = tid;
        this.placering = placering;
        this.staevne = staevne;
        this.dato = dato;
    }

    public String getDisciplin() { return disciplin; }
    public double getTid() { return tid; }
    public int getPlacering() { return placering; }
    public String getStaevne() { return staevne; }
    public Date getDato() { return dato; }
}
