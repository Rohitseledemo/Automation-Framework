package newDemoQaTest.demoRefundsPageTest.refundsForLateShipmentRefunds;

import newDemoQaPages.BaseModal;
import newDemoQaPages.NewDemoLandingPage;
import newDemoQaPages.NewDemoQALoginPage;
import newDemoQaPages.demoPriorAgreementComparisonPage.PriorAgreementComparisonPage;
import newDemoQaPages.demoRefundsPage.RefundsPage;
import newDemoQaPages.demoRefundsPage.refundsForLateShipment.ActualSavingsModalRefunds;
import newDemoQaPages.demoRefundsPage.refundsForLateShipment.PotentialCreditsRefundsModalRefunds;
import newDemoQaTest.NewDemoBaseTest;
import org.testng.Assert;
import org.testng.annotations.*;

public class ActualSavingsModalRefundsTest extends NewDemoBaseTest{

    NewDemoLandingPage newDemoLandingPage;
    ActualSavingsModalRefunds actualSavingsModalRefunds;
    RefundsPage refundsPage;
    BaseModal baseModal;

    @Test
    public void actualSavingsDataAvailabilityTest(){
        boolean isDisplayed;
        newDemoLandingPage = new NewDemoLandingPage();
        actualSavingsModalRefunds = new ActualSavingsModalRefunds();
        refundsPage = new RefundsPage();
        baseModal = new BaseModal();

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
