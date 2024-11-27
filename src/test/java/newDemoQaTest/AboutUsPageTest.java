package newDemoQaTest;

import newDemoQaPages.*;
import org.testng.annotations.*;

public class AboutUsPageTest extends NewDemoBaseTest{
    NewDemoLandingPage newDemoLandingPage;
    AboutUsPage aboutUsPage;
    BaseModal baseModal;

    @Test
    public void aboutUsPageTest(){
        newDemoLandingPage = new NewDemoLandingPage();
        aboutUsPage = new AboutUsPage();
        baseModal = new BaseModal();

        newDemoQALoginPage.launchUrl(this.url);
        newDemoQALoginPage.setEmailAddressNewDemo(this.email);
        newDemoQALoginPage.setPassword(this.password);
        newDemoQALoginPage.signInClick();
        newDemoLandingPage.clickOnAboutUs();
        aboutUsPage.tagLineVisibility();
    }

}
