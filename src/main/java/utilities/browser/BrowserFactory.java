package utilities.browser;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public enum BrowserFactory {

    CHROME {
        @Override
        public WebDriver createDriver() {
            return new ChromeDriver(getOptions());
        }
        @Override
        public ChromeOptions getOptions(){
            ChromeOptions option = new ChromeOptions();
            option.addArguments("start-maximized");
            //Set the zoom level to 80% (1.0 scale factor) fits the screen
            option.addArguments("--force-device-scale-factor=1.0");
            //to run TCs in headless mode
//            option.addArguments("--headless");
            System.setProperty("webdriver.chrome.driver","src/main/resources/DriverFiles/chromedriver.exe");
            return option;
        }},
    EDGE {
        @Override
        public WebDriver createDriver() {
        return new EdgeDriver(getOptions());
    }
        @Override
        public EdgeOptions getOptions() {
        EdgeOptions option = new EdgeOptions();
        option.addArguments("start-maximized");
        //Set the zoom level to 80% (1.0 scale factor) fits the screen
        option.addArguments("--force-device-scale-factor=1.0");
        //to run TCs in headless mode
//        option.addArguments("--headless");
        System.setProperty("webdriver.edge.driver", "src/main/resources/DriverFiles/msedgedriver.exe");
        return option;
    }
}, FIREFOX {
        @Override
        public WebDriver createDriver() {
        return new FirefoxDriver(getOptions());
    }
        @Override
        public FirefoxOptions getOptions() {
        FirefoxOptions option = new FirefoxOptions();
        option.addArguments("start-maximized");
        //Set the zoom level to 80% (1.0 scale factor) fits the screen
        option.addArguments("--force-device-scale-factor=1.0");
        //to run TCs in headless mode
        option.addArguments("--headless");
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromeDriver/chromedriver.exe");
        return option;
    }
}, REMOTE {
        @Override
        public WebDriver createDriver() throws MalformedURLException {
            String username = System.getenv("BROWSERSTACK_USERNAME");
            String accessKey = System.getenv("BROWSERSTACK_ACCESS_KEY");
            MutableCapabilities capabilities = getOptions();
            return new RemoteWebDriver(new URL("https://" + username + ":" + accessKey +
                    "@hub.browserstack.com/wd/hub"), capabilities);
        }
        @Override
        public MutableCapabilities getOptions(){
            ChromeOptions option=new ChromeOptions();
            option.addArguments("start-maximized");
            // to run TCs in headless mode
//        option.addArguments("--headless");
            MutableCapabilities capabilities = new MutableCapabilities();
            capabilities.setCapability("browserName", "Chrome");
            capabilities.setCapability(ChromeOptions.CAPABILITY, option);
            HashMap<String, String> browserstackOptions = new HashMap<>();
            browserstackOptions.put("os", "Windows");
            capabilities.setCapability("bstack:options", browserstackOptions);
            return capabilities;
        }
    };
    public abstract WebDriver createDriver() throws MalformedURLException;

    public abstract MutableCapabilities getOptions();

}
