package tests;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.BaseTest;

public class LoginTest extends BaseTest {

    @Test
    public void validLoginTest() {
        LoginPage loginPage = new LoginPage(driver, wait);
        String username = "kvtp";
        String password = "kvtp";

        loginPage.visitLoginPage(baseUrl);
        loginPage.login(username, password);
        loginPage.verifyLoginSuccess(baseUrl);
    }
}
