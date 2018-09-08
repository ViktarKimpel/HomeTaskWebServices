package po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class HomePage extends AbstractPage {

    private static final By SEARCH_IMPUT_LOCATOR = By.cssSelector("#twotabsearchtextbox");
    private static final By GO_BUTTON_LOCATOR = By.xpath("//*[@value='Go']");
    private static final String URL = "Http://amazon.com";

    public HomePage (WebDriver driver){
        super(driver);
    }

    public void open(){
        driver.get(URL);
    }

    public void fillSearchInput (String query){
        waitForElementVisible(SEARCH_IMPUT_LOCATOR);
       WebElement input = driver.findElement(SEARCH_IMPUT_LOCATOR) ;
        input.sendKeys(query);
    }
    public SearchResultPage pressGo (){
        waitForElementVisible(GO_BUTTON_LOCATOR);
        driver.findElement (GO_BUTTON_LOCATOR).click();
        return new SearchResultPage(driver);
    }
}
