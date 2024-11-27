package newDemoQaPages.demoRefundsPage.carrierPerformance;

import newDemoQaPages.BaseModal;
import org.openqa.selenium.By;

public class CarrierPerformanceModal extends BaseModal {

    public CarrierPerformanceModal(){
//       this.mapStates = By.xpath("//div[@class='w-50 d-flex']//div[contains(@id,'reactgooglegraph')]" +
//               "//*[name()='g']//*[@stroke='#275f8a']");
        this.mapStates = By.xpath("//div[@data-testid='overall-performance']//div[@class='w-50 d-flex']" +
                "//div[contains(@id,'reactgooglegraph')]//*[name()='g']//*[contains(@d,'M')]");

       this.carrierSelectorFedEx = By.xpath("//div[@class='d-flex align-items-center justify-content-center" +
               " my-2 gap-2']//button[text()='FedEx']");
       this.carrierSelectorUPS = By.xpath("//div[@class='d-flex align-items-center justify-content-center " +
               "my-2 gap-2']//button[text()='UPS']");
       this.tableDataLoadWait = By.xpath("//tbody//tr//td[@class='align-middle text-wrap custom-header']");
;    }

    @Override
    public void carrierSelectorValidator() {
        super.carrierSelectorValidator();
    }

}
