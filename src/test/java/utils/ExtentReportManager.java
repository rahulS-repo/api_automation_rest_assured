package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager {
    private static ExtentReports extentReports;

    public static ExtentReports getReport(){
        ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter("reports/report.html");
        extentSparkReporter.config().setDocumentTitle("API Test Report");
        extentSparkReporter.config().setReportName("API Test Report");
        extentSparkReporter.config().setTheme(Theme.DARK);

        extentReports = new ExtentReports();
        extentReports.attachReporter(extentSparkReporter);
        extentReports.setSystemInfo("Environment", "QA");
        extentReports.setSystemInfo("Tester", "Your Name");
        return extentReports;
    }
}
