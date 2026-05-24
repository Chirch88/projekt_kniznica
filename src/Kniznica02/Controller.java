package Kniznica02;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.net.URL;

public class Controller {

    @FXML
    private TableView<Kniha> kniznicaTable;

    @FXML
    private TableColumn<Kniha, String> colNazov;

    @FXML
    private TableColumn<Kniha, String> colAutor;

    @FXML
    private TableColumn<Kniha, String> colKategoria;

    @FXML
    private TableColumn<Kniha, String> colStav;

    private Inventar inventar;
    private ObservableList<Kniha> data;

    public Controller() {
        inventar = new Inventar();
        nacitajData();
    }

    @FXML
    public void initialize() {
        colNazov.setCellValueFactory(new PropertyValueFactory<>("nazov"));
        colAutor.setCellValueFactory(new PropertyValueFactory<>("autor"));
        colKategoria.setCellValueFactory(new PropertyValueFactory<>("kategoria"));
        colStav.setCellValueFactory(new PropertyValueFactory<>("stav"));

        data = FXCollections.observableArrayList();
        kniznicaTable.setItems(data);

        zobrazVsetky();
    }

    @FXML
    public void pozicatAction() {
        Kniha kniha = kniznicaTable.getSelectionModel().getSelectedItem();

        if (kniha != null) {
            zobrazPozicanieOkno(kniha);
        }
    }

    private void zobrazPozicanieOkno(Kniha kniha) {
        Stage okno = new Stage();
        okno.setTitle("Požičanie knihy");
        okno.initModality(Modality.APPLICATION_MODAL);
        okno.initOwner(kniznicaTable.getScene().getWindow());
        okno.setResizable(false);

        Label nadpis = new Label("Požičanie knihy");
        nadpis.getStyleClass().add("filter-title");

        Label knihaLabel = new Label(kniha.getNazov());
        knihaLabel.getStyleClass().add("filter-label");

        Label dniLabel = new Label("Počet dní:");
        dniLabel.getStyleClass().add("filter-label");

        TextField dniField = new TextField("0");
        dniField.setPrefWidth(260);

        GridPane grid = new GridPane();
        grid.setHgap(12);
        grid.setVgap(12);
        grid.setAlignment(Pos.CENTER);
        grid.add(dniLabel, 0, 0);
        grid.add(dniField, 1, 0);

        Button pozicatButton = vytvorFilterButton("Požičať");
        Button zrusitButton = vytvorFilterButton("Zrušiť");

        pozicatButton.setOnAction(e -> {
            int dni = nacitajCislo(dniField.getText());
            kniha.pozicaj(dni);
            kniznicaTable.refresh();
            okno.close();
        });

        zrusitButton.setOnAction(e -> okno.close());

        VBox root = new VBox(10);
        root.getStyleClass().add("filter-window");
        root.setAlignment(Pos.CENTER);
        root.setPrefWidth(500);
        root.setPrefHeight(300);
        root.getChildren().addAll(
                nadpis,
                knihaLabel,
                grid,
                pozicatButton,
                zrusitButton
        );

        Scene scene = new Scene(root, 500, 300);

        URL css = getClass().getResource("/Kniznica02/style.css");

        if (css != null) {
            scene.getStylesheets().add(css.toExternalForm());
        }

        okno.setScene(scene);
        okno.showAndWait();
    }

    @FXML
    public void vratitAction() {
        Kniha kniha = kniznicaTable.getSelectionModel().getSelectedItem();

        if (kniha != null) {
            kniha.vrat();
            kniznicaTable.refresh();
        }
    }

