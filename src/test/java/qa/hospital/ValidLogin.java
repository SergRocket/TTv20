package qa.hospital;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import qa.hospital.pages.LoginPage;
import utils.AppConfig;

public class ValidLogin extends BaseTest {
    @Test
    public void validLog () {
        LoginPage loginPage = new LoginPage(driver);
        String validUsername = AppConfig.USERNAME;
        String validPassword = AppConfig.PASSWORD;
        loginPage.login(validUsername, validPassword);
        wait.until(ExpectedConditions.urlContains("#/patients"));
    }
}
