package com.nopcommerce.pages;

import com.nopcommerce.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductPage extends Utility {
    private static final Logger log = LogManager.getLogger(ProductPage.class.getName());

    public ProductPage() {
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy(xpath = "//div[@class='page-title']/h1")
    WebElement pageTitle;
    @CacheLookup
    @FindBy(xpath = "//div[@class='details']/h2/a")
    List<WebElement> productName;
    @CacheLookup
    @FindBy(id = "add-to-cart-button-5")
    WebElement addToCartButton;
    @CacheLookup
    @FindBy(xpath = "//p[@class='content']")
    WebElement productAddMessage;
    @CacheLookup
    @FindBy(xpath = "//p[@class='content']/a")
    WebElement shoppingCart;

    public String titleOfPage() {
        log.info("Getting title of page : " + pageTitle.toString());
        return getTextFromElement(pageTitle);
    }

    public String selectProduct(String nameOfProduct) throws StaleElementReferenceException {
        log.info("Selecting product " + productName.toString());
        List<WebElement> listofnames = productName;

        try {
            for (WebElement element : listofnames) {
                if (element.getText().equalsIgnoreCase(nameOfProduct)) {
                    element.click();
                }
            }
        } catch (StaleElementReferenceException exception) {
            listofnames = productName;
        }

        return nameOfProduct;
    }

    public void clickOnAddToCartButton() {
        log.info("click on add to cart button " + addToCartButton.toString());
        clickOnElement(addToCartButton);
    }

    public String productAddedToCart() {
        log.info("Product successfully added to cart : " + productAddMessage.toString());
        return getTextFromElement(productAddMessage);
    }

    public void clickOnShoppingCart() {
        log.info("Click on shopping cart : " + shoppingCart.toString());
        clickOnElement(shoppingCart);
    }

}
