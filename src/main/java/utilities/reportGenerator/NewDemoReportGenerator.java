package utilities.reportGenerator;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class NewDemoReportGenerator {
    public static String reportPath;

    public static ExtentReports getNewDemoQAReportObject(){
        //ExtentHtmlReporter type reporter
        reportPath = System.getProperty("user.dir")+"//reports//newDemoQaReport//New-DemoQAReport.html";
        ExtentHtmlReporter reporter = new ExtentHtmlReporter(reportPath);
        reporter.config().setDocumentTitle("Test Results");
        reporter.config().setReportName("New-DemoQA Automation Results");
        reporter.config().setTheme(Theme.STANDARD);
        reporter.config().setEncoding("UTF-8");

        ExtentReports extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester", "Rohit Kumar");
        return extent;


    }
}
