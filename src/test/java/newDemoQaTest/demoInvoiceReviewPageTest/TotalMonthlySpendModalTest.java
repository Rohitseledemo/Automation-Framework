package newDemoQaTest.demoInvoiceReviewPageTest;

import newDemoQaPages.BaseModal;
import newDemoQaPages.NewDemoLandingPage;
import newDemoQaPages.NewDemoQALoginPage;
import newDemoQaPages.demoInvoiceReviewPage.InvoiceReviewPage;
import newDemoQaPages.demoInvoiceReviewPage.TotalMonthlySpendModal;
import baseTest.NewDemoBaseTest;
import org.testng.Assert;
import org.testng.annotations.*;

public class TotalMonthlySpendModalTest extends NewDemoBaseTest {

    NewDemoLandingPage newDemoLandingPage;
    InvoiceReviewPage invoiceReviewPage;
    TotalMonthlySpendModal totalMonthlySpendModal;
    BaseModal baseModal;

    @Test(testName = "TotalMonthlySpend Tabs Data Verification")
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
        Assert.assertTrue(dataPresent,"Some Data is not present on 1 or more number of tabs.");
    }

    @Test(testName = "TotalMonthlySpend SpendAndVolume Table Validation")
    public void spendAndVolumeTableValidation() {
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
        totalMonthlySpendModal.spendAndVolumeTabClick();
        result = totalMonthlySpendModal.spendAndVolumeTabValidation("Duty/Tax");
        Assert.assertTrue(result,"|Duty/Tax| Column in the table has either Missing/Wrong data.");
    }

    @Test(testName = "TotalMonthlySpend Download Func Test",dataProvider = "getTabName")
    public void totalMonthlySpendModalAllTabsDownloadBtnTest(String tabName){
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

        if (tabName.equalsIgnoreCase("Surcharge Trend")) {
            totalMonthlySpendModal.surchargeTrendTabClick();
            isDisplayed = totalMonthlySpendModal.testDownloadButtonFunctionality2();
            softAssert.assertTrue(isDisplayed, "Download Confirmation Toast Not Displayed Surcharge Trend Tab.");
        }
        if (tabName.equalsIgnoreCase("Spend And Volume")) {
        totalMonthlySpendModal.spendAndVolumeTabClick();
        isDisplayed= totalMonthlySpendModal.testDownloadButtonFunctionality2();
        softAssert.assertTrue(isDisplayed,"Download Confirmation Toast Not Displayed in Spend And Volume Tab.");
        }
        softAssert.assertAll();
    }


    @DataProvider(name = "getIndexData", parallel = true)
    public Object[] getIndexData(){
        Object[] data = new Object[3];
        data[0] = 0;
        data[1] = 1;
        data[2] = 2;
        return data;
    }
    @DataProvider(name = "getTabName",parallel = true)
    public Object[] getTabName(){
        return new Object[]{"Surcharge Trend","Spend And Volume"};
    }


}
