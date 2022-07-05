package ca.pragmaticcoding.beginners.part10;

import java.util.Map;

public class SlowCustomerDatabase extends CustomerDatabase {

    private final int delay;

    public SlowCustomerDatabase(int delay) {
        this.delay = delay;
    }

    @Override
    public int saveNewCustomer(Map<String, String> customerRecord) throws CustomerAlreadyOnFileException {
        delay();
        return super.saveNewCustomer(customerRecord);
    }

    private void delay() {
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
