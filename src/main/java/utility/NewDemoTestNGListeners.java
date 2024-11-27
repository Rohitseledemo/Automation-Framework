package utility;

import baseClass.NewDemoBasePage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.IRetryAnalyzer;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

import static utility.NewDemoReportGenerator.getNewDemoQAReportObject;

public class NewDemoTestNGListeners extends NewDemoBasePage implements ITestListener {
    private ExtentReports extent = NewDemoReportGenerator.getNewDemoQAReportObject();
    private static ThreadLocal<ExtentTest> extentTest =  new ThreadLocal<>();//Making an object Thread Safe
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    public ExtentReports getExtentReportsInstance(){
        return extent;
    }


    @Override
    public void onTestStart(ITestResult result) {
        getNewDemoQAReportObject();
        test.set(extent.createTest(result.getMethod().getMethodName()));
        extentTest.set(test.get());// gives unique thread id
    }
    @Override
    public void onTestSuccess(ITestResult result) {
        test.get().log(Status.PASS, "This test is passed");
    }
    @Override
    public void onTestFailure(ITestResult result) {
        // Get the retry analyzer for the test method
        IRetryAnalyzer retryAnalyzer = result.getMethod().getRetryAnalyzer(result);

        // Check if retry analyzer is set and if we can retry the test
        if (retryAnalyzer != null && retryAnalyzer.retry(result)) {
            // Do not take a screenshot yet, as we are retrying the test
            System.out.println("Retrying test: " + result.getMethod().getMethodName());
            return;
        }

        extentTest.get().fail(result.getThrowable());
        String filePath;
        try {
            filePath= getScreenshot(result.getMethod().getMethodName());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            extentTest.get().addScreenCaptureFromPath(filePath, result.getMethod().getMethodName());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void onTestSkipped(ITestResult result) {
        // not implemented
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
    }

}
