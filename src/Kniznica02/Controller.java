package Kniznica02;

import Kniznica02.Inventar;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class Controller {

    @FXML
    private TableView<Kniha> kniznicaTable;
    @FXML
    private TableColumn<Kniha, String> colNazov;
    @FXML
    private TableColumn<Kniha, String> colAutor;
    @FXML
    private TableColumn<Kniha, String> colKategoria;

    private Inventar inventar;

    public Controller() {
        inventar = new Inventar();
        nacitajData();
    }

    @FXML
    public void initialize() {
        colNazov.setCellValueFactory(new PropertyValueFactory<>("nazov"));
        colAutor.setCellValueFactory(new PropertyValueFactory<>("autor"));
        colKategoria.setCellValueFactory(new PropertyValueFactory<>("Kategoria"));

        ObservableList<Kniha> data = FXCollections.observableArrayList(inventar.getZoznamKnih());
        kniznicaTable.setItems(data);
    }

    private void nacitajData() {
        inventar.pridajKnihu(new Kniznica02.Kniha("1984", "George Orwell", "Beletria"));
        inventar.pridajKnihu(new Kniznica02.Kniha("Zvieracia farma", "George Orwell", "Beletria"));
        inventar.pridajKnihu(new Kniznica02.Kniha("Sherlock Holmes", "Arthur Conan Doyle", "Beletria"));
        inventar.pridajKnihu(new Kniznica02.Kniha("Dracula", "Bram Stoker", "Beletria"));
        inventar.pridajKnihu(new Kniznica02.Kniha("Frankenstein", "Mary Shelley", "Beletria"));
        inventar.pridajKnihu(new Kniznica02.Kniha("It", "Stephen King", "Beletria"));
        inventar.pridajKnihu(new Kniznica02.Kniha("Mizéria", "Stephen King", "Beletria"));
        inventar.pridajKnihu(new Kniznica02.Kniha("Zelená míľa", "Stephen King", "Beletria"));
        inventar.pridajKnihu(new Kniznica02.Kniha("Na západe nič nové", "Erich Maria Remarque", "Beletria"));
        inventar.pridajKnihu(new Kniznica02.Kniha("Kmotrov", "Mario Puzo", "Beletria"));

        inventar.pridajKnihu(new Kniznica02.Kniha("Harry Potter 1", "J. K. Rowling", "Fantasy"));
        inventar.pridajKnihu(new Kniznica02.Kniha("Harry Potter 2", "J. K. Rowling", "Fantasy"));
        inventar.pridajKnihu(new Kniznica02.Kniha("Harry Potter 3", "J. K. Rowling", "Fantasy"));
        inventar.pridajKnihu(new Kniznica02.Kniha("Harry Potter 4", "J. K. Rowling", "Fantasy"));
        inventar.pridajKnihu(new Kniznica02.Kniha("Hobit", "J. R. R. Tolkien", "Fantasy"));
        inventar.pridajKnihu(new Kniznica02.Kniha("Pán prsteňov", "J. R. R. Tolkien", "Fantasy"));
        inventar.pridajKnihu(new Kniznica02.Kniha("Silmarillion", "J. R. R. Tolkien", "Fantasy"));
        inventar.pridajKnihu(new Kniznica02.Kniha("Zaklínač", "Andrzej Sapkowski", "Fantasy"));
        inventar.pridajKnihu(new Kniznica02.Kniha("Eragon", "Christopher Paolini", "Fantasy"));
        inventar.pridajKnihu(new Kniznica02.Kniha("Narnia", "C. S. Lewis", "Fantasy"));

        inventar.pridajKnihu(new Kniznica02.Kniha("Robinson Crusoe", "Daniel Defoe", "Dobrodružné"));
        inventar.pridajKnihu(new Kniznica02.Kniha("Ostrov pokladov", "R. L. Stevenson", "Dobrodružné"));
        inventar.pridajKnihu(new Kniznica02.Kniha("Cesta okolo sveta za 80 dní", "Jules Verne", "Dobrodružné"));
        inventar.pridajKnihu(new Kniznica02.Kniha("Dvadsaťtisíc míľ pod morom", "Jules Verne", "Dobrodružné"));
        inventar.pridajKnihu(new Kniznica02.Kniha("Tajomný ostrov", "Jules Verne", "Dobrodružné"));
        inventar.pridajKnihu(new Kniznica02.Kniha("Volanie divočiny", "Jack London", "Dobrodružné"));
        inventar.pridajKnihu(new Kniznica02.Kniha("Biely tesák", "Jack London", "Dobrodružné"));
        inventar.pridajKnihu(new Kniznica02.Kniha("Traja mušketieri", "Alexandre Dumas", "Dobrodružné"));

        inventar.pridajKnihu(new Kniznica02.Kniha("Malý princ", "Antoine de Saint-Exupéry", "Detské"));
        inventar.pridajKnihu(new Kniznica02.Kniha("Matilda", "Roald Dahl", "Detské"));
        inventar.pridajKnihu(new Kniznica02.Kniha("Charlie a továreň na čokoládu", "Roald Dahl", "Detské"));
        inventar.pridajKnihu(new Kniznica02.Kniha("Denník odvážneho bojka", "Jeff Kinney", "Detské"));
        inventar.pridajKnihu(new Kniznica02.Kniha("Momo", "Michael Ende", "Detské"));
        inventar.pridajKnihu(new Kniznica02.Kniha("Peter Pan", "J. M. Barrie", "Detské"));

        inventar.pridajKnihu(new Kniznica02.Kniha("Programovanie v Jave", "Autor", "Náučné"));
        inventar.pridajKnihu(new Kniznica02.Kniha("Databázy", "Autor", "Náučné"));
        inventar.pridajKnihu(new Kniznica02.Kniha("Fyzika pre SŠ", "Kolektív autorov", "Náučné"));
        inventar.pridajKnihu(new Kniznica02.Kniha("Matematika pre SŠ", "Kolektív autorov", "Náučné"));
        inventar.pridajKnihu(new Kniznica02.Kniha("Informatika", "Kolektív autorov", "Náučné"));
        inventar.pridajKnihu(new Kniha("Algoritmy", "Autor", "Náučné"));
    }
    @FXML
    public void zavrietAction() {
        Platform.exit();
    }
}