import java.util.Scanner;

public class Kniznica {

    private Inventar inventar;
    private Scanner sc;

    public Kniznica() {
        inventar = new Inventar();
        sc = new Scanner(System.in);
        nacitajData();
    }

    public void spusti() {
        int volba;

        do {
            System.out.println("\n--- KNIŽNICA ---");
            System.out.println("1 - Pridať knihu");
            System.out.println("2 - Vyradiť knihu");
            System.out.println("3 - Požičať knihu");
            System.out.println("4 - Vrátiť knihu");
            System.out.println("5 - Vypísať všetky knihy");
            System.out.println("6 - Vypísať požičané knihy");
            System.out.println("7 - Vypísať knihy po lehote");
            System.out.println("8 - Vypísať podľa kategórie");
            System.out.println("0 - Koniec");

            volba = sc.nextInt();
            sc.nextLine();

            switch (volba) {
                case 1 -> pridajKnihu();
                case 2 -> vyradKnihu();
                case 3 -> pozicajKnihu();
                case 4 -> vratKnihu();
                case 5 -> inventar.vypisVsetky();
                case 6 -> inventar.vypisPozicane();
                case 7 -> vypisPoLehote();
                case 8 -> vypisPodlaKategorie();
            }
        } while (volba != 0);
    }

    private void pridajKnihu() {
        System.out.print("Názov: ");
        String nazov = sc.nextLine();
        System.out.print("Autor: ");
        String autor = sc.nextLine();
        System.out.print("Kategória: ");
        String kategoria = sc.nextLine();

        inventar.pridajKnihu(new Kniha(nazov, autor, kategoria));
    }

    private void vyradKnihu() {
        System.out.print("Zadaj názov knihy: ");
        inventar.vymazKnihu(sc.nextLine());
    }

    private void pozicajKnihu() {
        System.out.print("Názov knihy: ");
        String nazov = sc.nextLine();
        System.out.print("Počet dní: ");
        int dni = sc.nextInt();
        sc.nextLine();

        inventar.pozicajKnihu(nazov, dni);
    }

    private void vratKnihu() {
        System.out.print("Názov knihy: ");
        inventar.vratKnihu(sc.nextLine());
    }

    private void vypisPoLehote() {
        System.out.print("Zadaj počet dní: ");
        int limit = sc.nextInt();
        sc.nextLine();

        inventar.vypisPoLehote(limit);
    }

    private void vypisPodlaKategorie() {
        System.out.print("Zadaj kategóriu: ");
        inventar.vypisPodlaKategorie(sc.nextLine());
    }

    private void nacitajData() {
    }
}
