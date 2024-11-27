package newDemoQaTest.demoPriorAgreementComparisonPageTest;
import newDemoQaPages.NewDemoLandingPage;
import newDemoQaPages.demoPriorAgreementComparisonPage.NicknameAccountsModal;
import newDemoQaPages.demoPriorAgreementComparisonPage.PriorAgreementComparisonPage;
import newDemoQaPages.demoPriorAgreementComparisonPage.totalSavings.SurchargeSavingsModalFirstLevel;
import newDemoQaPages.demoPriorAgreementComparisonPage.totalSavings.SurchargeSavingsModalSecondLevel;
import newDemoQaTest.NewDemoBaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NicknameAccountModalTest extends NewDemoBaseTest {

    NewDemoLandingPage newDemoLandingPage;
    NicknameAccountsModal nicknameAccountsModal;
    PriorAgreementComparisonPage priorAgreementComparison;
    SurchargeSavingsModalFirstLevel surchargeSavingsModalFirstLevel;
    SurchargeSavingsModalSecondLevel surchargeSavingsModalSecondLevel;

    @Test
    public void nicknameModalTitleValidation(){
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
        Assert.assertEquals(modalTitleActual,"Nickname Accounts");
        isClosed = nicknameAccountsModal.closeModal();
        Assert.assertTrue(isClosed);
    }

    @Test
    public void nicknameAccountsTableValidation(){
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
    @Test
    public void nicknameAccountsChangesValidation(){
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
