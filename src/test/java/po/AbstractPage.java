package po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Tec.by on 22.07.2018.
 */
public class AbstractPage {
    protected WebDriver driver;
    private static final int WAIT_FOR_ELEMENT_SECONDS = 10;

    public AbstractPage (WebDriver driver){
        this.driver= driver;
    }

    protected void waitForElementVisible (By locator){
        new WebDriverWait(driver, WAIT_FOR_ELEMENT_SECONDS ).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }
    protected void waitForElementPresent (By locator){
        new WebDriverWait(driver, WAIT_FOR_ELEMENT_SECONDS ).until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
    }
    protected void waitForElementClickable (By locator){
        new WebDriverWait(driver, WAIT_FOR_ELEMENT_SECONDS ).until(ExpectedConditions.elementToBeClickable(locator));
    }

}
