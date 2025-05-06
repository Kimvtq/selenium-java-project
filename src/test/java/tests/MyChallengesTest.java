package tests;
import java.util.UUID;
import org.testng.ITestContext;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.CreateChallengePage;
import pages.LoggedInBasePage;
import pages.MyChallengesPage;
import pages.LoginPage;
import utils.BaseTest;

public class MyChallengesTest extends BaseTest {
    @Parameters({"username", "password"})

    @Test
    public void testMyChallenges(String username, String password) {
        LoginPage loginPage = new LoginPage(driver, wait);
        LoggedInBasePage loggedInBasePage = new LoggedInBasePage(driver, wait);
        CreateChallengePage createChallengePage = new CreateChallengePage(driver, wait);
        MyChallengesPage myChallengesPage = new MyChallengesPage(driver, wait);
        String randomString = UUID.randomUUID().toString().substring(0, 3);
        String challengeTitle = "Automation Challenge Test " + randomString;
        String challengeFlag = "CTFlearn{123456789}";
        String challengeDescription = "Automation Challenge Test Description";
        String challengeHowToSolve = "This is an automated test challenge.";
        String challengeStatus = "In Review";

        loginPage.visitLoginPage(baseUrl);
        loginPage.login(username, password);
//        loggedInBasePage.navigateToCreateChallengePage();
//        createChallengePage.createChallenge(challengeTitle, challengeFlag, challengeDescription, challengeHowToSolve);
//        loggedInBasePage.navigateToMyChallengePage();
//        myChallengesPage.verifyFirstChallenge(challengeTitle, challengeStatus);
        loggedInBasePage.logout();
    }
}