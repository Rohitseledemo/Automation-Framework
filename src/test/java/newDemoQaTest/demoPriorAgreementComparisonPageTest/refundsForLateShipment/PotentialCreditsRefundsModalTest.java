package newDemoQaTest.demoPriorAgreementComparisonPageTest.refundsForLateShipment;

import newDemoQaPages.BaseModal;
import newDemoQaPages.NewDemoLandingPage;
import newDemoQaPages.demoPriorAgreementComparisonPage.refundsForLateShipment.PotentialCreditsRefundsModalFirstLevel;
import newDemoQaPages.demoPriorAgreementComparisonPage.PriorAgreementComparisonPage;
import newDemoQaPages.demoPriorAgreementComparisonPage.refundsForLateShipment.PotentialCreditsRefundsModalFourthLevel;
import newDemoQaPages.demoPriorAgreementComparisonPage.refundsForLateShipment.PotentialCreditsRefundsModalSecondLevel;
import newDemoQaPages.demoPriorAgreementComparisonPage.refundsForLateShipment.ServiceSummaryModalThirdLevel;
import baseTest.NewDemoBaseTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.List;

public class PotentialCreditsRefundsModalTest extends NewDemoBaseTest {

    PriorAgreementComparisonPage priorAgreementComparison;
    NewDemoLandingPage newDemoLandingPage;
    BaseModal baseModal;
    PotentialCreditsRefundsModalFirstLevel potentialCreditsRefundsModalFirstLevel;
    PotentialCreditsRefundsModalSecondLevel potentialCreditsRefundsModalSecondLevel;
    ServiceSummaryModalThirdLevel serviceSummaryModalThirdLevel;
    PotentialCreditsRefundsModalFourthLevel potentialCreditsRefundsModalFourthLevel;

    @Test(testName = "PAC-PS 1Lvl Table Test")
    public void potentialCreditsRefundsFirstLevelModalTest() {
        int headerColumnCount, pageNo;
        ArrayList<Float> values;
        boolean sorted, serialNos;
        newDemoLandingPage = new NewDemoLandingPage();
        priorAgreementComparison = new PriorAgreementComparisonPage();
        potentialCreditsRefundsModalFirstLevel = new PotentialCreditsRefundsModalFirstLevel();
        baseModal = new BaseModal();

        newDemoQALoginPage.launchUrl(this.url);
        newDemoQALoginPage.setEmailAddressNewDemo(this.email);
        newDemoQALoginPage.setPassword(this.password);
        newDemoQALoginPage.signInClick();
        newDemoLandingPage.clickOnPriorAgreementComparisonTile();
        priorAgreementComparison.potentialSavingsRefundClick();
        //TC-1
        potentialCreditsRefundsModalFirstLevel.pageDataValidator(priorAgreementComparison.getTotalSavings(),priorAgreementComparison.
                getDateDropdown(),priorAgreementComparison.getDateDropdownElements());
        //TC-2
        pageNo = potentialCreditsRefundsModalFirstLevel.paginationClick(2);
        serialNos=potentialCreditsRefundsModalFirstLevel.pageSerialNoValidator(pageNo);
        softAssert.assertTrue(serialNos,"Serial Number Not Correct According To Pagination.");
        //TC-3
        headerColumnCount = potentialCreditsRefundsModalFirstLevel.headerClick("Refund Amount");
        values = potentialCreditsRefundsModalFirstLevel.columnData(headerColumnCount);
        sorted = baseModal.sortingValidation(values);
        softAssert.assertTrue(sorted,"|Refund Amount| Column values not Sorted.");
        softAssert.assertAll();
    }

