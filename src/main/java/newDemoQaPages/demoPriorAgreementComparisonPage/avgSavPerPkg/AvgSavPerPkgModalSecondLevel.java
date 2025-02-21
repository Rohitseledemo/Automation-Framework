package newDemoQaPages.demoPriorAgreementComparisonPage.avgSavPerPkg;

import newDemoQaPages.BaseModal;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.JavaScriptExecutorMethods;
import utilities.WebDriverWaits;

import java.util.ArrayList;
import java.util.List;

public class AvgSavPerPkgModalSecondLevel extends BaseModal {
    WebDriverWaits wait;
    JavaScriptExecutorMethods javaScript;

    public AvgSavPerPkgModalSecondLevel(){
        this.dataTestId = By.xpath("//div[@data-testid='surcharge-info']" +
                "//thead[@class='sticky-header shadow-sm']//tr//th");
        this.timePeriodDropdown = By.xpath("//div[@data-testid='surcharge-info']//div[text()='Time Period']" +
                "//following-sibling::div//button");
        this.timePeriodDropdownElements = By.xpath("//div[contains(@class,'dropdown-menu show')]//a");
        this.downloadButton = By.xpath("//div[@data-testid='surcharge-info']//button[@data-download-status=" +
                "'ideal']");
    }

    public ArrayList<Float> columnData(int headerColumnCount) {
        wait = new WebDriverWaits(this.getBrowser());
        ArrayList<Float> columnValues = new ArrayList<Float>();
        List<WebElement> columnWebElements;

        wait.waitForVisibilityOfElement(10,spinnerLoad);
        wait.waitForInvisibilityOfElementLocated(10,spinnerLoad);
        columnWebElements = this.getBrowser().findElements(By.xpath("//div[@data-testid='surcharge-info']" +
                "//tbody//tr//td[@class='align-middle text-wrap custom-header'][" + headerColumnCount + "]"));
        for (WebElement countValue : columnWebElements) {
            float value = Float.parseFloat(countValue.getText().replace("$", "")
                    .replace("%","").replace(",",""));
            columnValues.add(value);
        }
//        for printing arrayList data
        for (Float columnValue : columnValues) {
            System.out.println(columnValue);}
        return columnValues;
    }
}
