package com.nopcommerce.pages;

import com.nopcommerce.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends Utility {
    private static final Logger log = LogManager.getLogger(LoginPage.class.getName());

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy(xpath = "//div[@class='page-title']/h1")
    WebElement welcomeText;
    @CacheLookup
    @FindBy(id = "Email")
    WebElement email;
    @CacheLookup
    @FindBy(id = "Password")
    WebElement Password;
    @CacheLookup
    @FindBy(xpath = "//button[@class='button-1 login-button']")
    WebElement loginButton;

    RegisterPage registerPage = new RegisterPage();

    public String getWelcomeText() {
        log.info("Getting text from : " + welcomeText.toString());
        return getTextFromElement(welcomeText);
    }

    public void enterEmailID() {
        new RegisterPage().enterEmail();
    }

    public void enterPassword() {
        log.info("Entering an password : " + Password.toString());
        sendTextToElement(Password, registerPage.Password);
    }

    public void clickOnLoginButton() {
        log.info("Clicking on login button : " + loginButton.toString());
        clickOnElement(loginButton);
    }

    public void enteringEmailID(String emialId) {
        log.info("Entering an invalid email : " + email.toString());
        sendTextToElement(loginButton, emialId);
    }

    public void enteringPassword(String passCode) {
        log.info("Entering password : " + Password.toString());
        sendTextToElement(Password, passCode);
    }

}
