package newDemoQaPages.demoInvoiceReviewPage;

import newDemoQaPages.demoPriorAgreementComparisonPage.AdvancedSearchModal;
import org.openqa.selenium.By;

public class AdvancedSearchModalInvoiceReview extends AdvancedSearchModal {
    public AdvancedSearchModalInvoiceReview(){
        this.serviceTypeDropDown = By.xpath("//div[@data-testid='prior-agreement-advanced-search-modal']" +
               "//div[@class='dropdown']//button[contains(@class,'undefined d-flex w-100 justify-content-between align" +
               "-items-center gap-1')]");
        this.serviceTypeDropDownElements = By.xpath("//div[contains(@class,'dropdown-menu show')]//a");
        this.searchBtn = By.xpath("//button[@type='submit']");
    }


}
