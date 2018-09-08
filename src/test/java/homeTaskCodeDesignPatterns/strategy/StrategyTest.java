package homeTaskCodeDesignPatterns.strategy;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class StrategyTest {
    LogInContext logInContext = new LogInContext();

    @BeforeTest
    public void before() {
        WebDriverInstance.getInstance().navigate().to("https://www.google.com/gmail/about/#");
    }

    @Test
    public void testUserFirst() {
        assertLogIn(new UserFirst("viktar.kimpel@gmail.com", "Imrahil1216@inbox.ru"));
    }

    @Test
    public void testUserSecond() {
        assertLogIn(new UserSecond("viktarr.kimpell@gmail.com", "Imrahil1216@inbox.ru"));
    }

    private void assertLogIn(LogInStrategy logInStrategy) {
        logInContext.setLogInStrategy(logInStrategy);
        logInContext.login();
        Assert.assertFalse(WebDriverInstance.getInstance()
                .findElements(By.xpath(("//*[@id=\"gb\"]/div[2]/div[1]/div[4]/div/a"))).isEmpty(),"Log in was not completed");
    }
}
