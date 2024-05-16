package edu.sdccd.cisc191.template;

import javafx.application.Application;
import javafx.stage.Stage;

import static javafx.application.Application.launch;

public class Main extends Application {
    public static void main(String[] args) {
        launch();
    }

    public void start(Stage stage) {
        MenuController menuController = new MenuController(stage);
        stage.setTitle("Step on a Crack...");
        stage.setScene( menuController.getScene() );
        stage.show();
    }
}
