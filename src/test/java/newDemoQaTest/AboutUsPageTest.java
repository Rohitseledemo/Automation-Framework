package newDemoQaTest;

import baseTest.NewDemoBaseTest;
import newDemoQaPages.*;
import org.testng.Assert;
import org.testng.annotations.*;

public class AboutUsPageTest extends NewDemoBaseTest {
    NewDemoLandingPage newDemoLandingPage;
    AboutUsPage aboutUsPage;
    BaseModal baseModal;

    @Test(testName="About-Us Page TagLine Visibility Test")
    public void aboutUsPageTest(){
        boolean isVisible;
        newDemoLandingPage = new NewDemoLandingPage();
        aboutUsPage = new AboutUsPage();
        baseModal = new BaseModal();

        newDemoQALoginPage.launchUrl(this.url);
        newDemoQALoginPage.setEmailAddressNewDemo(this.email);
        newDemoQALoginPage.setPassword(this.password);
        newDemoQALoginPage.signInClick();
        newDemoLandingPage.clickOnAboutUs();
        isVisible = aboutUsPage.tagLineVisibility();
        Assert.assertTrue(isVisible);
    }

}
