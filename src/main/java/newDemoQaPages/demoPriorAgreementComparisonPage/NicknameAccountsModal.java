package newDemoQaPages.demoPriorAgreementComparisonPage;
import newDemoQaPages.BaseModal;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.JavaScriptExecutorMethods;
import utilities.WebDriverWaits;

public class NicknameAccountsModal extends BaseModal {
    JavaScriptExecutorMethods javaScript;
    WebDriverWaits wait;

    private By submitBtn;
    private By nicknameInputField;
    private By nicknameDropdown;
    private By nicknameDropdownElements;

    public By getNicknameDropdown(){
        return nicknameDropdown;
    }
    public By getNicknameDropdownElements(){
        return nicknameDropdownElements;
    }

    public NicknameAccountsModal(){
        this.modalTitle = By.cssSelector("div.modal-title");
        this.closeModalBtn = By.xpath("//div[@class='modal-header']//button[@class='btn-close']");
        this.submitBtn = By.xpath("//button[@class='d-flex gap-2 btn btn-primary btn-sm']");
        this.dataTestId = By.xpath("//table[@class='x-table-bordered custom-table table table-striped " +
                "table-hover']//thead//tr//th");
        this.nicknameInputField = By.xpath("//input[@class='x-text-input']");
        this.nicknameDropdown = By.xpath("//div[@data-testid='prior-agreement-surcharge-detail-service-" +
                "surcharge-modal']//thead//tr//td[4]");
        this.nicknameDropdownElements = By.xpath("//div[@class='show dropdown']//a");
    }

    public void nicknameDropdownInSurchargeSavingsClick(){
        wait = new WebDriverWaits(this.getBrowser());
        javaScript = new JavaScriptExecutorMethods(this.getBrowser());
        wait.waitForElementToBeClickable(30,nicknameDropdown);
        this.getBrowser().findElement(nicknameDropdown).click();
    }

    public boolean submitBtnClick(){
        wait = new WebDriverWaits(this.getBrowser());
        javaScript = new JavaScriptExecutorMethods(this.getBrowser());
        wait.waitForElementToBeClickable(30,submitBtn);
        return javaScript.clickWebElement(this.getBrowser().findElement(submitBtn));
    }

    public String addNicknameValue(){
        wait = new WebDriverWaits(this.getBrowser());
        javaScript = new JavaScriptExecutorMethods(this.getBrowser());
        wait.waitForVisibilityOfElement(30,nicknameInputField);
        WebElement inputField = this.getBrowser().findElements(nicknameInputField).get(1);
        inputField.clear();
        String str = generateRandomString(2);
        inputField.sendKeys(str);
        return str;
    }

}
