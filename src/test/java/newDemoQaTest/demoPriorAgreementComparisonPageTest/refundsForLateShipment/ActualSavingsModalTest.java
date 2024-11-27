//package newDemoQaTest.demoPriorAgreementComparisonPageTest.refundsForLateShipment;
//
//import newDemoQaPages.BaseModal;
//import newDemoQaPages.NewDemoLandingPage;
//import newDemoQaPages.NewDemoQALoginPage;
//import newDemoQaPages.demoPriorAgreementComparisonPage.*;
//import newDemoQaPages.demoPriorAgreementComparisonPage.refundsForLateShipment.ActualSavingsModalFirstLevel;
//import org.testng.Assert;
//import org.testng.annotations.*;
//
//import java.net.MalformedURLException;
//import java.util.ArrayList;
//
//public class ActualSavingsModalTest {
//    String url, email, password;
//    NewDemoQALoginPage newDemoQALoginPage;
//    PriorAgreementComparisonPage priorAgreementComparison;
//    NewDemoLandingPage newDemoLandingPage;
//    BaseModal baseModal;
//    ActualSavingsModalFirstLevel actualSavingsModalFirstLevel;
//
//    @BeforeMethod
//    @Parameters({"Email", "Password", "URL"})
//    public void launchBrowser(@Optional("subdomain@dogoodsinc.com") String Email,
//                              @Optional("Dev@Admin2023!") String Password,
//                              @Optional("https://new-demo.dogoodsinc.com/") String Url)
//            throws MalformedURLException {
//
//        this.url = Url;
//        this.email = Email;
//        this.password = Password;
//
//        newDemoQALoginPage = new NewDemoQALoginPage();
//        newDemoQALoginPage.launchNewBrowserInstance();
//    }
//
//    @Test
//    public void actualSavingsFirstLevelModalTest(){
//        int headerColumnCount;
//        ArrayList<Float> values;
//        boolean sorted;
//        newDemoQALoginPage = new NewDemoQALoginPage();
//        newDemoLandingPage = new NewDemoLandingPage();
//        priorAgreementComparison = new PriorAgreementComparisonPage();
//        actualSavingsModalFirstLevel = new ActualSavingsModalFirstLevel();
//        baseModal = new BaseModal();
//
//        newDemoQALoginPage.launchUrl(this.url);
//        newDemoQALoginPage.setEmailAddressNewDemo(this.email);
//        newDemoQALoginPage.setPassword(this.password);
//        newDemoQALoginPage.signInClick();
//        newDemoLandingPage.clickOnPriorAgreementComparisonTile();
//        priorAgreementComparison.actualSavingsRefundClick();
//        //TC-1
//        actualSavingsModalFirstLevel.pageDataValidator(priorAgreementComparison.getTotalSavings(),priorAgreementComparison.
//                getSelectTimePeriodDropdown(),priorAgreementComparison.getDateDropdownElements());
//        //TC-2
//        actualSavingsModalFirstLevel.paginationClick(2);
//        actualSavingsModalFirstLevel.serialNoValidator(2);
//        //TC-3
//        headerColumnCount = actualSavingsModalFirstLevel.headerClick("Refund Amount");
//        values = actualSavingsModalFirstLevel.columnData(headerColumnCount);
//        sorted = baseModal.sortingValidation(values);
//        Assert.assertTrue(sorted);
//
//    }
//
//    @Test
//    public void actualSavingsShowEntriesTest() throws InterruptedException {
//        int serialNo;
//        boolean correct;
//        newDemoQALoginPage = new NewDemoQALoginPage();
//        newDemoLandingPage = new NewDemoLandingPage();
//        priorAgreementComparison = new PriorAgreementComparisonPage();
//        actualSavingsModalFirstLevel = new ActualSavingsModalFirstLevel();
//        baseModal = new BaseModal();
//
//        newDemoQALoginPage.launchUrl(this.url);
//        newDemoQALoginPage.setEmailAddressNewDemo(this.email);
//        newDemoQALoginPage.setPassword(this.password);
//        newDemoQALoginPage.signInClick();
//        newDemoLandingPage.clickOnPriorAgreementComparisonTile();
//        priorAgreementComparison.actualSavingsRefundClick();
//        //TC-1
//        actualSavingsModalFirstLevel.pageDataValidator(priorAgreementComparison.getTotalSavings(),priorAgreementComparison.
//                getSelectTimePeriodDropdown(),priorAgreementComparison.getDateDropdownElements());
//        //TC-2 - Show entries dropdown test
//        serialNo= actualSavingsModalFirstLevel.anyDropdownIterator(actualSavingsModalFirstLevel.getShowEntriesDropdown()
//                ,actualSavingsModalFirstLevel.getShowEntriesDropdownElements());
//        correct = actualSavingsModalFirstLevel.serialNoValidator(serialNo);
//        Assert.assertTrue(correct);
//    }
//
//    @AfterMethod
//    public void closeApplication () throws MalformedURLException {
//        newDemoQALoginPage.closeBrowser();
//    }
//}
