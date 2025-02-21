package newDemoQaTest.demoPriorAgreementComparisonPageTest;

import basePages.NewDemoBasePage;
import newDemoQaPages.BaseModal;
import newDemoQaPages.NewDemoLandingPage;
import newDemoQaPages.demoPriorAgreementComparisonPage.AdvancedSearchModal;
import newDemoQaPages.demoPriorAgreementComparisonPage.PriorAgreementComparisonPage;
import baseTest.NewDemoBaseTest;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import java.util.List;

public class AdvancedSearchModalTest extends NewDemoBaseTest {

    PriorAgreementComparisonPage priorAgreementComparisonPage;
    NewDemoLandingPage newDemoLandingPage;
    BaseModal baseModal;
    AdvancedSearchModal advancedSearchModal;
    NewDemoBasePage newDemoBasePage;

    @Test(testName = "PAC-AdvancedSearch Modal Validation")
    public void advancedSearchModalValidation(){
        boolean isDisplayed;
        boolean result;
        int headerColumn;
        List<WebElement> elements;
        newDemoLandingPage = new NewDemoLandingPage();
        priorAgreementComparisonPage = new PriorAgreementComparisonPage();
        advancedSearchModal = new AdvancedSearchModal();
        newDemoBasePage = new NewDemoBasePage();
        baseModal= new BaseModal();

        newDemoQALoginPage.launchUrl(this.url);
        newDemoQALoginPage.setEmailAddressNewDemo(this.email);
        newDemoQALoginPage.setPassword(this.password);
        newDemoQALoginPage.signInClick();
        newDemoLandingPage.clickOnPriorAgreementComparisonTile();
        priorAgreementComparisonPage.advancedSearchBtnClick();
        isDisplayed = baseModal.isModalDisplayed(advancedSearchModal.getModalTitle());
        softAssert.assertTrue(isDisplayed,"Modal Title not Displayed or Modal Not Opened.");
        //TC-1
        newDemoBasePage.anyCheckboxDropdownRandomValues(advancedSearchModal.getServiceTypeDropDown(),advancedSearchModal.
                getServiceTypeDropDownElements());
        advancedSearchModal.searchBtnClick();
        //TC-2
        headerColumn = priorAgreementComparisonPage.headerClick("Service Type");
        elements = priorAgreementComparisonPage.columnDataWebElements(headerColumn);
        result = newDemoBasePage.dropdownAndColumnDataValidation(newDemoBasePage.getValueClickedNames(),elements
                ,false);
        softAssert.assertTrue(result);
        softAssert.assertAll();
    }

}
