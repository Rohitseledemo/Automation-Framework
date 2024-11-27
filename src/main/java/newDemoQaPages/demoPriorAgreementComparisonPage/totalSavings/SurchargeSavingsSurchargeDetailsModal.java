package newDemoQaPages.demoPriorAgreementComparisonPage.totalSavings;

import newDemoQaPages.BaseModal;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.JavaScriptExecutorMethods;
import utility.WebDriverWaits;

import java.util.ArrayList;
import java.util.List;

public class SurchargeSavingsSurchargeDetailsModal extends BaseModal {
    WebDriverWaits wait;
    JavaScriptExecutorMethods javaScript;
    private By chooseServiceDropdown;
    private By chooseServiceDropdownElements;

    public By getChooseServiceDropdown(){
        return this.chooseServiceDropdown;
    }
    public By getChooseServiceDropdownElements(){
        return this.chooseServiceDropdownElements;
    }

    public SurchargeSavingsSurchargeDetailsModal(){
        this.chooseServiceDropdown = By.xpath("//div[@data-testid='prior-agreement-surcharge-detail-table-modal']" +
                "//button[@id='dropdown-basic']");
        this.chooseServiceDropdownElements = By.xpath("//div[@data-testid='prior-agreement-surcharge-detail" +
                "-table-modal']//div[contains(@class,'dropdown-menu show')]//a");
        this.dataTestId = By.xpath("//div[@data-testid='prior-agreement-surcharge-detail-table-modal']" +
                "//thead[@class='sticky-header shadow-sm']//tr//th//div[@class='custom-header']");
        this.serialNos= By.xpath("//div[@data-testid='prior-agreement-surcharge-detail-table-modal']" +
                "//tbody//tr//td[@class='align-middle text-wrap custom-header'][1]");
        this.tableDataLoadWait = By.xpath("//div[@data-testid='prior-agreement-surcharge-detail-" +
                "table-modal']//tbody//tr//td[@class='align-middle text-wrap custom-header']");
        this.trackingNos = By.xpath("//div[@class='text-center align-middle text-nowrap text-primary cursor-pointer']");

    }

    @Override
    public ArrayList<Float> columnData(int headerColumnCount) {
        ArrayList<Float> columnValues = new ArrayList<Float>();
        List<WebElement> columnWebElements;

        columnWebElements = this.getBrowser().findElements(By.xpath("//div[@data-testid='prior-agreement" +
                "-surcharge-detail-table-modal']//tbody//tr//td[@class='" +
                "align-middle text-wrap custom-header'][" + headerColumnCount + "]"));
        for (WebElement countValue : columnWebElements) {
            float value = Float.parseFloat(countValue.getText().replace("$", ""));
            columnValues.add(value);
        }
//        for printing arrayList data
//        for (Float columnValue : columnValues) {
//            System.out.println(columnValue);
//        }
        return columnValues;
    }
    @Override
    public List<WebElement> columnDataWebElements(int columnCount) {
        wait = new WebDriverWaits(this.getBrowser());
        List<WebElement> columnWebElements;
        columnWebElements = this.getBrowser().findElements(By.xpath("//div[@data-testid='prior-agreement-" +
                "surcharge-detail-table-modal']//tbody//tr//td["+columnCount+"]//div"));
        return columnWebElements;
    }
}
