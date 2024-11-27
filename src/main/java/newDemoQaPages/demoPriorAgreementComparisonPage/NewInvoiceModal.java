package newDemoQaPages.demoPriorAgreementComparisonPage;

import newDemoQaPages.BaseModal;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.JavaScriptExecutorMethods;
import utility.WebDriverWaits;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class NewInvoiceModal extends BaseModal {
    private final Logger logger = Logger.getLogger(PackageProfileModal.class.getName());
    WebDriverWaits wait;
    JavaScriptExecutorMethods javaScript;
    private String totalRowCount;

    public NewInvoiceModal() {
        this.dataTestId = By.xpath("//div[@data-testid='prior-agreement-total-of-uploaded-invoice']" +
                "//table//thead//tr//th//strong");
        this.parentTabs = By.xpath("//div[@data-testid='prior-agreement-total-of-uploaded-invoice']" +
                "//div[@class='d-flex flex-row justify-content-center gap-4']//button");
        this.childTabs = By.xpath("//div[@data-testid='prior-agreement-total-of-uploaded-invoice']" +
                "//div[@class='d-flex flex-row justify-content-center align-items-center']//button");
        this.tableDataLoadWait = By.xpath("//div[@data-testid='prior-agreement-total-of-uploaded-invoice']" +
                "//table[@class='x-table-bordered table table-sm table-striped']");
        this.downloadButton = By.xpath("//div[@data-testid='prior-agreement-total-of-uploaded-invoice']" +
                "//button[@class=' d-flex justify-content-between align-items-center gap-2 btn btn-primary']");
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
        wait.waitForPresenceOfElement(40, parentTabs);

        int parentTabElementsSize = this.getBrowser().findElements(parentTabs).size();
        for (int i = 0; i < parentTabElementsSize-1; i++) {
            List<WebElement> parentTabElements = this.getBrowser().findElements(parentTabs);
            parentTabElements.get(i).click();
            wait.waitForPresenceOfElement(40, tableDataLoadWait);
            column = this.headerClick(headerNameToCalc);
            values = this.columnData(column);
            sum = String.valueOf(calculateSum(values));
            if (!sum.equalsIgnoreCase(totalRowCount)){
                   failCount++ ;}
        }
        if(failCount>0){
            equal = false;}
        return equal;
        }

    @Override
    public ArrayList<Float> columnData(int headerColumnCount) {
        ArrayList<Float> columnValues = new ArrayList<Float>();
        List<WebElement> columnWebElements;
        // the table used here has //tbody indexing different than the //thead that is why below line of code was used.
//        int realHeaderColumn = headerColumnCount-2;
        columnWebElements = this.getBrowser().findElements(By.xpath("//div[@data-testid='" +
                "prior-agreement-total-of-uploaded-invoice']//tbody//tr//td[@class='align-middle']" +
                "["+headerColumnCount+"]"));
        for (WebElement countValue : columnWebElements) {
            float value = Float.parseFloat(countValue.getText().replace("$", "")
                    .replace(",",""));
            columnValues.add(value);
        }
        WebElement totalRow = this.getBrowser().findElement(By.xpath("//div[@data-testid='" +
                "prior-agreement-total-of-uploaded-invoice']//tbody//tr//td" +
                "[@class='align-middle fw-bold']["+headerColumnCount+"]"));
        this.totalRowCount = totalRow.getText().replace("$","").replace(",","");
        return columnValues;
}


    public void parentTabsIterator(By parentTabs, int index) {
        wait = new WebDriverWaits(this.getBrowser());
        wait.waitForPresenceOfElement(5, parentTabs);
        List<WebElement> parentTabElements = getBrowser().findElements(parentTabs);
        int size = parentTabElements.size();

        if (index >= size) {
            index = size - 1; // Adjust the index to the last element
        }
        int i =0;
        while(i<=index) {
            parentTabElements = this.getBrowser().findElements(parentTabs);
                parentTabElements.get(index).click();
                break;
            }
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




