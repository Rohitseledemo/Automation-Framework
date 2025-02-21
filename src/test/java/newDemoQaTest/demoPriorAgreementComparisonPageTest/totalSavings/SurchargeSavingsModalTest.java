package newDemoQaTest.demoPriorAgreementComparisonPageTest.totalSavings;

import newDemoQaPages.BaseModal;
import newDemoQaPages.NewDemoLandingPage;
import newDemoQaPages.demoPriorAgreementComparisonPage.*;
import newDemoQaPages.demoPriorAgreementComparisonPage.totalSavings.*;
import baseTest.NewDemoBaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.List;

public class SurchargeSavingsModalTest extends NewDemoBaseTest {
    PriorAgreementComparisonPage newDemoPriorAgreementComparison;
    NewDemoLandingPage newDemoLandingPage;
    SurchargeSavingsModalFirstLevel surchargeSavingsModalFirstLevel;
    SurchargeSavingsModalSecondLevel surchargeSavingsModalSecondLevel;
    SurchargeSavingsSurchargeDetailsModal surchargeSavingsSurchargeDetailsModal;
    SurchargeSavingsSurchargeTrendModal surchargeSavingsSurchargeTrendModal;
    SurchargeSavingsDetailsModalSecondLevel surchargeSavingsDetailsModalSecondLevel;
    BaseModal baseModal;

    @Test(testName = "SurSav 1LvlModal POSS Test")
    public void surchargeFirstLevelModalPOSSValidation() {
        boolean notDuplicate;
        newDemoLandingPage = new NewDemoLandingPage();
        newDemoPriorAgreementComparison = new PriorAgreementComparisonPage();
        surchargeSavingsModalFirstLevel = new SurchargeSavingsModalFirstLevel();
        baseModal = new BaseModal();

        newDemoQALoginPage.launchUrl(this.url);
        newDemoQALoginPage.setEmailAddressNewDemo(this.email);
        newDemoQALoginPage.setPassword(this.password);
        newDemoQALoginPage.signInClick();
        newDemoLandingPage.clickOnPriorAgreementComparisonTile();
        newDemoPriorAgreementComparison.surchargeSavingsClick();
        //TC-1
        notDuplicate = surchargeSavingsModalFirstLevel.surchargeTableDataValidator();
        softAssert.assertTrue(notDuplicate,"Duplicate Data Found in Surcharge First Level Modal");
        softAssert.assertAll();
    }

    @Test(testName = "SurSav 1LvlModal ServiceDropdown Test",dataProvider = "getServiceIterator")
    public void surchargeFirstLevelModalCarrierValidation(int serviceIndex) {
        boolean sorted;
        int headerColumnNum;
        ArrayList<Float> values;
        newDemoLandingPage = new NewDemoLandingPage();
        newDemoPriorAgreementComparison = new PriorAgreementComparisonPage();
        surchargeSavingsModalFirstLevel = new SurchargeSavingsModalFirstLevel();
        baseModal = new BaseModal();

        newDemoQALoginPage.launchUrl(this.url);
        newDemoQALoginPage.setEmailAddressNewDemo(this.email);
        newDemoQALoginPage.setPassword(this.password);
        newDemoQALoginPage.signInClick();
        newDemoLandingPage.clickOnPriorAgreementComparisonTile();
        newDemoPriorAgreementComparison.surchargeSavingsClick();
        //TC-1
        By carrierServiceDropdown = surchargeSavingsModalFirstLevel.getCarrierServiceDropdown();
        By carrierServiceDropdownElements = surchargeSavingsModalFirstLevel.getCarrierServiceDropdownElements();
        surchargeSavingsModalFirstLevel.anyDropdownIterator(carrierServiceDropdown, carrierServiceDropdownElements,serviceIndex);
        headerColumnNum = baseModal.headerClick("Count");
        values = baseModal.columnData(headerColumnNum);
        sorted = baseModal.sortingValidation(values);
        softAssert.assertTrue(sorted,"|Count| Column values not Sorted in Surcharge First Table");
        softAssert.assertAll();
    }

