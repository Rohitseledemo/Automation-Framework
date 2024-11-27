package newDemoQaTest.demoPriorAgreementComparisonPageTest;

import newDemoQaPages.BaseModal;
import newDemoQaPages.NewDemoLandingPage;
import newDemoQaPages.demoPriorAgreementComparisonPage.BenchMarkingModal;
import newDemoQaPages.demoPriorAgreementComparisonPage.PriorAgreementComparisonPage;
import newDemoQaTest.NewDemoBaseTest;
import org.testng.annotations.*;

public class BenchMarkingModalTest extends NewDemoBaseTest {

    PriorAgreementComparisonPage priorAgreementComparison;
    NewDemoLandingPage newDemoLandingPage;
    BenchMarkingModal benchMarkingModal;
    BaseModal baseModal;

    @Test
    public void benchmarkingDetailsTest(){
        newDemoLandingPage = new NewDemoLandingPage();
        priorAgreementComparison = new PriorAgreementComparisonPage();
        benchMarkingModal = new BenchMarkingModal();
        baseModal = new BaseModal();

        newDemoQALoginPage.launchUrl(this.url);
        newDemoQALoginPage.setEmailAddressNewDemo(this.email);
        newDemoQALoginPage.setPassword(this.password);
        newDemoQALoginPage.signInClick();
        newDemoLandingPage.clickOnPriorAgreementComparisonTile();
        priorAgreementComparison.benchMarkingBtnClick();
        benchMarkingModal.isModalDisplayed(benchMarkingModal.getModalTitle());
    }

}
