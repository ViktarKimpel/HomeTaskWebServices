package homeTaskCodeDesignPatterns.decorator;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WebDriverDecoratorTest {
    private WebDriver driver;

    @Test
    public void decoratorDriver() {
        System.setProperty("webdriver.chrome.driver", "d:\\_webdriver\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("https://www.google.com/gmail/about/#");
        driver.findElement(By.xpath("//div[@class='gmail-nav__nav-links-wrap']/a[@class ='gmail-nav__nav-link gmail-nav__nav-link__sign-in']")).click();
        driver.quit();
    }
}
