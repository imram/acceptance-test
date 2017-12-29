package features.eligibility;

import features.eligibility.model.Passenger;
import net.thucydides.core.annotations.Step;

import java.util.List;
import java.util.Map;

public class PassengerAction {
    private Passenger passenger;
    @Step
    public void retrievePNR(List<Map<String, String>> passengerMap) {
        //passenger.setPNR(MockReservationApi.create(passengerMap));
    }
}
