package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponent;

public class LandingPage extends AbstractComponent{
	WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	//Elements
	
	@FindBy(id="userEmail")
	WebElement email;

	@FindBy(id="userPassword")
	WebElement password;
	
	@FindBy(id="login")
	WebElement submitBtn;

	@FindBy(xpath="//*[contains(text(),'Incorrect')]")
	WebElement errorMsg;
	
	
	//Action Methods
	
	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client");
	}
	
	public ProductCatalouge logInIntoApplication(String emaill, String passwordd) {
		email.sendKeys(emaill);
		password.sendKeys(passwordd);
		submitBtn.click();
		
		ProductCatalouge pc = new ProductCatalouge(driver);
		return pc;
	}
	
	public String getErrorMsg() {
		return errorMsg.getText();
	}
	
	
}
