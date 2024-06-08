package tests;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.CartPage;
import pageObjects.ConfirmationPage;
import pageObjects.LandingPage;
import pageObjects.PaymentPage;
import pageObjects.ProductCatalouge;
import testComponents.BaseTest;

public class ErrorValidationTest extends BaseTest {

	@Test(groups= {"ErrorHandeling"},retryAnalyzer=testComponents.Retry.class)
	public void loginErrorValidation() throws IOException {
		lp.logInIntoApplication("adeshrathod989@gmail.com", "Aa@8624037");
		Assert.assertNotEquals("Incorrect email or password.", lp.getErrorMsg());
	}
	
	@Test
	public void productErrorValidation() throws IOException {
		ProductCatalouge pc = lp.logInIntoApplication("adeshrathod989@gmail.com", "Aa@8624037909");

		List<WebElement> items = pc.getProductList();
		pc.getProductNameAndClickOnAddToCart("ADIDAS ORIGINAL");
		CartPage cp = pc.clickOnCartIcon();

		PaymentPage pp = cp.clickOnCheckoutButton();
		pp.provideCountry("India");
		pp.selectSpecifiedCountry("India");
		ConfirmationPage ccp = pp.clickOnPlaceOrder();
		System.out.println(ccp.getConfirmationText());
		Assert.assertEquals(ccp.getConfirmationText(), "THANKYOU FOR THE ORDER.");
		
	}

}
