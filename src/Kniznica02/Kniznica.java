package Kniznica02;

import Kniznica01.Inventar;
import Kniznica01.Kniha;

import java.util.Scanner;

public class Kniznica {

    private Kniznica01.Inventar inventar;

    public Kniznica() {
        inventar = new Inventar();
        nacitajData();
    }
    private void nacitajData() {

        inventar.pridajKnihu(new Kniznica01.Kniha("1984", "George Orwell", "Beletria"));
        inventar.pridajKnihu(new Kniznica01.Kniha("Zvieracia farma", "George Orwell", "Beletria"));
        inventar.pridajKnihu(new Kniznica01.Kniha("Sherlock Holmes", "Arthur Conan Doyle", "Beletria"));
        inventar.pridajKnihu(new Kniznica01.Kniha("Dracula", "Bram Stoker", "Beletria"));
        inventar.pridajKnihu(new Kniznica01.Kniha("Frankenstein", "Mary Shelley", "Beletria"));
        inventar.pridajKnihu(new Kniznica01.Kniha("It", "Stephen King", "Beletria"));
        inventar.pridajKnihu(new Kniznica01.Kniha("Mizéria", "Stephen King", "Beletria"));
        inventar.pridajKnihu(new Kniznica01.Kniha("Zelená míľa", "Stephen King", "Beletria"));
        inventar.pridajKnihu(new Kniznica01.Kniha("Na západe nič nové", "Erich Maria Remarque", "Beletria"));
        inventar.pridajKnihu(new Kniznica01.Kniha("Kmotrov", "Mario Puzo", "Beletria"));

        inventar.pridajKnihu(new Kniznica01.Kniha("Harry Potter 1", "J. K. Rowling", "Fantasy"));
        inventar.pridajKnihu(new Kniznica01.Kniha("Harry Potter 2", "J. K. Rowling", "Fantasy"));
        inventar.pridajKnihu(new Kniznica01.Kniha("Harry Potter 3", "J. K. Rowling", "Fantasy"));
        inventar.pridajKnihu(new Kniznica01.Kniha("Harry Potter 4", "J. K. Rowling", "Fantasy"));
        inventar.pridajKnihu(new Kniznica01.Kniha("Hobit", "J. R. R. Tolkien", "Fantasy"));
        inventar.pridajKnihu(new Kniznica01.Kniha("Pán prsteňov", "J. R. R. Tolkien", "Fantasy"));
        inventar.pridajKnihu(new Kniznica01.Kniha("Silmarillion", "J. R. R. Tolkien", "Fantasy"));
        inventar.pridajKnihu(new Kniznica01.Kniha("Zaklínač", "Andrzej Sapkowski", "Fantasy"));
        inventar.pridajKnihu(new Kniznica01.Kniha("Eragon", "Christopher Paolini", "Fantasy"));
        inventar.pridajKnihu(new Kniznica01.Kniha("Narnia", "C. S. Lewis", "Fantasy"));

        inventar.pridajKnihu(new Kniznica01.Kniha("Robinson Crusoe", "Daniel Defoe", "Dobrodružné"));
        inventar.pridajKnihu(new Kniznica01.Kniha("Ostrov pokladov", "R. L. Stevenson", "Dobrodružné"));
        inventar.pridajKnihu(new Kniznica01.Kniha("Cesta okolo sveta za 80 dní", "Jules Verne", "Dobrodružné"));
        inventar.pridajKnihu(new Kniznica01.Kniha("Dvadsaťtisíc míľ pod morom", "Jules Verne", "Dobrodružné"));
        inventar.pridajKnihu(new Kniznica01.Kniha("Tajomný ostrov", "Jules Verne", "Dobrodružné"));
        inventar.pridajKnihu(new Kniznica01.Kniha("Volanie divočiny", "Jack London", "Dobrodružné"));
        inventar.pridajKnihu(new Kniznica01.Kniha("Biely tesák", "Jack London", "Dobrodružné"));
        inventar.pridajKnihu(new Kniznica01.Kniha("Traja mušketieri", "Alexandre Dumas", "Dobrodružné"));

        inventar.pridajKnihu(new Kniznica01.Kniha("Malý princ", "Antoine de Saint-Exupéry", "Detské"));
        inventar.pridajKnihu(new Kniznica01.Kniha("Matilda", "Roald Dahl", "Detské"));
        inventar.pridajKnihu(new Kniznica01.Kniha("Charlie a továreň na čokoládu", "Roald Dahl", "Detské"));
        inventar.pridajKnihu(new Kniznica01.Kniha("Denník odvážneho bojka", "Jeff Kinney", "Detské"));
        inventar.pridajKnihu(new Kniznica01.Kniha("Momo", "Michael Ende", "Detské"));
        inventar.pridajKnihu(new Kniznica01.Kniha("Peter Pan", "J. M. Barrie", "Detské"));

        inventar.pridajKnihu(new Kniznica01.Kniha("Programovanie v Jave", "Autor", "Náučné"));
        inventar.pridajKnihu(new Kniznica01.Kniha("Databázy", "Autor", "Náučné"));
        inventar.pridajKnihu(new Kniznica01.Kniha("Fyzika pre SŠ", "Kolektív autorov", "Náučné"));
        inventar.pridajKnihu(new Kniznica01.Kniha("Matematika pre SŠ", "Kolektív autorov", "Náučné"));
        inventar.pridajKnihu(new Kniznica01.Kniha("Informatika", "Kolektív autorov", "Náučné"));
        inventar.pridajKnihu(new Kniha("Algoritmy", "Autor", "Náučné"));
    }
}
