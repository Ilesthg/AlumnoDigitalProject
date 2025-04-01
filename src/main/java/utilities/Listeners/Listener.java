package utilities.Listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import reportss.ExtentLogger;
import reportss.ExtentReportsClass;
import reportss.SingletonExtentTest;

import java.util.Objects;

public class Listener implements ITestListener {
   private ExtentReports extentReports;
    private ExtentTest logger;


    @Override
    public void onTestStart(ITestResult result) {
        ITestListener.super.onTestStart(result);
       // logger =  ExtentReportsClass.createTest(result.getMethod().getMethodName());//This wont work bc, the extent report from method createTest is initialating a new ExtentReport, and here on listener we are initializing  other, and the visible will be the one which flush at the end
       logger = extentReports.createTest(result.getMethod().getMethodName());// For each test create his own logger(Extent test)
        SingletonExtentTest.getInstance().setExtentTest(logger);//********ExtentTest which will log into Report*********//

    }
    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Entre a OntestSuccess");
        ITestListener.super.onTestSuccess(result);
        if (result.getStatus() == ITestResult.SUCCESS) {
            System.out.println("Entre a IF OntestSuccess");
            logger.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " - Test case SUCCESS", ExtentColor.GREEN));
        }

        // Singleton_ExtentTest.getInstance().removeExtentObject();//*****************//


    }

    @Override
    public void onTestFailure(ITestResult result) {
        ITestListener.super.onTestFailure(result);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ITestListener.super.onTestSkipped(result);
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        ITestListener.super.onTestFailedWithTimeout(result);
    }

    @Override
    public void onStart(ITestContext context) {
        ITestListener.super.onStart(context);

 extentReports=  ExtentReportsClass.setUpExtentReports();//Init the extent Report
    }

    @Override
    public void onFinish(ITestContext context) {
        ITestListener.super.onFinish(context);
        if (Objects.nonNull(extentReports)) {
            extentReports.flush();// WE NEED TO FLUSH REPORTS, IF WE forget report wont be created
        }
    }
}
