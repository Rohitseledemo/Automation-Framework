package utility;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptExecutorMethods {
    private final WebDriver jsDriver;

    public JavaScriptExecutorMethods(WebDriver jsDriver){
        this.jsDriver = jsDriver;
    }
    public WebDriver getJsDriver() {
        return jsDriver;  // To access the thread-safe Js WebDriver instance
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
