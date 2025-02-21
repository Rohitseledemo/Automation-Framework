package newDemoQaTest.switchToCompanyView;

import basePages.NewDemoBasePage;
import newDemoQaPages.*;
import newDemoQaPages.switchToCompanyView.SwitchToCompanyViewModal;
import newDemoQaPages.trackSavingsPage.TrackSavingsPage;
import baseTest.NewDemoBaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SwitchToCompanyViewModalTest extends NewDemoBaseTest {

    SwitchToCompanyViewModal switchToCompanyViewModal;
    NewDemoBasePage newDemoBasePage;
    TrackSavingsPage trackSavingsPage;
    NewDemoLandingPage newDemoLandingPage;

    @Test(testName ="Switch To Company View Function Test")
    public void switchToCompanyViewTest(){
        String pageTitle;
        switchToCompanyViewModal = new SwitchToCompanyViewModal();
        newDemoBasePage = new NewDemoBasePage();
        trackSavingsPage = new TrackSavingsPage();
        newDemoLandingPage = new NewDemoLandingPage();

        newDemoQALoginPage.launchUrl(this.url);
        newDemoQALoginPage.setEmailAddressNewDemo(this.email);
        newDemoQALoginPage.setPassword(this.password);
        newDemoQALoginPage.signInClick();
        newDemoBasePage.profileDropdownBtnClick();
        newDemoBasePage.switchCompanyViewBtnClick();
        switchToCompanyViewModal.searchTextBoxValue("Activ Post");
        newDemoLandingPage.clickOnTrackSavingsTab();
        pageTitle=trackSavingsPage.pageTitleValidation();
        Assert.assertEquals("Track Saving Dashboard",pageTitle);
    }

    @Test(testName ="Switch To Default View Function Test")
    public void switchToDefaultViewTest(){
        switchToCompanyViewModal = new SwitchToCompanyViewModal();
        newDemoBasePage = new NewDemoBasePage();
        trackSavingsPage = new TrackSavingsPage();
        newDemoLandingPage = new NewDemoLandingPage();

        newDemoQALoginPage.launchUrl(this.url);
        newDemoQALoginPage.setEmailAddressNewDemo(this.email);
        newDemoQALoginPage.setPassword(this.password);
        newDemoQALoginPage.signInClick();
        newDemoBasePage.profileDropdownBtnClick();
        newDemoBasePage.switchCompanyViewBtnClick();
    }
}
