package com.nopcommerce.pages;

import com.github.javafaker.Faker;
import com.nopcommerce.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage extends Utility {
    private static final Logger log = LogManager.getLogger(RegisterPage.class.getName());

    public RegisterPage() {
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy(id = "FirstName")
    WebElement firstname;

    @CacheLookup
    @FindBy(id = "LastName")
    WebElement lastname;

    @CacheLookup
    @FindBy(id = "Email")
    WebElement email;

    @CacheLookup
    @FindBy(id = "Password")
    WebElement password;

    @CacheLookup
    @FindBy(id = "ConfirmPassword")
    WebElement confirmPassword;

    @CacheLookup
    @FindBy(id = "register-button")
    WebElement registerButton;
    @CacheLookup
    @FindBy(xpath = "//div[@class='result']")
    WebElement registrationMessage;

    static Faker faker = new Faker();
    public String Password = "123456";
    static String firstName = faker.name().firstName();
    static String lastName = faker.name().lastName();
    public String Email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@gmail.com";


    public void enterFirstName() {
        sendTextToElement(firstname, firstName);
        log.info("Entering firstname : " + firstname.toString());
    }

    public void enterLastName() {
        sendTextToElement(lastname, lastName);
        log.info("Entering lastname to filed : " + lastname.toString());
    }

    public void enterEmail() {
        sendTextToElement(email, Email);
        log.info("Entering an email to email field : " + email.toString());
    }

    public void enterPassword() {
        sendTextToElement(password, Password);
    }

    public void reConfirmPassword() {
        sendTextToElement(confirmPassword, Password);
    }

    public void clickOnRegisterButton() {
        clickOnElement(registerButton);
    }

    public String verifyRegistrationSuccessMessage() {
        log.info("Registration successful message : " + registrationMessage.toString());
        return getTextFromElement(registrationMessage);
    }
}
