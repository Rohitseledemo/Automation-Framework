package newDemoQaPages.demoInvoiceReviewPage.surchargeSpendModals;

import newDemoQaPages.demoPriorAgreementComparisonPage.totalSavings.SurchargeSavingsModalSecondLevel;
import org.openqa.selenium.By;

public class SurchargeSpendModalSecondLevel extends SurchargeSavingsModalSecondLevel {
    public SurchargeSpendModalSecondLevel(){
       this.serialNos = By.xpath("//div[@data-testid='prior-agreement-surcharge-detail-service-surcharge" +
               "-modal']//tbody//tr//td[@class='align-middle text-wrap custom-header'][1]");
       this.tableDataLoadWait = By.xpath("//div[@data-testid='prior-agreement-surcharge-detail-service-" +
               "surcharge-modal']//tbody//tr//td[@class='align-middle text-wrap custom-header']");
       this.showEntriesDropdown = By.xpath("//div[@data-testid='prior-agreement-surcharge-detail-service-" +
               "surcharge-modal']//button[@id='dropdown-basic']");
       this.showEntriesDropdownElements = By.xpath("//div[contains(@class,'dropdown-menu show')]//a");

    }
}
