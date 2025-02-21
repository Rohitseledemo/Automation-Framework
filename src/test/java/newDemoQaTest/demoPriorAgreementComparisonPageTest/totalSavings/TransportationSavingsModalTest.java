package newDemoQaTest.demoPriorAgreementComparisonPageTest.totalSavings;

import newDemoQaPages.NewDemoLandingPage;
import newDemoQaPages.NewDemoQALoginPage;
import newDemoQaPages.demoPriorAgreementComparisonPage.PriorAgreementComparisonPage;
import newDemoQaPages.demoPriorAgreementComparisonPage.totalSavings.TransportationSavingsModalFirstLevel;
import baseTest.NewDemoBaseTest;
import org.testng.annotations.Test;

import java.util.List;

public class TransportationSavingsModalTest extends NewDemoBaseTest {

    NewDemoLandingPage newDemoLandingPage;
    PriorAgreementComparisonPage priorAgreementComparisonPage;
    TransportationSavingsModalFirstLevel transportationSavingsModalFirstLevel;


    @Test
    public void transportSavFirstLevelModalTest(){
        int columnCount;
        float sum,actualSum;
        List<Float> columnValues;
        boolean isSorted;
        newDemoQALoginPage = new NewDemoQALoginPage();
        newDemoLandingPage = new NewDemoLandingPage();
        priorAgreementComparisonPage = new PriorAgreementComparisonPage();
        transportationSavingsModalFirstLevel = new TransportationSavingsModalFirstLevel();

        newDemoQALoginPage.launchUrl(this.url);
        newDemoQALoginPage.setEmailAddressNewDemo(this.email);
        newDemoQALoginPage.setPassword(this.password);
        newDemoQALoginPage.signInClick();
        newDemoLandingPage.clickOnPriorAgreementComparisonTile();
        priorAgreementComparisonPage.transportationSavingsClick();
        columnCount = transportationSavingsModalFirstLevel.headerClick("Total Packages");
        columnValues = transportationSavingsModalFirstLevel.columnData(columnCount);
        isSorted = transportationSavingsModalFirstLevel.sortingValidation(columnValues);
        sum = transportationSavingsModalFirstLevel.calculateSum(columnValues);
        System.out.println("sum - "+sum);
        actualSum = transportationSavingsModalFirstLevel.getTransModalFirstModalTotalRowCount();
        System.out.println("actualSum - "+actualSum);
        softAssert.assertEquals(sum,actualSum);
        softAssert.assertTrue(isSorted);
        softAssert.assertAll();
    }
}
