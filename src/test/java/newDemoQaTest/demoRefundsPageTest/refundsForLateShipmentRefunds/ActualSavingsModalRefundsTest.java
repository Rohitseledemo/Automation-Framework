package newDemoQaTest.demoRefundsPageTest.refundsForLateShipmentRefunds;

import newDemoQaPages.BaseModal;
import newDemoQaPages.NewDemoLandingPage;
import newDemoQaPages.demoRefundsPage.RefundsPage;
import newDemoQaPages.demoRefundsPage.refundsForLateShipment.ActualSavingsModalRefunds;
import newDemoQaTest.NewDemoBaseTest;
import org.testng.Assert;
import org.testng.annotations.*;

public class ActualSavingsModalRefundsTest extends NewDemoBaseTest{

    NewDemoLandingPage newDemoLandingPage;
    ActualSavingsModalRefunds actualSavingsModalRefunds;
    RefundsPage refundsPage;

    @Test
    public void actualSavingsDataAvailabilityTest(){
        boolean isDisplayed;
        newDemoLandingPage = new NewDemoLandingPage();
        actualSavingsModalRefunds = new ActualSavingsModalRefunds();
        refundsPage = new RefundsPage();

        newDemoQALoginPage.launchUrl(this.url);
        newDemoQALoginPage.setEmailAddressNewDemo(this.email);
        newDemoQALoginPage.setPassword(this.password);
        newDemoQALoginPage.signInClick();
        newDemoLandingPage.clickOnRefundsTile();
        refundsPage.percentageLateTabClick();
        refundsPage.actualSavingsRefundBtnClick();
        isDisplayed = actualSavingsModalRefunds.verifyNoDataAvailable();
        Assert.assertFalse(isDisplayed);
    }



}
