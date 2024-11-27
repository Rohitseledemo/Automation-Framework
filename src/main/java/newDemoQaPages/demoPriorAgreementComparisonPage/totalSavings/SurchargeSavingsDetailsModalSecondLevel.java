package newDemoQaPages.demoPriorAgreementComparisonPage.totalSavings;

import newDemoQaPages.BaseModal;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.WebDriverWaits;

import java.util.ArrayList;
import java.util.List;

public class SurchargeSavingsDetailsModalSecondLevel extends BaseModal {
    WebDriverWaits wait;

    public SurchargeSavingsDetailsModalSecondLevel(){
        this.dataTestId = By.xpath("//div[@data-testid='prior-agreement-surcharge-detail-service-table" +
                "-modal']//thead[@class='sticky-header shadow-sm']//tr//th//div[@class='custom-header']");
        this.serialNos = By.xpath("//div[@data-testid='prior-agreement-surcharge-detail-service-table-" +
                "modal']//tbody//tr//td[@class='align-middle text-wrap custom-header'][1]");
        this.tableDataLoadWait = By.xpath("//div[@data-testid='prior-agreement-surcharge-detail-service-" +
                "table-modal']//tbody//tr//td[@class='align-middle text-wrap custom-header']");
        this.closeModalBtn = By.xpath("//div[@data-testid='prior-agreement-surcharge-detail-service-table-modal']//button[@class='btn-close']");
    }

    @Override
    public ArrayList<Float> columnData(int headerColumnCount) {
        ArrayList<Float> columnValues = new ArrayList<Float>();
        List<WebElement> columnWebElements;

        columnWebElements = this.getBrowser().findElements(By.xpath("//div[@data-testid='prior-agreement" +
                "-surcharge-detail-service-table-modal']//tbody//tr//td[@class='align-middle text-wrap custom-header']" +
                "["+headerColumnCount+"]"));
        for (WebElement countValue : columnWebElements) {
            float value = Float.parseFloat(countValue.getText().replace("$", "")
                    .replace("%",""));
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
        columnWebElements = this.getBrowser().findElements(By.xpath("//div[@data-testid='prior-agreement-" +
                "surcharge-detail-service-table-modal']//tbody//tr//td["+columnCount+"]"));
        return columnWebElements;
    }

}
