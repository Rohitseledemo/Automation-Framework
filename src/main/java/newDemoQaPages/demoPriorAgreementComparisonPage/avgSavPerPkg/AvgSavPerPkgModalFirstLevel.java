package newDemoQaPages.demoPriorAgreementComparisonPage.avgSavPerPkg;

import newDemoQaPages.BaseModal;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.JavaScriptExecutorMethods;
import utilities.WebDriverWaits;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AvgSavPerPkgModalFirstLevel extends BaseModal {
    WebDriverWaits wait;
    JavaScriptExecutorMethods javaScript;
    private float avgSavFirstModalTotalRowCount;

    private By serviceNameDropdown;
    private By serviceNameDropdownElements;
    By columnData;

    public AvgSavPerPkgModalFirstLevel(){
        this.columnDataWebElementsXpath=By.xpath("//div[@data-testid='average-saving-per-package-modal']" +
                "//tbody//tr//td//div[@class='text-link h6']");
        this.columnDataXpath = By.xpath("//div[@data-testid='average-saving-per-package-modal']//tbody//tr//td");
      this.dataTestId = By.xpath("//div[@data-testid='average-saving-per-package-modal']//tr//th");
      this.serialNos = By.xpath("//div[@data-testid='surcharge-info']" +
              "//tbody//tr//td[@class='align-middle text-wrap custom-header'][1]");
      this.tableDataLoadWait = By.xpath("//div[@data-testid='average-saving-per-package-modal']" +
              "//div[@class='text-link h6']");
      this.serviceNameDropdown = By.xpath("//div[@data-testid='average-saving-per-package-modal']//button" +
              "[contains(@class,'_Button_co7d3_5 dropdown-toggle btn btn-white btn-sm')]");
      this.serviceNameDropdownElements = By.xpath("//div[contains(@class,'dropdown-menu show')]//a");
      this.carrierServiceDropdown = By.xpath("//div[@data-testid='average-saving-per-package-modal']" +
              "//button[@id='dropdown-basic']");
      this.carrierServiceDropdownElements = By.xpath("//div[contains(@class,'dropdown-menu show')]//a");
      this.downloadButton = By.xpath("//div[@data-testid='average-saving-per-package-modal']" +
              "//button[@data-download-status='ideal']");
      this.emptyClick = By.xpath("//div[@data-testid='average-saving-per-package-modal']" +
              "//button[contains(@class,'_Button_co7d3_5 dropdown-toggle ')]");
      this.columnData = By.xpath("//div[@data-testid='average-saving-per-package-modal']//tbody//tr//td");
    }

    public By getServiceNameDropdown(){
        return serviceNameDropdown;
    }
    public By getServiceNameDropdownElements(){
        return serviceNameDropdownElements;
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
        By customXpath = this.generateDynamicXPath(columnDataXpath,headerColumnCount);

        wait.waitForStalenessOfWebElement(5,this.getBrowser().findElement(customXpath));
        columnWebElements = this.getBrowser().findElements(customXpath);
        List<String> columnTexts = columnWebElements.stream()
                .map(element -> element.getText().replace("$", "").replace(",", ""))
                .collect(Collectors.toList());

        try {
            this.avgSavFirstModalTotalRowCount = Float.parseFloat(columnTexts.get(columnTexts.size() - 1));
        } catch (NumberFormatException e) {
            System.err.println("Error parsing total row value: " + columnTexts.get(columnTexts.size() - 1));
            this.avgSavFirstModalTotalRowCount = 0.0f; // Assigning default value if parsing fails
        }
        for (int i=0;i<columnTexts.size()-1;i++) {
            try {
                float value = Float.parseFloat(columnTexts.get(i));
                columnValues.add(value);
            } catch (NumberFormatException e) {
                // Handling parsing errors gracefully
                System.out.println("Error parsing value at index " + i + ": " + columnTexts.get(i));}}
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
        columnWebElements = this.getBrowser().findElements(columnDataWebElementsXpath);
        return columnWebElements;
    }

    @Override
    public void getEmptyClickOperation(){
        wait = new WebDriverWaits(this.getBrowser());
        this.getBrowser().findElement(emptyClick).click();
        wait.waitForNumberOfElementsToBeLessThan(10,tableDataLoadWait,3);
    }
}
