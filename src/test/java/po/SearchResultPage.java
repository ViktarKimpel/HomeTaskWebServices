package po;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultPage extends AbstractPage {

    private static final By FIRST_RESULT_LINK_LOCATOR = By.cssSelector("#result_0 a.s-access-details-page");



    public SearchResultPage (WebDriver driver){
        super(driver);
    }
    public ItemPage openFirstItem (){

        waitForElementVisible(FIRST_RESULT_LINK_LOCATOR);
        driver.findElement(FIRST_RESULT_LINK_LOCATOR).click();
        return new ItemPage (driver);
    }
}
