package helpers;

import enums.BrowserType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
//import org.openqa.selenium.remote.BrowserType;

public class BrowserFabric {
    public static WebDriver getDriver(BrowserType browserType) {
        if (browserType == BrowserType.FIERFOX) {
            return getFirefoxDriver();
        }
        return getChromeDriver();
    }
    private static WebDriver getChromeDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("window-size=1400,1000");
        //options.addArguments("--headless");
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver(options);
    }

    private static WebDriver getFirefoxDriver() {
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--headless");
        options.addArguments("--width=1400");
        options.addArguments("--height=1000");
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver(options);
    }
}
