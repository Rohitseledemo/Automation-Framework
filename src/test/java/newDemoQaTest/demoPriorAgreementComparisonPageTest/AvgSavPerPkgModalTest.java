package newDemoQaTest.demoPriorAgreementComparisonPageTest;

import newDemoQaPages.BaseModal;
import newDemoQaPages.NewDemoLandingPage;
import newDemoQaPages.demoPriorAgreementComparisonPage.*;
import newDemoQaPages.demoPriorAgreementComparisonPage.avgSavPerPkg.AvgSavPerPkgModalFirstLevel;
import newDemoQaPages.demoPriorAgreementComparisonPage.avgSavPerPkg.AvgSavPerPkgModalSecondLevel;
import baseTest.NewDemoBaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;
import java.util.ArrayList;
import java.util.List;

public class AvgSavPerPkgModalTest extends NewDemoBaseTest {

    PriorAgreementComparisonPage newDemoPriorAgreementComparison;
    NewDemoLandingPage newDemoLandingPage;
    BaseModal baseModal;
    AvgSavPerPkgModalFirstLevel averageSavingsPerPackageModalFirstLevel;
    AvgSavPerPkgModalSecondLevel averageSavingsPerPackageModalSecondLevel;

    @Test(testName = "Avg-Savings 1LvlModal Table Test ", dataProvider = "getServiceIterator")
    public void averageSavingsPerPkgFirstLevelModalTest(int serviceIndex){
        int headerColumnCount;
        List<Float> numbers;
        newDemoLandingPage = new NewDemoLandingPage();
        newDemoPriorAgreementComparison = new PriorAgreementComparisonPage();
        averageSavingsPerPackageModalFirstLevel = new AvgSavPerPkgModalFirstLevel();
        baseModal = new BaseModal();
        newDemoQALoginPage.launchUrl(this.url);
        newDemoQALoginPage.setEmailAddressNewDemo(this.email);
        newDemoQALoginPage.setPassword(this.password);
        newDemoQALoginPage.signInClick();
        newDemoLandingPage.clickOnPriorAgreementComparisonTile();
        newDemoPriorAgreementComparison.averageSavingsPerPkgClick();
        By carrierServiceDropdown = averageSavingsPerPackageModalFirstLevel.getCarrierServiceDropdown();
        By carrierServiceDropdownElements = averageSavingsPerPackageModalFirstLevel.getCarrierServiceDropdownElements();
        averageSavingsPerPackageModalFirstLevel.anyDropdownIterator(carrierServiceDropdown, carrierServiceDropdownElements,serviceIndex);
        headerColumnCount = averageSavingsPerPackageModalFirstLevel.headerClick("Count");
        numbers = averageSavingsPerPackageModalFirstLevel.columnData(headerColumnCount);
        float actual = baseModal.calculateSum(numbers);
        Assert.assertEquals(actual,averageSavingsPerPackageModalFirstLevel.getAvgSavFirstModalTotalRowCount());
    }

    @Test(testName = "Avg-Savings 1LvlModal DownloadBtn Test")
    public void avgSavPkgFirstLvlDownloadBtnTest(){
        boolean isDisplayed;
        newDemoLandingPage = new NewDemoLandingPage();
        newDemoPriorAgreementComparison = new PriorAgreementComparisonPage();
        averageSavingsPerPackageModalFirstLevel = new AvgSavPerPkgModalFirstLevel();
        baseModal = new BaseModal();
        newDemoQALoginPage.launchUrl(this.url);
        newDemoQALoginPage.setEmailAddressNewDemo(this.email);
        newDemoQALoginPage.setPassword(this.password);
        newDemoQALoginPage.signInClick();
        newDemoLandingPage.clickOnPriorAgreementComparisonTile();
        newDemoPriorAgreementComparison.averageSavingsPerPkgClick();
        isDisplayed = averageSavingsPerPackageModalFirstLevel.testDownloadButtonFunctionality2();
        Assert.assertTrue(isDisplayed);
    }

