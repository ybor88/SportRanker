package com.sportranker;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.util.Objects;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        MainView mainView = new MainView(stage);
        Scene scene = new Scene(mainView);

        stage.setTitle("SportRanker");

        // 🔽 Aggiunta dell'icona alla barra del titolo
        stage.getIcons().add(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/img/logoSportRanker.png"))));

        stage.setScene(scene);
        stage.setMaximized(true);
        stage.setResizable(true);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}