package basicFramework;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenClass implements ITestListener
{
	
	ExtentSparkReporter sparkreporter;
	ExtentReports extentreports;
	ExtentTest extenttest;
	String repName;
	public  void onStart(ITestContext context)//which testcase got executed that details will be here
	{
		String timeStamp = new SimpleDateFormat("yyyy.mm.dd.HH.mm.ss").format(new Date());
		repName = "Test-Report-"+timeStamp+".html";
		
		
		
		
		sparkreporter = new ExtentSparkReporter("./Reports/" +repName);
		sparkreporter.config().setDocumentTitle("My Test Reports");
		sparkreporter.config().setReportName("Tester");
		sparkreporter.config().setTheme(Theme.DARK);
		
		extentreports = new ExtentReports();
		
		
		extentreports.setSystemInfo("username",System.getProperty("user.name"));
		extentreports.attachReporter(sparkreporter);
		String OS = context.getCurrentXmlTest().getParameter("os");
		extentreports.setSystemInfo("OS",OS);
		String browser = context.getCurrentXmlTest().getParameter("browser");
		extentreports.setSystemInfo("Browser",browser);
		System.out.println("Execution Started");
	}
	public void onTestSuccess(ITestResult result)
	{
		ExtentTest t = extentreports.createTest(result.getName());
		t.log(Status.PASS,"Execution is Success");
		System.out.println("Testcase Success");
	}
	
	public void onTestFailure(ITestResult result)
	{
		ExtentTest t = extentreports.createTest(result.getName());
		t.log(Status.FAIL,"Execution is Fail");
		System.out.println("Testcase Failed");}
	public void onTestSkipped(ITestResult result)
	{
		ExtentTest t = extentreports.createTest(result.getName());
		t.log(Status.SKIP,"Execution is Skipped");
		System.out.println("Testcase Skipped");
	}
	public void onFinish(ITestContext context)
	{
		System.out.println("Execution Finished");
		extentreports.flush();
	}
		
}
