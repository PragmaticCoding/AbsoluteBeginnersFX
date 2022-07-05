package ca.pragmaticcoding.beginners.part6;

public class CustomerInteractor {
    private final CustomerModel model;
    private final CustomerBroker broker = new CustomerBroker();

    public CustomerInteractor(CustomerModel model) {
        this.model = model;
    }

    public void saveCustomer() {
        int result = broker.saveCustomer(createCustomerFromModel());
        System.out.println("Saving account: " + model.getAccountNumber() + " Name: " + model.getCustomerName() + " Result: " + result);
    }

     Customer createCustomerFromModel() {
        Customer customer = new Customer();
        customer.setAccountNumber(model.getAccountNumber());
        customer.setName(model.getCustomerName());
        return customer;
    }
}
