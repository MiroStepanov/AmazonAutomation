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

    @FindBy(how = How.XPATH, using = "(//a[@class='a-link-normal a-text-normal'])[3]")
    private WebElement firstResultTitle;

    @FindBy(how = How.XPATH, using = "(//span[@class='a-badge-text'])[3]")
    private WebElement firstResultBadge;

    @FindBy(how = How.XPATH, using = "//(a[@class='a-size-base a-link-normal a-text-bold'])[3]")
    private WebElement firstResultType;

    @FindBy(how = How.XPATH, using = "(//span[@class='a-price'])[3]")
    private WebElement firstResultPrice;

    @FindBy(how = How.XPATH, using = "//span[@id='productTitle']")
    private WebElement bookDetailsTitle;

    @FindBy(how = How.XPATH, using ="//a[@class='badge-link']")
    private WebElement bookDetailsBadge;

    @FindBy(how = How.XPATH, using ="//a[@class='a-button-text']")
    private WebElement bookDetailsType;

    @FindBy(how = How.XPATH, using ="//span[@class='offer-price']")
    private WebElement bookDetailsPrice;

    @FindBy(how = How.XPATH, using ="//input[@id='add-to-cart-button']")
    private WebElement addToBasketButton;



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
        Assertions.assertTrue(getText(firstResultTitle).contains( title ), "First result was different " + getText(firstResultTitle));
    }

    public void verifyBadge(String badge) {
        LOGGER.info( "Verifying the badge is " + badge );
        Assertions.assertTrue(getText(firstResultBadge).contains(badge), "Badge was different " + getText(firstResultBadge));
    }

    public void verifyType(String type) {
        LOGGER.info( "Verifying the type is " + type );
        Assertions.assertTrue(getText(firstResultType).contains(type) , "Type was different " + getText(firstResultType));
    }

    public void verifyPrice(String price) {
        LOGGER.info( "Verifying the price is " + price );
        Assertions.assertTrue(getText(firstResultPrice).contains (price) , "Price was different " + getText(firstResultPrice));
    }

    public void clickFirstResultTitle() {
        click(firstResultTitle);
    }

    public void verifyTitle(String title) {
        LOGGER.info("Verifying the book result title is " + title);
        Assertions.assertTrue(getText(bookDetailsTitle).contains(title), "Title was different " + getText(bookDetailsTitle));
    }

    public void verifyBadgeIsCorrect(String badge) {
        LOGGER.info( "Verifying the badge is " + badge );
        Assertions.assertTrue(getText(bookDetailsBadge).contains(badge), "Badge was different " + getText(bookDetailsBadge));
    }

    public void verifyTypeIsCorrect(String type) {
        LOGGER.info( "Verifying the type is " + type );
        Assertions.assertTrue(getText(bookDetailsType).contains(type) , "Type was different " + getText(bookDetailsType));
    }

    public void verifyPriceIsCorrect(String price) {
        LOGGER.info( "Verifying the price is " + price );
        Assertions.assertTrue(getText(bookDetailsPrice).contains (price) , "Price was different " + getText(bookDetailsPrice));
    }

    public void clickAddToBasketButto() {
        click(addToBasketButton);
    }

    public void verifyuserIsonbasketDetails() {
        Assertions.assertTrue(getTitle().contains( "Shopping Basket" ) , "Title was different " + getTitle());
    }

}
