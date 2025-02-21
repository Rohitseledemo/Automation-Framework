package newDemoQaTest;

import baseTest.NewDemoBaseTest;
import newDemoQaPages.BaseModal;
import newDemoQaPages.NewDemoLandingPage;
import newDemoQaPages.ClaimsPage;
import org.testng.Assert;
import org.testng.annotations.*;
import java.util.List;

public class ClaimsPageTest extends NewDemoBaseTest {

    NewDemoLandingPage newDemoLandingPage;
    ClaimsPage claimsPage;
    BaseModal baseModal;

    @Test(testName = "Claims Page ViewAllTransactionTest")
    public void claimsPageViewAllTransactionTest(){
        int headerColumn, pageNo;
        List<Float> values;
        boolean validate, isSorted;
        newDemoLandingPage = new NewDemoLandingPage();
        claimsPage = new ClaimsPage();
        baseModal = new BaseModal();

        newDemoQALoginPage.launchUrl(this.url);
        newDemoQALoginPage.setEmailAddressNewDemo(this.email);
        newDemoQALoginPage.setPassword(this.password);
        newDemoQALoginPage.signInClick();
        newDemoLandingPage.clickOnClaimsTab();
        claimsPage.clickViewAllTransactionBtn();
        //TC-1
        pageNo = claimsPage.paginationClick(2);
        validate = claimsPage.pageSerialNoValidator(pageNo);
        softAssert.assertTrue(validate,"Serial Number Not Correct According To Pagination.");
        //TC-2
        headerColumn = claimsPage.headerClick("Amount Paid");
        values = claimsPage.columnData(headerColumn);
        isSorted = claimsPage.sortingValidation(values);
        softAssert.assertTrue(isSorted,"|Amount Paid| Column values not Sorted.");
        softAssert.assertAll();
    }

    @Test(testName = "Claims Page ViewAllTransaction ShowEntries Test")
    public void claimsPageViewAllTransactionShowEntriesTest() {
        int serialNo;
        boolean correct;
        newDemoLandingPage = new NewDemoLandingPage();
        claimsPage = new ClaimsPage();
        baseModal = new BaseModal();

        newDemoQALoginPage.launchUrl(this.url);
        newDemoQALoginPage.setEmailAddressNewDemo(this.email);
        newDemoQALoginPage.setPassword(this.password);
        newDemoQALoginPage.signInClick();
        newDemoLandingPage.clickOnClaimsTab();
        claimsPage.clickViewAllTransactionBtn();
        //TC-1 - show entries dropdown test
        serialNo= claimsPage.anyDropdownIterator(claimsPage.getShowEntriesDropdown()
                ,claimsPage.getShowEntriesDropdownElements());
        correct = claimsPage.showEntriesSerialNoValidator(serialNo);
        Assert.assertTrue(correct);
    }

    @Test(testName = "Claims Page ViewAllTransaction DownloadPdf Test")
    public void downloadPdfFunctionalityTest() {
        boolean isVisible;
        newDemoLandingPage = new NewDemoLandingPage();
        claimsPage = new ClaimsPage();
        baseModal = new BaseModal();

        newDemoQALoginPage.launchUrl(this.url);
        newDemoQALoginPage.setEmailAddressNewDemo(this.email);
        newDemoQALoginPage.setPassword(this.password);
        newDemoQALoginPage.signInClick();
        newDemoLandingPage.clickOnClaimsTab();
        isVisible = claimsPage.testDownloadPdfFunctionality();
        Assert.assertTrue(isVisible);
    }
    @Test(testName = "Claims Page ViewAllTransaction DownloadCsv Test")
    public void downloadCsvFunctionalityTest() {
        boolean isDisplayed;
        newDemoLandingPage = new NewDemoLandingPage();
        claimsPage = new ClaimsPage();
        baseModal = new BaseModal();

        newDemoQALoginPage.launchUrl(this.url);
        newDemoQALoginPage.setEmailAddressNewDemo(this.email);
        newDemoQALoginPage.setPassword(this.password);
        newDemoQALoginPage.signInClick();
        newDemoLandingPage.clickOnClaimsTab();
        isDisplayed = claimsPage.testDownloadButtonFunctionality2();
        Assert.assertTrue(isDisplayed);
    }

    @Test(testName = "Claims Page PaidValue Validation",dataProvider = "getDateIndex")
    public void claimsPaidValueValidation(int dateIndex){
        boolean result, notEmpty, isEmpty, isDisplayed, displayed;
        newDemoLandingPage = new NewDemoLandingPage();
        claimsPage = new ClaimsPage();
        baseModal = new BaseModal();

        newDemoQALoginPage.launchUrl(this.url);
        newDemoQALoginPage.setEmailAddressNewDemo(this.email);
        newDemoQALoginPage.setPassword(this.password);
        newDemoQALoginPage.signInClick();
        newDemoLandingPage.clickOnClaimsTab();
        claimsPage.anyDropdownIterator(claimsPage.getDateDropdown(),claimsPage.getDateDropdownElements()
                ,dateIndex);
        result = claimsPage.claimsPaidAmountNotEmpty();
        notEmpty = claimsPage.totalClaimsAmountNotEmpty();
        isEmpty = claimsPage.averagePaidAmountNotEmpty();
        isDisplayed = claimsPage.claimsPaidVsDeniedChartVisibility();
        displayed = claimsPage.claimsPaidGraphVisibility();
        softAssert.assertTrue(displayed,"Claims Paid Graph is Visible.");
        softAssert.assertTrue(notEmpty,"Total Claims Amount is Empty.");
        softAssert.assertTrue(result,"Claims Paid Amount is Empty.");
        softAssert.assertTrue(isEmpty,"Average Paid Amount is Empty.");
        softAssert.assertTrue(isDisplayed,"Claims Paid Vs Denied Chart is not Visible.");
        softAssert.assertAll();
    }

    @DataProvider(name = "getDateIndex", parallel = true)
    public Object[] getDateIndex(){
        return new Object[] {0,1,2};
    }
}
