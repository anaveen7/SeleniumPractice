package TestCasesPackage;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import resources.Base;

public class HomePage extends Base{
	
	
	public WebDriver driver;
	LoginPage lp;
	@BeforeTest
	public void intilizeBrowser() throws IOException {
		driver=intializeDriver();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		PageFactory.initElements(driver,this);
		
	}
	@Test(dataProvider="getData")
	public void getLoginPage(String name,String mail) {
		driver.get(prop.getProperty("url"));
		lp = new LoginPage(driver);
		lp.getName().sendKeys(name);
		lp.getEmail().sendKeys(mail);
		lp.getSubmit().click();
	
		
	}
	@AfterTest
	public void CloseBrowser() throws IOException {
		driver.close();
	}
	@DataProvider
	public Object getData() {
		Object[][] data = new Object[1][2];
		data[0][0]="Naveen";
		data[0][1]="naveen.selenium@mailinator.com";
		return data;
	}
}
