package main.helpers.webDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import main.config.PropertyReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class browserType {
    public static WebDriver createBrowser() {
        WebDriver driver = null;
        String browser = PropertyReader.getProperty("browser");
        switch (browser) {
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
        return driver;
    }
}
