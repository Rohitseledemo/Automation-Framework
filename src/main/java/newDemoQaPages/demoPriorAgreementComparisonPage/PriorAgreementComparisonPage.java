package newDemoQaPages.demoPriorAgreementComparisonPage;

import basePages.NewDemoBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.JavaScriptExecutorMethods;
import utilities.WebDriverWaits;

import java.util.List;

public class PriorAgreementComparisonPage extends NewDemoBasePage {

    WebDriverWaits wait;
    JavaScriptExecutorMethods javaScript;

    private By totalSavings;
    By transportationSavings;
    By dimensionalWeightImpact;
    By potentialSavingsRefundName;
    By actualSavingsRefundsName;
    By benchmarkingBtn;
    By downloadInvoiceBtn;
    By nicknameAccountsBtn;
    By priorDiscountsBtn;
    By originalInvoice;
    By shipPlugInvoiceDetailBtn;
    By downloadViewBtn;
    By downloadAllBtn;
    By advancedSearchBtn;
    By packageProfileBtn;
    By pricingAgreementBtn;
    By defaultMonth;
    By graphLoadWait;
    By fedExOnTimeDelivery;
    By UPSOnTimeDelivery;

    public By getTotalSavings(){
        return this.totalSavings;
    }

    public PriorAgreementComparisonPage() {
        this.columnDataWebElementsXpath = By.xpath("//tbody//tr//td");
        this.fedExOnTimeDelivery = By.xpath("//div[@class='d-flex align-item s-center']//span[text()='FedEx']");
        this.UPSOnTimeDelivery = By.xpath("//div[@class='d-flex align-item s-center']//span[text()='UPS']");
        this.trendReportTab = By.xpath("//div[@class='col-6 d-flex justify-content-end gap-2']" +
                "//button[text()='Trend Report']");
        this.graphLoadWait = By.xpath("//div[contains(@id,'reactgooglegraph')]//div[@dir='ltr']" +
                "//div//*[name()='svg']//*[name()='g' and contains(@clip-path,'url(https:')]");
        this.pricingAgreementBtn = By.xpath("//button[text()='Pricing Agreement']");
        this.packageProfileBtn = By.xpath("//button[text()='Package Profile']");
        this.advancedSearchBtn = By.xpath("//button[text()='Advanced Search']");
        this.pagination = By.xpath("//ul[@role='navigation']//li//a");
        this.showEntriesDropdown = By.xpath("//button[contains(@class,' d-flex justify-content-between " +
                "align-items-center gap-2 w-100 dropdown-toggle')]");
        this.showEntriesDropdownElements = By.xpath("//div[contains(@class,'dropdown-menu show')]//a");
        this.serialNos = By.xpath("//tbody//tr//td[@class='align-middle text-wrap custom-header'][1]");
        this.tableDataLoadWait = By.xpath("//tbody//tr//td[@class='align-middle text-wrap custom-header']");
        this.downloadViewBtn = By.xpath("//div[@class='d-flex gap-2']//button[text()='Download View']");
        this.downloadAllBtn = By.xpath("//div[@class='d-flex gap-2']//button[text()='Download All']");
        this.dataTestId = By.xpath("//thead[@class='sticky-header shadow-sm']//tr//th");
        this.shipPlugInvoiceDetailBtn = By.xpath("//span[@class='fs-5 text-primary cursor-pointer fw-medium ms-2']");
        this.totalSavings = By.xpath("//span[contains(@class,'fw-semibold fs-2 ms-auto d-flex align-items-" +
                "center cursor-pointer')]");

        this.surchargeSavings = By.xpath("//div[@class='bg-white shadow-sm rounded savings_box yellow_" +
                "border d-flex align-items-center mb-4 cursor-pointer']//span[contains(@class,'d-block fs-22 fw-semibold')]");

        this.transportationSavings = By.xpath("//div[@class='bg-white shadow-sm rounded savings_box d-flex " +
                "align-items-center mb-4 cursor-pointer'] //span[contains(@class,'d-block fs-22 fw-semibold text-success')]");

        this.dimensionalWeightImpact = By.xpath("//div[@class='cursor-pointer bg-white shadow-sm rounded " +
                "savings_box cyan_border d-flex align-items-center']//span[contains(@class,'d-block fs-22 fw-semibold')]");

        this.avgSavingsPerPkgBtn = By.xpath("//span[contains(@class,'cursor-pointer fw-semibold fs-2 ms-" +
                "auto d-flex align-items-center')]");
        this.potentialSavingsRefundName = By.xpath("//div[contains(@class,'refunds_value me-1 " +
                "refund-late-shipment-amount')]");
        this.actualSavingsRefundsName = By.xpath("//div[contains(@class,'cursor-pointer position-absolute" +
                "  bg-white d-flex justify-content-center align-items-center')]");
        this.dateDropdown = By.xpath("//span[@class='dropdown-option ']//img[contains(@src,'calendar_days')]");
        this.dateDropdownElements = By.xpath("//div[contains(@class,'dropdown-menu show')]//a//i");
        this.benchmarkingBtn = By.xpath("//button[text()='Bench Marking']");
        this.priorDiscountsBtn = By.xpath("//button[text()='Prior Discounts']");
        this.downloadInvoiceBtn = By.xpath("//button[text()='Download Invoice']");
        this.nicknameAccountsBtn = By.xpath("//button[text()='Nickname Accounts']");
        this.accountDropdown = By.xpath("//div[@class='me-3 dropdown']//button[contains(@class,'" +
                "dropdown-toggle btn btn-primary')]");
        this.accountDropdownElements = By.xpath("//div[contains(@class,'dropdown-menu show')]//a");
        this.carrierServiceDropdown = By.xpath("//div[@class='dropdown']//button[contains(@class,'dropdown" +
                "-toggle btn btn-primary')]//div[@class='d-flex align-items-center']");
        this.carrierServiceDropdownElements = By.xpath("//div[contains(@class,'dropdown-menu show')]//a");
        this.originalInvoice = By.cssSelector("span[class='fs-22 fw-semibold ms-auto  text-dark']");
        this.newInvoice = By.cssSelector("span[class='fw-semibold fs-2 ms-auto cursor-pointer text-dark ']");
        this.defaultMonth = By.xpath("//div[contains(@class,'dropdown-menu show')]" +
                "//a//i[@class='text-primary bi bi-check-square-fill']");
        this.spinnerLoad = By.xpath("//div[@class='spinner-border spinner-border-sm text-primary']");
    }
    public void fedExOnTimeDeliveryClick(){
        wait = new WebDriverWaits(this.getBrowser());
        javaScript = new JavaScriptExecutorMethods(this.getBrowser());
        wait.waitForPresenceOfElement(20,fedExOnTimeDelivery);
        javaScript.clickWebElement(this.getBrowser().findElement(fedExOnTimeDelivery));
    }

