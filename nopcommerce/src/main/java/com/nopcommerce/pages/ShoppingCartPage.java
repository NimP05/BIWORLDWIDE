package com.nopcommerce.pages;

import com.nopcommerce.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage extends Utility {
    private static final Logger log = LogManager.getLogger(ShoppingCartPage.class.getName());

    public ShoppingCartPage() {
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy(xpath = "//div[@class='page-title']/h1")
    WebElement pageTitle;
    @CacheLookup
    @FindBy(id = "termsofservice")
    WebElement termsCheckBox;
    @CacheLookup
    @FindBy(id = "checkout")
    WebElement checkoutButton;

    public String getTitleOfThePage() {
        log.info("Getting title of the page : " + pageTitle.toString());
        return getTextFromElement(pageTitle);
    }

    public void selectCheckBoxTermsOfServices() {
        log.info("Agree terms of services check box : " + termsCheckBox.toString());
        clickOnElement(termsCheckBox);
    }

    public void clickOnCheckoutButton() {
        log.info("Clicking on checkout button : " + checkoutButton.toString());
        clickOnElement(checkoutButton);
    }
}
