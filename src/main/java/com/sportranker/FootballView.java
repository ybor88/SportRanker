package com.sportranker;

import com.sportranker.modali.AddPlayerDialogFootball;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Objects;

public class FootballView extends VBox {

    public FootballView(Stage stage) {
        setAlignment(Pos.CENTER);
        setSpacing(20);
        setStyle("-fx-background-color: #a5d6a7;");

        // Header con immagine molto grande
        ImageView headerImage = createHeader();
        getChildren().add(headerImage);

        Button showRating = createStyledButton("Mostra Rating");
        Button addPlayer = createStyledButton("Aggiungi Giocatore");
        Button back = createStyledButton("← Torna indietro");

        // Azione del pulsante "Mostra Rating" apre la schermata dei top players
        showRating.setOnAction(e -> stage.getScene().setRoot(new RatingViewSoccer(stage)));

        // Azione del pulsante "Aggiungi Giocatore" apre la modale
        addPlayer.setOnAction(e -> {
            AddPlayerDialogFootball dialog = new AddPlayerDialogFootball(stage);
            dialog.showAndWait();
        });

        // Torna indietro alla main view
        back.setOnAction(e -> stage.getScene().setRoot(new MainView(stage)));

        getChildren().addAll(showRating, addPlayer, back);
    }

    private ImageView createHeader() {
        ImageView headerImage = new ImageView(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/img/worldCup.png"))));
        headerImage.setFitHeight(300);  // immagine molto grande
        headerImage.setPreserveRatio(true);
        return headerImage;
    }

    private Button createStyledButton(String text) {
        Button button = new Button(text);
        button.setStyle(
                "-fx-background-color: #2e7d32;" + // verde scuro
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