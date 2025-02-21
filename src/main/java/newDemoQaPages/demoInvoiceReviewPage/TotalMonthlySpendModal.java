package newDemoQaPages.demoInvoiceReviewPage;

import newDemoQaPages.demoPriorAgreementComparisonPage.NewInvoiceModal;
import org.openqa.selenium.By;

public class TotalMonthlySpendModal extends NewInvoiceModal {

    public TotalMonthlySpendModal(){
        this.parentTabs = By.xpath("//div[@data-testid='prior-agreement-total-of-uploaded-invoice']" +
                "//div[@class='d-flex flex-row justify-content-center gap-4']//button");
       this.childTabs = By.xpath("//div[@data-testid='prior-agreement-total-of-uploaded-invoice']" +
               "//div[@class='d-flex flex-row justify-content-center align-items-center']//button");
        this.tableDataLoadWait = By.xpath("//div[@data-testid='prior-agreement-total-of-uploaded-invoice']" +
                "//table[@class='x-table-bordered table table-sm table-striped']");
        this.downloadButton = By.xpath("//div[@data-testid='prior-agreement-total-of-uploaded-invoice']" +
                "//button[@icon='bi bi-cloud-download']");
    }


}
