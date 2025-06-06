package com.sportranker;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        MainView mainView = new MainView(stage);
        Scene scene = new Scene(mainView);

        stage.setTitle("SportRanker");
        stage.setScene(scene);

        // Estende la finestra a tutto schermo
        stage.setMaximized(true);
        stage.setResizable(true);

        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}