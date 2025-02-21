package newDemoQaTest.demoPriorAgreementComparisonPageTest;

import newDemoQaPages.*;
import newDemoQaPages.demoPriorAgreementComparisonPage.*;
import baseTest.NewDemoBaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;

public class PriorAgreementComparisonTest extends NewDemoBaseTest {

    PriorAgreementComparisonPage priorAgreementComparison;
    NewDemoLandingPage newDemoLandingPage;
    BaseModal baseModal;

    @Test(testName = "PAC CardsColourTest",dataProvider = "getMonthIterator")
    public void priorAgreementComparisonColourTest(int monthIndex) {
        newDemoLandingPage = new NewDemoLandingPage();
        priorAgreementComparison = new PriorAgreementComparisonPage();

        newDemoQALoginPage.launchUrl(this.url);
        newDemoQALoginPage.setEmailAddressNewDemo(this.email);
        newDemoQALoginPage.setPassword(this.password);
        newDemoQALoginPage.signInClick();
        newDemoLandingPage.clickOnPriorAgreementComparisonTile();
        priorAgreementComparison.monthsCheckboxDropdownIterator(priorAgreementComparison.getDateDropdown(),
                priorAgreementComparison.getDateDropdownElements(),monthIndex);
        boolean totalSavingsActual = priorAgreementComparison.totalSavingsColourVerify();
        softAssert.assertTrue(totalSavingsActual,"Total Savings Color not verified.");
        boolean transportationActual = priorAgreementComparison.transportationSavingsColorVerify();
        softAssert.assertTrue(transportationActual,"Transportation Savings Color not verified.");
        boolean surchargeActual = priorAgreementComparison.surchargeSavingsColorVerify();
        softAssert.assertTrue(surchargeActual,"Surcharge Savings Color not verified.");
        boolean dimensionalActual = priorAgreementComparison.dimensionalWeightImpactColorVerify();
        softAssert.assertTrue(dimensionalActual,"Dimensional Weight Impact Savings Color not verified.");
        boolean avgSavingsPkgActual = priorAgreementComparison.avgSavingsPerPkgBtnColorVerify();
        softAssert.assertTrue(avgSavingsPkgActual,"Avg Savings Per Pkg Savings Color not verified.");
        boolean actualSavingsActual = priorAgreementComparison.actualSavingsRefundsNameColorVerify();
        softAssert.assertTrue(actualSavingsActual,"Actual Savings Refunds Savings Color not verified.");
        softAssert.assertAll();
    }

    @Test(testName = "PAC TotalSavingsTest",dataProvider = "getMonthIterator")
    public void priorAgreementComparisonTotalSavingsTest(int dateIndex) {
        boolean result,click;
        newDemoLandingPage = new NewDemoLandingPage();
        priorAgreementComparison = new PriorAgreementComparisonPage();

        newDemoQALoginPage.launchUrl(this.url);
        newDemoQALoginPage.setEmailAddressNewDemo(this.email);
        newDemoQALoginPage.setPassword(this.password);
        newDemoQALoginPage.signInClick();
        newDemoLandingPage.clickOnPriorAgreementComparisonTile();
        priorAgreementComparison.monthsCheckboxDropdownIterator(priorAgreementComparison.getDateDropdown(),
                priorAgreementComparison.getDateDropdownElements(),dateIndex);
        result = priorAgreementComparison.calculateTotalSavings();
        softAssert.assertTrue(result,"Mismatched result.");
        click = priorAgreementComparison.totalSavingsClick();
        softAssert.assertTrue(click,"Total Savings not Clicked.");
        softAssert.assertAll();
    }

