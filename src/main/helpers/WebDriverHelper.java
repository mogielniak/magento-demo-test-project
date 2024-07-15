package main.helpers;

import com.google.j2objc.annotations.Property;
import io.github.bonigarcia.wdm.WebDriverManager;
import main.config.PropertyReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

final public class WebDriverHelper implements IInvokedMethodListener {
    private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
        if (method.isTestMethod()) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--start-maximized");
            chromeOptions.addArguments("--disable-extensions");
            WebDriver driver = new ChromeDriver(chromeOptions);
            driverThreadLocal.set(driver);
        }
    }

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        WebDriver driver = driverThreadLocal.get();
        if (driver != null) {
            driver.quit();
            driverThreadLocal.remove();
        }
    }

    public static WebDriver getDriverInv() {
        return driverThreadLocal.get();
    }

    private  static WebDriver driver;
    public static WebDriver getDriver() {
        if (driver == null) {
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
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}