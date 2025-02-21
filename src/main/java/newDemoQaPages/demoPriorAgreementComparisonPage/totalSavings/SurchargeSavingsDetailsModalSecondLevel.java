package newDemoQaPages.demoPriorAgreementComparisonPage.totalSavings;

import newDemoQaPages.BaseModal;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.WebDriverWaits;

import java.util.ArrayList;
import java.util.List;

public class SurchargeSavingsDetailsModalSecondLevel extends BaseModal {
    WebDriverWaits wait;

    public SurchargeSavingsDetailsModalSecondLevel(){
        this.columnDataXpath = By.xpath("//div[@data-testid='prior-agreement-surcharge-detail-service-table" +
                "-modal']//tbody//tr//td[@class='align-middle text-wrap custom-header']");
        this.columnDataWebElementsXpath= By.xpath("//div[@data-testid='prior-agreement-surcharge-detail-" +
                "service-table-modal']//tbody//tr//td");
        this.dataTestId = By.xpath("//div[@data-testid='prior-agreement-surcharge-detail-service-surcharge" +
                "-modal']//thead[@class='sticky-header shadow-sm']//tr//th//div[@class='custom-header']");
        this.serialNos = By.xpath("//div[@data-testid='prior-agreement-surcharge-detail-service-table-" +
                "modal']//tbody//tr//td[@class='align-middle text-wrap custom-header'][1]");
        this.tableDataLoadWait = By.xpath("//div[@data-testid='prior-agreement-surcharge-detail-service-" +
                "surcharge-modal']//tbody//tr//td");
        this.closeModalBtn = By.xpath("//div[@data-testid='prior-agreement-surcharge-detail-service-table-" +
                "modal']//button[@class='btn-close']");
    }

    @Override
    public ArrayList<Float> columnData(int headerColumnCount) {
        ArrayList<Float> columnValues = new ArrayList<Float>();
        List<WebElement> columnWebElements;

        By customXpath = this.generateDynamicXPath(columnDataXpath,headerColumnCount);
        columnWebElements = this.getBrowser().findElements(customXpath);
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
        By customXpath = this.generateDynamicXPath(columnDataWebElementsXpath,columnCount);
        columnWebElements = this.getBrowser().findElements(customXpath);
        return columnWebElements;
    }

}
