package ca.pragmaticcoding.beginners.part9;

import javafx.beans.binding.Bindings;

public class CustomerInteractor {
    private final CustomerModel model;
    private final CustomerBroker broker = new CustomerBroker();

    public CustomerInteractor(CustomerModel model) {
        this.model = model;
        model.okToSaveProperty().bind(Bindings.createBooleanBinding(this::isDataValid, model.accountNumberProperty(), model.customerNameProperty()));
    }

    private boolean isDataValid() {
        return !model.getAccountNumber().isEmpty() && !model.getCustomerName().isEmpty();
    }

    public void saveCustomer() {
        String customerName = model.getCustomerName();
        String account = model.getAccountNumber();
        int result = broker.saveCustomer(createCustomerFromModel());
        System.out.println("Saving account: " + account + " Name: " + customerName + " Result: " + result);
    }

     Customer createCustomerFromModel() {
        Customer customer = new Customer();
        customer.setAccountNumber(model.getAccountNumber());
        customer.setName(model.getCustomerName());
        return customer;
    }
}
