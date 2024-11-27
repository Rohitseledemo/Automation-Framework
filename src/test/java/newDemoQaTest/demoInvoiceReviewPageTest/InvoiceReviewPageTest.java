package newDemoQaTest.demoInvoiceReviewPageTest;

import baseClass.NewDemoBasePage;
import newDemoQaPages.BaseModal;
import newDemoQaPages.NewDemoLandingPage;
import newDemoQaPages.NewDemoQALoginPage;
import newDemoQaPages.demoInvoiceReviewPage.InvoiceReviewPage;
import newDemoQaTest.NewDemoBaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;

public class InvoiceReviewPageTest extends NewDemoBaseTest{

    NewDemoLandingPage newDemoLandingPage;
    InvoiceReviewPage invoiceReviewPage;
    BaseModal baseModal;

    @Test
    public void invoiceReviewViewDetailsBtnTest(){
        int headerColumn, pageNo;
        List<Float> values;
        boolean validate;
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
        Assert.assertTrue(validate);
        //TC-2
        headerColumn = invoiceReviewPage.headerClick("Actual Weight");
        values = invoiceReviewPage.columnData(headerColumn);
        invoiceReviewPage.sortingValidation(values);
    }

    @Test
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
        Assert.assertTrue(correct);
    }

    @Test(dataProvider = "getDateIndex")
    public void dateDropdownValidator(int dateIndex){
        newDemoQALoginPage = new NewDemoQALoginPage();
        newDemoLandingPage = new NewDemoLandingPage();
        invoiceReviewPage = new InvoiceReviewPage();
        baseModal = new BaseModal();

        newDemoQALoginPage.launchUrl(this.url);
        newDemoQALoginPage.setEmailAddressNewDemo(this.email);
        newDemoQALoginPage.setPassword(this.password);
        newDemoQALoginPage.signInClick();
        newDemoLandingPage.clickOnInvoiceReviewTile();
        invoiceReviewPage.anyDropdownIterator(invoiceReviewPage.getDateDropdown(),
                invoiceReviewPage.getDateDropdownElements(),dateIndex);
    }
    @Test(dataProvider = "getAccountIndex")
    //unit TC for account number dropdown
    public void accountDropdownIterator(int accountIndex){
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
        invoiceReviewPage.anyDropdownIterator(dropdown, dropdownElements,accountIndex);
    }

    @Test(dataProvider = "getServiceIndex")
    public void carrierServiceDropdownInvoiceReview(int serviceIndex){
        newDemoQALoginPage = new NewDemoQALoginPage();
        newDemoLandingPage = new NewDemoLandingPage();
        invoiceReviewPage = new InvoiceReviewPage();
        baseModal = new BaseModal();

        newDemoQALoginPage.launchUrl(this.url);
        newDemoQALoginPage.setEmailAddressNewDemo(this.email);
        newDemoQALoginPage.setPassword(this.password);
        newDemoQALoginPage.signInClick();
        newDemoLandingPage.clickOnInvoiceReviewTile();
        By serviceDropdown = invoiceReviewPage.getServiceDropdown();
        By serviceDropdownElements = invoiceReviewPage.getServiceDropdownElements();
        invoiceReviewPage.anyDropdownIterator(serviceDropdown, serviceDropdownElements,serviceIndex);
    }


    @DataProvider
    public Object[] getDateIndex(){
        return new Object[] {0,1,2};
    }
    @DataProvider
    public Object[] getServiceIndex(){
        return new Object[] {0,1,2};
    }
    @DataProvider
    public Object[] getAccountIndex(){
        return new Object[] {1};
    }

}
