package Utilities;
import com.RahulShetty.pages.abstractcomponents.AbstractComponents;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import java.io.IOException;

public class TestListeners implements ITestListener {

    private static ExtentReports extent = ExtentManager.createInstance();
    private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();

    public void onTestStart(ITestResult result) {
        ExtentTest test = extent.createTest(result.getTestClass().getName()
                + "::" + result.getMethod().getMethodName());
        extentTest.set(test);
    }

    public void onTestSuccess(ITestResult result) {
        String logText = " <b> Test Method" +  result.getMethod().getMethodName() + "Successful </b>";
        Markup m = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
        extentTest.get().log(Status.PASS, m);
    }

    public void onTestFailure(ITestResult result) {
        String methodName = result.getMethod().getMethodName();
        String path = null;
        try {
            path = AbstractComponents.takeScreenshot(methodName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        extentTest.get().log(Status.FAIL, MarkupHelper.createLabel("Test method ->" + methodName + " Failed ", ExtentColor.RED));
        try {
            extentTest.get().addScreenCaptureFromPath(path);
        } catch (IOException e) {
            e.getMessage();
        }
    }

    public void onTestSkipped(ITestResult result) {
        String logText = " <b> Test Method" + result.getMethod().getMethodName() + "Skipped </b>";
        Markup m = MarkupHelper.createLabel(logText, ExtentColor.YELLOW);
        extentTest.get().log(Status.SKIP, m);
    }

    public void onFinish(ITestContext context) {
        if (extent != null) {
            extent.flush();
        }
    }
}
