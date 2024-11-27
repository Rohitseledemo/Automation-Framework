package newDemoQaTest.demoInvoiceReviewPageTest;

import baseClass.NewDemoBasePage;
import newDemoQaPages.BaseModal;
import newDemoQaPages.NewDemoLandingPage;
import newDemoQaPages.NewDemoQALoginPage;
import newDemoQaPages.demoInvoiceReviewPage.*;
import newDemoQaPages.demoInvoiceReviewPage.surchargeSpendModals.*;
import newDemoQaTest.NewDemoBaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.List;

public class SurchargeSpendModalTest extends NewDemoBaseTest{

    NewDemoLandingPage newDemoLandingPage;
    InvoiceReviewPage invoiceReviewPage;
    SurchargeSpendModalFirstLevel surchargeSpendModalFirstLevel;
    SurchargeSpendModalSecondLevel surchargeSpendModalSecondLevel;
    SurchargeSpendTrendModal surchargeSpendTrendModal;
    SurchargeSpendDetailsModal surchargeSpendDetailsModal;
    SurchargeSpendDetailsModalSecondLevel surchargeSpendDetailsModalSecondLevel;
    BaseModal baseModal;
    NewDemoBasePage newDemoBasePage;

    @Test(dataProvider = "getServiceIterator")
    public void surchargeSpendFirstLevelModalTest(int serviceIndex){
        boolean notDuplicate;
        boolean sorted;
        int headerColumnNum;
        ArrayList<Float> values;
        newDemoQALoginPage = new NewDemoQALoginPage();
        newDemoLandingPage = new NewDemoLandingPage();
        invoiceReviewPage = new InvoiceReviewPage();
        surchargeSpendModalFirstLevel = new SurchargeSpendModalFirstLevel();
        baseModal = new BaseModal();

        newDemoQALoginPage.launchUrl(this.url);
        newDemoQALoginPage.setEmailAddressNewDemo(this.email);
        newDemoQALoginPage.setPassword(this.password);
        newDemoQALoginPage.signInClick();
        newDemoLandingPage.clickOnInvoiceReviewTile();
        invoiceReviewPage.clickSurchargeSpendCard();
        //TC-1
        notDuplicate = surchargeSpendModalFirstLevel.surchargeTableDataValidator();
        Assert.assertTrue(notDuplicate);
        //TC-2
        By carrierServiceDropdown = surchargeSpendModalFirstLevel.getCarrierServiceDropdown();
        By carrierServiceDropdownElements = surchargeSpendModalFirstLevel.getCarrierServiceDropdownElements();
        surchargeSpendModalFirstLevel.anyDropdownIterator(carrierServiceDropdown, carrierServiceDropdownElements,serviceIndex);
        headerColumnNum = baseModal.headerClick("Count");
        values = baseModal.columnData(headerColumnNum);
        sorted = baseModal.sortingValidation(values);
        Assert.assertTrue(sorted);
    }
    @Test
    public void surchargeSpendSecondLevelModalValidation(){
        int headerColumnNum;
        ArrayList<Float> values;
        boolean isDisplayed;
        boolean sorted;
        newDemoQALoginPage = new NewDemoQALoginPage();
        newDemoLandingPage = new NewDemoLandingPage();
        invoiceReviewPage = new InvoiceReviewPage();
        surchargeSpendModalFirstLevel = new SurchargeSpendModalFirstLevel();
        surchargeSpendModalSecondLevel = new SurchargeSpendModalSecondLevel();
        baseModal = new BaseModal();

        newDemoQALoginPage.launchUrl(this.url);
        newDemoQALoginPage.setEmailAddressNewDemo(this.email);
        newDemoQALoginPage.setPassword(this.password);
        newDemoQALoginPage.signInClick();
        newDemoLandingPage.clickOnInvoiceReviewTile();
        invoiceReviewPage.clickSurchargeSpendCard();
        surchargeSpendModalFirstLevel.anySurchargeTypeClick("FUEL SURCHARGE");
        //TC-1
        headerColumnNum = surchargeSpendModalSecondLevel.headerClick("Current Invoiced Amount");
        values = baseModal.columnData(headerColumnNum);
        //TC-2
        sorted =  baseModal.sortingValidation(values);
        Assert.assertTrue(sorted);
        //TC-3
        isDisplayed = baseModal.trackingNumberValidation();
        Assert.assertTrue(isDisplayed);
    }

