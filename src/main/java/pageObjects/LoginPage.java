package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	public WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}
	private By name=By.id("name");
	private By email=By.id("email");
	private By checkbox=By.id("agreeTerms");	
	private By submit=By.id("form-submita");	
//	@FindBy(id="form-submit") public
//	WebElement  getSubmit;

	
	
	public WebElement getName() {
		return driver.findElement(name);
	}
	public WebElement getEmail() {
		return driver.findElement(email);
	}
	public WebElement getCheckbox() {
		return driver.findElement(checkbox);
	}
	public WebElement getSubmit() {
		return driver.findElement(submit);
	}

}
