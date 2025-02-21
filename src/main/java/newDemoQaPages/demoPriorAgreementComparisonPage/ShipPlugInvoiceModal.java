package newDemoQaPages.demoPriorAgreementComparisonPage;

import newDemoQaPages.BaseModal;
import org.openqa.selenium.By;
import utilities.JavaScriptExecutorMethods;
import utilities.WebDriverWaits;

public class ShipPlugInvoiceModal extends BaseModal {
    WebDriverWaits wait;
    JavaScriptExecutorMethods javaScript;

    public ShipPlugInvoiceModal(){
       this.downloadButton = By.xpath("//div[@data-testid='project-invoice']//button[@class=' d-flex " +
               "justify-content-between align-items-center gap-2 btn btn-primary']");
       this.tableDataLoadWait = By.xpath("//div[@data-testid='project-invoice']//table[@class='x-table-" +
               "bordered _table_yadg7_1 table table-sm']");
    }

}
