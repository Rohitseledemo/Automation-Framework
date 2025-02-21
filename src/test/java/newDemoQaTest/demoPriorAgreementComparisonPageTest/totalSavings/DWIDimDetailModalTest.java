package newDemoQaTest.demoPriorAgreementComparisonPageTest.totalSavings;

import newDemoQaPages.NewDemoLandingPage;
import newDemoQaPages.demoPriorAgreementComparisonPage.PriorAgreementComparisonPage;
import newDemoQaPages.demoPriorAgreementComparisonPage.totalSavings.DWIDimDetailModal;
import newDemoQaPages.demoPriorAgreementComparisonPage.totalSavings.DimensionalWeightImpactModalFirstLevel;
import baseTest.NewDemoBaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class DWIDimDetailModalTest extends NewDemoBaseTest {
    PriorAgreementComparisonPage newDemoPriorAgreementComparison;
    NewDemoLandingPage newDemoLandingPage;
    DWIDimDetailModal dwiDimDetailModal;
    DimensionalWeightImpactModalFirstLevel dimensionalWeightImpactModalFirstLevel;

    @Test(testName = "PAC-DWI DimDetailModal Table Test")
    public void dimDetailModalTableTest() {
        int headerColumn;
        List<WebElement> columnValues;
        boolean result;
        newDemoLandingPage = new NewDemoLandingPage();
        newDemoPriorAgreementComparison = new PriorAgreementComparisonPage();
        dimensionalWeightImpactModalFirstLevel = new DimensionalWeightImpactModalFirstLevel();
        dwiDimDetailModal = new DWIDimDetailModal();

        newDemoQALoginPage.launchUrl(this.url);
        newDemoQALoginPage.setEmailAddressNewDemo(this.email);
        newDemoQALoginPage.setPassword(this.password);
        newDemoQALoginPage.signInClick();
        newDemoLandingPage.clickOnPriorAgreementComparisonTile();
        newDemoPriorAgreementComparison.dimensionalWeightImpactClick();
        dimensionalWeightImpactModalFirstLevel.dimDetailBtnClick();
        By serviceDropdown = dwiDimDetailModal.getServiceDropdown();
        By serviceDropdownElements = dwiDimDetailModal.getServiceDropdownElements();
        dwiDimDetailModal.anyCheckboxDropdownRandomValues(serviceDropdown,serviceDropdownElements);
        dwiDimDetailModal.getEmptyClickOperation();
        headerColumn=dwiDimDetailModal.headerClick("Service Type");
        columnValues=dwiDimDetailModal.columnDataWebElements(headerColumn);
        result = dwiDimDetailModal.dropdownAndColumnDataValidation(dwiDimDetailModal.getValueClickedNames(),columnValues
                ,true);
        Assert.assertTrue(result,"Selected Value from Dropdown not in the column.");
    }

    @Test(testName = "PAC-DWI DimDetailModal TableSorting Test")
    public void dimDetailModalSortingValidation(){
        int headerColumn;
        List<Float> columnValues;
        boolean isSorted;
        newDemoLandingPage = new NewDemoLandingPage();
        newDemoPriorAgreementComparison = new PriorAgreementComparisonPage();
        dimensionalWeightImpactModalFirstLevel = new DimensionalWeightImpactModalFirstLevel();
        dwiDimDetailModal = new DWIDimDetailModal();

        newDemoQALoginPage.launchUrl(this.url);
        newDemoQALoginPage.setEmailAddressNewDemo(this.email);
        newDemoQALoginPage.setPassword(this.password);
        newDemoQALoginPage.signInClick();
        newDemoLandingPage.clickOnPriorAgreementComparisonTile();
        newDemoPriorAgreementComparison.dimensionalWeightImpactClick();
        dimensionalWeightImpactModalFirstLevel.dimDetailBtnClick();
        //TC-1
        headerColumn = dwiDimDetailModal.headerClick("Number of Packages Impacted by DIM Weight");
        columnValues = dwiDimDetailModal.columnData(headerColumn);
        isSorted= dwiDimDetailModal.sortingValidation(columnValues);
        Assert.assertTrue(isSorted,"|Number of Packages Impacted by DIM Weight| Column values not Sorted.");
    }
    @Test(testName = "PAC-DWI DimDetailModal DownloadBtn Test")
    public void dimDetailModalDownloadBtnValidation(){
        boolean isDisplayed;
        newDemoLandingPage = new NewDemoLandingPage();
        newDemoPriorAgreementComparison = new PriorAgreementComparisonPage();
        dimensionalWeightImpactModalFirstLevel = new DimensionalWeightImpactModalFirstLevel();
        dwiDimDetailModal = new DWIDimDetailModal();

        newDemoQALoginPage.launchUrl(this.url);
        newDemoQALoginPage.setEmailAddressNewDemo(this.email);
        newDemoQALoginPage.setPassword(this.password);
        newDemoQALoginPage.signInClick();
        newDemoLandingPage.clickOnPriorAgreementComparisonTile();
        newDemoPriorAgreementComparison.dimensionalWeightImpactClick();
        dimensionalWeightImpactModalFirstLevel.dimDetailBtnClick();
        //TC-1
        isDisplayed=dwiDimDetailModal.testDownloadButtonFunctionality2();
        Assert.assertTrue(isDisplayed,"Download Confirmation Toast Not Displayed.");
    }
}