    @Test(testName = "SurSav 2LvlModal Table Test")
    public void surchargeSecondLevelModalValidation(){
        int headerColumnNum;
        ArrayList<Float> values;
        boolean isDisplayed;
        boolean sorted;
        newDemoLandingPage = new NewDemoLandingPage();
        newDemoPriorAgreementComparison = new PriorAgreementComparisonPage();
        surchargeSavingsModalFirstLevel = new SurchargeSavingsModalFirstLevel();
        surchargeSavingsModalSecondLevel = new SurchargeSavingsModalSecondLevel();
        baseModal = new BaseModal();

        newDemoQALoginPage.launchUrl(this.url);
        newDemoQALoginPage.setEmailAddressNewDemo(this.email);
        newDemoQALoginPage.setPassword(this.password);
        newDemoQALoginPage.signInClick();
        newDemoLandingPage.clickOnPriorAgreementComparisonTile();
        newDemoPriorAgreementComparison.surchargeSavingsClick();
        surchargeSavingsModalFirstLevel.anySurchargeTypeClick("FUEL SURCHARGE");
        //TC-1
        headerColumnNum = surchargeSavingsModalSecondLevel.headerClick("Prior Invoiced Amount");
        values = baseModal.columnData(headerColumnNum);
        //TC-2
        sorted =  baseModal.sortingValidation(values);
        softAssert.assertTrue(sorted,"|Prior Invoiced Amount| Column values not Sorted in Surcharge Second Table");
        //TC-3
        isDisplayed = surchargeSavingsModalSecondLevel.trackingNumberValidation();
        softAssert.assertTrue(isDisplayed,"Tracking Number Modal is not Displayed.");
        softAssert.assertAll();
    }

    @Test(testName = "SurSav 2LvlModal Pagination Test")
    public void surchargeSecondLevelModalPaginationTest(){
        boolean isDisplayed,sorted;
        int pageNo;
        newDemoLandingPage = new NewDemoLandingPage();
        newDemoPriorAgreementComparison = new PriorAgreementComparisonPage();
        surchargeSavingsModalFirstLevel = new SurchargeSavingsModalFirstLevel();
        surchargeSavingsModalSecondLevel = new SurchargeSavingsModalSecondLevel();
        baseModal = new BaseModal();

        newDemoQALoginPage.launchUrl(this.url);
        newDemoQALoginPage.setEmailAddressNewDemo(this.email);
        newDemoQALoginPage.setPassword(this.password);
        newDemoQALoginPage.signInClick();
        newDemoLandingPage.clickOnPriorAgreementComparisonTile();
        newDemoPriorAgreementComparison.surchargeSavingsClick();
        surchargeSavingsModalFirstLevel.anySurchargeTypeClick("FUEL SURCHARGE");
        //TC-1
        pageNo=surchargeSavingsModalSecondLevel.paginationClick(2);
        sorted = baseModal.pageSerialNoValidator(pageNo);
        softAssert.assertTrue(sorted,"Serial Number Not Correct According To Pagination.");
        //TC-2
        isDisplayed = surchargeSavingsModalSecondLevel.testDownloadButtonFunctionality();
        softAssert.assertTrue(isDisplayed,"Download Confirmation Toast Not Displayed.");
        softAssert.assertAll();
    }
    @Test(testName = "SurSav SurTrendModal Test")
    public void surchargeTrendReportBtnModalTest() {
        newDemoLandingPage = new NewDemoLandingPage();
        newDemoPriorAgreementComparison = new PriorAgreementComparisonPage();
        surchargeSavingsModalFirstLevel = new SurchargeSavingsModalFirstLevel();
        surchargeSavingsModalSecondLevel = new SurchargeSavingsModalSecondLevel();
        surchargeSavingsSurchargeTrendModal = new SurchargeSavingsSurchargeTrendModal();
        baseModal = new BaseModal();

        newDemoQALoginPage.launchUrl(this.url);
        newDemoQALoginPage.setEmailAddressNewDemo(this.email);
        newDemoQALoginPage.setPassword(this.password);
        newDemoQALoginPage.signInClick();
        newDemoLandingPage.clickOnPriorAgreementComparisonTile();
        newDemoPriorAgreementComparison.surchargeSavingsClick();
        surchargeSavingsModalFirstLevel.trendReportClick();
        //dropdown - 1
        surchargeSavingsSurchargeTrendModal.selectTimePeriodDropdownClick();
        By selectTimePeriodDropdown =  surchargeSavingsSurchargeTrendModal.getSelectTimePeriodDropdown();
        By allDropdownValues =  surchargeSavingsSurchargeTrendModal.getAllDropdownValues();
        surchargeSavingsModalSecondLevel.anyDropdownIterator(selectTimePeriodDropdown,allDropdownValues,5);
        //dropdown - 2
        surchargeSavingsSurchargeTrendModal.surchargeTypeDropdownClick();
        By surchargeTypeDropdown =  surchargeSavingsSurchargeTrendModal.getSurchargeTypeDropdown();
        allDropdownValues =  surchargeSavingsSurchargeTrendModal.getAllDropdownValues();
        surchargeSavingsModalSecondLevel.anyDropdownIterator(surchargeTypeDropdown,allDropdownValues,5);
        //dropdown - 3
        surchargeSavingsSurchargeTrendModal.sortBySpendOrVolumeDropdownClick();
        By sortBySpendOrVolumeDropdown = surchargeSavingsSurchargeTrendModal.getSortBySpendOrVolumeDropdown();
        allDropdownValues =  surchargeSavingsSurchargeTrendModal.getAllDropdownValues();
        surchargeSavingsModalSecondLevel.anyDropdownIterator(sortBySpendOrVolumeDropdown,allDropdownValues,1);
    }

