package newDemoQaTest.demoPriorAgreementComparisonPageTest;

import newDemoQaPages.NewDemoLandingPage;
import newDemoQaPages.demoPriorAgreementComparisonPage.PriorAgreementComparisonPage;
import newDemoQaPages.demoPriorAgreementComparisonPage.ShipPlugInvoiceModal;
import baseTest.NewDemoBaseTest;
import org.testng.Assert;
import org.testng.annotations.*;

public class ShipPlugInvoiceModalTest extends NewDemoBaseTest {

    PriorAgreementComparisonPage priorAgreementComparison;
    ShipPlugInvoiceModal shipPlugInvoiceModal;
    NewDemoLandingPage newDemoLandingPage;

    @Test(testName = "PAC-ShipPlugInvoice Modal Test")
    public void shipPlugInvoiceModalTest(){
        String modalTitle;
        boolean isVisible;
        newDemoLandingPage = new NewDemoLandingPage();
        priorAgreementComparison = new PriorAgreementComparisonPage();
        shipPlugInvoiceModal = new ShipPlugInvoiceModal();

        newDemoQALoginPage.launchUrl(this.url);
        newDemoQALoginPage.setEmailAddressNewDemo(this.email);
        newDemoQALoginPage.setPassword(this.password);
        newDemoQALoginPage.signInClick();
        newDemoLandingPage.clickOnPriorAgreementComparisonTile();
        priorAgreementComparison.shipPlugInvoiceClick();
        modalTitle = shipPlugInvoiceModal.modalTitleValidation();
        softAssert.assertEquals(modalTitle,"ShipPlug Invoice Details");
        isVisible = shipPlugInvoiceModal.tableDataVisibility();
        softAssert.assertTrue(isVisible);
        softAssert.assertAll();
    }

    @Test(testName = "PAC-ShipPlugInvoice DownloadBtn Test")
    public void shipPlugInvoiceDownloadBtnTest(){
        boolean isDisplayed;
        newDemoLandingPage = new NewDemoLandingPage();
        priorAgreementComparison = new PriorAgreementComparisonPage();
        shipPlugInvoiceModal = new ShipPlugInvoiceModal();

        newDemoQALoginPage.launchUrl(this.url);
        newDemoQALoginPage.setEmailAddressNewDemo(this.email);
        newDemoQALoginPage.setPassword(this.password);
        newDemoQALoginPage.signInClick();
        newDemoLandingPage.clickOnPriorAgreementComparisonTile();
        priorAgreementComparison.shipPlugInvoiceClick();
        isDisplayed = shipPlugInvoiceModal.testDownloadButtonFunctionality2();
        Assert.assertTrue(isDisplayed,"Download Confirmation Toast Not Displayed.");
    }

}
