package ca.pragmaticcoding.beginners.part10;

import java.util.Map;

public class CustomerDAO {

    static CustomerDatabase database = new SlowCustomerDatabase(3000);

    public int saveCustomer(Map<String, String> customerRecord) throws CustomerAlreadyOnFileException {
        return database.saveNewCustomer(customerRecord);
    }
}
