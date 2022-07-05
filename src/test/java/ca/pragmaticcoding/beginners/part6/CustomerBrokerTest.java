package ca.pragmaticcoding.beginners.part6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerBrokerTest {

    @Test
    void createCustomerRecord_AccountNumberTest() {
        CustomerBroker broker = new CustomerBroker();
        Customer customer = new Customer();
        customer.setAccountNumber("1234");
        customer.setName("Fred");
        assertEquals("1234", broker.createCustomerRecord(customer).get("account_number"), "Account number check");
    }

    @Test
    void createCustomerRecord_CustomerNameTest() {
        CustomerBroker broker = new CustomerBroker();
        Customer customer = new Customer();
        customer.setAccountNumber("1234");
        customer.setName("Fred");
        assertEquals("Fred", broker.createCustomerRecord(customer).get("name"), "Customer name check");
    }
}