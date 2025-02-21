package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptExecutorMethods {
    // ThreadLocal for thread-safe WebDriver
    private static final ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();

    public JavaScriptExecutorMethods(WebDriver driver) {
        threadLocalDriver.set(driver);
    }
    public static WebDriver getJsDriver() {
        return threadLocalDriver.get();
    }
    public boolean clickWebElement(WebElement element) {
        boolean result = true;
        JavascriptExecutor jsExec = (JavascriptExecutor) getJsDriver();
        try {
            jsExec.executeScript("arguments[0].click()", element);
        }
        catch (Exception e){
            result = false;
        }
        return result;
    }

    public boolean scrollWebElement(int x, int y) {
        boolean result = true;
        JavascriptExecutor jsExec = (JavascriptExecutor) getJsDriver();
        try {
            jsExec.executeScript("window.scrollTo(x, y);");
        }
        catch (Exception e){
            result = false;
        }
        return result;
    }
    public boolean scrollIntoViewWebElement(WebElement element) {
        boolean result = true;
        JavascriptExecutor jsExec = (JavascriptExecutor) getJsDriver();
        try {
            jsExec.executeScript("arguments[0].scrollIntoView(true);", element);
        }
        catch (Exception e){
            result = false;
        }
        return result;
    }
    public boolean launchZoomPercent(){
        boolean result = true;
        JavascriptExecutor jsExec = (JavascriptExecutor) getJsDriver();
        try {
            jsExec.executeScript("document.body.style.zoom='67%'");
        }
        catch (Exception e){
            result = false;
        }
        return result;
    }
}
