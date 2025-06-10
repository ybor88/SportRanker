package com.sportranker.modali;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.Objects;

public class AddPlayerDialogBasketball extends Stage {

    public AddPlayerDialogBasketball(Stage owner) {
        initOwner(owner);
        initModality(Modality.APPLICATION_MODAL);
        setTitle("Aggiungi Giocatore");

        getIcons().add(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/img/palloneBasket.jpg"))));

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20));
        grid.setVgap(10);
        grid.setHgap(10);
        grid.setAlignment(Pos.CENTER);

        TextField codiceField = new TextField();
        TextField nomeField = new TextField();
        TextField cognomeField = new TextField();

        Spinner<Integer> annoNascitaSpinner = new Spinner<>(1900, 2025, 2000);
        annoNascitaSpinner.setEditable(true);

        ComboBox<String> ruoloCombo = new ComboBox<>();
        ruoloCombo.getItems().addAll("C", "AG", "AP", "G", "PG");

        TextField nazionalitaField = new TextField();

        // Nuovi campi
        TextField partiteGiocateMediaField = new TextField();
        TextField puntiPerGameField = new TextField();

        ComboBox<String> bonusMaxCareerCombo = new ComboBox<>();
        bonusMaxCareerCombo.getItems().addAll("NBA", "EUROLEAGUE", "FIBA NATIONS", "SUMMER LEAGUE NBA");

        // Aggiungo le label e i campi al grid
        grid.add(new Label("Codice:"), 0, 0);
        grid.add(codiceField, 1, 0);

        grid.add(new Label("Nome:"), 0, 1);
        grid.add(nomeField, 1, 1);

        grid.add(new Label("Cognome:"), 0, 2);
        grid.add(cognomeField, 1, 2);

        grid.add(new Label("Anno Nascita:"), 0, 3);
        grid.add(annoNascitaSpinner, 1, 3);

        grid.add(new Label("Ruolo:"), 0, 4);
        grid.add(ruoloCombo, 1, 4);

        grid.add(new Label("Nazionalità:"), 0, 5);
        grid.add(nazionalitaField, 1, 5);

        grid.add(new Label("Partite giocate media:"), 0, 6);
        grid.add(partiteGiocateMediaField, 1, 6);

        grid.add(new Label("Punti per game:"), 0, 7);
        grid.add(puntiPerGameField, 1, 7);

        grid.add(new Label("Bonus Max Career:"), 0, 8);
        grid.add(bonusMaxCareerCombo, 1, 8);

        Button saveButton = createStyledButton("Salva");
        Button cancelButton = createStyledButton("Annulla");

        grid.add(saveButton, 0, 9);
        grid.add(cancelButton, 1, 9);

        saveButton.setOnAction(e -> {
            String codice = codiceField.getText().trim();
            String nome = nomeField.getText().trim();
            String cognome = cognomeField.getText().trim();
            String nazionalita = nazionalitaField.getText().trim();
            String ruolo = ruoloCombo.getValue();
            String bonusMaxCareer = bonusMaxCareerCombo.getValue();

            if (codice.isEmpty() || nome.isEmpty() || cognome.isEmpty() || nazionalita.isEmpty() || ruolo == null || bonusMaxCareer == null) {
                showAlert(Alert.AlertType.ERROR, "Errore", "Compila tutti i campi obbligatori!");
                return;
            }

            int annoNascita = annoNascitaSpinner.getValue();

            // Controllo numerico per partite giocate media
            double partiteGiocateMedia;
            try {
                partiteGiocateMedia = Double.parseDouble(partiteGiocateMediaField.getText().trim());
            } catch (NumberFormatException ex) {
                showAlert(Alert.AlertType.ERROR, "Errore", "Partite giocate media deve essere un numero valido!");
                return;
            }

            // Controllo numerico per punti per game
            double puntiPerGame;
            try {
                puntiPerGame = Double.parseDouble(puntiPerGameField.getText().trim());
            } catch (NumberFormatException ex) {
                showAlert(Alert.AlertType.ERROR, "Errore", "Punti per game deve essere un numero valido!");
                return;
            }

            // TODO: salva su DB
            System.out.println("Salvato: " + codice + " " + nome + " " + cognome + " " + annoNascita + " " + ruolo + " " + nazionalita +
                    " Partite Giocate Media: " + partiteGiocateMedia +
                    " Punti Per Game: " + puntiPerGame +
                    " Bonus Max Career: " + bonusMaxCareer);
            close();
        });

        cancelButton.setOnAction(e -> close());

        Scene scene = new Scene(grid);
        setScene(scene);
    }

    private void showAlert(Alert.AlertType type, String title, String message) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(this);
        alert.showAndWait();
    }

    private Button createStyledButton(String text) {
        Button button = new Button(text);
        button.setStyle(
                "-fx-background-color: #ef6c00;" +
                        "-fx-text-fill: white;" +
                        "-fx-font-size: 16px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-padding: 10 20;" +
                        "-fx-background-radius: 12;" +
                        "-fx-cursor: hand;" +
                        "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.3), 5, 0, 0, 3);"
        );

        button.setOnMouseEntered(e -> button.setStyle(
                "-fx-background-color: #f57c00;" +
                        "-fx-text-fill: white;" +
                        "-fx-font-size: 16px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-padding: 10 20;" +
                        "-fx-background-radius: 12;" +
                        "-fx-cursor: hand;" +
                        "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.4), 7, 0, 0, 4);"
        ));

        button.setOnMouseExited(e -> button.setStyle(
                "-fx-background-color: #ef6c00;" +
                        "-fx-text-fill: white;" +
                        "-fx-font-size: 16px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-padding: 10 20;" +
                        "-fx-background-radius: 12;" +
                        "-fx-cursor: hand;" +
                        "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.3), 5, 0, 0, 3);"
        ));

        return button;
    }
}