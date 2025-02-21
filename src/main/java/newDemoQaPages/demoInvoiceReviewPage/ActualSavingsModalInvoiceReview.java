package newDemoQaPages.demoInvoiceReviewPage;

import newDemoQaPages.demoPriorAgreementComparisonPage.refundsForLateShipment.ActualSavingsModalFirstLevel;
import org.openqa.selenium.By;
import utilities.WebDriverWaits;

public class ActualSavingsModalInvoiceReview extends ActualSavingsModalFirstLevel {
    WebDriverWaits wait;
    private By actualSavingsIframe;
    public By getActualSavingsIframe(){
        return actualSavingsIframe;
    }
    public ActualSavingsModalInvoiceReview(){
       this.actualSavingsIframe = By.xpath("//div[@class='h-70vh-max d-flex flex-column justify-content" +
               "-center align-items-center gap-2']//iframe");
       this.modalTitle = By.xpath("//div[@class='modal-title h4']");
    }

    public void switchToFrame(){
        wait = new WebDriverWaits(this.getBrowser());
        wait.waitForPresenceOfElement(30,actualSavingsIframe);
        this.getBrowser().switchTo().frame(this.getBrowser().findElement(actualSavingsIframe));
        wait.waitForPresenceOfElement(30,By.xpath("//cr-icon-button[@id='download']"));
        this.getBrowser().findElement(By.xpath("//cr-icon-button[@id='download']")).click();
    }
}
