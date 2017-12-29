package features.offers.steps;

import io.restassured.response.Response;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.junit.Assert;

import static org.hamcrest.core.Is.is;

public class OffersAssetionSteps extends ScenarioSteps {
    private Response response;

    @Step
    @Pending
    public void check_status_success(){
        Assert.assertThat(response
                .getStatusCode(), is(200));
    }

    public void setResponse(Response response) {
        this.response = response;
    }
}
