package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
public Properties prop;
public WebDriver driver;

public WebDriver intializeDriver() throws IOException {
	
	FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");
	prop= new Properties();
	prop.load(fis);
	
/*	String browsername=prop.getProperty("browser");
//	if(browsername.contains("chrome")) {
//		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\java\\resources\\chromedriver.exe");
//	driver = new ChromeDriver();
//	driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	} */
	
	ChromeOptions option = new ChromeOptions();
    option.addArguments("--remote-allow-origins=*");

    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver(option);
	
	return driver;
}
public String getScreenShot(String testcaseName,WebDriver driver) throws IOException {
	TakesScreenshot ts = (TakesScreenshot)driver;
	File source= ts.getScreenshotAs(OutputType.FILE);
	File file= new File(System.getProperty("user.dir")+"//reports//"+testcaseName+".png");
	FileUtils.copyFile(source, file);
	return System.getProperty("user.dir")+"//reports//"+testcaseName+".png";
}
}
