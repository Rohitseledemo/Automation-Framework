package utility;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class WebDriverWaits {
    private final WebDriver driver;

    public WebDriverWaits(WebDriver driver){
          this.driver =driver ;
    }
    public WebDriver getDriver() {
        return driver;
    }

    public boolean waitForPresenceOfElement(int waitTime, By ele){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(waitTime));
        boolean result = true;
        try{
            wait.until(ExpectedConditions.presenceOfElementLocated(ele));
        }
        catch (Exception e){
            result = false;
        }
        return result;
    }

    public boolean waitForVisibilityOfElement(int waitTime, By ele){
        WebDriverWait wait = new WebDriverWait(getDriver(),Duration.ofSeconds(waitTime));
        boolean result = true;
        try{
            wait.until(ExpectedConditions.visibilityOfElementLocated(ele));
        }
        catch (Exception e){
            result = false;
        }
        return result;
    }
    public boolean waitForVisibilityOfWebElementLocated(int waitTime, WebElement ele){
        WebDriverWait wait = new WebDriverWait(getDriver(),Duration.ofSeconds(waitTime));
        boolean result = true;
        try{
            wait.until(ExpectedConditions.visibilityOf(ele));
        }
        catch (Exception e){
            result = false;
        }
        return result;
    }
    public boolean waitForInvisibilityOfWebElement(int waitTime, WebElement ele){
        WebDriverWait wait = new WebDriverWait(getDriver(),Duration.ofSeconds(waitTime));
        boolean result = true;
        try{
            wait.until(ExpectedConditions.invisibilityOf(ele));
        }
        catch (Exception e){
            result = false;
        }
        return result;
    }
    public boolean waitForInvisibilityOfElementLocated(int waitTime, By ele){
        WebDriverWait wait = new WebDriverWait(getDriver(),Duration.ofSeconds(waitTime));
        boolean result = true;
        try{
            wait.until(ExpectedConditions.invisibilityOfElementLocated(ele));
        }
        catch (Exception e){
            result = false;
        }
        return result;
    }
    public boolean waitForElementToBeClickable(int waitTime, By ele){
        WebDriverWait wait = new WebDriverWait(getDriver(),Duration.ofSeconds(waitTime));
        boolean result = true;
        try{
            wait.until(ExpectedConditions.elementToBeClickable(ele));
        }
        catch (Exception e){
            result = false;
        }
        return result;
    }
    public boolean waitForElementToBeClickable(int waitTime, WebElement ele){
        WebDriverWait wait = new WebDriverWait(getDriver(),Duration.ofSeconds(waitTime));
        boolean result = true;
        try{
            wait.until(ExpectedConditions.elementToBeClickable(ele));
        }
        catch (Exception e){
            result = false;
        }
        return result;
    }

    public boolean waitForJavascriptRendering(int waitTime, By ele){
        WebDriverWait wait = new WebDriverWait(getDriver(),Duration.ofSeconds(waitTime));
        boolean result = true;
        try{
            wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript
                    ("return document.readyState").equals("complete"));
        }
        catch (Exception e){
            result = false;
        }
        return result;
    }

    public boolean waitForStalenessOfWebElement(int waitTime, WebElement ele){
        WebDriverWait wait = new WebDriverWait(getDriver(),Duration.ofSeconds(waitTime));
        boolean result = true;
        try{
            wait.until(ExpectedConditions.stalenessOf(ele));
        }
        catch (Exception e){
            result = false;
        }
        return result;
    }

    public boolean waitForSerialNoToChange(int waitTime, By locator, String initialValue){
        FluentWait<WebDriver> wait = new FluentWait<>(getDriver())
                .withTimeout(Duration.ofSeconds(waitTime))
                .pollingEvery(Duration.ofMillis(100))
                .ignoring(Exception.class);
        return wait.until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                int elementIndex = driver.findElements(locator).size()-1;
                String currentValue = driver.findElements(locator).get(elementIndex).getText();
                System.out.println("currentValue - "+currentValue);
                System.out.println("initialValue - "+initialValue);
                return !initialValue.equals(currentValue);
            }
            @Override
            public String toString() {
                return String.format("value to change from '%s'", initialValue);
            }
        });

    }

    public boolean waitForValueToChange(int waitTime, By locator, String initialValue){
        WebDriverWait wait = new WebDriverWait(getDriver(),Duration.ofSeconds(waitTime));
        return wait.until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                WebElement element = driver.findElement(locator);
                String currentValue = element.getText();
                return !initialValue.equals(currentValue);
            }
            @Override
            public String toString() {
                return String.format("value to change from '%s'", initialValue);
            }
        });
    }

    public boolean waitForAttributeValueToChange(int waitTime, By locator,String initialValue){
        FluentWait<WebDriver> wait = new FluentWait<>(getDriver())
                .withTimeout(Duration.ofSeconds(waitTime))
                .pollingEvery(Duration.ofMillis(5))
                .ignoring(Exception.class);
        return wait.until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                String currentAttributeValue = driver.findElement(locator).getAttribute("data-download-status");
                System.out.println("currentAttributeValue - "+currentAttributeValue);
                return !initialValue.equals(currentAttributeValue);
            }
            @Override
            public String toString() {
                return String.format("attribute to change from '%s'", initialValue);
            }
        });
    }

    public boolean waitForNumberOfElementsToBeLessThan(int waitTime,By locator, int ele){
        WebDriverWait wait = new WebDriverWait(getDriver(),Duration.ofSeconds(waitTime));
        boolean result = true;
        try{
            wait.until(ExpectedConditions.numberOfElementsToBeLessThan(locator,ele));
        }
        catch (Exception e){
            result = false;
        }
        return result;
    }
    public boolean waitForNumberOfElementsToBeMoreThan(int waitTime, By locator, int ele){
        WebDriverWait wait = new WebDriverWait(getDriver(),Duration.ofSeconds(waitTime));
        boolean result = true;
        try{
            wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(locator,ele));
        }
        catch (Exception e){
            result = false;
        }
        return result;
    }



}