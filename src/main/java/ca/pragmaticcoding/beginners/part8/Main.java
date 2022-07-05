package ca.pragmaticcoding.beginners.part8;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setScene(new Scene(new CustomerController().getView()));
        primaryStage.show();
    }
}
