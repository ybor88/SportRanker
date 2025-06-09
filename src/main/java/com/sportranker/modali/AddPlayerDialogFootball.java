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

public class AddPlayerDialogFootball extends Stage {

    public AddPlayerDialogFootball(Stage owner) {
        initOwner(owner);
        initModality(Modality.APPLICATION_MODAL);
        setTitle("Aggiungi Giocatore");

        // Icona nel titolo
        getIcons().add(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/img/logoSportRanker.png"))));

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20));
        grid.setVgap(10);
        grid.setHgap(10);
        grid.setAlignment(Pos.CENTER);

        // Campi
        TextField nomeField = new TextField();
        TextField cognomeField = new TextField();

        Spinner<Integer> annoNascitaSpinner = new Spinner<>(1900, 2025, 2000);
        annoNascitaSpinner.setEditable(true);

        // Stato fisso a "S"
        Label statoLabel = new Label("Stato:");
        TextField statoField = new TextField("S");
        statoField.setEditable(false);

        // Sport fisso "S" (non mostrato)

        ComboBox<String> ruoloCombo = new ComboBox<>();
        // Valori solo per "S"
        ruoloCombo.getItems().addAll("AT", "CE", "DI", "PO");

        TextField ratingField = new TextField();
        TextField nazionalitaField = new TextField();

        // Layout
        grid.add(new Label("Nome:"), 0, 0);
        grid.add(nomeField, 1, 0);

        grid.add(new Label("Cognome:"), 0, 1);
        grid.add(cognomeField, 1, 1);

        grid.add(new Label("Anno Nascita:"), 0, 2);
        grid.add(annoNascitaSpinner, 1, 2);

        grid.add(statoLabel, 0, 3);
        grid.add(statoField, 1, 3);

        grid.add(new Label("Ruolo:"), 0, 4);
        grid.add(ruoloCombo, 1, 4);

        grid.add(new Label("Rating:"), 0, 5);
        grid.add(ratingField, 1, 5);

        grid.add(new Label("Nazionalità:"), 0, 6);
        grid.add(nazionalitaField, 1, 6);

        // Pulsanti con stile identico a FootballView
        Button saveButton = createStyledButton("Salva");
        Button cancelButton = createStyledButton("Annulla");

        grid.add(saveButton, 0, 7);
        grid.add(cancelButton, 1, 7);

        saveButton.setOnAction(e -> {
            // Validazioni base
            String nome = nomeField.getText().trim();
            String cognome = cognomeField.getText().trim();
            String nazionalita = nazionalitaField.getText().trim();
            String stato = statoField.getText();
            String ruolo = ruoloCombo.getValue();

            if (nome.isEmpty() || cognome.isEmpty() || nazionalita.isEmpty() ||
                    stato == null || ruolo == null) {
                showAlert(Alert.AlertType.ERROR, "Errore", "Compila tutti i campi obbligatori!");
                return;
            }

            double rating = 0;
            if (!ratingField.getText().trim().isEmpty()) {
                try {
                    rating = Double.parseDouble(ratingField.getText().trim());
                } catch (NumberFormatException ex) {
                    showAlert(Alert.AlertType.ERROR, "Errore", "Rating deve essere un numero valido!");
                    return;
                }
            } else {
                rating = -1;
            }

            int annoNascita = annoNascitaSpinner.getValue();

            // TODO: inserisci dati nel DB
            System.out.println("Salvato: " + nome + " " + cognome + " " + annoNascita + " " + stato + " S " + ruolo + " " + rating + " " + nazionalita);

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
                "-fx-background-color: #2e7d32;" +
                        "-fx-text-fill: white;" +
                        "-fx-font-size: 16px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-padding: 10 20;" +
                        "-fx-background-radius: 12;" +
                        "-fx-cursor: hand;" +
                        "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.3), 5, 0, 0, 3);" +
                        "-fx-transition: all 0.3s ease-in-out;"
        );

        button.setOnMouseEntered(e -> button.setStyle(
                "-fx-background-color: #388e3c;" +
                        "-fx-text-fill: white;" +
                        "-fx-font-size: 16px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-padding: 10 20;" +
                        "-fx-background-radius: 12;" +
                        "-fx-cursor: hand;" +
                        "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.4), 7, 0, 0, 4);"
        ));

        button.setOnMouseExited(e -> button.setStyle(
                "-fx-background-color: #2e7d32;" +
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