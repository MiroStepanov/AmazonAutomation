package steps;

import core.WebApp;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.jupiter.api.BeforeAll;

public class StepDefinitions {
    private WebApp webApp = new WebApp();

    @Given("^the user opens a web browser$")
    public void theUserOpensWebBrowser() {
        webApp.startBrowser("chrome");
    }

    @When("^the user opens amazon")
    public void theUserOpensAmazon() {
        webApp.homePage().gotoPage();
    }

    @Then("^Amazon Home Page is visible")
    public void amazonHomePageIsVisible() {
        webApp.homePage().verifyLogoIsPresent();
    }
//
//    @Then("^Owner Information page header text should be  \"([^\"]*)\"$")
//    public void ownerInformationPageHeaderTextShouldBe(String arg0) throws Throwable {
//        System.out.println("This is for test purposes only");
//    }


}