    @Test(testName = "PAC-PS 1Lvl ShowEntries Test")
    public void potentialCreditsRefundsShowEntriesTest() {
        int serialNo;
        boolean correct;
        newDemoLandingPage = new NewDemoLandingPage();
        priorAgreementComparison = new PriorAgreementComparisonPage();
        potentialCreditsRefundsModalFirstLevel = new PotentialCreditsRefundsModalFirstLevel();
        baseModal = new BaseModal();

        newDemoQALoginPage.launchUrl(this.url);
        newDemoQALoginPage.setEmailAddressNewDemo(this.email);
        newDemoQALoginPage.setPassword(this.password);
        newDemoQALoginPage.signInClick();
        newDemoLandingPage.clickOnPriorAgreementComparisonTile();
        priorAgreementComparison.potentialSavingsRefundClick();
        //TC-1
        potentialCreditsRefundsModalFirstLevel.pageDataValidator(priorAgreementComparison.getTotalSavings(),priorAgreementComparison.
                getDateDropdown(),priorAgreementComparison.getDateDropdownElements());
        //TC-2 - Show entries dropdown test
        serialNo= potentialCreditsRefundsModalFirstLevel.anyDropdownIterator(potentialCreditsRefundsModalFirstLevel.getShowEntriesDropdown()
                ,potentialCreditsRefundsModalFirstLevel.getShowEntriesDropdownElements());
        correct = potentialCreditsRefundsModalFirstLevel.showEntriesSerialNoValidator(serialNo);
        Assert.assertTrue(correct,"Show Entries Value not correct.");
    }

    @Test(testName = "PAC-PS ServiceSummaryModal Test")
    public void potentialCreditsRefundsModalServiceSummaryThirdLevelTest(){
        int headerColumnCount;
        List<Float> numbers;

        newDemoLandingPage = new NewDemoLandingPage();
        priorAgreementComparison = new PriorAgreementComparisonPage();
        potentialCreditsRefundsModalFirstLevel = new PotentialCreditsRefundsModalFirstLevel();
        potentialCreditsRefundsModalSecondLevel = new PotentialCreditsRefundsModalSecondLevel();
        serviceSummaryModalThirdLevel = new ServiceSummaryModalThirdLevel();
        baseModal = new BaseModal();

        newDemoQALoginPage.launchUrl(this.url);
        newDemoQALoginPage.setEmailAddressNewDemo(this.email);
        newDemoQALoginPage.setPassword(this.password);
        newDemoQALoginPage.signInClick();
        newDemoLandingPage.clickOnPriorAgreementComparisonTile();
        priorAgreementComparison.potentialSavingsRefundClick();
        potentialCreditsRefundsModalFirstLevel.performanceReportingBtnClick();
        potentialCreditsRefundsModalSecondLevel.serviceSummaryBtnClick();
        headerColumnCount = serviceSummaryModalThirdLevel.headerClick("Total Packages");
        numbers = serviceSummaryModalThirdLevel.columnData(headerColumnCount);
        float actual = serviceSummaryModalThirdLevel.calculateSum(numbers);
        Assert.assertEquals(actual,serviceSummaryModalThirdLevel.getServiceSummaryTotalCount(),
                "|Total Packages| total row count not matching.");
        }

    @Test(testName = "PAC-PS 3Lvl ColumnDropdown Test")
    public void potentialCreditsRefundsModalThirdLevelTest() {
        int headerColumnCount;
        newDemoLandingPage = new NewDemoLandingPage();
        priorAgreementComparison = new PriorAgreementComparisonPage();
        potentialCreditsRefundsModalFirstLevel = new PotentialCreditsRefundsModalFirstLevel();
        potentialCreditsRefundsModalSecondLevel = new PotentialCreditsRefundsModalSecondLevel();
        serviceSummaryModalThirdLevel = new ServiceSummaryModalThirdLevel();
        potentialCreditsRefundsModalFourthLevel = new PotentialCreditsRefundsModalFourthLevel();
        baseModal = new BaseModal();

        newDemoQALoginPage.launchUrl(this.url);
        newDemoQALoginPage.setEmailAddressNewDemo(this.email);
        newDemoQALoginPage.setPassword(this.password);
        newDemoQALoginPage.signInClick();
        newDemoLandingPage.clickOnPriorAgreementComparisonTile();
        priorAgreementComparison.potentialSavingsRefundClick();
        potentialCreditsRefundsModalFirstLevel.performanceReportingBtnClick();
        potentialCreditsRefundsModalSecondLevel.serviceSummaryBtnClick();
        headerColumnCount = serviceSummaryModalThirdLevel.headerClick("Service Type");
        List<WebElement> elements = serviceSummaryModalThirdLevel.columnDataWebElements(headerColumnCount);
        serviceSummaryModalThirdLevel.anyColumnValueClick(elements);
    }

