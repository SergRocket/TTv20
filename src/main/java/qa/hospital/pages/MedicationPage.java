package qa.hospital.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Random;

public class MedicationPage extends BasePage {
    @FindBy(css="#ember767")
    private WebElement medicationSection;
    @FindBy(css="#ember2177")
    private WebElement requests;
    @FindBy(css="#ember2180")
    private WebElement completed;
    @FindBy(css="#ember2495")
    private WebElement newRequest;
    @FindBy(css="#ember2239")
    private WebElement returnMedication;
    @FindBy(css="#ember727")
    private WebElement patients;
    @FindBy(css="#patientTypeAhead-ember2546")
    private WebElement patient ;
    @FindBy(css="#visit-ember2591")
    private WebElement visitDate;
    @FindBy(css="#ember767")
    private WebElement medication;
    @FindBy(css="#prescription-ember2645")
    private WebElement prescription;
    @FindBy(css="#display_prescriptionDate-ember2668")
    private WebElement prescriptionDate;
    @FindBy(css="body > div.pika-single.is-bound.is-hidden > div")
    private WebElement weekDay;
    @FindBy(css="#quantity-ember2687")
    private WebElement quantit;
    @FindBy(css="#refills-ember2694")
    private WebElement refils;
    @FindBy(css="#ember2509 > div > div.panel-footer > button.btn.btn-primary.on-white.disabled-btn")
    private WebElement addButton;
    @FindBy(css="#ember2963 > div > div > div")
    private WebElement modalWin;
    @FindBy(css="#ember2963 > div > div > div > div.modal-header > button > span")
    private WebElement closeBut;
    @FindBy(css="#ember2963 > div > div > div > div.modal-footer > button")
    private WebElement oKButton;

    public MedicationPage(WebDriver driver) {
        super(driver);
    }

    public void MedicRequest(String searchFor, String medications, String prescriptions){
        wait.until(ExpectedConditions.visibilityOfAllElements(patients, medication));
        medicationSection.click();
        wait.until(ExpectedConditions.visibilityOfAllElements(requests, completed, returnMedication, newRequest));
        newRequest.click();
        patient.click();
        patient.sendKeys(searchFor);
        int i=1;
        while(i<3){
            patient.sendKeys(Keys.ARROW_DOWN);
            i++;
        }
        patient.sendKeys(Keys.ENTER);
        visitDate.click();
        int c=1;
        while(c<4) {
            visitDate.sendKeys(Keys.ARROW_DOWN);
            c++;
        }
        visitDate.sendKeys(Keys.ENTER);
        medication.sendKeys(medications);
        medication.sendKeys(Keys.ARROW_DOWN);
        medication.sendKeys(Keys.ENTER);
        prescription.sendKeys(prescriptions);
        prescriptionDate.click();
        wait.until(ExpectedConditions.visibilityOfAllElements(weekDay));
        weekDay.click();
        prescriptionDate.sendKeys(Keys.ARROW_LEFT);
        prescriptionDate.sendKeys(Keys.ENTER);
        Random rand = new Random();
        int qr = rand.nextInt(1)+3;
        int qrf = rand.nextInt(5)+8;
        String QR = Integer.toString(qr);
        String QRef = Integer.toString(qrf);
        quantit.sendKeys(QR);
        refils.sendKeys(QRef);
        addButton.click();
        wait.until(ExpectedConditions.visibilityOfAllElements(modalWin, oKButton,closeBut));
        boolean popUp = (modalWin.isDisplayed() && oKButton.isDisplayed() && closeBut.isDisplayed());
        if (popUp){
            System.out.print("The pop is displayed after clicking Add button ");
        } else {
            System.out.println("The pop up is not shown after clicking Add button");
        }
        wait.until(ExpectedConditions.visibilityOfAllElements(modalWin));
        oKButton.click();
        try {
            modalWin.isDisplayed();
        } catch (Exception e){
            System.out.println(" The pop up is gone, as expected");
        }
    }
}
