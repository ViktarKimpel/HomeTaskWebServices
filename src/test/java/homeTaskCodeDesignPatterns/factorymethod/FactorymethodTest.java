package homeTaskCodeDesignPatterns.factorymethod;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class FactorymethodTest {

    @Test
    public void test() {
        ChromeBrowser browser = new ChromeBrowser(); // can be FireFoxBrowser
        WebDriver driver = browser.createWebDriver();
        driver.navigate().to("https://www.google.com/gmail/about/#");
        driver.quit();
    }
}
