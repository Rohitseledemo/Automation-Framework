package newDemoQaPages.demoInvoiceReviewPage.surchargeSpendModals;

import newDemoQaPages.demoPriorAgreementComparisonPage.totalSavings.SurchargeSavingsSurchargeDetailsModal;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.WebDriverWaits;

import java.util.ArrayList;
import java.util.List;

public class SurchargeSpendDetailsModal extends SurchargeSavingsSurchargeDetailsModal {
    WebDriverWaits wait;
    public SurchargeSpendDetailsModal(){
        this.columnDataXpath = By.xpath("//div[@data-testid='prior-agreement-surcharge-detail-table-modal']" +
                "//tbody//tr//td[@class='align-middle text-wrap custom-header']");
        this.columnDataWebElementsXpath= By.xpath("//div[@data-testid='prior-agreement-surcharge-detail-" +
                "table-modal']//tbody//tr//td");
        this.dataTestId = By.xpath("//div[@data-testid='prior-agreement-surcharge-detail-table-modal']" +
                "//thead[@class='sticky-header shadow-sm']//tr//th");
      this.serialNos = By.xpath("//div[@data-testid='prior-agreement-surcharge-detail-table-modal']" +
              "//tbody//tr//td[@class='align-middle text-wrap custom-header'][1]");
      this.tableDataLoadWait = By.xpath("//div[@data-testid='prior-agreement-surcharge-detail-table-modal']" +
              "//tbody//tr//td[@class='align-middle text-wrap custom-header']");
    }

    @Override
    public ArrayList<Float> columnData(int headerColumnCount) {
        ArrayList<Float> columnValues = new ArrayList<Float>();
        List<WebElement> columnWebElements;

        By customXpath = this.generateDynamicXPath(columnDataXpath,headerColumnCount);
        columnWebElements = this.getBrowser().findElements(customXpath);
        for (WebElement countValue : columnWebElements) {
            float value = Float.parseFloat(countValue.getText().replace("$", ""));
            columnValues.add(value);
        }
//        for printing arrayList data
        for (Float columnValue : columnValues) {
            System.out.println(columnValue);
        }
        return columnValues;
    }
    @Override
    public List<WebElement> columnDataWebElements(int columnCount) {
        wait = new WebDriverWaits(this.getBrowser());
        List<WebElement> columnWebElements;
        By customXpath = this.generateDynamicXPath(columnDataWebElementsXpath,columnCount);
        columnWebElements = this.getBrowser().findElements(customXpath);
        //for printing webelements list size
//        System.out.println("size of list - "+columnWebElements.size());
        return columnWebElements;
    }
}
