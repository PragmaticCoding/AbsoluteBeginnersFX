package ca.pragmaticcoding.beginners.part10;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class CustomerDatabaseTest {

    CustomerDatabase dataBase;

    @BeforeEach
    void init() {
        dataBase = new CustomerDatabase();
    }

    @Test
    void saveCustomerIdIncrementTest() {
        assertEquals(1, dataBase.saveCustomer(createFred()), "Id is incremented");
    }

    @Test
    void saveCustomerIdIncrementTwiceTest() {
        dataBase.saveCustomer(createFred());
        assertEquals(2, dataBase.saveCustomer(createGeorge()), "Id is incremented");
    }

    @Test
    void saveCustomerIdInsertionTest() {
        dataBase.saveCustomer(createFred());
        assertEquals("1", dataBase.getData().get(1).get("_id"), "Id is inserted");
    }

    @Test
    void saveCustomerRecordCorrectTest() {
        dataBase.saveCustomer(createFred());
        assertEquals("Fred", dataBase.getData().get(1).get("name"), "Id is inserted");
    }

    @Test
    void findAccountTest_Found() {
        dataBase.saveCustomer(createFred());
        dataBase.saveCustomer(createGeorge());
        assertTrue(dataBase.isAccountOnFile("123"), "Lookup Fred");
    }

    @Test
    void findAccountTest_NotFound() {
        dataBase.saveCustomer(createFred());
        dataBase.saveCustomer(createGeorge());
        assertFalse(dataBase.isAccountOnFile("7777"), "Lookup someone not present");
    }

    @Test
    void saveWithoutAccountNumber() {
        HashMap<String, String> customerRecord = new HashMap<>();
        customerRecord.put("name", "Fred");
        assertThrows(IllegalArgumentException.class, () -> dataBase.saveNewCustomer(customerRecord));
    }

    @Test
    void saveRecordTwiceTest() {
        dataBase.saveCustomer(createFred());
        assertThrows(CustomerAlreadyOnFileException.class, () -> dataBase.saveNewCustomer(createFred()));
    }

    private Map<String, String> createFred() {
        HashMap<String, String> customerRecord = new HashMap<>();
        customerRecord.put("name", "Fred");
        customerRecord.put("account_number", "123");
        return customerRecord;
    }

    private Map<String, String> createGeorge() {
        HashMap<String, String> customerRecord = new HashMap<>();
        customerRecord.put("name", "George");
        customerRecord.put("account_number", "567");
        return customerRecord;
    }
}