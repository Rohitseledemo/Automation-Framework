package newDemoQaPages.demoPriorAgreementComparisonPage.onTimeDeliveryModals;

import baseClass.NewDemoBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.WebDriverWaits;

import java.util.ArrayList;
import java.util.List;

public class FedExOnTimeDeliveryModalFirstLevel extends NewDemoBasePage {
    WebDriverWaits wait;
    private float fedExFirstModalTotalRowCount;

    public FedExOnTimeDeliveryModalFirstLevel(){
        this.dataTestId = By.xpath("//div[@data-testid='PriorAgreementComparisonFedExOntimeDeliveryModal']" +
                "//thead//tr//td");
        this.tableDataLoadWait = By.xpath("//div[@data-testid='PriorAgreementComparisonFedExOntime" +
                "DeliveryModal']//tbody");
    }
    public float getFedExFirstModalTotalRowCount() {
        return fedExFirstModalTotalRowCount;
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

        wait.waitForVisibilityOfElement(10,tableDataLoadWait);
        columnWebElements = this.getBrowser().findElements(By.xpath("//div[@data-testid='PriorAgreementComp" +
                "arisonFedExOntimeDeliveryModal']//tbody//tr//td["+headerColumnCount+"]"));
        this.fedExFirstModalTotalRowCount = Float.parseFloat(columnWebElements.get
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