    @Test(testName = "Avg-Savings 1LvlModal ServiceDropdown Test")
    public void avgSavPkgFirstLvlServiceDropdownTest() {
        int headerColumnCount;
        List<WebElement> elements;
        boolean result;
        newDemoLandingPage = new NewDemoLandingPage();
        newDemoPriorAgreementComparison = new PriorAgreementComparisonPage();
        averageSavingsPerPackageModalFirstLevel = new AvgSavPerPkgModalFirstLevel();
        baseModal = new BaseModal();
        newDemoQALoginPage.launchUrl(this.url);
        newDemoQALoginPage.setEmailAddressNewDemo(this.email);
        newDemoQALoginPage.setPassword(this.password);
        newDemoQALoginPage.signInClick();
        newDemoLandingPage.clickOnPriorAgreementComparisonTile();
        newDemoPriorAgreementComparison.averageSavingsPerPkgClick();
        By serviceNameDropdown = averageSavingsPerPackageModalFirstLevel.getServiceNameDropdown();
        By serviceNameDropdownElements = averageSavingsPerPackageModalFirstLevel.getServiceNameDropdownElements();
        List<String> dropdownValues = averageSavingsPerPackageModalFirstLevel.anyCheckboxDropdownRandomValues(serviceNameDropdown,
                serviceNameDropdownElements);
        System.out.println("dropdownValues size - "+dropdownValues.size());
        averageSavingsPerPackageModalFirstLevel.getEmptyClickOperation();
        headerColumnCount = averageSavingsPerPackageModalFirstLevel.headerClick("Service Name");
        elements = averageSavingsPerPackageModalFirstLevel.columnDataWebElements(headerColumnCount);
        result = averageSavingsPerPackageModalFirstLevel.dropdownAndColumnDataValidation(averageSavingsPerPackageModalFirstLevel.
                getValueClickedNames(),elements,true);
        Assert.assertTrue(result);
    }

    @Test(testName = "Avg-Savings 2LvlModal Table Test")
    public void avgSavPkgSecondLevelModalTest() {
        int columnCount, pageClickedNo;
        ArrayList<Float> values;
        boolean sorted, correctPage;

        newDemoLandingPage = new NewDemoLandingPage();
        newDemoPriorAgreementComparison = new PriorAgreementComparisonPage();
        averageSavingsPerPackageModalFirstLevel = new AvgSavPerPkgModalFirstLevel();
        averageSavingsPerPackageModalSecondLevel = new AvgSavPerPkgModalSecondLevel();
        baseModal = new BaseModal();

        newDemoQALoginPage.launchUrl(this.url);
        newDemoQALoginPage.setEmailAddressNewDemo(this.email);
        newDemoQALoginPage.setPassword(this.password);
        newDemoQALoginPage.signInClick();
        newDemoLandingPage.clickOnPriorAgreementComparisonTile();
        newDemoPriorAgreementComparison.averageSavingsPerPkgClick();
        columnCount = averageSavingsPerPackageModalFirstLevel.headerClick("Service Name");
        List<WebElement> elements = averageSavingsPerPackageModalFirstLevel.columnDataWebElements(columnCount);
        baseModal.anyColumnValueClick(elements);
        pageClickedNo = baseModal.paginationClick(2);
        correctPage = averageSavingsPerPackageModalFirstLevel.pageSerialNoValidator(pageClickedNo);
        softAssert.assertTrue(correctPage,"");
        columnCount = averageSavingsPerPackageModalSecondLevel.headerClick("Prior Invoiced Amount");
        values = averageSavingsPerPackageModalSecondLevel.columnData(columnCount);
        sorted = baseModal.sortingValidation(values);
        softAssert.assertTrue(sorted,"|Prior Invoiced Amount| Column values not Sorted.");
        softAssert.assertAll();
    }

