package newDemoQaTest.demoPriorAgreementComparisonPageTest;

import newDemoQaPages.BaseModal;
import newDemoQaPages.NewDemoLandingPage;
import newDemoQaPages.NewDemoQALoginPage;
import newDemoQaPages.demoPriorAgreementComparisonPage.PriorAgreementComparisonPage;
import newDemoQaPages.demoPriorAgreementComparisonPage.priorDiscounts.PriorDiscountsModalFirstLevel;
import newDemoQaPages.demoPriorAgreementComparisonPage.priorDiscounts.PriorDiscountsModalSecondLevel;
import newDemoQaPages.demoPriorAgreementComparisonPage.priorDiscounts.SelectCarrierModal;
import newDemoQaTest.NewDemoBaseTest;
import org.testng.Assert;
import org.testng.annotations.*;

public class PriorDiscountsModalTest extends NewDemoBaseTest {

    PriorAgreementComparisonPage priorAgreementComparison;
    PriorDiscountsModalFirstLevel priorDiscountsModalFirstLevel;
    SelectCarrierModal selectCarrierModal;
    PriorDiscountsModalSecondLevel priorDiscountsModalSecondLevel;
    NewDemoLandingPage newDemoLandingPage;

    @Test
    public void priorDiscountsModalFirstLevelTest(){
        String modalTitle;
        boolean isVisible;
        newDemoLandingPage = new NewDemoLandingPage();
        priorAgreementComparison = new PriorAgreementComparisonPage();
        priorDiscountsModalFirstLevel = new PriorDiscountsModalFirstLevel();

        newDemoQALoginPage.launchUrl(this.url);
        newDemoQALoginPage.setEmailAddressNewDemo(this.email);
        newDemoQALoginPage.setPassword(this.password);
        newDemoQALoginPage.signInClick();
        newDemoLandingPage.clickOnPriorAgreementComparisonTile();
        priorAgreementComparison.priorDiscountsBtnClick();
        modalTitle = priorDiscountsModalFirstLevel.modalTitleValidation();
        Assert.assertEquals(modalTitle,"Prior Discounts");
        isVisible = priorDiscountsModalFirstLevel.tableDataVisibility();
        Assert.assertTrue(isVisible);
    }
    @Test(dataProvider = "getCarrierName")
    public void priorDiscountsModalSecondLevelTest(String carrierName){
        String modalTitle;
        boolean isVisible;
        newDemoLandingPage = new NewDemoLandingPage();
        priorAgreementComparison = new PriorAgreementComparisonPage();
        priorDiscountsModalFirstLevel = new PriorDiscountsModalFirstLevel();
        selectCarrierModal = new SelectCarrierModal();
        priorDiscountsModalSecondLevel = new PriorDiscountsModalSecondLevel();

        newDemoQALoginPage.launchUrl(this.url);
        newDemoQALoginPage.setEmailAddressNewDemo(this.email);
        newDemoQALoginPage.setPassword(this.password);
        newDemoQALoginPage.signInClick();
        newDemoLandingPage.clickOnPriorAgreementComparisonTile();
        priorAgreementComparison.priorDiscountsBtnClick();
        priorDiscountsModalFirstLevel.surchargesBtnClick();
        selectCarrierModal.selectCarrierClick(carrierName);
        selectCarrierModal.selectBtnClick();

        if (carrierName.equalsIgnoreCase("FEDEX")){
            modalTitle = priorDiscountsModalSecondLevel.modalTitleValidation();
            Assert.assertEquals(modalTitle,"FedEx Carrier");
            isVisible = priorDiscountsModalSecondLevel.tableDataVisibility();
            Assert.assertTrue(isVisible);
        }
        if (carrierName.equalsIgnoreCase("UPS")){
            modalTitle = priorDiscountsModalSecondLevel.modalTitleValidation();
            Assert.assertEquals(modalTitle,"UPS Carrier");
            isVisible = priorDiscountsModalSecondLevel.tableDataVisibility();
            Assert.assertTrue(isVisible);
        }
        if (carrierName.equalsIgnoreCase("DHL Express")){
            modalTitle = priorDiscountsModalSecondLevel.modalTitleValidation();
            Assert.assertEquals(modalTitle,"DHL-Express Carrier");
            isVisible = priorDiscountsModalSecondLevel.tableDataVisibility();
            Assert.assertTrue(isVisible);
        }
    }

    @DataProvider
    public String[] getCarrierName(){
        return new String[] {"FedEx","UPS","DHL Express"};
    }

}
