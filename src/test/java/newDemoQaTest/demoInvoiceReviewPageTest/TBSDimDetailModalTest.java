package newDemoQaTest.demoInvoiceReviewPageTest;

import newDemoQaPages.NewDemoLandingPage;
import newDemoQaPages.NewDemoQALoginPage;
import newDemoQaPages.demoInvoiceReviewPage.InvoiceReviewPage;
import newDemoQaPages.demoInvoiceReviewPage.topBoxSizesModals.TBSDimDetailModal;
import newDemoQaPages.demoInvoiceReviewPage.topBoxSizesModals.TopBoxSizesModalFirstLevel;
import newDemoQaTest.NewDemoBaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class TBSDimDetailModalTest extends NewDemoBaseTest {

    NewDemoLandingPage newDemoLandingPage;
    TBSDimDetailModal tbsDimDetailModal;
    TopBoxSizesModalFirstLevel topBoxSizesModalFirstLevel;
    InvoiceReviewPage invoiceReviewPage;

    @Test
    public void dimDetailModalTableTest() {
        int headerColumn;
        List<WebElement> columnValues;
        boolean result;
        newDemoQALoginPage = new NewDemoQALoginPage();
        newDemoLandingPage = new NewDemoLandingPage();
        invoiceReviewPage = new InvoiceReviewPage();
        topBoxSizesModalFirstLevel = new TopBoxSizesModalFirstLevel();
        tbsDimDetailModal = new TBSDimDetailModal();

        newDemoQALoginPage.launchUrl(this.url);
        newDemoQALoginPage.setEmailAddressNewDemo(this.email);
        newDemoQALoginPage.setPassword(this.password);
        newDemoQALoginPage.signInClick();
        newDemoLandingPage.clickOnInvoiceReviewTile();
        invoiceReviewPage.clickTopBoxSizesCard();
        topBoxSizesModalFirstLevel.dimDetailBtnClick();
        By serviceDropdown = tbsDimDetailModal.getServiceDropdown();
        By serviceDropdownElements = tbsDimDetailModal.getServiceDropdownElements();
        tbsDimDetailModal.anyCheckboxDropdownRandomValues(serviceDropdown,serviceDropdownElements);
        tbsDimDetailModal.getEmptyClickOperation();
        headerColumn= tbsDimDetailModal.headerClick("Service Type");
        columnValues= tbsDimDetailModal.columnDataWebElements(headerColumn);
        result = tbsDimDetailModal.dropdownAndColumnDataValidation(tbsDimDetailModal.getValueClickedNames(),columnValues
                ,true);
        Assert.assertTrue(result);
    }

    @Test
    public void dimDetailModalSortingValidation(){
        int headerColumn;
        List<Float> columnValues;
        boolean isDisplayed, isSorted;
        newDemoLandingPage = new NewDemoLandingPage();
        invoiceReviewPage = new InvoiceReviewPage();
        topBoxSizesModalFirstLevel = new TopBoxSizesModalFirstLevel();
        tbsDimDetailModal = new TBSDimDetailModal();

        newDemoQALoginPage.launchUrl(this.url);
        newDemoQALoginPage.setEmailAddressNewDemo(this.email);
        newDemoQALoginPage.setPassword(this.password);
        newDemoQALoginPage.signInClick();
        newDemoLandingPage.clickOnInvoiceReviewTile();
        invoiceReviewPage.clickTopBoxSizesCard();
        topBoxSizesModalFirstLevel.dimDetailBtnClick();
        headerColumn= tbsDimDetailModal.headerClick("Number of Packages Impacted by DIM Weight");
        columnValues = tbsDimDetailModal.columnData(headerColumn);
        isSorted= tbsDimDetailModal.sortingValidation(columnValues);
        Assert.assertTrue(isSorted);
        //TC-2
        isDisplayed=tbsDimDetailModal.testDownloadButtonFunctionality();
        Assert.assertTrue(isDisplayed);
    }
}