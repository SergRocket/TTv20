package qa.hospital.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {
    @FindBy(css = "#identification")
    private WebElement usernameInput;
    @FindBy(css = "#password")
    private WebElement passwordInput;
    @FindBy(css = "button[type='submit']")
    private WebElement loginButton;
    @FindBy(css = "div[role='alert']")
    private WebElement errorMassage;
    @FindBy(css ="#ember412 > nav > header > a.settings-trigger")
    private WebElement cogWheel;
    @FindBy(css = "#ember412 > nav > header > nav > a.logout")
    private WebElement logoutButton;

    public LoginPage(WebDriver driver){super(driver);}

    public void login(String username, String password) {
        waitForElementToBeVisible(usernameInput);
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();
    }

    public String getErrorMessage() {
        waitForElementToBeVisible(errorMassage);
        return errorMassage.getText();
    }

    public void logOut(){
        wait.until(ExpectedConditions.visibilityOfAllElements(cogWheel));
        cogWheel.click();
        logoutButton.click();
    }

}
