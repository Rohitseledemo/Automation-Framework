package basePages;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import utilities.browser.BrowserManager;
import utilities.JavaScriptExecutorMethods;
import utilities.WebDriverWaits;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class NewDemoBasePage {
    JavaScriptExecutorMethods javaScript;
    WebDriverWaits wait;

    private Set<Integer> randomCheckboxValues;
    private ThreadLocal<List<String>> valueClickedNames = new ThreadLocal<>();
    private static final String alphabets = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    protected By columnDataWebElementsXpath;
    protected By columnDataXpath;
    protected By mapStates;
    protected By trendReportTab;
    protected By emptyClick;
    protected By carrierSelectorFedEx;
    protected By carrierSelectorUPS;
    protected By spinnerLoad;
    protected By pageTitle;
    By email;
    By pass;
    By signInBtn;
    protected By trackingNumId;
    protected By downloadConfirmationToast;
    protected By pagination;
    protected By noData;
    protected By closeModalBtn;
    protected By downloadButton;
    protected By tableDataLoadWait;
    protected By downloadButtonStatus;
    protected By percentageOfSurchargeSpendDropdown;
    protected By percentageOfSurchargeSpendDropdownWait;
    protected By dataTestId;
    protected By serialNos;
    protected By trackingNos;
    protected By noDataAvailableText;
    protected By showEntriesDropdown;
    protected By showEntriesDropdownElements;
    protected By carrierServiceDropdown;
    protected By carrierServiceDropdownElements;
    protected By tableDropdown;
    protected By tableDropdownElements;
    protected By viewDetails;
    protected By dateDropdown;
    protected By dateDropdownElements;
    protected By serviceDropdown;
    protected By serviceDropdownElements;
    protected By accountDropdown;
    protected By accountDropdownElements;
    protected By profileDropdown;
    protected By switchToCompanyOrStandardViewBtn;
    protected By avgSavingsPerPkgBtn;
    protected By surchargeSavings;
    protected By newInvoice;


    public By getAccountDropdown(){
        return accountDropdown;
    }

    public By getAccountDropdownElements(){
        return accountDropdownElements;
    }

    public By getDateDropdown(){
        return this.dateDropdown;
    }
    public By getDateDropdownElements(){
        return this.dateDropdownElements;
    }

    public By getServiceDropdown(){
        return serviceDropdown;
    }
    public By getServiceDropdownElements(){
        return serviceDropdownElements;
    }
    //value clicked names list
    public List<String> getValueClickedNames(){
        return valueClickedNames.get();
    }
    public void setValueClickedNames(List<String> values){
        this.valueClickedNames.set(values);
    }

    public Set<Integer> getRandomCheckboxValues(){
        return randomCheckboxValues;
    }
    public void setRandomCheckboxValues(Set<Integer> intValues){
        this.randomCheckboxValues = intValues;
    }

    public By getShowEntriesDropdownElements(){
        return this.showEntriesDropdownElements;
    }
    public By getShowEntriesDropdown(){
        return this.showEntriesDropdown;
    }
    public By getTableDropdown(){
        return this.tableDropdown;
    }
    public By getTableDropdownElements(){
        return this.tableDropdownElements;
    }
    public By getCarrierServiceDropdown(){
        return this.carrierServiceDropdown;
    }
    public By getCarrierServiceDropdownElements(){
        return this.carrierServiceDropdownElements;
    }
    public NewDemoBasePage(){
        this.switchToCompanyOrStandardViewBtn = By.xpath("//div[@class='d-flex gap-2']//i[@class='bi bi-people']");
        this.profileDropdown = By.xpath("//div[@class='custom-dropdown navigation-bar-profile-dropdown dropdown']");
        this.viewDetails = By.xpath("//div[@class='col-6 d-flex justify-content-end gap-2']//button[text()=' Details']");
        this.emptyClick = By.xpath("//div[@class='d-flex align-items-center pt-2']//span[@class='d-block fs-2']");
        this.email= By.xpath("//input[@id='email_addtess']");
        this.pass= By.xpath("//input[@id='login_pass']");
        this.signInBtn=By.xpath("//*[text()='Sign In']");
        this.showEntriesDropdown = By.xpath("//button[@class='d-flex align-items-center bg-white text-" +
                "black mx-1 dropdown-toggle btn btn-primary']");
        this.trackingNumId = By.cssSelector("a.text-black");
        this.percentageOfSurchargeSpendDropdown = By.xpath("//div[@class='d-flex align-items-center gap-2 mt-5']//button");
        this.percentageOfSurchargeSpendDropdownWait = By.xpath("//div[@class='d-flex align-items-center gap-2 mt-5']//button[@class='border-0 skeleton  btn btn-primary btn-sm']");
        this.pagination = By.xpath("//ul[@role='navigation']//li//a[@class='page-link text-center rounded']");
        this.downloadButton = By.xpath("//button[text()='Download']");
        this.downloadConfirmationToast = By.xpath("//div[text()='File has been downloaded successfully!']");
        this.tableDataLoadWait = By.xpath("//tbody//tr//td[@class='align-middle text-wrap custom-header']");
        this.downloadButtonStatus = By.xpath("//button[@data-download-status='ideal']");
        this.dataTestId = By.xpath("//div[@data-testid='prior-agreement-surcharge-savings-modal']//thead" +
                "[@class='sticky-header shadow-sm']//tr//th");
        this.serialNos = By.xpath("//div[@data-testid='prior-agreement-surcharge-detail-service-surcharge" +
                "-modal']//tbody//tr//td[@class='align-middle text-wrap custom-header'][1]");
        this.trackingNos = By.xpath("//div[@data-testid='prior-agreement-surcharge-detail-service-surcharge" +
                "-modal']//div[@class='tracking-id cursor-pointer']");
        this.noDataAvailableText = By.xpath("//div[@class=' d-flex flex-row gap-2 blockquote ']");
        this.closeModalBtn = By.xpath("//button[@class='btn-close']");
        this.spinnerLoad = By.xpath("//div[@class='spinner-border spinner-border-sm text-primary']");
    }

    public boolean validateWindowHandles(){
        boolean newWindow = true;
        Set<String> windowHandles  = this.getBrowser().getWindowHandles();
        if (windowHandles.size()<2){
            newWindow = false;
            System.out.println("No new Window opened up");
        }
        // Iterate through each handle
        for (String handle : windowHandles) {
            this.getBrowser().switchTo().window(handle);
        }
        return newWindow;

    }

    public String pageTitleValidation() {
        wait = new WebDriverWaits(this.getBrowser());
        wait.waitForVisibilityOfElement(30, pageTitle);
        return this.getBrowser().findElement(pageTitle).getText();
    }

    public void profileDropdownBtnClick(){
        wait = new WebDriverWaits(this.getBrowser());
        wait.waitForElementToBeClickable(20,profileDropdown);
        this.getBrowser().findElement(profileDropdown).click();
    }
    public void switchCompanyViewBtnClick(){
        wait = new WebDriverWaits(this.getBrowser());
        wait.waitForElementToBeClickable(20, switchToCompanyOrStandardViewBtn);
        this.getBrowser().findElement(switchToCompanyOrStandardViewBtn).click();
    }

    public void trendReportClick(){
        wait = new WebDriverWaits(this.getBrowser());
        javaScript = new JavaScriptExecutorMethods(this.getBrowser());
        wait.waitForElementToBeClickable(20,trendReportTab);
        javaScript.clickWebElement(this.getBrowser().findElement(trendReportTab));
    }

    public boolean mapTableClick() throws InterruptedException {
        boolean tableVisible = true;
        wait = new WebDriverWaits(this.getBrowser());
        javaScript = new JavaScriptExecutorMethods(this.getBrowser());
//        wait.waitForElementToBeClickable(9,mapStates);
        Thread.sleep(8000);
        this.getBrowser().findElement(mapStates).click();
        try{
            tableVisible = wait.waitForPresenceOfElement(15,tableDataLoadWait);
        }
        catch (Exception ignore){
            System.out.println("noDataAvailable");
            if(wait.waitForPresenceOfElement(8,noDataAvailableText)){
                tableVisible = false;
            }
        }
        return tableVisible;
    }

    //////////////////////////////////////////////////////////////////////////

    public WebDriver getBrowser(){
        return BrowserManager.getInstance().getBrowser();
    }

    //////////////////////////////////////////////////////////////////////////

    public void launchUrl(String URL) {
        WebDriverWaits wait = new WebDriverWaits(this.getBrowser());

        wait.waitForPresenceOfElement(7,email);
        this.getBrowser().get(URL);
    }
    public String getScreenshot(String testCaseName) throws IOException {
        TakesScreenshot ts = (TakesScreenshot)this.getBrowser();
        File source = ts.getScreenshotAs(OutputType.FILE);
        File file = new File(System.getProperty("user.dir")+"//reports//new_demo_qa_screenshots//"+testCaseName+".png");
        FileUtils.copyFile(source,file);
        return System.getProperty("user.dir")+"//reports//new_demo_qa_screenshots//"+testCaseName+".png";
    }

    public boolean viewDetailsBtnClick(){
        boolean isDisplayed = false;
        int count =0;
        wait = new WebDriverWaits(this.getBrowser());
        javaScript = new JavaScriptExecutorMethods(this.getBrowser());
        wait.waitForElementToBeClickable(20,viewDetails);
        while(!isDisplayed && count<3){
            javaScript.clickWebElement(this.getBrowser().findElement(viewDetails));
            wait.waitForPresenceOfElement(20,showEntriesDropdown);
            isDisplayed = this.getBrowser().findElement(showEntriesDropdown).isDisplayed();
            count++;
        }
        return isDisplayed;
    }

    public void anyDropdownIterator(By dropdown, By dropdownElements, int careerIndex){
        wait = new WebDriverWaits(this.getBrowser());
        javaScript = new JavaScriptExecutorMethods(this.getBrowser());
        wait.waitForElementToBeClickable(30, dropdown);
        javaScript.clickWebElement(this.getBrowser().findElement(dropdown));
        wait.waitForPresenceOfElement(30, dropdownElements);
        wait.waitForNumberOfElementsToBeMoreThan(30, dropdownElements,1);
        List<WebElement> dropdownOptions = this.getBrowser().findElements(dropdownElements);
        int listSize = dropdownOptions.size();
        if (careerIndex>=0 && careerIndex<listSize) {
            javaScript.clickWebElement(dropdownOptions.get(careerIndex));}
        else {
            System.out.println("Invalid index, selecting last option.");
            javaScript.clickWebElement(dropdownOptions.get(listSize-1));
        }
    }

    public String anyDropdownIterator1(By dropdown, By dropdownElements, int careerIndex){
        String selectedDropdownValue;
        wait = new WebDriverWaits(this.getBrowser());
        javaScript = new JavaScriptExecutorMethods(this.getBrowser());
        wait.waitForElementToBeClickable(30, dropdown);
        javaScript.clickWebElement(this.getBrowser().findElement(dropdown));
        wait.waitForNumberOfElementsToBeMoreThan(30, dropdownElements,1);
        // added to test
        wait.waitForVisibilityOfWebElementLocated(30, this.getBrowser().findElement(dropdownElements));
        //
        List<WebElement> dropdownOptions = this.getBrowser().findElements(dropdownElements);
        int listSize = dropdownOptions.size();
        if (careerIndex>=0 && careerIndex<listSize) {
            wait.waitForVisibilityOfWebElementLocated(10, dropdownOptions.get(careerIndex));
            selectedDropdownValue = dropdownOptions.get(careerIndex).getText();
            System.out.println("selectedDropdownValue - "+dropdownOptions.get(careerIndex).getText());
            javaScript.clickWebElement(dropdownOptions.get(careerIndex));
        }
        else {
            System.out.println("Invalid index, selecting last option.");
            javaScript.clickWebElement(dropdownOptions.get(listSize-1));
            selectedDropdownValue = dropdownOptions.get(listSize-1).getText();
        }
        return selectedDropdownValue;
    }
    public void getEmptyClickOperation(){
        this.getBrowser().findElement(emptyClick).click();
    }

    public int headerClick(String headerName){
        int headerColumnCount = 0;
        wait = new WebDriverWaits(this.getBrowser());
        javaScript = new JavaScriptExecutorMethods(this.getBrowser());
        wait.waitForPresenceOfElement(20,dataTestId);
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
    public ArrayList<Float> columnData(int headerColumnCount) {
        wait = new WebDriverWaits(this.getBrowser());
        ArrayList<Float> columnValues = new ArrayList<Float>();
        List<WebElement> columnWebElements;

        wait.waitForVisibilityOfElement(10,spinnerLoad);
        wait.waitForInvisibilityOfElementLocated(10,spinnerLoad);
        columnWebElements = this.getBrowser().findElements(By.xpath("//tbody//tr//td[@class='" +
                "align-middle text-wrap custom-header'][" + headerColumnCount + "]"));
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

    public boolean sortingValidation(List<Float> columnValues) {
        boolean isAscending = true, isDescending = true;
        if(columnValues == null || columnValues.size() <= 1){
            return true;}
            for (int i = 0; i < columnValues.size() - 1; i++) {
                if (columnValues.get(i) > columnValues.get(i + 1)) {
                    isAscending = false;}
                if (columnValues.get(i) < columnValues.get(i + 1)) {
                    isDescending = false;}
                if (!isAscending && !isDescending) {
                    return false;
                }
            }
        return true;
    }

    public int paginationClick(int pageNo) {
        int pageClickedNo;
        wait = new WebDriverWaits(this.getBrowser());
        javaScript = new JavaScriptExecutorMethods(this.getBrowser());

        wait.waitForPresenceOfElement(30, pagination);
        javaScript.scrollIntoViewWebElement(this.getBrowser().findElement(pagination));

        List<WebElement> paginationList = this.getBrowser().findElements(pagination);
        if (pageNo<paginationList.size()) {
            this.getBrowser().findElements(pagination).get(pageNo).click();
            pageClickedNo = pageNo+1;
        }
        else {
            javaScript.clickWebElement(paginationList.get(0));
            pageClickedNo = 1;
        }
        return pageClickedNo;
    }

    public boolean pageSerialNoValidator(int pageNo) {
        wait = new WebDriverWaits(this.getBrowser());

        if(pageNo==1){
            return true;
        }
        boolean correctValues = false;
        wait.waitForPresenceOfElement(30, tableDataLoadWait);
        int lastSerialNoIndex = this.getBrowser().findElements(serialNos).size()-1;
        String lastSerialNo = this.getBrowser().findElements(serialNos).get(lastSerialNoIndex).getText();
        wait.waitForSerialNoToChange(30,serialNos,lastSerialNo);

        List<WebElement> columnWebElements;
        columnWebElements = this.getBrowser().findElements(serialNos);
        int lastValue = columnWebElements.size() - 1;
        int sNumVal = Integer.parseInt(columnWebElements.get(lastValue).getText());
        System.out.println("sNumVal - "+sNumVal);
        if (sNumVal == pageNo * 20) {
            correctValues = true;
        }
        return correctValues;
    }

    public boolean showEntriesSerialNoValidator(int showEntries) {
        boolean correctValues = false;
        wait = new WebDriverWaits(this.getBrowser());
        wait.waitForPresenceOfElement(30, tableDataLoadWait);
        int serialNo = this.getBrowser().findElements(serialNos).size();

        int lastSerialNoIndex = this.getBrowser().findElements(serialNos).size()-1;
        String lastSerialNo = this.getBrowser().findElements(serialNos).get(lastSerialNoIndex).getText();
        if (serialNo>=20){
            try{
                wait.waitForSerialNoToChange(30,serialNos,lastSerialNo);
            }
            catch (Exception e){
                wait.waitForValueToChange(30,serialNos,lastSerialNo);
            }}

        List<WebElement> columnWebElements;
        columnWebElements = this.getBrowser().findElements(serialNos);
        int lastValue = columnWebElements.size() - 1;
        int sNumVal = Integer.parseInt(columnWebElements.get(lastValue).getText());

        if (sNumVal==showEntries) {
            correctValues = true;
        }
        return correctValues;
    }

    public boolean testDownloadButtonFunctionality() {
        boolean isDisplayed = false;
        wait = new WebDriverWaits(this.getBrowser());
        wait.waitForElementToBeClickable(30, downloadButton);
        try {
            this.getBrowser().findElement(downloadButton).click();
            wait.waitForPresenceOfElement(50, downloadConfirmationToast);
            isDisplayed = this.getBrowser().findElement(downloadConfirmationToast).isDisplayed();
        }
        catch (Exception ignored){
            System.out.println("DOWNLOAD BUTTON NOT FOUND");
        }
        return isDisplayed;
    }

    public boolean testDownloadButtonFunctionality2() {
        boolean isDisplayed = false;
        String initialValue;
        wait = new WebDriverWaits(this.getBrowser());
        wait.waitForVisibilityOfElement(16, downloadButton);
        wait.waitForElementToBeClickable(16, downloadButton);
        try {
            initialValue = this.getBrowser().findElement(downloadButton).getAttribute("data-download-status");
            this.getBrowser().findElement(downloadButton).click();
            isDisplayed = wait.waitForAttributeValueToChange(50, downloadButton, initialValue);
        }
        catch (Exception ignored){
            System.out.println("DOWNLOAD BUTTON NOT FOUND");
        }
        return isDisplayed;
    }

    public boolean verifyNoDataAvailable(){
        boolean isDisplayed = false;
        wait = new WebDriverWaits(this.getBrowser());
        wait.waitForPresenceOfElement(30, noDataAvailableText);
        try {
            wait.waitForPresenceOfElement(30, noDataAvailableText);
            isDisplayed = this.getBrowser().findElement(noDataAvailableText).isDisplayed();
        }
        catch (Exception ignored){
            System.out.println("NO DATA AVAILABLE TEXT NOT VISIBLE.");
        }
        return isDisplayed;
    }
    public boolean trackingNumberValidation() {
        wait = new WebDriverWaits(this.getBrowser());
        javaScript = new JavaScriptExecutorMethods(this.getBrowser());
        List<WebElement> columnWebElements;

        columnWebElements = this.getBrowser().findElements(trackingNos);
        javaScript.clickWebElement(columnWebElements.get(2));
        wait.waitForPresenceOfElement(30, trackingNumId);
        return this.getBrowser().findElement(trackingNumId).isDisplayed();
    }
    public Float calculateSum(List<Float> numbers) {
        float sum = 0;
        for (float num : numbers) {
            sum += num;
        }
        BigDecimal bd = new BigDecimal(sum);
        bd = bd.setScale(2, RoundingMode.HALF_UP); // Rounds to 2 decimal places

        return bd.floatValue();
    }
    public void anyColumnValueClick(List<WebElement> columnLinks) {
        boolean displayed;
        javaScript = new JavaScriptExecutorMethods(this.getBrowser());
        wait = new WebDriverWaits(this.getBrowser());

//        for (WebElement element : columnLinks) {
        for(int i =0;i<columnLinks.size();i++){
            javaScript.clickWebElement(columnLinks.get(1));
            try {
                wait.waitForPresenceOfElement(10, noDataAvailableText);
                displayed = this.getBrowser().findElement(noDataAvailableText).isDisplayed();
                if (displayed) {
                    wait.waitForPresenceOfElement(10, closeModalBtn);
                    WebElement closeModal = this.getBrowser().findElement(closeModalBtn);
                    closeModal.click();
                    wait.waitForInvisibilityOfElementLocated(30, closeModalBtn);
                }
            } catch (Exception e) {
                System.out.println("NoData Element not found");
                break;
            }
        }
    }

    public List<WebElement> columnDataWebElements(int columnCount) {
        wait = new WebDriverWaits(this.getBrowser());
        List<WebElement> columnWebElements;
//-----------------------------------newly added for optimization check-----------------------------------------------//
        wait.waitForVisibilityOfElement(10,spinnerLoad);
        wait.waitForInvisibilityOfElementLocated(10,spinnerLoad);
        columnWebElements = this.getBrowser().findElements(By.xpath("//div[@data-testid='service-summary']" +
                "//tbody//tr//td["+columnCount+"]"));
        return columnWebElements;
    }

    //overloading anyDropdownIterator method of this class for use in show entries test
    public int anyDropdownIterator(By dropdown, By dropdownElements) {
        int entry = 0;
        wait = new WebDriverWaits(this.getBrowser());
        javaScript = new JavaScriptExecutorMethods(this.getBrowser());
        wait.waitForPresenceOfElement(30, dropdown);
        javaScript.clickWebElement(this.getBrowser().findElement(dropdown));
        wait.waitForVisibilityOfElement(20, dropdownElements);
        List<WebElement> dateOptions = this.getBrowser().findElements(dropdownElements);
        if (!dateOptions.isEmpty()) {
            entry = Integer.parseInt(dateOptions.get(1).getText());
            javaScript.clickWebElement(dateOptions.get(1));
        }
        return entry;
    }

    public void getRandomCheckBoxIndexes(int count, int minValue, int maxValue) {
        javaScript = new JavaScriptExecutorMethods(this.getBrowser());
        this.randomCheckboxValues = new HashSet<>();
        Random random = new Random();
        // Ensure that maxValue is greater than minValue and the range is valid
        if (maxValue <= minValue) {
            throw new IllegalArgumentException("maxValue must be greater than minValue");
        }
        // Generate random values within the specified range
        while (randomCheckboxValues.size() < count) {
            int randomValue = random.nextInt((maxValue - minValue) + 1) + minValue;
            this.randomCheckboxValues.add(randomValue);
        }
    }
    public String generateRandomString(int length) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder(length);
        sb.append("SelTest ");

        for (int i = 0; i < length; i++) {
            sb.append(alphabets.charAt(random.nextInt(alphabets.length())));
        }
        return sb.toString();
    }

    public List<String> anyCheckboxDropdownRandomValues(By dropdown, By dropdownElements){
        String valueClicked;
        getRandomCheckBoxIndexes(2,1,6);

        wait = new WebDriverWaits(this.getBrowser());
        javaScript = new JavaScriptExecutorMethods(this.getBrowser());
        wait.waitForElementToBeClickable(20,dropdown);
        javaScript.clickWebElement(this.getBrowser().findElement(dropdown));
        wait.waitForNumberOfElementsToBeMoreThan(20,dropdownElements,2);
        List<WebElement> elements = this.getBrowser().findElements(dropdownElements);

        // to unselect all the checkboxes if selected.
        WebElement selectAll = elements.get(0);
        if (selectAll.isSelected()) {
            javaScript.clickWebElement(selectAll);
        }
        valueClickedNames.set(new ArrayList<>());
        for (int i:this.randomCheckboxValues){
            valueClicked = elements.get(i).getText();
            valueClickedNames.get().add(valueClicked);
            javaScript.clickWebElement(elements.get(i));
        }
        return valueClickedNames.get();

    }

    public boolean dropdownAndColumnDataValidation(List<String> dropdownValues,
                                                   List<WebElement> columnValuesElements,
                                                   boolean compareAllValues){
        boolean result = false;
        List<String> columnValues = new ArrayList<>();
        for (WebElement element : columnValuesElements) {
            columnValues.add(element.getText());
        }
        //to print column values
        for (String value:columnValues){
            System.out.println(value);
        }
        //case-1 it compares all values of both list
        if (compareAllValues){
            boolean containsAll = new HashSet<>(dropdownValues).containsAll(columnValues);
            if (containsAll){
                result = true;
            }
        }
        //case-2 it checks if atleast 1 value is common in both list
        else {
            columnValues.retainAll(dropdownValues);
            // If the resulting list is not empty, there are common values
            if(!dropdownValues.isEmpty()){
                result = true;
            }
        }
        return result;
    }

    public boolean stringValueSearch(String valueToSearch, By dropdownValues){
        List<String> valuesCollection = new ArrayList<>();
        wait = new WebDriverWaits(this.getBrowser());
        wait.waitForVisibilityOfElement(30,dropdownValues);
        List<WebElement> dropdownElements = this.getBrowser().findElements(dropdownValues);
        for (WebElement element : dropdownElements){
            valuesCollection.add(element.getText());
        }
        return valuesCollection.stream().anyMatch(s->s.equalsIgnoreCase(valueToSearch));
    }


    public boolean pageDataValidator(By locatorToCheck,By dropdown, By dropdownElements ){
        boolean dataPresent = false;
        wait = new WebDriverWaits(this.getBrowser());
        wait.waitForPresenceOfElement(20,locatorToCheck);
        float data = Float.parseFloat(this.getBrowser().findElement(locatorToCheck).getText()
                .replace("$","").replace(",",""));
//        System.out.println("DataPresent - "+data);
        if (data!=0){
            dataPresent = true;
        }
        else {
            for (int i=0;i<50;i++){
                anyDropdownIterator(dropdown,dropdownElements,i);
                wait = new WebDriverWaits(this.getBrowser());
                wait.waitForPresenceOfElement(20,locatorToCheck);
                data = Float.parseFloat(this.getBrowser().findElement(locatorToCheck).getText()
                        .replace("$","").replace(",",""));
                System.out.println("DataPresent - "+data);
                if (data!=0){
                    dataPresent = true;
                    break;
                }
            }
        }
        return dataPresent;
    }


    public boolean isNoDataFound() {
        try {
            wait.waitForVisibilityOfElement(5,noData);
            return this.getBrowser().findElement(noData).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    public void carrierSelectorValidator() {
        wait = new WebDriverWaits(this.getBrowser());

        wait.waitForPresenceOfElement(20, carrierSelectorUPS);
        this.getBrowser().findElement(carrierSelectorUPS).click();
        verifyCarrierText(carrierSelectorUPS, "UPS");

        wait.waitForPresenceOfElement(20, carrierSelectorFedEx);
        this.getBrowser().findElement(carrierSelectorFedEx).click();
        verifyCarrierText(carrierSelectorFedEx, "FedEx");

    }

    public boolean verifyCarrierText(By locator, String expectedText) {
        wait = new WebDriverWaits(this.getBrowser());
        boolean textDisplayed = false;
        wait.waitForPresenceOfElement(20,locator);
        String actualText = this.getBrowser().findElement(locator).getText();
        if (actualText.equals(expectedText)) {
            textDisplayed = true;
        }
        else {
            System.out.println("Text verification failed. Expected: " + expectedText + ", but got: " + actualText);
        }
        return textDisplayed;
    }

    public boolean validateAllDropdownValues(By dropdown, By dropdownElements, int[] dateIndices) {
        boolean allValues = false;
        try {
            for (int dateIndex : dateIndices) {
                String dropdownValue = anyDropdownIterator1(dropdown, dropdownElements, dateIndex);
                if (validateDropdownTitle(dropdownValue, dropdown)) {
                    allValues= true;}}}
        catch (Exception e) {
            System.err.println("Error occurred during dropdown validation: " + e.getMessage());
            allValues= false;}
        return allValues;
    }

    public boolean validateDropdownTitle(String dropdownValue, By dropdown){
        String actualValue;
        boolean flag = false;
        wait = new WebDriverWaits(this.getBrowser());
//        wait.waitForVisibilityOfElement(10,dropdown);
        wait.waitForTextToBePresentInElement(10,dropdown,dropdownValue);
        actualValue = this.getBrowser().findElement(dropdown).getText();
        System.out.println("actualValue - "+actualValue);
        if (actualValue.equalsIgnoreCase(dropdownValue)){
            flag = true;
        }
        return flag;
    }

    public By generateDynamicXPath(By xpath, int indexing){
        String defaultXpath, customXpath;
        if (!xpath.toString().startsWith("By.xpath:")) {
            throw new IllegalArgumentException("Only By.xpath locators are supported with this custom method.");
        }
        defaultXpath = xpath.toString().replaceFirst("By.xpath:", "");
        customXpath = defaultXpath + "[" +indexing+ "]";
        return By.xpath(customXpath);
    }


}