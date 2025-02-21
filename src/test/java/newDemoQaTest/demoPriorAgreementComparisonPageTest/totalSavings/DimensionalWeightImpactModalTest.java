package newDemoQaTest.demoPriorAgreementComparisonPageTest.totalSavings;

import newDemoQaPages.BaseModal;
import newDemoQaPages.NewDemoLandingPage;
import newDemoQaPages.demoPriorAgreementComparisonPage.totalSavings.DimensionalWeightImpactModalFirstLevel;
import newDemoQaPages.demoPriorAgreementComparisonPage.totalSavings.DimensionalWeightImpactModalSecondLevel;
import newDemoQaPages.demoPriorAgreementComparisonPage.PriorAgreementComparisonPage;
import baseTest.NewDemoBaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;
import java.util.ArrayList;

public class DimensionalWeightImpactModalTest extends NewDemoBaseTest {

    PriorAgreementComparisonPage newDemoPriorAgreementComparison;
    NewDemoLandingPage newDemoLandingPage;
    DimensionalWeightImpactModalFirstLevel dimensionalWeightImpactModalFirstLevel;
    DimensionalWeightImpactModalSecondLevel dimensionalWeightImpactModalSecondLevel;
    BaseModal baseModal;

    @Test(testName = "PAC-DWI 2LvlModal Test", dataProvider = "getData")
    public void dimensionalWeightImpactSecondLevelModalTest(String serviceName){
        int headerColumnNum, pageNo;
        ArrayList<Float> values;
        boolean isDisplayed, sorted, serialNos;

        newDemoLandingPage = new NewDemoLandingPage();
        newDemoPriorAgreementComparison = new PriorAgreementComparisonPage();
        dimensionalWeightImpactModalFirstLevel = new DimensionalWeightImpactModalFirstLevel();
        dimensionalWeightImpactModalSecondLevel = new DimensionalWeightImpactModalSecondLevel();
        baseModal = new BaseModal();

        newDemoQALoginPage.launchUrl(this.url);
        newDemoQALoginPage.setEmailAddressNewDemo(this.email);
        newDemoQALoginPage.setPassword(this.password);
        newDemoQALoginPage.signInClick();
        newDemoLandingPage.clickOnPriorAgreementComparisonTile();
        newDemoPriorAgreementComparison.dimensionalWeightImpactClick();
        if(serviceName.equalsIgnoreCase("Express")){
            dimensionalWeightImpactModalFirstLevel.clickOnServiceByName(serviceName);
        }
        if (serviceName.equalsIgnoreCase("Ground")){
            dimensionalWeightImpactModalFirstLevel.clickOnServiceByName(serviceName);
        }
        //TC-1
        dimensionalWeightImpactModalFirstLevel.getTableColumn("Count");
        dimensionalWeightImpactModalFirstLevel.getColumnValues();
        //TC-4
        headerColumnNum = dimensionalWeightImpactModalSecondLevel.headerClick("Prior Invoiced Amount");
        values = baseModal.columnData(headerColumnNum);
        //TC-5
        sorted =  baseModal.sortingValidation(values);
        softAssert.assertTrue(sorted,"|Prior Invoiced Amount| column values not sorted.");
        //TC-2
        boolean downloadText = dimensionalWeightImpactModalSecondLevel.testDownloadButtonFunctionality2();
        softAssert.assertTrue(downloadText,"Download Confirmation Toast Not Displayed.");
        //TC-3
        pageNo = baseModal.paginationClick(0);
        serialNos = dimensionalWeightImpactModalSecondLevel.pageSerialNoValidator(pageNo);
        softAssert.assertTrue(serialNos,"Serial Number Not Correct According To Pagination.");
        //TC-6
        isDisplayed = dimensionalWeightImpactModalSecondLevel.trackingNumberValidation();
        softAssert.assertTrue(isDisplayed,"Tracking Number Modal is not Displayed.");
        softAssert.assertAll();
    }

    @Test(testName = "PAC-DWI 1LvlModal ServiceDropdown Test", dataProvider = "getData")
    public void dimensionalWeightImpactFirstLevelModalTest(){
        newDemoLandingPage = new NewDemoLandingPage();
        newDemoPriorAgreementComparison = new PriorAgreementComparisonPage();
        dimensionalWeightImpactModalFirstLevel = new DimensionalWeightImpactModalFirstLevel();
        baseModal = new BaseModal();

        newDemoQALoginPage.launchUrl(this.url);
        newDemoQALoginPage.setEmailAddressNewDemo(this.email);
        newDemoQALoginPage.setPassword(this.password);
        newDemoQALoginPage.signInClick();
        newDemoLandingPage.clickOnPriorAgreementComparisonTile();
        newDemoPriorAgreementComparison.dimensionalWeightImpactClick();
        //this is to validate the landing service name and table.
        dimensionalWeightImpactModalFirstLevel.anyCheckboxDropdownRandomValues(dimensionalWeightImpactModalFirstLevel.
                getServiceDropdown(),dimensionalWeightImpactModalFirstLevel.getServiceDropdownElements());
    }

