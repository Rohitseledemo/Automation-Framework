package newDemoQaPages.demoPriorAgreementComparisonPage.totalSavings;

import newDemoQaPages.BaseModal;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.WebDriverWaits;

import java.util.ArrayList;
import java.util.List;

public class TransportationSavingsModalFirstLevel extends BaseModal {
    WebDriverWaits wait;

    private float transModalFirstModalTotalRowCount;


    public TransportationSavingsModalFirstLevel(){
        this.columnDataXpath = By.xpath("//div[@data-testid='published-charge-modal']//tbody//tr//td[@class" +
                "='align-middle text-wrap custom-header']");
        this.dataTestId = By.xpath("//thead[@class='sticky-header shadow-sm']//th");
    }

    public float getTransModalFirstModalTotalRowCount() {
        return transModalFirstModalTotalRowCount;
    }
    @Override
    public ArrayList<Float> columnData(int headerColumnCount) {
        wait = new WebDriverWaits(this.getBrowser());
        ArrayList<Float> columnValues = new ArrayList<Float>();
        List<WebElement> columnWebElements;
        By customLocator = this.generateDynamicXPath(columnDataXpath,headerColumnCount);

        wait.waitForNumberOfElementsToBeMoreThan(10,customLocator,2);
        columnWebElements = this.getBrowser().findElements(customLocator);
        this.transModalFirstModalTotalRowCount = Float.parseFloat(columnWebElements.get
                (columnWebElements.size()-1).getText().replace("$","").replace(",",""));
        for (int i=0;i<columnWebElements.size()-1;i++) {
            float value = Float.parseFloat(columnWebElements.get(i).getText().replace("$", "")
                    .replace(",",""));
            columnValues.add(value);
        }
//        for printing arrayList data
//        for (Float columnValue : columnValues) {
//            System.out.println(columnValue);
//        }
        return columnValues;
    }

}
