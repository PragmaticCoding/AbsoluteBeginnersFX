package ca.pragmaticcoding.beginners.part6;

import java.util.HashMap;
import java.util.Map;

public class CustomerDatabase {

    private Map<Integer, Map<String, String>> data = new HashMap<>();
    private Integer nextKey = 0;

    public int saveCustomer(Map<String, String> customerRecord) {
        customerRecord.put("_id", (++nextKey).toString());
        data.put(nextKey, customerRecord);
        return nextKey;
    }

    Map<Integer, Map<String,String>> getData() {
        return data;
    }
}
