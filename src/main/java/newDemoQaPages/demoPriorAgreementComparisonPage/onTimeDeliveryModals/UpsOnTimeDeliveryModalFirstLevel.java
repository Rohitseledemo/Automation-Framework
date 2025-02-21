package newDemoQaPages.demoPriorAgreementComparisonPage.onTimeDeliveryModals;

import basePages.NewDemoBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.WebDriverWaits;

import java.util.ArrayList;
import java.util.List;

public class UpsOnTimeDeliveryModalFirstLevel extends NewDemoBasePage {
    WebDriverWaits wait;
    private float upsFirstModalTotalRowCount;

    public UpsOnTimeDeliveryModalFirstLevel(){
        this.columnDataXpath = By.xpath("//div[@data-testid='PriorAgreementComparisonUPSOntimeDeliveryModal']//tbody//tr//td");
        this.dataTestId = By.xpath("//div[@data-testid='PriorAgreementComparisonUPSOntimeDeliveryModal']" +
                "//thead//tr//td");
        this.tableDataLoadWait = By.xpath("//div[@data-testid='PriorAgreementComparisonUPSOntimeDeliveryModal']//tbody");
    }
    public float getUpsFirstModalTotalRowCount() {
        return upsFirstModalTotalRowCount;
    }

    @Override
    public int headerClick(String headerName){
        int headerColumnCount = 0;
        wait = new WebDriverWaits(this.getBrowser());
        wait.waitForPresenceOfElement(30,tableDataLoadWait);
        List<WebElement> headerNames = this.getBrowser().findElements(dataTestId);
        for (int i = 0; i < headerNames.size(); i++) {
            try {
                if (headerNames.get(i).getText().equalsIgnoreCase(headerName)) {
                    headerColumnCount = i + 1;
                    //commented bcz this table header doesn't need to be clicked.
//                    headerNames.get(i).click();
                    break;
                }
            } catch (Exception e) {
                System.out.println("Input Element not found in headerClick method");
            }
        }
        return headerColumnCount;
    }

    @Override
    public ArrayList<Float> columnData(int headerColumnCount) {
        wait = new WebDriverWaits(this.getBrowser());
        ArrayList<Float> columnValues = new ArrayList<Float>();
        List<WebElement> columnWebElements;

        By customXpath = this.generateDynamicXPath(columnDataXpath,headerColumnCount);
        columnWebElements = this.getBrowser().findElements(customXpath);
        System.out.println("Elements size - "+columnWebElements.size());
        this.upsFirstModalTotalRowCount = Float.parseFloat(columnWebElements.get
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
