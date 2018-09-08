package homeTaskPatterns.WebDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class GmailWebDriver {
    private static WebDriver driver;

    private static WebDriver createWebDriverInstance() {
        System.setProperty("webdriver.chrome.driver", "d:\\_webdriver\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        return driver;
    }

    public static WebDriver getDriver() {
        if(driver == null){
            createWebDriverInstance();
        }
        return driver;
    }

}