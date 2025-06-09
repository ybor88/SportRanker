package com.sportranker;

import com.sportranker.modali.AddPlayerDialogBasketball;
import com.sportranker.modali.AddPlayerDialogFootball;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Button;

import java.util.Objects;

public class BasketballView extends VBox {

    public BasketballView(Stage stage) {
        setAlignment(Pos.CENTER);
        setSpacing(20);
        setStyle("-fx-background-color: #ffcc80;"); // Arancione chiaro

        // Header con immagine grande
        ImageView headerImage = createHeader();
        getChildren().add(headerImage);

        Button showRating = createStyledButton("Mostra Rating");
        Button addPlayer = createStyledButton("Aggiungi Giocatore");

        Button back = createStyledButton("← Torna indietro");
        // Azione del pulsante "Aggiungi Giocatore" apre la modale
        addPlayer.setOnAction(e -> {
            AddPlayerDialogBasketball dialog = new AddPlayerDialogBasketball(stage);
            dialog.showAndWait();
        });

        back.setOnAction(e -> stage.getScene().setRoot(new MainView(stage)));

        getChildren().addAll(showRating, addPlayer, back);
    }

    private ImageView createHeader() {
        ImageView headerImage = new ImageView(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/img/basketballCup.png"))));
        headerImage.setFitHeight(300);  // immagine molto grande
        headerImage.setPreserveRatio(true);
        return headerImage;
    }

    private Button createStyledButton(String text) {
        Button button = new Button(text);
        button.setStyle(
                "-fx-background-color: #ef6c00;" + // Arancione forte
                        "-fx-text-fill: white;" +
                        "-fx-font-size: 16px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-padding: 10 20;" +
                        "-fx-background-radius: 12;" +
                        "-fx-cursor: hand;" +
                        "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.3), 5, 0, 0, 3);"
        );

        button.setOnMouseEntered(e -> button.setStyle(
                "-fx-background-color: #f57c00;" + // più chiaro al passaggio
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