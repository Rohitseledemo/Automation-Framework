package newDemoQaTest;
import newDemoQaPages.*;
import org.testng.Assert;
import org.testng.annotations.*;

public class YearlyIncreasesPageTest extends NewDemoBaseTest{
    NewDemoLandingPage newDemoLandingPage;
    YearlyIncreasesPage yearlyIncreasesPage;
    BaseModal baseModal;

    @Test(dataProvider = "getCarrierIndex")
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

    @DataProvider
    public Object[] getCarrierIndex(){
        return new Object[] {0,1};
    }

}
