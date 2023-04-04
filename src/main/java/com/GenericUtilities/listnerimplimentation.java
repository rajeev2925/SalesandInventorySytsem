package com.GenericUtilities;




import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class listnerimplimentation implements ITestListener
{
	ExtentReports report;
	ExtentTest test;
	
	
//test start
	public void onTestStart(ITestResult result) 
	{
		String methodename = result.getMethod().getMethodName();
		test = report.createTest(methodename);
		Reporter.log(methodename+"-------->Testscript execution started");	
	}
	
//if test is success
	public void onTestSuccess(ITestResult result) 
	{
		String methodname=result.getMethod().getMethodName();
		test.log(Status.PASS,methodname+"----------->passed");
		Reporter.log(methodname+"--------->testscript execution is passed");
	}
//if test is failed
	public void onTestFailure(ITestResult result)
	{
		try {
		String screenshot =WebdriverUtilities.getScreenShot(BaseClass.edriver,result.getMethod().getMethodName());
		test.addScreenCaptureFromPath(screenshot);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	test.log(Status.FAIL,result.getThrowable());
	Reporter.log("execution failed");
	}
//if test is skipped
	public void onTestSkipped(ITestResult result) 
	{
	String methodname=result.getMethod().getMethodName();
	test.log(Status.SKIP, methodname+"----->skipped");
	test.log(Status.SKIP,result.getThrowable());
	Reporter.log(methodname+"--------------skipped");
	}
//extent report empty format 
	public void onStart(ITestContext context) 
	{
	ExtentSparkReporter htmlreport=new ExtentSparkReporter("./Extentreport/report.html");  
	htmlreport.config().setDocumentTitle("SDET-47");
	htmlreport.config().setTheme(Theme.DARK);
	htmlreport.config().setReportName("SALES AND INVENTORY");
	
	report=new ExtentReports();
	report.attachReporter(htmlreport);
	report.setSystemInfo("Base-Browser","chrome");
	report.setSystemInfo("OS","Windows");
	report.setSystemInfo("Base_URL","http://rmgtestingserver/domain/Sales_And_Inventory_System/pages/login.php");
	report.setSystemInfo("Reporter name","Rajeeva");
	
	}
//to finish
	public void onFinish(ITestContext context) 
	{
		report.flush();
	}

}
