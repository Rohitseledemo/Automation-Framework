package newDemoQaPages.demoPriorAgreementComparisonPage.priorDiscounts;

import newDemoQaPages.BaseModal;
import org.openqa.selenium.By;

public class PriorDiscountsModalSecondLevel extends BaseModal {

    public PriorDiscountsModalSecondLevel(){
        this.tableDataLoadWait = By.xpath("//div[@class='accordion']");
        this.modalTitle = By.xpath("//div[@data-testid='select-carrier']//div[@class='modal-title h4']");
    }
}
