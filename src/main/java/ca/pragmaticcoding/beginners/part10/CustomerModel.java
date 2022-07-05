package ca.pragmaticcoding.beginners.part10;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class CustomerModel {

    private final StringProperty accountNumber = new SimpleStringProperty("");
    private final StringProperty customerName = new SimpleStringProperty("");
    private final BooleanProperty okToSave = new SimpleBooleanProperty(false);

    public String getAccountNumber() {
        return accountNumber.get();
    }

    public StringProperty accountNumberProperty() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber.set(accountNumber);
    }

    public String getCustomerName() {
        return customerName.get();
    }

    public StringProperty customerNameProperty() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName.set(customerName);
    }

    public boolean isOkToSave() {
        return okToSave.get();
    }

    public BooleanProperty okToSaveProperty() {
        return okToSave;
    }

    public void setOkToSave(boolean okToSave) {
        this.okToSave.set(okToSave);
    }
}
