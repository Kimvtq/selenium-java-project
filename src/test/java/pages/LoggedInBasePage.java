package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoggedInBasePage {
    WebDriver driver;
    WebDriverWait wait;

    // Locators
    By dropdownToggleChallengesMenu = By.xpath("//a[contains(@class, 'dropdown-toggle') and contains(@class, 'dropdown-toggle-split')]");
    By challengesSubMenu = By.xpath("//div[contains(@class, 'dropdown-menu show')]");
    By createChallengeLink = By.xpath("//a[text()='Create Challenge']");
    By myChallengesLink = By.xpath("//a[contains(@href, '/challenge/by/')]");
    By profileDropdown = By.id("profileDropdown");
    By logoutButton = By.xpath("//a[contains(@href, '/user/logout')]");

    public LoggedInBasePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void clickDownArrowChallengesMenu() {
        driver.findElement(dropdownToggleChallengesMenu).click();
        wait.until(ExpectedConditions.elementToBeClickable(challengesSubMenu));
    }

    public void navigateToMyChallengePage() {
        this.clickDownArrowChallengesMenu();
        driver.findElement(myChallengesLink).click();
        wait.until(ExpectedConditions.urlContains("/by"));
    }

    public void navigateToCreateChallengePage() {
        this.clickDownArrowChallengesMenu();
        driver.findElement(createChallengeLink).click();
        wait.until(ExpectedConditions.urlContains("/create"));
    }

    public void logout() {
        driver.findElement(profileDropdown).click();
        wait.until(ExpectedConditions.elementToBeClickable(logoutButton)).click();
    }
}