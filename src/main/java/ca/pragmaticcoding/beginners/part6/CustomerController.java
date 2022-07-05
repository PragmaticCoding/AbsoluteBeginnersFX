package ca.pragmaticcoding.beginners.part6;

import javafx.scene.layout.Region;
import javafx.util.Builder;

public class CustomerController {

    private final Builder<Region> viewBuilder;
    private final CustomerInteractor interactor;

    public CustomerController() {
        CustomerModel model = new CustomerModel();
        interactor = new CustomerInteractor(model);
        viewBuilder = new CustomerViewBuilder(model,interactor::saveCustomer);
    }

    public Region getView() {
        return viewBuilder.build();
    }
}
