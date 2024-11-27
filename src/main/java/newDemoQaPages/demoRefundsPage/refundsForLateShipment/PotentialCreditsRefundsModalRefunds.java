package newDemoQaPages.demoRefundsPage.refundsForLateShipment;

import newDemoQaPages.demoPriorAgreementComparisonPage.refundsForLateShipment.PotentialCreditsRefundsModalFirstLevel;
import org.openqa.selenium.By;

public class PotentialCreditsRefundsModalRefunds extends PotentialCreditsRefundsModalFirstLevel {
    public PotentialCreditsRefundsModalRefunds(){
        this.downloadButton = By.xpath("//button[@data-download-status='ideal']");
    }
}
