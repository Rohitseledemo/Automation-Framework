package newDemoQaTest.trackSavingsPageTest;

import baseClass.NewDemoBasePage;
import newDemoQaPages.BaseModal;
import newDemoQaPages.NewDemoLandingPage;
import newDemoQaPages.switchToCompanyView.SwitchToCompanyViewModal;
import newDemoQaPages.trackSavingsPage.AvgSavPkgInTrackSavFirstLevel;
import newDemoQaPages.trackSavingsPage.AvgSavPkgInTrackSavSecondLevel;
import newDemoQaPages.trackSavingsPage.TrackSavingsPage;
import newDemoQaTest.NewDemoBaseTest;
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


    @Test
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
        Assert.assertEquals(actual,avgSavPkgInTrackSavFirstLevel.getAvgSavFirstModalTotalRowCount());

    }

    @Test
    public void trackSavingsAvgSavPerPkgSecondLevelTest() {
        int columnCount, pageClickedNo;
        ArrayList<Float> values;
        boolean sorted;
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
        columnCount = avgSavPkgInTrackSavFirstLevel.headerClick("Service");
        List<WebElement> elements = avgSavPkgInTrackSavFirstLevel.columnDataWebElements(columnCount);
        baseModal.anyColumnValueClick(elements);
        pageClickedNo = baseModal.paginationClick(2);
        avgSavPkgInTrackSavFirstLevel.pageSerialNoValidator(pageClickedNo);
        columnCount = avgSavPkgInTrackSavSecondLevel.headerClick("Prior Invoiced Amount");
        values = avgSavPkgInTrackSavSecondLevel.columnData(columnCount);
        sorted =  baseModal.sortingValidation(values);
        Assert.assertTrue(sorted);
    }
}
