package com.sportranker;

import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.Objects;

public class MainView extends VBox {
    public MainView(Stage stage) {
        setSpacing(40);
        setAlignment(Pos.TOP_CENTER);
        setStyle("-fx-padding: 40; -fx-background-color: #f4f4f4;");

        // Logo
        ImageView logoView = new ImageView(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/img/logoSportRanker.png"))));
        logoView.setFitWidth(120);
        logoView.setPreserveRatio(true);

        // Titolo
        Label title = new Label("SportRanker");
        title.setFont(Font.font("Arial", 28));
        title.setTextFill(Color.web("#2e7d32"));

        VBox headerBox = new VBox(logoView, title);
        headerBox.setAlignment(Pos.CENTER);
        headerBox.setSpacing(10);

        // Cards
        HBox cardsBox = new HBox(30);
        cardsBox.setAlignment(Pos.CENTER);

        VBox footballCard = createCard("Calcio", "/img/football.jpg", "#43a047");
        VBox basketballCard = createCard("Basket", "/img/basketball.jpg", "#fb8c00");

        footballCard.setOnMouseClicked(e -> stage.getScene().setRoot(new FootballView(stage)));
        basketballCard.setOnMouseClicked(e -> stage.getScene().setRoot(new BasketballView(stage)));

        cardsBox.getChildren().addAll(footballCard, basketballCard);

        getChildren().addAll(headerBox, cardsBox);
    }

    private VBox createCard(String label, String imagePath, String bgColor) {
        VBox box = new VBox(10);
        box.setAlignment(Pos.CENTER);
        box.setPrefSize(200, 250);
        box.setStyle(
                "-fx-background-color: " + bgColor + ";" +
                        "-fx-background-radius: 20;" +
                        "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.2), 8, 0, 2, 4);" +
                        "-fx-cursor: hand;"
        );

        Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream(imagePath)));
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(140);
        imageView.setFitHeight(140);

        Label title = new Label(label);
        title.setTextFill(Color.WHITE);
        title.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");

        box.setOnMouseEntered(e -> box.setScaleX(1.05));
        box.setOnMouseEntered(e -> box.setScaleY(1.05));
        box.setOnMouseExited(e -> {
            box.setScaleX(1.0);
            box.setScaleY(1.0);
        });

        box.getChildren().addAll(imageView, title);
        return box;
    }
}