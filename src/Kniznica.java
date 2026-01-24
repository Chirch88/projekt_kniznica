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

        inventar.pridajKnihu(new Kniha("1984", "George Orwell", "Beletria"));
        inventar.pridajKnihu(new Kniha("Zvieracia farma", "George Orwell", "Beletria"));
        inventar.pridajKnihu(new Kniha("Sherlock Holmes", "Arthur Conan Doyle", "Beletria"));
        inventar.pridajKnihu(new Kniha("Dracula", "Bram Stoker", "Beletria"));
        inventar.pridajKnihu(new Kniha("Frankenstein", "Mary Shelley", "Beletria"));
        inventar.pridajKnihu(new Kniha("It", "Stephen King", "Beletria"));
        inventar.pridajKnihu(new Kniha("Mizéria", "Stephen King", "Beletria"));
        inventar.pridajKnihu(new Kniha("Zelená míľa", "Stephen King", "Beletria"));
        inventar.pridajKnihu(new Kniha("Na západe nič nové", "Erich Maria Remarque", "Beletria"));
        inventar.pridajKnihu(new Kniha("Kmotrov", "Mario Puzo", "Beletria"));

        inventar.pridajKnihu(new Kniha("Harry Potter 1", "J. K. Rowling", "Fantasy"));
        inventar.pridajKnihu(new Kniha("Harry Potter 2", "J. K. Rowling", "Fantasy"));
        inventar.pridajKnihu(new Kniha("Harry Potter 3", "J. K. Rowling", "Fantasy"));
        inventar.pridajKnihu(new Kniha("Harry Potter 4", "J. K. Rowling", "Fantasy"));
        inventar.pridajKnihu(new Kniha("Hobit", "J. R. R. Tolkien", "Fantasy"));
        inventar.pridajKnihu(new Kniha("Pán prsteňov", "J. R. R. Tolkien", "Fantasy"));
        inventar.pridajKnihu(new Kniha("Silmarillion", "J. R. R. Tolkien", "Fantasy"));
        inventar.pridajKnihu(new Kniha("Zaklínač", "Andrzej Sapkowski", "Fantasy"));
        inventar.pridajKnihu(new Kniha("Eragon", "Christopher Paolini", "Fantasy"));
        inventar.pridajKnihu(new Kniha("Narnia", "C. S. Lewis", "Fantasy"));

        inventar.pridajKnihu(new Kniha("Robinson Crusoe", "Daniel Defoe", "Dobrodružné"));
        inventar.pridajKnihu(new Kniha("Ostrov pokladov", "R. L. Stevenson", "Dobrodružné"));
        inventar.pridajKnihu(new Kniha("Cesta okolo sveta za 80 dní", "Jules Verne", "Dobrodružné"));
        inventar.pridajKnihu(new Kniha("Dvadsaťtisíc míľ pod morom", "Jules Verne", "Dobrodružné"));
        inventar.pridajKnihu(new Kniha("Tajomný ostrov", "Jules Verne", "Dobrodružné"));
        inventar.pridajKnihu(new Kniha("Volanie divočiny", "Jack London", "Dobrodružné"));
        inventar.pridajKnihu(new Kniha("Biely tesák", "Jack London", "Dobrodružné"));
        inventar.pridajKnihu(new Kniha("Traja mušketieri", "Alexandre Dumas", "Dobrodružné"));

        inventar.pridajKnihu(new Kniha("Malý princ", "Antoine de Saint-Exupéry", "Detské"));
        inventar.pridajKnihu(new Kniha("Matilda", "Roald Dahl", "Detské"));
        inventar.pridajKnihu(new Kniha("Charlie a továreň na čokoládu", "Roald Dahl", "Detské"));
        inventar.pridajKnihu(new Kniha("Denník odvážneho bojka", "Jeff Kinney", "Detské"));
        inventar.pridajKnihu(new Kniha("Momo", "Michael Ende", "Detské"));
        inventar.pridajKnihu(new Kniha("Peter Pan", "J. M. Barrie", "Detské"));

        inventar.pridajKnihu(new Kniha("Programovanie v Jave", "Autor", "Náučné"));
        inventar.pridajKnihu(new Kniha("Databázy", "Autor", "Náučné"));
        inventar.pridajKnihu(new Kniha("Fyzika pre SŠ", "Kolektív autorov", "Náučné"));
        inventar.pridajKnihu(new Kniha("Matematika pre SŠ", "Kolektív autorov", "Náučné"));
        inventar.pridajKnihu(new Kniha("Informatika", "Kolektív autorov", "Náučné"));
        inventar.pridajKnihu(new Kniha("Algoritmy", "Autor", "Náučné"));
    }
}
