package newDemoQaTest.demoPriorAgreementComparisonPageTest;
import newDemoQaPages.NewDemoLandingPage;
import newDemoQaPages.demoPriorAgreementComparisonPage.BenchMarkingModal;
import newDemoQaPages.demoPriorAgreementComparisonPage.PriorAgreementComparisonPage;
import baseTest.NewDemoBaseTest;
import org.testng.Assert;
import org.testng.annotations.*;

public class BenchMarkingModalTest extends NewDemoBaseTest {

    PriorAgreementComparisonPage priorAgreementComparison;
    NewDemoLandingPage newDemoLandingPage;
    BenchMarkingModal benchMarkingModal;

    @Test(testName = "PAC-BenchmarkingDetails Modal Verify")
    public void benchmarkingDetailsTest(){
        boolean isDisplayed;
        newDemoLandingPage = new NewDemoLandingPage();
        priorAgreementComparison = new PriorAgreementComparisonPage();
        benchMarkingModal = new BenchMarkingModal();

        newDemoQALoginPage.launchUrl(this.url);
        newDemoQALoginPage.setEmailAddressNewDemo(this.email);
        newDemoQALoginPage.setPassword(this.password);
        newDemoQALoginPage.signInClick();
        newDemoLandingPage.clickOnPriorAgreementComparisonTile();
        priorAgreementComparison.benchMarkingBtnClick();
        isDisplayed=benchMarkingModal.isModalDisplayed(benchMarkingModal.getModalTitle());
        Assert.assertTrue(isDisplayed,"BenchMarking Modal not getting Opened.");
    }

}
