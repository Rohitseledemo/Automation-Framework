package newDemoQaTest.demoPriorAgreementComparisonPageTest;

import newDemoQaPages.BaseModal;
import newDemoQaPages.NewDemoLandingPage;
import newDemoQaPages.demoPriorAgreementComparisonPage.PackageProfileModal;
import newDemoQaPages.demoPriorAgreementComparisonPage.PriorAgreementComparisonPage;
import baseTest.NewDemoBaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.*;

public class PackageProfileModalTest extends NewDemoBaseTest {

    PriorAgreementComparisonPage priorAgreementComparisonPage;
    NewDemoLandingPage newDemoLandingPage;
    BaseModal baseModal;
    PackageProfileModal packageProfileModal;

    @Test(testName="PAC-PkgProfile AllTabs Test")
    public void packageProfileModalAllTabsTest() {
        boolean result;
        boolean isDisplayed;
        newDemoLandingPage = new NewDemoLandingPage();
        priorAgreementComparisonPage = new PriorAgreementComparisonPage();
        packageProfileModal = new PackageProfileModal();
        baseModal= new BaseModal();

        newDemoQALoginPage.launchUrl(this.url);
        newDemoQALoginPage.setEmailAddressNewDemo(this.email);
        newDemoQALoginPage.setPassword(this.password);
        newDemoQALoginPage.signInClick();
        newDemoLandingPage.clickOnPriorAgreementComparisonTile();
        priorAgreementComparisonPage.packageProfileBtnClick();
        //TC-1
        isDisplayed = packageProfileModal.testDownloadButtonFunctionality();
        softAssert.assertTrue(isDisplayed,"Download Confirmation Toast Not Displayed.");
        //TC-2
        // 2 iterations because 2 carrier service dropdown values are there
        result = packageProfileModal.validateAllTabsForDropdown(packageProfileModal.getCarrierServiceDropdown(),
                packageProfileModal.getCarrierServiceDropdownElements(),2);
        softAssert.assertTrue(result,"All Tabs not Validated.");
        softAssert.assertAll();
    }

    @Test(testName="PAC-PkgProfile TimePeriodDropdown Test",dataProvider = "getMonthIterator")
    public void timePeriodDropdownIteratorPkgProfile(int monthIndex) {
        newDemoLandingPage = new NewDemoLandingPage();
        priorAgreementComparisonPage = new PriorAgreementComparisonPage();
        packageProfileModal = new PackageProfileModal();
        baseModal = new BaseModal();

        newDemoQALoginPage.launchUrl(this.url);
        newDemoQALoginPage.setEmailAddressNewDemo(this.email);
        newDemoQALoginPage.setPassword(this.password);
        newDemoQALoginPage.signInClick();
        newDemoLandingPage.clickOnPriorAgreementComparisonTile();
        priorAgreementComparisonPage.packageProfileBtnClick();
        By timePeriodDropdown = packageProfileModal.getTimePeriodDropdown();
        By timePeriodDropdownElements = packageProfileModal.getTimePeriodDropdownElements();
        packageProfileModal.anyDropdownIterator(timePeriodDropdown, timePeriodDropdownElements,monthIndex);
    }

    @DataProvider(name = "getMonthIterator", parallel = true)
    public Object[] getMonthIterator(){
        return new Object[] {1,2,3};
    }

}
