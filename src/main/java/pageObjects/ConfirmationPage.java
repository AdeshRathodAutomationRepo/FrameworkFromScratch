package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponent;
import dev.failsafe.internal.util.Assert;

public class ConfirmationPage extends AbstractComponent {
	WebDriver driver;
	
	public ConfirmationPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(tagName="h1")
	WebElement confirmationText;
	
	public String getConfirmationText() {
		return confirmationText.getText();
	}
}

