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

    @Given("^the user is on Amazon Home Page")
    public void theUserIsOnAmazonPage() {
        webApp.startBrowser("chrome");
        webApp.homePage().gotoPage();
    }

    @When("^the user enters \"([^\"]*)\" into the Amazon Search Bar and presses enter")
    public void enterTextIntoSearchBar(String query) {
        webApp.homePage().search( query );
    }

    @When("^first result is \"([^\"]*)\"")
    public void firstResultIs(String title) {
        webApp.homePage().verifyFirstResultTitle(title);
    }

    @When("^the item has badge \"([^\"]*)\"")
    public void itemHasBadge(String badge) {
        webApp.homePage().verifyBadge( badge );
    }

    @When("^the item type should be \"([^\"]*)\"")
    public void itemHasType(String type) {
        webApp.homePage().verifyType( type );
    }

    @When("^the item price should be \"([^\"]*)\"")
    public void itemHasPrice(String price) {
        webApp.homePage().verifyPrice( price );
    }
}
