package newDemoQaTest.trackSavingsPageTest;

import basePages.NewDemoBasePage;
import newDemoQaPages.NewDemoLandingPage;
import newDemoQaPages.switchToCompanyView.SwitchToCompanyViewModal;
import newDemoQaPages.trackSavingsPage.TrackSavPriorDiscountModalFirstLevel;
import newDemoQaPages.trackSavingsPage.TrackSavPriorDiscountModalSecondLevel;
import newDemoQaPages.trackSavingsPage.TrackSavSelectCarrierModal;
import newDemoQaPages.trackSavingsPage.TrackSavingsPage;
import baseTest.NewDemoBaseTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TrackSavPriorDiscountModalTest extends NewDemoBaseTest {

    TrackSavPriorDiscountModalFirstLevel trackSavPriorDiscountModalFirstLevel;
    TrackSavSelectCarrierModal trackSavSelectCarrierModal;
    TrackSavPriorDiscountModalSecondLevel trackSavPriorDiscountModalSecondLevel;
    NewDemoBasePage newDemoBasePage;
    TrackSavingsPage trackSavingsPage;
    SwitchToCompanyViewModal switchToCompanyViewModal;
    NewDemoLandingPage newDemoLandingPage;

    @Test(testName = "TS PriorDiscounts FirstLevelModal Test")
    public void priorDiscountsModalFirstLevelTest(){
        String modalTitle;
        boolean isVisible;
        newDemoLandingPage = new NewDemoLandingPage();
        trackSavPriorDiscountModalFirstLevel = new TrackSavPriorDiscountModalFirstLevel();
        newDemoBasePage = new NewDemoBasePage();
        switchToCompanyViewModal = new SwitchToCompanyViewModal();
        trackSavingsPage = new TrackSavingsPage();

        newDemoQALoginPage.launchUrl(this.url);
        newDemoQALoginPage.setEmailAddressNewDemo(this.email);
        newDemoQALoginPage.setPassword(this.password);
        newDemoQALoginPage.signInClick();
        newDemoBasePage.profileDropdownBtnClick();
        newDemoBasePage.switchCompanyViewBtnClick();
        switchToCompanyViewModal.searchTextBoxValue("Activ Post");
        newDemoLandingPage.clickOnTrackSavingsTab();
        trackSavingsPage.priorDiscountBtnClick();
        modalTitle = trackSavPriorDiscountModalFirstLevel.modalTitleValidation();
        softAssert.assertEquals(modalTitle,"Prior Discounts");
        isVisible = trackSavPriorDiscountModalFirstLevel.tableDataVisibility();
        softAssert.assertTrue(isVisible,"Table Data not Visible.");
        softAssert.assertAll();
    }
    @Test(testName = "TS PriorDiscounts SecondLevelModal Test",
            dataProvider = "getCarrierName")
    public void priorDiscountsModalSecondLevelTest(String carrierName){
        String modalTitle;
        boolean isVisible;

        newDemoLandingPage = new NewDemoLandingPage();
        trackSavPriorDiscountModalFirstLevel = new TrackSavPriorDiscountModalFirstLevel();
        trackSavPriorDiscountModalSecondLevel = new TrackSavPriorDiscountModalSecondLevel();
        newDemoBasePage = new NewDemoBasePage();
        switchToCompanyViewModal = new SwitchToCompanyViewModal();
        trackSavingsPage = new TrackSavingsPage();
        trackSavSelectCarrierModal = new TrackSavSelectCarrierModal();

        newDemoQALoginPage.launchUrl(this.url);
        newDemoQALoginPage.setEmailAddressNewDemo(this.email);
        newDemoQALoginPage.setPassword(this.password);
        newDemoQALoginPage.signInClick();
        newDemoBasePage.profileDropdownBtnClick();
        newDemoBasePage.switchCompanyViewBtnClick();
        switchToCompanyViewModal.searchTextBoxValue("Activ Post");
        newDemoLandingPage.clickOnTrackSavingsTab();
        trackSavingsPage.priorDiscountBtnClick();
        trackSavPriorDiscountModalFirstLevel.surchargesBtnClick();
        trackSavSelectCarrierModal.selectCarrierClick(carrierName);
        trackSavSelectCarrierModal.selectBtnClick();

        if (carrierName.equalsIgnoreCase("FEDEX")){
            modalTitle = trackSavPriorDiscountModalSecondLevel.modalTitleValidation();
            softAssert.assertEquals(modalTitle,"FedEx Carrier");
            isVisible = trackSavPriorDiscountModalSecondLevel.tableDataVisibility();
            softAssert.assertTrue(isVisible,"Table Data not Visible for FedEx.");
        }
        if (carrierName.equalsIgnoreCase("UPS")){
            modalTitle = trackSavPriorDiscountModalSecondLevel.modalTitleValidation();
            softAssert.assertEquals(modalTitle,"UPS Carrier");
            isVisible = trackSavPriorDiscountModalSecondLevel.tableDataVisibility();
            softAssert.assertTrue(isVisible,"Table Data not Visible for UPS.");
        }
        if (carrierName.equalsIgnoreCase("DHL Express")){
            modalTitle = trackSavPriorDiscountModalSecondLevel.modalTitleValidation();
            softAssert.assertEquals(modalTitle,"DHL-Express Carrier");
            isVisible = trackSavPriorDiscountModalSecondLevel.tableDataVisibility();
            softAssert.assertTrue(isVisible,"Table Data not Visible for DHL Express.");
        }
        softAssert.assertAll();
    }

    @DataProvider(name="getCarrierName", parallel= true)
    public String[] getCarrierName(){
        return new String[] {"FedEx","UPS","DHL Express"};
    }
}
