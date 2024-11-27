package newDemoQaPages.demoPriorAgreementComparisonPage.avgSavPerPkg;

import newDemoQaPages.BaseModal;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.WebDriverWaits;

import java.util.ArrayList;
import java.util.List;

public class AvgSavPerPkgModalFirstLevel extends BaseModal {
    WebDriverWaits wait;
    private float avgSavFirstModalTotalRowCount;
    public AvgSavPerPkgModalFirstLevel(){
      dataTestId = By.xpath("//div[@data-testid='average-saving-per-package-modal']" +
              "//tr[@class='_StickyHeaderSecondary_1csbh_8']//th");
      serialNos = By.xpath("//div[@data-testid='surcharge-info']" +
              "//tbody//tr//td[@class='align-middle text-wrap custom-header'][1]");
      this.tableDataLoadWait = By.xpath("//div[@data-testid='average-saving-per-package-modal']" +
              "//tbody//tr//td[@class='text-link h6']");
      this.carrierServiceDropdown = By.xpath("//div[@data-testid='average-saving-per-package-modal']" +
              "//button[@id='dropdown-basic']");
      this.carrierServiceDropdownElements = By.xpath("//div[contains(@class,'dropdown-menu show')]//a");
    }

    public float getAvgSavFirstModalTotalRowCount() {
        return avgSavFirstModalTotalRowCount;
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

        columnWebElements = this.getBrowser().findElements(By.xpath("//div[@data-testid='average-saving-" +
                "per-package-modal']//tbody//tr//td["+headerColumnCount+"]"));
        this.avgSavFirstModalTotalRowCount = Float.parseFloat(columnWebElements.get
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

    @Override
    public List<WebElement> columnDataWebElements(int columnCount){
        wait = new WebDriverWaits(this.getBrowser());
        List<WebElement> columnWebElements;
        columnWebElements = this.getBrowser().findElements(By.xpath("//div[@data-testid='average-saving-" +
                "per-package-modal']//tbody//tr//td["+columnCount+"]"));
        return columnWebElements;
    }
}
