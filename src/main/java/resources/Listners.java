package resources;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.Base;
import resources.ExtentReporterNG;

public class Listners extends Base implements ITestListener{			
	
	ExtentReports extent= ExtentReporterNG.getReporterObject();
	ExtentTest test;
	WebDriver driver;
	    @Override		
	    public void onTestStart(ITestResult result) {					
	        // TODO Auto-generated method stub				
	    	test=extent.createTest(result.getMethod().getMethodName());
	    }

	    @Override		
	    public void onTestSuccess(ITestResult result) {					
	        // TODO Auto-generated method stub	
	    	test.log(Status.PASS, "Test Passed");		
	    }

	    @Override		
	    public void onTestFailure(ITestResult result) {					
	        // TODO Auto-generated method stub	
	    	test.fail(result.getThrowable());
	    	try {
	    	driver= (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
	    	}
	    	catch(Exception e) {
	    		e.printStackTrace();
	    	};
	    	
	    	String filepath=null;
	    	try {
				 filepath=getScreenShot(result.getMethod().getMethodName(),driver);
			} catch (IOException e) {
				e.printStackTrace();
			}
	    	test.addScreenCaptureFromPath(filepath, result.getMethod().getMethodName());
	        		
	    }	
	    @Override		
	    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {					
	        // TODO Auto-generated method stub				
	        		
	    }	

	    @Override		
	    public void onTestSkipped(ITestResult result) {					
	        // TODO Auto-generated method stub				
	        		
	    }				

    @Override		
    public void onFinish(ITestContext result) {					
        // TODO Auto-generated method stub				
        	extent.flush();	
    }		

//	    @Override		
//	    public void onStart(ITestResult result) {					
//	        // TODO Auto-generated method stub				
//	        		
//	    }
	    
}
