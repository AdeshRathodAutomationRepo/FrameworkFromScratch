package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import AbstractComponents.AbstractComponent;

public class ProductCatalouge extends AbstractComponent {

	WebDriver driver;

	public ProductCatalouge(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[contains(@class,'col-lg-4')]")
	List<WebElement> items;

	@FindBy(xpath = "//i[@class='fa fa-shopping-cart']/parent::button")
	WebElement cartIcon;

	@FindBy(xpath = "//*[@class='btn w-10 rounded']")
	List<WebElement> addToCartButton;

	By productt = By.xpath("//*[contains(@class,'col-lg-4')]");

	By productTextTag = By.tagName("b");

	By itemAddedToCart = By.id("toast-container");

	public List<WebElement> getProductList() {
		waitForElementToAppear(productt);
		return items;
	}

	public void getProductNameAndClickOnAddToCart(String productName) {
		for (int i = 0; i < items.size(); i++) {
			String itemName = items.get(i).findElement(productTextTag).getText();

			if (itemName.equals(productName)) {
				addToCartButton.get(i).click();
			}
		}

		waitForElementToAppear(itemAddedToCart);
	}

	public CartPage clickOnCartIcon() {
		clickOnElementUsingJavascriptExecutor(cartIcon);
		
		CartPage cp = new CartPage(driver);
		return cp;
	}

}