    public void UPSOnTimeDeliveryClick(){
        wait = new WebDriverWaits(this.getBrowser());
        javaScript = new JavaScriptExecutorMethods(this.getBrowser());
        wait.waitForPresenceOfElement(20,UPSOnTimeDelivery);
        javaScript.clickWebElement(this.getBrowser().findElement(UPSOnTimeDelivery));
    }
    public void transportationSavingsClick(){
        wait = new WebDriverWaits(this.getBrowser());
        javaScript = new JavaScriptExecutorMethods(this.getBrowser());
        wait.waitForElementToBeClickable(20,transportationSavings);
        javaScript.clickWebElement(this.getBrowser().findElement(transportationSavings));
    }
    public void advancedSearchBtnClick(){
        wait = new WebDriverWaits(this.getBrowser());
        javaScript = new JavaScriptExecutorMethods(this.getBrowser());
        wait.waitForElementToBeClickable(20,advancedSearchBtn);
        javaScript.clickWebElement(this.getBrowser().findElement(advancedSearchBtn));
    }
    public void packageProfileBtnClick(){
        wait = new WebDriverWaits(this.getBrowser());
        javaScript = new JavaScriptExecutorMethods(this.getBrowser());
        wait.waitForElementToBeClickable(40,packageProfileBtn);
        javaScript.clickWebElement(this.getBrowser().findElement(packageProfileBtn));
    }
    public void pricingAgreementBtnClick(){
        wait = new WebDriverWaits(this.getBrowser());
        javaScript = new JavaScriptExecutorMethods(this.getBrowser());
        wait.waitForElementToBeClickable(20,pricingAgreementBtn);
        javaScript.clickWebElement(this.getBrowser().findElement(pricingAgreementBtn));
    }
    public void benchMarkingBtnClick(){
        wait = new WebDriverWaits(this.getBrowser());
        javaScript = new JavaScriptExecutorMethods(this.getBrowser());
        wait.waitForElementToBeClickable(20,benchmarkingBtn);
        System.out.println("Clicked.??"+javaScript.clickWebElement(this.getBrowser().findElement(benchmarkingBtn)));
    }
    public void priorDiscountsBtnClick(){
        wait = new WebDriverWaits(this.getBrowser());
        javaScript = new JavaScriptExecutorMethods(this.getBrowser());
        wait.waitForElementToBeClickable(20,priorDiscountsBtn);
        javaScript.clickWebElement(this.getBrowser().findElement(priorDiscountsBtn));
    }
    public void nicknameAccountsBtnClick(){
        wait = new WebDriverWaits(this.getBrowser());
        javaScript = new JavaScriptExecutorMethods(this.getBrowser());
        wait.waitForElementToBeClickable(20,nicknameAccountsBtn);
        javaScript.clickWebElement(this.getBrowser().findElement(nicknameAccountsBtn));
    }

