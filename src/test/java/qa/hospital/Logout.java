package qa.hospital;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import qa.hospital.pages.LoginPage;
import qa.hospital.pages.MainPage;
import utils.AppConfig;

public class Logout extends BaseTest {
    @Test
    public void logOut() {
        LoginPage loginPage = new LoginPage(driver);
        String validUsername = AppConfig.USERNAME;
        String validPassword = AppConfig.PASSWORD;
        MainPage mainPage = loginPage.login(validUsername, validPassword);
        mainPage.logOut();
        }
}
