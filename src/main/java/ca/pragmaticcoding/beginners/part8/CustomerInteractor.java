package ca.pragmaticcoding.beginners.part8;

public class CustomerInteractor {
    private final CustomerModel model;
    private final CustomerBroker broker = new CustomerBroker();

    public CustomerInteractor(CustomerModel model) {
        this.model = model;
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
