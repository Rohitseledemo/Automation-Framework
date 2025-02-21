package newDemoQaPages.demoPriorAgreementComparisonPage;

import newDemoQaPages.BaseModal;
import org.openqa.selenium.By;
import utilities.JavaScriptExecutorMethods;
import utilities.WebDriverWaits;

public class AdvancedSearchModal extends BaseModal {
    WebDriverWaits wait;
    JavaScriptExecutorMethods javaScript;

    protected By serviceTypeDropDown;
    protected By serviceTypeDropDownElements;
    protected By searchBtn;

    public By getServiceTypeDropDown(){
        return serviceTypeDropDown;
    }
    public By getServiceTypeDropDownElements(){
        return serviceTypeDropDownElements;
    }

    public AdvancedSearchModal(){
     this.serviceTypeDropDown = By.xpath("//div[@data-testid='prior-agreement-advanced-search-modal']" +
             "//button[contains(@class,'undefined d-flex w-100 justify-content-between align-items-center')]");
     this.serviceTypeDropDownElements = By.xpath("//div[@data-testid='prior-agreement-advanced-search-" +
             "modal']//div[contains(@class,'dropdown-menu show')]//a");
     this.searchBtn = By.xpath("//div[@data-testid='prior-agreement-advanced-search-modal']//button[@type='submit']");
    }

    public void searchBtnClick(){
        wait= new WebDriverWaits(this.getBrowser());
        wait.waitForPresenceOfElement(10,searchBtn);
        this.getBrowser().findElement(searchBtn).click();
    }
}
