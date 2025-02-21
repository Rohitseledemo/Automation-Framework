package newDemoQaPages.demoPriorAgreementComparisonPage.refundsForLateShipment;

import newDemoQaPages.BaseModal;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.WebDriverWaits;

import java.util.ArrayList;
import java.util.List;

public class ServiceSummaryModalThirdLevel extends BaseModal {
    WebDriverWaits wait;
    private float serviceSummaryTotalCount;

    public float getServiceSummaryTotalCount(){
        return serviceSummaryTotalCount;
    }

    public ServiceSummaryModalThirdLevel(){
        this.columnDataXpath = By.xpath("//div[@data-testid='service-summary']//tbody//tr//td");
        this.dataTestId = By.xpath("//div[@data-testid='service-summary']" +
                "//tr[@class='_StickyHeaderSecondary_1csbh_8']//th");
        //noDataText is in 4th level modal hence it's data-testid
        noDataAvailableText = By.xpath("//div[@data-testid='service-info']" +
                "//div[@class=' d-flex flex-row gap-2 blockquote ']");
        //closeModalBtn is in 4th level modal hence it's data-testid
        closeModalBtn = By.xpath("//div[@data-testid='service-info']//button[@class='btn-close']");
    }

    @Override
    public int headerClick(String headerName){
        return super.headerClick(headerName);
    }

    @Override
    public ArrayList<Float> columnData(int headerColumnCount) {
        wait = new WebDriverWaits(this.getBrowser());
        ArrayList<Float> columnValues = new ArrayList<Float>();
        List<WebElement> columnWebElements;

        By customXpath = this.generateDynamicXPath(columnDataXpath,headerColumnCount);
        columnWebElements = this.getBrowser().findElements(customXpath);
        this.serviceSummaryTotalCount = Float.parseFloat(columnWebElements.get
                (columnWebElements.size()-1).getText().replace("$","").replace(",",""));
        for (int i=0;i<columnWebElements.size()-1;i++) {
            float value = Float.parseFloat(columnWebElements.get(i).getText().replace("$", "")
                    .replace(",",""));
            columnValues.add(value);
        }
//        for printing arrayList data
//        for (Float columnValue : columnValues) {
//            System.out.println(columnValue);
//        }
        return columnValues;
    }

    @Override
    public List<WebElement> columnDataWebElements(int columnCount) {
        return super.columnDataWebElements(columnCount);
    }
}
