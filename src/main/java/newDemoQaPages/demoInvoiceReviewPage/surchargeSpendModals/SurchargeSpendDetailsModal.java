package newDemoQaPages.demoInvoiceReviewPage.surchargeSpendModals;

import newDemoQaPages.demoPriorAgreementComparisonPage.totalSavings.SurchargeSavingsSurchargeDetailsModal;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.WebDriverWaits;

import java.util.ArrayList;
import java.util.List;

public class SurchargeSpendDetailsModal extends SurchargeSavingsSurchargeDetailsModal {
    WebDriverWaits wait;
    public SurchargeSpendDetailsModal(){
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

        columnWebElements = this.getBrowser().findElements(By.xpath("//div[@data-testid='prior-agreement-" +
                "surcharge-detail-table-modal']//tbody//tr//td[@class='align-middle text-wrap custom-header']["+headerColumnCount+"]"));
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
        columnWebElements = this.getBrowser().findElements(By.xpath("//div[@data-testid='prior-agreement" +
                "-surcharge-detail-table-modal']//tbody//tr//td["+columnCount+"]"));
        //for printing webelements list size
        System.out.println("size of list - "+columnWebElements.size());
        return columnWebElements;
    }
}
