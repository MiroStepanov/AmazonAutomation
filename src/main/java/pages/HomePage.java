package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HomePage extends BasePage {
    private static final Logger LOGGER = LoggerFactory.getLogger(HomePage.class);
    private static final String PAGE_URL = "/";

    @FindBy(how = How.XPATH, using = "//div[@id='nav-logo']")
    private WebElement logo;

    @FindBy(how = How.XPATH, using = "//input[@id='twotabsearchtextbox']")
    private WebElement searchInput;

    @FindBy(how = How.XPATH, using = "//a[@class='a-link-normal a-text-normal']")
    private WebElement firtResultTitle;

    @FindBy(how = How.XPATH, using = "//span[@class='a-badge-text']")
    private WebElement firtResultBadge;

    @FindBy(how = How.XPATH, using = "//a[@class='a-size-base a-link-normal a-text-bold']")
    private WebElement firtResultType;

    @FindBy(how = How.XPATH, using = "//span[@class='a-price']")
    private WebElement firtResultPrice;



    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void gotoPage() {
        LOGGER.info("Navigate to:" + BASE_URL + PAGE_URL);
        navigateTo(PAGE_URL);
    }

    public void verifyLogoIsPresent() {
        LOGGER.info("Verifying logo is present");
        Assertions.assertTrue(logo.isDisplayed(), "Logo is not present");
    }

    public void search(String query) {
        LOGGER.info("Searching for " + query);
        typeText(searchInput, query);
        searchInput.sendKeys( Keys.ENTER);
    }

    public void verifyFirstResultTitle(String title) {
        LOGGER.info( "Verifying the first result is " + title );
        Assertions.assertTrue(getText(firtResultTitle).contains( title ), "First result was different " + getText(firtResultTitle));
    }

    public void verifyBadge(String badge) {
        LOGGER.info( "Verifying the badge is " + badge );
        Assertions.assertTrue(getText(firtResultBadge).contains(badge), "Badge was different " + getText(firtResultBadge));
    }

    public void verifyType(String type) {
        LOGGER.info( "Verifying the type is " + type );
        Assertions.assertTrue(getText(firtResultType).contains(type) , "Type was different " + getText(firtResultType));
    }

    public void verifyPrice(String price) {
        LOGGER.info( "Verifying the price is " + price );
        Assertions.assertTrue(getText(firtResultPrice).contains (price) , "Price was different " + getText(firtResultPrice));
    }
}
