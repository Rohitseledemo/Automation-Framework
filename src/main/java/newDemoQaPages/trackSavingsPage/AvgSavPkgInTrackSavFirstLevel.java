package newDemoQaPages.trackSavingsPage;

import newDemoQaPages.demoPriorAgreementComparisonPage.avgSavPerPkg.AvgSavPerPkgModalFirstLevel;
import org.openqa.selenium.By;

public class AvgSavPkgInTrackSavFirstLevel extends AvgSavPerPkgModalFirstLevel {


    public AvgSavPkgInTrackSavFirstLevel(){
        dataTestId = By.xpath("//div[@data-testid='average-saving-per-package-modal']//tr//th");

    }


}
