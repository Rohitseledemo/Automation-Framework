package newDemoQaPages.demoPriorAgreementComparisonPage;

import newDemoQaPages.BaseModal;
import org.openqa.selenium.By;

public class PackageProfileModal extends BaseModal {

    public PackageProfileModal(){
     this.downloadButton = By.xpath("//div[@data-testid='package-profile']//button[@data-download-status='ideal']");
     this.parentTabs = By.xpath("//div[@data-testid='package-profile']//div[@class='d-flex gap-2']//button");
     this.childTabs = By.xpath("//div[@data-testid='package-profile']" +
             "//div[@class='d-flex flex-row justify-content-center align-items-center gap-2']//button");
     this.timePeriodDropdown = By.xpath("//div[@data-testid='package-profile']//button[contains(@class," +
             "'_Button_co7d3_5 dropdown-toggle btn btn-light')]");
     this.timePeriodDropdownElements = By.xpath("//div[contains(@class,'dropdown-menu show')]//a");

     this.carrierServiceDropdown = By.xpath("//div[@data-testid='package-profile']//div[@class='w-100 " +
             "dropdown']//button");
     this.carrierServiceDropdownElements = By.xpath("//div[@data-testid='package-profile']" +
             "//div[@class='shadow border-0 dropdown-menu show']//a");
     this.noData = By.xpath("//div[@data-testid='package-profile']//div[@class=' d-flex flex-row gap-2 blockquote ']");
     this.tableDataLoadWait = By.xpath("//div[@data-testid='package-profile']//div[@class='table-responsive']");
    }

    public boolean validateAllTabsForDropdown(By getCarrierServiceDropdown, By getCarrierServiceDropdownElements,int iterations){
        boolean result = true;
        for (int i= 0;i<=iterations;i++){
        anyDropdownIterator(getCarrierServiceDropdown,getCarrierServiceDropdownElements,i);
        result = allTabsDataValidation();
        }
        return result;
    }

   }