    @Test
    public void surchargeSpendSecondLevelModalPaginationTest(){
        boolean isDisplayed, isCorrect;
        int pageNo;
        newDemoQALoginPage = new NewDemoQALoginPage();
        newDemoLandingPage = new NewDemoLandingPage();
        invoiceReviewPage = new InvoiceReviewPage();
        surchargeSpendModalFirstLevel = new SurchargeSpendModalFirstLevel();
        surchargeSpendModalSecondLevel = new SurchargeSpendModalSecondLevel();
        baseModal = new BaseModal();

        newDemoQALoginPage.launchUrl(this.url);
        newDemoQALoginPage.setEmailAddressNewDemo(this.email);
        newDemoQALoginPage.setPassword(this.password);
        newDemoQALoginPage.signInClick();
        newDemoLandingPage.clickOnInvoiceReviewTile();
        invoiceReviewPage.clickSurchargeSpendCard();
        surchargeSpendModalFirstLevel.anySurchargeTypeClick("FUEL SURCHARGE");
        //TC-1
        pageNo=surchargeSpendModalSecondLevel.paginationClick(2);
        isCorrect= surchargeSpendModalSecondLevel.pageSerialNoValidator(pageNo);
        Assert.assertTrue(isCorrect);
        //TC-2
        isDisplayed = baseModal.testDownloadButtonFunctionality2();
        Assert.assertTrue(isDisplayed);
    }
    @Test
    public void surchargeSpendSecondLevelModalShowEntriesTest(){
        int entries;
        boolean validate;
        newDemoQALoginPage = new NewDemoQALoginPage();
        newDemoLandingPage = new NewDemoLandingPage();
        invoiceReviewPage = new InvoiceReviewPage();
        surchargeSpendModalFirstLevel = new SurchargeSpendModalFirstLevel();
        surchargeSpendModalSecondLevel = new SurchargeSpendModalSecondLevel();
        baseModal = new BaseModal();
        newDemoBasePage = new NewDemoBasePage();

        newDemoQALoginPage.launchUrl(this.url);
        newDemoQALoginPage.setEmailAddressNewDemo(this.email);
        newDemoQALoginPage.setPassword(this.password);
        newDemoQALoginPage.signInClick();
        newDemoLandingPage.clickOnInvoiceReviewTile();
        invoiceReviewPage.clickSurchargeSpendCard();
        surchargeSpendModalFirstLevel.anySurchargeTypeClick("FUEL SURCHARGE");
        //TC-1
        entries = newDemoBasePage.anyDropdownIterator(surchargeSpendModalSecondLevel.getShowEntriesDropdown(),
                surchargeSpendModalSecondLevel.getShowEntriesDropdownElements());
        validate = surchargeSpendModalSecondLevel.showEntriesSerialNoValidator(entries);
        Assert.assertTrue(validate);
    }

    @Test
    public void surchargeTrendReportBtnModalTest(){
        newDemoQALoginPage = new NewDemoQALoginPage();
        newDemoLandingPage = new NewDemoLandingPage();
        invoiceReviewPage = new InvoiceReviewPage();
        surchargeSpendModalFirstLevel = new SurchargeSpendModalFirstLevel();
        surchargeSpendModalSecondLevel = new SurchargeSpendModalSecondLevel();
        surchargeSpendTrendModal = new SurchargeSpendTrendModal();
        baseModal = new BaseModal();
        newDemoBasePage = new NewDemoBasePage();

        newDemoQALoginPage.launchUrl(this.url);
        newDemoQALoginPage.setEmailAddressNewDemo(this.email);
        newDemoQALoginPage.setPassword(this.password);
        newDemoQALoginPage.signInClick();
        newDemoLandingPage.clickOnInvoiceReviewTile();
        invoiceReviewPage.clickSurchargeSpendCard();
        surchargeSpendModalFirstLevel.trendReportClick();
        //dropdown - 1
        surchargeSpendTrendModal.selectTimePeriodDropdownClick();
        By selectTimePeriodDropdown =  surchargeSpendTrendModal.getSelectTimePeriodDropdown();
        By allDropdownValues =  surchargeSpendTrendModal.getAllDropdownValues();
        surchargeSpendModalSecondLevel.anyDropdownIterator(selectTimePeriodDropdown,allDropdownValues,5);
        //dropdown - 2
        surchargeSpendTrendModal.surchargeTypeDropdownClick();
        By surchargeTypeDropdown =  surchargeSpendTrendModal.getSurchargeTypeDropdown();
        allDropdownValues =  surchargeSpendTrendModal.getAllDropdownValues();
        surchargeSpendModalSecondLevel.anyDropdownIterator(surchargeTypeDropdown,allDropdownValues,5);
        //dropdown - 3
        surchargeSpendTrendModal.sortBySpendOrVolumeDropdownClick();
        By sortBySpendOrVolumeDropdown = surchargeSpendTrendModal.getSortBySpendOrVolumeDropdown();
        allDropdownValues =  surchargeSpendTrendModal.getAllDropdownValues();
        surchargeSpendModalSecondLevel.anyDropdownIterator(sortBySpendOrVolumeDropdown,allDropdownValues,1);
    }