    @Test(testName = "PAC-DWI 1LvlModal DownloadFunctionality Test")
    public void dimensionalWeightImpactDownloadFunctionalityTest(){
        newDemoLandingPage = new NewDemoLandingPage();
        newDemoPriorAgreementComparison = new PriorAgreementComparisonPage();
        dimensionalWeightImpactModalFirstLevel = new DimensionalWeightImpactModalFirstLevel();
        dimensionalWeightImpactModalSecondLevel = new DimensionalWeightImpactModalSecondLevel();
        baseModal = new BaseModal();

        newDemoQALoginPage.launchUrl(this.url);
        newDemoQALoginPage.setEmailAddressNewDemo(this.email);
        newDemoQALoginPage.setPassword(this.password);
        newDemoQALoginPage.signInClick();
        newDemoLandingPage.clickOnPriorAgreementComparisonTile();
        newDemoPriorAgreementComparison.dimensionalWeightImpactClick();
        //TC-1
        boolean downloadText = dimensionalWeightImpactModalFirstLevel.testDownloadButtonFunctionality();
        Assert.assertTrue(downloadText);
    }

    @Test(testName = "PAC-DWI ServiceDropdown Test",dataProvider = "getServiceIterator")
    public void carrierServiceDropdownIterator(int serviceIndex){
        newDemoLandingPage = new NewDemoLandingPage();
        newDemoPriorAgreementComparison = new PriorAgreementComparisonPage();
        dimensionalWeightImpactModalFirstLevel = new DimensionalWeightImpactModalFirstLevel();
        baseModal = new BaseModal();

        newDemoQALoginPage.launchUrl(this.url);
        newDemoQALoginPage.setEmailAddressNewDemo(this.email);
        newDemoQALoginPage.setPassword(this.password);
        newDemoQALoginPage.signInClick();
        newDemoLandingPage.clickOnPriorAgreementComparisonTile();
        newDemoPriorAgreementComparison.dimensionalWeightImpactClick();
        By carrierServiceDropdown = dimensionalWeightImpactModalFirstLevel.getCarrierServiceDropdown();
        By carrierServiceDropdownElements = dimensionalWeightImpactModalFirstLevel.getCarrierServiceDropdownElements();
        dimensionalWeightImpactModalFirstLevel.anyDropdownIterator(carrierServiceDropdown, carrierServiceDropdownElements,serviceIndex);
    }
    @Test(testName = "PAC-DWI TimePeriodDropdown Test",dataProvider = "getMonthIterator")
    public void timePeriodDropdownIteratorDWIModal(int monthIndex) {
        newDemoLandingPage = new NewDemoLandingPage();
        newDemoPriorAgreementComparison = new PriorAgreementComparisonPage();
        dimensionalWeightImpactModalFirstLevel = new DimensionalWeightImpactModalFirstLevel();
        baseModal = new BaseModal();

        newDemoQALoginPage.launchUrl(this.url);
        newDemoQALoginPage.setEmailAddressNewDemo(this.email);
        newDemoQALoginPage.setPassword(this.password);
        newDemoQALoginPage.signInClick();
        newDemoLandingPage.clickOnPriorAgreementComparisonTile();
        newDemoPriorAgreementComparison.dimensionalWeightImpactClick();
        By timePeriodDropdown = dimensionalWeightImpactModalFirstLevel.getTimePeriodDropdown();
        By timePeriodDropdownElements = dimensionalWeightImpactModalFirstLevel.getTimePeriodDropdownElements();
        dimensionalWeightImpactModalFirstLevel.anyDropdownIterator(timePeriodDropdown, timePeriodDropdownElements,monthIndex);
    }

    @DataProvider(name = "getData", parallel = true)
    public String[][] getData(){
        return new String[][] { {"Express"}, {"Ground"} };
    }
    @DataProvider(name = "getMonthIterator", parallel = true)
    public Object[] getMonthIterator(){
        return new Object[] {1,2,3};
    }
    @DataProvider(name = "getServiceIterator", parallel = true)
    public Object[] getServiceIterator(){
        return new Object[] {1,2};
    }

}
