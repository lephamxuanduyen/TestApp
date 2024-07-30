package driver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class DriverManager {
    public static final ThreadLocal<AndroidDriver> driver = new ThreadLocal<>();

    public static AndroidDriver getDriver() {
        if (driver.get() == null) {
            throw new RuntimeException("Driver not initialized.");
        }
        return driver.get();
    }

    public static void initializeDriver() {
        if (driver.get() == null){
            try {
                DesiredCapabilities capabilities = new DesiredCapabilities();
                capabilities.setCapability("platformName", "Android");
                capabilities.setCapability("automationName", "UiAutomator2");
                capabilities.setCapability("udid", "emulator-5554");
                URL url = new URL("http://localhost:4723/wd/hub");
                AndroidDriver initializedDriver = new AndroidDriver(url, capabilities);
                initializedDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                driver.set(initializedDriver);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}
