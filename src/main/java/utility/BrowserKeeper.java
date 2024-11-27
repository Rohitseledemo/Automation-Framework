package utility;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class BrowserKeeper {
        private static final ThreadLocal<WebDriver> browser = new ThreadLocal<>();
//        private static WebDriver browser;

    // Private constructor to prevent instantiation
        private BrowserKeeper() { }

    private static final class InstanceHolder {
        static final BrowserKeeper instance = new BrowserKeeper();
    }

    // Method to get the singleton instance of BrowserKeeper
        public static BrowserKeeper getInstance() {
            return InstanceHolder.instance;
        }

    public void setupWebDriver() throws MalformedURLException {
            // for BrowserStack instance creation

//              String username = System.getenv("BROWSERSTACK_USERNAME");
//              String accessKey = System.getenv("BROWSERSTACK_ACCESS_KEY");
//              MutableCapabilities capabilities = getMutableCapabilities();
//              browser = new RemoteWebDriver(new URL("https://" + username + ":" + accessKey +
//                "@hub.browserstack.com/wd/hub"), capabilities);
////            browser.set(new RemoteWebDriver(new URL("https://" + username + ":" + accessKey +
////                "@hub.browserstack.com/wd/hub"), capabilities));

            // for local browser instance creation

            if (browser.get() == null) {
            ChromeOptions option = new ChromeOptions();
            option.addArguments("start-maximized");
            //Set the zoom level to 80% (1.0 scale factor) fits the screen
            option.addArguments("--force-device-scale-factor=1.0");
            //to run TCs in headless mode
            option.addArguments("--headless");
            System.setProperty("webdriver.chrome.driver", "src/main/resources/chromeDriver/chromedriver.exe");
            browser.set(new ChromeDriver(option));}
    }

    private MutableCapabilities getMutableCapabilities() {
        ChromeOptions option=new ChromeOptions();
        option.addArguments("start-maximized");
        // to run TCs in headless mode
        option.addArguments("--headless");
        MutableCapabilities capabilities = new MutableCapabilities();
        capabilities.setCapability("browserName", "Chrome");
        capabilities.setCapability(ChromeOptions.CAPABILITY, option);
        HashMap<String, String> browserstackOptions = new HashMap<String, String>();
        browserstackOptions.put("os", "Windows");
        capabilities.setCapability("bstack:options", browserstackOptions);
        return capabilities;
    }

    public  WebDriver getBrowserInstance() {
	return browser.get();
   }
    public void quitBrowserInstance() {
        WebDriver driver = browser.get();
        if (driver != null) {
            try {
                driver.quit();
            } catch (Exception e) {
                System.out.println("Session already closed. Skipping quit.");
            } finally {
                browser.remove(); // Remove the instance from ThreadLocal
            }
        }
    }

//    public  WebDriver getBrowserInstance() {
//        return browser;
//    }
//    public void quitBrowserInstance() {
//        browser.quit();
//    }


}
