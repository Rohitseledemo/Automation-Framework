package newDemoQaPages.demoPriorAgreementComparisonPage.totalSavings;

import newDemoQaPages.BaseModal;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.JavaScriptExecutorMethods;
import utilities.WebDriverWaits;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SurchargeSavingsModalFirstLevel extends BaseModal {
    WebDriverWaits wait;
    JavaScriptExecutorMethods javaScript;

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
        this.timePeriodDropdown = By.xpath("//div[@data-testid='prior-agreement-surcharge-savings-modal']" +
                "//button[contains(@class,'_Button_co7d3_5 dropdown-toggle btn btn-light')]");
        this.timePeriodDropdownElements = By.xpath("//div[contains(@class,'dropdown-menu show')]//a");
        this.carrierServiceDropdown = By.xpath("//div[@data-testid='prior-agreement-surcharge-savings-modal']" +
                "//button[@class=' d-flex justify-content-between align-items-center gap-2 w-100 dropdown-toggle btn btn-light']");
        this.carrierServiceDropdownElements = By.xpath("//div[contains(@class,'dropdown-menu show')]//a");
        this.downloadButton = By.xpath("//div[@data-testid='prior-agreement-surcharge-savings-modal']" +
                "//button[@data-download-status='ideal']");
    }

    public void surchargeDetailClick(){
        wait = new WebDriverWaits(this.getBrowser());
        wait.waitForPresenceOfElement(30,surchargeDetail);
        this.getBrowser().findElement(surchargeDetail).click();
    }
    @Override
    public void anyDropdownIterator(By dropdown, By dropdownElements, int careerIndex){
        wait = new WebDriverWaits(this.getBrowser());
        javaScript = new JavaScriptExecutorMethods(this.getBrowser());
        wait.waitForElementToBeClickable(30, dropdown);
        wait.waitForInvisibilityOfElementLocated(10,percentageOfSurchargeSpendDropdownWait);
        javaScript.clickWebElement(this.getBrowser().findElement(dropdown));

        wait.waitForPresenceOfElement(30, dropdownElements);
        List<WebElement> dateOptions = this.getBrowser().findElements(dropdownElements);
        dateOptions.get(careerIndex).click();
    }

    public boolean surchargeTableDataValidator(){
        float value;
        Set<Float> values = new HashSet<Float>();
        boolean notDuplicate = false;
        wait = new WebDriverWaits(this.getBrowser());
        javaScript = new JavaScriptExecutorMethods(this.getBrowser());
        wait.waitForElementToBeClickable(20,percentageOfSurchargeSpendDropdown);
        //dropdownOpenClick
        this.getBrowser().findElement(percentageOfSurchargeSpendDropdown).click();
        //dropdownGetSize
        List<WebElement> options = this.getBrowser().findElements(percentageOfSurchargeSpendDropdownElements);
        //dropdownCloseClick
        this.getBrowser().findElement(By.xpath("//h6")).click();
        for (int i = 1;i<options.size();i++) {
            anyDropdownIterator(percentageOfSurchargeSpendDropdown, percentageOfSurchargeSpendDropdownElements, i);
            wait.waitForVisibilityOfElement(10,totalSavingsFooterInSurcharge);
            value = Float.parseFloat(this.getBrowser().findElement(totalSavingsFooterInSurcharge).getText().
                    replace("$","").replace(",",""));
            if(values.add(value)){
                notDuplicate =  true;
            }
        }
        return notDuplicate;
    }

    public String anySurchargeTypeClick(String surchargeName){
        String surName;
        wait = new WebDriverWaits(this.getBrowser());
        wait.waitForVisibilityOfElement(20,surchargeType);
        List<WebElement> surcharges = this.getBrowser().findElements(surchargeType);
        for (int i =0;i<surcharges.size();i++) {
            try {
             surName = surcharges.get(i).getText();
            if (surName.equalsIgnoreCase(surchargeName)) {
                    surcharges.get(i).click();
                    return surName;}}
            catch (Exception e){
                surcharges = this.getBrowser().findElements(surchargeType);
                if (i < surcharges.size()) {
                    surName = surcharges.get(i).getText(); // Re-fetching the text again to validate.
                    if (surName.equalsIgnoreCase(surchargeName)) {
                        surcharges.get(i).click();
                        return surName;}}
                else {
                    System.err.println("Index out of bounds after re-fetching surcharges list.");}}}
        return "Value is null. " + surchargeName + " not found";
    }

}
