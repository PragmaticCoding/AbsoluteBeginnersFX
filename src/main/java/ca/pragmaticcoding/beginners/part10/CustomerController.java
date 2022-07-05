package ca.pragmaticcoding.beginners.part10;

import javafx.concurrent.Task;
import javafx.scene.control.Alert;
import javafx.scene.layout.Region;
import javafx.util.Builder;

public class CustomerController {

    private final Builder<Region> viewBuilder;
    private final CustomerInteractor interactor;

    public CustomerController() {
        CustomerModel model = new CustomerModel();
        interactor = new CustomerInteractor(model);
        viewBuilder = new CustomerViewBuilder(model, this::saveCustomer);
    }

    private void saveCustomer(Runnable postTaskGuiActions) {
        Task<Boolean> saveTask = new Task<>() {
            @Override
            protected Boolean call() {
                return interactor.saveCustomer();

            }
        };
        saveTask.setOnSucceeded(evt -> {
            postTaskGuiActions.run();
            if (!saveTask.getValue()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("This customer is already on file, cannot save.");
                alert.show();
            }
        });
        Thread saveThread = new Thread(saveTask);
        saveThread.start();
    }

    public Region getView() {
        return viewBuilder.build();
    }
}
