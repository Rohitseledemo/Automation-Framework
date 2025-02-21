package newDemoQaPages;

import basePages.NewDemoBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.JavaScriptExecutorMethods;
import utilities.WebDriverWaits;

import java.util.List;

public class ClaimsPage extends NewDemoBasePage {
    WebDriverWaits wait;
    JavaScriptExecutorMethods javaScript;

    By viewAllTransactionBtn;
    By downloadPdfBtn;
    By claimsPaidAmount;
    By totalClaimsAmount;
    By pageLoadWait;
    By averagePaidAmount;
    By claimsPaidVsDeniedChart;
    By claimsPaidGraph;

    public ClaimsPage(){
        this.dateDropdown = By.xpath("//div[@class='dropdown']//button[contains(@class,'border border-" +
                "primary d-flex w-100 justify-content-between align-items-center')]");
        this.dateDropdownElements = By.xpath("//div[contains(@class,'border-0 shadow rounded-3 _')]//a//i");
        this.pageLoadWait = By.xpath("//div[@class='bg-light w-100 rounded p-4']//span[@class='d-block " +
                "fw-semibold fs-4 mb-4']//img[@src='/image/shipplug/claim/paid-sign.svg']");
        this.pagination = By.xpath("//ul[@role='navigation']//a[@class='page-link text-center rounded']");
        this.showEntriesDropdown = By.xpath("//button[contains(@class,' d-flex justify-content-between " +
                "align-items-center gap-2 w-100 dropdown-toggle')]");
        this.showEntriesDropdownElements = By.xpath("//div[contains(@class,'dropdown-menu show')]//a");
        this.dataTestId = By.xpath("//thead[@class='sticky-header shadow-sm']//tr//th//div[@class='custom-header']");
        this.viewAllTransactionBtn = By.xpath("//button[@aria-controls='claim-txn-table']");
        this.serialNos = By.xpath("//tbody//tr//td[@class='align-middle text-wrap custom-header'][1]");
        this.tableDataLoadWait = By.xpath("//tbody//tr//td[@class='align-middle text-wrap custom-header']");
        this.downloadPdfBtn = By.xpath("//button[text()='Download PDF']");
        this.downloadButton = By.xpath("//button[text()='Download CSV']");
        this.claimsPaidAmount = By.xpath("//div[@class='d-flex align-items-start pt-2']//span[@class='" +
                "fw-semibold fs-2 text-success ms-auto d-flex align-items-center gap-2']");
        this.totalClaimsAmount = By.xpath("//span[@class='fw-semibold fs-2 text-dark ms-auto d-flex " +
                "align-items-center']");
        this.averagePaidAmount = By.xpath("//span[@class='fs-1 fw-medium']");
        this.claimsPaidGraph = By.xpath("//div[@id='reactgooglegraph-2']");
        this.claimsPaidVsDeniedChart = By.xpath("//div[@class='d-flex flex-column align-items-center']");
    }

    @Override
    public int paginationClick(int pageNo) {
        int pageClickedNo;
        wait = new WebDriverWaits(this.getBrowser());
        javaScript = new JavaScriptExecutorMethods(this.getBrowser());

        wait.waitForPresenceOfElement(60, pagination);
        javaScript.scrollIntoViewWebElement(this.getBrowser().findElement(pagination));

        List<WebElement> paginationList = this.getBrowser().findElements(pagination);
        if (pageNo<=paginationList.size()) {
            javaScript.clickWebElement(this.getBrowser().findElements(pagination).get(pageNo));
            pageClickedNo = pageNo;
        }
        else {
            javaScript.clickWebElement(paginationList.get(0));
            pageClickedNo = 1;
        }
        return pageClickedNo;
    }

    public void clickViewAllTransactionBtn(){
        wait = new WebDriverWaits(this.getBrowser());
        javaScript = new JavaScriptExecutorMethods(this.getBrowser());

        wait.waitForPresenceOfElement(30,viewAllTransactionBtn);
        javaScript.clickWebElement(this.getBrowser().findElement(viewAllTransactionBtn));
    }

