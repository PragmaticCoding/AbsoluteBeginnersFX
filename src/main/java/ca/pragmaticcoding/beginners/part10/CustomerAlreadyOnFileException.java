package ca.pragmaticcoding.beginners.part10;

public class CustomerAlreadyOnFileException extends Exception {

    public CustomerAlreadyOnFileException(String accountNumber) {
        super("Customer account: " + accountNumber + " is already on file");
    }
}
