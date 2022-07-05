package ca.pragmaticcoding.beginners.part8;

import java.util.Map;

public class CustomerDAO {

    static CustomerDatabase database = new SlowCustomerDatabase(10000);

    public int saveCustomer(Map<String, String> customerRecord) {
        return database.saveCustomer(customerRecord);
    }
}
