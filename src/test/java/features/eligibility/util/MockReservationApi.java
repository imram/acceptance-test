package features.eligibility.util;

import java.util.List;
import java.util.Map;

public class MockReservationApi {
    public static String create(List<Map<String, String>> passengers) {
        return passengers.get(0).get("firstName").equals("John") ? "ZXVWSL" : "ABCDEF";
    }
}
