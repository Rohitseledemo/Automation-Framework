package newDemoQaTest.demoPriorAgreementComparisonPageTest;

import baseClass.NewDemoBasePage;
import newDemoQaPages.BaseModal;
import newDemoQaPages.NewDemoLandingPage;
import newDemoQaPages.NewDemoQALoginPage;
import newDemoQaPages.demoPriorAgreementComparisonPage.PackageProfileModal;
import newDemoQaPages.demoPriorAgreementComparisonPage.PriorAgreementComparisonPage;
import newDemoQaTest.NewDemoBaseTest;
import org.testng.Assert;
import org.testng.annotations.*;

public class PackageProfileModalTest extends NewDemoBaseTest {

    PriorAgreementComparisonPage priorAgreementComparisonPage;
    NewDemoLandingPage newDemoLandingPage;
    BaseModal baseModal;
    PackageProfileModal packageProfileModal;
    NewDemoBasePage newDemoBasePage;

    @Test
    public void packageProfileModalAllTabsTest() {
        boolean result;
        boolean isDisplayed;
        newDemoLandingPage = new NewDemoLandingPage();
        priorAgreementComparisonPage = new PriorAgreementComparisonPage();
        newDemoBasePage = new NewDemoBasePage();
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
        Assert.assertTrue(isDisplayed);
        //TC-2
        // 2 iterations because 2 carrier service dropdown values are there
        result = packageProfileModal.validateAllTabsForDropdown(packageProfileModal.getCarrierServiceDropdown(),
                packageProfileModal.getCarrierServiceDropdownElements(),2);
        Assert.assertTrue(result);

    }

}
