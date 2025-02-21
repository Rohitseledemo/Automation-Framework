package newDemoQaTest.demoRefundsPageTest;

import newDemoQaPages.BaseModal;
import newDemoQaPages.NewDemoLandingPage;
import newDemoQaPages.demoRefundsPage.RefundsPage;
import baseTest.NewDemoBaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;

public class RefundsPageTest extends NewDemoBaseTest {

    NewDemoLandingPage newDemoLandingPage;
    RefundsPage refundsPage;
    BaseModal baseModal;

    @Test(testName = "RP ViewDetails ShowEntries Test")
    public void viewDetailsShowEntriesTest(){
        newDemoLandingPage = new NewDemoLandingPage();
        refundsPage = new RefundsPage();
        baseModal = new BaseModal();

        newDemoQALoginPage.launchUrl(this.url);
        newDemoQALoginPage.setEmailAddressNewDemo(this.email);
        newDemoQALoginPage.setPassword(this.password);
        newDemoQALoginPage.signInClick();
        newDemoLandingPage.clickOnRefundsTile();
        refundsPage.viewDetailsBtnClick();
        //TC-1 - show entries dropdown test
        refundsPage.anyDropdownIterator(refundsPage.getShowEntriesDropdown()
                ,refundsPage.getShowEntriesDropdownElements());
    }
    @Test(testName = "RP ViewDetails Table Test")
    public void viewDetailsTableTest(){
        boolean isSorted;
        int headerColumn;
        List<Float> values;
        newDemoLandingPage = new NewDemoLandingPage();
        refundsPage = new RefundsPage();
        baseModal = new BaseModal();

        newDemoQALoginPage.launchUrl(this.url);
        newDemoQALoginPage.setEmailAddressNewDemo(this.email);
        newDemoQALoginPage.setPassword(this.password);
        newDemoQALoginPage.signInClick();
        newDemoLandingPage.clickOnRefundsTile();
        refundsPage.viewDetailsBtnClick();
        //TC-1
        headerColumn = refundsPage.headerClick("Net Charge");
        values = refundsPage.columnData(headerColumn);
        isSorted = refundsPage.sortingValidation(values);
        Assert.assertTrue(isSorted,"|Net Charge| Column values not Sorted.");
    }

    @Test(testName = "RP ViewDetails TableDropdown Test")
    public void viewDetailsTableDropdownsTest(){
        int headerColumn;
        List<WebElement> elements;
        boolean result;
        newDemoLandingPage = new NewDemoLandingPage();
        refundsPage = new RefundsPage();
        baseModal = new BaseModal();

        newDemoQALoginPage.launchUrl(this.url);
        newDemoQALoginPage.setEmailAddressNewDemo(this.email);
        newDemoQALoginPage.setPassword(this.password);
        newDemoQALoginPage.signInClick();
        newDemoLandingPage.clickOnRefundsTile();
        refundsPage.viewDetailsBtnClick();
        refundsPage.anyCheckboxDropdownRandomValues(refundsPage.getTableDropdown(),refundsPage.getTableDropdownElements());
        headerColumn = refundsPage.headerClick("Service Type");
        elements = refundsPage.columnDataWebElements(headerColumn);
        result = refundsPage.dropdownAndColumnDataValidation(refundsPage.getValueClickedNames(),elements,
                false);
        Assert.assertTrue(result,"|Service Type| dropdown has Unexpected Values.");
    }

    @Test(testName = "RP LateShipmentsReport Download Test")
    public void downloadLateShipmentsReportTest(){
        boolean isDisplayed;
        newDemoLandingPage = new NewDemoLandingPage();
        refundsPage = new RefundsPage();
        baseModal = new BaseModal();

        newDemoQALoginPage.launchUrl(this.url);
        newDemoQALoginPage.setEmailAddressNewDemo(this.email);
        newDemoQALoginPage.setPassword(this.password);
        newDemoQALoginPage.signInClick();
        newDemoLandingPage.clickOnRefundsTile();
        isDisplayed = refundsPage.testDownloadButtonFunctionality2();
        Assert.assertTrue(isDisplayed,"Download Invoice Toast is not Displayed.");
    }

    @Test(testName = "RP RefundsTabClick Validation")
    public void refundsTabClickValidation(){
        boolean flag;
        newDemoLandingPage = new NewDemoLandingPage();
        refundsPage = new RefundsPage();
        baseModal = new BaseModal();

        newDemoQALoginPage.launchUrl(this.url);
        newDemoQALoginPage.setEmailAddressNewDemo(this.email);
        newDemoQALoginPage.setPassword(this.password);
        newDemoQALoginPage.signInClick();
        newDemoLandingPage.clickOnRefundsTile();
        flag = refundsPage.statesTableValuesValidation();
        Assert.assertTrue(flag);
    }

    @Test(testName = "RP CarrierDropdown Test",dataProvider = "serviceIndexIterator")
    public void carrierDropdownTestRefundsPage(int[] serviceIndex){
        newDemoLandingPage = new NewDemoLandingPage();
        refundsPage = new RefundsPage();
        baseModal = new BaseModal();

        newDemoQALoginPage.launchUrl(this.url);
        newDemoQALoginPage.setEmailAddressNewDemo(this.email);
        newDemoQALoginPage.setPassword(this.password);
        newDemoQALoginPage.signInClick();
        newDemoLandingPage.clickOnRefundsTile();
        refundsPage.validateAllDropdownValues(refundsPage.getCarrierServiceDropdown(),refundsPage.
                getCarrierServiceDropdownElements(),serviceIndex);
    }

    @Test(testName = "RP AccountDropdown Test",dataProvider = "getAccountIndex")
    //unit TC for account number dropdown
    public void accountDropdownIteratorRefundsPage(int[] accountIndex) {
        boolean flag;
        newDemoLandingPage = new NewDemoLandingPage();
        refundsPage = new RefundsPage();
        baseModal = new BaseModal();

        newDemoQALoginPage.launchUrl(this.url);
        newDemoQALoginPage.setEmailAddressNewDemo(this.email);
        newDemoQALoginPage.setPassword(this.password);
        newDemoQALoginPage.signInClick();
        newDemoLandingPage.clickOnRefundsTile();
        By dropdown = refundsPage.getAccountDropdown();
        By dropdownElements = refundsPage.getAccountDropdownElements();
        flag = refundsPage.validateAllDropdownValues(dropdown, dropdownElements,accountIndex);
        Assert.assertTrue(flag);
    }

    @DataProvider(name = "serviceIndexIterator", parallel = true)
    public Object[][] serviceIndexIterator(){
        return new Object[][] {
                { new int[] {0,1,2} }};
    }

    @DataProvider(name = "getAccountIndex", parallel = true)
    public Object[] getAccountIndex(){
        return new Object[][] {{new int[] {2,3,4,5,6}}};
    }

}
