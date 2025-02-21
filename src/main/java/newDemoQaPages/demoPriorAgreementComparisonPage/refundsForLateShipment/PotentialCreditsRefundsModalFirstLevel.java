package newDemoQaPages.demoPriorAgreementComparisonPage.refundsForLateShipment;

import newDemoQaPages.BaseModal;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.WebDriverWaits;

import java.util.ArrayList;
import java.util.List;

public class PotentialCreditsRefundsModalFirstLevel extends BaseModal {
    WebDriverWaits wait;
    private By performanceReportingBtn;

    public By getPerformanceReportingBtn() {
        return performanceReportingBtn;
    }

    public PotentialCreditsRefundsModalFirstLevel() {
        this.dataTestId = By.xpath("//div[@data-testid='potential-credit-fund-data']" +
                "//thead[@class='sticky-header shadow-sm']//tr//th");
        this.showEntriesDropdown = By.xpath("//div[@data-testid='potential-credit-fund-data']" +
                "//button[@id='dropdown-basic']");
        this.showEntriesDropdownElements = By.xpath("//div[@data-testid='potential-credit-fund-data']" +
                "//div[contains(@class,'dropdown-menu show')]//a");
        this.performanceReportingBtn = By.xpath("//div[@data-testid='potential-credit-fund-data']" +
                "//button[@class='d-flex gap-2 btn btn-primary']");
        this.downloadButton = By.xpath("//div[@data-testid='potential-credit-fund-data']//button[@class='bi" +
                "  d-flex justify-content-between align-items-center gap-2 btn btn-primary']");
        this.serialNos = By.xpath("//div[@data-testid='potential-credit-fund-data']" +
                "//tbody//tr//td[@class='align-middle text-wrap custom-header'][1]");
        this.tableDataLoadWait = By.xpath("//div[@data-testid='potential-credit-fund-data']" +
                "//tbody//tr//td[@class='align-middle text-wrap custom-header']");
    }

    public void performanceReportingBtnClick() {
        wait = new WebDriverWaits(this.getBrowser());
        wait.waitForPresenceOfElement(40, performanceReportingBtn);
        this.getBrowser().findElement(performanceReportingBtn).click();
    }

    @Override
    public int headerClick(String headerName) {
        return super.headerClick(headerName);
    }

    @Override
    public ArrayList<Float> columnData(int headerColumnCount){
        return super.columnData(headerColumnCount);
    }

    @Override
    public void anyDropdownIterator(By dropdown, By dropdownElements, int careerIndex) {
        super.anyDropdownIterator(dropdown, dropdownElements, careerIndex);
    }

    @Override
    public boolean showEntriesSerialNoValidator(int showEntries){
        boolean correctValues = false;
        wait = new WebDriverWaits(this.getBrowser());
        wait.waitForPresenceOfElement(30, tableDataLoadWait);
        int lastSerialNoIndex = this.getBrowser().findElements(serialNos).size()-1;
        String lastSerialNo = this.getBrowser().findElements(serialNos).get(lastSerialNoIndex).getText();
        try{
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

}
