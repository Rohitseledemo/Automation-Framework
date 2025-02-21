package baseTest;

import newDemoQaPages.NewDemoQALoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;
import utilities.browser.BrowserManager;
import utilities.config.NewDemoConfigReader;

import java.net.MalformedURLException;

public class NewDemoBaseTest {
    protected String url, email, password, browserName;
    protected NewDemoQALoginPage newDemoQALoginPage;
    protected SoftAssert softAssert;
    private BrowserManager browserManager;

    @BeforeMethod(alwaysRun = true)
    public void launchBrowser() throws MalformedURLException {
        String resolvedBrowserName = browserName != null ? browserName : NewDemoConfigReader.getProperty("browser");

        this.url = NewDemoConfigReader.getProperty("url");
        this.email = NewDemoConfigReader.getProperty("email");
        this.password = NewDemoConfigReader.getProperty("password");

        newDemoQALoginPage = new NewDemoQALoginPage();
        softAssert = new SoftAssert();

        browserManager = BrowserManager.getInstance();
        browserManager.setBrowser(resolvedBrowserName);
        browserManager.getBrowser();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (browserManager!= null) {
            browserManager.quitBrowser();
        }
    }
}
