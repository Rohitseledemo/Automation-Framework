package newDemoQaTest.demoPriorAgreementComparisonPageTest;

import baseClass.NewDemoBasePage;
import newDemoQaPages.BaseModal;
import newDemoQaPages.NewDemoLandingPage;
import newDemoQaPages.NewDemoQALoginPage;
import newDemoQaPages.demoPriorAgreementComparisonPage.NewInvoiceModal;
import newDemoQaPages.demoPriorAgreementComparisonPage.PriorAgreementComparisonPage;
import newDemoQaTest.NewDemoBaseTest;
import org.testng.Assert;
import org.testng.annotations.*;

public class NewInvoiceModalTest extends NewDemoBaseTest {

    PriorAgreementComparisonPage priorAgreementComparisonPage;
    NewDemoLandingPage newDemoLandingPage;
    BaseModal baseModal;
    NewDemoBasePage newDemoBasePage;
    NewInvoiceModal newInvoiceModal;

    @Test
    public void newInvoiceModalTabsDataValidation(){
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
        Assert.assertTrue(dataPresent);
    }
    @Test
    public void allTabsTableValidation(){
        boolean result;
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
        result = newInvoiceModal.validateAllTabsTable ("Surcharge");
        Assert.assertTrue(result);
    }
    @Test(dataProvider = "getIndexData")
    public void allTabsDownloadBtnTest(int index){
        boolean isDisplayed;
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
        newInvoiceModal.parentTabsIterator(newInvoiceModal.getParentTabs(),index);
        isDisplayed = newInvoiceModal.testDownloadButtonFunctionality2();
        Assert.assertTrue(isDisplayed);
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
