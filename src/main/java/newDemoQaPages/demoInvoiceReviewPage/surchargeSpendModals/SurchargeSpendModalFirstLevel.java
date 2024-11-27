package newDemoQaPages.demoInvoiceReviewPage.surchargeSpendModals;

import newDemoQaPages.demoPriorAgreementComparisonPage.totalSavings.SurchargeSavingsModalFirstLevel;
import org.openqa.selenium.By;

public class SurchargeSpendModalFirstLevel extends SurchargeSavingsModalFirstLevel {

    public SurchargeSpendModalFirstLevel(){
        this.totalSavingsFooterInSurcharge = By.xpath("//tfoot[@class='custom-table-footer']//tr//th[4]");

    }

    @Override
    public boolean surchargeTableDataValidator() {
    return super.surchargeTableDataValidator();
    }
}