    @Test(testName = "Surcharge Savings TrendModal DownloadFunctionality Test")
    public void surchargeTrendDownloadFunctionalityTest(){
        boolean isDisplayed;
        newDemoLandingPage = new NewDemoLandingPage();
        newDemoPriorAgreementComparison = new PriorAgreementComparisonPage();
        surchargeSavingsModalFirstLevel = new SurchargeSavingsModalFirstLevel();
        surchargeSavingsModalSecondLevel = new SurchargeSavingsModalSecondLevel();
        surchargeSavingsSurchargeTrendModal = new SurchargeSavingsSurchargeTrendModal();
        baseModal = new BaseModal();

        newDemoQALoginPage.launchUrl(this.url);
        newDemoQALoginPage.setEmailAddressNewDemo(this.email);
        newDemoQALoginPage.setPassword(this.password);
        newDemoQALoginPage.signInClick();
        newDemoLandingPage.clickOnPriorAgreementComparisonTile();
        newDemoPriorAgreementComparison.surchargeSavingsClick();
        surchargeSavingsModalFirstLevel.trendReportClick();
        //TC-1
        isDisplayed = surchargeSavingsSurchargeTrendModal.testDownloadButtonFunctionality2();
        Assert.assertTrue(isDisplayed);
    }

    @Test(testName = "Surcharge Savings TrendModal TimePeriodDropdown Test")
    public void surchargeTrendTableAndTimePeriodDropdownTest(){
        List<String> dropdownValues;
        List<String> tableValues;
        newDemoLandingPage = new NewDemoLandingPage();
        newDemoPriorAgreementComparison = new PriorAgreementComparisonPage();
        surchargeSavingsModalFirstLevel = new SurchargeSavingsModalFirstLevel();
        surchargeSavingsModalSecondLevel = new SurchargeSavingsModalSecondLevel();
        surchargeSavingsSurchargeTrendModal = new SurchargeSavingsSurchargeTrendModal();
        baseModal = new BaseModal();

        newDemoQALoginPage.launchUrl(this.url);
        newDemoQALoginPage.setEmailAddressNewDemo(this.email);
        newDemoQALoginPage.setPassword(this.password);
        newDemoQALoginPage.signInClick();
        newDemoLandingPage.clickOnPriorAgreementComparisonTile();
        newDemoPriorAgreementComparison.surchargeSavingsClick();
        surchargeSavingsModalFirstLevel.trendReportClick();
        //dropdown - 1
        By selectTimePeriodDropdown =  surchargeSavingsSurchargeTrendModal.getSelectTimePeriodDropdown();
        By allDropdownValues =  surchargeSavingsSurchargeTrendModal.getAllDropdownValues();
        dropdownValues = surchargeSavingsSurchargeTrendModal.anyCheckboxDropdownRandomValues(selectTimePeriodDropdown,allDropdownValues);
        surchargeSavingsSurchargeTrendModal.refreshBtnClick();
        tableValues = surchargeSavingsSurchargeTrendModal.tableHeaderColumnsValidator();
        Assert.assertEquals(dropdownValues,tableValues);
    }

