package newDemoQaPages;

import baseClass.NewDemoBasePage;
import newDemoQaPages.demoPriorAgreementComparisonPage.PackageProfileModal;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.JavaScriptExecutorMethods;
import utility.WebDriverWaits;

import java.util.List;
import java.util.logging.Logger;

public class BaseModal extends NewDemoBasePage {
    private final Logger logger = Logger.getLogger(PackageProfileModal.class.getName());

    WebDriverWaits wait;
    JavaScriptExecutorMethods javaScript;

    protected By modalTitle;
    protected By parentTabs;
    protected By childTabs;

    public By getModalTitle(){
        return modalTitle;
    }
    public BaseModal() {
        this.modalTitle = By.cssSelector("div.modal-title");
    }
    public By getParentTabs(){
        return this.parentTabs;
    }
    public By getChildTabs(){
        return this.childTabs;
    }



    public boolean closeModal() {
        javaScript = new JavaScriptExecutorMethods(this.getBrowser());
        return javaScript.clickWebElement(this.getBrowser().findElement(closeModalBtn));
    }

    public boolean isModalDisplayed(By modalLocator) {
        wait = new WebDriverWaits(this.getBrowser());
        wait.waitForPresenceOfElement(40,modalLocator);
        return this.getBrowser().findElement(modalLocator).isDisplayed();
    }


    public String modalTitleValidation() {
        wait = new WebDriverWaits(this.getBrowser());
        wait.waitForVisibilityOfElement(30, modalTitle);
        return this.getBrowser().findElement(modalTitle).getText();
    }

    public boolean allTabsDataValidation() {
        boolean result = true;
        int failCount = 0;

        wait = new WebDriverWaits(this.getBrowser());

        wait.waitForPresenceOfElement(5,childTabs);
        List<WebElement> parentTabElements = getBrowser().findElements(parentTabs);

        for (WebElement parentTabElement : parentTabElements) {
            wait.waitForElementToBeClickable(10,parentTabElement); //newly add for element click reference exception
            parentTabElement.click();
            wait.waitForPresenceOfElement(5,childTabs);
            List<WebElement> childTabElements = getBrowser().findElements(childTabs);

            for (WebElement childTabElement : childTabElements) {
                wait.waitForElementToBeClickable(10,childTabElement); //newly add for element click reference exception
                childTabElement.click();

                if (isNoDataFound()) {
                    failCount++;
                    logger.info("No Record Found in " + parentTabElement.getText() + " of " +
                            childTabElement.getText());}}}

        logger.info("FailCount - " + failCount);
        if (failCount > 0) {
            result = false;
        }
        return result;
    }
    public boolean childTabsIterator(By childTabs) {
        int failCount = 0;
        boolean result = true;
        wait = new WebDriverWaits(this.getBrowser());
        wait.waitForPresenceOfElement(5, childTabs);

        List<WebElement> childTabElements = getBrowser().findElements(childTabs);
        for (WebElement childTabElement : childTabElements) {
            childTabElement.click();
            wait.waitForPresenceOfElement(3, tableDataLoadWait);

            if (isNoDataFound()) {
                failCount++;
                System.out.println("No Record Found in " + childTabElement.getText());
            }
            if (failCount > 0) {
                result = false;
            }
        }
        return result;
    }

    public boolean tableDataVisibility(){
        wait = new WebDriverWaits(this.getBrowser());
        wait.waitForPresenceOfElement(30,tableDataLoadWait);
        return this.getBrowser().findElement(tableDataLoadWait).isDisplayed();
    }


}

