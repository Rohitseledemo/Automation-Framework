package newDemoQaPages.trackSavingsPage;

import newDemoQaPages.demoPriorAgreementComparisonPage.avgSavPerPkg.AvgSavPerPkgModalSecondLevel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.WebDriverWaits;

import java.util.ArrayList;
import java.util.List;

public class AvgSavPkgInTrackSavSecondLevel extends AvgSavPerPkgModalSecondLevel {
    WebDriverWaits wait;

    public AvgSavPkgInTrackSavSecondLevel(){
        this.columnDataXpath = By.xpath("//div[@data-testid='surcharge-info']//tbody//tr//td[@class='align" +
                "-middle text-wrap custom-header']");

    }

    @Override
    public ArrayList<Float> columnData(int headerColumnCount) {
        wait = new WebDriverWaits(this.getBrowser());
        ArrayList<Float> columnValues = new ArrayList<Float>();
        List<WebElement> columnWebElements;

        wait.waitForVisibilityOfElement(10,spinnerLoad);
        wait.waitForInvisibilityOfElementLocated(10,spinnerLoad);
        By customXpath = this.generateDynamicXPath(columnDataXpath,headerColumnCount);
        columnWebElements = this.getBrowser().findElements(customXpath);
        for (WebElement countValue : columnWebElements) {
            float value = Float.parseFloat(countValue.getText().replace("$", "")
                    .replace("%","").replace(",",""));
            columnValues.add(value);
        }
//        for printing arrayList data
        for (Float columnValue : columnValues) {
            System.out.println(columnValue);}
        return columnValues;
    }


}