    @Test
    public void surchargeSpendTrendDownloadFunctionalityTest(){
        boolean isDisplayed;
        newDemoQALoginPage = new NewDemoQALoginPage();
        newDemoLandingPage = new NewDemoLandingPage();
        invoiceReviewPage = new InvoiceReviewPage();
        surchargeSpendModalFirstLevel = new SurchargeSpendModalFirstLevel();
        surchargeSpendModalSecondLevel = new SurchargeSpendModalSecondLevel();
        surchargeSpendTrendModal = new SurchargeSpendTrendModal();
        baseModal = new BaseModal();
        newDemoBasePage = new NewDemoBasePage();

        newDemoQALoginPage.launchUrl(this.url);
        newDemoQALoginPage.setEmailAddressNewDemo(this.email);
        newDemoQALoginPage.setPassword(this.password);
        newDemoQALoginPage.signInClick();
        newDemoLandingPage.clickOnInvoiceReviewTile();
        invoiceReviewPage.clickSurchargeSpendCard();
        surchargeSpendModalFirstLevel.trendReportClick();
        //TC-1
        isDisplayed = surchargeSpendTrendModal.testDownloadButtonFunctionality2();
        Assert.assertTrue(isDisplayed);
    }

    @Test
    public void surchargeTrendTableAndTimePeriodDropdownTest(){
        List<String> dropdownValues;
        List<String> tableValues;
        newDemoQALoginPage = new NewDemoQALoginPage();
        newDemoLandingPage = new NewDemoLandingPage();
        invoiceReviewPage = new InvoiceReviewPage();
        surchargeSpendModalFirstLevel = new SurchargeSpendModalFirstLevel();
        surchargeSpendModalSecondLevel = new SurchargeSpendModalSecondLevel();
        surchargeSpendTrendModal = new SurchargeSpendTrendModal();
        baseModal = new BaseModal();
        newDemoBasePage = new NewDemoBasePage();

        newDemoQALoginPage.launchUrl(this.url);
        newDemoQALoginPage.setEmailAddressNewDemo(this.email);
        newDemoQALoginPage.setPassword(this.password);
        newDemoQALoginPage.signInClick();
        newDemoLandingPage.clickOnInvoiceReviewTile();
        invoiceReviewPage.clickSurchargeSpendCard();
        surchargeSpendModalFirstLevel.trendReportClick();
        //dropdown - 1
        By selectTimePeriodDropdown =  surchargeSpendTrendModal.getSelectTimePeriodDropdown();
        By allDropdownValues =  surchargeSpendTrendModal.getAllDropdownValues();
        dropdownValues = surchargeSpendTrendModal.anyCheckboxDropdownRandomValues(selectTimePeriodDropdown,allDropdownValues);
        surchargeSpendTrendModal.refreshBtnClick();
        tableValues = surchargeSpendTrendModal.tableHeaderColumnsValidator();
        Assert.assertEquals(dropdownValues,tableValues);
    }

    @Test
    public void surchargeTrendTableAndSurchargeTypeDropdownTest(){
        List<String> dropdownValues;
        List<WebElement> elements;
        boolean result;
        int headerColumn;
        newDemoQALoginPage = new NewDemoQALoginPage();
        newDemoLandingPage = new NewDemoLandingPage();
        invoiceReviewPage = new InvoiceReviewPage();
        surchargeSpendModalFirstLevel = new SurchargeSpendModalFirstLevel();
        surchargeSpendModalSecondLevel = new SurchargeSpendModalSecondLevel();
        surchargeSpendTrendModal = new SurchargeSpendTrendModal();
        baseModal = new BaseModal();
        newDemoBasePage = new NewDemoBasePage();

        newDemoQALoginPage.launchUrl(this.url);
        newDemoQALoginPage.setEmailAddressNewDemo(this.email);
        newDemoQALoginPage.setPassword(this.password);
        newDemoQALoginPage.signInClick();
        newDemoLandingPage.clickOnInvoiceReviewTile();
        invoiceReviewPage.clickSurchargeSpendCard();
        surchargeSpendModalFirstLevel.trendReportClick();
        //dropdown - 1
        By surchargeTypeDropdown =  surchargeSpendTrendModal.getSurchargeTypeDropdown();
        By allDropdownValues =  surchargeSpendTrendModal.getAllDropdownValues();
        dropdownValues = surchargeSpendTrendModal.anyCheckboxDropdownRandomValues(surchargeTypeDropdown,allDropdownValues);
        surchargeSpendTrendModal.refreshBtnClick();
        headerColumn = surchargeSpendTrendModal.headerClick("Topic");
        elements = surchargeSpendTrendModal.columnDataWebElements(headerColumn);
        result = surchargeSpendTrendModal.dropdownAndColumnDataValidation(dropdownValues,elements,true);
        Assert.assertTrue(result);
    }

