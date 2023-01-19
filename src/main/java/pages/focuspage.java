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

public class focuspage extends DriverHandler {

    //Page Objects

    @FindBy(id = "user-name")
    WebElement Username;

    @FindBy(id = "login-button")
    WebElement loginbutton;

    @FindBy(id = "password")
    WebElement password;



    WebDriverWait wait;

    //Initialize Page Objects
    public focuspage() {
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void enterUsername(String username) {
        wait.until(ExpectedConditions.visibilityOf(Username)).sendKeys(username);
    }

    public void enterPassword(String Password) {
        password.sendKeys(Password);
    }

    public void clickLoginButton() {
        WebElement element = driver.findElement(By.id("login-button"));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }

}
