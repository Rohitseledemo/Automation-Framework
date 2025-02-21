package newDemoQaPages;

import basePages.NewDemoBasePage;
import org.openqa.selenium.By;
import utilities.JavaScriptExecutorMethods;
import utilities.WebDriverWaits;

public class NewDemoLandingPage extends NewDemoBasePage {
    WebDriverWaits wait;
    JavaScriptExecutorMethods javaScript;
    By priorAgreementComparisonTab;
    By refundsTab;
    By invoiceReviewTab;
    By claimsTab;
    By yearlyIncreasesTab;
    By aboutUs;
    By trackSavingsTab;

    public NewDemoLandingPage(){
        this.priorAgreementComparisonTab = By.xpath("//ul[@class='menu_links d-none d-xl-flex gap-3']" +
                "//li//a[text()='Prior Agreement Comparison']");
        this.trackSavingsTab = By.xpath("//ul[@class='menu_links d-none d-xl-flex gap-3']//a[@href='/track-savings']");
        this.refundsTab = By.xpath("//ul[@class='menu_links d-none d-xl-flex gap-3']" +
                "//li//a[text()='Refunds']");
        this.invoiceReviewTab = By.xpath("//ul[@class='menu_links d-none d-xl-flex gap-3']//a[text()=" +
                "'Invoice Review']");
        this.yearlyIncreasesTab = By.xpath("//ul[@class='menu_links d-none d-xl-flex gap-3']//li//a[text()='Yearly Increases']");
        this.claimsTab = By.xpath("//ul[@class='menu_links d-none d-xl-flex gap-3']//li//a[text()='Claims']");
        this.aboutUs = By.xpath("//ul[@class='menu_links d-none d-xl-flex gap-3']//li//a[text()='About Us']");
    }

    public void clickOnPriorAgreementComparisonTile() {
        wait = new WebDriverWaits(this.getBrowser());
        javaScript = new JavaScriptExecutorMethods(this.getBrowser());
        wait.waitForElementToBeClickable(20, priorAgreementComparisonTab);
        this.getBrowser().findElement(priorAgreementComparisonTab).click();
    }

    public void clickOnRefundsTile() {
        wait = new WebDriverWaits(this.getBrowser());
        javaScript = new JavaScriptExecutorMethods(this.getBrowser());
        wait.waitForElementToBeClickable(20, refundsTab);
        this.getBrowser().findElement(refundsTab).click();
    }
    public void clickOnInvoiceReviewTile() {
        wait = new WebDriverWaits(this.getBrowser());
        javaScript = new JavaScriptExecutorMethods(this.getBrowser());
        wait.waitForElementToBeClickable(20, invoiceReviewTab);
        this.getBrowser().findElement(invoiceReviewTab).click();

    }
    public void clickOnClaimsTab() {
        wait = new WebDriverWaits(this.getBrowser());
        javaScript = new JavaScriptExecutorMethods(this.getBrowser());
        wait.waitForElementToBeClickable(20, claimsTab);
        this.getBrowser().findElement(claimsTab).click();

    }
    public void clickOnYearlyIncreasesTab() {
        wait = new WebDriverWaits(this.getBrowser());
        javaScript = new JavaScriptExecutorMethods(this.getBrowser());
        wait.waitForElementToBeClickable(20, yearlyIncreasesTab);
        this.getBrowser().findElement(yearlyIncreasesTab).click();
    }
    public void clickOnAboutUs() {
        wait = new WebDriverWaits(this.getBrowser());
        javaScript = new JavaScriptExecutorMethods(this.getBrowser());
        wait.waitForElementToBeClickable(20, aboutUs);
        this.getBrowser().findElement(aboutUs).click();
    }
    public void clickOnTrackSavingsTab() {
        wait = new WebDriverWaits(this.getBrowser());
        javaScript = new JavaScriptExecutorMethods(this.getBrowser());
        wait.waitForElementToBeClickable(20, trackSavingsTab);
        this.getBrowser().findElement(trackSavingsTab).click();
    }

}
