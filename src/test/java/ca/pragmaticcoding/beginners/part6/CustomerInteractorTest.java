package ca.pragmaticcoding.beginners.part6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerInteractorTest {

    @Test
    void createCustomer_NameTest() {
        CustomerModel model = new CustomerModel();
        CustomerInteractor interactor = new CustomerInteractor(model);
        model.setCustomerName("Fred");
        model.setAccountNumber("ABCDE");
        assertEquals("Fred", interactor.createCustomerFromModel().getName(),"Check customer name");
    }

    @Test
    void createCustomer_AccountTest() {
        CustomerModel model = new CustomerModel();
        CustomerInteractor interactor = new CustomerInteractor(model);
        model.setCustomerName("Fred");
        model.setAccountNumber("ABCDE");
        assertEquals("ABCDE", interactor.createCustomerFromModel().getAccountNumber(),"Check customer name");
    }
}