    @FXML
    public void filtrovatAction() {
        Stage okno = new Stage();
        okno.setTitle("Filtrovanie kníh");
        okno.initModality(Modality.APPLICATION_MODAL);
        okno.initOwner(kniznicaTable.getScene().getWindow());
        okno.setResizable(false);

        Label nadpis = new Label("Filtrovanie kníh");
        nadpis.getStyleClass().add("filter-title");

        TextField limitField = new TextField("0");
        TextField kategoriaField = new TextField();
        TextField autorField = new TextField();

        limitField.setPrefWidth(260);
        kategoriaField.setPrefWidth(260);
        autorField.setPrefWidth(260);

        GridPane grid = new GridPane();
        grid.setHgap(12);
        grid.setVgap(12);
        grid.setAlignment(Pos.CENTER);
        grid.setMaxWidth(420);

        Label limitLabel = new Label("Limit dní:");
        Label kategoriaLabel = new Label("Kategória:");
        Label autorLabel = new Label("Meno autora:");

        limitLabel.getStyleClass().add("filter-label");
        kategoriaLabel.getStyleClass().add("filter-label");
        autorLabel.getStyleClass().add("filter-label");

        grid.add(limitLabel, 0, 0);
        grid.add(limitField, 1, 0);
        grid.add(kategoriaLabel, 0, 1);
        grid.add(kategoriaField, 1, 1);
        grid.add(autorLabel, 0, 2);
        grid.add(autorField, 1, 2);

        Button pozicaneButton = vytvorFilterButton("Vypísať požičané knihy");
        Button poLehoteButton = vytvorFilterButton("Vypísať knihy po lehote");
        Button kategoriaButton = vytvorFilterButton("Vypísať podľa kategórie");
        Button autorButton = vytvorFilterButton("Vypísať podľa mena autora");
        Button navratButton = vytvorFilterButton("Návrat do hlavného menu");

        pozicaneButton.setOnAction(e -> {
            zobrazPozicane();
            okno.close();
        });

        poLehoteButton.setOnAction(e -> {
            int limit = nacitajCislo(limitField.getText());
            zobrazPoLehote(limit);
            okno.close();
        });

        kategoriaButton.setOnAction(e -> {
            zobrazPodlaKategorie(kategoriaField.getText());
            okno.close();
        });

        autorButton.setOnAction(e -> {
            zobrazPodlaAutora(autorField.getText());
            okno.close();
        });

        navratButton.setOnAction(e -> {
            zobrazVsetky();
            okno.close();
        });

        VBox root = new VBox(10);
        root.getStyleClass().add("filter-window");
        root.setAlignment(Pos.CENTER);
        root.setPrefWidth(500);
        root.setPrefHeight(520);
        root.getChildren().addAll(
                nadpis,
                grid,
                pozicaneButton,
                poLehoteButton,
                kategoriaButton,
                autorButton,
                navratButton
        );

        Scene scene = new Scene(root, 500, 520);

        URL css = getClass().getResource("/Kniznica02/style.css");

        if (css != null) {
            scene.getStylesheets().add(css.toExternalForm());
        }

        okno.setScene(scene);
        okno.showAndWait();
    }

    private Button vytvorFilterButton(String text) {
        Button button = new Button(text);
        button.getStyleClass().add("filter-button");
        button.setPrefWidth(420);
        button.setMaxWidth(420);
        button.setMinHeight(42);
        button.setWrapText(true);
        return button;
    }

    @FXML
    public void zavrietAction() {
        Platform.exit();
    }

    private void zobrazVsetky() {
        data.clear();

        for (int i = 0; i < inventar.getPocet(); i++) {
            data.add(inventar.getZoznamKnih()[i]);
        }

        kniznicaTable.refresh();
    }

    private void zobrazPozicane() {
        data.clear();

        for (int i = 0; i < inventar.getPocet(); i++) {
            Kniha kniha = inventar.getZoznamKnih()[i];

            if (kniha.jePozicana()) {
                data.add(kniha);
            }
        }

        kniznicaTable.refresh();
    }

    private void zobrazPoLehote(int limit) {
        data.clear();

        for (int i = 0; i < inventar.getPocet(); i++) {
            Kniha kniha = inventar.getZoznamKnih()[i];

            if (kniha.jePozicana() && kniha.getDniPozicania() > limit) {
                data.add(kniha);
            }
        }

        kniznicaTable.refresh();
    }

    private void zobrazPodlaKategorie(String kategoria) {
        data.clear();

        for (int i = 0; i < inventar.getPocet(); i++) {
            Kniha kniha = inventar.getZoznamKnih()[i];

            if (kniha.getKategoria().equalsIgnoreCase(kategoria)) {
                data.add(kniha);
            }
        }

        kniznicaTable.refresh();
    }

    private void zobrazPodlaAutora(String autor) {
        data.clear();

        for (int i = 0; i < inventar.getPocet(); i++) {
            Kniha kniha = inventar.getZoznamKnih()[i];

            if (kniha.getAutor().toLowerCase().contains(autor.toLowerCase())) {
                data.add(kniha);
            }
        }

        kniznicaTable.refresh();
    }

    private int nacitajCislo(String text) {
        try {
            int cislo = Integer.parseInt(text);

            if (cislo < 0) {
                return 0;
            }

            return cislo;
        } catch (NumberFormatException e) {
            return 0;
        }
    }


    // TODO pridat



    // vyradit

    public void vyraditAction(){
        var vybranaKniha = kniznicaTable.getSelectionModel().getSelectedItem();

        if (vybranaKniha != null) {
            inventar.vymazKnihu(vybranaKniha.getNazov());
            kniznicaTable.getItems().remove(vybranaKniha);
        }
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