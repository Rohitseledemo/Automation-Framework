package newDemoQaTest.demoInvoiceReviewPageTest;

import basePages.NewDemoBasePage;
import newDemoQaPages.BaseModal;
import newDemoQaPages.NewDemoLandingPage;
import newDemoQaPages.NewDemoQALoginPage;
import newDemoQaPages.demoInvoiceReviewPage.InvoiceReviewPage;
import newDemoQaPages.demoInvoiceReviewPage.PackageProfileModalInvoiceReview;
import baseTest.NewDemoBaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;

public class PackageProfileModalInvoiceReviewTest extends NewDemoBaseTest{

    NewDemoLandingPage newDemoLandingPage;
    InvoiceReviewPage invoiceReviewPage;
    PackageProfileModalInvoiceReview packageProfileModalInvoiceReview;
    NewDemoBasePage newDemoBasePage;
    BaseModal baseModal;

    @Test(testName = "IR-PkgProfile AllTabs Test")
    public void packageProfileModalInvoiceReviewAllTabsTest() {
        boolean result;
        newDemoQALoginPage = new NewDemoQALoginPage();
        newDemoLandingPage = new NewDemoLandingPage();
        newDemoBasePage = new NewDemoBasePage();
        invoiceReviewPage = new InvoiceReviewPage();
        packageProfileModalInvoiceReview = new PackageProfileModalInvoiceReview();
        baseModal= new BaseModal();

        newDemoQALoginPage.launchUrl(this.url);
        newDemoQALoginPage.setEmailAddressNewDemo(this.email);
        newDemoQALoginPage.setPassword(this.password);
        newDemoQALoginPage.signInClick();
        newDemoLandingPage.clickOnInvoiceReviewTile();
        invoiceReviewPage.clickPackageProfileTab();
        //TC-1
        // 2 iterations because 2 carrier service dropdown values are there
        By carrierServiceDropdown = packageProfileModalInvoiceReview.getCarrierServiceDropdown();
        By carrierServiceDropdownElements = packageProfileModalInvoiceReview.getCarrierServiceDropdownElements();
        result = packageProfileModalInvoiceReview.validateAllTabsForDropdown(carrierServiceDropdown,carrierServiceDropdownElements,
                2);
        Assert.assertTrue(result);
    }
    @Test(testName = "IR-PkgProfile DownloadFunc Test")
    public void packageProfileModalInvoiceReviewDownloadFuncTest() {
        boolean result;
        boolean isDisplayed;
        newDemoQALoginPage = new NewDemoQALoginPage();
        newDemoLandingPage = new NewDemoLandingPage();
        newDemoBasePage = new NewDemoBasePage();
        invoiceReviewPage = new InvoiceReviewPage();
        packageProfileModalInvoiceReview = new PackageProfileModalInvoiceReview();
        baseModal = new BaseModal();


        newDemoQALoginPage.launchUrl(this.url);
        newDemoQALoginPage.setEmailAddressNewDemo(this.email);
        newDemoQALoginPage.setPassword(this.password);
        newDemoQALoginPage.signInClick();
        newDemoLandingPage.clickOnInvoiceReviewTile();
        invoiceReviewPage.clickPackageProfileTab();
        //TC-1
        isDisplayed = packageProfileModalInvoiceReview.testDownloadButtonFunctionality2();
        Assert.assertTrue(isDisplayed);
    }

    @Test(testName = "IR-PkgProfile Time-Period Dropdown Test",dataProvider = "getMonthIterator")
    public void timePeriodDropdownIteratorPkgProfileInvReview(int monthIndex) {
        newDemoLandingPage = new NewDemoLandingPage();
        baseModal = new BaseModal();
        invoiceReviewPage = new InvoiceReviewPage();
        packageProfileModalInvoiceReview = new PackageProfileModalInvoiceReview();

        newDemoQALoginPage.launchUrl(this.url);
        newDemoQALoginPage.setEmailAddressNewDemo(this.email);
        newDemoQALoginPage.setPassword(this.password);
        newDemoQALoginPage.signInClick();
        newDemoLandingPage.clickOnInvoiceReviewTile();
        invoiceReviewPage.clickPackageProfileTab();
        By timePeriodDropdown = packageProfileModalInvoiceReview.getTimePeriodDropdown();
        By timePeriodDropdownElements = packageProfileModalInvoiceReview.getTimePeriodDropdownElements();
        packageProfileModalInvoiceReview.anyDropdownIterator(timePeriodDropdown, timePeriodDropdownElements,monthIndex);
    }

    @DataProvider(name = "getMonthIterator", parallel = true)
    public Object[] getMonthIterator(){
        return new Object[] {1,2,3};
    }

}
