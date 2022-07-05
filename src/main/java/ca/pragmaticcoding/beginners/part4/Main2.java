package ca.pragmaticcoding.beginners.part4;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main2 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    private final StringProperty greeting = new SimpleStringProperty("");
    private final StringProperty name = new SimpleStringProperty("");

    @Override
    public void start(Stage primaryStage) {
        Scene scene = new Scene(createContents(), 400, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Region createContents() {
        VBox results = new VBox(20, createInputRow(), createOutputLabel(), createButton());
        results.setAlignment(Pos.CENTER);
        results.getStylesheets().add(this.getClass().getResource("/css/beginners.css").toExternalForm());
        return results;
    }

    private Button createButton() {
        Button results = new Button("Hello");
        results.setOnAction(evt -> setGreeting());
        return results;
    }

    private HBox createInputRow() {
        TextField textField = new TextField("");
        textField.textProperty().bindBidirectional(name);
        HBox hBox = new HBox(6, styledLabel("Name:", "prompt-label"), textField);
        hBox.setAlignment(Pos.CENTER);
        return hBox;
    }

    private Node createOutputLabel() {
        Label results = styledLabel("", "greeting-label");
        results.textProperty().bind(greeting);
        return results;
    }

    private Label styledLabel(String contents, String classSelector) {
        Label results = new Label(contents);
        results.getStyleClass().add(classSelector);
        return results;
    }

    private void setGreeting() {
        greeting.set("Hello " + name.get());
    }
}
