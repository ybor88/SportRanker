package com.sportranker.modali;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.sql.Connection;
import java.util.Objects;

import static java.lang.System.*;

public class AddPlayerDialogFootball extends Stage {

    public AddPlayerDialogFootball(Stage owner) {
        initOwner(owner);
        initModality(Modality.APPLICATION_MODAL);
        setTitle("Aggiungi Giocatore");

        getIcons().add(new Image(
                Objects.requireNonNull(getClass().getResourceAsStream("/img/palloneCalcio.jpg")),
                64, 64,   // width, height forzati in pixel
                true,     // preserveRatio
                true      // smooth
        ));

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
        ruoloCombo.getItems().addAll("CE", "DI", "AT", "PO"); // ruoli validi

        TextField nazionalitaField = new TextField();

        TextField partiteDivisoStagioniField = new TextField();  // double
        TextField goalCalcoloField = new TextField();            // double

        ComboBox<String> bonusTipoCombo = new ComboBox<>();
        bonusTipoCombo.getItems().addAll(
                "Nessun bonus",
                "Bonus Centrocampista",
                "Bonus Difensore"
        );
        bonusTipoCombo.setValue("Nessun bonus");

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

        // Qui ho spostato Nazionalità subito sotto Ruolo
        grid.add(new Label("Nazionalità:"), 0, 5);
        grid.add(nazionalitaField, 1, 5);

        grid.add(new Label("Partite Giocate Totali Carriera / Stagioni Totali Carriera:"), 0, 6);
        grid.add(partiteDivisoStagioniField, 1, 6);

        grid.add(new Label("(Calcolo Goal Carriera * 2 / Partite totali Carriera) * 100:"), 0, 7);
        grid.add(goalCalcoloField, 1, 7);

        grid.add(new Label("Tipo Bonus Ruolo:"), 0, 8);
        grid.add(bonusTipoCombo, 1, 8);

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

            if (codice.isEmpty() || nome.isEmpty() || cognome.isEmpty() || nazionalita.isEmpty() || ruolo == null ||
                    partiteDivisoStagioniField.getText().trim().isEmpty() ||
                    goalCalcoloField.getText().trim().isEmpty() ||
                    bonusTipoCombo.getValue() == null) {
                showAlert(Alert.AlertType.ERROR, "Errore", "Compila tutti i campi obbligatori!");
                return;
            }

            double partiteDivisoStagioni;
            double goalCalcolo;

            try {
                partiteDivisoStagioni = Double.parseDouble(partiteDivisoStagioniField.getText().trim());
            } catch (NumberFormatException ex) {
                showAlert(Alert.AlertType.ERROR, "Errore", "Inserisci un numero valido per Partite/Stagioni!");
                return;
            }

            try {
                goalCalcolo = Double.parseDouble(goalCalcoloField.getText().trim());
            } catch (NumberFormatException ex) {
                showAlert(Alert.AlertType.ERROR, "Errore", "Inserisci un numero valido per il calcolo Goal!");
                return;
            }

            int annoNascita = annoNascitaSpinner.getValue();

            out.println("Salvato: " + codice + ", " + nome + " " + cognome + ", " + annoNascita + ", " +
                    ruolo + ", Nazionalità: " + nazionalita +
                    ", Partite/Stagioni: " + partiteDivisoStagioni + ", Calcolo Goal: " + goalCalcolo +
                    ", Bonus Tipo: " + bonusTipoCombo.getValue());

            close();
        });

        cancelButton.setOnAction(e -> close());

        Scene scene = new Scene(grid);
        setScene(scene);

        // Qui va il codice:
        saveButton.setOnAction(e -> {
            String codice = codiceField.getText().trim();
            String nome = nomeField.getText().trim();
            String cognome = cognomeField.getText().trim();
            String nazionalita = nazionalitaField.getText().trim();
            String ruolo = ruoloCombo.getValue();

            if (codice.isEmpty() || nome.isEmpty() || cognome.isEmpty() || nazionalita.isEmpty() || ruolo == null ||
                    partiteDivisoStagioniField.getText().trim().isEmpty() ||
                    goalCalcoloField.getText().trim().isEmpty() ||
                    bonusTipoCombo.getValue() == null) {
                showAlert(Alert.AlertType.ERROR, "Errore", "Compila tutti i campi obbligatori!");
                return;
            }

            double partiteDivisoStagioni;
            double goalCalcolo;

            try {
                partiteDivisoStagioni = Double.parseDouble(partiteDivisoStagioniField.getText().trim());
            } catch (NumberFormatException ex) {
                showAlert(Alert.AlertType.ERROR, "Errore", "Inserisci un numero valido per Partite/Stagioni!");
                return;
            }

            try {
                goalCalcolo = Double.parseDouble(goalCalcoloField.getText().trim());
            } catch (NumberFormatException ex) {
                showAlert(Alert.AlertType.ERROR, "Errore", "Inserisci un numero valido per il calcolo Goal!");
                return;
            }

            int annoNascita = annoNascitaSpinner.getValue();

            // Calcolo bonus in base al tipo selezionato
            double bonusValore = switch (bonusTipoCombo.getValue()) {
                case "Bonus Centrocampista" -> 66.0;
                case "Bonus Difensore" -> 82.0;
                default -> 0.0;
            };

            // Calcolo rating sommando i valori
            double rating = partiteDivisoStagioni + goalCalcolo + bonusValore;

            // SPORT fisso a 'S'
            String sport = "S";

            try {
                Connection conn = com.sportranker.db.DatabaseManager.getConnection();

                String sql = "INSERT INTO PLAYERS (CODICE, NOME, COGNOME, ANNO_NASCITA, SPORT, RUOLO, RATING, NAZIONALITA) " +
                        "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

                try (var stmt = conn.prepareStatement(sql)) {
                    stmt.setString(1,codice);
                    stmt.setString(2, nome);
                    stmt.setString(3, cognome);
                    stmt.setInt(4, annoNascita);
                    stmt.setString(5, sport);
                    stmt.setString(6, ruolo);
                    stmt.setDouble(7, rating);
                    stmt.setString(8, nazionalita);

                    int rowsInserted = stmt.executeUpdate();
                    if (rowsInserted > 0) {
                        showAlert(Alert.AlertType.INFORMATION, "Successo", "Giocatore aggiunto correttamente!");
                        close();
                    } else {
                        showAlert(Alert.AlertType.ERROR, "Errore", "Errore nell'inserimento del giocatore nel database.");
                    }
                }

            } catch (Exception ex) {
                ex.printStackTrace();
                showAlert(Alert.AlertType.ERROR, "Errore", "Errore nel database: " + ex.getMessage());
            }
        });

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
                        "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.3), 5, 0, 0, 3);"
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