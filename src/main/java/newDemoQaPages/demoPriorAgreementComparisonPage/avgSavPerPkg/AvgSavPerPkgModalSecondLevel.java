package newDemoQaPages.demoPriorAgreementComparisonPage.avgSavPerPkg;

import newDemoQaPages.BaseModal;
import org.openqa.selenium.By;

public class AvgSavPerPkgModalSecondLevel extends BaseModal {

    public AvgSavPerPkgModalSecondLevel(){
        dataTestId = By.xpath("//div[@data-testid='surcharge-info']" +
                "//thead[@class='sticky-header shadow-sm']//tr//th");
    }

}
