package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponent;

public class OrdersPage extends AbstractComponent {

	WebDriver driver;

	public OrdersPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//tbody/tr/td[2]")
	List<WebElement> orderedItems;

	boolean status;

	public boolean verifyOrderPlaced(String value) {
		for (int i = 0; i < orderedItems.size(); i++) {
			if (orderedItems.get(i).getText().equals(value)) {
				status = true;
				break;
			} else {
				status = false;
			}

		}
		return status;

	}

}
