package newDemoQaPages.demoPriorAgreementComparisonPage.totalSavings;

import newDemoQaPages.BaseModal;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.JavaScriptExecutorMethods;
import utilities.WebDriverWaits;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class SurchargeSavingsSurchargeTrendModal extends BaseModal {
    WebDriverWaits wait;
    JavaScriptExecutorMethods javaScript;
    By resetBtn;
    private By selectTimePeriodDropdown;
    private By surchargeTypeDropdown;
    private By sortBySpendOrVolume;
    private By allDropdownValues;
    By selectAllValueInDropdown;
    By tableHeaderColumnValues;
    protected By refreshBtn;


    public By getSelectTimePeriodDropdown(){
        return this.selectTimePeriodDropdown;
    }
    public By getSortBySpendOrVolumeDropdown(){
        return this.sortBySpendOrVolume;
    }
    public By getSurchargeTypeDropdown(){
        return this.surchargeTypeDropdown;
    }
    public By getAllDropdownValues(){
        return this.allDropdownValues;
    }

    public SurchargeSavingsSurchargeTrendModal(){
        this.columnDataWebElementsXpath = By.xpath("//div[@data-testid='prior-agreement-surcharge-trend']" +
                "//tbody//tr//td[@class='align-middle text-wrap custom-header']");
        this.tableHeaderColumnValues= By.xpath("//div[@data-testid='prior-agreement-surcharge-trend']" +
                "//thead[@class='sticky-header shadow-sm']//tr//th//div[@class='custom-header']");
        this.resetBtn = By.xpath("//button[@class='d-flex gap-1 btn btn-primary btn-sm']");
        this.sortBySpendOrVolume = By.xpath("//div[text()='Sort by Spend or Volume']/following-sibling::div//button");
        this.selectTimePeriodDropdown = By.xpath("//div[text()='Select Time Period']/following-sibling::div//button");
        this.surchargeTypeDropdown = By.xpath("//div[text()='Surcharge Type']/following-sibling::div");
        this.allDropdownValues = By.xpath("//div[@data-testid='prior-agreement-surcharge-" +
                "trend']//div[contains(@class,'dropdown-menu show')]//a");
        this.downloadButton = By.xpath("//div[@data-testid='prior-agreement-surcharge-trend']" +
                "//button[@icon='bi bi-cloud-download']");
        this.tableDataLoadWait = By.xpath("//div[@class='mt-2 overflow-auto']//thead");
        this.modalTitle = By.xpath("//div[@data-testid='prior-agreement-surcharge-trend']" +
                "//div[@class='modal-title h4']");
        this.selectAllValueInDropdown = By.xpath("//div[@data-testid='prior-agreement-surcharge-trend']" +
                "//div[contains(@class,'dropdown-menu show')]//a//i");
        this.refreshBtn = By.xpath("//button[@class='d-flex gap-1 btn btn-primary btn-sm']" +
                "//i[@class='bi bi-box-arrow-in-right']");
    }
    public void resetBtnClick(){
        wait = new WebDriverWaits(this.getBrowser());
        javaScript = new JavaScriptExecutorMethods(this.getBrowser());
        wait.waitForElementToBeClickable(30,resetBtn);
        javaScript.clickWebElement(this.getBrowser().findElement(resetBtn));
    }

    public void refreshBtnClick(){
        wait = new WebDriverWaits(this.getBrowser());
        javaScript = new JavaScriptExecutorMethods(this.getBrowser());
        wait.waitForElementToBeClickable(30,refreshBtn);
        javaScript.clickWebElement(this.getBrowser().findElement(refreshBtn));
    }
    public void sortBySpendOrVolumeDropdownClick(){
        wait = new WebDriverWaits(this.getBrowser());
        javaScript = new JavaScriptExecutorMethods(this.getBrowser());
        wait.waitForPresenceOfElement(30,tableDataLoadWait);
        javaScript.clickWebElement(this.getBrowser().findElement(sortBySpendOrVolume));
    }
    public void selectTimePeriodDropdownClick(){
        wait = new WebDriverWaits(this.getBrowser());
        javaScript = new JavaScriptExecutorMethods(this.getBrowser());
        wait.waitForPresenceOfElement(30,tableDataLoadWait);
        javaScript.clickWebElement(this.getBrowser().findElement(selectTimePeriodDropdown));
    }
    public void surchargeTypeDropdownClick(){
        wait = new WebDriverWaits(this.getBrowser());
        wait.waitForElementToBeClickable(20, surchargeTypeDropdown);
        this.getBrowser().findElement(surchargeTypeDropdown).click();
    }
    @Override
    public boolean testDownloadButtonFunctionality2() {
        boolean isDisplayed = false;
        String initialValue;
        wait = new WebDriverWaits(this.getBrowser());
        wait.waitForVisibilityOfElement(30,tableDataLoadWait);
        try {
            initialValue = this.getBrowser().findElement(downloadButton).getAttribute("data-download-status");
            this.getBrowser().findElement(downloadButton).click();
            isDisplayed = wait.waitForAttributeValueToChange(50,downloadButton,initialValue);
        }
        catch (Exception ignored){
            System.out.println("DOWNLOAD BUTTON NOT FOUND");
        }
        return isDisplayed;
    }
    @Override
    public List<String> anyCheckboxDropdownRandomValues(By dropdown, By dropdownElements){
        String valueClicked;
        List<String> valueClickedNames;
        getRandomCheckBoxIndexes(2,1,4);
        Set<Integer> randomCheckboxValues = getRandomCheckboxValues();

        wait = new WebDriverWaits(this.getBrowser());
        javaScript = new JavaScriptExecutorMethods(this.getBrowser());
        wait.waitForPresenceOfElement(30,tableDataLoadWait);
        this.getBrowser().findElement(dropdown).click();
        wait.waitForNumberOfElementsToBeMoreThan(40,dropdownElements,2);
        List<WebElement> elements = this.getBrowser().findElements(dropdownElements);

        // to unselect all the checkboxes if selected.
        WebElement selectAll = this.getBrowser().findElements(selectAllValueInDropdown).get(0);
//        System.out.println("selectAll is selected .? - "+selectAll.isEnabled());
        if (selectAll.isEnabled()) {
            javaScript.clickWebElement(selectAll);
        }
        valueClickedNames = new ArrayList<>();
        for (int i:randomCheckboxValues){
            valueClicked = elements.get(i).getText().replace("-","");
            valueClickedNames.add(valueClicked);
            javaScript.clickWebElement(elements.get(i));
        }
        setValueClickedNames(valueClickedNames);
        //empty click since dropdown on this modal gets api call only after that
        javaScript.clickWebElement(this.getBrowser().findElement(modalTitle));
        return valueClickedNames;
    }

    public List<String> tableHeaderColumnsValidator(){
        List<String> headerValues = new ArrayList<>();
        wait = new WebDriverWaits(this.getBrowser());
        javaScript = new JavaScriptExecutorMethods(this.getBrowser());

        wait.waitForVisibilityOfElement(40,tableHeaderColumnValues);
        List<WebElement> headerValuesWebElement = this.getBrowser().findElements(tableHeaderColumnValues);
        
        for (WebElement ele: headerValuesWebElement){
            headerValues.add(ele.getText().replace("/",""));
        }
        return headerValues.stream()
                .filter(s -> !s.equals("Topic") && !s.equals("Month Over Month %"))
                .collect(Collectors.toList());
    }
    @Override
    public List<WebElement> columnDataWebElements(int columnCount) {
        wait = new WebDriverWaits(this.getBrowser());
        List<WebElement> columnWebElements;
        By customXpath = this.generateDynamicXPath(columnDataWebElementsXpath,columnCount);
        columnWebElements = this.getBrowser().findElements(customXpath);
        return columnWebElements;
    }
}
