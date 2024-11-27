package newDemoQaTest.demoPriorAgreementComparisonPageTest;

import newDemoQaPages.NewDemoLandingPage;
import newDemoQaPages.demoPriorAgreementComparisonPage.PriorAgreementComparisonPage;
import newDemoQaPages.demoPriorAgreementComparisonPage.ShipPlugInvoiceModal;
import newDemoQaTest.NewDemoBaseTest;
import org.testng.Assert;
import org.testng.annotations.*;

public class ShipPlugInvoiceModalTest extends NewDemoBaseTest {

    PriorAgreementComparisonPage priorAgreementComparison;
    ShipPlugInvoiceModal shipPlugInvoiceModal;
    NewDemoLandingPage newDemoLandingPage;

    @Test
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
        Assert.assertEquals(modalTitle,"ShipPlug Invoice Details");
        isVisible = shipPlugInvoiceModal.tableDataVisibility();
        Assert.assertTrue(isVisible);
    }

}
