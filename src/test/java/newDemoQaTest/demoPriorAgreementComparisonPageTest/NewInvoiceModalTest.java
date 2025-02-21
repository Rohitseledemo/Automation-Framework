package newDemoQaTest.demoPriorAgreementComparisonPageTest;

import basePages.NewDemoBasePage;
import newDemoQaPages.BaseModal;
import newDemoQaPages.NewDemoLandingPage;
import newDemoQaPages.NewDemoQALoginPage;
import newDemoQaPages.demoPriorAgreementComparisonPage.NewInvoiceModal;
import newDemoQaPages.demoPriorAgreementComparisonPage.PriorAgreementComparisonPage;
import baseTest.NewDemoBaseTest;
import org.testng.Assert;
import org.testng.annotations.*;

public class NewInvoiceModalTest extends NewDemoBaseTest {

    PriorAgreementComparisonPage priorAgreementComparisonPage;
    NewDemoLandingPage newDemoLandingPage;
    BaseModal baseModal;
    NewDemoBasePage newDemoBasePage;
    NewInvoiceModal newInvoiceModal;

    @Test(testName = "PAC-ProposedInvoice TabsDataValidation")
    public void proposedInvoiceModalTabsDataValidation(){
        boolean dataPresent;
        newDemoLandingPage = new NewDemoLandingPage();
        priorAgreementComparisonPage = new PriorAgreementComparisonPage();
        newDemoBasePage = new NewDemoBasePage();
        newInvoiceModal = new NewInvoiceModal();
        baseModal= new BaseModal();

        newDemoQALoginPage.launchUrl(this.url);
        newDemoQALoginPage.setEmailAddressNewDemo(this.email);
        newDemoQALoginPage.setPassword(this.password);
        newDemoQALoginPage.signInClick();
        newDemoLandingPage.clickOnPriorAgreementComparisonTile();
        priorAgreementComparisonPage.newInvoiceClick();
        //TC-1
        dataPresent = newInvoiceModal.allTabsDataValidation();
        Assert.assertTrue(dataPresent,"Data Missing in one or more tabs of Proposed Invoice Modal.");
    }
    @Test(testName = "Current Invoice SpendAndVolume Table Validation")
    public void spendAndVolumeTableValidation() {
        boolean result;
        newDemoQALoginPage = new NewDemoQALoginPage();
        newDemoLandingPage = new NewDemoLandingPage();
        priorAgreementComparisonPage = new PriorAgreementComparisonPage();
        newInvoiceModal = new NewInvoiceModal();
        baseModal= new BaseModal();

        newDemoQALoginPage.launchUrl(this.url);
        newDemoQALoginPage.setEmailAddressNewDemo(this.email);
        newDemoQALoginPage.setPassword(this.password);
        newDemoQALoginPage.signInClick();
        newDemoLandingPage.clickOnPriorAgreementComparisonTile();
        priorAgreementComparisonPage.newInvoiceClick();
        //TC-1
        newInvoiceModal.spendAndVolumeTabClick();
        result = newInvoiceModal.spendAndVolumeTabValidation("Duty/Tax");
        Assert.assertTrue(result,"|Duty/Tax| Column in the table has either Missing/Wrong data.");
    }

    @Test(testName = "Current Invoice Tabs Download Func Test",dataProvider = "getTabName")
    public void totalMonthlySpendModalAllTabsDownloadBtnTest(String tabName){
        boolean isDisplayed;
        newDemoQALoginPage = new NewDemoQALoginPage();
        newDemoLandingPage = new NewDemoLandingPage();
        priorAgreementComparisonPage = new PriorAgreementComparisonPage();
        newDemoBasePage = new NewDemoBasePage();
        newInvoiceModal = new NewInvoiceModal();
        baseModal= new BaseModal();

        newDemoQALoginPage.launchUrl(this.url);
        newDemoQALoginPage.setEmailAddressNewDemo(this.email);
        newDemoQALoginPage.setPassword(this.password);
        newDemoQALoginPage.signInClick();
        newDemoLandingPage.clickOnPriorAgreementComparisonTile();
        priorAgreementComparisonPage.newInvoiceClick();

        if (tabName.equalsIgnoreCase("Surcharge Trend")) {
            newInvoiceModal.surchargeTrendTabClick();
            isDisplayed = newInvoiceModal.testDownloadButtonFunctionality2();
            softAssert.assertTrue(isDisplayed, "Download Confirmation Toast Not Displayed Surcharge Trend Tab.");
        }
        if (tabName.equalsIgnoreCase("Spend And Volume")) {
            newInvoiceModal.spendAndVolumeTabClick();
            isDisplayed= newInvoiceModal.testDownloadButtonFunctionality2();
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
