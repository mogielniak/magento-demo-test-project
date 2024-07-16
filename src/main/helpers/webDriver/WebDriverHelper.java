package main.helpers.webDriver;

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

import java.util.logging.Level;
import java.util.logging.Logger;

public class WebDriverHelper implements IInvokedMethodListener {
    private static final Logger LOGGER = Logger.getLogger(WebDriverHelper.class.getName());

    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
        if (method.isTestMethod()) {
            WebDriver driver = browserType.createBrowser();
            driverUtil.setWebDriver(driver);
            LOGGER.log(Level.INFO, "driverThreadLocal.set(driver);");
        }
    }

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        if (method.isTestMethod()) {
            WebDriver driver = driverUtil.getDriver();
            if (driver != null) {
                driver.quit();
                LOGGER.log(Level.INFO, "driver.quit();");
            }
        }
    }

}

