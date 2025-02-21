package newDemoQaPages;
import basePages.NewDemoBasePage;
import org.openqa.selenium.By;
import utilities.WebDriverWaits;

public class AboutUsPage extends NewDemoBasePage {
    WebDriverWaits wait;

    By tagLine;
    public AboutUsPage(){
        this.tagLine = By.xpath("//div[@class='col-xl-5 text-center mt-5 mt-xl-0']//div[@class='about_" +
                "arrows position-absolute']");
    }

    public boolean tagLineVisibility(){
       wait = new WebDriverWaits(this.getBrowser());
       wait.waitForPresenceOfElement(30,tagLine);
       return this.getBrowser().findElement(tagLine).isDisplayed();
    }
}
