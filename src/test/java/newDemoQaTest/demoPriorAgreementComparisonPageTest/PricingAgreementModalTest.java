package newDemoQaTest.demoPriorAgreementComparisonPageTest;
import newDemoQaPages.NewDemoLandingPage;
import newDemoQaPages.demoPriorAgreementComparisonPage.PricingAgreementModal;
import newDemoQaPages.demoPriorAgreementComparisonPage.PriorAgreementComparisonPage;
import baseTest.NewDemoBaseTest;
import org.testng.Assert;
import org.testng.annotations.*;

public class PricingAgreementModalTest extends NewDemoBaseTest {

    PriorAgreementComparisonPage priorAgreementComparison;
    NewDemoLandingPage newDemoLandingPage;
    PricingAgreementModal pricingAgreementModal;

    @Test(testName = "PAC-PricingAgreement Modal Test")
    public void pricingAgreementModalValidation(){
        boolean result;
        newDemoLandingPage = new NewDemoLandingPage();
        priorAgreementComparison = new PriorAgreementComparisonPage();
        pricingAgreementModal = new PricingAgreementModal();
        newDemoQALoginPage.launchUrl(this.url);
        newDemoQALoginPage.setEmailAddressNewDemo(this.email);
        newDemoQALoginPage.setPassword(this.password);
        newDemoQALoginPage.signInClick();
        newDemoLandingPage.clickOnPriorAgreementComparisonTile();
        priorAgreementComparison.pricingAgreementBtnClick();
        pricingAgreementModal.clickModalFullscreen();
        result = pricingAgreementModal.validateModalFullscreenClick();
        Assert.assertTrue(result,"Pricing Agreement Modal full screen not working.");
    }

}