    @Test(testName = "Surcharge Savings TrendModal SurchargeTypeDropdown Test")
    public void surchargeTrendTableAndSurchargeTypeDropdownTest(){
        List<String> dropdownValues;
        List<WebElement> elements;
        boolean result;
        int headerColumn;
        newDemoLandingPage = new NewDemoLandingPage();
        newDemoPriorAgreementComparison = new PriorAgreementComparisonPage();
        surchargeSavingsModalFirstLevel = new SurchargeSavingsModalFirstLevel();
        surchargeSavingsModalSecondLevel = new SurchargeSavingsModalSecondLevel();
        surchargeSavingsSurchargeTrendModal = new SurchargeSavingsSurchargeTrendModal();
        baseModal = new BaseModal();

        newDemoQALoginPage.launchUrl(this.url);
        newDemoQALoginPage.setEmailAddressNewDemo(this.email);
        newDemoQALoginPage.setPassword(this.password);
        newDemoQALoginPage.signInClick();
        newDemoLandingPage.clickOnPriorAgreementComparisonTile();
        newDemoPriorAgreementComparison.surchargeSavingsClick();
        surchargeSavingsModalFirstLevel.trendReportClick();
        //dropdown - 1
        By surchargeTypeDropdown =  surchargeSavingsSurchargeTrendModal.getSurchargeTypeDropdown();
        By allDropdownValues =  surchargeSavingsSurchargeTrendModal.getAllDropdownValues();
        dropdownValues = surchargeSavingsSurchargeTrendModal.anyCheckboxDropdownRandomValues(surchargeTypeDropdown,allDropdownValues);
        surchargeSavingsSurchargeTrendModal.refreshBtnClick();
        headerColumn = surchargeSavingsSurchargeTrendModal.headerClick("Topic");
        elements = surchargeSavingsSurchargeTrendModal.columnDataWebElements(headerColumn);
        System.out.println("size -"+elements.size());
        result = surchargeSavingsSurchargeTrendModal.dropdownAndColumnDataValidation(dropdownValues,elements,true);
        Assert.assertTrue(result);
    }

    @Test(testName = "Surcharge Savings Detail 1LvlModal Table Test")
    public void surchargeDetailBtnModalTest() {
        boolean sorted, pageSerialNo;
        int headerColumnNum,pageNo;
        ArrayList<Float> values;
        newDemoLandingPage = new NewDemoLandingPage();
        newDemoPriorAgreementComparison = new PriorAgreementComparisonPage();
        surchargeSavingsModalFirstLevel = new SurchargeSavingsModalFirstLevel();
        surchargeSavingsModalSecondLevel = new SurchargeSavingsModalSecondLevel();
        surchargeSavingsSurchargeDetailsModal = new SurchargeSavingsSurchargeDetailsModal();
        baseModal = new BaseModal();

        newDemoQALoginPage.launchUrl(this.url);
        newDemoQALoginPage.setEmailAddressNewDemo(this.email);
        newDemoQALoginPage.setPassword(this.password);
        newDemoQALoginPage.signInClick();
        newDemoLandingPage.clickOnPriorAgreementComparisonTile();
        newDemoPriorAgreementComparison.surchargeSavingsClick();
        surchargeSavingsModalFirstLevel.surchargeDetailClick();
        //TC-1
        headerColumnNum = surchargeSavingsSurchargeDetailsModal.headerClick("count");
        values = surchargeSavingsSurchargeDetailsModal.columnData(headerColumnNum);
        sorted =  baseModal.sortingValidation(values);
        softAssert.assertTrue(sorted,"|Count| column values Not Sorted.");
        //TC-3
        pageNo = surchargeSavingsSurchargeDetailsModal.paginationClick(2);
        pageSerialNo = surchargeSavingsSurchargeDetailsModal.pageSerialNoValidator(pageNo);
        softAssert.assertTrue(pageSerialNo,"Serial Number Not Correct According To Pagination.");
        //TC-4
        By chooseServiceDropdown= surchargeSavingsSurchargeDetailsModal.getChooseServiceDropdown();
        By chooseServiceDropdownElements= surchargeSavingsSurchargeDetailsModal.getChooseServiceDropdownElements();
        surchargeSavingsSurchargeDetailsModal.anyDropdownIterator(chooseServiceDropdown,chooseServiceDropdownElements);
        softAssert.assertAll();
    }

