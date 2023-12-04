package com.nopcommerce.cucumber.steps;

import com.nopcommerce.pages.HomePage;
import com.nopcommerce.pages.LoginPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;

public class LoginSteps {
    @When("^I click on login link$")
    public void iClickOnLoginLink() {
        new HomePage().clickOnLoginLink();
    }

    @And("^I am on login page$")
    public void iAmOnLoginPage() {
    }

    @Then("^I should navigate to login page successfully$")
    public void iShouldNavigateToLoginPageSuccessfully() {
        String expectedMessage = "Welcome, Please Sign In!";
        String actualMessage = new LoginPage().getWelcomeText();
        Assert.assertEquals(actualMessage, expectedMessage, "Login page is not displayed");
    }

    @And("^I enter an email$")
    public void iEnterAnEmail() {
        new LoginPage().enterEmailID();
    }

    @And("^I enter password$")
    public void iEnterPassword() {
        new LoginPage().enterPassword();
    }

    @And("^I click on login button$")
    public void iClickOnLoginButton() {
        new LoginPage().clickOnLoginButton();
    }

    @Then("^I should login successfully$")
    public void iShouldLoginSuccessfully() {
    }

    @When("^I enter an email\"([^\"]*)\"$")
    public void iEnterAnEmail(String emailID) {
        new LoginPage().enteringEmailID(emailID);
    }

    @And("^I enter password \"([^\"]*)\"$")
    public void iEnterPassword(String password) {
        new LoginPage().enteringPassword(password);
    }
}
