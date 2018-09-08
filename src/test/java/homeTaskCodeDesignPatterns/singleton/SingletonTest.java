package homeTaskCodeDesignPatterns.singleton;

import org.testng.annotations.Test;

public class SingletonTest {

    @Test
    public void gmailTest()
    {
        WebDriverSingleton.getWebDriver().navigate().to("https://www.google.com/gmail/about/#");
        WebDriverSingleton.getWebDriver().quit();
    }

}
