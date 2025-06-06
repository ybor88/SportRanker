package com.sportranker;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.Objects;

public class MainView extends HBox {
    public MainView(Stage stage) {
        setSpacing(30);
        setAlignment(Pos.CENTER);
        setStyle("-fx-padding: 40;");

        // Percorsi immagini coerenti e corrette
        VBox footballCard = createCard("Calcio", "/img/football.jpg", "#2e7d32"); // verde campo
        VBox basketballCard = createCard("Basket", "/img/basketball.jpg", "#ef6c00"); // arancione campo

        footballCard.setOnMouseClicked(e -> stage.getScene().setRoot(new FootballView(stage)));
        basketballCard.setOnMouseClicked(e -> stage.getScene().setRoot(new BasketballView(stage)));

        getChildren().addAll(footballCard, basketballCard);
    }

    private VBox createCard(String label, String imagePath, String bgColor) {
        VBox box = new VBox(10);
        box.setAlignment(Pos.CENTER);
        box.setPrefSize(200, 250);
        box.setStyle("-fx-background-color: " + bgColor + "; -fx-background-radius: 15; -fx-cursor: hand;");

        Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream(imagePath),
                "Immagine non trovata: " + imagePath));
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(150);
        imageView.setFitHeight(150);
        imageView.setPreserveRatio(true);

        Label title = new Label(label);
        title.setTextFill(Color.WHITE);
        title.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

        box.getChildren().addAll(imageView, title);
        return box;
    }
}