package utilities.browser;
import org.openqa.selenium.WebDriver;

public interface Browser {
    WebDriver getBrowser();
    void quitBrowser();
}
