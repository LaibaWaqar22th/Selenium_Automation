package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import pages.BuyProduct;

public class BuyProductTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver;
		String baseURL = "https://www.amazon.in/";

		// Launch the web browser
		System.setProperty("webdriver.chrome.driver", "..\\SeleniumJavaAssignment\\drivers\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");

		driver = new ChromeDriver(options);
		driver.manage().window().maximize();

		BuyProduct productObj = new BuyProduct(driver);

		String assertClass = "a-size-medium a-color-base a-text-bold";

		productObj.navigate(baseURL);

		productObj.searchProduct("twotabsearchtextbox", "dress");

		productObj.selectProduct("//div[@data-index='22']//descendant::a[@class='a-link-normal s-no-outline']");

		productObj.addProduct("select[id='native_dropdown_selected_size_name']", 2, "add-to-cart-button");

		productObj.buyProduct("span[id='sw-subtotal-item-count']", assertClass, "sc-buy-box-ptc-button");

		productObj.tearDown(driver);



	}

}
