package newDemoQaPages.demoPriorAgreementComparisonPage;

import newDemoQaPages.BaseModal;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import utilities.JavaScriptExecutorMethods;
import utilities.WebDriverWaits;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class NewInvoiceModal extends BaseModal {
    private final Logger logger = Logger.getLogger(PackageProfileModal.class.getName());
    WebDriverWaits wait;
    JavaScriptExecutorMethods javaScript;
    By totalRowXpath;
    private String totalRowCount;
    private By spendAndVolumeTab;
    private By surchargeTrendTab;
    private By spendByZone;

    public NewInvoiceModal() {
        this.spendAndVolumeTab = By.xpath("//div[@class='d-flex flex-row justify-content-center gap-4']" +
                "//button[text()='Spend and Volume']");
        this.surchargeTrendTab = By.xpath("//div[@class='d-flex flex-row justify-content-center gap-4']" +
                "//button[text()='Surcharge Trend']");
        this.spendByZone = By.xpath("//div[@class='d-flex flex-row justify-content-center gap-4']" +
                "//button[text()='Spend By Zone']");
        this.totalRowXpath = By.xpath("//div[@data-testid='prior-agreement-total-of-uploaded-invoice']" +
                "//tbody//tr//td[@class='align-middle fw-bold']");
        this.columnDataXpath = By.xpath("//div[@data-testid='prior-agreement-total-of-uploaded-invoice']" +
                "//tbody//tr//td[@class='align-middle']");
        this.dataTestId = By.xpath("//div[@data-testid='prior-agreement-total-of-uploaded-invoice']" +
                "//table//thead//tr//th//strong");
        this.parentTabs = By.xpath("//div[@data-testid='prior-agreement-total-of-uploaded-invoice']" +
                "//div[@class='d-flex flex-row justify-content-center gap-4']//button");
        this.childTabs = By.xpath("//div[@data-testid='prior-agreement-total-of-uploaded-invoice']" +
                "//div[@class='d-flex flex-row justify-content-center align-items-center']//button");
        this.tableDataLoadWait = By.xpath("//div[@data-testid='prior-agreement-total-of-uploaded-invoice']" +
                "//table[@class='x-table-bordered table table-sm table-striped']");
        this.downloadButton = By.xpath("//div[@data-testid='prior-agreement-total-of-uploaded-invoice']" +
                "//button[@icon='bi bi-cloud-download']");
    }

    public void spendAndVolumeTabClick(){
        wait = new WebDriverWaits(this.getBrowser());
        wait.waitForElementToBeClickable(10,spendAndVolumeTab);
        this.getBrowser().findElement(spendAndVolumeTab).click();
    }
    public void surchargeTrendTabClick(){
        wait = new WebDriverWaits(this.getBrowser());
        wait.waitForElementToBeClickable(10,surchargeTrendTab);
        this.getBrowser().findElement(surchargeTrendTab).click();
    }
    public void spendByZoneTabClick(){
        wait = new WebDriverWaits(this.getBrowser());
        wait.waitForElementToBeClickable(10,spendByZone);
        this.getBrowser().findElement(spendByZone).click();
    }

    @Override
    public boolean allTabsDataValidation() {
        boolean result = true;
        int failCount=0;

        wait = new WebDriverWaits(this.getBrowser());
        wait.waitForPresenceOfElement(7, parentTabs);

        int parentTabElementsSize = this.getBrowser().findElements(parentTabs).size();
        for (int i = 0; i < parentTabElementsSize; i++) {
            List<WebElement> parentTabElements = this.getBrowser().findElements(parentTabs);
            String parentName = parentTabElements.get(i).getText();

            if (parentName.equalsIgnoreCase("Zone Trends")) {
                parentTabElements.get(i).click();
                if(!childTabsIterator(childTabs)){
                failCount++;
                }}

            else {
            parentTabElements.get(i).click();
            wait.waitForPresenceOfElement(5,tableDataLoadWait);
            }

            if (isNoDataFound()) {
                failCount++;
                logger.info("No Record Found in " + parentTabElements.get(i).getText());
            }
            if (failCount > 0) {
                result = false;
            }}
            return result;
        }

    public boolean validateAllTabsTable (String headerNameToCalc){
        int column;
        int failCount = 0;
        List<Float> values;
        String sum = null;
        boolean equal = true;

        wait = new WebDriverWaits(this.getBrowser());
        javaScript = new JavaScriptExecutorMethods(this.getBrowser());
        wait.waitForPresenceOfElement(40, parentTabs);

        int parentTabElementsSize = this.getBrowser().findElements(parentTabs).size();
        for (int i = 0; i < parentTabElementsSize-1; i++) {
            try {
            List<WebElement> parentTabElements = this.getBrowser().findElements(parentTabs);
            wait.waitForElementToBeClickable(20,parentTabs);
            try {
                parentTabElements.get(i).click();
            }catch (ElementClickInterceptedException e) {
                System.out.println("Element click intercepted. Using JavaScript click.");
                javaScript.clickWebElement(parentTabElements.get(i));
            }
            wait.waitForPresenceOfElement(40, tableDataLoadWait);
            column = this.headerClick(headerNameToCalc);
            values = this.columnData(column);
            sum = String.valueOf(calculateSum(values));
            if (!sum.equalsIgnoreCase(totalRowCount)){
                   failCount++ ;}
        } catch (StaleElementReferenceException e){
                System.out.println("Stale element encountered. Retrying...");
                i--;}
        }
        if(failCount>0){
            equal = false;}
        return equal;
        }

    public boolean spendAndVolumeTabValidation(String tableHeaderName){
        int column;
        List<Float> values;
        String sum = null;
        wait = new WebDriverWaits(this.getBrowser());
        wait.waitForPresenceOfElement(20, tableDataLoadWait);
        try {
            column = this.headerClick(tableHeaderName);
            values = this.columnData(column);
            sum = String.valueOf(calculateSum(values));
            if (!sum.equalsIgnoreCase(totalRowCount)) {
               return false;
            }
        } catch (StaleElementReferenceException e){
        System.out.println("Stale element encountered. Retrying...");
        }
        return true;
    }

    @Override
    public ArrayList<Float> columnData(int headerColumnCount) {
        ArrayList<Float> columnValues = new ArrayList<Float>();
        List<WebElement> columnWebElements;
        By customXpath = this.generateDynamicXPath(columnDataXpath,headerColumnCount);
        wait.waitForVisibilityOfElement(20,customXpath);
        columnWebElements = this.getBrowser().findElements(customXpath);

        for (WebElement countValue : columnWebElements) {
            float value = Float.parseFloat(countValue.getText().replace("$", "")
                    .replace(",",""));
            columnValues.add(value);}

        By totalRowCustomXpath = this.generateDynamicXPath(totalRowXpath,headerColumnCount);
        WebElement totalRow = this.getBrowser().findElement(totalRowCustomXpath);
        this.totalRowCount = totalRow.getText().replace("$","").replace(",","");
        return columnValues;
}


    public void parentTabsIterator(By parentTabs, int index) {
        wait = new WebDriverWaits(this.getBrowser());
        wait.waitForPresenceOfElement(5, parentTabs);
        List<WebElement> parentTabElements = getBrowser().findElements(parentTabs);
        int size = parentTabElements.size();
        if (index >= size) {
            index = size - 1;}

        if (index >= 0) {
            parentTabElements.get(index).click();}
        else {
            System.err.println("Invalid index: " + index + ". Available indices: 0-" + (size - 1));}
    }

    @Override
    public boolean testDownloadButtonFunctionality2() {
        boolean isDisplayed = false;
        String initialValue;
        wait = new WebDriverWaits(this.getBrowser());
        wait.waitForElementToBeClickable(50, downloadButton);
        try {
            initialValue = this.getBrowser().findElement(downloadButton).getAttribute("data-download-status");
//            System.out.println("Initial Value - "+initialValue);
            this.getBrowser().findElement(downloadButton).click();
            isDisplayed = wait.waitForAttributeValueToChange(20,downloadButton,initialValue);
        }
        catch (Exception ignored){
            System.out.println("DOWNLOAD BUTTON NOT FOUND");
        }
        return isDisplayed;
    }



}




