package qa.hospital;

import org.testng.Assert;
import org.testng.annotations.Test;
import qa.hospital.pages.LoginPage;
import utils.AppConfig;

public class InvalidLogin extends BaseTest {
    @Test
    public void invalidLogin() {
        LoginPage loginPage = new LoginPage(driver);
        String invalidUsername = AppConfig.INVALIDUSERNAME;
        String invalidPassword = AppConfig.INVALIDPASSWORD;
        loginPage.login(invalidUsername, invalidPassword);
        final String error = loginPage.getErrorMessage();
        Assert.assertEquals(error, "Username or password is incorrect.");
        Assert.assertTrue(driver.getCurrentUrl().contains("#/login"));
    }
}
