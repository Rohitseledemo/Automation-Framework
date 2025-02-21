package newDemoQaPages;
import basePages.NewDemoBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.JavaScriptExecutorMethods;
import utilities.WebDriverWaits;

import java.util.List;

public class YearlyIncreasesPage extends NewDemoBasePage {
    WebDriverWaits wait;
    JavaScriptExecutorMethods javaScript;

    By groundSurchargesTab;
    By expressTab;
    By byServiceTab;
    By minimumChargeTab;
    By reactChartSurchargesNames;
    By tableSurchargesNames;
    By allServicesTabs;

    public YearlyIncreasesPage(){
      this.groundSurchargesTab = By.xpath("//div[@class='col-lg-9 d-flex justify-content-end align-items-" +
              "center']//button[text()='Ground Surcharges']");
      this.expressTab = By.xpath("//div[@class='col-lg-9 d-flex justify-content-end align-items-center']" +
              "//button[text()='Express']");
      this.byServiceTab = By.xpath("//div[@class='col-lg-9 d-flex justify-content-end align-items-center']" +
              "//button[text()='By Service']");
      this.minimumChargeTab = By.xpath("//div[@class='col-lg-9 d-flex justify-content-end align-items-" +
              "center']//button[text()='Minimum Charge']");
      this.reactChartSurchargesNames = By.xpath("//div[contains(@id,'reactgooglegraph')]//div[@aria-label='" +
              "A chart.']//*[name()='svg']//*[name()='g']//*[@text-anchor='middle'][1]");
      this.tableSurchargesNames = By.xpath("//table[contains(@class,'x-table-bordered ')]//tbody//tr//td[1]");
      this.allServicesTabs = By.xpath("//div[@class='d-flex justify-content-end align-items-center gap-1']//button");
      this.carrierServiceDropdown = By.xpath("//button[contains(@class,'w-100 dropdown-toggle btn btn-primary')]");
      this.carrierServiceDropdownElements = By.xpath("//div[contains(@class,'dropdown-menu show')]//a");
    }

    public boolean reactChartSurchargesNamesSize() {
        boolean equal = false;
        int reactSurcharges, tableSurcharges;
        wait = new WebDriverWaits(this.getBrowser());
        wait.waitForPresenceOfElement(10, allServicesTabs);

        List<WebElement> elementList = this.getBrowser().findElements(allServicesTabs);
        for (WebElement element : elementList) {
            wait.waitForElementToBeClickable(10,element);
            element.click();
            wait.waitForPresenceOfElement(8, reactChartSurchargesNames);
            reactSurcharges = this.getBrowser().findElements(reactChartSurchargesNames).size();
            wait.waitForPresenceOfElement(8, tableSurchargesNames);
            tableSurcharges = this.getBrowser().findElements(tableSurchargesNames).size();
        System.out.println("tableSurcharges - "+tableSurcharges);
        System.out.println("reactSurcharges - "+reactSurcharges);
            if (reactSurcharges == tableSurcharges) {
                equal = true;
            }
        }
          return equal;
    }


}
