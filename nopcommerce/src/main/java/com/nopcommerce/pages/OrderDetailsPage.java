package com.nopcommerce.pages;

import com.nopcommerce.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderDetailsPage extends Utility {
    private static final Logger log = LogManager.getLogger(OrderDetailsPage.class.getName());

    public OrderDetailsPage() {
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy(xpath = "//div[@class='page-title']/h1")
    WebElement pageTitle;
    @CacheLookup
    @FindBy(xpath = "//div[@class='page-title']/a")
    WebElement printButton;

    public String titleOfPage() {
        log.info("Getting title of page : " + pageTitle.toString());
        return getTextFromElement(pageTitle);
    }

    public void clickOnPrintOrderButton() {
        log.info("Clicking on print button : " + printButton.toString());
        clickOnElement(printButton);
    }

}