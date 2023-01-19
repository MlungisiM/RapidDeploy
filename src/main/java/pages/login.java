package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import common.DriverHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class login extends DriverHandler
{
    //Page Objects
    @FindBy(id = "user-name")
    WebElement username;
    @FindBy(id = "login-button")
    WebElement loginbutton;

    @FindBy(id = "password")
    WebElement password;

    WebDriverWait wait;

    //Initialize Page Objects
    public login() {
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void populateUsername(String Swagname) {
        username.sendKeys(Swagname);
    }

    public void populatepassword(String Swagpassword) {
        password.sendKeys(Swagpassword);
    }

    public void clickloginbutton() {
        wait.until(ExpectedConditions.elementToBeClickable(loginbutton)).click();
    }
    
    }