package newDemoQaTest.demoInvoiceReviewPageTest;

import newDemoQaPages.NewDemoLandingPage;
import newDemoQaPages.NewDemoQALoginPage;
import newDemoQaPages.demoInvoiceReviewPage.InvoiceReviewPage;
import newDemoQaPages.demoInvoiceReviewPage.NicknameAccountsModalInvoiceReview;
import newDemoQaPages.demoInvoiceReviewPage.surchargeSpendModals.SurchargeSpendModalFirstLevel;
import newDemoQaPages.demoInvoiceReviewPage.surchargeSpendModals.SurchargeSpendModalSecondLevel;
import newDemoQaTest.NewDemoBaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NicknameAccountsModalInvoiceReviewTest extends NewDemoBaseTest {
    NewDemoLandingPage newDemoLandingPage;
    NicknameAccountsModalInvoiceReview nicknameAccountsModalInvoiceReview;
    InvoiceReviewPage invoiceReviewPage;
    SurchargeSpendModalFirstLevel surchargeSpendModalFirstLevel;
    SurchargeSpendModalSecondLevel surchargeSpendModalSecondLevel;

    @Test
    public void nicknameModalInvoiceReviewTitleValidation(){
        String modalTitleActual;
        boolean isClosed;
        newDemoQALoginPage = new NewDemoQALoginPage();
        newDemoLandingPage = new NewDemoLandingPage();
        invoiceReviewPage = new InvoiceReviewPage();
        nicknameAccountsModalInvoiceReview = new NicknameAccountsModalInvoiceReview();

        newDemoQALoginPage.launchUrl(this.url);
        newDemoQALoginPage.setEmailAddressNewDemo(this.email);
        newDemoQALoginPage.setPassword(this.password);
        newDemoQALoginPage.signInClick();
        newDemoLandingPage.clickOnPriorAgreementComparisonTile();
        invoiceReviewPage.nicknameAccountsBtnInvoiceReviewClick();
        modalTitleActual = nicknameAccountsModalInvoiceReview.modalTitleValidation();
        Assert.assertEquals(modalTitleActual,"Nickname Accounts");
        isClosed = nicknameAccountsModalInvoiceReview.closeModal();
        Assert.assertTrue(isClosed);
    }

    @Test
    public void nicknameAccountsTableValidationInvoiceReview(){
        boolean isClicked;
        newDemoQALoginPage = new NewDemoQALoginPage();
        newDemoLandingPage = new NewDemoLandingPage();
        invoiceReviewPage = new InvoiceReviewPage();
        nicknameAccountsModalInvoiceReview = new NicknameAccountsModalInvoiceReview();

        newDemoQALoginPage.launchUrl(this.url);
        newDemoQALoginPage.setEmailAddressNewDemo(this.email);
        newDemoQALoginPage.setPassword(this.password);
        newDemoQALoginPage.signInClick();
        newDemoLandingPage.clickOnPriorAgreementComparisonTile();
        invoiceReviewPage.nicknameAccountsBtnInvoiceReviewClick();
        nicknameAccountsModalInvoiceReview.addNicknameValue();
        isClicked = nicknameAccountsModalInvoiceReview.submitBtnClick();
        Assert.assertTrue(isClicked);
    }
    @Test
    public void nicknameAccountsChangesValidation(){
        boolean result;
        newDemoQALoginPage = new NewDemoQALoginPage();
        newDemoLandingPage = new NewDemoLandingPage();
        invoiceReviewPage = new InvoiceReviewPage();
        surchargeSpendModalFirstLevel = new SurchargeSpendModalFirstLevel();
        surchargeSpendModalSecondLevel = new SurchargeSpendModalSecondLevel();
        nicknameAccountsModalInvoiceReview = new NicknameAccountsModalInvoiceReview();

        newDemoQALoginPage.launchUrl(this.url);
        newDemoQALoginPage.setEmailAddressNewDemo(this.email);
        newDemoQALoginPage.setPassword(this.password);
        newDemoQALoginPage.signInClick();
        newDemoLandingPage.clickOnInvoiceReviewTile();
        invoiceReviewPage.nicknameAccountsBtnInvoiceReviewClick();
        String str = nicknameAccountsModalInvoiceReview.addNicknameValue();
        nicknameAccountsModalInvoiceReview.submitBtnClick();
        nicknameAccountsModalInvoiceReview.closeModal();
        invoiceReviewPage.clickSurchargeSpendCard();
        surchargeSpendModalFirstLevel.anySurchargeTypeClick("FUEL SURCHARGE");
        //TC-1
        nicknameAccountsModalInvoiceReview.nicknameDropdownInSurchargeSavingsClick();
        By nicknameAccountsDropdownElements = nicknameAccountsModalInvoiceReview.getNicknameDropdownElements();
        result = nicknameAccountsModalInvoiceReview.stringValueSearch(str, nicknameAccountsDropdownElements);
        Assert.assertTrue(result);
    }
}