    @Test(testName = "PAC ViewDetailsBtnTest")
    public void priorAgreementComparisonViewDetailsTest() {
        int headerColumn, pageNo;
        List<Float> values;
        boolean validate, sorted;
        newDemoLandingPage = new NewDemoLandingPage();
        priorAgreementComparison = new PriorAgreementComparisonPage();
        baseModal = new BaseModal();

        newDemoQALoginPage.launchUrl(this.url);
        newDemoQALoginPage.setEmailAddressNewDemo(this.email);
        newDemoQALoginPage.setPassword(this.password);
        newDemoQALoginPage.signInClick();
        newDemoLandingPage.clickOnPriorAgreementComparisonTile();
        priorAgreementComparison.viewDetailsBtnClick();
        //TC-1
        pageNo=priorAgreementComparison.paginationClick(2);
        validate = priorAgreementComparison.pageSerialNoValidator(pageNo);
        softAssert.assertTrue(validate,"Serial Number Not Correct According To Pagination.");
        //TC-2
        headerColumn = priorAgreementComparison.headerClick("Actual Weight");
        values = priorAgreementComparison.columnData(headerColumn);
        sorted = priorAgreementComparison.sortingValidation(values);
        softAssert.assertTrue(sorted,"|Actual Weight| Column values not Sorted.");
        softAssert.assertAll();
    }

    @Test(testName = "PAC ViewDetailsShowEntriesTest")
    public void priorAgreementComparisonViewDetailsShowEntriesTest(){
        int serialNo;
        boolean correct, isDisplayed;
        newDemoLandingPage = new NewDemoLandingPage();
        priorAgreementComparison = new PriorAgreementComparisonPage();
        baseModal = new BaseModal();

        newDemoQALoginPage.launchUrl(this.url);
        newDemoQALoginPage.setEmailAddressNewDemo(this.email);
        newDemoQALoginPage.setPassword(this.password);
        newDemoQALoginPage.signInClick();
        newDemoLandingPage.clickOnPriorAgreementComparisonTile();
        isDisplayed=priorAgreementComparison.viewDetailsBtnClick();
        softAssert.assertTrue(isDisplayed,"View Details Button not clicked.");
        //TC-1 - show entries dropdown test
        serialNo= priorAgreementComparison.anyDropdownIterator(priorAgreementComparison.getShowEntriesDropdown()
                ,priorAgreementComparison.getShowEntriesDropdownElements());
        correct = priorAgreementComparison.showEntriesSerialNoValidator(serialNo);
        softAssert.assertTrue(correct,"Show Entries Serial No. not correct.");
        softAssert.assertAll();
    }

    @Test(testName = "PAC TrendReportBtnTest")
    public void priorAgreementTrendReportBtnTest(){
        newDemoLandingPage = new NewDemoLandingPage();
        priorAgreementComparison = new PriorAgreementComparisonPage();
        baseModal = new BaseModal();

        newDemoQALoginPage.launchUrl(this.url);
        newDemoQALoginPage.setEmailAddressNewDemo(this.email);
        newDemoQALoginPage.setPassword(this.password);
        newDemoQALoginPage.signInClick();
        newDemoLandingPage.clickOnPriorAgreementComparisonTile();
        priorAgreementComparison.trendReportClick();
    }

    @Test(testName = "PAC DownloadInvoiceFuncTest")
    public void downloadInvoiceFuncTest(){
        boolean isVisible;
        newDemoLandingPage = new NewDemoLandingPage();
        priorAgreementComparison = new PriorAgreementComparisonPage();
        baseModal = new BaseModal();

        newDemoQALoginPage.launchUrl(this.url);
        newDemoQALoginPage.setEmailAddressNewDemo(this.email);
        newDemoQALoginPage.setPassword(this.password);
        newDemoQALoginPage.signInClick();
        newDemoLandingPage.clickOnPriorAgreementComparisonTile();
        isVisible=priorAgreementComparison.multiDownloadButtonFuncTest("Download Invoice");
        Assert.assertTrue(isVisible,"Download Invoice Toast is not Displayed.");
    }
    @Test(testName = "PAC DownloadViewBtnTest")
    public void downloadViewBtnTest(){
        boolean isVisible,isViewVisible;
        newDemoLandingPage = new NewDemoLandingPage();
        priorAgreementComparison = new PriorAgreementComparisonPage();
        baseModal = new BaseModal();

        newDemoQALoginPage.launchUrl(this.url);
        newDemoQALoginPage.setEmailAddressNewDemo(this.email);
        newDemoQALoginPage.setPassword(this.password);
        newDemoQALoginPage.signInClick();
        newDemoLandingPage.clickOnPriorAgreementComparisonTile();
        priorAgreementComparison.viewDetailsBtnClick();
        isViewVisible=priorAgreementComparison.multiDownloadButtonFuncTest("Download View");
        softAssert.assertTrue(isViewVisible,"Download View Confirmation Toast Not Displayed.");
        isVisible=priorAgreementComparison.multiDownloadButtonFuncTest("Download All");
        softAssert.assertTrue(isVisible,"Download All Confirmation Toast Not Displayed.");
        softAssert.assertAll();
    }

