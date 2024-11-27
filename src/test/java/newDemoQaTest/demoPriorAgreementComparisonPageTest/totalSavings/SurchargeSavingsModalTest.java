package newDemoQaTest.demoPriorAgreementComparisonPageTest.totalSavings;

import newDemoQaPages.BaseModal;
import newDemoQaPages.NewDemoLandingPage;
import newDemoQaPages.demoPriorAgreementComparisonPage.*;
import newDemoQaPages.demoPriorAgreementComparisonPage.totalSavings.*;
import newDemoQaTest.NewDemoBaseTest;
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

    @Test(dataProvider = "getServiceIterator")
    public void surchargeFirstLevelModalValidation(int serviceIndex) {
        boolean notDuplicate;
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
        notDuplicate = surchargeSavingsModalFirstLevel.surchargeTableDataValidator();
        Assert.assertTrue(notDuplicate);
        //TC-2
        By carrierServiceDropdown = surchargeSavingsModalFirstLevel.getCarrierServiceDropdown();
        By carrierServiceDropdownElements = surchargeSavingsModalFirstLevel.getCarrierServiceDropdownElements();
        surchargeSavingsModalFirstLevel.anyDropdownIterator(carrierServiceDropdown, carrierServiceDropdownElements,serviceIndex);
        headerColumnNum = baseModal.headerClick("Count");
        values = baseModal.columnData(headerColumnNum);
        sorted = baseModal.sortingValidation(values);
        Assert.assertTrue(sorted);
    }

    @Test
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
        Assert.assertTrue(sorted);
        //TC-3
        isDisplayed = baseModal.trackingNumberValidation();
        Assert.assertTrue(isDisplayed);
    }

    @Test
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
        Assert.assertTrue(sorted);
        //TC-2
        isDisplayed = surchargeSavingsModalSecondLevel.testDownloadButtonFunctionality();
        Assert.assertTrue(isDisplayed);
    }
    @Test
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

    @Test
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

    @Test
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

    @Test
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

    @Test
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
        //TC-2
        sorted =  baseModal.sortingValidation(values);
        Assert.assertTrue(sorted);
        //TC-3
        pageNo = baseModal.paginationClick(2);
        pageSerialNo = surchargeSavingsSurchargeDetailsModal.pageSerialNoValidator(pageNo);
        Assert.assertTrue(pageSerialNo);
        //TC-4
        surchargeSavingsModalSecondLevel.anyDropdownIterator(surchargeSavingsSurchargeDetailsModal.getChooseServiceDropdown()
                , surchargeSavingsSurchargeDetailsModal.getChooseServiceDropdownElements());
    }

    @Test
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
//        Assert.assertTrue(sorted);
    }

    @Test
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
    @Test(dataProvider = "getServiceIterator")
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

    @DataProvider
    public Object[] getServiceIterator(){
        return new Object[] {1,2};
    }

}
