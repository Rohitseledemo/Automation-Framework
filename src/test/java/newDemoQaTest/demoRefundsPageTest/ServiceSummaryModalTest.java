package newDemoQaTest.demoRefundsPageTest;

import newDemoQaPages.BaseModal;
import newDemoQaPages.NewDemoLandingPage;
import newDemoQaPages.demoRefundsPage.RefundsPage;
import newDemoQaPages.demoRefundsPage.serviceSummaryModals.ServiceSummaryModal;
import newDemoQaPages.demoRefundsPage.serviceSummaryModals.ServiceSummarySecondLevelModal;
import baseTest.NewDemoBaseTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;
import java.util.List;

public class ServiceSummaryModalTest extends NewDemoBaseTest {

    NewDemoLandingPage newDemoLandingPage;
    ServiceSummaryModal serviceSummaryModal;
    ServiceSummarySecondLevelModal serviceSummarySecondLevelModal;

    RefundsPage refundsPage;
    BaseModal baseModal;

    @Test(testName = "RP-ServiceSummary Table Test")
    public void serviceSummaryModalTest(){
        int headerColumnCount;
        float expectedCount;
        List<Float> numbers;

        newDemoLandingPage = new NewDemoLandingPage();
        refundsPage = new RefundsPage();
        serviceSummaryModal = new ServiceSummaryModal();
        baseModal = new BaseModal();

        newDemoQALoginPage.launchUrl(this.url);
        newDemoQALoginPage.setEmailAddressNewDemo(this.email);
        newDemoQALoginPage.setPassword(this.password);
        newDemoQALoginPage.signInClick();
        newDemoLandingPage.clickOnRefundsTile();
        refundsPage.percentageLateTabClick();
        refundsPage.serviceSummaryBtnClick();
        headerColumnCount = serviceSummaryModal.headerClick("Total Packages");
        numbers = serviceSummaryModal.columnData(headerColumnCount);
        float actual = serviceSummaryModal.calculateSum(numbers);
        expectedCount = serviceSummaryModal.getServiceSummaryTotalCount();
        Assert.assertEquals(actual,expectedCount,"|Total Packages| Total row Count not correct.");
}

    @Test(testName = "RP-ServiceSummary 2LvlTable Test")
    public void serviceSummaryModalSecondLevelTest(){
        int headerColumnCount, pageNo;
        List<Float> numbers;
        boolean sorted, validator;

        newDemoLandingPage = new NewDemoLandingPage();
        refundsPage = new RefundsPage();
        serviceSummaryModal = new ServiceSummaryModal();
        serviceSummarySecondLevelModal = new ServiceSummarySecondLevelModal();
        baseModal = new BaseModal();

        newDemoQALoginPage.launchUrl(this.url);
        newDemoQALoginPage.setEmailAddressNewDemo(this.email);
        newDemoQALoginPage.setPassword(this.password);
        newDemoQALoginPage.signInClick();
        newDemoLandingPage.clickOnRefundsTile();
        refundsPage.percentageLateTabClick();
        refundsPage.serviceSummaryBtnClick();
        //TC-1
        headerColumnCount = serviceSummaryModal.headerClick("Service Type");
        List<WebElement> elements = serviceSummaryModal.columnDataWebElements(headerColumnCount);
        serviceSummaryModal.anyColumnValueClick(elements);
        //TC-2
        pageNo = serviceSummarySecondLevelModal.paginationClick(2);
        validator = serviceSummarySecondLevelModal.pageSerialNoValidator(pageNo);
        softAssert.assertTrue(validator,"Serial Number Not Correct According To Pagination.");
        //TC-3
        serviceSummarySecondLevelModal.anyDropdownIterator(serviceSummarySecondLevelModal.getShowEntriesDropdown(),
                serviceSummarySecondLevelModal.getShowEntriesDropdownElements(),1);
        serviceSummarySecondLevelModal.showEntriesSerialNoValidator(1);
        //TC-4
        headerColumnCount = serviceSummarySecondLevelModal.headerClick("Net Amount");
        numbers = serviceSummarySecondLevelModal.columnData(headerColumnCount);
        sorted  = serviceSummarySecondLevelModal.sortingValidation(numbers);
        softAssert.assertTrue(sorted,"|Net Amount| values not sorted.");
        softAssert.assertAll();
    }
    @Test(testName = "RP-ServiceSummary 2Lvl ShowEntries Test")
    public void serviceSummaryModalSecondLevelShowEntriesTest() {
        boolean correctValues;
        int headerColumnCount, serialNos;
        newDemoLandingPage = new NewDemoLandingPage();
        refundsPage = new RefundsPage();
        serviceSummaryModal = new ServiceSummaryModal();
        serviceSummarySecondLevelModal = new ServiceSummarySecondLevelModal();
        baseModal = new BaseModal();

        newDemoQALoginPage.launchUrl(this.url);
        newDemoQALoginPage.setEmailAddressNewDemo(this.email);
        newDemoQALoginPage.setPassword(this.password);
        newDemoQALoginPage.signInClick();
        newDemoLandingPage.clickOnRefundsTile();
        refundsPage.percentageLateTabClick();
        refundsPage.serviceSummaryBtnClick();
        //TC-1
        headerColumnCount = serviceSummaryModal.headerClick("Service Type");
        List<WebElement> elements = serviceSummaryModal.columnDataWebElements(headerColumnCount);
        serviceSummaryModal.anyColumnValueClick(elements);
        //TC-2
        serialNos= serviceSummarySecondLevelModal.anyDropdownIterator(serviceSummarySecondLevelModal.getShowEntriesDropdown(),
                serviceSummarySecondLevelModal.getShowEntriesDropdownElements());
        correctValues= serviceSummarySecondLevelModal.showEntriesSerialNoValidator(serialNos);
        Assert.assertTrue(correctValues,"Serial No.values not correct according to values selected from Show Entries dropdown.");
    }

}
