package newDemoQaTest.demoRefundsPageTest.refundsForLateShipmentRefunds;

import newDemoQaPages.BaseModal;
import newDemoQaPages.NewDemoLandingPage;
import newDemoQaPages.demoRefundsPage.RefundsPage;
import newDemoQaPages.demoRefundsPage.refundsForLateShipment.PotentialCreditsRefundsModalRefunds;
import newDemoQaTest.NewDemoBaseTest;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.ArrayList;

public class PotentialCreditsRefundsModalRefundsTest extends NewDemoBaseTest {

    NewDemoLandingPage newDemoLandingPage;
    PotentialCreditsRefundsModalRefunds potentialCreditsRefundsModalRefunds;
    RefundsPage refundsPage;
    BaseModal baseModal;


    @Test
    public void potentialCreditsRefundsModalTest(){
        int headerColumnCount;
        ArrayList<Float> values;
        boolean sorted;
        newDemoLandingPage = new NewDemoLandingPage();
        potentialCreditsRefundsModalRefunds = new PotentialCreditsRefundsModalRefunds();
        refundsPage = new RefundsPage();
        baseModal = new BaseModal();

        newDemoQALoginPage.launchUrl(this.url);
        newDemoQALoginPage.setEmailAddressNewDemo(this.email);
        newDemoQALoginPage.setPassword(this.password);
        newDemoQALoginPage.signInClick();
        newDemoLandingPage.clickOnRefundsTile();
        refundsPage.percentageLateTabClick();
        refundsPage.potentialSavingsRefundBtnClick();
        //TC-1
        potentialCreditsRefundsModalRefunds.paginationClick(2);
        potentialCreditsRefundsModalRefunds.pageSerialNoValidator(2);
        //TC-2
        headerColumnCount = potentialCreditsRefundsModalRefunds.headerClick("Refund Amount");
        values = potentialCreditsRefundsModalRefunds.columnData(headerColumnCount);
        sorted = baseModal.sortingValidation(values);
        Assert.assertTrue(sorted);
    }

    @Test
    public void potentialCreditRefundsModalInRefundsDownloadTest(){
        boolean isDisplayed;
        newDemoLandingPage = new NewDemoLandingPage();
        potentialCreditsRefundsModalRefunds = new PotentialCreditsRefundsModalRefunds();
        refundsPage = new RefundsPage();
        baseModal = new BaseModal();

        newDemoQALoginPage.launchUrl(this.url);
        newDemoQALoginPage.setEmailAddressNewDemo(this.email);
        newDemoQALoginPage.setPassword(this.password);
        newDemoQALoginPage.signInClick();
        newDemoLandingPage.clickOnRefundsTile();
        refundsPage.percentageLateTabClick();
        refundsPage.potentialSavingsRefundBtnClick();
        isDisplayed = potentialCreditsRefundsModalRefunds.testDownloadButtonFunctionality2();
        Assert.assertTrue(isDisplayed);
    }

}
