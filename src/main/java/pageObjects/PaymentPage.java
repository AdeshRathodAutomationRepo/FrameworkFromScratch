package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponent;

public class PaymentPage extends AbstractComponent {
	WebDriver driver;

	public PaymentPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@placeholder='Select Country']")
	WebElement CountryTextBox;
	
	@FindBy(xpath = "//div[@class='actions']/a")
	WebElement placeOrder;

	@FindBy(xpath = "//section/button")
	List<WebElement> listOfCountries;

	public void provideCountry(String country) {
		CountryTextBox.click();
		CountryTextBox.sendKeys(country);
	}

	public void selectSpecifiedCountry(String country) {
		for (int i = 0; i < listOfCountries.size(); i++) {

			String names = listOfCountries.get(i).getText();

			if (names.equals(country)) {
				listOfCountries.get(i).click();
			}
		}
	}
	
	public ConfirmationPage clickOnPlaceOrder() {
		scrollDown();
		clickOnElementUsingJavascriptExecutor(placeOrder);
		
		ConfirmationPage ccp = new ConfirmationPage(driver);
		return ccp;
	}
}