    @Test
    public void surchargeDetailBtnModalTableTest() {
        boolean sorted;
        boolean serialNos;
        int headerColumnNum, pageNo;
        ArrayList<Float> values;
        newDemoQALoginPage = new NewDemoQALoginPage();
        newDemoLandingPage = new NewDemoLandingPage();
        invoiceReviewPage = new InvoiceReviewPage();
        surchargeSpendModalFirstLevel = new SurchargeSpendModalFirstLevel();
        surchargeSpendModalSecondLevel = new SurchargeSpendModalSecondLevel();
        surchargeSpendDetailsModal = new SurchargeSpendDetailsModal();
        baseModal = new BaseModal();
        newDemoBasePage = new NewDemoBasePage();

        newDemoQALoginPage.launchUrl(this.url);
        newDemoQALoginPage.setEmailAddressNewDemo(this.email);
        newDemoQALoginPage.setPassword(this.password);
        newDemoQALoginPage.signInClick();
        newDemoLandingPage.clickOnInvoiceReviewTile();
        invoiceReviewPage.clickSurchargeSpendCard();
        surchargeSpendModalFirstLevel.surchargeDetailClick();
        //TC-1
        headerColumnNum = surchargeSpendDetailsModal.headerClick("count");
        values = surchargeSpendDetailsModal.columnData(headerColumnNum);
        //TC-2
        sorted =  baseModal.sortingValidation(values);
        Assert.assertTrue(sorted);
        //TC-3
        pageNo = baseModal.paginationClick(2);
        serialNos = surchargeSpendDetailsModal.pageSerialNoValidator(pageNo);
        Assert.assertTrue(serialNos);
        //TC-4
        surchargeSpendModalSecondLevel.anyDropdownIterator(surchargeSpendDetailsModal.getChooseServiceDropdown()
                , surchargeSpendDetailsModal.getChooseServiceDropdownElements());
    }
    @Test
    public void surchargeDetailBtnModalPaginationTest() {
        boolean sorted;
        boolean serialNos;
        int headerColumnNum, pageNo;
        ArrayList<Float> values;
        newDemoQALoginPage = new NewDemoQALoginPage();
        newDemoLandingPage = new NewDemoLandingPage();
        invoiceReviewPage = new InvoiceReviewPage();
        surchargeSpendModalFirstLevel = new SurchargeSpendModalFirstLevel();
        surchargeSpendModalSecondLevel = new SurchargeSpendModalSecondLevel();
        surchargeSpendDetailsModal = new SurchargeSpendDetailsModal();
        baseModal = new BaseModal();
        newDemoBasePage = new NewDemoBasePage();

        newDemoQALoginPage.launchUrl(this.url);
        newDemoQALoginPage.setEmailAddressNewDemo(this.email);
        newDemoQALoginPage.setPassword(this.password);
        newDemoQALoginPage.signInClick();
        newDemoLandingPage.clickOnInvoiceReviewTile();
        invoiceReviewPage.clickSurchargeSpendCard();
        surchargeSpendModalFirstLevel.surchargeDetailClick();
        //TC-1
        pageNo = baseModal.paginationClick(2);
        serialNos = surchargeSpendDetailsModal.pageSerialNoValidator(pageNo);
        Assert.assertTrue(serialNos);
        //TC-4
        surchargeSpendModalSecondLevel.anyDropdownIterator(surchargeSpendDetailsModal.getChooseServiceDropdown()
                , surchargeSpendDetailsModal.getChooseServiceDropdownElements());
    }

