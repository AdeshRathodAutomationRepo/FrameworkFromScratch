package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponent;

public class CartPage extends AbstractComponent {
	WebDriver driver;
	
	public CartPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="(//li//button[@class='btn btn-primary'])[2]")
	WebElement checkOutButton;
	
	public PaymentPage clickOnCheckoutButton() {
		checkOutButton.click();
		
		PaymentPage pp = new PaymentPage(driver);
		return pp;
	}
}

