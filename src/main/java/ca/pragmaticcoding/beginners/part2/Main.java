package ca.pragmaticcoding.beginners.part2;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Scene scene = new Scene(createContents(), 400, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Region createContents() {
        HBox results = new HBox(new Label("Name:"), new TextField(""));
        results.setSpacing(6);
        results.setPadding(new Insets(0,0,0,50));
        results.setAlignment(Pos.CENTER_LEFT);
        results.setStyle("-fx-border-color : red;-fx-border-width : 0.5;");
        return results;
    }
}
