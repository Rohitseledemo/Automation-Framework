package newDemoQaPages.demoPriorAgreementComparisonPage.totalSavings;

import newDemoQaPages.BaseModal;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.JavaScriptExecutorMethods;
import utilities.WebDriverWaits;

import java.util.ArrayList;
import java.util.List;

public class SurchargeSavingsModalSecondLevel extends BaseModal {
    WebDriverWaits wait;
    JavaScriptExecutorMethods javaScript;

    public SurchargeSavingsModalSecondLevel() {
        this.dataTestId = By.xpath("//div[@data-testid='prior-agreement-surcharge-detail-service-surcharge" +
                "-modal']//thead[@class='sticky-header shadow-sm']//tr//th");
        this.emptyClick = By.xpath("//div[@data-testid='prior-agreement-surcharge-trend']" +
                "//div[@class='modal-title h4']");
        this.tableDataLoadWait = By.xpath("//div[@data-testid='prior-agreement-surcharge-detail-service-" +
                "surcharge-modal']//tbody//tr//td");
        this.downloadButton = By.xpath("//div[@data-testid='prior-agreement-surcharge-detail-service-" +
                "surcharge-modal']//button[@data-download-status='ideal']");
        this.pagination = By.xpath("//ul[@role='navigation']//li//a[@class='page-link text-center rounded']");
    }

    @Override
    public void anyDropdownIterator(By dropdown, By dropdownElements, int careerIndexListSize) {
        List<Integer> carrierIndex= new ArrayList<>();
        wait = new WebDriverWaits(this.getBrowser());
        wait.waitForPresenceOfElement(10, dropdown);

        for (int i=1;i<=careerIndexListSize;i++) {
            carrierIndex.add(i);
        }

//        wait.waitForPresenceOfElement(10, dropdownElements);
        wait.waitForNumberOfElementsToBeMoreThan(10,dropdownElements,2);
        List<WebElement> dateOptions = this.getBrowser().findElements(dropdownElements);
        for (int i=0;i<carrierIndex.size();i++) {
            dateOptions.get(i).click();
        }
    }

    @Override
    public int anyDropdownIterator(By serviceDropdown, By serviceDropdownElements) {
        int i;
        wait = new WebDriverWaits(this.getBrowser());
        javaScript = new JavaScriptExecutorMethods(this.getBrowser());
        wait.waitForPresenceOfElement(20, tableDataLoadWait);
        WebElement serviceDropdownWebElement =  this.getBrowser().findElement(serviceDropdown);
        javaScript.clickWebElement(serviceDropdownWebElement);

        wait.waitForPresenceOfElement(20, serviceDropdownElements);
        List<WebElement> serviceOptions = this.getBrowser().findElements(serviceDropdownElements);
            i = serviceOptions.size()-2;
            WebElement element = serviceOptions.get(i);
            javaScript.clickWebElement(element);
         return i;
        }

    @Override
    public void getEmptyClickOperation(){
        super.getEmptyClickOperation();
    }

}