    // this function tests multiple download btn in single page
    public boolean multiDownloadButtonFuncTest(String downloadBtnName){
        boolean isDisplayed = false;
        By downloadButton = null;
        String initialValue;
        wait = new WebDriverWaits(this.getBrowser());

        if (downloadBtnName.equalsIgnoreCase("Download Invoice")){
             downloadButton = this.downloadInvoiceBtn;
        } else if (downloadBtnName.equalsIgnoreCase("Download View")) {
             downloadButton = this.downloadViewBtn;
        } else if (downloadBtnName.equalsIgnoreCase("Download All")) {
             downloadButton = this.downloadAllBtn;
        }

        wait.waitForVisibilityOfElement(20, downloadButton);
        wait.waitForElementToBeClickable(20, downloadButton);
        try {
            this.getBrowser().findElement(downloadButton).click();
            wait.waitForPresenceOfElement(40, downloadConfirmationToast);
            isDisplayed = this.getBrowser().findElement(downloadConfirmationToast).isDisplayed();}
        catch (Exception ignored){
            try {
                initialValue = this.getBrowser().findElement(downloadButton).getAttribute("data-download-status");
                System.out.println("Initial Value - "+initialValue);
                this.getBrowser().findElement(downloadButton).click();
                isDisplayed = wait.waitForAttributeValueToChange(50,downloadButton,initialValue);
            }
            catch (Exception e){
                System.out.println("DOWNLOAD BUTTON NOT FOUND");
            }
        }
        return isDisplayed;
    }

