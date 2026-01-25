import java.util.Locale;

public class Inventar {

    private Kniha[] knihy;
    private int pocet;

    public Inventar() {
        knihy = new Kniha[100];
        pocet = 0;
    }

    public void pridajKnihu(Kniha k) {
        knihy[pocet] = k;
        pocet++;
    }

    public void vymazKnihu(String nazov) {
        for (int i = 0; i < pocet; i++) {
            if (knihy[i].getNazov().equalsIgnoreCase(nazov)) {
                for (int j = i; j < pocet - 1; j++) {
                    knihy[j] = knihy[j + 1];
                }
                pocet--;
                System.out.println("Kniha bola vyradená.");
                return;
            }
        }
        System.out.println("Kniha sa nenašla.");
    }

    public void pozicajKnihu(String nazov, int dni) {
        for (int i = 0; i < pocet; i++) {
            if (knihy[i].getNazov().equalsIgnoreCase(nazov)) {
                if (!knihy[i].jePozicana()) {
                    knihy[i].pozicaj(dni);
                    System.out.println("Kniha bola požičaná.");
                } else {
                    System.out.println("Kniha je už požičaná.");
                }
                return;
            }
        }
        System.out.println("Kniha sa nenašla.");
    }

    public void vratKnihu(String nazov) {
        for (int i = 0; i < pocet; i++) {
            if (knihy[i].getNazov().equalsIgnoreCase(nazov)) {
                knihy[i].vrat();
                System.out.println("Kniha bola vrátená.");
                return;
            }
        }
        System.out.println("Kniha sa nenašla.");
    }

    public void vypisVsetky() {
        for (int i = 0; i < pocet; i++) {
            knihy[i].vypis();
        }
    }

    public void vypisPozicane() {
        for (int i = 0; i < pocet; i++) {
            if (knihy[i].jePozicana()) {
                knihy[i].vypis();
            }
        }
    }

    public void vypisPoLehote(int limit) {
        for (int i = 0; i < pocet; i++) {
            if (knihy[i].jePozicana() && knihy[i].getDniPozicania() > limit) {
                knihy[i].vypis();
            }
        }
    }

    public void vypisPodlaKategorie(String kat) {
        for (int i = 0; i < pocet; i++) {
            if (knihy[i].getKategoria().equalsIgnoreCase(kat)) {
                knihy[i].vypis();
            }
        }
    }

    public void vypisPodlaMenaAutora(String meno) {
        for (int i = 0; i < pocet; i++) {
            if (knihy[i].getAutor().toLowerCase().contains(meno.toLowerCase())) {
                knihy[i].vypis();
            }

        }
    }
}
