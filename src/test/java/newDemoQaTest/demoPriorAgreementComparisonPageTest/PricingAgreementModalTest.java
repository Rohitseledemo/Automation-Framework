package newDemoQaTest.demoPriorAgreementComparisonPageTest;

import newDemoQaPages.BaseModal;
import newDemoQaPages.NewDemoLandingPage;
import newDemoQaPages.NewDemoQALoginPage;
import newDemoQaPages.demoPriorAgreementComparisonPage.PricingAgreementModal;
import newDemoQaPages.demoPriorAgreementComparisonPage.PriorAgreementComparisonPage;
import newDemoQaTest.NewDemoBaseTest;
import org.testng.Assert;
import org.testng.annotations.*;

import java.net.MalformedURLException;

public class PricingAgreementModalTest extends NewDemoBaseTest {

    PriorAgreementComparisonPage priorAgreementComparison;
    NewDemoLandingPage newDemoLandingPage;
    PricingAgreementModal pricingAgreementModal;
    BaseModal baseModal;

    @Test
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
        Assert.assertTrue(result);
    }

}
