package com.nopcommerce.pages;

import com.nopcommerce.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage extends Utility {
    private static final Logger log = LogManager.getLogger(CheckoutPage.class.getName());

    public CheckoutPage() {
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy(xpath = "//div[@class='page-title']/h1")
    WebElement pageTitle;
    @CacheLookup
    @FindBy(id = "BillingNewAddress_CountryId")
    WebElement country;
    @CacheLookup
    @FindBy(id = "BillingNewAddress_City")
    WebElement city;
    @CacheLookup
    @FindBy(id = "BillingNewAddress_Address1")
    WebElement address;
    @CacheLookup
    @FindBy(id = "BillingNewAddress_ZipPostalCode")
    WebElement postcode;
    @CacheLookup
    @FindBy(id = "BillingNewAddress_PhoneNumber")
    WebElement phone;
    @CacheLookup
    @FindBy(xpath = "//div[@id='billing-buttons-container']/button[4]")
    WebElement continueButton;
    @CacheLookup
    @FindBy(xpath = "//button[@class='button-1 shipping-method-next-step-button']")
    WebElement shippingContinueButton;
    @CacheLookup
    @FindBy(xpath = "//div[@class='payment-details']/input")
    WebElement paymentCheck;
    @CacheLookup
    @FindBy(xpath = "//div[@id='payment-method-buttons-container']/button")
    WebElement paymentContinueButton;
    @CacheLookup
    @FindBy(xpath = "//button[@class='button-1 payment-info-next-step-button']")
    WebElement paymentInfoContinueButton;
    @CacheLookup
    @FindBy(xpath = "//button[@class='button-1 confirm-order-next-step-button']")
    WebElement confirmOrderContinueButton;
    @CacheLookup
    @FindBy(xpath = "//div[@class='page checkout-page order-completed-page']/div[2]/div/div/strong")
    WebElement orderPlacedMessage;

    @CacheLookup
    @FindBy(linkText = "Click here for order details.")
    WebElement orderDetailsLink;

    public String titleOfPage() {
        log.info("Getting title of page : " + pageTitle.toString());
        return getTextFromElement(pageTitle);
    }

    public void selectCountry(String nameOfCountry) {
        log.info("Selecting country : " + country.toString());
        selectByVisibleTextFromDropDown(country, nameOfCountry);
    }

    public void addNameOfCity(String nameOfCity) {
        log.info("Entering city name : " + city.toString());
        sendTextToElement(city, nameOfCity);
    }

    public void addAddressLine(String addressLine) {
        log.info("Enter an address : " + address.toString());
        sendTextToElement(address, addressLine);
    }

    public void addPostalCode(String zipCode) {
        log.info("Entering city name : " + postcode.toString());
        sendTextToElement(postcode, zipCode);
    }

    public void addPoneNumber(String telephone) {
        log.info("Entering city name : " + phone.toString());
        sendTextToElement(phone, telephone);
    }

    public void clickOnContinueButton() {
        log.info("Clicking on continue button : " + continueButton.toString());
        clickOnElement(continueButton);
    }

    public void clickOnShippingContinueButton() {
        log.info("Clicking on continue button : " + shippingContinueButton.toString());
        clickOnElement(shippingContinueButton);
    }

    public void selectPaymentRadioButton() {
        log.info("Selecting payment radio button : " + paymentCheck.toString());
        clickOnElement(paymentCheck);
    }

    public void clickOnPaymentContinueButton() {
        log.info("Clicking on payment method continue button : " + paymentContinueButton.toString());
        clickOnElement(paymentContinueButton);
    }

    public void clickOnPaymentInfoContinueButton() {
        log.info("Clicking on payment info continue button : " + paymentInfoContinueButton.toString());
        clickOnElement(paymentInfoContinueButton);
    }

    public void clickOnConfirmOrderContinueButton() {
        log.info("Clicking on confirm order continue button : " + confirmOrderContinueButton.toString());
        clickOnElement(confirmOrderContinueButton);
    }

    public String orderPlacedSuccessfulMessage() {
        log.info("Verify order placed successfully : " + orderPlacedMessage.toString());
        return getTextFromElement(orderPlacedMessage);
    }

    public void clickOnOrderDetailsLink() {
        log.info("click on order details link : " + orderDetailsLink.toString());
        clickOnElement(orderDetailsLink);
    }
}
