package newDemoQaTest.demoRefundsPageTest;

import newDemoQaPages.BaseModal;
import newDemoQaPages.NewDemoLandingPage;
import newDemoQaPages.NewDemoQALoginPage;
import newDemoQaPages.demoRefundsPage.DenialReasonsModal;
import newDemoQaPages.demoRefundsPage.RefundsPage;
import newDemoQaTest.NewDemoBaseTest;
import org.testng.Assert;
import org.testng.annotations.*;

import java.math.BigDecimal;
import java.util.List;

public class DenialReasonsModalTest extends NewDemoBaseTest {

    NewDemoLandingPage newDemoLandingPage;
    RefundsPage refundsPage;
    DenialReasonsModal denialReasonsModal;
    BaseModal baseModal;

    @Test
    public void denialReasonsModalTest(){
        int headerColumnCount;
        List<Float> numbers;

        newDemoLandingPage = new NewDemoLandingPage();
        refundsPage = new RefundsPage();
        denialReasonsModal = new DenialReasonsModal();
        baseModal = new BaseModal();

        newDemoQALoginPage.launchUrl(this.url);
        newDemoQALoginPage.setEmailAddressNewDemo(this.email);
        newDemoQALoginPage.setPassword(this.password);
        newDemoQALoginPage.signInClick();
        newDemoLandingPage.clickOnRefundsTile();
        refundsPage.denialReasonBtnClick();
        denialReasonsModal.modalTitleValidation();
        headerColumnCount = denialReasonsModal.headerClick("Total Refunds Denied ($)");
        numbers = denialReasonsModal.columnData(headerColumnCount);
        float actual = denialReasonsModal.calculateSum(numbers);
        Assert.assertEquals(actual,denialReasonsModal.getDenialReasonsModalTotalCount());
    }

}
