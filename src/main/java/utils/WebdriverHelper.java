package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class WebdriverHelper {

    public static void navigateToURL(String url, WebDriver driver) {
        driver.navigate().to(url);
        waitForNewPageToLoad(driver);
    }

    public static void waitForNewPageToLoad(WebDriver driver) {
        for (int i = 0; i < 10; i++) {
            //To check page ready state.
            if (javaScriptExecutor("return document.readyState", driver).toString()
                    .equals("complete")) {
                break;
            }
        }
    }

    public static String javaScriptExecutor(String javaScriptString, WebDriver driver) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        return (String) jse.executeScript(javaScriptString);
    }

    public static WebDriver getDriver(){
        System.setProperty("webdriver.chrome.driver", PropertyLoader.loadProperty("driverPath"));
        ChromeOptions option = new ChromeOptions();
        option.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
        option.setCapability("JavascriptEnabled", true);
        option.addArguments("disable-extensions");
        option.addArguments("no-sandbox");
        option.addArguments("disable-infobars");
        option.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation"));
        option.setExperimentalOption("useAutomationExtension", false);
        option.setCapability(ChromeOptions.CAPABILITY, option);
        return new ChromeDriver(option);
    }

    public static void killDriver(WebDriver driver){
        driver.close();
        driver.quit();
    }

    public static String getCurrentPageUrl(WebDriver driver) {
        return driver.getCurrentUrl();
    }
}