    @Test(testName = "PAC ProfileBtnDropdownTest")
    public void profileBtnDropdownTest(){
        newDemoLandingPage = new NewDemoLandingPage();
        priorAgreementComparison = new PriorAgreementComparisonPage();
        baseModal = new BaseModal();

        newDemoQALoginPage.launchUrl(this.url);
        newDemoQALoginPage.setEmailAddressNewDemo(this.email);
        newDemoQALoginPage.setPassword(this.password);
        newDemoQALoginPage.signInClick();
        newDemoLandingPage.clickOnPriorAgreementComparisonTile();
        priorAgreementComparison.profileDropdownBtnClick();
        priorAgreementComparison.switchCompanyViewBtnClick();
    }

    //unit TC for account number dropdown
    @Test(testName = "PAC AccountDropdownTest",dataProvider = "accountIndexIterator")
    public void accountDropdownIteratorPriorAgreement(int[] accountIndex){
        boolean isTrue;
        newDemoLandingPage = new NewDemoLandingPage();
        priorAgreementComparison = new PriorAgreementComparisonPage();
        baseModal = new BaseModal();

        newDemoQALoginPage.launchUrl(this.url);
        newDemoQALoginPage.setEmailAddressNewDemo(this.email);
        newDemoQALoginPage.setPassword(this.password);
        newDemoQALoginPage.signInClick();
        newDemoLandingPage.clickOnPriorAgreementComparisonTile();
        By dropdown = priorAgreementComparison.getAccountDropdown();
        By dropdownElements = priorAgreementComparison.getAccountDropdownElements();
        isTrue = priorAgreementComparison.validateAllDropdownValues(dropdown,dropdownElements,accountIndex);
        Assert.assertTrue(isTrue);
    }

    @Test(testName = "PAC CarrierServiceDropdownTest",dataProvider = "getServiceIterator")
    public void carrierServiceDropdownIterator(int[] serviceIndex){
        boolean isTrue;
        newDemoLandingPage = new NewDemoLandingPage();
        priorAgreementComparison = new PriorAgreementComparisonPage();
        baseModal = new BaseModal();

        newDemoQALoginPage.launchUrl(this.url);
        newDemoQALoginPage.setEmailAddressNewDemo(this.email);
        newDemoQALoginPage.setPassword(this.password);
        newDemoQALoginPage.signInClick();
        newDemoLandingPage.clickOnPriorAgreementComparisonTile();
        By carrierServiceDropdown = priorAgreementComparison.getCarrierServiceDropdown();
        By carrierServiceDropdownElements = priorAgreementComparison.getCarrierServiceDropdownElements();
        isTrue= priorAgreementComparison.validateAllDropdownValues(carrierServiceDropdown,
                carrierServiceDropdownElements,serviceIndex);
        Assert.assertTrue(isTrue);
    }

    @DataProvider
        public Object[][] accountIndexIterator(){
        return new Object[][] {
                { new int[] {1,2,3,4,5,6} }};
        }
    @DataProvider(name = "getMonthIterator", parallel = true)
    public Object[] getMonthIterator(){
        return new Object[] {1,2,3,4};
    }
    @DataProvider
        public Object[][] getServiceIterator(){
        return new Object[][] {{new int[] {0,1,2} }};
    }

}
