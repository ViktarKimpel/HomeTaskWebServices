package homeTaskPatterns.stepsdefs;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import homeTaskPatterns.businessObjects.User;
import homeTaskPatterns.pages.GmailMainPage;
import homeTaskPatterns.pages.GmailPasswordPage;
import homeTaskPatterns.pages.LogInPage;
import homeTaskPatterns.pages.StartPage;
import org.testng.Assert;

import static homeTaskPatterns.WebDriver.GmailWebDriver.getDriver;


public class GmailStepsDefs {
    @Given("I opened StartPage")
    public void iOpenedStartPage() {
        new StartPage(getDriver()).openGmail();
    }

    @When("^I opened LogInPage$")
    public void iOpenedLogInPage() {
        new StartPage(getDriver()).signIn();
    }

    @And("^I entered email")
    public void iEnteredEmail() {
        new LogInPage(getDriver()).fillEmailInput(new User()).pressNextButton();
    }

    @And("^I opened GmailPasswordPage$")
    public void iOpenedGmailPasswordPage() {
        new GmailPasswordPage(getDriver());
    }


    @And("^I entered password$")
    public void iEnteredPassword() {
        new GmailPasswordPage(getDriver()).fillGmailPasswordInput(new User()).pressNextButton();
    }

    @Then("^I opened GmailMainPage$")
    public void iOpenedGmailMainPage() {
        new GmailMainPage(getDriver());
        Assert.assertTrue(getDriver().getTitle().contains("viktar.kimpel@gmail.com"),
                "You have not login to your account");
    }






   /* @And("^I entered \"([^\"]*)\"$")
    public void iEntered(String email) {
        new LogInPage(getDriver()).fillEmailInput(new User()).pressNextButton();
    }*/
}
