package newDemoQaTest.demoPriorAgreementComparisonPageTest.totalSavings;

import newDemoQaPages.NewDemoLandingPage;
import newDemoQaPages.NewDemoQALoginPage;
import newDemoQaPages.demoPriorAgreementComparisonPage.PriorAgreementComparisonPage;
import newDemoQaPages.demoPriorAgreementComparisonPage.totalSavings.DWIDimDetailModal;
import newDemoQaPages.demoPriorAgreementComparisonPage.totalSavings.DimensionalWeightImpactModalFirstLevel;
import newDemoQaTest.NewDemoBaseTest;
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

    @Test
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
        Assert.assertTrue(result);
    }

    @Test
    public void dimDetailModalSortingValidation(){
        int headerColumn;
        List<Float> columnValues;
        boolean isSorted, isDisplayed;
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
        Assert.assertTrue(isSorted);
        //TC-2
        isDisplayed=dwiDimDetailModal.testDownloadButtonFunctionality2();
        Assert.assertTrue(isDisplayed);

    }
}
