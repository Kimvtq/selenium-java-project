package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateChallengePage extends LoggedInBasePage {

    By titleInput = By.id("title");
    By flagInput = By.id("flag");
    By descriptionTextArea = By.id("flask-pagedown-description");
    By howToSolveTextArea = By.id("howtosolve");
    By submitButton = By.xpath("//button[text()='Submit for Verification']");

    public CreateChallengePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void createChallenge(String title, String flag, String description, String howToSolve) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(titleInput));
        WebElement titleField = driver.findElement(titleInput);
        WebElement flagField = driver.findElement(flagInput);
        WebElement descriptionField = driver.findElement(descriptionTextArea);
        WebElement howToSolveField = driver.findElement(howToSolveTextArea);

        titleField.clear();
        titleField.sendKeys(title);

        flagField.clear();
        flagField.sendKeys(flag);

        descriptionField.clear();
        descriptionField.sendKeys(description);

        howToSolveField.clear();
        howToSolveField.sendKeys(howToSolve);

        driver.findElement(submitButton).click();
    }
}