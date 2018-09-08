package po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AmazonTest {
    private WebDriver driver;

    @BeforeClass (description = "Start browser")

    private void initBrowser(){
     System.setProperty("webdriver.chrome.driver", "d:\\_webdriver\\chromedriver\\chromedriver.exe");
     driver = new ChromeDriver();
    driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.manage().window().maximize();
}

    @Test (description = "Amazon search test" )

    public void amazonSearchTest(){
    HomePage homePage = new HomePage(driver);
    homePage.open();
    homePage.fillSearchInput("Iphone SE");
    SearchResultPage searchResultPage = homePage.pressGo();
     ItemPage itemPage = searchResultPage.openFirstItem();
     Double iphonePrice = itemPage.getItemPrice();
        Assert.assertTrue(iphonePrice<200, "Iphone SE costs more than $200, go and work more :)");
    }

    @AfterClass (description = "Close browser")

    public void kill(){
        driver.quit();
    }
}
