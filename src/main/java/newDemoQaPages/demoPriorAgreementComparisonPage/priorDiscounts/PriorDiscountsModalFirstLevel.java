package newDemoQaPages.demoPriorAgreementComparisonPage.priorDiscounts;

import newDemoQaPages.BaseModal;
import org.openqa.selenium.By;
import utilities.JavaScriptExecutorMethods;
import utilities.WebDriverWaits;

public class PriorDiscountsModalFirstLevel extends BaseModal {
    WebDriverWaits wait;
    JavaScriptExecutorMethods javaScript;

    By surchargesBtn;

    public PriorDiscountsModalFirstLevel(){
        this.surchargesBtn = By.xpath("//div[@class='d-flex justify-content-center modal-footer']" +
                "//button[text()='Surcharges']");
        this.tableDataLoadWait = By.xpath("//div[@data-testid='prior-discount']//table[@class='x-table-" +
                "bordered table table-sm table-striped']");
    }
    public void surchargesBtnClick(){
        wait = new WebDriverWaits(this.getBrowser());
        wait.waitForPresenceOfElement(30,surchargesBtn);
        this.getBrowser().findElement(surchargesBtn).click();
    }
}
