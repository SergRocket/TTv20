package qa.hospital;

import org.testng.Assert;
import org.testng.annotations.Test;
import qa.hospital.pages.LoginPage;
import qa.hospital.pages.MainPage;
import qa.hospital.pages.MedicationPage;
import utils.AppConfig;

public class MedicalRequest extends BaseTest {
    @Test
    public void medicationRequest () {
        LoginPage loginPage = new LoginPage(driver);
        String validUsername = AppConfig.USERNAME;
        String validPassword = AppConfig.PASSWORD;
        MainPage mainPage = loginPage.login(validUsername, validPassword);
        loginPage.login(validUsername, validPassword);
        MedicationPage medicationPage = new MedicationPage(driver);
        String searchFor = AppConfig.SEARCHFOR;
        String medication = AppConfig.MEDICATION;
        String prescription = AppConfig.PRESCRIPTION;
        medicationPage.openRequestPage();
        medicationPage.dataInput(searchFor,medication,prescription);
        medicationPage.finPopUp();
        Assert.assertTrue(driver.getCurrentUrl().contains("medication/edit/new"));
    }
}
