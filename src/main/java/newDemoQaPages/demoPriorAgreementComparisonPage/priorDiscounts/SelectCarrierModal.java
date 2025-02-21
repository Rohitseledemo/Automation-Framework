package newDemoQaPages.demoPriorAgreementComparisonPage.priorDiscounts;

import newDemoQaPages.BaseModal;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.JavaScriptExecutorMethods;
import utilities.WebDriverWaits;

import java.util.List;

public class SelectCarrierModal extends BaseModal {
    WebDriverWaits wait;
    JavaScriptExecutorMethods javaScript;

    By selectCarriers;
    By selectBtn;

    public SelectCarrierModal(){
        this.selectCarriers = By.xpath("//form[@class='d-flex flex-row justify-content-between my-2']//label");
        this.selectBtn = By.xpath("//button[@class='mt-3 d-flex flex-row justify-content-center align-" +
                "items-center shadow btn btn-primary']");
    }

    public void selectCarrierClick(String carrierName){
        wait = new WebDriverWaits(this.getBrowser());
        wait.waitForPresenceOfElement(30,selectCarriers);
        List<WebElement> carriers = this.getBrowser().findElements(selectCarriers);
        for (WebElement element : carriers) {
            String elementText = element.getText();
            if (elementText.equalsIgnoreCase(carrierName)){
                element.click();
                break;
            }
        }
    }

    public void selectBtnClick(){
        wait = new WebDriverWaits(this.getBrowser());
        wait.waitForPresenceOfElement(30,selectBtn);
        this.getBrowser().findElement(selectBtn).click();
    }

}