    @Override
    public int headerClick(String headerName){
        int headerColumnCount = 0;
        wait = new WebDriverWaits(this.getBrowser());
        javaScript = new JavaScriptExecutorMethods(this.getBrowser());
        wait.waitForPresenceOfElement(60,dataTestId);
        javaScript.scrollIntoViewWebElement(this.getBrowser().findElement(dataTestId));

        List<WebElement> headerNames = this.getBrowser().findElements(dataTestId);
        for (int i = 0; i < headerNames.size(); i++) {
            try {
                if (headerNames.get(i).getText().equalsIgnoreCase(headerName)) {
                    headerColumnCount = i + 1;
                    headerNames.get(i).click();
                    break;
                }
            } catch (Exception e) {
                System.out.println("Input Element not found in headerClick method");
                break;
            }
        }
        return headerColumnCount;
    }

    public boolean testDownloadPdfFunctionality() {
        boolean isDisplayed = false;
        String initialValue;
        wait = new WebDriverWaits(this.getBrowser());
        wait.waitForPresenceOfElement(30, pageLoadWait);
        try {
            initialValue = this.getBrowser().findElement(downloadPdfBtn).getAttribute("data-download-status");
//            System.out.println("Initial Value - "+initialValue);
            this.getBrowser().findElement(downloadPdfBtn).click();
            isDisplayed = wait.waitForAttributeValueToChange(20,downloadPdfBtn,initialValue);
        }
        catch (Exception ignored){
            System.out.println("DOWNLOAD BUTTON NOT FOUND");
        }
        return isDisplayed;
    }

    @Override
    public boolean testDownloadButtonFunctionality2() {
        boolean isDisplayed = false;
        String initialValue, finalValue;
        wait = new WebDriverWaits(this.getBrowser());
        wait.waitForPresenceOfElement(30, pageLoadWait);
        try {
            initialValue = this.getBrowser().findElement(downloadButton).getAttribute("data-download-status");
            this.getBrowser().findElement(downloadButton).click();
            isDisplayed = wait.waitForAttributeValueToChange(20, downloadButton, initialValue);
        }
        catch (Exception ignored){
            System.out.println("DOWNLOAD BUTTON NOT FOUND");
        }
        return isDisplayed;
    }

    public boolean claimsPaidAmountNotEmpty(){
        boolean result = true;
        float claimsPaidValue;
        wait = new WebDriverWaits(this.getBrowser());
        wait.waitForPresenceOfElement(30, pageLoadWait);
        claimsPaidValue = Float.parseFloat(this.getBrowser().findElement(claimsPaidAmount).getText().replace("$","").
                replace(",",""));
        if (claimsPaidValue<=0){
            result = false;
        }
        return result;
    }

    public boolean totalClaimsAmountNotEmpty(){
        boolean result = true;
        float claimsPaidValue;
        wait = new WebDriverWaits(this.getBrowser());
        wait.waitForPresenceOfElement(30, pageLoadWait);
        claimsPaidValue = Float.parseFloat(this.getBrowser().findElement(totalClaimsAmount).getText().replace("$","").
                replace(",",""));
        if (claimsPaidValue<=0){
            result = false;
        }
        return result;
    }

    public boolean averagePaidAmountNotEmpty(){
        boolean result = true;
        float claimsPaidValue;
        wait = new WebDriverWaits(this.getBrowser());
        wait.waitForPresenceOfElement(30, pageLoadWait);
        claimsPaidValue = Float.parseFloat(this.getBrowser().findElement(averagePaidAmount).getText().replace("$","").
                replace(",",""));
        if (claimsPaidValue<=0){
            result = false;
        }
        return result;
    }

    public boolean claimsPaidVsDeniedChartVisibility(){
        wait = new WebDriverWaits(this.getBrowser());
        wait.waitForPresenceOfElement(30, pageLoadWait);
        return this.getBrowser().findElement(claimsPaidVsDeniedChart).isDisplayed();
    }
    public boolean claimsPaidGraphVisibility(){
        wait = new WebDriverWaits(this.getBrowser());
        wait.waitForPresenceOfElement(30, claimsPaidGraph);
        return this.getBrowser().findElement(claimsPaidGraph).isDisplayed();
    }


}
