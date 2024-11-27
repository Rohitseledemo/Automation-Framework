package newDemoQaTest.demoPriorAgreementComparisonPageTest;

import newDemoQaPages.BaseModal;
import newDemoQaPages.NewDemoLandingPage;
import newDemoQaPages.NewDemoQALoginPage;
import newDemoQaPages.demoPriorAgreementComparisonPage.*;
import newDemoQaPages.demoPriorAgreementComparisonPage.avgSavPerPkg.AvgSavPerPkgModalFirstLevel;
import newDemoQaPages.demoPriorAgreementComparisonPage.avgSavPerPkg.AvgSavPerPkgModalSecondLevel;
import newDemoQaTest.NewDemoBaseTest;
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

    @Test(dataProvider = "getServiceIterator")
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

    @Test
    public void averageSavingsPerPkgSecondLevelModalTest() {
        int columnCount, pageClickedNo;
        ArrayList<Float> values;
        boolean sorted;

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
        columnCount = averageSavingsPerPackageModalFirstLevel.headerClick("Service");
        List<WebElement> elements = averageSavingsPerPackageModalFirstLevel.columnDataWebElements(columnCount);
        baseModal.anyColumnValueClick(elements);
        pageClickedNo = baseModal.paginationClick(2);
        averageSavingsPerPackageModalFirstLevel.pageSerialNoValidator(pageClickedNo);
        columnCount = averageSavingsPerPackageModalSecondLevel.headerClick("Prior Invoiced Amount");
        values = averageSavingsPerPackageModalSecondLevel.columnData(columnCount);
        sorted =  baseModal.sortingValidation(values);
        Assert.assertTrue(sorted);
    }

    @Test(dataProvider = "getServiceIterator")
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

    @DataProvider
    public Object[] getServiceIterator(){
        return new Object[] {0,1,2};
    }

}
