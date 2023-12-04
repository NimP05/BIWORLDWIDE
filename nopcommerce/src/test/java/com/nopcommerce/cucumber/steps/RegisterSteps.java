package com.nopcommerce.cucumber.steps;

import com.nopcommerce.pages.HomePage;
import com.nopcommerce.pages.RegisterPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;

public class RegisterSteps {
    @Given("^I am on homepage$")
    public void iAmOnHomepage() {
    }

    @When("^I click on register link$")
    public void iClickOnRegisterLink() {
        new HomePage().clickOnRegisterLink();
    }


    @And("^I enter following users details firstname,lastname, email, password, confirmPassword$")
    public void iEnterFollowingUsersDetailsFirstnameLastnameEmailPasswordConfirmPassword() {
        new RegisterPage().enterFirstName();
        new RegisterPage().enterLastName();
        new RegisterPage().enterEmail();
        new RegisterPage().enterPassword();
        new RegisterPage().reConfirmPassword();
    }

    @Then("^I click on register button$")
    public void iClickOnRegisterButton() {
        new RegisterPage().clickOnRegisterButton();
    }

    @Then("^Verify message \"([^\"]*)\"$")
    public void verifyMessage(String expectedMessage) {
        String actualMessage = new RegisterPage().verifyRegistrationSuccessMessage();
        Assert.assertEquals(actualMessage, expectedMessage, "Registration is not successful");
    }
}
