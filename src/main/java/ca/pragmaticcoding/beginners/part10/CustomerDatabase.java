package ca.pragmaticcoding.beginners.part10;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class CustomerDatabase {

    private final Map<Integer, Map<String, String>> data = new HashMap<>();
    private Integer nextKey = 0;

    public int saveNewCustomer(Map<String, String> customerRecord) throws CustomerAlreadyOnFileException, IllegalArgumentException {
        Optional<String> accountNumberOptional = getAccount(customerRecord);
        if (accountNumberOptional.isPresent()) {
            String accountNumber = accountNumberOptional.get();
            if (!isAccountOnFile(accountNumber)) {
                return saveCustomer(customerRecord);
            } else {
                throw new CustomerAlreadyOnFileException(accountNumber);
            }
        } else {
            throw new IllegalArgumentException("Account number must be included in Customer Record");
        }
    }

    int saveCustomer(Map<String, String> customerRecord) {
        customerRecord.put("_id", (++nextKey).toString());
        data.put(nextKey, customerRecord);
        return nextKey;
    }

    boolean isAccountOnFile(String accountNumber) {
        return data.values().stream().anyMatch(record -> getAccount(record).map(value -> value.equals(accountNumber)).orElse(false));
    }

    private Optional<String> getAccount(Map<String, String> customerRecord) {
        return Optional.ofNullable(customerRecord.get("account_number"));
    }

    Map<Integer, Map<String, String>> getData() {
        return data;
    }
}
