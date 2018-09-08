package homeTaskPatterns.tests;

import homeTaskPatterns.businessObjects.User;
import homeTaskPatterns.pages.GmailMainPage;
import homeTaskPatterns.pages.GmailPasswordPage;
import homeTaskPatterns.pages.LogInPage;
import homeTaskPatterns.pages.StartPage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import static homeTaskPatterns.WebDriver.GmailWebDriver.getDriver;
import static homeTaskPatterns.utils.RandomNumber.DEFAULT_INTERVAL_INT;
import static homeTaskPatterns.utils.RandomNumber.getRandomInt;


public class GmailTest {

    private GmailMainPage gmailMainPage;

    @BeforeTest
    public void AStartBrowser() {
        System.setProperty("webdriver.chrome.driver", "d:\\_webdriver\\chromedriver\\chromedriver.exe");
        /*try {
            driver = new RemoteWebDriver(new URL("http://192.168.0.104:4444/wd/hub"), DesiredCapabilities.chrome());
        }
        catch (MalformedURLException e) {
            e.printStackTrace();
        }*/
    }
    @Test
    public void LoggedInIntoGmail() {
        StartPage startPage = new StartPage(getDriver());
        startPage.openGmail();
        LogInPage logInPage = startPage.signIn();
        logInPage.fillEmailInput(new User());
        GmailPasswordPage gmailPasswordPage = logInPage.pressNextButton();
        gmailPasswordPage.fillGmailPasswordInput(new User());
        gmailMainPage = gmailPasswordPage.pressNextButton();
        /*gmailMainPage.waitForElementVisible(By.xpath("//div[text()='COMPOSE']"));*/
        Assert.assertTrue(getDriver().getTitle().contains("viktar.kimpel@gmail.com"),
                "You have not login to your account");
           }

           @Test(dependsOnMethods = {"LoggedInIntoGmail"})
           public void CreateDraftMessage() {
        gmailMainPage.doubleClick();
        gmailMainPage.starredButton();
        gmailMainPage.pressComposeButton();
        gmailMainPage.recipientInput("Imrahil1216@inbox.ru");
        gmailMainPage.subjectInput("Test");
        gmailMainPage.bodyInput("Hello, World!");
        gmailMainPage.saveAndCloseButton();
        gmailMainPage.draftMailButton();
        gmailMainPage.draftButton();
        gmailMainPage.bodyResult();
        Assert.assertTrue(getDriver().getTitle().contains("viktar.kimpel@gmail.com"),
                "You have invalid email");
           }

           @Test(dependsOnMethods = {"CreateDraftMessage"})
           public void VerifyDraftMessage() {
        gmailMainPage.sendButton();
        gmailMainPage.sentMailButton();
        gmailMainPage.draftsButton();
        gmailMainPage.noDraftsButton();
        gmailMainPage.pressComposeButton();
        gmailMainPage.recipientInput("Imrahil1216@inbox.ru");
        gmailMainPage.subjectInput("Test");
        gmailMainPage.bodyInput(getRandomInt(DEFAULT_INTERVAL_INT));
           }

           @Test(dependsOnMethods = {"VerifyDraftMessage"})
           public void SendGmail() {
        gmailMainPage.sendButton();
        gmailMainPage.imageButton();
        gmailMainPage.signOutButton();
          }

        @AfterClass

        public void kill () {
            getDriver().quit();
        }
    }
