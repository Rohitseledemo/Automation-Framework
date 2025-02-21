package newDemoQaPages.demoPriorAgreementComparisonPage.refundsForLateShipment;

import newDemoQaPages.BaseModal;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.JavaScriptExecutorMethods;
import utilities.WebDriverWaits;

import java.util.ArrayList;
import java.util.List;

public class PotentialCreditsRefundsModalFourthLevel extends BaseModal {
    WebDriverWaits wait;
    JavaScriptExecutorMethods javaScript;
    public PotentialCreditsRefundsModalFourthLevel(){
        this.columnDataXpath = By.xpath("//div[@data-testid='service-info']//tbody//tr//td[@class='align-" +
                "middle text-wrap custom-header']");
        this.dataTestId = By.xpath("//div[@data-testid='service-info']" +
                "//thead[@class='sticky-header shadow-sm']//tr//th");
        this.showEntriesDropdown=By.xpath("//div[@data-testid='service-info']//button[@id='dropdown-basic']");
        this.showEntriesDropdownElements = By.xpath("//div[@data-testid='service-info']" +
                "//div[contains(@class,'dropdown-menu show')]//a");
        this.tableDataLoadWait = By.xpath("//div[@data-testid='service-info']" +
                "//tbody//tr//td[@class='align-middle text-wrap custom-header']");
        this.serialNos = By.xpath("//div[@data-testid='service-info']" +
                "//tbody//tr//td[@class='align-middle text-wrap custom-header'][1]");
        this.pagination = By.xpath("//div[@data-testid='service-info']//ul[@role='navigation']" +
                "//li//a[@class='page-link text-center rounded']");

    }
    @Override
    public int headerClick(String headerName){
        return super.headerClick(headerName);
    }

    @Override
    public ArrayList<Float> columnData(int headerColumnCount) {
        ArrayList<Float> columnValues = new ArrayList<Float>();
        List<WebElement> columnWebElements;

        By customXpath = this.generateDynamicXPath(columnDataXpath,headerColumnCount);
        columnWebElements = this.getBrowser().findElements(customXpath);
        for (WebElement countValue : columnWebElements) {
            float value = Float.parseFloat(countValue.getText().replace("$", ""));
            columnValues.add(value);
        }
//        for printing arrayList data
//        for (Float columnValue : columnValues) {
//            System.out.println(columnValue);
//        }
        return columnValues;
    }

    @Override
    public boolean pageSerialNoValidator(int pageNo) {
        int lastSerialNoIndex = this.getBrowser().findElements(serialNos).size()-1;
        String lastSerialNo = this.getBrowser().findElements(serialNos).get(lastSerialNoIndex).getText();
        wait = new WebDriverWaits(this.getBrowser());

        if(pageNo==1){
            return true;
        }
        boolean correctValues = false;
        wait.waitForPresenceOfElement(30, tableDataLoadWait);
//        int lastSerialNoIndex = this.getBrowser().findElements(serialNos).size()-1;
//        String lastSerialNo = this.getBrowser().findElements(serialNos).get(lastSerialNoIndex).getText();
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




}
