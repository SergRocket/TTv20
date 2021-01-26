package qa.hospital;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import qa.hospital.pages.LoginPage;
import utils.AppConfig;

public class Logout extends BaseTest {
    @Test
    public void logOut() {
        LoginPage loginpage = new LoginPage(driver);
        String validUsername = AppConfig.USERNAME;
        String validPassword = AppConfig.PASSWORD;
        loginpage.login(validUsername, validPassword);
        loginpage.logOut();
        wait.until(ExpectedConditions.urlContains("#/login"));
    }
}
