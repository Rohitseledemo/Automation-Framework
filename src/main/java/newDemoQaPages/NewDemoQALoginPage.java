package newDemoQaPages;

import basePages.NewDemoBasePage;
import org.openqa.selenium.By;
import utilities.JavaScriptExecutorMethods;
import utilities.WebDriverWaits;

public class NewDemoQALoginPage extends NewDemoBasePage {
    WebDriverWaits wait;
    JavaScriptExecutorMethods javaScript;

    By emailAddress;
    By password;
    By signIn;
    By rememberMe;
    By forgotPassword;
    By emptyPasswordError;
    By emptyEmailError;
    By invalidEmailError;
    By incorrectEmailError;
    By incorrectPasswordToast;
    By rememberMeDemo;
    By loginValidator;

    public NewDemoQALoginPage(){
        this.emailAddress = By.xpath("//input[@placeholder='Type your email here']");
        this.password = By.xpath("//input[@type='password']");
        this.signIn = By.xpath("//button[@type='submit']");
        this.rememberMe = By.cssSelector("input.form-check-input");
        this.forgotPassword = By.cssSelector("a.text-primary ");
        this.emptyPasswordError = By.cssSelector("div.text-danger ");
        this.emptyEmailError = By.cssSelector("div.text-danger ");
        this.invalidEmailError = By.cssSelector("div.text-danger ");
        this.incorrectEmailError = By.xpath("//div[@class='text-danger error-message']");
        this.rememberMeDemo = By.xpath("//input[@type='checkbox']");
        this.incorrectPasswordToast = By.xpath("//div[@class='Toastify__toast-body']");
        this.loginValidator = By.xpath("//div[@class='col-auto logo cursor-pointer']");

    }
    public void setEmailAddressNewDemo(String inputEmail){
        wait = new WebDriverWaits(this.getBrowser());
        wait.waitForPresenceOfElement(40,emailAddress);
        this.getBrowser().findElement(emailAddress).sendKeys(inputEmail);
    }
    public void setPassword(String inputPassword){
        this.getBrowser().findElement(password).sendKeys(inputPassword);
    }
    public void signInClick(){
        javaScript = new JavaScriptExecutorMethods(this.getBrowser());
        wait = new WebDriverWaits(this.getBrowser());

        wait.waitForPresenceOfElement(4,signIn);
        javaScript.clickWebElement(this.getBrowser().findElement(signIn));
    }
    public void rememberMeDemoClick(){
        wait = new WebDriverWaits(this.getBrowser());
        wait.waitForPresenceOfElement(4,rememberMeDemo);
        this.getBrowser().findElement(rememberMeDemo).click();
    }
    public void forgotPasswordClick(){
        wait = new WebDriverWaits(this.getBrowser());
        wait.waitForPresenceOfElement(8,forgotPassword);
        this.getBrowser().findElement(forgotPassword).click();
    }
    public boolean wrongEmailErrorDisplayed(){
        wait = new WebDriverWaits(this.getBrowser());
        wait.waitForPresenceOfElement(5,incorrectEmailError);
        return this.getBrowser().findElement(incorrectEmailError).isDisplayed() || this.getBrowser().findElement
                (incorrectPasswordToast).isDisplayed();
    }
    public boolean wrongPasswordErrorDisplayed(){
        javaScript = new JavaScriptExecutorMethods(this.getBrowser());
        wait = new WebDriverWaits(this.getBrowser());
//        wait.waitForPresenceOfElement(3, incorrectPasswordToast);
        wait.waitForVisibilityOfElement(4,incorrectPasswordToast);
        return this.getBrowser().findElement(incorrectPasswordToast).isDisplayed();
    }
    public boolean emptyPasswordErrorDisplayed(){
        wait = new WebDriverWaits(this.getBrowser());
        wait.waitForPresenceOfElement(5,emptyPasswordError);
        return this.getBrowser().findElement(emptyPasswordError).isDisplayed();
    }
    public boolean emptyEmailErrorDisplayed(){
        wait = new WebDriverWaits(this.getBrowser());
        wait.waitForPresenceOfElement(5,emptyEmailError);
        return this.getBrowser().findElement(emptyEmailError).isDisplayed();
    }
    public boolean loginVerify(){
        wait = new WebDriverWaits(this.getBrowser());
        wait.waitForPresenceOfElement(10, loginValidator);
        return this.getBrowser().findElement(loginValidator).isDisplayed();
    }
}
