package newDemoQaPages.demoInvoiceReviewPage.avgCostPerPkgModals;

import newDemoQaPages.demoPriorAgreementComparisonPage.avgSavPerPkg.AvgSavPerPkgModalFirstLevel;
import org.openqa.selenium.By;

public class AvgCostPerPkgModalFirstLevel extends AvgSavPerPkgModalFirstLevel {

    public AvgCostPerPkgModalFirstLevel(){
     this.dataTestId = By.xpath("//div[@data-testid='average-saving-per-package-modal']//thead//tr//th");
    }
}
