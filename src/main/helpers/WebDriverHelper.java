package main.helpers;

import com.google.j2objc.annotations.Property;
import io.github.bonigarcia.wdm.WebDriverManager;
import main.config.PropertyReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

final public class WebDriverHelper {
    private static WebDriver driver;
    public static WebDriver getDriver() {
        if (driver == null) {
            String browser = PropertyReader.getProperty("browser");
            switch(browser) {
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    firefoxOptions.addArguments("--start-maximized");
                    firefoxOptions.addArguments("--disable-extensions");
                    driver = new FirefoxDriver(firefoxOptions);
                    break;
                case "chrome":
                default:
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("--start-maximized");
                    chromeOptions.addArguments("--disable-extensions");
                    driver = new ChromeDriver(chromeOptions);
                    break;
            }
            driver.get(PropertyReader.getProperty("home_page"));
            //driver.get(PropertyReader.getProperty("url") + "/customer/account/login/");
        }
        return driver;
    }
    public static void quitDriver(){
        if(driver!= null){
            driver.quit();
            driver = null;
        }
    }
}
