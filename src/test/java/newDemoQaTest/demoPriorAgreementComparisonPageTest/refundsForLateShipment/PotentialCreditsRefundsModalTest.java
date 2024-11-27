package newDemoQaTest.demoPriorAgreementComparisonPageTest.refundsForLateShipment;

import baseClass.NewDemoBasePage;
import newDemoQaPages.BaseModal;
import newDemoQaPages.NewDemoLandingPage;
import newDemoQaPages.NewDemoQALoginPage;
import newDemoQaPages.demoPriorAgreementComparisonPage.refundsForLateShipment.PotentialCreditsRefundsModalFirstLevel;
import newDemoQaPages.demoPriorAgreementComparisonPage.PriorAgreementComparisonPage;
import newDemoQaPages.demoPriorAgreementComparisonPage.refundsForLateShipment.PotentialCreditsRefundsModalFourthLevel;
import newDemoQaPages.demoPriorAgreementComparisonPage.refundsForLateShipment.PotentialCreditsRefundsModalSecondLevel;
import newDemoQaPages.demoPriorAgreementComparisonPage.refundsForLateShipment.ServiceSummaryModalThirdLevel;
import newDemoQaTest.NewDemoBaseTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.List;

public class PotentialCreditsRefundsModalTest extends NewDemoBaseTest {

    PriorAgreementComparisonPage priorAgreementComparison;
    NewDemoLandingPage newDemoLandingPage;
    BaseModal baseModal;
    NewDemoBasePage newDemoBasePage;
    PotentialCreditsRefundsModalFirstLevel potentialCreditsRefundsModalFirstLevel;
    PotentialCreditsRefundsModalSecondLevel potentialCreditsRefundsModalSecondLevel;
    ServiceSummaryModalThirdLevel serviceSummaryModalThirdLevel;
    PotentialCreditsRefundsModalFourthLevel potentialCreditsRefundsModalFourthLevel;

    @Test
    public void potentialCreditsRefundsFirstLevelModalTest() {
        int headerColumnCount, pageNo;
        ArrayList<Float> values;
        boolean sorted;
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
        potentialCreditsRefundsModalFirstLevel.pageSerialNoValidator(pageNo);
        //TC-3
        headerColumnCount = potentialCreditsRefundsModalFirstLevel.headerClick("Refund Amount");
        values = potentialCreditsRefundsModalFirstLevel.columnData(headerColumnCount);
        sorted = baseModal.sortingValidation(values);
        Assert.assertTrue(sorted);
    }

    @Test
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
        Assert.assertTrue(correct);
    }

    @Test
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
        Assert.assertEquals(actual,serviceSummaryModalThirdLevel.getServiceSummaryTotalCount());
        }

    @Test
    public void potentialCreditsRefundsModalThirdLevelTest() {
        int headerColumnCount;
        List<Float> numbers;

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

    @Test
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
        baseModal = new BaseModal();

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
        Assert.assertTrue(sorted);
        //TC-3
//        potentialCreditsRefundsModalFourthLevel.anyDropdownIterator(potentialCreditsRefundsModalFourthLevel.getShowEntriesDropdown(),
//                potentialCreditsRefundsModalFourthLevel.getShowEntriesDropdownElements(),1);
//        potentialCreditsRefundsModalFourthLevel.showEntriesSerialNoValidator(1);
        //TC-4
        headerColumnCount = potentialCreditsRefundsModalFourthLevel.headerClick("Net Amount");
        numbers = potentialCreditsRefundsModalFourthLevel.columnData(headerColumnCount);
        sorted  = potentialCreditsRefundsModalFourthLevel.sortingValidation(numbers);
        Assert.assertTrue(sorted);
    }

    @Test
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