    @Test(testName = "Surcharge Savings Detail 2LvlModal Table Test")
    public void surchargeDetailSecondLevelModalTableTest() {
        boolean sorted;
        int headerColumnNum;
        List<Float> values;
        List<WebElement> linkValues;
        newDemoLandingPage = new NewDemoLandingPage();
        newDemoPriorAgreementComparison = new PriorAgreementComparisonPage();
        surchargeSavingsModalFirstLevel = new SurchargeSavingsModalFirstLevel();
        surchargeSavingsSurchargeDetailsModal = new SurchargeSavingsSurchargeDetailsModal();
        surchargeSavingsDetailsModalSecondLevel = new SurchargeSavingsDetailsModalSecondLevel();
        baseModal = new BaseModal();

        newDemoQALoginPage.launchUrl(this.url);
        newDemoQALoginPage.setEmailAddressNewDemo(this.email);
        newDemoQALoginPage.setPassword(this.password);
        newDemoQALoginPage.signInClick();
        newDemoLandingPage.clickOnPriorAgreementComparisonTile();
        newDemoPriorAgreementComparison.surchargeSavingsClick();
        surchargeSavingsModalFirstLevel.surchargeDetailClick();
        //TC-1
        headerColumnNum = surchargeSavingsSurchargeDetailsModal.headerClick("Surcharge");
        linkValues = surchargeSavingsSurchargeDetailsModal.columnDataWebElements(headerColumnNum);
        surchargeSavingsSurchargeDetailsModal.anyColumnValueClick(linkValues);
        //TC-2
        headerColumnNum = surchargeSavingsDetailsModalSecondLevel.headerClick("Savings");
        values = surchargeSavingsDetailsModalSecondLevel.columnData(headerColumnNum);
        //TC-3
        sorted =  baseModal.sortingValidation(values);
        Assert.assertTrue(sorted,"|Savings| column values are not sorted.");
    }

    @Test(testName = "Surcharge Savings Detail 2LvlModal TrackingNos Test")
    public void surchargeDetailSecondLevelModalTrackingNosTest() {
        boolean sorted;
        int headerColumnNum;
        List<Float> values;
        List<WebElement> linkValues;
        newDemoLandingPage = new NewDemoLandingPage();
        newDemoPriorAgreementComparison = new PriorAgreementComparisonPage();
        surchargeSavingsModalFirstLevel = new SurchargeSavingsModalFirstLevel();
        surchargeSavingsSurchargeDetailsModal = new SurchargeSavingsSurchargeDetailsModal();
        surchargeSavingsDetailsModalSecondLevel = new SurchargeSavingsDetailsModalSecondLevel();
        baseModal = new BaseModal();

        newDemoQALoginPage.launchUrl(this.url);
        newDemoQALoginPage.setEmailAddressNewDemo(this.email);
        newDemoQALoginPage.setPassword(this.password);
        newDemoQALoginPage.signInClick();
        newDemoLandingPage.clickOnPriorAgreementComparisonTile();
        newDemoPriorAgreementComparison.surchargeSavingsClick();
        surchargeSavingsModalFirstLevel.surchargeDetailClick();
        //TC-1
        headerColumnNum = surchargeSavingsSurchargeDetailsModal.headerClick("Surcharge");
        linkValues = surchargeSavingsSurchargeDetailsModal.columnDataWebElements(headerColumnNum);
        surchargeSavingsSurchargeDetailsModal.anyColumnValueClick(linkValues);
        //TC-2
//        surchargeSavingsSurchargeDetailsModal.trackingNumberValidation();
    }
    @Test(testName = "Surcharge Savings ServiceDropdown Test",dataProvider = "getServiceIterator")
    public void carrierServiceDropdownIterator(int serviceIndex){
        newDemoLandingPage = new NewDemoLandingPage();
        newDemoPriorAgreementComparison = new PriorAgreementComparisonPage();
        surchargeSavingsModalFirstLevel = new SurchargeSavingsModalFirstLevel();
        baseModal = new BaseModal();

        newDemoQALoginPage.launchUrl(this.url);
        newDemoQALoginPage.setEmailAddressNewDemo(this.email);
        newDemoQALoginPage.setPassword(this.password);
        newDemoQALoginPage.signInClick();
        newDemoLandingPage.clickOnPriorAgreementComparisonTile();
        newDemoPriorAgreementComparison.surchargeSavingsClick();
        By carrierServiceDropdown = surchargeSavingsModalFirstLevel.getCarrierServiceDropdown();
        By carrierServiceDropdownElements = surchargeSavingsModalFirstLevel.getCarrierServiceDropdownElements();
        surchargeSavingsModalFirstLevel.anyDropdownIterator(carrierServiceDropdown, carrierServiceDropdownElements,serviceIndex);
    }

