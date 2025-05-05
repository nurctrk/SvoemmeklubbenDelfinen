public class Medlemmer {
    private String navn;
    private int alder;
    private String email;
    private String telefonnummer;
    private String disciplin;
    private String medlemstype;  // f.eks. Junior / Senior
    private String aktivitet;    // Aktiv / Passiv

    public Medlemmer(String navn, int alder, String email, String telefonnummer,
                  String disciplin, String medlemstype, String aktivitet) {
        this.navn = navn;
        this.alder = alder;
        this.email = email;
        this.telefonnummer = telefonnummer;
        this.disciplin = disciplin;
        this.medlemstype = medlemstype;
        this.aktivitet = aktivitet;
    }

    // Gettere
    public String getNavn() { return navn; }
    public int getAlder() { return alder; }
    public String getEmail() { return email; }
    public String getTelefonnummer() { return telefonnummer; }
    public String getDisciplin() { return disciplin; }
    public String getMedlemstype() { return medlemstype; }
    public String getAktivitet() { return aktivitet; }
}
