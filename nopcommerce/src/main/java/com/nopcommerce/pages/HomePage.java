package com.nopcommerce.pages;

import com.nopcommerce.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends Utility {
    private static final Logger log = LogManager.getLogger(HomePage.class.getName());

    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy(linkText = "Register")
    WebElement registerLink;

    @CacheLookup
    @FindBy(linkText = "Log in")
    WebElement loginLink;

    @CacheLookup
    @FindBy(xpath = "//div[@class='header-menu']/ul/li")
    WebElement headerMenuTabs;
    @CacheLookup
    @FindBy(xpath = "//ul[@class='top-menu notmobile']/li//ul/li[2]/a")
    WebElement subDepartment;


    public void clickOnRegisterLink() {
        log.info("Clicking on register link : " + registerLink.toString());
        clickOnElement(registerLink);
    }

    public void clickOnLoginLink() {
        log.info("Clicking on login link : " + loginLink.toString());
        clickOnElement(loginLink);
    }

    public void selectDepartmentFromHeaderMenu() {
        mouseHoverToElement(headerMenuTabs);
    }

    public void selectSubDepartment() {
        clickOnElement(subDepartment);
    }
}