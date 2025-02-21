package newDemoQaPages.demoPriorAgreementComparisonPage;

import newDemoQaPages.BaseModal;
import org.openqa.selenium.By;

public class BenchMarkingModal extends BaseModal {

    public BenchMarkingModal(){
        this.modalTitle = By.xpath("//div[@class='modal-title h4']");
    }
}
