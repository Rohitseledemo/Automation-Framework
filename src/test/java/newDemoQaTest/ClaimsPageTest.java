package newDemoQaTest;

import newDemoQaPages.BaseModal;
import newDemoQaPages.NewDemoLandingPage;
import newDemoQaPages.NewDemoQALoginPage;
import newDemoQaPages.ClaimsPage;
import org.testng.Assert;
import org.testng.annotations.*;
import java.util.List;

public class ClaimsPageTest extends NewDemoBaseTest {

    NewDemoLandingPage newDemoLandingPage;
    ClaimsPage claimsPage;
    BaseModal baseModal;

    @Test
    public void claimsPageViewAllTransactionTest(){
        int headerColumn, pageNo;
        List<Float> values;
        boolean validate;
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
        Assert.assertTrue(validate);
        //TC-2
        headerColumn = claimsPage.headerClick("Amount Paid");
        values = claimsPage.columnData(headerColumn);
        claimsPage.sortingValidation(values);
    }

    @Test
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

    @Test
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
    @Test
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

    @Test(dataProvider = "getDateIndex")
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
        Assert.assertTrue(displayed);
        Assert.assertTrue(notEmpty);
        Assert.assertTrue(result);
        Assert.assertTrue(isEmpty);
        Assert.assertTrue(isDisplayed);
    }

    @DataProvider
    public Object[] getDateIndex(){
        return new Object[] {0,1,2};
    }
}
