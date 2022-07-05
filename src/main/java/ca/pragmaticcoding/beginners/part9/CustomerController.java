package ca.pragmaticcoding.beginners.part9;

import javafx.concurrent.Task;
import javafx.scene.layout.Region;
import javafx.util.Builder;

public class CustomerController {

    private final Builder<Region> viewBuilder;
    private final CustomerInteractor interactor;

    public CustomerController() {
        CustomerModel model = new CustomerModel();
        interactor = new CustomerInteractor(model);
        viewBuilder = new CustomerViewBuilder(model,this::saveCustomer);
    }

    private void saveCustomer(Runnable postTaskGuiActions) {
        Task<Void> saveTask = new Task<>() {
            @Override
            protected Void call() {
                interactor.saveCustomer();
                return null;
            }
        };
        saveTask.setOnSucceeded(evt -> postTaskGuiActions.run());
        Thread saveThread = new Thread(saveTask);
        saveThread.start();
    }

    public Region getView() {
        return viewBuilder.build();
    }
}
