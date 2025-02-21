package newDemoQaPages.demoPriorAgreementComparisonPage.totalSavings;

import newDemoQaPages.BaseModal;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.JavaScriptExecutorMethods;
import utilities.WebDriverWaits;

import java.util.List;

public class DimensionalWeightImpactModalFirstLevel extends BaseModal {
    WebDriverWaits wait;
    JavaScriptExecutorMethods javaScript;
    By tableHeaderList;
    By tableBody;
    By serviceTypeBtn;
    By tableTitle;
    By minimumChargesPriorVsCurrentText;
    By defaultMonth;
    By dimDetailBtn;

    public DimensionalWeightImpactModalFirstLevel(){
        this.dimDetailBtn = By.xpath("//button[text()='DIM Detail']");
        this.tableHeaderList = By.xpath("//table[@class='x-table-bordered table']//thead//tr//th");
        this.tableBody = By.xpath("//table[@class='x-table-bordered table']//tbody//tr//td//span");
        this.serviceTypeBtn = By.xpath("//button[contains(@class,'undefined d-flex w-100 justify-content" +
                "-between align-items-center gap-1')]");
        this.tableTitle = By.xpath("//h5[@class='my-3 text-capitalize']");
        this.minimumChargesPriorVsCurrentText= By.xpath("//h5[@class=' text-center my-2']");
        this.defaultMonth = By.xpath("//div[contains(@class,'dropdown-menu show')]//a");
        this.serviceDropdown = By.xpath("//div[@data-testid='prior-agreement-dimensional-weight-impact-" +
                "main-modal']//button[contains(@class,'dropdown-toggle btn btn-light')]");
        this.serviceDropdownElements = By.xpath("//div[contains(@class,'dropdown-menu show')]//a");
        this.downloadButton = By.xpath("//div[@data-testid='prior-agreement-dimensional-weight-impact-main" +
                "-modal']//button[@data-download-status='ideal']");
        this.timePeriodDropdown = By.xpath("//div[text()='Time Period']//following-sibling::div//button");
        this.timePeriodDropdownElements = By.xpath("//div[contains(@class,'dropdown-menu show')]//a");

        this.carrierServiceDropdown = By.xpath("//div[@data-testid='prior-agreement-dimensional-weight" +
                "-impact-main-modal']//button[@id='dropdown-basic']");
        this.carrierServiceDropdownElements = By.xpath("//div[contains(@class,'dropdown-menu show')]//a");
    }

    public int getTableColumn(String columnName){
        int columnIndex = 0;
        wait = new WebDriverWaits(this.getBrowser());
        wait.waitForPresenceOfElement(8,tableHeaderList);
        List<WebElement> columnList= this.getBrowser().findElements(tableHeaderList);
        for (int i=0;i<columnList.size();i++){
            String columnText = columnList.get(i).getText();
            if (columnText.equalsIgnoreCase(columnName)){
                 columnIndex = i+1;
                 break;
            }
        }
        System.out.println(columnIndex);
        return columnIndex;
    }
    public void getColumnValues(){
        wait = new WebDriverWaits(this.getBrowser());
        javaScript = new JavaScriptExecutorMethods(this.getBrowser());
        wait.waitForPresenceOfElement(8,tableBody);
        List<WebElement> columnValues = this.getBrowser().findElements(tableBody);
        columnValues.get(1).click();
    }
    public void dimDetailBtnClick(){
        wait = new WebDriverWaits(this.getBrowser());
        wait.waitForElementToBeClickable(30,dimDetailBtn);
        this.getBrowser().findElement(dimDetailBtn).click();
    }

    public void clickOnServiceByName(String serviceName){
        wait = new WebDriverWaits(this.getBrowser());
        wait.waitForPresenceOfElement(8, serviceTypeBtn);
        List<WebElement> serviceBtnList = this.getBrowser().findElements(serviceTypeBtn);
        for (WebElement service:serviceBtnList){
            if (service.getText().equalsIgnoreCase(serviceName)){
                service.click();
                break;
            }
        }
    }

    public boolean minimumChargesTabValidation(){
        wait = new WebDriverWaits(this.getBrowser());
        return wait.waitForPresenceOfElement(10, minimumChargesPriorVsCurrentText);
    }



}
