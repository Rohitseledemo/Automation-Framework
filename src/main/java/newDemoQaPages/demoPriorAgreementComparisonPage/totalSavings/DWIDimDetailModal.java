package newDemoQaPages.demoPriorAgreementComparisonPage.totalSavings;

import newDemoQaPages.BaseModal;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.WebDriverWaits;

import java.util.List;

public class DWIDimDetailModal extends BaseModal {
    WebDriverWaits wait;
    public DWIDimDetailModal(){
        this.spinnerLoad = By.xpath("//div[@class='spinner-border spinner-border-sm text-primary']");
        this.dataTestId = By.xpath("//thead[@class='sticky-header shadow-sm']//tr//th[@class='text-wrap ']");
        this.downloadButton = By.xpath("//div[@data-testid='dim-detail-modal']" +
                "//button[@data-download-status='ideal']");
        this.serviceDropdown = By.xpath("//div[@data-testid='dim-detail-modal']" +
                "//button[contains(@class,'Button_co7d3_5 dropdown-toggle btn btn-light')]");
        this.serviceDropdownElements = By.xpath("//div[contains(@class,'dropdown-menu show')]//a");
        this.emptyClick = By.xpath("//div[@class='d-flex justify-content-center align-items-center gap-2']");

    }
    @Override
    public List<WebElement> columnDataWebElements(int columnCount) {
        wait = new WebDriverWaits(this.getBrowser());
        wait.waitForVisibilityOfElement(10,spinnerLoad);
        wait.waitForInvisibilityOfElementLocated(30,spinnerLoad);
        List<WebElement> columnWebElements;
        columnWebElements = this.getBrowser().findElements(By.xpath("//tbody//tr//td[@class='align-middle " +
                "text-wrap custom-header']["+columnCount+"]"));
        return columnWebElements;
    }
}