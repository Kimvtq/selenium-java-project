package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LoginPage {
    WebDriver driver;
    WebDriverWait wait;
    String pageUri = "/user/login";

    // Constructor
    public LoginPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    // Locators
    By usernameField = By.id("identifier");
    By passwordField = By.id("password");
    By loginButton = By.xpath("//button[text()='Login']");


    public void visitLoginPage(String baseUrl) {
        driver.get(baseUrl + pageUri);
    }

    public void enterUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }

    public void verifyLoginSuccess(String baseUrl) {
        wait.until(ExpectedConditions.urlContains("/dashboard"));
        Assert.assertEquals(driver.getCurrentUrl(), baseUrl + "/dashboard", "User is not on the dashboard page.");
    }
}
