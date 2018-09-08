package homeTaskCodeDesignPatterns.strategy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverInstance {
    private static WebDriver instance;

    public static WebDriver getInstance() {
        if (instance == null) {
            System.setProperty("webdriver.chrome.driver", "d:\\_webdriver\\chromedriver\\chromedriver.exe");
            instance = new ChromeDriver();
        }
        return instance;
    }
}
