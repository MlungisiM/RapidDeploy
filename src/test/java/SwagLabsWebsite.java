import common.DriverHandler;
import javafx.scene.layout.Priority;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.focuspage;
import pages.login;
import pages.inventorypage;

import java.util.concurrent.TimeUnit;

public class SwagLabsWebsite extends DriverHandler {
    String username = getProp().getProperty("username");
    String password = getProp().getProperty("password");
    String firstname = getProp().getProperty("firstname");
    String lastname = getProp().getProperty("lastname");
    String postalcode = getProp().getProperty("postalcode");;


    login loginPage;

    focuspage FocusPage;
    inventorypage InventoryPage;

   @Test(priority = 1)
    //@BeforeMethod
    public void setUp() {
        startBrowser();
       loginPage = new login();
    }

    @Test(priority = 2)
    public void logIn() {

        loginPage.populateUsername(username);
        loginPage.populatepassword(password);
        loginPage.clickloginbutton();
    }

    @Test(priority = 3)
    public void addCart()
    {
        InventoryPage.clickaddItembutton();
        InventoryPage.clickcartbutton();
        InventoryPage.clickcheckoutbutton();
        InventoryPage.populateFirstname(firstname);
        InventoryPage.populateLastname(lastname);
        InventoryPage.populatepostalcode(postalcode);
        InventoryPage.clickcontinuebutton();
        InventoryPage.clickfinishbutton();
    }
    @Test(priority = 4)
    //@AfterMethod
    public void tearDown() {
        closeBrowser();
   }
}
