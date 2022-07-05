package ca.pragmaticcoding.beginners.part6;

import java.util.Map;

public class CustomerDAO {

    static CustomerDatabase database = new CustomerDatabase();

    public int saveCustomer(Map<String, String> customerRecord) {
        return database.saveCustomer(customerRecord);
    }
}
