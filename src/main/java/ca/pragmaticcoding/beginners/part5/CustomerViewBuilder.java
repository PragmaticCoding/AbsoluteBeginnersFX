package ca.pragmaticcoding.beginners.part5;

import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.util.Builder;

public class CustomerViewBuilder implements Builder<Region> {

    private final CustomerModel model;
    public CustomerViewBuilder(CustomerModel model) {
        this.model = model;
    }

    @Override
    public Region build() {
        return new VBox();
    }
}
