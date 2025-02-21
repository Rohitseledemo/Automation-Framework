package newDemoQaTest.demoPriorAgreementComparisonPageTest;
import newDemoQaPages.NewDemoLandingPage;
import newDemoQaPages.demoPriorAgreementComparisonPage.NicknameAccountsModal;
import newDemoQaPages.demoPriorAgreementComparisonPage.PriorAgreementComparisonPage;
import newDemoQaPages.demoPriorAgreementComparisonPage.totalSavings.SurchargeSavingsModalFirstLevel;
import newDemoQaPages.demoPriorAgreementComparisonPage.totalSavings.SurchargeSavingsModalSecondLevel;
import baseTest.NewDemoBaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NicknameAccountModalTest extends NewDemoBaseTest {

    NewDemoLandingPage newDemoLandingPage;
    NicknameAccountsModal nicknameAccountsModal;
    PriorAgreementComparisonPage priorAgreementComparison;
    SurchargeSavingsModalFirstLevel surchargeSavingsModalFirstLevel;
    SurchargeSavingsModalSecondLevel surchargeSavingsModalSecondLevel;

    @Test(testName = "PAC-NicknameModal Title Validation")
    public void nicknameModalTitleValidation() {
        String modalTitleActual;
        boolean isClosed;
        newDemoLandingPage = new NewDemoLandingPage();
        priorAgreementComparison = new PriorAgreementComparisonPage();
        nicknameAccountsModal = new NicknameAccountsModal();

        newDemoQALoginPage.launchUrl(this.url);
        newDemoQALoginPage.setEmailAddressNewDemo(this.email);
        newDemoQALoginPage.setPassword(this.password);
        newDemoQALoginPage.signInClick();
        newDemoLandingPage.clickOnPriorAgreementComparisonTile();
        priorAgreementComparison.nicknameAccountsBtnClick();
        modalTitleActual = nicknameAccountsModal.modalTitleValidation();
        softAssert.assertEquals(modalTitleActual, "Nickname Accounts");
        isClosed = nicknameAccountsModal.closeModal();
        softAssert.assertTrue(isClosed,"Modal Not Closed.");
        softAssert.assertAll();
    }

    @Test(testName = "PAC-NicknameModal AccountsTable Validation")
    public void nicknameAccountsTableValidation() {
        boolean isClicked;
        newDemoLandingPage = new NewDemoLandingPage();
        priorAgreementComparison = new PriorAgreementComparisonPage();
        nicknameAccountsModal = new NicknameAccountsModal();

        newDemoQALoginPage.launchUrl(this.url);
        newDemoQALoginPage.setEmailAddressNewDemo(this.email);
        newDemoQALoginPage.setPassword(this.password);
        newDemoQALoginPage.signInClick();
        newDemoLandingPage.clickOnPriorAgreementComparisonTile();
        priorAgreementComparison.nicknameAccountsBtnClick();
        nicknameAccountsModal.addNicknameValue();
        isClicked = nicknameAccountsModal.submitBtnClick();
        Assert.assertTrue(isClicked);
    }

    @Test(testName = "PAC-NicknameModal AccountsChanges Validation")
    public void nicknameAccountsChangesValidation() {
        boolean result;
        newDemoLandingPage = new NewDemoLandingPage();
        priorAgreementComparison = new PriorAgreementComparisonPage();
        surchargeSavingsModalFirstLevel = new SurchargeSavingsModalFirstLevel();
        surchargeSavingsModalSecondLevel = new SurchargeSavingsModalSecondLevel();
        nicknameAccountsModal = new NicknameAccountsModal();

        newDemoQALoginPage.launchUrl(this.url);
        newDemoQALoginPage.setEmailAddressNewDemo(this.email);
        newDemoQALoginPage.setPassword(this.password);
        newDemoQALoginPage.signInClick();
        newDemoLandingPage.clickOnPriorAgreementComparisonTile();
        priorAgreementComparison.nicknameAccountsBtnClick();
        String str = nicknameAccountsModal.addNicknameValue();
        nicknameAccountsModal.submitBtnClick();
        nicknameAccountsModal.closeModal();
        priorAgreementComparison.surchargeSavingsClick();
        surchargeSavingsModalFirstLevel.anySurchargeTypeClick("FUEL SURCHARGE");
        //TC-1
        nicknameAccountsModal.nicknameDropdownInSurchargeSavingsClick();
        By nicknameAccountsDropdownElements = nicknameAccountsModal.getNicknameDropdownElements();
        result = nicknameAccountsModal.stringValueSearch(str, nicknameAccountsDropdownElements);
        Assert.assertTrue(result);
    }
}