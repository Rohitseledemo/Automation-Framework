package newDemoQaTest.demoRefundsPageTest;

import newDemoQaPages.BaseModal;
import newDemoQaPages.NewDemoLandingPage;
import newDemoQaPages.NewDemoQALoginPage;
import newDemoQaPages.demoRefundsPage.RefundsPage;
import newDemoQaPages.demoRefundsPage.serviceSummaryModals.ServiceSummaryModal;
import newDemoQaPages.demoRefundsPage.serviceSummaryModals.ServiceSummarySecondLevelModal;
import newDemoQaTest.NewDemoBaseTest;
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

    @Test
    public void serviceSummaryModalTest(){
        int headerColumnCount;
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
        Assert.assertEquals(actual,serviceSummaryModal.getServiceSummaryTotalCount());
}

    @Test
    public void serviceSummaryModalSecondLevelTest(){
        int headerColumnCount, pageNo;
        List<Float> numbers;
        boolean sorted;

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
        serviceSummarySecondLevelModal.pageSerialNoValidator(pageNo);
        //TC-3
        serviceSummarySecondLevelModal.anyDropdownIterator(serviceSummarySecondLevelModal.getShowEntriesDropdown(),
                serviceSummarySecondLevelModal.getShowEntriesDropdownElements(),1);
        serviceSummarySecondLevelModal.showEntriesSerialNoValidator(1);
        //TC-4
        headerColumnCount = serviceSummarySecondLevelModal.headerClick("Net Amount");
        numbers = serviceSummarySecondLevelModal.columnData(headerColumnCount);
        sorted  = serviceSummarySecondLevelModal.sortingValidation(numbers);
        Assert.assertTrue(sorted);
    }
    @Test
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
        Assert.assertTrue(correctValues);
    }

}
