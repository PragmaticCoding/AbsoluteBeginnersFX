package ca.pragmaticcoding.beginners.part8;

import java.util.Map;

public class SlowCustomerDatabase extends CustomerDatabase {

    private final int delay;

    public SlowCustomerDatabase(int delay) {
        this.delay = delay;
    }

    @Override
    public int saveCustomer(Map<String, String> customerRecord) {
        delay();
        return super.saveCustomer(customerRecord);
    }

    private void delay() {
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
