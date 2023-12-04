package com.nopcommerce.cucumber.steps;

import com.nopcommerce.pages.*;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;

public class ProductSteps {

    @When("^I select product department Computers$")
    public void iSelectProductDepartmentComputers() {
        new HomePage().selectDepartmentFromHeaderMenu();
    }


    @And("^I click on sub department Notebooks$")
    public void iClickOnSubDepartmentNotebooks() {
        new HomePage().selectSubDepartment();
    }

    @Then("^I should navigate to department page successfully$")
    public void iShouldNavigateToDepartmentPageSuccessfully() {
        String expectedTitle = "Notebooks";
        String actualTitle = new ProductPage().titleOfPage();
        Assert.assertEquals(expectedTitle, actualTitle, "Title does not match");
    }

    @And("^I click on product \"([^\"]*)\"$")
    public void iClickOnProduct(String product) {
        new ProductPage().selectProduct(product);
    }

    @Then("^I should navigate to selected product successfully$")
    public void iShouldNavigateToSelectedProductSuccessfully() {
    }

    @And("^I click on Add product to cart button$")
    public void iClickOnAddProductToCartButton() {
        new ProductPage().clickOnAddToCartButton();
    }

    @Then("^verify message product is added to cart \"([^\"]*)\"$")
    public void verifyMessageProductIsAddedToCart(String expectedMessage) {
        String actualMessage = new ProductPage().productAddedToCart();
        Assert.assertEquals(expectedMessage, actualMessage, "message does not match");
    }

    @Then("^I click on shopping cart$")
    public void iClickOnShoppingCart() {
        new ProductPage().clickOnShoppingCart();
    }

    @Then("^I should navigate to shopping cart page successfully$")
    public void iShouldNavigateToShoppingCartPageSuccessfully() {
        String expectedTitle = "Shopping cart";
        String actualTitle = new ShoppingCartPage().getTitleOfThePage();
        Assert.assertEquals(expectedTitle, actualTitle, "Page tile doesn't match");
    }

    @And("^I select check box of terms of services$")
    public void iSelectCheckBoxOfTermsOfServices() {
        new ShoppingCartPage().selectCheckBoxTermsOfServices();
    }

    @And("^I click on checkout button$")
    public void iClickOnCheckoutButton() {
        new ShoppingCartPage().clickOnCheckoutButton();
    }

    @Then("^I should navigate to login page$")
    public void iShouldNavigateToLoginPage() {
        String expectedMessage = "Welcome, Please Sign In!";
        String actualMessage = new LoginPage().getWelcomeText();
        Assert.assertEquals(actualMessage, expectedMessage, "Login page is not displayed");
    }

    @Then("^I should navigate to Checkout page$")
    public void iShouldNavigateToCheckoutPage() {
        String expectedTitle = "Checkout";
        String actualTitle = new CheckoutPage().titleOfPage();
        Assert.assertEquals(expectedTitle, actualTitle, "Page title doesn't match");
    }

    @And("^I select country \"([^\"]*)\"$")
    public void iSelectCountry(String countryName) {
        new CheckoutPage().selectCountry(countryName);
    }

    @And("^I enter city \"([^\"]*)\"$")
    public void iEnterCity(String nameOfCity) {
        new CheckoutPage().addNameOfCity(nameOfCity);
    }

    @And("^I enter an address \"([^\"]*)\"$")
    public void iEnterAnAddress(String addressLine) {
        new CheckoutPage().addAddressLine(addressLine);
    }

    @And("^I enter postal code \"([^\"]*)\"$")
    public void iEnterPostalCode(String postcode) {
        new CheckoutPage().addPostalCode(postcode);
    }

    @And("^I enter phone number \"([^\"]*)\"$")
    public void iEnterPhoneNumber(String phoneNumber) {
        new CheckoutPage().addPoneNumber(phoneNumber);
    }

    @And("^Click on continue button$")
    public void clickOnContinueButton() {
        new CheckoutPage().clickOnContinueButton();
    }

    @And("^Click on shipping continue button$")
    public void clickOnShippingContinueButton() {
        new CheckoutPage().clickOnShippingContinueButton();
    }

    @And("^Select payment method by Check / Money order$")
    public void selectPaymentMethodByCheckMoneyOrder() {
        new CheckoutPage().selectPaymentRadioButton();
    }

    @And("^Click on payment continue button$")
    public void clickOnPaymentContinueButton() {
        new CheckoutPage().clickOnPaymentContinueButton();
    }

    @Then("^Check payment information$")
    public void checkPaymentInformation() {
    }

    @And("^Click on payment information continue button$")
    public void clickOnPaymentInformationContinueButton() {
        new CheckoutPage().clickOnPaymentInfoContinueButton();
    }

    @Then("^Check billing address and shipping address$")
    public void checkBillingAddressAndShippingAddress() {
    }

    @And("^Click on confirm order continue button$")
    public void clickOnConfirmOrderContinueButton() {
        new CheckoutPage().clickOnConfirmOrderContinueButton();
    }

    @Then("^I should navigate to order completed page$")
    public void iShouldNavigateToOrderCompletedPage() {
    }


    @Then("^I should see message \"([^\"]*)\"$")
    public void iShouldSeeMessage(String expectedMessage) {
        String actualMessage = new CheckoutPage().orderPlacedSuccessfulMessage();
        Assert.assertEquals(expectedMessage, actualMessage, "Message doesn't match");
    }

    @And("^I click on click here for order details link$")
    public void iClickOnClickHereForOrderDetailsLink() {
        new CheckoutPage().clickOnOrderDetailsLink();
    }

    @Then("^I should navigate to order information page$")
    public void iShouldNavigateToOrderInformationPage() {
        String expectedTitle = "Order information";
        String actualTitle = new OrderDetailsPage().titleOfPage();
        Assert.assertEquals(expectedTitle, actualTitle, "Page title doesn't match");
    }

}
