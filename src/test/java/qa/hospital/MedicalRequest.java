package qa.hospital;

import org.testng.Assert;
import org.testng.annotations.Test;
import qa.hospital.pages.LoginPage;
import qa.hospital.pages.MedicationPage;
import utils.AppConfig;

public class MedicalRequest extends BaseTest {
    @Test
    public void medicationRequest () {
        LoginPage loginPage = new LoginPage(driver);
        String validUsername = AppConfig.USERNAME;
        String validPassword = AppConfig.PASSWORD;
        loginPage.login(validUsername, validPassword);
        MedicationPage medicationPage = new MedicationPage(driver);
        String searchFor = AppConfig.SEARCHFOR;
        String medication = AppConfig.MEDICATION;
        String prescription = AppConfig.PRESCRIPTION;
        medicationPage.MedicRequest(searchFor, medication, prescription);
        Assert.assertTrue(driver.getCurrentUrl().contains("medication/edit/new"));
    }
}
