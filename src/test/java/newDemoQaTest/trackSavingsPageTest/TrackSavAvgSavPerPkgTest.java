package newDemoQaTest.trackSavingsPageTest;

import basePages.NewDemoBasePage;
import newDemoQaPages.BaseModal;
import newDemoQaPages.NewDemoLandingPage;
import newDemoQaPages.switchToCompanyView.SwitchToCompanyViewModal;
import newDemoQaPages.trackSavingsPage.AvgSavPkgInTrackSavFirstLevel;
import newDemoQaPages.trackSavingsPage.AvgSavPkgInTrackSavSecondLevel;
import newDemoQaPages.trackSavingsPage.TrackSavingsPage;
import baseTest.NewDemoBaseTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class TrackSavAvgSavPerPkgTest extends NewDemoBaseTest {

    SwitchToCompanyViewModal switchToCompanyViewModal;
    NewDemoBasePage newDemoBasePage;
    TrackSavingsPage trackSavingsPage;
    NewDemoLandingPage newDemoLandingPage;
    AvgSavPkgInTrackSavFirstLevel avgSavPkgInTrackSavFirstLevel;
    AvgSavPkgInTrackSavSecondLevel avgSavPkgInTrackSavSecondLevel;
    BaseModal baseModal;


    @Test(testName = "TS AvgSavPerPkg FirstLevelModal Test")
    public void trackSavingsAvgSavPerPkgFirstLevelTest(){
        int headerColumnCount;
        List<Float> numbers;
        switchToCompanyViewModal = new SwitchToCompanyViewModal();
        newDemoBasePage = new NewDemoBasePage();
        trackSavingsPage = new TrackSavingsPage();
        newDemoLandingPage = new NewDemoLandingPage();
        avgSavPkgInTrackSavFirstLevel = new AvgSavPkgInTrackSavFirstLevel();

        newDemoQALoginPage.launchUrl(this.url);
        newDemoQALoginPage.setEmailAddressNewDemo(this.email);
        newDemoQALoginPage.setPassword(this.password);
        newDemoQALoginPage.signInClick();
        newDemoBasePage.profileDropdownBtnClick();
        newDemoBasePage.switchCompanyViewBtnClick();
        switchToCompanyViewModal.searchTextBoxValue("Activ Post");
        newDemoLandingPage.clickOnTrackSavingsTab();
        trackSavingsPage.avgSavingsPerPkgBtnClick();
        headerColumnCount = avgSavPkgInTrackSavFirstLevel.headerClick("Count");
        numbers = avgSavPkgInTrackSavFirstLevel.columnData(headerColumnCount);
        float actual = avgSavPkgInTrackSavFirstLevel.calculateSum(numbers);
        System.out.println(actual+" - actual");
        Assert.assertEquals(actual,avgSavPkgInTrackSavFirstLevel.getAvgSavFirstModalTotalRowCount());
    }

    @Test(testName = "TS AvgSavPerPkg SecondLevelModal Test")
    public void trackSavingsAvgSavPerPkgSecondLevelTest() {
        int columnCount, pageClickedNo;
        ArrayList<Float> values;
        boolean sorted, validator;
        switchToCompanyViewModal = new SwitchToCompanyViewModal();
        newDemoBasePage = new NewDemoBasePage();
        trackSavingsPage = new TrackSavingsPage();
        newDemoLandingPage = new NewDemoLandingPage();
        avgSavPkgInTrackSavFirstLevel = new AvgSavPkgInTrackSavFirstLevel();
        avgSavPkgInTrackSavSecondLevel = new AvgSavPkgInTrackSavSecondLevel();
        baseModal = new BaseModal();;

        newDemoQALoginPage.launchUrl(this.url);
        newDemoQALoginPage.setEmailAddressNewDemo(this.email);
        newDemoQALoginPage.setPassword(this.password);
        newDemoQALoginPage.signInClick();
        newDemoBasePage.profileDropdownBtnClick();
        newDemoBasePage.switchCompanyViewBtnClick();
        switchToCompanyViewModal.searchTextBoxValue("Activ Post");
        newDemoLandingPage.clickOnTrackSavingsTab();
        trackSavingsPage.avgSavingsPerPkgBtnClick();
        columnCount = avgSavPkgInTrackSavFirstLevel.headerClick("Service Name");
        List<WebElement> elements = avgSavPkgInTrackSavFirstLevel.columnDataWebElements(columnCount);
        baseModal.anyColumnValueClick(elements);
        pageClickedNo = baseModal.paginationClick(2);
        validator = avgSavPkgInTrackSavFirstLevel.pageSerialNoValidator(pageClickedNo);
        softAssert.assertTrue(validator);
        columnCount = avgSavPkgInTrackSavSecondLevel.headerClick("Prior Invoiced Amount");
        values = avgSavPkgInTrackSavSecondLevel.columnData(columnCount);
        sorted =  baseModal.sortingValidation(values);
        softAssert.assertTrue(sorted);
        softAssert.assertAll();
    }
}
