package newDemoQaTest;

import baseTest.NewDemoBaseTest;
import newDemoQaPages.NewDemoQAForgotPasswordPage;
import newDemoQaPages.NewDemoQALoginPage;
import org.testng.Assert;
import org.testng.annotations.*;

public class NewDemoLoginPageTest extends NewDemoBaseTest {
    NewDemoQAForgotPasswordPage newDemoQAForgotPasswordPage;

    @Test(testName = "LP Login Test", dataProvider = "getData")
    public void loginTest(String scenario, String testInputEmail, String testInputPassword){
        newDemoQALoginPage.launchUrl(this.url);
        newDemoQALoginPage.setEmailAddressNewDemo(testInputEmail);
        newDemoQALoginPage.setPassword(testInputPassword);
        newDemoQALoginPage.rememberMeDemoClick();
        newDemoQALoginPage.signInClick();

        if (scenario.equalsIgnoreCase("IncorrectEmail")) {
            softAssert.assertTrue(newDemoQALoginPage.wrongEmailErrorDisplayed());
        }
//         else if (scenario.equalsIgnoreCase("IncorrectPassword")) {
//            Assert.assertTrue(newDemoQALoginPage.wrongPasswordErrorDisplayed());
//        }
        else if (scenario.equalsIgnoreCase("EmptyEmail")) {
            softAssert.assertTrue(newDemoQALoginPage.emptyEmailErrorDisplayed());

        } else if (scenario.equalsIgnoreCase("EmptyPassword")) {
            softAssert.assertTrue(newDemoQALoginPage.emptyPasswordErrorDisplayed());
        }
        softAssert.assertAll();
    }
    @Test(testName = "FP Forgot Password Page Test")
    public void forgotPasswordPageTest(){
        newDemoQAForgotPasswordPage = new NewDemoQAForgotPasswordPage();
        newDemoQALoginPage = new NewDemoQALoginPage();

        boolean displayed;
        newDemoQALoginPage.launchUrl(this.url);
        newDemoQALoginPage.forgotPasswordClick();
        newDemoQAForgotPasswordPage.setNewEmailAddress("ting.tong@gmail.com");
        newDemoQAForgotPasswordPage.setSendLinkBtnClick();
        displayed = newDemoQAForgotPasswordPage.resetPassLinkMessageValidation();
        Assert.assertTrue(displayed);
    }
    @DataProvider(name = "getData", parallel = true)
    public String[][] getData() {
        // 5 different data sets of username and password so,
        String[][] data = new String[3][3];
        // 1st dataset
        data[0][0] = "IncorrectEmail";
        data[0][1] = "admin!dogoodsinc.com";
        data[0][2] = "Dev@Admin2023!";
        // 3rd dataset
        data[1][0] = "EmptyEmail";
        data[1][1] = "";
        data[1][2] = "Dev@Admin2023!";
        // 4th dataset
        data[2][0] = "EmptyPassword";
        data[2][1] = "subdomain@dogoodsinc.com";
        data[2][2] = "";
        // 2nd dataset
//        data[3][0] = "IncorrectPassword";
//        data[3][1] = "subdomain@dogoodsinc.com";
//        data[3][2] = "Admin!Shipplug2024!";
        return data;
    }

}
