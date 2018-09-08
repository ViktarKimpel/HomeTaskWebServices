package po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class ItemPage extends AbstractPage {

    private static final By ITEM_PRICE_LOCATOR = By.cssSelector("#priceblock_ourprice");


    public ItemPage (WebDriver driver){
            super(driver);
        }

    public Double getItemPrice (){
        waitForElementVisible(ITEM_PRICE_LOCATOR);
        return Double.parseDouble(driver.findElement(ITEM_PRICE_LOCATOR).getText().substring(1)) ;

    }

}
