package newDemoQaPages.demoInvoiceReviewPage;

import basePages.NewDemoBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.JavaScriptExecutorMethods;
import utilities.WebDriverWaits;

import java.util.List;

public class InvoiceReviewPage extends NewDemoBasePage {
    WebDriverWaits wait;
    JavaScriptExecutorMethods javaScript;
    By totalMonthlySpendCard;
    By surchargeSpendCard;
    By topBoxSizesCard;
    By avgCostPerPkgCard;
    By potentialSavingsCard;
    By actualSavingsCard;
    By packageProfileTab;
    By advancedSearchTab;
    By nicknameAccountsBtn;

    public InvoiceReviewPage(){
        this.dataTestId = By.xpath("//thead[@class='sticky-header shadow-sm']//tr//th");
        this.downloadButton = By.xpath("//button[@class='d-flex align-items-center d-flex justify-" +
                "content-between align-items-center gap-2 btn btn-light']");
        this.totalMonthlySpendCard = By.xpath("//div[text()='Total Monthly Spend']/following-sibling::div");
        this.surchargeSpendCard = By.xpath("//div[text()='Surcharge Spend']/following-sibling::div");
        this.topBoxSizesCard = By.xpath("//div[text()='Top Box Sizes']/following-sibling::div");
        this.avgCostPerPkgCard = By.xpath("//div[text()='Average Cost Per Package']/following-sibling::div");
        this.potentialSavingsCard = By.xpath("//div[text()='Potential Credits/Refunds']/following-sibling::div");
        this.actualSavingsCard = By.xpath("//div[text()='Actual Credits/Refunds']/following-sibling::div");
        this.packageProfileTab = By.xpath("//button[text()='Package Profile']");
        this.advancedSearchTab = By.xpath("//button[text()='Advanced Search']");
        this.nicknameAccountsBtn = By.xpath("//button[text()='Nickname Accounts']");
        this.viewDetails  = By.xpath("//div[@class='col-6 d-flex justify-content-end gap-2']" +
                "//button[text()=' Details']");
        this.serialNos = By.xpath("//tbody//tr//td[@class='align-middle text-wrap custom-header'][1]");
        this.tableDataLoadWait = By.xpath("//tbody//tr//td[@class='align-middle text-wrap custom-header']");
        this.pagination = By.xpath("//ul[@class='d-flex flex-row pagination gap-1 ms-auto _pagination_" +
                "2iwnb_1']//a[@class='page-link text-center rounded']");
        this.showEntriesDropdown = By.xpath("//button[contains(@class,' d-flex justify-content-between " +
                "align-items-center gap-2 w-100 dropdown-toggle')]");
        this.showEntriesDropdownElements = By.xpath("//div[contains(@class,'dropdown-menu show')]//a");
        this.dateDropdown = By.xpath("//span[@class='dropdown-option']//img[contains(@src,'calendar_days')]");
        this.dateDropdownElements = By.xpath("//div[contains(@class,'dropdown-menu show')]//a");
        this.serviceDropdown = By.xpath("//span[@class='select_icon d-sm-none d-lg-block']/parent::div");
        this.serviceDropdownElements = By.xpath("//div[contains(@class,'dropdown-menu show')]//a");
        this.accountDropdown = By.xpath("//button[contains(@class,'text-black dropdown-toggle btn btn-primary')]//div");
        this.accountDropdownElements = By.xpath("//div[contains(@class,'dropdown-menu show')]//a");
    }

    public void clickTotalMonthlySpendCard(){
        wait = new WebDriverWaits(this.getBrowser());
        wait.waitForPresenceOfElement(30,totalMonthlySpendCard);
        this.getBrowser().findElement(totalMonthlySpendCard).click();
    }
    public void clickSurchargeSpendCard(){
        wait = new WebDriverWaits(this.getBrowser());
        javaScript = new JavaScriptExecutorMethods(this.getBrowser());
        wait.waitForPresenceOfElement(30,surchargeSpendCard);
        javaScript.clickWebElement(this.getBrowser().findElement(surchargeSpendCard));
    }

