package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class MyChallengesPage extends LoggedInBasePage {

    By firstChallenge = By.xpath("(//a[contains(@class, 'clear-link')])[1]");
    By firstChallengeHeader = By.xpath("//div[contains(@class, 'card-header')]/span");
    By firstChallengeStatus = By.xpath("//div[contains(@class, 'card-header')]//span[contains(@class, 'badge')]");

    public MyChallengesPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void verifyFirstChallenge(String title, String status) {
        WebElement firstChallengeElement = driver.findElement(firstChallenge);
        Assert.assertEquals(firstChallengeElement.findElement(firstChallengeHeader).getText(), title, "Challenge not found");
        Assert.assertEquals(firstChallengeElement.findElement(firstChallengeStatus).getText(), status, "Status not matched");
    }
}
