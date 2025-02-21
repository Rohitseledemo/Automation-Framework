package newDemoQaTest.demoInvoiceReviewPageTest;
import newDemoQaPages.BaseModal;
import newDemoQaPages.NewDemoLandingPage;
import newDemoQaPages.NewDemoQALoginPage;
import newDemoQaPages.demoInvoiceReviewPage.InvoiceReviewPage;
import baseTest.NewDemoBaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;

public class InvoiceReviewPageTest extends NewDemoBaseTest{

    NewDemoLandingPage newDemoLandingPage;
    InvoiceReviewPage invoiceReviewPage;
    BaseModal baseModal;

    @Test(testName = "IR - View Details Test")
    public void invoiceReviewViewDetailsBtnTest(){
        int headerColumn, pageNo;
        List<Float> values;
        boolean validate,isSorted;
        newDemoQALoginPage = new NewDemoQALoginPage();
        newDemoLandingPage = new NewDemoLandingPage();
        invoiceReviewPage = new InvoiceReviewPage();
        baseModal = new BaseModal();

        newDemoQALoginPage.launchUrl(this.url);
        newDemoQALoginPage.setEmailAddressNewDemo(this.email);
        newDemoQALoginPage.setPassword(this.password);
        newDemoQALoginPage.signInClick();
        newDemoLandingPage.clickOnInvoiceReviewTile();
        invoiceReviewPage.viewDetailsBtnClick();
        //TC-1
        pageNo=invoiceReviewPage.paginationClick(2);
        validate = invoiceReviewPage.pageSerialNoValidator(pageNo);
        Assert.assertTrue(validate,"Serial Number Not Correct According To Pagination.");
        //TC-2
        headerColumn = invoiceReviewPage.headerClick("Actual Weight");
        values = invoiceReviewPage.columnData(headerColumn);
        isSorted = invoiceReviewPage.sortingValidation(values);
        Assert.assertTrue(isSorted,"|Actual Weight| Column Values not Sorted.");
    }

    @Test(testName = "IR - View Details ShowEntries Test")
    public void invoiceReviewViewDetailsShowEntriesTest(){
        int serialNo;
        boolean correct;
        newDemoQALoginPage = new NewDemoQALoginPage();
        newDemoLandingPage = new NewDemoLandingPage();
        invoiceReviewPage = new InvoiceReviewPage();
        baseModal = new BaseModal();

        newDemoQALoginPage.launchUrl(this.url);
        newDemoQALoginPage.setEmailAddressNewDemo(this.email);
        newDemoQALoginPage.setPassword(this.password);
        newDemoQALoginPage.signInClick();
        newDemoLandingPage.clickOnInvoiceReviewTile();
        invoiceReviewPage.viewDetailsBtnClick();
        //TC-1 - show entries dropdown test
        serialNo= invoiceReviewPage.anyDropdownIterator(invoiceReviewPage.getShowEntriesDropdown()
                ,invoiceReviewPage.getShowEntriesDropdownElements());
        correct = invoiceReviewPage.showEntriesSerialNoValidator(serialNo);
        Assert.assertTrue(correct,"Show Entries Serial No. not correct.");
    }

    @Test(testName = "IR Date Dropdown Validation", dataProvider = "getDateIndex")
    public void dateDropdownValidatorInvoiceReviewPage(int[] dateIndex){
        boolean isTrue;
        newDemoQALoginPage = new NewDemoQALoginPage();
        newDemoLandingPage = new NewDemoLandingPage();
        invoiceReviewPage = new InvoiceReviewPage();
        baseModal = new BaseModal();

        newDemoQALoginPage.launchUrl(this.url);
        newDemoQALoginPage.setEmailAddressNewDemo(this.email);
        newDemoQALoginPage.setPassword(this.password);
        newDemoQALoginPage.signInClick();
        newDemoLandingPage.clickOnInvoiceReviewTile();
        By dropdown = invoiceReviewPage.getDateDropdown();
        By dropdownElements = invoiceReviewPage.getDateDropdownElements();
        isTrue = invoiceReviewPage.validateAllDropdownValues(dropdown, dropdownElements,dateIndex);
        Assert.assertTrue(isTrue,"Date Dropdown not working properly.");
    }

    //unit TC for account number dropdown
    @Test(testName = "IR Account Dropdown Validation",dataProvider = "getAccountIndex")
    public void accountDropdownIteratorInvoiceReviewPage(int[] accountIndex){
        boolean isTrue;
        newDemoQALoginPage = new NewDemoQALoginPage();
        newDemoLandingPage = new NewDemoLandingPage();
        invoiceReviewPage = new InvoiceReviewPage();
        baseModal = new BaseModal();

        newDemoQALoginPage.launchUrl(this.url);
        newDemoQALoginPage.setEmailAddressNewDemo(this.email);
        newDemoQALoginPage.setPassword(this.password);
        newDemoQALoginPage.signInClick();
        newDemoLandingPage.clickOnInvoiceReviewTile();
        By dropdown = invoiceReviewPage.getAccountDropdown();
        By dropdownElements = invoiceReviewPage.getAccountDropdownElements();
        isTrue=invoiceReviewPage.validateAllDropdownValues(dropdown, dropdownElements,accountIndex);
        Assert.assertTrue(isTrue,"Account Dropdown not working properly.");
    }

    //unit TC for account number dropdown
    @Test(testName = "IR Service Dropdown Validation",dataProvider = "serviceIndexIterator")
    public void carrierServiceDropdownInvoiceReviewPage(int[] serviceIndex){
        boolean isTrue;
        newDemoLandingPage = new NewDemoLandingPage();
        invoiceReviewPage = new InvoiceReviewPage();
        baseModal = new BaseModal();

        newDemoQALoginPage.launchUrl(this.url);
        newDemoQALoginPage.setEmailAddressNewDemo(this.email);
        newDemoQALoginPage.setPassword(this.password);
        newDemoQALoginPage.signInClick();
        newDemoLandingPage.clickOnInvoiceReviewTile();
        By dropdown = invoiceReviewPage.getServiceDropdown();
        By dropdownElements = invoiceReviewPage.getServiceDropdownElements();
        isTrue=invoiceReviewPage.validateAllDropdownValues(dropdown,dropdownElements,serviceIndex);
        Assert.assertTrue(isTrue,"Carrier Service Dropdown not working properly.");

    }

    @DataProvider(name = "getDateIndex", parallel = true)
    public Object[][] getDateIndex(){
        return new Object[][] { { new int[] {2,3,4,5,6}}};
    }
    @DataProvider(name = "getAccountIndex", parallel = true)
    public Object[][] getAccountIndex(){
        return new Object[][] {{ new int[] {1,2,3,4,5,6}}};
    }
    @DataProvider(name = "serviceIndexIterator", parallel = true)
    public Object[][] serviceIndexIterator(){
        return new Object[][] {
                { new int[] {0,1,2} }};
    }

}
