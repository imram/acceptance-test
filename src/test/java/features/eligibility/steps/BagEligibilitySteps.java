package features.eligibility.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import features.eligibility.PassengerAction;
import features.eligibility.util.MockReservationApi;
import io.restassured.response.Response;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

import static net.serenitybdd.rest.SerenityRest.rest;
import static org.hamcrest.core.Is.is;

public class BagEligibilitySteps {
    @Steps
    private PassengerAction passengerAction;
    private String recordLocator;

    private Response response;

    @Given("^Passenger with following reservation wants to check bag online$")
    public void passengerWithFollowingReservationWantsToCheckBagOnline(List<Map<String, String>> passengerMap) throws Throwable {
        recordLocator = MockReservationApi.create(passengerMap);
// TODO:       passengerAction.retrievePNR(passengerMap);
    }

    @When("^I check bag eligibility for above passenger$")
    public void i_check_bag_eligibility_for_above_passenger() throws Exception {

        response = rest()
                .header("x-clientId", "AACOM")
                .queryParam("recordLocator", recordLocator)
                .when()
                .get("https://aa-ct-fly-merchandising-bff.mybluemix.net/viewRes/products")
                .thenReturn();
    }

    @Then("^I should be able to see customer is eligible to buy bag for given slice$")
    public void i_should_be_able_to_see_customer_ineligible_for_bag() throws Exception {
        Assert.assertThat(response
                .getStatusCode(), is(200));
    }

    @Then("^I should be able to see customer is not eligible to buy bag for given slice$")
    public void iShouldBeAbleToSeeCustomerIsNotEligibleToBuyBagForGivenSlice() throws Throwable {
        Assert.assertThat(response
                .getStatusCode(), is(200));
    }
}
