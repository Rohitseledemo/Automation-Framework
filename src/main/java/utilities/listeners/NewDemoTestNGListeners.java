package utilities.listeners;
import basePages.NewDemoBasePage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.IRetryAnalyzer;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import java.io.IOException;

import org.testng.annotations.Test; // For TestNG
import utilities.email.newDemoEmail.NewDemoEmailSender;
import utilities.reportGenerator.NewDemoReportGenerator;

import static utilities.reportGenerator.NewDemoReportGenerator.getNewDemoQAReportObject;

public class NewDemoTestNGListeners extends NewDemoBasePage implements ITestListener {

    int count_totalTCs;
    int count_passedTCs;
    int count_skippedTCs;
    int count_failedTCs;

    private ExtentReports extent = NewDemoReportGenerator.getNewDemoQAReportObject();
    private static ThreadLocal<ExtentTest> extentTest =  new ThreadLocal<>();//Making an object Thread Safe
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    public ExtentReports getExtentReportsInstance(){
        return extent;
    }


    @Override
    public void onTestStart(ITestResult result) {

        count_totalTCs = count_totalTCs + 1;

        // Retrieve the @Test annotation on the method
        Test testAnnotation = result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(Test.class);
        // Fetching the testName from the annotation (falling back to method name if not provided)
        String testName = (testAnnotation != null && !testAnnotation.testName().isEmpty())
                ? testAnnotation.testName()
                : result.getMethod().getMethodName();
        getNewDemoQAReportObject();
        test.set(extent.createTest(testName));
        extentTest.set(test.get());// gives unique thread id
    }
    @Override
    public void onTestSuccess(ITestResult result) {
        count_passedTCs = count_passedTCs + 1;

        test.get().log(Status.PASS, "This test is passed");
    }
    @Override
    public void onTestFailure(ITestResult result) {
        count_failedTCs = count_failedTCs +1 ;

        // Get the retry analyzer for the test method
        IRetryAnalyzer retryAnalyzer = result.getMethod().getRetryAnalyzer(result);
        Test testAnnotation = result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(Test.class);
        // Fetching the testName from the annotation (falling back to method name if not provided)
        String testName = (testAnnotation != null && !testAnnotation.testName().isEmpty())
                ? testAnnotation.testName()
                : result.getMethod().getMethodName();

        // Check if retry analyzer is set and if we can retry the test
        if (retryAnalyzer != null && retryAnalyzer.retry(result)) {
            // Do not take a screenshot yet, as we are retrying the test
            System.out.println("Retrying test: " + testName);
            return;
        }
        extentTest.get().fail(result.getThrowable());
        String filePath;
        try {
            filePath= getScreenshot(testName);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            extentTest.get().addScreenCaptureFromPath(filePath, testName);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void onTestSkipped(ITestResult result) {
        count_skippedTCs = count_skippedTCs + 1;
    }
    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // not implemented
    }
    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        onTestFailure(result);
    }

    @Override
    public void onStart(ITestContext context) {
        // not implemented
    }
    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
        NewDemoEmailSender.sendEmail(count_totalTCs, count_passedTCs, count_failedTCs, count_skippedTCs);
    }

}
