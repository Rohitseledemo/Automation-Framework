package utilities.browser;

import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;

public class BrowserManager implements Browser {
    private static final ThreadLocal<WebDriver> browser = new ThreadLocal<>();

    // Private constructor to prevent instantiation
    private BrowserManager() { }

    private static final class InstanceHolder {
        static final BrowserManager instance = new BrowserManager();
    }

    // Method to get the singleton instance of BrowserKeeper
    public static BrowserManager getInstance() {
        return InstanceHolder.instance;
    }

    // Setting the WebDriver instance for the current thread
    public void setBrowser(String browserName) throws MalformedURLException {
        if (browser.get() == null) { // Avoid setting a new driver if one already exists
            browser.set(BrowserFactory.valueOf(browserName.toUpperCase()).createDriver());
        }
    }


    // Getting the WebDriver instance for the current thread
    @Override
    public WebDriver getBrowser() {
        if (browser.get() == null) {
            throw new IllegalStateException("Browser has not been initialized. Call setBrowser() first.");
        }
        return browser.get();
    }

    @Override
    public void quitBrowser() {
        WebDriver driver = browser.get();
        if (driver != null) {
            try {
                driver.quit();
            } catch (Exception e) {
                System.out.println("Session already closed. Skipping quit.");
            } finally {
                browser.remove(); // Removing the instance from ThreadLocal
            }}}

}
