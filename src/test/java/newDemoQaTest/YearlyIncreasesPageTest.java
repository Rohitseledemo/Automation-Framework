package newDemoQaTest;
import baseTest.NewDemoBaseTest;
import newDemoQaPages.*;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;

public class YearlyIncreasesPageTest extends NewDemoBaseTest {
    NewDemoLandingPage newDemoLandingPage;
    YearlyIncreasesPage yearlyIncreasesPage;
    BaseModal baseModal;

    @Test(testName = "YearlyIncreases Data Validation", dataProvider = "serviceIndexIterator")
    public void yearlyIncreasesDataValidation(int carrierIndex){
        boolean isEqual;
        newDemoLandingPage = new NewDemoLandingPage();
        yearlyIncreasesPage = new YearlyIncreasesPage();
        baseModal = new BaseModal();

        newDemoQALoginPage.launchUrl(this.url);
        newDemoQALoginPage.setEmailAddressNewDemo(this.email);
        newDemoQALoginPage.setPassword(this.password);
        newDemoQALoginPage.signInClick();
        newDemoLandingPage.clickOnYearlyIncreasesTab();
        yearlyIncreasesPage.anyDropdownIterator(yearlyIncreasesPage.getServiceDropdown(),
                yearlyIncreasesPage.getServiceDropdownElements(),carrierIndex);
        isEqual = yearlyIncreasesPage.reactChartSurchargesNamesSize();
        Assert.assertTrue(isEqual);
    }
    @Test(testName = "YearlyIncreases Carrier-Dropdown Test",dataProvider = "serviceIndexIterator")
    public void carrierDropdownTest(int[] serviceIndex){
        newDemoLandingPage = new NewDemoLandingPage();
        yearlyIncreasesPage = new YearlyIncreasesPage();
        baseModal = new BaseModal();

        newDemoQALoginPage.launchUrl(this.url);
        newDemoQALoginPage.setEmailAddressNewDemo(this.email);
        newDemoQALoginPage.setPassword(this.password);
        newDemoQALoginPage.signInClick();
        newDemoLandingPage.clickOnYearlyIncreasesTab();
        By dropdown = yearlyIncreasesPage.getCarrierServiceDropdown();
        By dropdownElements = yearlyIncreasesPage.getCarrierServiceDropdownElements();
        yearlyIncreasesPage.validateAllDropdownValues(dropdown,dropdownElements,serviceIndex);
    }


    @DataProvider(name = "serviceIndexIterator", parallel = true)
    public Object[][] serviceIndexIterator() {
        return new Object[][]{{new int[]{0, 1}}};
    }

}
