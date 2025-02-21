package newDemoQaTest.demoInvoiceReviewPageTest;

import newDemoQaPages.BaseModal;
import newDemoQaPages.NewDemoLandingPage;
import newDemoQaPages.demoInvoiceReviewPage.InvoiceReviewPage;
import newDemoQaPages.demoInvoiceReviewPage.potentialSavingsCardModals.PotentialSavingsCardModalFirstLevel;
import newDemoQaPages.demoInvoiceReviewPage.potentialSavingsCardModals.PotentialSavingsCardModalFourthLevel;
import newDemoQaPages.demoInvoiceReviewPage.potentialSavingsCardModals.PotentialSavingsCardModalSecondLevel;
import newDemoQaPages.demoInvoiceReviewPage.potentialSavingsCardModals.PotentialSavingsCardModalThirdLevel;
import baseTest.NewDemoBaseTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;
import java.util.ArrayList;
import java.util.List;

public class PotentialSavingsCardModalTest extends NewDemoBaseTest{

    NewDemoLandingPage newDemoLandingPage;
    InvoiceReviewPage invoiceReviewPage;
    PotentialSavingsCardModalFirstLevel potentialSavingsCardModalFirstLevel;
    PotentialSavingsCardModalSecondLevel potentialSavingsCardModalSecondLevel;
    PotentialSavingsCardModalThirdLevel potentialSavingsCardModalThirdLevel;
    PotentialSavingsCardModalFourthLevel potentialSavingsCardModalFourthLevel;
    BaseModal baseModal;

    @Test(testName = "IR-PS 1Lvl Table Test")
    public void invoiceReviewPotentialSavingsCardFirstLevelModalTest(){
        int headerColumnCount;
        ArrayList<Float> values;
        boolean sorted;
        newDemoLandingPage = new NewDemoLandingPage();
        invoiceReviewPage = new InvoiceReviewPage();
        potentialSavingsCardModalFirstLevel = new PotentialSavingsCardModalFirstLevel();
        baseModal = new BaseModal();

        newDemoQALoginPage.launchUrl(this.url);
        newDemoQALoginPage.setEmailAddressNewDemo(this.email);
        newDemoQALoginPage.setPassword(this.password);
        newDemoQALoginPage.signInClick();
        newDemoLandingPage.clickOnInvoiceReviewTile();
        invoiceReviewPage.clickPotentialSavingsCard();
        //TC-1
        potentialSavingsCardModalFirstLevel.paginationClick(2);
        potentialSavingsCardModalFirstLevel.pageSerialNoValidator(2);
        //TC-3
        headerColumnCount = potentialSavingsCardModalFirstLevel.headerClick("Refund Amount");
        values = potentialSavingsCardModalFirstLevel.columnData(headerColumnCount);
        sorted = baseModal.sortingValidation(values);
        Assert.assertTrue(sorted,"|Refund Amount| Column values not sorted.");
    }

    @Test(testName = "IR-PS 1Lvl Show Entries Test")
    public void invoiceReviewPotentialSavingsCardShowEntriesTest() {
        int serialNo;
        boolean correct;
        newDemoLandingPage = new NewDemoLandingPage();
        invoiceReviewPage = new InvoiceReviewPage();
        potentialSavingsCardModalFirstLevel = new PotentialSavingsCardModalFirstLevel();
        baseModal = new BaseModal();

        newDemoQALoginPage.launchUrl(this.url);
        newDemoQALoginPage.setEmailAddressNewDemo(this.email);
        newDemoQALoginPage.setPassword(this.password);
        newDemoQALoginPage.signInClick();
        newDemoLandingPage.clickOnInvoiceReviewTile();
        invoiceReviewPage.clickPotentialSavingsCard();
        //TC-1 - Show entries dropdown test
        serialNo= potentialSavingsCardModalFirstLevel.anyDropdownIterator(potentialSavingsCardModalFirstLevel.getShowEntriesDropdown()
                ,potentialSavingsCardModalFirstLevel.getShowEntriesDropdownElements());
        correct = potentialSavingsCardModalFirstLevel.showEntriesSerialNoValidator(serialNo);
        Assert.assertTrue(correct);
    }

    @Test(testName = "IR-PS 2Lvl Table Test")
    public void invoiceReviewPotentialCreditsRefundsModalSecondLevelTest(){
        newDemoLandingPage = new NewDemoLandingPage();
        invoiceReviewPage = new InvoiceReviewPage();
        potentialSavingsCardModalFirstLevel = new PotentialSavingsCardModalFirstLevel();
        potentialSavingsCardModalSecondLevel = new PotentialSavingsCardModalSecondLevel();
        baseModal = new BaseModal();

        newDemoQALoginPage.launchUrl(this.url);
        newDemoQALoginPage.setEmailAddressNewDemo(this.email);
        newDemoQALoginPage.setPassword(this.password);
        newDemoQALoginPage.signInClick();
        newDemoLandingPage.clickOnInvoiceReviewTile();
        invoiceReviewPage.clickPotentialSavingsCard();

        potentialSavingsCardModalFirstLevel.performanceReportingBtnClick();
        potentialSavingsCardModalSecondLevel.carrierSelectorValidator();
    }

