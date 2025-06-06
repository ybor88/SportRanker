package com.sportranker;


import javafx.geometry.Pos;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javafx.scene.control.Button;

public class BasketballView extends VBox {
    public BasketballView(Stage stage) {
        setAlignment(Pos.CENTER);
        setSpacing(20);
        setStyle("-fx-background-color: #ffcc80;");

        Button showRating = new Button("Mostra Rating");
        Button addPlayer = new Button("Aggiungi Giocatore");

        Button back = new Button("← Torna indietro");
        back.setOnAction(e -> stage.getScene().setRoot(new MainView(stage)));

        getChildren().addAll(showRating, addPlayer, back);
    }
}