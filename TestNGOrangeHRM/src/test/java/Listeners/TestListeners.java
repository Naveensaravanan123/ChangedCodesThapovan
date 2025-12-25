package Listeners;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class TestListeners implements ITestListener {
	
	ExtentReports extent;
	ExtentTest test;
	
	@Override 
	public void onStart(ITestContext context) {
		ExtentSparkReporter reporter = new ExtentSparkReporter("./Reports/TestReport_"+System.currentTimeMillis()+".html");
		extent = new ExtentReports();
		extent.attachReporter(reporter);
	}
	
	@Override
	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getName());
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		test.pass("Test Passed.");
		attachScreenshot(result);

	}
	
	@Override
	public void onTestFailure(ITestResult result) {
		test.pass("Test Failed.");
		test.fail(result.getThrowable());
		attachScreenshot(result);
	}
	
	public void attachScreenshot(ITestResult result) {
		WebDriver driver = (WebDriver) result.getTestContext().getAttribute("driver");
		
		try {
			File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			
			String screenshotPath = System.getProperty("user.dir")+"/Screenshots/"+result.getName()+".png";
			FileUtils.copyFile(screenshotFile, new File(screenshotPath));
			
			test.addScreenCaptureFromPath(screenshotPath);
		}catch(Exception e) {
			e.getStackTrace();
		}
	}
	
	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
	}
	
}



