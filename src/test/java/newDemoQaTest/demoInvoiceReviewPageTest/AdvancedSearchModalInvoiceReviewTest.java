package newDemoQaTest.demoInvoiceReviewPageTest;

import baseClass.NewDemoBasePage;
import newDemoQaPages.BaseModal;
import newDemoQaPages.NewDemoLandingPage;
import newDemoQaPages.NewDemoQALoginPage;
import newDemoQaPages.demoInvoiceReviewPage.AdvancedSearchModalInvoiceReview;
import newDemoQaPages.demoInvoiceReviewPage.InvoiceReviewPage;
import newDemoQaTest.NewDemoBaseTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;
import java.util.List;

public class AdvancedSearchModalInvoiceReviewTest extends NewDemoBaseTest{

    NewDemoLandingPage newDemoLandingPage;
    InvoiceReviewPage invoiceReviewPage;
    AdvancedSearchModalInvoiceReview advancedSearchModalInvoiceReview;
    NewDemoBasePage newDemoBasePage;
    BaseModal baseModal;

    @Test
    public void invoiceReviewAdvancedSearchModalValidation() throws InterruptedException {
        boolean result;
        int headerColumn;
        List<WebElement> elements;
        newDemoQALoginPage = new NewDemoQALoginPage();
        newDemoLandingPage = new NewDemoLandingPage();
        invoiceReviewPage = new InvoiceReviewPage();
        advancedSearchModalInvoiceReview = new AdvancedSearchModalInvoiceReview();
        newDemoBasePage = new NewDemoBasePage();
        baseModal= new BaseModal();

        newDemoQALoginPage.launchUrl(this.url);
        newDemoQALoginPage.setEmailAddressNewDemo(this.email);
        newDemoQALoginPage.setPassword(this.password);
        newDemoQALoginPage.signInClick();
        newDemoLandingPage.clickOnInvoiceReviewTile();
        invoiceReviewPage.clickAdvancedSearchTab();
        baseModal.isModalDisplayed(advancedSearchModalInvoiceReview.getModalTitle());
        //TC-1
        advancedSearchModalInvoiceReview.anyCheckboxDropdownRandomValues(advancedSearchModalInvoiceReview.
                getServiceTypeDropDown(),advancedSearchModalInvoiceReview.getServiceTypeDropDownElements());
        advancedSearchModalInvoiceReview.searchBtnClick();
//        Thread.sleep(5000);
        //TC-2
        headerColumn = invoiceReviewPage.headerClick("Service Type");
        elements = invoiceReviewPage.columnDataWebElements(headerColumn);
        result = advancedSearchModalInvoiceReview.dropdownAndColumnDataValidation(newDemoBasePage.getValueClickedNames(),elements,
                false);
        Assert.assertTrue(result);
    }

}