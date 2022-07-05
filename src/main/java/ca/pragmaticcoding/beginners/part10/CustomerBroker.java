package ca.pragmaticcoding.beginners.part10;

import java.util.HashMap;
import java.util.Map;

public class CustomerBroker {

    private final CustomerDAO dao = new CustomerDAO();

    public int saveCustomer(Customer customer) throws CustomerAlreadyOnFileException {
        return dao.saveCustomer(createCustomerRecord(customer));
    }

    Map<String, String> createCustomerRecord(Customer customer) {
        Map<String, String> customerRecord = new HashMap<>();
        customerRecord.put("name", customer.getName());
        customerRecord.put("account_number", customer.getAccountNumber());
        return customerRecord;
    }
}
