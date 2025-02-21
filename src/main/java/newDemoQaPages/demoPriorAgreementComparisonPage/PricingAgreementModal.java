package newDemoQaPages.demoPriorAgreementComparisonPage;

import newDemoQaPages.BaseModal;
import org.openqa.selenium.By;
import utilities.JavaScriptExecutorMethods;
import utilities.WebDriverWaits;

public class PricingAgreementModal extends BaseModal {
    WebDriverWaits wait;
    JavaScriptExecutorMethods javaScript;
    By modalFullscreen;
    public PricingAgreementModal(){
        this.modalTitle= By.xpath("//div[@data-testid='pricing-agreement']" +
                "//div[@class='d-flex flex-row gap-3 modal-title h4']");
        this.modalFullscreen = By.xpath("//div[@data-testid='pricing-agreement']" +
                "//div[@class='d-flex flex-row gap-3 modal-title h4']//i");
    }
    public void clickModalFullscreen(){
            wait = new WebDriverWaits(this.getBrowser());
            javaScript = new JavaScriptExecutorMethods(this.getBrowser());
            wait.waitForPresenceOfElement(40,modalFullscreen);
            javaScript.clickWebElement(this.getBrowser().findElement(modalFullscreen));
        }

    public boolean validateModalFullscreenClick(){
        String attribute;
        boolean clicked = false;
        wait = new WebDriverWaits(this.getBrowser());
        javaScript = new JavaScriptExecutorMethods(this.getBrowser());
        wait.waitForPresenceOfElement(40,modalFullscreen);
        attribute = this.getBrowser().findElement(modalFullscreen).getAttribute("class");
        if (attribute.contains("exit")){
            clicked = true;
        }
        return clicked;
    }

    }

