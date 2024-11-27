package newDemoQaPages.demoInvoiceReviewPage;

import newDemoQaPages.demoPriorAgreementComparisonPage.NicknameAccountsModal;
import org.openqa.selenium.By;

public class NicknameAccountsModalInvoiceReview extends NicknameAccountsModal {

    public NicknameAccountsModalInvoiceReview(){
        this.closeModalBtn = By.xpath("//div[@class='modal-header']//button[@class='btn-close']");
    }

}
