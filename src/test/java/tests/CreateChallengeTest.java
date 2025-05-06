package tests;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.CreateChallengePage;
import pages.LoggedInBasePage;
import pages.LoginPage;
import utils.BaseTest;

import java.util.UUID;

public class CreateChallengeTest extends BaseTest {
    @Parameters({"username", "password"})
    @Test
    public void testCreateChallenge(@Optional String username, @Optional String password) {
        LoginPage loginPage = new LoginPage(driver, wait);
        LoggedInBasePage loggedInBasePage = new LoggedInBasePage(driver, wait);
        CreateChallengePage createChallengePage = new CreateChallengePage(driver, wait);
        String randomString = UUID.randomUUID().toString().substring(0, 3);
        String challengeTitle = "Automation Challenge Test " + randomString;
        String challengeFlag = "CTFlearn{123456789}";
        String challengeDescription = "Automation Challenge Test Description";
        String challengeHowToSolve = "This is an automated test challenge.";

        loginPage.visitLoginPage(baseUrl);
        loginPage.login(username, password);
        loggedInBasePage.navigateToCreateChallengePage();
        createChallengePage.createChallenge(challengeTitle, challengeFlag, challengeDescription, challengeHowToSolve);
        loggedInBasePage.logout();
    }
}