    public void clickTopBoxSizesCard(){
        wait = new WebDriverWaits(this.getBrowser());
        javaScript = new JavaScriptExecutorMethods(this.getBrowser());
        wait.waitForPresenceOfElement(30,topBoxSizesCard);
        javaScript.clickWebElement(this.getBrowser().findElement(topBoxSizesCard));
    }
    public void clickAvgCostPerPkgCard(){
        wait = new WebDriverWaits(this.getBrowser());
        javaScript = new JavaScriptExecutorMethods(this.getBrowser());
        wait.waitForPresenceOfElement(30,avgCostPerPkgCard);
        javaScript.clickWebElement(this.getBrowser().findElement(avgCostPerPkgCard));
    }

    public void clickPotentialSavingsCard(){
        wait = new WebDriverWaits(this.getBrowser());
        javaScript = new JavaScriptExecutorMethods(this.getBrowser());
        wait.waitForPresenceOfElement(30,potentialSavingsCard);
        javaScript.clickWebElement(this.getBrowser().findElement(potentialSavingsCard));
    }
    public void clickActualSavingsCard(){
        wait = new WebDriverWaits(this.getBrowser());
        javaScript = new JavaScriptExecutorMethods(this.getBrowser());
        wait.waitForPresenceOfElement(30,actualSavingsCard);
        javaScript.clickWebElement(this.getBrowser().findElement(actualSavingsCard));
    }
    public void clickPackageProfileTab(){
        wait = new WebDriverWaits(this.getBrowser());
        javaScript = new JavaScriptExecutorMethods(this.getBrowser());
        wait.waitForPresenceOfElement(30,packageProfileTab);
        javaScript.clickWebElement(this.getBrowser().findElement(packageProfileTab));
    }
    public void clickAdvancedSearchTab(){
        wait = new WebDriverWaits(this.getBrowser());
        javaScript = new JavaScriptExecutorMethods(this.getBrowser());
        wait.waitForPresenceOfElement(30,advancedSearchTab);
        javaScript.clickWebElement(this.getBrowser().findElement(advancedSearchTab));
    }
    public void nicknameAccountsBtnInvoiceReviewClick(){
        wait = new WebDriverWaits(this.getBrowser());
        javaScript = new JavaScriptExecutorMethods(this.getBrowser());
        wait.waitForElementToBeClickable(40,nicknameAccountsBtn);
        javaScript.clickWebElement(this.getBrowser().findElement(nicknameAccountsBtn));
    }
    @Override
    public boolean pageSerialNoValidator(int pageNo) {
        boolean correctValues = false;
        wait = new WebDriverWaits(this.getBrowser());
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
    @Override
    public int paginationClick(int pageNo) {
        int pageClickedNo;
        wait = new WebDriverWaits(this.getBrowser());
        javaScript = new JavaScriptExecutorMethods(this.getBrowser());

        wait.waitForPresenceOfElement(30, pagination);
        javaScript.scrollIntoViewWebElement(this.getBrowser().findElement(pagination));

        List<WebElement> paginationList = this.getBrowser().findElements(pagination);
        if (pageNo<paginationList.size()) {
            javaScript.clickWebElement(this.getBrowser().findElements(pagination).get(pageNo));
            pageClickedNo = pageNo+1;
        }
        else {
            javaScript.clickWebElement(paginationList.get(0));
            pageClickedNo = 1;
        }
        return pageClickedNo;
    }

    @Override
    public List<WebElement> columnDataWebElements(int columnCount) {
        wait = new WebDriverWaits(this.getBrowser());
        List<WebElement> columnWebElements;
        columnWebElements = this.getBrowser().findElements(By.xpath("//tbody//tr//td["+columnCount+"]"));
        return columnWebElements;
    }
    @Override
    public int headerClick(String headerName){
        int headerColumnCount = 0;
        wait = new WebDriverWaits(this.getBrowser());
        javaScript = new JavaScriptExecutorMethods(this.getBrowser());
        wait.waitForElementToBeClickable(40,dataTestId);
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
}
