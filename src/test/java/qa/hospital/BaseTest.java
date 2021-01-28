package qa.hospital;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import utils.AppConfig;
import utils.BrowserDriverFactory;

import java.time.Duration;
import java.util.concurrent.TimeUnit;


public class BaseTest {
     protected WebDriver driver;
    protected WebDriverWait wait;
    protected Logger logger;
    @Parameters({"browser"})
    @BeforeMethod
    public void beforeLogin(@Optional()String browser, ITestContext testContext) {
        String validLoginTest = testContext.getCurrentXmlTest().getName();
        logger = LogManager.getLogger(validLoginTest);
        BrowserDriverFactory browserDriverFactory = new BrowserDriverFactory(browser, logger);
        driver=browserDriverFactory.createDriver();
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, Duration.ofSeconds(AppConfig.TIMEOUT));
        driver.get(AppConfig.DEVLINK);
    }

    @AfterMethod
    public void shuttingDown() {
        driver.close();
        if (driver != null) {
            driver.quit();
        }
    }
}
