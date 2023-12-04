package com.nopcommerce.utility;

import com.nopcommerce.browserfactory.ManageBrowser;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Utility extends ManageBrowser {
    /*Utility Class extends to ManageBrowser for the driver to finding locators

     * This method will generate random number
     */
    public int generateRandomNumber() {
        return (int) (Math.random() * 5000 + 1);

    }

    /**
     * This method will generate random string
     */
    public static String getRandomString(int length) {
        StringBuilder sb = new StringBuilder();
        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        for (int i = 0; i < length; i++) {
            int index = (int) (Math.random() * characters.length());
            sb.append(characters.charAt(index));
        }
        return sb.toString();
    }


    public void clickOnElement(WebElement element) {
        element.click();
    }

    /**
     * This method will get text from element
     */

    public String getTextFromElement(WebElement element) {
        return element.getText();
    }

    /**
     * This method will send text on element
     */

    public void sendTextToElement(WebElement element, String str) {
        element.sendKeys(str);
    }



//*************************** Select Class Methods ***************************************//

    /**
     * This method will select the option by visible text
     */

    public void selectByVisibleTextFromDropDown(WebElement element, String text) {
        new Select(element).selectByVisibleText(text);
    }


//*************************** Action Methods ***************************************//

    /**
     * This method will use to hover mouse on element
     */


    public void mouseHoverToElement(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }


    //************************** ScreenShot Methods *********************************************//

    /**
     * This method will take screenshot
     */
    public static void takeScreenShot() {
        String filePath = System.getProperty("user.dir") + "/src/main/java/com/nopcommerce/screenshots/";
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File scr1 = screenshot.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scr1, new File(filePath + getRandomString(10) + ".jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String currentTimeStamp() {
        Date d = new Date();
        return d.toString().replace(":", "_").replace(" ", "_");
    }

    public static String getScreenshot(WebDriver driver, String screenshotName) {
        String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);

        // After execution, you could see a folder "FailedTestsScreenshots" under screenshot folder
        String destination = System.getProperty("user.dir") + "/src/main/java/com/nopcommerce/screenshots/" + screenshotName + dateName + ".png";
        File finalDestination = new File(destination);
        try {
            FileUtils.copyFile(source, finalDestination);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return destination;
    }

    /*
     *Screenshot methods
     */
    public static String takeScreenShot(String fileName) {
        String filePath = System.getProperty("user.dir") + "/test-output/html/";
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File scr1 = screenshot.getScreenshotAs(OutputType.FILE);
        String imageName = fileName + currentTimeStamp() + ".jpg";
        String destination = filePath + imageName;
        try {
            FileUtils.copyFile(scr1, new File(destination));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return destination;
    }
}
