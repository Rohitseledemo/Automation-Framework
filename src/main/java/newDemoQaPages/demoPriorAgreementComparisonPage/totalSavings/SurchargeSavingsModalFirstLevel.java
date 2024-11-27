package newDemoQaPages.demoPriorAgreementComparisonPage.totalSavings;

import newDemoQaPages.BaseModal;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.WebDriverWaits;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SurchargeSavingsModalFirstLevel extends BaseModal {
    WebDriverWaits wait;

    By percentageOfSurchargeSpendDropdownElements;
    protected By totalSavingsFooterInSurcharge;
    By surchargeType;
    By surchargeDetail;

    public SurchargeSavingsModalFirstLevel(){
        this.percentageOfSurchargeSpendDropdownElements = By.xpath("//div[contains(@class,'dropdown-menu show')]//a");
        this.totalSavingsFooterInSurcharge = By.xpath("//tfoot[@class='custom-table-footer']//tr//th[5]");
        this.surchargeType = By.xpath("//span[@class='cursor-pointer align-middle text-underline x-page-link']");
        this.trendReportTab = By.xpath("//div[@data-testid='prior-agreement-surcharge-savings-modal']" +
                "//button[text()='Surcharge Trend Report']");
        this.surchargeDetail = By.xpath("//div[@data-testid='prior-agreement-surcharge-savings-modal']" +
                "//button[text()='Surcharge Detail']");
        this.carrierServiceDropdown = By.xpath("//div[@data-testid='prior-agreement-surcharge-savings-modal']" +
                "//button[@class=' d-flex justify-content-between align-items-center gap-2 w-100 dropdown-toggle btn btn-light']");
        this.carrierServiceDropdownElements = By.xpath("//div[contains(@class,'dropdown-menu show')]//a");
    }

    public void surchargeDetailClick(){
        wait = new WebDriverWaits(this.getBrowser());
        wait.waitForPresenceOfElement(30,surchargeDetail);
        this.getBrowser().findElement(surchargeDetail).click();
    }
    @Override
    public void anyDropdownIterator(By dropdown, By dropdownElements, int careerIndex){
        wait = new WebDriverWaits(this.getBrowser());
        wait.waitForPresenceOfElement(30, dropdown);
        this.getBrowser().findElement(dropdown).click();
        wait.waitForPresenceOfElement(30, dropdownElements);
        List<WebElement> dateOptions = this.getBrowser().findElements(dropdownElements);
        dateOptions.get(careerIndex).click();
    }

    public boolean surchargeTableDataValidator(){
        float value;
        Set<Float> values = new HashSet<Float>();
        boolean notDuplicate = false;
        wait = new WebDriverWaits(this.getBrowser());
        wait.waitForPresenceOfElement(30,percentageOfSurchargeSpendDropdown);
        //dropdownOpenClick
        this.getBrowser().findElement(percentageOfSurchargeSpendDropdown).click();
        //dropdownGetSize
        List<WebElement> options = this.getBrowser().findElements(percentageOfSurchargeSpendDropdownElements);
        //dropdownCloseClick
        this.getBrowser().findElement(By.xpath("//h6")).click();
        for (int i = 1;i<options.size();i++) {
            anyDropdownIterator(percentageOfSurchargeSpendDropdown, percentageOfSurchargeSpendDropdownElements, i);
            wait.waitForPresenceOfElement(10,totalSavingsFooterInSurcharge);
            value = Float.parseFloat(this.getBrowser().findElement(totalSavingsFooterInSurcharge).getText().
                    replace("$","").replace(",",""));
            if(values.add(value)){
                notDuplicate =  true;
            }
        }
        return notDuplicate;
    }

    public String anySurchargeTypeClick(String surchargeName){
        String surName = null;
        wait = new WebDriverWaits(this.getBrowser());
        wait.waitForPresenceOfElement(40,surchargeType);
        List<WebElement> surcharges = this.getBrowser().findElements(surchargeType);
        for (int i =0;i<surcharges.size();i++) {
             surName = surcharges.get(i).getText();
            if (surName.equalsIgnoreCase(surchargeName)) {
                surcharges.get(i).click();
                break;
            }
        }
        if(surName!=null){
            return surName;
        }
        return "Value is null. " + surchargeName + " not found";
    }

}
