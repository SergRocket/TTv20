package utils;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.opera.OperaDriver;


public class BrowserDriverFactory {
 private ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
 private String browser;
 private Logger logger;

 public BrowserDriverFactory(String browser, Logger logger){
     this.browser=browser.toLowerCase();
     this.logger=logger;
 }

 public WebDriver createDriver(){
     logger.info("driver was created ");

     switch (browser){
         case "chrome":
             WebDriverManager.chromedriver().setup();
             driver.set(new ChromeDriver());
             break;
         case "opera":
             WebDriverManager.operadriver().setup();
             driver.set(new OperaDriver());
             break;
         default:
             logger.info("The test was completed");
     }
     return driver.get();
 }
}
