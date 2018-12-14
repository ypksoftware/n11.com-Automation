package com.n11.utils.driver;

import com.amazonaws.services.dynamodbv2.xspec.NULL;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import io.github.bonigarcia.wdm.InternetExplorerDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DriverFactory {

    // Get a new WebDriver Instance.
    // There are various implementations for this depending on browser. The required browser can be set as an environment variable.
    // Refer http://getgauge.io/documentation/user/current/managing_environments/README.html
    public static WebDriver getDriver() {

        String browser = System.getenv("BROWSER");
        if (browser == null) {
            ChromeDriverManager.getInstance(Driver.class).setup();
            return new ChromeDriver();
        }
        switch (browser)
        {
            case "IE":
                InternetExplorerDriverManager.getInstance(Driver.class).setup();

                DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
                capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS,true);
                capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
                capabilities.setCapability("ignoreZoomSetting", true);
                return new InternetExplorerDriver(capabilities);
            case "FIREFOX":
                FirefoxDriverManager.getInstance(Driver.class).setup();
                return new FirefoxDriver();
            default:
                ChromeDriverManager.getInstance(Driver.class).setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--allow-running-insecure-content");
                ChromeDriver chromeDriver = new ChromeDriver(options);
                return chromeDriver;

        }
    }
}
