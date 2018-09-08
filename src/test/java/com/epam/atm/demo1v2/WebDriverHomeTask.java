package com.epam.atm.demo1v2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class WebDriverHomeTask {

    private WebDriver driver;

    @BeforeTest(description = "start browser")
    public void StartBrowser() {
        System.setProperty("webdriver.chrome.driver", "d:\\_webdriver\\chromedriver\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/gmail/about/#");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test(description = "mailCreation")
    public void MailCreation () throws InterruptedException {


        WebElement SignInButton = driver.findElement(By.xpath("//div[@class='gmail-nav__nav-links-wrap']/a[@class ='gmail-nav__nav-link gmail-nav__nav-link__sign-in']"));
        SignInButton.click();

        WebElement emailInput = driver.findElement(By.cssSelector("input#identifierId.whsOnd.zHQkBf"));
        emailInput.sendKeys("viktar.kimpel@gmail.com");

        WebElement emailButton = driver.findElement(By.cssSelector("#identifierNext"));
        emailButton.click();

        WebElement gmailPasswordPage = driver.findElement(By.id("yDmH0d"));
        Assert.assertTrue(gmailPasswordPage.isDisplayed(), "Our email are invalid!");

        WebElement passwordInput = driver.findElement(By.xpath("//div[@class='Xb9hP']/input[@type='password']"));
        passwordInput.sendKeys("Imrahil1216");

        WebElement passwordButton = driver.findElement(By.cssSelector("#passwordNext"));
        passwordButton.click();

        WebElement gmailMainPage = driver.findElement(By.xpath("//body[@class='aAU']"));
        Assert.assertTrue(gmailMainPage.isDisplayed(), "Our password are invalid!");


        WebElement composeButton = driver.findElement(By.xpath("//div[text()='COMPOSE']"));
        composeButton.click();

        WebElement recipientInput = driver.findElement(By.xpath("//textarea[@name='to']"));
        recipientInput.click();
        recipientInput.sendKeys("Imrahil1216@inbox.ru");

        WebElement subjectInput = driver.findElement(By.xpath("//div[@class='aoD az6']/input[@placeholder='Subject']"));
        subjectInput.sendKeys("Test");

        WebElement bodyInput = driver.findElement(By.xpath("//div[@class='Am Al editable LW-avf']"));
        bodyInput.sendKeys("Hello, World!");

        WebElement saveAndCLoseButton = driver.findElement(By.xpath("//td[@class='Hm']/img[@class='Ha']"));
        saveAndCLoseButton.click();


        WebElement draftButton = driver.findElement(By.xpath("//span[@class='nU n1']/a[@href='https://mail.google.com/mail/u/0/#drafts']"));
        draftButton.click();

        WebElement draftButton1 = driver.findElement(By.xpath("//div[@class='yW']/font[@color='#DD4B39']"));
        Assert.assertTrue(draftButton1.isDisplayed(), "Draft is disappeared!");
        draftButton1.click();

        WebElement bodyResult = driver.findElement(By.xpath("//div[text()='Hello, World!']"));
        Assert.assertTrue(bodyResult.isDisplayed(), "Body is invalid!");

        WebElement sendButton = driver.findElement(By.xpath("//div[text()='Send']"));
        sendButton.click();

        Thread.sleep(3000);

        WebElement SentMailButton = driver.findElement(By.xpath("//a[@href='https://mail.google.com/mail/u/0/#sent']"));
        SentMailButton.click();


        WebElement draftsButton = driver.findElement(By.xpath("//a[@href='https://mail.google.com/mail/u/0/#drafts']"));
        draftsButton.click();

        WebElement noDraft = driver.findElement(By.xpath("//td[@class='TC']"));
        Assert.assertTrue(noDraft.isDisplayed(), "Draft is here!");


        WebElement imageButton = driver.findElement(By.xpath("//a[@href='https://accounts.google.com/SignOutOptions?hl=en&continue=https://mail.google.com/mail&service=mail']"));
        imageButton.click();

        WebElement SignOutButton = driver.findElement(By.xpath("//a[text()='Sign out']"));
        SignOutButton.click();

        driver.quit();
    }

    @AfterTest(description = "closed browser")
        public void kill() {
            driver.quit();
            System.out.println("Browse was successfully quited");

        }
    }
