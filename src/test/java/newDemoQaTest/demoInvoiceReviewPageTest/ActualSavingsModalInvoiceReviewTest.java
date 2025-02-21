package newDemoQaTest.demoInvoiceReviewPageTest;

import newDemoQaPages.BaseModal;
import newDemoQaPages.NewDemoLandingPage;
import newDemoQaPages.NewDemoQALoginPage;
import newDemoQaPages.demoInvoiceReviewPage.ActualSavingsModalInvoiceReview;
import newDemoQaPages.demoInvoiceReviewPage.InvoiceReviewPage;
import baseTest.NewDemoBaseTest;
import org.testng.Assert;
import org.testng.annotations.*;

public class ActualSavingsModalInvoiceReviewTest extends NewDemoBaseTest {

    NewDemoLandingPage newDemoLandingPage;
    InvoiceReviewPage invoiceReviewPage;
    ActualSavingsModalInvoiceReview actualSavingsModalInvoiceReview;
    BaseModal baseModal;


    @Test(testName = "IR-ActualSavings Modal Opening Test")
    public void actualSavingsModalInvoiceReviewOpeningTest(){
        boolean isDisplayed;
        newDemoQALoginPage = new NewDemoQALoginPage();
        newDemoLandingPage = new NewDemoLandingPage();
        invoiceReviewPage = new InvoiceReviewPage();
        actualSavingsModalInvoiceReview = new ActualSavingsModalInvoiceReview();
        baseModal = new BaseModal();

        newDemoQALoginPage.launchUrl(this.url);
        newDemoQALoginPage.setEmailAddressNewDemo(this.email);
        newDemoQALoginPage.setPassword(this.password);
        newDemoQALoginPage.signInClick();
        newDemoLandingPage.clickOnInvoiceReviewTile();
        invoiceReviewPage.clickActualSavingsCard();
//        actualSavingsModalInvoiceReview.switchToFrame();
    }

    @Test(testName = "IR-ActualSavings Modal Title Validation")
    public void actualSavingsModalInvoiceReviewTitleValidation(){
        String modalTitleExpected = "Actual Savings";
        String modalTitleActual;
        newDemoQALoginPage = new NewDemoQALoginPage();
        newDemoLandingPage = new NewDemoLandingPage();
        invoiceReviewPage = new InvoiceReviewPage();
        actualSavingsModalInvoiceReview = new ActualSavingsModalInvoiceReview();
        baseModal = new BaseModal();

        newDemoQALoginPage.launchUrl(this.url);
        newDemoQALoginPage.setEmailAddressNewDemo(this.email);
        newDemoQALoginPage.setPassword(this.password);
        newDemoQALoginPage.signInClick();
        newDemoLandingPage.clickOnInvoiceReviewTile();
        invoiceReviewPage.clickActualSavingsCard();
        modalTitleActual = actualSavingsModalInvoiceReview.modalTitleValidation();
        Assert.assertEquals(modalTitleActual,modalTitleExpected);
    }

}