    @Test
    public void invoiceReviewSurchargeDetailSecondLevelModalTableTest() {
        boolean sorted;
        int headerColumnNum;
        List<Float> values;
        List<WebElement> linkValues;
        newDemoQALoginPage = new NewDemoQALoginPage();
        newDemoLandingPage = new NewDemoLandingPage();
        invoiceReviewPage = new InvoiceReviewPage();
        surchargeSpendModalFirstLevel = new SurchargeSpendModalFirstLevel();
        surchargeSpendModalSecondLevel = new SurchargeSpendModalSecondLevel();
        surchargeSpendDetailsModal = new SurchargeSpendDetailsModal();
        surchargeSpendDetailsModalSecondLevel = new SurchargeSpendDetailsModalSecondLevel();
        baseModal = new BaseModal();
        newDemoBasePage = new NewDemoBasePage();

        newDemoQALoginPage.launchUrl(this.url);
        newDemoQALoginPage.setEmailAddressNewDemo(this.email);
        newDemoQALoginPage.setPassword(this.password);
        newDemoQALoginPage.signInClick();
        newDemoLandingPage.clickOnInvoiceReviewTile();
        invoiceReviewPage.clickSurchargeSpendCard();
        surchargeSpendModalFirstLevel.surchargeDetailClick();
        //TC-1
        headerColumnNum = surchargeSpendDetailsModal.headerClick("Surcharge");
        linkValues = surchargeSpendDetailsModal.columnDataWebElements(headerColumnNum);
        surchargeSpendDetailsModal.anyColumnValueClick(linkValues);
        //TC-2
        surchargeSpendDetailsModalSecondLevel.headerClick("Current Invoiced Amount");
        values = surchargeSpendDetailsModalSecondLevel.columnData(headerColumnNum);
        //TC-3
//        sorted =  baseModal.sortingValidation(values);
//        Assert.assertTrue(sorted);
    }

    @Test
    public void invoiceReviewSurchargeDetailSecondLevelModalTrackingNosTest() {
        boolean sorted;
        int headerColumnNum;
        List<Float> values;
        List<WebElement> linkValues;
        newDemoQALoginPage = new NewDemoQALoginPage();
        newDemoLandingPage = new NewDemoLandingPage();
        invoiceReviewPage = new InvoiceReviewPage();
        surchargeSpendModalFirstLevel = new SurchargeSpendModalFirstLevel();
        surchargeSpendModalSecondLevel = new SurchargeSpendModalSecondLevel();
        surchargeSpendDetailsModal = new SurchargeSpendDetailsModal();
        surchargeSpendDetailsModalSecondLevel = new SurchargeSpendDetailsModalSecondLevel();
        baseModal = new BaseModal();
        newDemoBasePage = new NewDemoBasePage();

        newDemoQALoginPage.launchUrl(this.url);
        newDemoQALoginPage.setEmailAddressNewDemo(this.email);
        newDemoQALoginPage.setPassword(this.password);
        newDemoQALoginPage.signInClick();
        newDemoLandingPage.clickOnInvoiceReviewTile();
        invoiceReviewPage.clickSurchargeSpendCard();
        surchargeSpendModalFirstLevel.surchargeDetailClick();
        //TC-1
        headerColumnNum = surchargeSpendDetailsModal.headerClick("Surcharge");
        linkValues = surchargeSpendDetailsModal.columnDataWebElements(headerColumnNum);
        surchargeSpendDetailsModal.anyColumnValueClick(linkValues);
        //TC-2
        headerColumnNum = surchargeSpendDetailsModalSecondLevel.headerClick("Tracking Number");
        linkValues = surchargeSpendDetailsModalSecondLevel.columnDataWebElements(headerColumnNum);
        surchargeSpendDetailsModalSecondLevel.anyColumnValueClick(linkValues);
//        surchargeSavingsSurchargeDetailsModal.trackingNumberValidation();
    }
    @Test(dataProvider = "getServiceIterator")
    public void carrierServiceDropdownIterator(int serviceIndex){
        newDemoQALoginPage = new NewDemoQALoginPage();
        newDemoLandingPage = new NewDemoLandingPage();
        surchargeSpendModalFirstLevel = new SurchargeSpendModalFirstLevel();
        invoiceReviewPage = new InvoiceReviewPage();
        baseModal = new BaseModal();

        newDemoQALoginPage.launchUrl(this.url);
        newDemoQALoginPage.setEmailAddressNewDemo(this.email);
        newDemoQALoginPage.setPassword(this.password);
        newDemoQALoginPage.signInClick();
        newDemoLandingPage.clickOnInvoiceReviewTile();
        invoiceReviewPage.clickSurchargeSpendCard();
        By carrierServiceDropdown = surchargeSpendModalFirstLevel.getCarrierServiceDropdown();
        By carrierServiceDropdownElements = surchargeSpendModalFirstLevel.getCarrierServiceDropdownElements();
        surchargeSpendModalFirstLevel.anyDropdownIterator(carrierServiceDropdown, carrierServiceDropdownElements,serviceIndex);
    }

    @DataProvider
    public Object[] getServiceIterator(){
        return new Object[] {2};
    }

}
