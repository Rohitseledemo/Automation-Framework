package newDemoQaPages.demoPriorAgreementComparisonPage.totalSavings;

import newDemoQaPages.BaseModal;
import org.openqa.selenium.By;

public class DimensionalWeightImpactModalSecondLevel extends BaseModal {

    public DimensionalWeightImpactModalSecondLevel(){
        this.serialNos = By.xpath("//div[@data-testid='dimensional-weight-impact-box-size']//tbody//tr//" +
                "td[@class='align-middle text-wrap custom-header'][1]");
        this.dataTestId = By.xpath("//div[@data-testid='dimensional-weight-impact-box-size']//thead" +
                "[@class='sticky-header shadow-sm']//tr//th");
        this.trackingNos = By.xpath("//tbody//tr//td[@class='align-middle text-wrap custom-header']//div//span");
        this.downloadButton = By.xpath("//div[@data-testid='dimensional-weight-impact-box-size']" +
                "//button[@data-download-status='ideal']");
    }

    @Override
    public int headerClick(String headerName){
        return super.headerClick(headerName);
    }
    @Override
    public boolean trackingNumberValidation(){
        return super.trackingNumberValidation();
    }
}