    @Test(testName = "Avg-Savings 2LvlModal DownloadBtn Test")
    public void avgSavPkgSecondLevelModalDownloadBtnTest() {
        int columnCount;
        boolean isDisplayed;
        newDemoLandingPage = new NewDemoLandingPage();
        newDemoPriorAgreementComparison = new PriorAgreementComparisonPage();
        averageSavingsPerPackageModalFirstLevel = new AvgSavPerPkgModalFirstLevel();
        averageSavingsPerPackageModalSecondLevel = new AvgSavPerPkgModalSecondLevel();
        baseModal = new BaseModal();

        newDemoQALoginPage.launchUrl(this.url);
        newDemoQALoginPage.setEmailAddressNewDemo(this.email);
        newDemoQALoginPage.setPassword(this.password);
        newDemoQALoginPage.signInClick();
        newDemoLandingPage.clickOnPriorAgreementComparisonTile();
        newDemoPriorAgreementComparison.averageSavingsPerPkgClick();
        columnCount = averageSavingsPerPackageModalFirstLevel.headerClick("Service Name");
        List<WebElement> elements = averageSavingsPerPackageModalFirstLevel.columnDataWebElements(columnCount);
        baseModal.anyColumnValueClick(elements);
        isDisplayed = averageSavingsPerPackageModalSecondLevel.testDownloadButtonFunctionality2();
        Assert.assertTrue(isDisplayed,"Download Confirmation Toast Not Displayed.");
    }
//    @Test
    public void avgSavPkgSecondLevelModalTimePeriodDropdownTest() {
        int columnCount;
        List<WebElement> values;
        List<String> dropdownValues;
        boolean result;

        newDemoLandingPage = new NewDemoLandingPage();
        newDemoPriorAgreementComparison = new PriorAgreementComparisonPage();
        averageSavingsPerPackageModalFirstLevel = new AvgSavPerPkgModalFirstLevel();
        averageSavingsPerPackageModalSecondLevel = new AvgSavPerPkgModalSecondLevel();
        baseModal = new BaseModal();

        newDemoQALoginPage.launchUrl(this.url);
        newDemoQALoginPage.setEmailAddressNewDemo(this.email);
        newDemoQALoginPage.setPassword(this.password);
        newDemoQALoginPage.signInClick();
        newDemoLandingPage.clickOnPriorAgreementComparisonTile();
        newDemoPriorAgreementComparison.averageSavingsPerPkgClick();
        columnCount = averageSavingsPerPackageModalFirstLevel.headerClick("Service Name");
        List<WebElement> elements = averageSavingsPerPackageModalFirstLevel.columnDataWebElements(columnCount);
        baseModal.anyColumnValueClick(elements);
        By timePeriodDropdown = averageSavingsPerPackageModalSecondLevel.getTimePeriodDropdown();
        By timePeriodDropdownElements = averageSavingsPerPackageModalSecondLevel.getTimePeriodDropdownElements();
        dropdownValues = averageSavingsPerPackageModalSecondLevel.anyCheckboxDropdownRandomValues(timePeriodDropdown,timePeriodDropdownElements);
        columnCount = averageSavingsPerPackageModalSecondLevel.headerClick("Invoice Date");
        values = averageSavingsPerPackageModalSecondLevel.columnDataWebElements(columnCount);
        result = averageSavingsPerPackageModalSecondLevel.dropdownAndColumnDataValidation(dropdownValues,values,true);
        Assert.assertTrue(result);
    }

    @Test(testName = "Avg-Savings ServiceDropdown Test", dataProvider = "getServiceIterator")
    public void carrierServiceDropdownIterator(int serviceIndex){
        newDemoLandingPage = new NewDemoLandingPage();
        averageSavingsPerPackageModalFirstLevel = new AvgSavPerPkgModalFirstLevel();
        newDemoPriorAgreementComparison = new PriorAgreementComparisonPage();
        baseModal = new BaseModal();

        newDemoQALoginPage.launchUrl(this.url);
        newDemoQALoginPage.setEmailAddressNewDemo(this.email);
        newDemoQALoginPage.setPassword(this.password);
        newDemoQALoginPage.signInClick();
        newDemoLandingPage.clickOnPriorAgreementComparisonTile();
        newDemoPriorAgreementComparison.averageSavingsPerPkgClick();
        By carrierServiceDropdown = averageSavingsPerPackageModalFirstLevel.getCarrierServiceDropdown();
        By carrierServiceDropdownElements = averageSavingsPerPackageModalFirstLevel.getCarrierServiceDropdownElements();
        averageSavingsPerPackageModalFirstLevel.anyDropdownIterator(carrierServiceDropdown, carrierServiceDropdownElements,serviceIndex);
    }

    @DataProvider(name = "getServiceIterator", parallel = true)
    public Object[] getServiceIterator(){
        return new Object[] {0,1,2};
    }

}
