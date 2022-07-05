package ca.pragmaticcoding.beginners.part9;

import javafx.beans.property.StringProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.util.Builder;

import java.util.Objects;
import java.util.function.Consumer;

public class CustomerViewBuilder implements Builder<Region> {

    private final CustomerModel model;
    private final Consumer<Runnable> saveHandler;
    public CustomerViewBuilder(CustomerModel model, Consumer<Runnable> saveHandler) {
        this.model = model;
        this.saveHandler = saveHandler;
    }

    @Override
    public Region build() {
        BorderPane results = new BorderPane();
        results.getStylesheets().add(Objects.requireNonNull(this.getClass().getResource("/css/customer.css")).toExternalForm());
        results.setTop(headingLabel("Customer Information"));
        results.setCenter(createCentre());
        results.setBottom(createButtons());
        return results;
    }

    private Node createCentre() {
        VBox results = new VBox(6, accountBox(), nameBox());
        results.setPadding(new Insets(20));
        return results;
    }

    private Node accountBox() {
        return new HBox(6,promptLabel("Account #:"), boundTextField(model.accountNumberProperty()));
    }

    private Node nameBox() {
        return new HBox(6, promptLabel("Name:"), boundTextField(model.customerNameProperty()));
    }

    private Node createButtons() {
        Button saveButton = new Button("Save");
        saveButton.disableProperty().bind(model.okToSaveProperty().not());
        saveButton.setOnAction(evt -> {
            saveButton.disableProperty().unbind();
            saveButton.setDisable(true);
            saveHandler.accept(() -> saveButton.disableProperty().bind(model.okToSaveProperty().not()));
        });
        HBox results = new HBox(10, saveButton);
        results.setAlignment(Pos.CENTER_RIGHT);
        return results;
    }

    private Node boundTextField(StringProperty boundProperty) {
        TextField textField = new TextField();
        textField.textProperty().bindBidirectional(boundProperty);
        return textField;
    }

    private Node promptLabel(String contents) {
        return styledLabel(contents, "prompt-label");
    }

    private Node headingLabel(String contents) {
        return styledLabel(contents, "heading-label");
    }

    private Node styledLabel(String contents, String styleClass) {
        Label label = new Label(contents);
        label.getStyleClass().add(styleClass);
        return label;
    }
}
