package newDemoQaTest.demoInvoiceReviewPageTest;

import newDemoQaPages.BaseModal;
import newDemoQaPages.NewDemoLandingPage;
import newDemoQaPages.NewDemoQALoginPage;
import newDemoQaPages.demoInvoiceReviewPage.InvoiceReviewPage;
import newDemoQaPages.demoInvoiceReviewPage.surchargeSpendModals.SurchargeSpendModalFirstLevel;
import newDemoQaPages.demoInvoiceReviewPage.topBoxSizesModals.TopBoxSizesModalFirstLevel;
import newDemoQaPages.demoInvoiceReviewPage.topBoxSizesModals.TopBoxSizesModalSecondLevel;
import newDemoQaTest.NewDemoBaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;
import java.util.ArrayList;

public class TopBoxSizesModalTest extends NewDemoBaseTest {

    NewDemoLandingPage newDemoLandingPage;
    InvoiceReviewPage invoiceReviewPage;
    TopBoxSizesModalFirstLevel topBoxSizesModalFirstLevel;
    TopBoxSizesModalSecondLevel topBoxSizesModalSecondLevel;
    BaseModal baseModal;

    @Test
    public void topBoxSizesFirstLevelModalTest(){
        boolean validate;
        boolean validate1;
        newDemoQALoginPage = new NewDemoQALoginPage();
        newDemoLandingPage = new NewDemoLandingPage();
        invoiceReviewPage = new InvoiceReviewPage();
        topBoxSizesModalFirstLevel = new TopBoxSizesModalFirstLevel();
        baseModal = new BaseModal();

        newDemoQALoginPage.launchUrl(this.url);
        newDemoQALoginPage.setEmailAddressNewDemo(this.email);
        newDemoQALoginPage.setPassword(this.password);
        newDemoQALoginPage.signInClick();
        newDemoLandingPage.clickOnInvoiceReviewTile();
        invoiceReviewPage.clickTopBoxSizesCard();
        //this is to validate the landing service name and table.
        topBoxSizesModalFirstLevel.anyCheckboxDropdownRandomValues(topBoxSizesModalFirstLevel.
                getServiceDropdown(),topBoxSizesModalFirstLevel.getServiceDropdownElements());
    }

    @Test(dataProvider = "getData")
    public void topBoxSizesSecondLevelModalTest(String serviceName){
        int headerColumnNum, pageNo;
        ArrayList<Float> values;
        boolean isDisplayed;
        boolean sorted;
        boolean downloadCsv;

        newDemoQALoginPage = new NewDemoQALoginPage();
        newDemoLandingPage = new NewDemoLandingPage();
        invoiceReviewPage = new InvoiceReviewPage();
        topBoxSizesModalFirstLevel = new TopBoxSizesModalFirstLevel();
        topBoxSizesModalSecondLevel = new TopBoxSizesModalSecondLevel();
        baseModal = new BaseModal();

        newDemoQALoginPage.launchUrl(this.url);
        newDemoQALoginPage.setEmailAddressNewDemo(this.email);
        newDemoQALoginPage.setPassword(this.password);
        newDemoQALoginPage.signInClick();
        newDemoLandingPage.clickOnInvoiceReviewTile();
        invoiceReviewPage.clickTopBoxSizesCard();
        if(serviceName.equalsIgnoreCase("Express")){
            topBoxSizesModalFirstLevel.clickOnServiceByName(serviceName);
        }
        if (serviceName.equalsIgnoreCase("Ground")){
            topBoxSizesModalFirstLevel.clickOnServiceByName(serviceName);
        }
        //TC-1
        topBoxSizesModalFirstLevel.getTableColumn("Count");
        topBoxSizesModalFirstLevel.getColumnValues();
        //TC-2
        pageNo = baseModal.paginationClick(2);
        topBoxSizesModalSecondLevel.pageSerialNoValidator(pageNo);
        //TC-3
        headerColumnNum = topBoxSizesModalSecondLevel.headerClick("Current Invoiced Amount");
        values = baseModal.columnData(headerColumnNum);
        //TC-4
        sorted =  baseModal.sortingValidation(values);
        Assert.assertTrue(sorted);
        //TC-5
        downloadCsv = topBoxSizesModalSecondLevel.testDownloadButtonFunctionality2();
        Assert.assertTrue(downloadCsv);
        //TC-6
        isDisplayed = topBoxSizesModalSecondLevel.trackingNumberValidation();
        Assert.assertTrue(isDisplayed);
    }

    @Test
    public void topBoxSizesDownloadFunctionalityTest(){
        boolean downloadText;

        newDemoQALoginPage = new NewDemoQALoginPage();
        newDemoLandingPage = new NewDemoLandingPage();
        invoiceReviewPage = new InvoiceReviewPage();
        topBoxSizesModalFirstLevel = new TopBoxSizesModalFirstLevel();
        topBoxSizesModalSecondLevel = new TopBoxSizesModalSecondLevel();
        baseModal = new BaseModal();

        newDemoQALoginPage.launchUrl(this.url);
        newDemoQALoginPage.setEmailAddressNewDemo(this.email);
        newDemoQALoginPage.setPassword(this.password);
        newDemoQALoginPage.signInClick();
        newDemoLandingPage.clickOnInvoiceReviewTile();
        invoiceReviewPage.clickTopBoxSizesCard();
        //TC-1
        String title = baseModal.modalTitleValidation();
        Assert.assertEquals(title,"Dimensional Weight Impact");
        //TC-2
        downloadText = topBoxSizesModalFirstLevel.testDownloadButtonFunctionality();
        Assert.assertTrue(downloadText);
    }
    @Test(dataProvider = "getServiceIterator")
    public void carrierServiceDropdownIterator(int serviceIndex){
        newDemoQALoginPage = new NewDemoQALoginPage();
        newDemoLandingPage = new NewDemoLandingPage();
        topBoxSizesModalFirstLevel = new TopBoxSizesModalFirstLevel();
        invoiceReviewPage = new InvoiceReviewPage();
        baseModal = new BaseModal();

        newDemoQALoginPage.launchUrl(this.url);
        newDemoQALoginPage.setEmailAddressNewDemo(this.email);
        newDemoQALoginPage.setPassword(this.password);
        newDemoQALoginPage.signInClick();
        newDemoLandingPage.clickOnInvoiceReviewTile();
        invoiceReviewPage.clickTopBoxSizesCard();
        By carrierServiceDropdown = topBoxSizesModalFirstLevel.getCarrierServiceDropdown();
        By carrierServiceDropdownElements = topBoxSizesModalFirstLevel.getCarrierServiceDropdownElements();
        topBoxSizesModalFirstLevel.anyDropdownIterator(carrierServiceDropdown, carrierServiceDropdownElements,serviceIndex);
    }

    @DataProvider
    public Object[] getServiceIterator(){
        return new Object[] {1,2};
    }

    @DataProvider
    public String[][] getData(){
        return new String[][] { {"Express"}, {"Ground"} };
    }

}
