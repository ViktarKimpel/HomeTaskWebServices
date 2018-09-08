package homeTaskCodeDesignPatterns.factorymethod;


import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeBrowser  {

        public org.openqa.selenium.WebDriver createWebDriver() {
            System.setProperty("webdriver.chrome.driver", "d:\\_webdriver\\chromedriver\\chromedriver.exe");
            return new ChromeDriver();
        }
    }
