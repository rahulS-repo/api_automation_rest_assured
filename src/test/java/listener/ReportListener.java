package listener;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.ExtentReportManager;

public class ReportListener implements ITestListener {

    private ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();
    private static final ExtentReports reports = ExtentReportManager.getReport();

//    public void onStart(ITestContext context) {
//        // not implemented
//    }

    public void onTestStart(ITestResult result) {
        // not implemented
        ExtentTest test = reports.createTest(result.getMethod().getMethodName());
        extentTest.set(test);
    }
    public void onTestSuccess(ITestResult result) {
        extentTest.get().log(Status.PASS,"Test "+result.getMethod().getMethodName()+"is successfully passed");
    }

    public void onTestFailure(ITestResult result) {
        // not implemented
        extentTest.get().log(Status.FAIL,"Test "+result.getMethod().getMethodName()+"is failed");
        extentTest.get().log(Status.FAIL,result.getThrowable());
    }

    public void onTestSkipped(ITestResult result) {
        // not implemented
        extentTest.get().log(Status.SKIP,"Test "+result.getMethod().getMethodName()+"is skipped");

    }

    public void onFinish(ITestContext context) {
        // not implemented
        reports.flush();
    }
}
