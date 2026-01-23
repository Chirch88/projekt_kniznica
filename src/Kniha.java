public class Kniha {

    private String nazov;
    private String autor;
    private String kategoria;
    private boolean pozicana;
    private int dniPozicania;

    public Kniha(String nazov, String autor, String kategoria) {
        this.nazov = nazov;
        this.autor = autor;
        this.kategoria = kategoria;
        this.pozicana = false;
        this.dniPozicania = 0;
    }

    public String getNazov() {
        return nazov;
    }

    public String getAutor() {
        return autor;
    }

    public String getKategoria() {
        return kategoria;
    }

    public boolean jePozicana() {
        return pozicana;
    }

    public int getDniPozicania() {
        return dniPozicania;
    }

    public void pozicaj(int dni) {
        pozicana = true;
        dniPozicania = dni;
    }

    public void vrat() {
        pozicana = false;
        dniPozicania = 0;
    }

    public void vypis() {
        System.out.printf("%s | %s | %s | %s\n",
                nazov,
                autor,
                kategoria,
                pozicana ? "požičaná" : "voľná");
    }
}