    @Test(testName = "IR-PS 3Lvl Table Test")
    public void invoiceReviewPotentialSavingsCardModalThirdLevelTest(){
        int headerColumnCount;
        List<Float> numbers;
        newDemoLandingPage = new NewDemoLandingPage();
        invoiceReviewPage = new InvoiceReviewPage();
        potentialSavingsCardModalFirstLevel = new PotentialSavingsCardModalFirstLevel();
        potentialSavingsCardModalSecondLevel = new PotentialSavingsCardModalSecondLevel();
        potentialSavingsCardModalThirdLevel = new PotentialSavingsCardModalThirdLevel();
        baseModal = new BaseModal();

        newDemoQALoginPage.launchUrl(this.url);
        newDemoQALoginPage.setEmailAddressNewDemo(this.email);
        newDemoQALoginPage.setPassword(this.password);
        newDemoQALoginPage.signInClick();
        newDemoLandingPage.clickOnInvoiceReviewTile();
        invoiceReviewPage.clickPotentialSavingsCard();
        potentialSavingsCardModalFirstLevel.performanceReportingBtnClick();
        potentialSavingsCardModalSecondLevel.serviceSummaryBtnClick();
        headerColumnCount = potentialSavingsCardModalThirdLevel.headerClick("Total Packages");
        numbers = potentialSavingsCardModalThirdLevel.columnData(headerColumnCount);
        float actual = potentialSavingsCardModalThirdLevel.calculateSum(numbers);
        Assert.assertEquals(actual,potentialSavingsCardModalThirdLevel.getServiceSummaryTotalCount(),"|Total" +
                " Packages| total row count not matching.");
    }

    @Test(testName = "IR-PS 3Lvl Table Test")
    public void invoiceReviewPotentialSavingsCardModalTableThirdLevelTest() {
        int headerColumnCount;
        List<Float> numbers;
        newDemoLandingPage = new NewDemoLandingPage();
        invoiceReviewPage = new InvoiceReviewPage();
        potentialSavingsCardModalFirstLevel = new PotentialSavingsCardModalFirstLevel();
        potentialSavingsCardModalSecondLevel = new PotentialSavingsCardModalSecondLevel();
        potentialSavingsCardModalThirdLevel = new PotentialSavingsCardModalThirdLevel();
        baseModal = new BaseModal();

        newDemoQALoginPage.launchUrl(this.url);
        newDemoQALoginPage.setEmailAddressNewDemo(this.email);
        newDemoQALoginPage.setPassword(this.password);
        newDemoQALoginPage.signInClick();
        newDemoLandingPage.clickOnInvoiceReviewTile();
        invoiceReviewPage.clickPotentialSavingsCard();
        potentialSavingsCardModalFirstLevel.performanceReportingBtnClick();
        potentialSavingsCardModalSecondLevel.serviceSummaryBtnClick();
        headerColumnCount = potentialSavingsCardModalThirdLevel.headerClick("Service Type");
        List<WebElement> elements = potentialSavingsCardModalThirdLevel.columnDataWebElements(headerColumnCount);
        potentialSavingsCardModalThirdLevel.anyColumnValueClick(elements);
    }

    @Test(testName = "IR-PS 4Lvl Table Test")
    public void invoiceReviewPotentialSavingsCardFourthLevelTest() {
        int headerColumnCount, pageNo;
        List<Float> numbers;
        boolean sorted;

        newDemoLandingPage = new NewDemoLandingPage();
        invoiceReviewPage = new InvoiceReviewPage();
        potentialSavingsCardModalFirstLevel = new PotentialSavingsCardModalFirstLevel();
        potentialSavingsCardModalSecondLevel = new PotentialSavingsCardModalSecondLevel();
        potentialSavingsCardModalThirdLevel = new PotentialSavingsCardModalThirdLevel();
        potentialSavingsCardModalFourthLevel = new PotentialSavingsCardModalFourthLevel();
        baseModal = new BaseModal();

        newDemoQALoginPage.launchUrl(this.url);
        newDemoQALoginPage.setEmailAddressNewDemo(this.email);
        newDemoQALoginPage.setPassword(this.password);
        newDemoQALoginPage.signInClick();
        newDemoLandingPage.clickOnInvoiceReviewTile();
        invoiceReviewPage.clickPotentialSavingsCard();
        potentialSavingsCardModalFirstLevel.performanceReportingBtnClick();
        potentialSavingsCardModalSecondLevel.serviceSummaryBtnClick();
        //TC-1
        headerColumnCount = potentialSavingsCardModalThirdLevel.headerClick("Service Type");
        List<WebElement> elements = potentialSavingsCardModalThirdLevel.columnDataWebElements(headerColumnCount);
        potentialSavingsCardModalThirdLevel.anyColumnValueClick(elements);
        //TC-2
        pageNo=potentialSavingsCardModalFourthLevel.paginationClick(2);
        System.out.println("pageNo - "+pageNo);
        potentialSavingsCardModalFourthLevel.pageSerialNoValidator(pageNo);
        //TC-3
        potentialSavingsCardModalFourthLevel.anyDropdownIterator(potentialSavingsCardModalFourthLevel.getShowEntriesDropdown(),
                potentialSavingsCardModalFourthLevel.getShowEntriesDropdownElements(),1);
        potentialSavingsCardModalFourthLevel.showEntriesSerialNoValidator(1);
        //TC-4
        headerColumnCount = potentialSavingsCardModalFourthLevel.headerClick("Net Amount");
        numbers = potentialSavingsCardModalFourthLevel.columnData(headerColumnCount);
        sorted  = potentialSavingsCardModalFourthLevel.sortingValidation(numbers);
        Assert.assertTrue(sorted,"|Net Amount| Column values not sorted.");
    }

}
