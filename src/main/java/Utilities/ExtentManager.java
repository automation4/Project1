package Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;

public class ExtentManager {
    private static ExtentReports extent;

    public static ExtentReports createInstance(){

        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+ "\\extentreports\\ExtentReport.html");
        htmlReporter.config().setDocumentTitle("Automation");
        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
        htmlReporter.config().setReportName("Automating Amazon POM, TNG report");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("Browser","Chrome");
        extent.setSystemInfo("Site","Amazon");
        extent.setSystemInfo("Build","4");
        extent.setSystemInfo("Tester","HP");

        return extent;
    }
}
