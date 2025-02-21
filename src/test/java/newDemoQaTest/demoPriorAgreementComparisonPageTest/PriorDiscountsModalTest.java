package newDemoQaTest.demoPriorAgreementComparisonPageTest;

import newDemoQaPages.NewDemoLandingPage;
import newDemoQaPages.demoPriorAgreementComparisonPage.PriorAgreementComparisonPage;
import newDemoQaPages.demoPriorAgreementComparisonPage.priorDiscounts.PriorDiscountsModalFirstLevel;
import newDemoQaPages.demoPriorAgreementComparisonPage.priorDiscounts.PriorDiscountsModalSecondLevel;
import newDemoQaPages.demoPriorAgreementComparisonPage.priorDiscounts.SelectCarrierModal;
import baseTest.NewDemoBaseTest;
import org.testng.annotations.*;

public class PriorDiscountsModalTest extends NewDemoBaseTest {

    PriorAgreementComparisonPage priorAgreementComparison;
    PriorDiscountsModalFirstLevel priorDiscountsModalFirstLevel;
    SelectCarrierModal selectCarrierModal;
    PriorDiscountsModalSecondLevel priorDiscountsModalSecondLevel;
    NewDemoLandingPage newDemoLandingPage;

    @Test(testName = "PAC-PriorDiscountModal Verify")
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
        softAssert.assertEquals(modalTitle,"Prior Discounts");
        isVisible = priorDiscountsModalFirstLevel.tableDataVisibility();
        softAssert.assertTrue(isVisible,"Table Data Not Visible.");
        softAssert.assertAll();
    }
    @Test(testName = "PAC-PriorDiscount 2LvlModal Test",dataProvider = "getCarrierName")
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
            softAssert.assertEquals(modalTitle,"FedEx Carrier");
            isVisible = priorDiscountsModalSecondLevel.tableDataVisibility();
            softAssert.assertTrue(isVisible,"Table Data Not Visible in FedEx.");
        }
        if (carrierName.equalsIgnoreCase("UPS")){
            modalTitle = priorDiscountsModalSecondLevel.modalTitleValidation();
            softAssert.assertEquals(modalTitle,"UPS Carrier");
            isVisible = priorDiscountsModalSecondLevel.tableDataVisibility();
            softAssert.assertTrue(isVisible,"Table Data Not Visible in UPS.");
        }
        if (carrierName.equalsIgnoreCase("DHL Express")){
            modalTitle = priorDiscountsModalSecondLevel.modalTitleValidation();
            softAssert.assertEquals(modalTitle,"DHL-Express Carrier");
            isVisible = priorDiscountsModalSecondLevel.tableDataVisibility();
            softAssert.assertTrue(isVisible,"Table Data Not Visible in DHL Express.");
        }
        softAssert.assertAll();
    }

    @DataProvider(name = "getCarrierName", parallel = true)
    public String[] getCarrierName(){
        return new String[] {"FedEx","UPS","DHL Express"};
    }

}
