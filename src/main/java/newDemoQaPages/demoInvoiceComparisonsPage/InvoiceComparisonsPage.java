package newDemoQaPages.demoInvoiceComparisonsPage;

import basePages.NewDemoBasePage;
import org.openqa.selenium.By;

public class InvoiceComparisonsPage extends NewDemoBasePage {

    public InvoiceComparisonsPage(){
       this.newInvoice = By.xpath("//div[@class='d-flex align-items-center pt-2']//span[@class='fw-" +
               "semibold fs-2 ms-auto cursor-pointer text-dark ']");
       this.avgSavingsPerPkgBtn = By.xpath("//span[@class='cursor-pointer fw-semibold fs-2 ms-auto d-flex align-" +
               "items-center text-danger']");
       this.surchargeSavings = By.xpath("//div[contains(@class,'bg-white shadow-sm rounded savings_box yellow_" +
               "border')]//span[@class='d-block fs-22 fw-semibold text-danger ']");

    }


}
