package homeTaskPatterns.pages;

import homeTaskPatterns.businessObjects.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;




public class LogInPage extends AbstractedPage {

    private static final By EMAIL_INPUT_LOCATOR = By.cssSelector("input#identifierId.whsOnd.zHQkBf");
    private static final By NEXT_BUTTON_LOCATOR = By.cssSelector("#identifierNext");


    public LogInPage (WebDriver driver)
    {
        super(driver);
    }

    public LogInPage fillEmailInput (User user){
        waitForElementVisible(EMAIL_INPUT_LOCATOR);
        driver.findElement(EMAIL_INPUT_LOCATOR).sendKeys(user.getLogin()) ;
        return this;
    }

    public GmailPasswordPage pressNextButton (){
        waitForElementVisible(NEXT_BUTTON_LOCATOR);
        driver.findElement (NEXT_BUTTON_LOCATOR).click();
        return new GmailPasswordPage(driver);
    }
}
