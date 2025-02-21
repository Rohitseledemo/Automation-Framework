package newDemoQaPages.demoRefundsPage;

import basePages.NewDemoBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.JavaScriptExecutorMethods;
import utilities.WebDriverWaits;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class RefundsPage extends NewDemoBasePage {
    WebDriverWaits wait;
    JavaScriptExecutorMethods javaScript;
    By serviceSummaryBtn;
    By potentialSavingsRefundBtn;
    By actualSavingsRefundsBtn;
    By percentageLateTab;
    By carrierPerformanceTab;
    By refundsTab;
    By stateListValues;
    By denialReasonsBtn;

    public RefundsPage(){
        this.carrierServiceDropdown = By.xpath("//div[@class='d-flex w-lg-50 w-md-100']//div[contains(@class,'w-100 ')]//button");
        this.carrierServiceDropdownElements = By.xpath("//div[@class='shadow border-0 dropdown-menu show']//a");
        this.accountDropdown = By.xpath("//div[@class='me-3 dropdown']//div");
        this.accountDropdownElements = By.xpath("//div[contains(@class,'dropdown-menu show')]//a");
        this.denialReasonsBtn = By.xpath("//button[@class='p-1 rounded-5 d-flex btn btn-light']");
        this.refundsTab = By.xpath("//div[@class='col-lg-5 col-md-12 d-flex justify-content-end align-" +
                "items-center gap-2']//button[text()='Refunds']");
        this.stateListValues = By.xpath("//div[@class='states_list']//span[@class='badge-info rounded-pill" +
                " d-block text-center']");
        this.carrierPerformanceTab = By.xpath("//div[@class='col-lg-5 col-md-12 d-flex justify-content-" +
                "end align-items-center gap-2']//button[text()='Carrier Performance']");
        //service type dropdown
        this.tableDropdown = By.xpath("//thead[@class='sticky-header shadow-sm']//tr//th//button[text()" +
                "='Service Type']");
        //service type dropdown Elements
        this.downloadButton = By.xpath("//button[@class=' d-flex justify-content-between align-items-center" +
                " gap-2 rounded-5 btn btn-light']");
        this.tableDropdownElements = By.xpath("//thead[@class='sticky-header shadow-sm']" +
                "//tr//th//div[contains(@class,'dropdown-menu show')]//a");
        this.dataTestId = By.xpath("//thead[@class='sticky-header shadow-sm']//tr//th");
        this.showEntriesDropdown = By.xpath("//button[contains(@class,' d-flex justify-content-between " +
                "align-items-center gap-2 w-100 dropdown-toggle btn btn-light')]");
        this.showEntriesDropdownElements = By.xpath("//div[contains(@class,'dropdown-menu show')]//a");
        this.viewDetails = By.xpath("//button[contains(@class,'rounded-5 d-flex flex-row')]");
        this.percentageLateTab = By.xpath("//div[@class='col-lg-5 col-md-12 d-flex justify-content-end" +
                " align-items-center gap-2']//button[text()='Percentage Late']");
        this.serviceSummaryBtn = By.xpath("//div[@class='d-flex justify-content-center flex-wrap mt-5 gap-3']" +
             "//button[@class='rounded-5 btn btn-light btn-sm']");
        this.actualSavingsRefundsBtn = By.xpath("//div[contains(@class,'refunds_value ms-1')]");
        this.potentialSavingsRefundBtn = By.xpath("//div[contains(@class,'refunds_value me-1 refund-late-shipment-amount gap-1')]");
    }

    public void carrierPerformanceTabClick(){
        wait = new WebDriverWaits(this.getBrowser());
        wait.waitForPresenceOfElement(30,carrierPerformanceTab);
        this.getBrowser().findElement(carrierPerformanceTab).click();
    }
    public void denialReasonBtnClick(){
        wait = new WebDriverWaits(this.getBrowser());
        javaScript = new JavaScriptExecutorMethods(this.getBrowser());
        wait.waitForPresenceOfElement(30,denialReasonsBtn);
        javaScript.clickWebElement(this.getBrowser().findElement(denialReasonsBtn));
    }

    public void refundsTabClick(){
        wait = new WebDriverWaits(this.getBrowser());
        wait.waitForPresenceOfElement(30,refundsTab);
        this.getBrowser().findElement(refundsTab).click();
    }

    public boolean statesTableValuesValidation(){
        boolean result = false;
        wait = new WebDriverWaits(this.getBrowser());

        wait.waitForPresenceOfElement(50,refundsTab);
        this.getBrowser().findElement(refundsTab).click();
//        wait.waitForPresenceOfElement(50,stateListValues);
        if (stateListSignFetch(stateListValues).equalsIgnoreCase("$")){
            System.out.println(stateListSignFetch(stateListValues));
            result = true;
        }
        wait.waitForPresenceOfElement(50,percentageLateTab);
        this.getBrowser().findElement(percentageLateTab).click();
        if (stateListSignFetch(stateListValues).equalsIgnoreCase("%")){
            System.out.println(stateListSignFetch(stateListValues));
            result = true;
        }
        return result;
    }

    public String stateListSignFetch(By valueLocator){
        String sign = null;
        wait.waitForPresenceOfElement(30,valueLocator);
        List<WebElement> values  = this.getBrowser().findElements(valueLocator);
        for (WebElement value:values){
            System.out.println("Value - "+value.getText());
            try {
                if (value.getText().contains("$")) {
                    sign = "$";
                } else if (value.getText().contains("%")) {
                    sign = "%";
                }
                else{
                    sign = null;
                }
            }
            catch(NullPointerException e){
                System.out.println("Null values");
            }
        }
        return sign;
    }

    public void serviceSummaryBtnClick(){
        wait = new WebDriverWaits(this.getBrowser());
        wait.waitForPresenceOfElement(30,serviceSummaryBtn);
        this.getBrowser().findElement(serviceSummaryBtn).click();
    }

    public void percentageLateTabClick(){
        wait = new WebDriverWaits(this.getBrowser());
        wait.waitForPresenceOfElement(30,percentageLateTab);
        this.getBrowser().findElement(percentageLateTab).click();
    }

    public void potentialSavingsRefundBtnClick(){
        wait = new WebDriverWaits(this.getBrowser());
        wait.waitForPresenceOfElement(30,potentialSavingsRefundBtn);
        this.getBrowser().findElement(potentialSavingsRefundBtn).click();
    }

    public void actualSavingsRefundBtnClick(){
        wait = new WebDriverWaits(this.getBrowser());
        javaScript = new JavaScriptExecutorMethods(this.getBrowser());
        wait.waitForPresenceOfElement(30,actualSavingsRefundsBtn);
        javaScript.clickWebElement(this.getBrowser().findElement(actualSavingsRefundsBtn));
    }

    @Override
    public int headerClick(String headerName){
        return super.headerClick(headerName);
    }
    @Override
    public ArrayList<Float> columnData(int headerColumnCount) {
        return super.columnData(headerColumnCount);
    }
    @Override
    public List<String> anyCheckboxDropdownRandomValues(By dropdown, By dropdownElements){
        String valueClicked;
        List<String> valueClickedNames;
        getRandomCheckBoxIndexes(2,1,4);
        Set<Integer> randomCheckboxValues = getRandomCheckboxValues();

        wait = new WebDriverWaits(this.getBrowser());
        javaScript = new JavaScriptExecutorMethods(this.getBrowser());
        wait.waitForPresenceOfElement(30,dropdown);
        javaScript.clickWebElement(this.getBrowser().findElement(dropdown));
        wait.waitForNumberOfElementsToBeMoreThan(40,dropdownElements,2);
        List<WebElement> elements = this.getBrowser().findElements(dropdownElements);

        // to unselect all the checkboxes if selected.
        WebElement selectAll = elements.get(0);
        if (selectAll.isSelected()) {
            javaScript.clickWebElement(selectAll);
        }
        valueClickedNames = new ArrayList<>();
        for (int i:randomCheckboxValues){
            valueClicked = elements.get(i).getText();
            valueClickedNames.add(valueClicked);
            javaScript.clickWebElement(elements.get(i));
        }
        setValueClickedNames(valueClickedNames);
        return valueClickedNames;
    }
    @Override
    public void anyDropdownIterator(By dropdown, By dropdownElements, int careerIndex){
        wait = new WebDriverWaits(this.getBrowser());
        javaScript = new JavaScriptExecutorMethods(this.getBrowser());
        wait.waitForElementToBeClickable(30, dropdown);
        this.getBrowser().findElement(dropdown).click();
        wait.waitForNumberOfElementsToBeMoreThan(30, dropdownElements,4);
        List<WebElement> dateOptions = this.getBrowser().findElements(dropdownElements);
        dateOptions.get(careerIndex).click();
    }

}
