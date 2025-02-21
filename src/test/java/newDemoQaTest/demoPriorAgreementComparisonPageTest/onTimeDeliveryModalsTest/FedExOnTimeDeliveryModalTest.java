//package newDemoQaTest.demoPriorAgreementComparisonPageTest.onTimeDeliveryModalsTest;
//
//import newDemoQaPages.BaseModal;
//import newDemoQaPages.NewDemoLandingPage;
//import newDemoQaPages.demoPriorAgreementComparisonPage.PriorAgreementComparisonPage;
//import newDemoQaPages.demoPriorAgreementComparisonPage.onTimeDeliveryModals.FedExOnTimeDeliveryModalFirstLevel;
//import baseTest.NewDemoBaseTest;
//import org.testng.Assert;
//import org.testng.annotations.Test;
//
//import java.util.List;
//
//public class FedExOnTimeDeliveryModalTest extends NewDemoBaseTest {
//
//    NewDemoLandingPage newDemoLandingPage;
//    PriorAgreementComparisonPage priorAgreementComparisonPage;
//    FedExOnTimeDeliveryModalFirstLevel fedExOnTimeDeliveryModalFirstLevel;
//    BaseModal baseModal;
//
//    @Test
//    public void fedExOnTimeDeliveryFirstLevelModalTest(){
//        int headerColumnCount;
//        List<Float> numbers;
//        newDemoLandingPage = new NewDemoLandingPage();
//        priorAgreementComparisonPage = new PriorAgreementComparisonPage();
//        fedExOnTimeDeliveryModalFirstLevel = new FedExOnTimeDeliveryModalFirstLevel();
//        baseModal = new BaseModal();
//        newDemoQALoginPage.launchUrl(this.url);
//        newDemoQALoginPage.setEmailAddressNewDemo(this.email);
//        newDemoQALoginPage.setPassword(this.password);
//        newDemoQALoginPage.signInClick();
//        newDemoLandingPage.clickOnPriorAgreementComparisonTile();
//        priorAgreementComparisonPage.fedExOnTimeDeliveryClick();
//        headerColumnCount = fedExOnTimeDeliveryModalFirstLevel.headerClick("Late Packages");
//        numbers = fedExOnTimeDeliveryModalFirstLevel.columnData(headerColumnCount);
//        float actual = baseModal.calculateSum(numbers);
//        Assert.assertEquals(actual,fedExOnTimeDeliveryModalFirstLevel.getFedExFirstModalTotalRowCount());
//
//    }
//}
