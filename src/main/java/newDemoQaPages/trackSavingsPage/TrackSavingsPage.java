package newDemoQaPages.trackSavingsPage;

import baseClass.NewDemoBasePage;
import org.openqa.selenium.By;
import utility.JavaScriptExecutorMethods;
import utility.WebDriverWaits;

public class TrackSavingsPage extends NewDemoBasePage {

    WebDriverWaits wait;
    JavaScriptExecutorMethods javaScript;

    By avgSavingsPerPkgBtn;
    By priorDiscountBtn;

    public TrackSavingsPage(){
       this.pageTitle = By.xpath("//div[@class='h3']");
       this.avgSavingsPerPkgBtn = By.xpath("//div[text()='Average Saving Per Package']");
       this.priorDiscountBtn = By.xpath("//div[text()='Prior Discount']");
    }

    public void avgSavingsPerPkgBtnClick(){
        wait = new WebDriverWaits(this.getBrowser());
        javaScript = new JavaScriptExecutorMethods(this.getBrowser());
        wait.waitForPresenceOfElement(20,avgSavingsPerPkgBtn);
        javaScript.clickWebElement(this.getBrowser().findElement(avgSavingsPerPkgBtn));
    }

    public void priorDiscountBtnClick(){
        wait = new WebDriverWaits(this.getBrowser());
        javaScript = new JavaScriptExecutorMethods(this.getBrowser());
        wait.waitForPresenceOfElement(20,priorDiscountBtn);
        javaScript.clickWebElement(this.getBrowser().findElement(priorDiscountBtn));
    }





}
