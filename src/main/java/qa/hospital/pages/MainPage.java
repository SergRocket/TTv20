package qa.hospital.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage extends BasePage {
    @FindBy(css ="#ember412 > nav > header > a.settings-trigger")
    private WebElement cogWheel;
    @FindBy(css = "#ember412 > nav > header > nav > a.logout")
    private WebElement logoutButton;

    public MainPage(WebDriver driver) {super(driver);}

    public void logOut(){
        wait.until(ExpectedConditions.visibilityOfAllElements(cogWheel));
        cogWheel.click();
        logoutButton.click();
        wait.until(ExpectedConditions.urlContains("#/login"));
    }
}