    @Test(testName = "Surcharge Savings TimePeriodDropdown Test",dataProvider = "getMonthIterator")
    public void timePeriodDropdownIteratorSurchargeSavings(int monthIndex) {
        boolean sorted;
        int headerColumnNum;
        ArrayList<Float> values;
        newDemoLandingPage = new NewDemoLandingPage();
        newDemoPriorAgreementComparison = new PriorAgreementComparisonPage();
        surchargeSavingsModalFirstLevel = new SurchargeSavingsModalFirstLevel();
        baseModal = new BaseModal();

        newDemoQALoginPage.launchUrl(this.url);
        newDemoQALoginPage.setEmailAddressNewDemo(this.email);
        newDemoQALoginPage.setPassword(this.password);
        newDemoQALoginPage.signInClick();
        newDemoLandingPage.clickOnPriorAgreementComparisonTile();
        newDemoPriorAgreementComparison.surchargeSavingsClick();
        By timePeriodDropdown = surchargeSavingsModalFirstLevel.getTimePeriodDropdown();
        By timePeriodDropdownElements = surchargeSavingsModalFirstLevel.getTimePeriodDropdownElements();
        surchargeSavingsModalFirstLevel.anyDropdownIterator(timePeriodDropdown, timePeriodDropdownElements,monthIndex);
        headerColumnNum = baseModal.headerClick("Count");
        values = baseModal.columnData(headerColumnNum);
        sorted = baseModal.sortingValidation(values);
        Assert.assertTrue(sorted);
    }

    @Test(testName = "Surcharge Savings 1Lvl DownloadFunctionality Test")
    public void surchargeFirstLevelDownloadFunctionalityTest(){
        boolean isDisplayed;
        newDemoLandingPage = new NewDemoLandingPage();
        newDemoPriorAgreementComparison = new PriorAgreementComparisonPage();
        surchargeSavingsModalFirstLevel = new SurchargeSavingsModalFirstLevel();
        baseModal = new BaseModal();

        newDemoQALoginPage.launchUrl(this.url);
        newDemoQALoginPage.setEmailAddressNewDemo(this.email);
        newDemoQALoginPage.setPassword(this.password);
        newDemoQALoginPage.signInClick();
        newDemoLandingPage.clickOnPriorAgreementComparisonTile();
        newDemoPriorAgreementComparison.surchargeSavingsClick();
        //TC-1
        isDisplayed = surchargeSavingsModalFirstLevel.testDownloadButtonFunctionality2();
        Assert.assertTrue(isDisplayed,"");
    }



    @DataProvider(name = "getServiceIterator", parallel = true)
    public Object[] getServiceIterator(){
        return new Object[] {1,2};
    }
    @DataProvider(name = "getMonthIterator", parallel = true)
    public Object[] getMonthIterator(){
        return new Object[] {1,2,3};
    }

}
