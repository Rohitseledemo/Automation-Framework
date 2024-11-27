package newDemoQaPages.demoRefundsPage.carrierPerformance;

import newDemoQaPages.BaseModal;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.WebDriverWaits;

import java.util.List;

public class CarrierPerformanceReportDetailsModal extends BaseModal {
    WebDriverWaits wait;

    public CarrierPerformanceReportDetailsModal(){
        this.dataTestId = By.xpath("//div[@data-testid='carrier-performance']" +
                "//thead[@class='sticky-header shadow-sm']//tr//th");
        this.showEntriesDropdown = By.xpath("//div[@data-testid='carrier-performance']" +
                "//button[@id='dropdown-basic']");
        this.showEntriesDropdownElements = By.xpath("//div[@data-testid='carrier-performance']" +
                "//div[contains(@class,'dropdown-menu show')]//a");
        this.serialNos = By.xpath("//div[@data-testid='carrier-performance']//tbody//tr//td" +
                "[@class='align-middle text-wrap custom-header'][1]");
        this.tableDataLoadWait = By.xpath("//div[@data-testid='carrier-performance']//tbody//tr//td" +
                "[@class='align-middle text-wrap custom-header']");
        this.downloadButton = By.xpath("//button[@data-download-status='ideal']");
    }

    @Override
    public List<WebElement> columnDataWebElements(int columnCount) {
        wait = new WebDriverWaits(this.getBrowser());
        List<WebElement> columnWebElements;
        columnWebElements = this.getBrowser().findElements(By.xpath("//div[@data-testid='carrier-performance']" +
                "//tbody//tr//td//div[@class='_Link_107k8_7']//a"));
        return columnWebElements;
    }
}
