package newDemoQaTest.demoInvoiceReviewPageTest;

import newDemoQaPages.BaseModal;
import newDemoQaPages.NewDemoLandingPage;
import newDemoQaPages.NewDemoQALoginPage;
import newDemoQaPages.demoInvoiceReviewPage.InvoiceReviewPage;
import newDemoQaPages.demoInvoiceReviewPage.TotalMonthlySpendModal;
import newDemoQaTest.NewDemoBaseTest;
import org.testng.Assert;
import org.testng.annotations.*;

public class TotalMonthlySpendModalTest extends NewDemoBaseTest {

    NewDemoLandingPage newDemoLandingPage;
    InvoiceReviewPage invoiceReviewPage;
    TotalMonthlySpendModal totalMonthlySpendModal;
    BaseModal baseModal;

    @Test
    public void totalMonthlySpendModalTabsDataValidation(){
        boolean dataPresent;
        newDemoQALoginPage = new NewDemoQALoginPage();
        newDemoLandingPage = new NewDemoLandingPage();
        invoiceReviewPage = new InvoiceReviewPage();
        totalMonthlySpendModal = new TotalMonthlySpendModal();
        baseModal= new BaseModal();

        newDemoQALoginPage.launchUrl(this.url);
        newDemoQALoginPage.setEmailAddressNewDemo(this.email);
        newDemoQALoginPage.setPassword(this.password);
        newDemoQALoginPage.signInClick();
        newDemoLandingPage.clickOnInvoiceReviewTile();
        invoiceReviewPage.clickTotalMonthlySpendCard();
        //TC-1
        dataPresent = totalMonthlySpendModal.allTabsDataValidation();
        Assert.assertTrue(dataPresent);
    }

    @Test
    public void totalMonthlySpendModalAllTabsTableValidation(){
        boolean result;
        newDemoQALoginPage = new NewDemoQALoginPage();
        newDemoLandingPage = new NewDemoLandingPage();
        invoiceReviewPage = new InvoiceReviewPage();
        totalMonthlySpendModal = new TotalMonthlySpendModal();
        baseModal= new BaseModal();

        newDemoQALoginPage.launchUrl(this.url);
        newDemoQALoginPage.setEmailAddressNewDemo(this.email);
        newDemoQALoginPage.setPassword(this.password);
        newDemoQALoginPage.signInClick();
        newDemoLandingPage.clickOnInvoiceReviewTile();
        invoiceReviewPage.clickTotalMonthlySpendCard();
        //TC-1
        result = totalMonthlySpendModal.validateAllTabsTable ("Duty/Tax");
        Assert.assertTrue(result);
    }

    @Test(dataProvider = "getIndexData")
    public void totalMonthlySpendModalAllTabsDownloadBtnTest(int index){
        boolean isDisplayed;
        newDemoQALoginPage = new NewDemoQALoginPage();
        newDemoLandingPage = new NewDemoLandingPage();
        invoiceReviewPage = new InvoiceReviewPage();
        totalMonthlySpendModal = new TotalMonthlySpendModal();
        baseModal= new BaseModal();

        newDemoQALoginPage.launchUrl(this.url);
        newDemoQALoginPage.setEmailAddressNewDemo(this.email);
        newDemoQALoginPage.setPassword(this.password);
        newDemoQALoginPage.signInClick();
        newDemoLandingPage.clickOnInvoiceReviewTile();
        invoiceReviewPage.clickTotalMonthlySpendCard();
        totalMonthlySpendModal.parentTabsIterator(totalMonthlySpendModal.getParentTabs(),index);
        totalMonthlySpendModal.testDownloadButtonFunctionality();
    }

    @DataProvider
    public Object[] getIndexData(){
        Object[] data = new Object[3];
        data[0] = 0;
        data[1] = 1;
        data[2] = 2;
        return data;
    }

}
