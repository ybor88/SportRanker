package com.sportranker;

import com.sportranker.db.DatabaseManager;
import com.sportranker.model.Player;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RatingViewBasketball extends VBox {
    public RatingViewBasketball(Stage stage) {
        setSpacing(15);
        setAlignment(Pos.CENTER);
        setStyle("-fx-background-color: #f4f4f4;");

        // Caricamento immagine sopra il titolo
        InputStream imgStream = getClass().getResourceAsStream("/img/palloneBasket.jpg");
        ImageView headerImage = (imgStream != null) ? new ImageView(new Image(imgStream)) : new ImageView();
        if (imgStream == null) {
            System.out.println("Immagine non trovata!");
        } else {
            headerImage.setFitHeight(100);
            headerImage.setPreserveRatio(true);
        }

        Label title = new Label("Top Players");
        title.setFont(Font.font("Arial", 24));
        title.setTextFill(Color.web("#ff9800")); // Testo arancione

        TableView<Player> table = new TableView<>();
        table.setPrefWidth(500);
        table.setStyle("-fx-background-color: white; -fx-border-color: #ff9800; -fx-border-width: 2px;");
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        // Creazione colonne con numerazione automatica e intestazioni arancioni
        TableColumn<Player, Integer> posizioneCol = new TableColumn<>("Posizione");
        posizioneCol.setCellValueFactory(new PropertyValueFactory<>("posizione"));

        TableColumn<Player, String> nomeCol = createStyledColumn("Nome", "nome");
        TableColumn<Player, String> cognomeCol = createStyledColumn("Cognome", "cognome");
        TableColumn<Player, Integer> annoCol = createStyledColumnInt("Anno Nascita", "annoNascita");
        TableColumn<Player, String> ruoloCol = createStyledColumn("Ruolo", "ruolo");
        TableColumn<Player, Double> ratingCol = createStyledColumnDouble("Rating", "rating");

        table.getColumns().addAll(posizioneCol, nomeCol, cognomeCol, annoCol, ruoloCol, ratingCol);
        table.setItems(getTopPlayers());

        // Pulsante "Indietro" con tono arancione
        Button backButton = new Button("← Torna indietro");
        backButton.setStyle("-fx-background-color: #ff9800; -fx-text-fill: white; -fx-font-size: 14px; -fx-padding: 6 12; -fx-background-radius: 8; -fx-cursor: hand;");
        backButton.setOnAction(e -> stage.getScene().setRoot(new FootballView(stage)));

        getChildren().clear();
        getChildren().addAll(headerImage, title, table, backButton);
    }

    private <T> TableColumn<Player, T> createStyledColumn(String title, String property) {
        TableColumn<Player, T> column = new TableColumn<>(title);
        column.setCellValueFactory(new PropertyValueFactory<>(property));
        column.setStyle("-fx-text-fill: #ff9800; -fx-font-weight: bold;"); // Testo arancione nelle intestazioni
        return column;
    }

    private TableColumn<Player, Integer> createStyledColumnInt(String title, String property) {
        TableColumn<Player, Integer> column = new TableColumn<>(title);
        column.setCellValueFactory(new PropertyValueFactory<>(property));
        column.setStyle("-fx-text-fill: #ff9800; -fx-font-weight: bold;");
        return column;
    }

    private TableColumn<Player, Double> createStyledColumnDouble(String title, String property) {
        TableColumn<Player, Double> column = new TableColumn<>(title);
        column.setCellValueFactory(new PropertyValueFactory<>(property));
        column.setStyle("-fx-text-fill: #ff9800; -fx-font-weight: bold;");

        // Colorazione delle prime tre posizioni SOLO sulla colonna Rating
        column.setCellFactory(tc -> new TableCell<Player, Double>() {
            @Override
            protected void updateItem(Double item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null || getTableRow().getItem() == null) {
                    setText(null);
                    setStyle("");
                } else {
                    setText(String.valueOf(item));

                    Player player = getTableRow().getItem(); // Ottieni il player corretto
                    if (player.getPosizione() == 1) {
                        setTextFill(Color.GOLD);
                    } else if (player.getPosizione() == 2) {
                        setTextFill(Color.SILVER);
                    } else if (player.getPosizione() == 3) {
                        setTextFill(Color.BROWN);
                    } else {
                        setTextFill(Color.BLACK);
                    }
                }
            }
        });
        return column;
    }

    private ObservableList<Player> getTopPlayers() {
        List<Player> players = new ArrayList<>();
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(
                     "SELECT ROW_NUMBER() OVER (ORDER BY RATING DESC) AS POSIZIONE, " +
                             "NOME, COGNOME, ANNO_NASCITA, RUOLO, RATING " +
                             "FROM PLAYERS WHERE SPORT = 'B' ORDER BY RATING");
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Player player = new Player(rs.getInt("POSIZIONE"), rs.getString("NOME"), rs.getString("COGNOME"),
                        rs.getInt("ANNO_NASCITA"), rs.getString("RUOLO"), rs.getDouble("RATING"));
                players.add(player);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return FXCollections.observableArrayList(players);
    }
}