package newDemoQaTest.demoInvoiceReviewPageTest;

import newDemoQaPages.BaseModal;
import newDemoQaPages.NewDemoLandingPage;
import newDemoQaPages.NewDemoQALoginPage;
import newDemoQaPages.demoInvoiceReviewPage.InvoiceReviewPage;
import newDemoQaPages.demoInvoiceReviewPage.topBoxSizesModals.TopBoxSizesModalFirstLevel;
import newDemoQaPages.demoInvoiceReviewPage.topBoxSizesModals.TopBoxSizesModalSecondLevel;
import baseTest.NewDemoBaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.*;
import java.util.ArrayList;

public class TopBoxSizesModalTest extends NewDemoBaseTest {

    NewDemoLandingPage newDemoLandingPage;
    InvoiceReviewPage invoiceReviewPage;
    TopBoxSizesModalFirstLevel topBoxSizesModalFirstLevel;
    TopBoxSizesModalSecondLevel topBoxSizesModalSecondLevel;
    BaseModal baseModal;

    @Test(testName = "TopBoxSizes 1Lvl Modal Test")
    public void topBoxSizesFirstLevelModalTest(){
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

    @Test(testName = "TopBoxSizes 2Lvl Modal Test",dataProvider = "getData")
    public void topBoxSizesSecondLevelModalTest(String serviceName){
        int headerColumnNum, pageNo;
        ArrayList<Float> values;
        boolean isDisplayed,sorted,downloadCsv;

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
        softAssert.assertTrue(sorted,"|Current Invoiced Amount| Column values not Sorted.");
        //TC-5
        downloadCsv = topBoxSizesModalSecondLevel.testDownloadButtonFunctionality2();
        softAssert.assertTrue(downloadCsv,"Download Confirmation Toast not seen.");
        //TC-6
        isDisplayed = topBoxSizesModalSecondLevel.trackingNumberValidation();
        softAssert.assertTrue(isDisplayed,"Tracking Number Modal is not Displayed.");
        softAssert.assertAll();
    }

    @Test(testName = "TopBoxSizes Download Functionality Test")
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
        softAssert.assertEquals(title,"Dimensional Weight Impact");
        //TC-2
        downloadText = topBoxSizesModalFirstLevel.testDownloadButtonFunctionality();
        softAssert.assertTrue(downloadText);
        softAssert.assertAll();
    }
    @Test(testName = "TopBoxSizes Service Dropdown Test",dataProvider = "getServiceIterator")
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
    @Test(testName = "TopBoxSizes Time-Period Dropdown Test",dataProvider = "getMonthIterator")
    public void timePeriodDropdownIteratorTBSModal(int monthIndex) {
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
        By timePeriodDropdown = topBoxSizesModalFirstLevel.getTimePeriodDropdown();
        By timePeriodDropdownElements = topBoxSizesModalFirstLevel.getTimePeriodDropdownElements();
        topBoxSizesModalFirstLevel.anyDropdownIterator(timePeriodDropdown, timePeriodDropdownElements,monthIndex);
    }

    @DataProvider(name = "getServiceIterator", parallel = true)
    public Object[] getServiceIterator(){
        return new Object[] {1,2};
    }

    @DataProvider(name = "getData", parallel = true)
    public String[][] getData(){
        return new String[][] { {"Express"}, {"Ground"} };
    }
    @DataProvider(name = "getMonthIterator", parallel = true)
    public Object[] getMonthIterator(){
        return new Object[] {1,2,3};
    }

}
