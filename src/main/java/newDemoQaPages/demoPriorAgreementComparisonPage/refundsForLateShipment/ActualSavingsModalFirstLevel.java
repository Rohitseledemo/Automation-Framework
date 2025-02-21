package newDemoQaPages.demoPriorAgreementComparisonPage.refundsForLateShipment;

import newDemoQaPages.BaseModal;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.WebDriverWaits;

import java.util.List;

public class ActualSavingsModalFirstLevel extends BaseModal {
    WebDriverWaits wait;
    public ActualSavingsModalFirstLevel(){
     this.tableDataLoadWait= By.xpath("//div[@data-testid='actual-saving-data']" +
             "//tbody//tr//td[@class='align-middle text-wrap custom-header']");
     this.serialNos= By.xpath("//div[@data-testid='actual-saving-data']" +
             "//tbody//tr//td[@class='align-middle text-wrap custom-header'][1]");
     this.dataTestId= By.xpath("//div[@data-testid='actual-saving-data']" +
             "//thead[@class='sticky-header shadow-sm']//tr//th");
     this.showEntriesDropdown = By.xpath("//div[@data-testid='actual-saving-data']" +
                "//button[@id='dropdown-basic']");
     this.showEntriesDropdownElements = By.xpath("//div[@data-testid='actual-saving-data']" +
                "//div[@class='border-0 shadow rounded-2 p-0 _Container_ztwlk_11 dropdown-menu show']//a");
    }

    @Override
    public int headerClick(String headerName){
        return super.headerClick(headerName);
    }

    @Override
    public boolean showEntriesSerialNoValidator(int showEntries){
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

        if (sNumVal==showEntries) {
            correctValues = true;
        }
        return correctValues;
    }

}
