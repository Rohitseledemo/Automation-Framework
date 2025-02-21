package newDemoQaTest.demoRefundsPageTest;

import newDemoQaPages.BaseModal;
import newDemoQaPages.NewDemoLandingPage;
import newDemoQaPages.demoRefundsPage.carrierPerformance.CarrierPerformanceModal;
import newDemoQaPages.demoRefundsPage.RefundsPage;
import newDemoQaPages.demoRefundsPage.carrierPerformance.CarrierPerformanceReportDetailsModal;
import baseTest.NewDemoBaseTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;

public class CarrierPerformanceModalTest extends NewDemoBaseTest {

    NewDemoLandingPage newDemoLandingPage;
    CarrierPerformanceModal carrierPerformanceModal;
    CarrierPerformanceReportDetailsModal carrierPerformanceReportDetailsModal;
    RefundsPage refundsPage;
    BaseModal baseModal;

    @Test(testName = "RP-CPModal MapTable Test")
    public void carrierPerformanceModalFirstLevelTest() throws InterruptedException {
        boolean isClicked;
        newDemoLandingPage = new NewDemoLandingPage();
        refundsPage = new RefundsPage();
        carrierPerformanceModal = new CarrierPerformanceModal();
        baseModal = new BaseModal();

        newDemoQALoginPage.launchUrl(this.url);
        newDemoQALoginPage.setEmailAddressNewDemo(this.email);
        newDemoQALoginPage.setPassword(this.password);
        newDemoQALoginPage.signInClick();
        newDemoLandingPage.clickOnRefundsTile();
        //TC-1
        refundsPage.carrierPerformanceTabClick();
        //TC-2
        carrierPerformanceModal.carrierSelectorValidator();
        //TC-3
        isClicked=carrierPerformanceModal.mapTableClick();
        Assert.assertTrue(isClicked,"Carrier Performance Modal Map Table not Opened.");
    }
    @Test(testName = "RP-CP ReportDetailsModal Test")
    public void carrierPerformanceReportDetailsModalTest() throws InterruptedException {
        int headerColumnCount;
        List<Float> values;
        boolean isSorted,tableVisible;
        newDemoLandingPage = new NewDemoLandingPage();
        refundsPage = new RefundsPage();
        carrierPerformanceModal = new CarrierPerformanceModal();
        carrierPerformanceReportDetailsModal = new CarrierPerformanceReportDetailsModal();
        baseModal = new BaseModal();

        newDemoQALoginPage.launchUrl(this.url);
        newDemoQALoginPage.setEmailAddressNewDemo(this.email);
        newDemoQALoginPage.setPassword(this.password);
        newDemoQALoginPage.signInClick();
        newDemoLandingPage.clickOnRefundsTile();
        refundsPage.carrierPerformanceTabClick();
        tableVisible= carrierPerformanceModal.mapTableClick();
        softAssert.assertTrue(tableVisible,"Carrier Performance Modal Map Table not Opened.");
        headerColumnCount = carrierPerformanceReportDetailsModal.headerClick("Net Charge");
        values = carrierPerformanceReportDetailsModal.columnData(headerColumnCount);
        isSorted = carrierPerformanceReportDetailsModal.sortingValidation(values);
        softAssert.assertTrue(isSorted,"|Net Charge| column values not sorted.");
        softAssert.assertAll();
    }
    @Test(testName = "RP-CP ShowEntries Test")
    public void carrierPerformanceReportShowEntriesTesT() throws InterruptedException {
        int serialNo;
        boolean result;
        boolean isDisplayed;
        newDemoLandingPage = new NewDemoLandingPage();
        refundsPage = new RefundsPage();
        carrierPerformanceModal = new CarrierPerformanceModal();
        carrierPerformanceReportDetailsModal = new CarrierPerformanceReportDetailsModal();
        baseModal = new BaseModal();

        newDemoQALoginPage.launchUrl(this.url);
        newDemoQALoginPage.setEmailAddressNewDemo(this.email);
        newDemoQALoginPage.setPassword(this.password);
        newDemoQALoginPage.signInClick();
        newDemoLandingPage.clickOnRefundsTile();
        refundsPage.carrierPerformanceTabClick();
        carrierPerformanceModal.mapTableClick();
        serialNo = carrierPerformanceReportDetailsModal.anyDropdownIterator(carrierPerformanceReportDetailsModal.getShowEntriesDropdown(),
                carrierPerformanceReportDetailsModal.getShowEntriesDropdownElements());
        result = carrierPerformanceReportDetailsModal.showEntriesSerialNoValidator(serialNo);
        softAssert.assertTrue(result,"Show Entries serial number is not valid.");
        isDisplayed = carrierPerformanceReportDetailsModal.testDownloadButtonFunctionality();
        softAssert.assertTrue(isDisplayed,"Download Confirmation Toast Not Displayed.");
        softAssert.assertAll();
    }
    @Test(testName = "RP-CP TrackingId Test")
    public void carrierPerformanceReportTrackingIdTest() throws InterruptedException {
        int headerColumnCount;
        List<WebElement> values;
        newDemoLandingPage = new NewDemoLandingPage();
        refundsPage = new RefundsPage();
        carrierPerformanceModal = new CarrierPerformanceModal();
        carrierPerformanceReportDetailsModal = new CarrierPerformanceReportDetailsModal();
        baseModal = new BaseModal();

        newDemoQALoginPage.launchUrl(this.url);
        newDemoQALoginPage.setEmailAddressNewDemo(this.email);
        newDemoQALoginPage.setPassword(this.password);
        newDemoQALoginPage.signInClick();
        newDemoLandingPage.clickOnRefundsTile();
        refundsPage.carrierPerformanceTabClick();
        carrierPerformanceModal.mapTableClick();
        headerColumnCount = carrierPerformanceReportDetailsModal.headerClick("Tracking ID");
        values = carrierPerformanceReportDetailsModal.columnDataWebElements(headerColumnCount);
        carrierPerformanceReportDetailsModal.anyColumnValueClick(values);
        // this method needs to be expand for future validations on carrier website
        carrierPerformanceReportDetailsModal.validateWindowHandles();
    }
}
