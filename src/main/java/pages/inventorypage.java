package pages;

import common.DriverHandler;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class inventorypage extends DriverHandler {

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    WebElement addItem;

    @FindBy(xpath = "//*[@id='shopping_cart_container']/a/span")
    WebElement cart;

    @FindBy(id = "checkout")
    WebElement checkout;

    @FindBy(id = "first-name")
    WebElement checkoutfirstname;

    @FindBy(id = "last-name")
    WebElement checkoutlastname;

    @FindBy(id = "postal-code")
    WebElement checkoutpostal;

    @FindBy(id = "continue")
    WebElement continuebutton;

    @FindBy(id = "finish")
    WebElement finishbutton;

    WebDriverWait wait;

    //Initialize Page Objects
    public inventorypage() {
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void populateFirstname(String Firstname) {
        checkoutfirstname.sendKeys(Firstname);
    }

    public void populateLastname(String Lastname) {
        checkoutlastname.sendKeys(Lastname);
    }

    public void populatepostalcode(String Postal) {
        checkoutpostal.sendKeys(Postal);
    }

    public void clickcontinuebutton() {
        wait.until(ExpectedConditions.elementToBeClickable(continuebutton)).click();
    }

    public void clickfinishbutton() {
        wait.until(ExpectedConditions.elementToBeClickable(finishbutton)).click();
    }

    public void clickcheckoutbutton() {
        wait.until(ExpectedConditions.elementToBeClickable(checkout)).click();
    }

    public void clickcartbutton() {
        wait.until(ExpectedConditions.elementToBeClickable(cart)).click();
    }

    //public void clickaddItembutton() {
      //  wait.until(ExpectedConditions.elementToBeClickable(addItem)).click();
    //}

    public void clickaddItembutton() {
        WebElement element = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }

}
