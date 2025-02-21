//package newDemoQaTest.demoPriorAgreementComparisonPageTest.onTimeDeliveryModalsTest;
//
//import newDemoQaPages.BaseModal;
//import newDemoQaPages.NewDemoLandingPage;
//import newDemoQaPages.demoPriorAgreementComparisonPage.PriorAgreementComparisonPage;
//import newDemoQaPages.demoPriorAgreementComparisonPage.onTimeDeliveryModals.UpsOnTimeDeliveryModalFirstLevel;
//import baseTest.NewDemoBaseTest;
//import org.testng.Assert;
//import org.testng.annotations.Test;
//
//import java.util.List;
//
//public class UpsOnTimeDeliveryModalTest extends NewDemoBaseTest {
//
//    NewDemoLandingPage newDemoLandingPage;
//    PriorAgreementComparisonPage priorAgreementComparisonPage;
//    UpsOnTimeDeliveryModalFirstLevel upsOnTimeDeliveryModalFirstLevel;
//    BaseModal baseModal;
//
//    @Test
//    public void upsOnTimeDeliveryFirstLevelModalTest() {
//        int headerColumnCount;
//        List<Float> numbers;
//        newDemoLandingPage = new NewDemoLandingPage();
//        priorAgreementComparisonPage = new PriorAgreementComparisonPage();
//        upsOnTimeDeliveryModalFirstLevel = new UpsOnTimeDeliveryModalFirstLevel();
//        baseModal = new BaseModal();
//        newDemoQALoginPage.launchUrl(this.url);
//        newDemoQALoginPage.setEmailAddressNewDemo(this.email);
//        newDemoQALoginPage.setPassword(this.password);
//        newDemoQALoginPage.signInClick();
//        newDemoLandingPage.clickOnPriorAgreementComparisonTile();
//        priorAgreementComparisonPage.UPSOnTimeDeliveryClick();
//        headerColumnCount = upsOnTimeDeliveryModalFirstLevel.headerClick("Late Packages");
//        numbers = upsOnTimeDeliveryModalFirstLevel.columnData(headerColumnCount);
//        float actual = baseModal.calculateSum(numbers);
//        Assert.assertEquals(actual, upsOnTimeDeliveryModalFirstLevel.getUpsFirstModalTotalRowCount());
//    }
//}