    @Test(testName = "PAC-PS 4Lvl Table Test")
    public void potentialCreditsRefundsModalFourthLevelTest() {
        int headerColumnCount, pageNo;
        List<Float> numbers;
        boolean sorted;

        newDemoLandingPage = new NewDemoLandingPage();
        priorAgreementComparison = new PriorAgreementComparisonPage();
        potentialCreditsRefundsModalFirstLevel = new PotentialCreditsRefundsModalFirstLevel();
        potentialCreditsRefundsModalSecondLevel = new PotentialCreditsRefundsModalSecondLevel();
        serviceSummaryModalThirdLevel = new ServiceSummaryModalThirdLevel();
        potentialCreditsRefundsModalFourthLevel = new PotentialCreditsRefundsModalFourthLevel();

        newDemoQALoginPage.launchUrl(this.url);
        newDemoQALoginPage.setEmailAddressNewDemo(this.email);
        newDemoQALoginPage.setPassword(this.password);
        newDemoQALoginPage.signInClick();
        newDemoLandingPage.clickOnPriorAgreementComparisonTile();
        priorAgreementComparison.potentialSavingsRefundClick();
        potentialCreditsRefundsModalFirstLevel.performanceReportingBtnClick();
        potentialCreditsRefundsModalSecondLevel.serviceSummaryBtnClick();
        //TC-1
        headerColumnCount = serviceSummaryModalThirdLevel.headerClick("Service Type");
        List<WebElement> elements = serviceSummaryModalThirdLevel.columnDataWebElements(headerColumnCount);
        serviceSummaryModalThirdLevel.anyColumnValueClick(elements);
        //TC-2
        pageNo=potentialCreditsRefundsModalFourthLevel.paginationClick(1);
        System.out.println(pageNo);
        sorted = potentialCreditsRefundsModalFourthLevel.pageSerialNoValidator(pageNo);
        softAssert.assertTrue(sorted,"Serial Number Not Correct According To Pagination.");
        //TC-3
//        potentialCreditsRefundsModalFourthLevel.anyDropdownIterator(potentialCreditsRefundsModalFourthLevel.getShowEntriesDropdown(),
//                potentialCreditsRefundsModalFourthLevel.getShowEntriesDropdownElements(),1);
//        potentialCreditsRefundsModalFourthLevel.showEntriesSerialNoValidator(1);
        //TC-4
        headerColumnCount = potentialCreditsRefundsModalFourthLevel.headerClick("Net Amount");
        numbers = potentialCreditsRefundsModalFourthLevel.columnData(headerColumnCount);
        sorted  = potentialCreditsRefundsModalFourthLevel.sortingValidation(numbers);
        softAssert.assertTrue(sorted,"|Net Amount| Column values not Sorted.");
        softAssert.assertAll();
    }

    @Test(testName = "PAC-PS 2Lvl CarrierSelector Validation")
    public void potentialCreditsRefundsModalSecondLevelTest(){
        newDemoLandingPage = new NewDemoLandingPage();
        priorAgreementComparison = new PriorAgreementComparisonPage();
        potentialCreditsRefundsModalFirstLevel = new PotentialCreditsRefundsModalFirstLevel();
        potentialCreditsRefundsModalSecondLevel = new PotentialCreditsRefundsModalSecondLevel();
        baseModal = new BaseModal();

        newDemoQALoginPage.launchUrl(this.url);
        newDemoQALoginPage.setEmailAddressNewDemo(this.email);
        newDemoQALoginPage.setPassword(this.password);
        newDemoQALoginPage.signInClick();
        newDemoLandingPage.clickOnPriorAgreementComparisonTile();
        priorAgreementComparison.potentialSavingsRefundClick();
        potentialCreditsRefundsModalFirstLevel.performanceReportingBtnClick();
        potentialCreditsRefundsModalSecondLevel.carrierSelectorValidator();
    }

}
