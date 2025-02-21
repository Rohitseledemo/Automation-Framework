package newDemoQaPages;

import basePages.NewDemoBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import utilities.JavaScriptExecutorMethods;
import utilities.WebDriverWaits;

public class NewDemoQAForgotPasswordPage extends NewDemoBasePage {
    WebDriverWaits wait;
    JavaScriptExecutorMethods javaScript;

    By emailTextBox;
    By sendLinkBtn;
    By goBackToLoginBtn;
    By resetPassMessage;

    public NewDemoQAForgotPasswordPage(){
      this.emailTextBox = By.id("validationEmail");
      this.sendLinkBtn = By.xpath("//button[@type='submit']");
      this.goBackToLoginBtn = By.xpath("//a[@class='fs-14 text-secondary text-decoration-none']");
      this.resetPassMessage = By.xpath("//span[@class='text-danger']");
    }
    public void setNewEmailAddress(String inputEmail){
        wait = new WebDriverWaits(this.getBrowser());
        wait.waitForPresenceOfElement(10,emailTextBox);
        Actions action = new Actions(this.getBrowser());
        action.moveToElement(this.getBrowser().findElement(emailTextBox)).sendKeys(inputEmail);
//        this.getBrowser().findElement(emailTextBox).sendKeys(inputEmail);
    }
    public void setSendLinkBtnClick(){
        wait = new WebDriverWaits(this.getBrowser());
        javaScript = new JavaScriptExecutorMethods(this.getBrowser());
        wait.waitForPresenceOfElement(5,sendLinkBtn);
        javaScript.clickWebElement(this.getBrowser().findElement(sendLinkBtn));
    }
    public void goBackToLoginBtnClick(){
        wait = new WebDriverWaits(this.getBrowser());
        wait.waitForPresenceOfElement(5,goBackToLoginBtn);
        this.getBrowser().findElement(goBackToLoginBtn).click();
    }
    public boolean resetPassLinkMessageValidation(){
        wait = new WebDriverWaits(this.getBrowser());
        wait.waitForPresenceOfElement(10,goBackToLoginBtn);
        return this.getBrowser().findElement(goBackToLoginBtn).isDisplayed();
    }
}
