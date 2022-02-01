package co.com.heison_test.stepdefinitions;

import static co.com.heison_test.models.builders.EmployeeDataBuilder.*;
import co.com.heison_test.tasks.Login;
import co.com.heison_test.tasks.Navigate;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import static net.serenitybdd.screenplay.actors.OnStage.*;

public class LoginStepDefinition {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginStepDefinition.class);

    @Managed
    private WebDriver hisBrowser;

    @Before
    public void setUp(){
        setTheStage(OnlineCast.ofStandardActors());
        theActorCalled("Employee");
        theActorInTheSpotlight().can(BrowseTheWeb.with(hisBrowser));
    }

    @Given("^the employee opens the web page$")
    public void theEmployeeOpensTheWebPage() {
        theActorInTheSpotlight().wasAbleTo(Navigate.theHeisonPage());
    }

    @When("^he enter your credentials$")
    public void heEnterYourCredentials() {
        theActorInTheSpotlight().attemptsTo(Login.inTheApp(withEmployeeCalled().victor()));
    }

    @Then("^he should see the main page$")
    public void heShouldSeeTheMainPage() {

    }
}