    @Override
    public int headerClick(String headerName){
        int headerColumnCount = 0;
        javaScript = new JavaScriptExecutorMethods(this.getBrowser());
        wait = new WebDriverWaits(this.getBrowser());
        wait.waitForPresenceOfElement(40,downloadViewBtn);
        javaScript.scrollIntoViewWebElement(this.getBrowser().findElement(downloadViewBtn));
        wait.waitForPresenceOfElement(40,dataTestId);

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

    @Override
    public boolean pageSerialNoValidator(int pageNo){
        boolean correctValues = false;
        wait = new WebDriverWaits(this.getBrowser());
        wait.waitForPresenceOfElement(30, tableDataLoadWait);
        int lastSerialNoIndex = this.getBrowser().findElements(serialNos).size()-1;
        String lastSerialNo = this.getBrowser().findElements(serialNos).get(lastSerialNoIndex).getText();
        try{
//            System.out.println("Last Serial Nos- "+lastSerialNo);
            wait.waitForSerialNoToChange(10,serialNos,lastSerialNo);
        }
        catch (Exception e){
            wait.waitForValueToChange(30,serialNos,lastSerialNo);
        }
        List<WebElement> columnWebElements;
        columnWebElements = this.getBrowser().findElements(serialNos);
        int lastValue = columnWebElements.size() - 1;
        int sNumVal = Integer.parseInt(columnWebElements.get(lastValue).getText());
        System.out.println("sNumVal - "+sNumVal);
        //this 60 value is exclusive for prior agreement page table since it contains 60 rows in one pagination
        if (sNumVal == pageNo * 20) {
            correctValues = true;
        }
        return correctValues;
    }
    @Override
    public boolean showEntriesSerialNoValidator(int showEntries){
        boolean correctValues = false;
        wait = new WebDriverWaits(this.getBrowser());
        wait.waitForPresenceOfElement(30, tableDataLoadWait);
        int lastSerialNoIndex = this.getBrowser().findElements(serialNos).size()-1;
        String lastSerialNo = this.getBrowser().findElements(serialNos).get(lastSerialNoIndex).getText();
        try{
            System.out.println("Last Serial Nos- "+lastSerialNo);
            wait.waitForSerialNoToChange(10,serialNos,lastSerialNo);
        }
        catch (Exception e){
            wait.waitForValueToChange(30,serialNos,lastSerialNo);
        }

        List<WebElement> columnWebElements;
        columnWebElements = this.getBrowser().findElements(serialNos);
        int lastValue = columnWebElements.size() - 1;
        int sNumVal = Integer.parseInt(columnWebElements.get(lastValue).getText());

        if (sNumVal==showEntries) {
            correctValues = true;
        }
        return correctValues;
    }
    @Override
    public int anyDropdownIterator(By showEntriesDropdown, By showEntriesDropdownElements) {
        return super.anyDropdownIterator(showEntriesDropdown,showEntriesDropdownElements);
    }
    @Override
    public List<WebElement> columnDataWebElements(int columnCount) {
        wait = new WebDriverWaits(this.getBrowser());
        List<WebElement> columnWebElements;
        By customXpath = this.generateDynamicXPath(columnDataWebElementsXpath,columnCount);
        columnWebElements = this.getBrowser().findElements(customXpath);
        return columnWebElements;
    }

    public void shipPlugInvoiceClick(){
        wait = new WebDriverWaits(this.getBrowser());
        javaScript = new JavaScriptExecutorMethods(this.getBrowser());
        wait.waitForPresenceOfElement(30,shipPlugInvoiceDetailBtn);
        javaScript.clickWebElement(this.getBrowser().findElement(shipPlugInvoiceDetailBtn));
    }

    public boolean totalSavingsClick() {
        wait = new WebDriverWaits(this.getBrowser());
        wait.waitForPresenceOfElement(40, totalSavings);
        this.getBrowser().findElement(totalSavings).click();
        wait.waitForPresenceOfElement(40, By.cssSelector("div[class='modal-title h4']"));
        String text = this.getBrowser().findElement(By.cssSelector("div[class='modal-title h4']")).getText();
        return text.equalsIgnoreCase("Total Savings");
    }

    public void newInvoiceClick() {
        wait = new WebDriverWaits(this.getBrowser());
        wait.waitForPresenceOfElement(40, newInvoice);
        this.getBrowser().findElement(newInvoice).click();
    }

    public void surchargeSavingsClick() {
        javaScript = new JavaScriptExecutorMethods(this.getBrowser());
        wait = new WebDriverWaits(this.getBrowser());
        wait.waitForPresenceOfElement(40, surchargeSavings);
        javaScript.clickWebElement(this.getBrowser().findElement(surchargeSavings));
    }

    public void dimensionalWeightImpactClick() {
        wait = new WebDriverWaits(this.getBrowser());
        javaScript = new JavaScriptExecutorMethods(this.getBrowser());
        wait.waitForPresenceOfElement(50, dimensionalWeightImpact);
        WebElement dimensionalWeightImpactElement = this.getBrowser().findElement(dimensionalWeightImpact);
        javaScript.scrollIntoViewWebElement(dimensionalWeightImpactElement);
        javaScript.clickWebElement(dimensionalWeightImpactElement);
    }
    public void averageSavingsPerPkgClick(){
        wait = new WebDriverWaits(this.getBrowser());
        javaScript = new JavaScriptExecutorMethods(this.getBrowser());
        wait.waitForPresenceOfElement(20,avgSavingsPerPkgBtn );
        WebElement avgSavingsPerPkgElement = this.getBrowser().findElement(avgSavingsPerPkgBtn);
        javaScript.scrollIntoViewWebElement(avgSavingsPerPkgElement);
        javaScript.clickWebElement(avgSavingsPerPkgElement);
    }

    public void potentialSavingsRefundClick(){
        wait = new WebDriverWaits(this.getBrowser());
        javaScript = new JavaScriptExecutorMethods(this.getBrowser());
        wait.waitForPresenceOfElement(40, potentialSavingsRefundName);
        javaScript.clickWebElement(this.getBrowser().findElement(potentialSavingsRefundName));
    }
    public void actualSavingsRefundClick(){
        wait = new WebDriverWaits(this.getBrowser());
        javaScript = new JavaScriptExecutorMethods(this.getBrowser());
        wait.waitForPresenceOfElement(40, actualSavingsRefundsName);
        javaScript.clickWebElement(this.getBrowser().findElement(actualSavingsRefundsName));

    }


    public boolean totalSavingsColourVerify() {
        boolean color = false;

        wait = new WebDriverWaits(this.getBrowser());
        wait.waitForPresenceOfElement(20, totalSavings);

        String classAttribute = this.getBrowser().findElement(totalSavings).getAttribute("class");
        String initialVal = this.getBrowser().findElement(totalSavings).getText().
                replace(",", "").replace("$", "");
        wait.waitForValueToChange(30,totalSavings,initialVal);
        float val = Float.parseFloat(this.getBrowser().findElement(totalSavings).getText().
                replace(",", "").replace("$", ""));
        System.out.println("totalSavings Value - "+val);
        if (classAttribute.contains("text-success") && val > 0) {
            color = true;
        } else if (classAttribute.contains("text-danger")) {
            System.out.println("Text color is red");
            color = true;
        }
        return color;
    }

    public boolean transportationSavingsColorVerify() {
        boolean color = false;
        wait = new WebDriverWaits(this.getBrowser());
        wait.waitForPresenceOfElement(20, graphLoadWait);
        String classAttribute = this.getBrowser().findElement(transportationSavings).getAttribute("class");
        float val = Float.parseFloat(this.getBrowser().findElement(transportationSavings).getText().
                replace(",", "").replace("$", ""));
        System.out.println("transportationSavings Value - "+val);
        if (classAttribute.contains("text-success") && val > 0) {
            color = true;
        } else if (classAttribute.contains("text-danger")) {
            System.out.println("Text color is red");
            color = true;
        }
        return color;
    }

    public boolean surchargeSavingsColorVerify() {
        boolean color = false;
        wait = new WebDriverWaits(this.getBrowser());
        wait.waitForPresenceOfElement(20, graphLoadWait);
        String classAttribute = this.getBrowser().findElement(surchargeSavings).getAttribute("class");
        float val = Float.parseFloat(this.getBrowser().findElement(surchargeSavings).getText().
                replace(",", "").replace("$", ""));
        System.out.println("surchargeSavings Value - "+val);
        if (classAttribute.contains("text-success") && val > 0) {
            color = true;
        } else if (classAttribute.contains("text-danger")) {
            System.out.println("Text color is red");
            color = true;
        }
        return color;
    }

    public boolean dimensionalWeightImpactColorVerify() {
        boolean color = false;
        wait = new WebDriverWaits(this.getBrowser());
        wait.waitForPresenceOfElement(20, graphLoadWait);
        String classAttribute = this.getBrowser().findElement(dimensionalWeightImpact).getAttribute("class");
        float val = Float.parseFloat(this.getBrowser().findElement(dimensionalWeightImpact).getText().
                replace(",", "").replace("$", ""));
        System.out.println("dimensionalWeightImpact Value - "+val);
        if (classAttribute.contains("text-success") && val > 0) {
            color = true;
        } else if (classAttribute.contains("text-danger")) {
            System.out.println("Text color is red");
            color = true;
        }
        return color;
    }

    public boolean avgSavingsPerPkgBtnColorVerify() {
        boolean color = false;
        wait = new WebDriverWaits(this.getBrowser());
        wait.waitForPresenceOfElement(20, graphLoadWait);
        String classAttribute = this.getBrowser().findElement(avgSavingsPerPkgBtn).getAttribute("class");
        float val = Float.parseFloat(this.getBrowser().findElement(avgSavingsPerPkgBtn).getText().
                replace(",", "").replace("$", ""));
        System.out.println("avgSavingsPerPkg Value - "+val);
        if (classAttribute.contains("text-success") && val > 0) {
            color = true;
        } else if (classAttribute.contains("text-danger")) {
            System.out.println("Text color is red");
            color = true;
        }
        return color;
    }

    public boolean actualSavingsRefundsNameColorVerify() {
        boolean color = false;
        float val;
        String classAttribute;
        wait = new WebDriverWaits(this.getBrowser());
            wait.waitForPresenceOfElement(20, graphLoadWait);
             classAttribute = this.getBrowser().findElement(actualSavingsRefundsName).getAttribute("class");
             val = Float.parseFloat(this.getBrowser().findElement(actualSavingsRefundsName).getText().
                    replace(",", "").replace("$", ""));
        System.out.println("actualSavingsRefundsName Value - "+val);

        if (classAttribute.contains("text-success") && val > 0) {
            color = true;
        }
        if (!classAttribute.contains("text-success") && val == 0){
            color = true;
        }
        else if (classAttribute.contains("text-danger")) {
            System.out.println("Text color is red");
            color = true;
        }
        return color;
    }

    public void monthsCheckboxDropdownIterator(By dropdown, By dropdownElements, int monthIndex) {
        wait = new WebDriverWaits(this.getBrowser());
        javaScript = new JavaScriptExecutorMethods(this.getBrowser());

        // Ensure the dropdown is expanded
        wait.waitForElementToBeClickable(30, dropdown);
        javaScript.clickWebElement(this.getBrowser().findElement(dropdown));
        wait.waitForVisibilityOfElement(30, dropdownElements);
        // Fetch the dropdown elements
        List<WebElement> elements = this.getBrowser().findElements(dropdownElements);
        System.out.println("Number of dropdown elements: " + elements.size());
        // Validate monthIndex
        if (monthIndex >= elements.size()) {
            throw new IndexOutOfBoundsException("Invalid monthIndex: " + monthIndex + ", Available elements: " + elements.size());
        }
        // Unselect all default months if selected
        wait.waitForVisibilityOfElement(30, defaultMonth);
        List<WebElement> checkedMonths = this.getBrowser().findElements(defaultMonth);
        for (WebElement element : checkedMonths) {
            javaScript.clickWebElement(element);
        }
        // Re-fetch dropdown elements after unselection
        elements = this.getBrowser().findElements(dropdownElements);
        // Select the desired month
        wait.waitForVisibilityOfWebElementLocated(30, elements.get(monthIndex));
        elements.get(monthIndex).click();
    }


    public boolean calculateTotalSavings() {
        wait = new WebDriverWaits(this.getBrowser());

        boolean finalResult = true;
        wait.waitForPresenceOfElement(10,graphLoadWait);
        float x = Float.parseFloat(this.getBrowser().findElement(transportationSavings).getText()
                .replace("$", "").replace(",", ""));

        float y = Float.parseFloat(this.getBrowser().findElement(surchargeSavings).getText()
                .replace("$", "").replace(",", ""));

        float z = Float.parseFloat(this.getBrowser().findElement(dimensionalWeightImpact).getText()
                .replace("$", "").replace(",", ""));

        float a = Float.parseFloat(this.getBrowser().findElement(originalInvoice).getText()
                .replace("$", "").replace(",", ""));

        float b = Float.parseFloat(this.getBrowser().findElement(newInvoice).getText()
                .replace("$", "").replace(",", ""));

        float actual = Float.parseFloat(this.getBrowser().findElement(totalSavings).getText()
                .replace("$", "").replace(",", "").split("\\.")[0]);

        float r = x + y + z;
        float c = a - b;
        int result2 = (int) r;
        int result = (int) c;
            System.out.println(result);
            System.out.println(result2);
        if (actual != result && actual != result2) {
            finalResult = false;
        }
        return finalResult;
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
}

