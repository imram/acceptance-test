package features.offers.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import features.eligibility.util.MockReservationApi;
import io.restassured.response.Response;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

import static net.serenitybdd.rest.SerenityRest.rest;
import static org.hamcrest.core.Is.is;

public class BagOffersSteps {

    private Response response;
    private String recordLocator;

    @Steps
    private OffersAssetionSteps offersAssetionSteps;

    @Given("^Passenger with following reservation wants to select 1 bag and see price$")
    public void passengerWithFollowingReservationWantsToSelectBagAndSeePrice(List<Map<String, String>> passengers) throws Throwable {

        //TODO: WRITE LOGIC TO USE DATA PASSED FROM FEATURE FILE TO CREATE APPROPRIATE PNR.
        recordLocator = MockReservationApi.create(passengers);

    }

    @When("^I retrieve bag offer for above passenger$")
    public void i_retrieve_bag_offer_for_above_passenger() throws Throwable {

        response = rest()
                .header("x-clientId", "AACOM")
                //.header("X-B3-TraceId", "85c39e94b6aa8e59bd6551eaefd381f0")
                .queryParam("recordLocator", recordLocator)
                .when()
                .get("https://aa-ct-fly-merchandising-bff.mybluemix.net/viewRes/offers/PREPAID/BAG")
                .thenReturn();

    }


    @Then("^I should be able to see customer received offers with bag products$")
    public void i_should_be_able_to_see_customer_received_offers_with_bag_products() throws Throwable {
        //TODO: All the assertion in response is performed here..
        offersAssetionSteps.setResponse(response);
        offersAssetionSteps.check_status_success();
    }


}
