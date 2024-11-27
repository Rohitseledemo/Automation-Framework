package newDemoQaTest.demoPriorAgreementComparisonPageTest;

import newDemoQaPages.*;
import newDemoQaPages.demoPriorAgreementComparisonPage.*;
import newDemoQaTest.NewDemoBaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;

public class PriorAgreementComparisonTest extends NewDemoBaseTest {

    PriorAgreementComparisonPage priorAgreementComparison;
    NewDemoLandingPage newDemoLandingPage;
    BaseModal baseModal;

    @Test(dataProvider = "getMonthIterator")
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
        Assert.assertTrue(totalSavingsActual);
        boolean transportationActual = priorAgreementComparison.transportationSavingsColorVerify();
        Assert.assertTrue(transportationActual);
        boolean surchargeActual = priorAgreementComparison.surchargeSavingsColorVerify();
        Assert.assertTrue(surchargeActual);
        boolean dimensionalActual = priorAgreementComparison.dimensionalWeightImpactColorVerify();
        Assert.assertTrue(dimensionalActual);
        boolean avgSavingsPkgActual = priorAgreementComparison.avgSavingsPerPkgBtnColorVerify();
        Assert.assertTrue(avgSavingsPkgActual);
        boolean actualSavingsActual = priorAgreementComparison.actualSavingsRefundsNameColorVerify();
        Assert.assertTrue(actualSavingsActual);
    }

    @Test(dataProvider = "getMonthIterator")
    public void priorAgreementComparisonTotalSavingsTest(int dateIndex) {
        boolean result;
        boolean click;
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
        Assert.assertTrue(result);
        click = priorAgreementComparison.totalSavingsClick();
        Assert.assertTrue(click);
    }

    @Test
    public void priorAgreementComparisonViewDetailsTest(){
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
        Assert.assertTrue(validate);
        //TC-2
        headerColumn = priorAgreementComparison.headerClick("Actual Weight");
        values = priorAgreementComparison.columnData(headerColumn);
        sorted = priorAgreementComparison.sortingValidation(values);
        Assert.assertTrue(sorted);
    }

    @Test
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
        Assert.assertTrue(isDisplayed);
        //TC-1 - show entries dropdown test
        serialNo= priorAgreementComparison.anyDropdownIterator(priorAgreementComparison.getShowEntriesDropdown()
                ,priorAgreementComparison.getShowEntriesDropdownElements());
        correct = priorAgreementComparison.showEntriesSerialNoValidator(serialNo);
        Assert.assertTrue(correct);
    }

    @Test(dataProvider = "getMonthIterator")
    //unit TC for account number dropdown
    public void accountDropdownIterator(int accountIndex){
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
        priorAgreementComparison.anyDropdownIterator(dropdown, dropdownElements,accountIndex);
    }
    @Test(dataProvider = "getServiceIterator")
    public void carrierServiceDropdownIterator(int serviceIndex){
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
        priorAgreementComparison.anyDropdownIterator(carrierServiceDropdown, carrierServiceDropdownElements,serviceIndex);
    }

    @Test
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

    @Test
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
        Assert.assertTrue(isVisible);
    }
    @Test
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
        Assert.assertTrue(isViewVisible);
        isVisible=priorAgreementComparison.multiDownloadButtonFuncTest("Download All");
        Assert.assertTrue(isVisible);
    }

    @Test
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

    @DataProvider
        public Object[] getMonthIterator(){
        return new Object[] {1,2,3,4};
        }
    @DataProvider
        public Object[] getServiceIterator(){
        return new Object[] {0,1,2};
    }
    @DataProvider
    public String[][] getDemoQACredentials () {

        String[][] data = new String[1][3];
        data[0][0] = "https://qa-demo.dogoodsinc.com/";
        data[0][1] = "subdomain@dogoodsinc.com";
        data[0][2] = "Dev@Admin2023!";

        return data;
    }

    }
