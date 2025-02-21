package newDemoQaPages.demoPriorAgreementComparisonPage.totalSavings;

import newDemoQaPages.BaseModal;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.JavaScriptExecutorMethods;
import utilities.WebDriverWaits;

import java.util.ArrayList;
import java.util.List;

public class SurchargeSavingsSurchargeDetailsModal extends BaseModal {
    WebDriverWaits wait;
    JavaScriptExecutorMethods javaScript;
    private By chooseServiceDropdown;
    private By chooseServiceDropdownElements;

    public By getChooseServiceDropdown(){
        return this.chooseServiceDropdown;
    }
    public By getChooseServiceDropdownElements(){
        return this.chooseServiceDropdownElements;
    }

    public SurchargeSavingsSurchargeDetailsModal(){
        this.columnDataXpath = By.xpath("//div[@data-testid='prior-agreement-surcharge-detail-table-modal']" +
                "//tbody//tr//td[@class='align-middle text-wrap custom-header']");
        this.pagination = By.xpath("//div[@data-testid='prior-agreement-surcharge-detail-table-modal']" +
                "//ul[@role='navigation']//li//a[@class='page-link text-center rounded']");
        this.chooseServiceDropdown = By.xpath("//div[@data-testid='prior-agreement-surcharge-detail-table-modal']" +
                "//button[@id='dropdown-basic']");
        this.chooseServiceDropdownElements = By.xpath("//div[@data-testid='prior-agreement-surcharge-detail" +
                "-table-modal']//div[contains(@class,'dropdown-menu show')]//a");
        this.dataTestId = By.xpath("//div[@data-testid='prior-agreement-surcharge-detail-table-modal']" +
                "//thead[@class='sticky-header shadow-sm']//tr//th//div[@class='custom-header']");
        this.serialNos= By.xpath("//div[@data-testid='prior-agreement-surcharge-detail-table-modal']" +
                "//tbody//tr//td[@class='align-middle text-wrap custom-header'][1]");
        this.tableDataLoadWait = By.xpath("//div[@data-testid='prior-agreement-surcharge-detail-" +
                "table-modal']//tbody//tr//td[@class='align-middle text-wrap custom-header']");
        this.trackingNos = By.xpath("//div[@class='text-center align-middle text-nowrap text-primary cursor-pointer']");

    }

    @Override
    public ArrayList<Float> columnData(int headerColumnCount) {
        wait = new WebDriverWaits(this.getBrowser());
        ArrayList<Float> columnValues = new ArrayList<Float>();
        List<WebElement> columnWebElements;

        wait.waitForVisibilityOfElement(10,spinnerLoad);
        wait.waitForInvisibilityOfElementLocated(10,spinnerLoad);
        By customXpath = this.generateDynamicXPath(columnDataXpath,headerColumnCount);
        columnWebElements = this.getBrowser().findElements(customXpath);
        for (WebElement countValue : columnWebElements) {
            float value = Float.parseFloat(countValue.getText().replace("$", ""));
            columnValues.add(value);}
//        for printing arrayList data
//        for (Float columnValue : columnValues) {
//            System.out.println(columnValue);
//        }
        return columnValues;
    }
    @Override
    public List<WebElement> columnDataWebElements(int columnCount) {
        wait = new WebDriverWaits(this.getBrowser());
        List<WebElement> columnWebElements;
        columnWebElements = this.getBrowser().findElements(By.xpath("//div[@data-testid='prior-agreement-" +
                "surcharge-detail-table-modal']//tbody//tr//td["+columnCount+"]//div"));
        return columnWebElements;
    }
    @Override
    public int anyDropdownIterator(By serviceDropdown, By serviceDropdownElements) {
        int i;
        wait = new WebDriverWaits(this.getBrowser());
        javaScript = new JavaScriptExecutorMethods(this.getBrowser());
        wait.waitForPresenceOfElement(20, tableDataLoadWait);
        WebElement serviceDropdownWebElement =  this.getBrowser().findElement(serviceDropdown);
        javaScript.clickWebElement(serviceDropdownWebElement);

        wait.waitForPresenceOfElement(20, serviceDropdownElements);
        List<WebElement> serviceOptions = this.getBrowser().findElements(serviceDropdownElements);
        i = serviceOptions.size()-2;
        WebElement element = serviceOptions.get(i);
        javaScript.clickWebElement(element);
        return i;
    }
}
