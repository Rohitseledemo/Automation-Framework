package newDemoQaPages.demoRefundsPage;

import newDemoQaPages.BaseModal;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.WebDriverWaits;

import java.util.ArrayList;
import java.util.List;

public class DenialReasonsModal extends BaseModal {
    WebDriverWaits wait;
    private float denialReasonsModalTotalCount;

    public float getDenialReasonsModalTotalCount(){
        return this.denialReasonsModalTotalCount;
    }

    public DenialReasonsModal(){
        this.columnDataXpath = By.xpath("//div[@data-testid='denial-reason-modal']//tbody//tr//td");
         this.dataTestId = By.xpath("//div[@data-testid='denial-reason-modal']//thead//tr//th");
        this.modalTitle = By.xpath("//div[@data-testid='denial-reason-modal']//div[@class='modal-title h4']");

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
        this.denialReasonsModalTotalCount = Float.parseFloat(columnWebElements.get
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
}
