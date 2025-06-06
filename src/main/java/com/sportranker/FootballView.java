package com.sportranker;


import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FootballView extends VBox {
    public FootballView(Stage stage) {
        setAlignment(Pos.CENTER);
        setSpacing(20);
        setStyle("-fx-background-color: #a5d6a7;");

        Button showRating = new Button("Mostra Rating");
        Button addPlayer = new Button("Aggiungi Giocatore");

        Button back = new Button("← Torna indietro");
        back.setOnAction(e -> stage.getScene().setRoot(new MainView(stage)));

        getChildren().addAll(showRating, addPlayer, back);
    }

}