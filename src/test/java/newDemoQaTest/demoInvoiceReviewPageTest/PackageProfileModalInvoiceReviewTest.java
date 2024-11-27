package newDemoQaTest.demoInvoiceReviewPageTest;

import baseClass.NewDemoBasePage;
import newDemoQaPages.BaseModal;
import newDemoQaPages.NewDemoLandingPage;
import newDemoQaPages.NewDemoQALoginPage;
import newDemoQaPages.demoInvoiceReviewPage.InvoiceReviewPage;
import newDemoQaPages.demoInvoiceReviewPage.PackageProfileModalInvoiceReview;
import newDemoQaTest.NewDemoBaseTest;
import org.testng.Assert;
import org.testng.annotations.*;

public class PackageProfileModalInvoiceReviewTest extends NewDemoBaseTest{

    NewDemoLandingPage newDemoLandingPage;
    InvoiceReviewPage invoiceReviewPage;
    PackageProfileModalInvoiceReview packageProfileModalInvoiceReview;
    NewDemoBasePage newDemoBasePage;
    BaseModal baseModal;

    @Test
    public void packageProfileModalInvoiceReviewAllTabsTest() {
        boolean result;
        boolean isDisplayed;
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
        isDisplayed = packageProfileModalInvoiceReview.testDownloadButtonFunctionality();
        Assert.assertTrue(isDisplayed);
        //TC-2
        // 2 iterations because 2 carrier service dropdown values are there
        result = packageProfileModalInvoiceReview.validateAllTabsForDropdown(packageProfileModalInvoiceReview.getCarrierServiceDropdown(),
                packageProfileModalInvoiceReview.getCarrierServiceDropdownElements(),2);
        Assert.assertTrue(result);

    }

}
