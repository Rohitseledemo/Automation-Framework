package newDemoQaTest.demoInvoiceReviewPageTest;

import newDemoQaPages.BaseModal;
import newDemoQaPages.NewDemoLandingPage;
import newDemoQaPages.NewDemoQALoginPage;
import newDemoQaPages.demoInvoiceReviewPage.InvoiceReviewPage;
import newDemoQaPages.demoInvoiceReviewPage.avgCostPerPkgModals.AvgCostPerPkgModalFirstLevel;
import newDemoQaPages.demoInvoiceReviewPage.avgCostPerPkgModals.AvgCostPerPkgModalSecondLevel;
import baseTest.NewDemoBaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.List;

public class AvgCostPerPkgModalTest extends NewDemoBaseTest{

    NewDemoLandingPage newDemoLandingPage;
    InvoiceReviewPage invoiceReviewPage;
    AvgCostPerPkgModalFirstLevel avgCostPerPkgModalFirstLevel;
    AvgCostPerPkgModalSecondLevel avgCostPerPkgModalSecondLevel;
    BaseModal baseModal;

    @Test(testName = "Avg-Cost 1Lvl Modal Table Test ")
    public void avgCostPerPkgInvoiceReviewFirstLevelModalTest(){
        int headerColumnCount;
        List<Float> numbers;
        newDemoQALoginPage = new NewDemoQALoginPage();
        newDemoLandingPage = new NewDemoLandingPage();
        invoiceReviewPage = new InvoiceReviewPage();
        avgCostPerPkgModalFirstLevel = new AvgCostPerPkgModalFirstLevel();
        baseModal = new BaseModal();
        newDemoQALoginPage.launchUrl(this.url);
        newDemoQALoginPage.setEmailAddressNewDemo(this.email);
        newDemoQALoginPage.setPassword(this.password);
        newDemoQALoginPage.signInClick();
        newDemoLandingPage.clickOnInvoiceReviewTile();
        invoiceReviewPage.clickAvgCostPerPkgCard();
        headerColumnCount = avgCostPerPkgModalFirstLevel.headerClick("Count");
        numbers = avgCostPerPkgModalFirstLevel.columnData(headerColumnCount);
        float actual = baseModal.calculateSum(numbers);
        Assert.assertEquals(actual,avgCostPerPkgModalFirstLevel.getAvgSavFirstModalTotalRowCount());
    }

    @Test(testName = "Avg-Cost 2Lvl Modal Table Test ")
    public void avgCostPerPkgInvoiceReviewSecondLevelModalTest() {
        int columnCount, pageNo;
        ArrayList<Float> values;
        boolean sorted;

        newDemoQALoginPage = new NewDemoQALoginPage();
        newDemoLandingPage = new NewDemoLandingPage();
        invoiceReviewPage = new InvoiceReviewPage();
        avgCostPerPkgModalFirstLevel = new AvgCostPerPkgModalFirstLevel();
        avgCostPerPkgModalSecondLevel = new AvgCostPerPkgModalSecondLevel();
        baseModal = new BaseModal();

        newDemoQALoginPage.launchUrl(this.url);
        newDemoQALoginPage.setEmailAddressNewDemo(this.email);
        newDemoQALoginPage.setPassword(this.password);
        newDemoQALoginPage.signInClick();
        newDemoLandingPage.clickOnInvoiceReviewTile();
        invoiceReviewPage.clickAvgCostPerPkgCard();
        columnCount = avgCostPerPkgModalFirstLevel.headerClick("Service Name");
        System.out.println("ColumnCount - "+columnCount);

        List<WebElement> elements = avgCostPerPkgModalFirstLevel.columnDataWebElements(columnCount);
        System.out.println("elements - "+elements.size());
        avgCostPerPkgModalFirstLevel.anyColumnValueClick(elements);
        pageNo = baseModal.paginationClick(2);
        avgCostPerPkgModalFirstLevel.pageSerialNoValidator(pageNo);
        columnCount = avgCostPerPkgModalSecondLevel.headerClick("Current Invoiced Amount");
        values = avgCostPerPkgModalSecondLevel.columnData(columnCount);
        sorted =  baseModal.sortingValidation(values);
        Assert.assertTrue(sorted);
    }
    //commented bcz the dropdown is not added here yet
//    @Test(dataProvider = "getServiceIterator")
    public void carrierServiceDropdownIterator(int serviceIndex){
        newDemoQALoginPage = new NewDemoQALoginPage();
        newDemoLandingPage = new NewDemoLandingPage();
        avgCostPerPkgModalFirstLevel = new AvgCostPerPkgModalFirstLevel();
        invoiceReviewPage = new InvoiceReviewPage();
        baseModal = new BaseModal();

        newDemoQALoginPage.launchUrl(this.url);
        newDemoQALoginPage.setEmailAddressNewDemo(this.email);
        newDemoQALoginPage.setPassword(this.password);
        newDemoQALoginPage.signInClick();
        newDemoLandingPage.clickOnInvoiceReviewTile();
        invoiceReviewPage.clickAvgCostPerPkgCard();
        By carrierServiceDropdown = avgCostPerPkgModalFirstLevel.getCarrierServiceDropdown();
        By carrierServiceDropdownElements = avgCostPerPkgModalFirstLevel.getCarrierServiceDropdownElements();
        avgCostPerPkgModalFirstLevel.anyDropdownIterator(carrierServiceDropdown, carrierServiceDropdownElements,serviceIndex);
    }

    @DataProvider(name = "getServiceIterator", parallel = true)
    public Object[] getServiceIterator(){
        return new Object[] {0,1,2};
    }

}
