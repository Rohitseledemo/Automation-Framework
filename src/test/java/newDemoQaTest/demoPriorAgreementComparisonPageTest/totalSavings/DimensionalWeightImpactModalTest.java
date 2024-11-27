package newDemoQaTest.demoPriorAgreementComparisonPageTest.totalSavings;

import newDemoQaPages.BaseModal;
import newDemoQaPages.NewDemoLandingPage;
import newDemoQaPages.demoPriorAgreementComparisonPage.totalSavings.DimensionalWeightImpactModalFirstLevel;
import newDemoQaPages.demoPriorAgreementComparisonPage.totalSavings.DimensionalWeightImpactModalSecondLevel;
import newDemoQaPages.demoPriorAgreementComparisonPage.PriorAgreementComparisonPage;
import newDemoQaTest.NewDemoBaseTest;
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

    @Test(dataProvider = "getData")
    public void dimensionalWeightImpactSecondLevelModalTest(String serviceName){
        int headerColumnNum, pageNo;
        ArrayList<Float> values;
        boolean isDisplayed;
        boolean sorted;

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
        Assert.assertTrue(sorted);
        //TC-2
        boolean downloadText = dimensionalWeightImpactModalSecondLevel.testDownloadButtonFunctionality();
        Assert.assertTrue(downloadText);
        //TC-3
        pageNo = baseModal.paginationClick(0);
        dimensionalWeightImpactModalSecondLevel.pageSerialNoValidator(pageNo);
        //TC-6
        isDisplayed = dimensionalWeightImpactModalSecondLevel.trackingNumberValidation();
        Assert.assertTrue(isDisplayed);
    }

    @Test
    public void dimensionalWeightImpactFirstLevelModalTest(){
        boolean validate;
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

    @Test
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

    @Test(dataProvider = "getServiceIterator")
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

    @DataProvider
    public String[][] getData(){
        return new String[][] { {"Express"}, {"Ground"} };
    }
    @DataProvider
    public Object[] getMonthIterator(){
        return new Object[] {1,2,3,4,5};
    }
    @DataProvider
    public Object[] getServiceIterator(){
        return new Object[] {1,2};
    }

}
