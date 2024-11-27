package newDemoQaTest;

import newDemoQaPages.NewDemoQALoginPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import utility.BrowserKeeper;

import java.net.MalformedURLException;

public class NewDemoBaseTest {
    protected String url, email, password;
    protected NewDemoQALoginPage newDemoQALoginPage;

    @BeforeMethod(alwaysRun = true)
    @Parameters({"Email", "Password", "URL"})
        public void launchBrowser(@Optional("admin@123.com") String Email,
                @Optional("admin2024!") String Password,
                @Optional("https://demo.com/") String Url)
            throws MalformedURLException {

        this.url = Url;
        this.email = Email;
        this.password = Password;

        newDemoQALoginPage = new NewDemoQALoginPage();
        BrowserKeeper.getInstance().setupWebDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void closeApplication () {
        BrowserKeeper.getInstance().quitBrowserInstance();
    }
}
