package newDemoQaPages.switchToCompanyView;

import newDemoQaPages.BaseModal;
import org.openqa.selenium.By;
import utilities.JavaScriptExecutorMethods;
import utilities.WebDriverWaits;

public class SwitchToCompanyViewModal extends BaseModal {

    WebDriverWaits wait;
    JavaScriptExecutorMethods javaScript;

    protected By searchTextBox;
    protected By searchBtn;
    protected By companyList;

    public SwitchToCompanyViewModal(){
        this.searchTextBox = By.xpath("//input[@class='form-control']");
        this.searchBtn = By.xpath("//button[@class='btn btn-primary']//i");
        this.companyList = By.xpath("//div[@class='border rounded py-3']//div");
    }

    public void searchBtnClick(){
        wait = new WebDriverWaits(this.getBrowser());
        wait.waitForElementToBeClickable(10,searchBtn);
        this.getBrowser().findElement(searchBtn).click();
    }

    public void searchTextBoxValue(String companyName){
        wait = new WebDriverWaits(this.getBrowser());
        wait.waitForElementToBeClickable(10,searchTextBox);
        this.getBrowser().findElement(searchTextBox).sendKeys(companyName);
        wait.waitForNumberOfElementsToBeLessThan(5,companyList,2);
        this.getBrowser().findElement(companyList).click();
    }
}
