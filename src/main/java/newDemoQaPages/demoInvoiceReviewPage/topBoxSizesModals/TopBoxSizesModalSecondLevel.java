package newDemoQaPages.demoInvoiceReviewPage.topBoxSizesModals;

import newDemoQaPages.demoPriorAgreementComparisonPage.totalSavings.DimensionalWeightImpactModalSecondLevel;
import org.openqa.selenium.By;

public class TopBoxSizesModalSecondLevel extends DimensionalWeightImpactModalSecondLevel {

    public TopBoxSizesModalSecondLevel(){
        this.downloadButton = By.xpath("//div[@data-testid='dimensional-weight-impact-box-size']" +
                "//button[@data-download-status='ideal']");
    }
}
