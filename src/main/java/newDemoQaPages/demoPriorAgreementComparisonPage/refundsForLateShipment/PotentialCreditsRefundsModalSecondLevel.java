package newDemoQaPages.demoPriorAgreementComparisonPage.refundsForLateShipment;

import newDemoQaPages.BaseModal;
import org.openqa.selenium.By;
import utilities.WebDriverWaits;


public class PotentialCreditsRefundsModalSecondLevel extends BaseModal {
    WebDriverWaits wait;
    By serviceSummaryBtn;
    By carrierText;
//    public float getServiceSummaryTotalCount(){
//        return serviceSummaryTotalCount;
//    }
    public PotentialCreditsRefundsModalSecondLevel(){
      this.serviceSummaryBtn= By.xpath("//div[@data-testid='performance-reporting']" +
              "//button[text()='Service Summary']");
      this.carrierText = By.xpath("//div[@data-testid='performance-reporting']//span[@class='d-block h3 text-center']");
      this.carrierSelectorFedEx = By.xpath("//div[@class='d-flex flex-row align-items-center mb-4 gap-2']" +
              "//button[text()='FedEx']");
      this.carrierSelectorUPS = By.xpath("//div[@class='d-flex flex-row align-items-center mb-4 gap-2']" +
              "//button[text()='UPS']");
    }

    public void serviceSummaryBtnClick(){
        wait = new WebDriverWaits(this.getBrowser());
        wait.waitForPresenceOfElement(30,serviceSummaryBtn);
        this.getBrowser().findElement(serviceSummaryBtn).click();
    }

//    public void carrierSelectorValidator() {
//        wait = new WebDriverWaits(this.getBrowser());
//
//        wait.waitForPresenceOfElement(30, carrierSelectorUPS);
//        this.getBrowser().findElement(carrierSelectorUPS).click();
//        verifyCarrierText(carrierSelectorUPS, "UPS");
//
//        wait.waitForPresenceOfElement(30, carrierSelectorFedEx);
//        this.getBrowser().findElement(carrierSelectorFedEx).click();
//        verifyCarrierText(carrierSelectorFedEx, "FedEx");
//
//        }
//
//    public boolean verifyCarrierText(By locator, String expectedText) {
//        wait = new WebDriverWaits(this.getBrowser());
//        boolean textDisplayed = false;
//        wait.waitForPresenceOfElement(20,locator);
//        String actualText = this.getBrowser().findElement(locator).getText();
//        if (actualText.equals(expectedText)) {
//            textDisplayed = true;
//        }
//        else {
//            System.out.println("Text verification failed. Expected: " + expectedText + ", but got: " + actualText);
//        }
//        return textDisplayed;
//    }




}
