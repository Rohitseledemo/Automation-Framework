package newDemoQaTest.trackSavingsPageTest;

import baseClass.NewDemoBasePage;
import newDemoQaPages.NewDemoLandingPage;
import newDemoQaPages.NewDemoQALoginPage;
import newDemoQaPages.switchToCompanyView.SwitchToCompanyViewModal;
import newDemoQaPages.trackSavingsPage.TrackSavPriorDiscountModalFirstLevel;
import newDemoQaPages.trackSavingsPage.TrackSavPriorDiscountModalSecondLevel;
import newDemoQaPages.trackSavingsPage.TrackSavSelectCarrierModal;
import newDemoQaPages.trackSavingsPage.TrackSavingsPage;
import newDemoQaTest.NewDemoBaseTest;
import org.testng.Assert;
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

    @Test
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
        Assert.assertEquals(modalTitle,"Prior Discounts");
        isVisible = trackSavPriorDiscountModalFirstLevel.tableDataVisibility();
        Assert.assertTrue(isVisible);
    }
    @Test(dataProvider = "getCarrierName")
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
            Assert.assertEquals(modalTitle,"FedEx Carrier");
            isVisible = trackSavPriorDiscountModalSecondLevel.tableDataVisibility();
            Assert.assertTrue(isVisible);
        }
        if (carrierName.equalsIgnoreCase("UPS")){
            modalTitle = trackSavPriorDiscountModalSecondLevel.modalTitleValidation();
            Assert.assertEquals(modalTitle,"UPS Carrier");
            isVisible = trackSavPriorDiscountModalSecondLevel.tableDataVisibility();
            Assert.assertTrue(isVisible);
        }
        if (carrierName.equalsIgnoreCase("DHL Express")){
            modalTitle = trackSavPriorDiscountModalSecondLevel.modalTitleValidation();
            Assert.assertEquals(modalTitle,"DHL-Express Carrier");
            isVisible = trackSavPriorDiscountModalSecondLevel.tableDataVisibility();
            Assert.assertTrue(isVisible);
        }
    }

    @DataProvider
    public String[] getCarrierName(){
        return new String[] {"FedEx","UPS","DHL Express"};
    }
}
