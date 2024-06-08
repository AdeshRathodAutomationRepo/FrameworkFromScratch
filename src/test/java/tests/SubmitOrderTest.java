package tests;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
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
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.CartPage;
import pageObjects.ConfirmationPage;
import pageObjects.LandingPage;
import pageObjects.OrdersPage;
import pageObjects.PaymentPage;
import pageObjects.ProductCatalouge;
import testComponents.BaseTest;

public class SubmitOrderTest extends BaseTest {

	@Test(dataProvider="getData",groups="purchaseOrder")
	public void orderConfirmation(HashMap<String,String> input) throws IOException {
		ProductCatalouge pc = lp.logInIntoApplication(input.get("email"),input.get("password"));

		List<WebElement> items = pc.getProductList();
		pc.getProductNameAndClickOnAddToCart(input.get("product"));
		CartPage cp = pc.clickOnCartIcon();

		PaymentPage pp = cp.clickOnCheckoutButton();
		pp.provideCountry("India");
		pp.selectSpecifiedCountry("India");
		ConfirmationPage ccp = pp.clickOnPlaceOrder();
		System.out.println(ccp.getConfirmationText());
		Assert.assertEquals(ccp.getConfirmationText(), "THANKYOU FOR THE ORDER.");
	}
	
	@Test
	public void orderHistory() {
		ProductCatalouge pc = lp.logInIntoApplication("adeshrathod989@gmail.com", "Aa@8624037909");
		OrdersPage op= pc.clickOnOrders();
		Assert.assertTrue(op.verifyOrderPlaced("ADIDAS ORIGINAL"));
	}
	
	@DataProvider
	public Object[][] getData() throws IOException{
		
		List<HashMap<String,String>> data= getJsonDataToMap("C:\\Users\\Admin\\Desktop\\Framework\\SeleniumJava\\src\\test\\java\\data\\PurchaseOrder.json");
		return new Object[][] {{data.get(0)},{data.get(1)}};
		
		
//		HashMap<String,String> map= new HashMap<String, String>();
//		map.put("email", "adeshrathod989@gmail.com");
//		map.put("password", "Aa@8624037909");
//		map.put("product", "ADIDAS ORIGINAL");
//
//		HashMap<String,String> map1= new HashMap<String, String>();
//		map1.put("email", "rathodadesh@gmail.com");
//		map1.put("password", "Aa@12345678");
//		map1.put("product", "ZARA COAT 3");
		
		
//		return new Object[][] {{map},{map1}};
		
//		return new Object[][]  {{"adeshrathod989@gmail.com","Aa@8624037909","ADIDAS ORIGINAL"},{"rathodadesh@gmail.com","Aa@12345678","ZARA COAT 3"}};
	}

}
