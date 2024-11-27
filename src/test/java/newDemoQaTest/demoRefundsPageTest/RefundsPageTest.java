package newDemoQaTest.demoRefundsPageTest;

import newDemoQaPages.BaseModal;
import newDemoQaPages.NewDemoLandingPage;
import newDemoQaPages.NewDemoQALoginPage;
import newDemoQaPages.demoPriorAgreementComparisonPage.PriorAgreementComparisonPage;
import newDemoQaPages.demoRefundsPage.RefundsPage;
import newDemoQaTest.NewDemoBaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;

public class RefundsPageTest extends NewDemoBaseTest {

    NewDemoLandingPage newDemoLandingPage;
    RefundsPage refundsPage;
    BaseModal baseModal;

    @Test
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
    @Test
    public void viewDetailsTableTest(){
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
        refundsPage.sortingValidation(values);
    }

    @Test
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
        Assert.assertTrue(result);
    }

    @Test
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
        isDisplayed = refundsPage.testDownloadButtonFunctionality();
        Assert.assertTrue(isDisplayed);
    }

    @Test
    public void refundsTabClickValidation(){
        newDemoLandingPage = new NewDemoLandingPage();
        refundsPage = new RefundsPage();
        baseModal = new BaseModal();

        newDemoQALoginPage.launchUrl(this.url);
        newDemoQALoginPage.setEmailAddressNewDemo(this.email);
        newDemoQALoginPage.setPassword(this.password);
        newDemoQALoginPage.signInClick();
        newDemoLandingPage.clickOnRefundsTile();
        refundsPage.statesTableValuesValidation();
    }

    @Test(dataProvider = "getIndex")
    public void carrierDropdownTest(int index){
        newDemoLandingPage = new NewDemoLandingPage();
        refundsPage = new RefundsPage();
        baseModal = new BaseModal();

        newDemoQALoginPage.launchUrl(this.url);
        newDemoQALoginPage.setEmailAddressNewDemo(this.email);
        newDemoQALoginPage.setPassword(this.password);
        newDemoQALoginPage.signInClick();
        newDemoLandingPage.clickOnRefundsTile();
        refundsPage.anyDropdownIterator(refundsPage.getCarrierServiceDropdown(),refundsPage.
                getCarrierServiceDropdownElements(),index);
    }

    @Test(dataProvider = "getAccountIndex")
    //unit TC for account number dropdown
    public void accountDropdownIterator(int accountIndex) {
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
        refundsPage.anyDropdownIterator(dropdown, dropdownElements,accountIndex);
    }

    @DataProvider
    public Object[][] getIndex(){
        return new Object[][] {{0},{1}};
    }

    @DataProvider
    public Object[] getAccountIndex(){
        return new Object[] {2,3,5,6,7};
    }

}
