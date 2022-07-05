package ca.pragmaticcoding.beginners.part6;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class CustomerDatabaseTest {

    @Test
    void saveCustomerIdIncrementTest() {
        CustomerDatabase dataBase = new CustomerDatabase();
        assertEquals(1,dataBase.saveCustomer(new HashMap<String, String>()), "Id is incremented");
    }

    @Test
    void saveCustomerIdIncrementTwiceTest() {
        CustomerDatabase dataBase = new CustomerDatabase();
        dataBase.saveCustomer(new HashMap<String, String>());
        assertEquals(2,dataBase.saveCustomer(new HashMap<String, String>()), "Id is incremented");
    }

    @Test
    void saveCustomerIdInsertionTest() {
        CustomerDatabase dataBase = new CustomerDatabase();
        HashMap<String, String> customerRecord = new HashMap<>();
        dataBase.saveCustomer(new HashMap<String, String>());
        assertEquals("1",dataBase.getData().get(1).get("_id"), "Id is inserted");
    }

    @Test
    void saveCustomerRecordCorrectTest() {
        CustomerDatabase dataBase = new CustomerDatabase();
        HashMap<String, String> customerRecord = new HashMap<>();
        customerRecord.put("name", "Fred");
        dataBase.saveCustomer(customerRecord);
        assertEquals("Fred",dataBase.getData().get(1).get("name"), "Id is inserted");
    }
}