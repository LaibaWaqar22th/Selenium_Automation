package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import graphql.Assert;

public class BuyProduct {

	WebDriver driver;

	public BuyProduct(WebDriver driver) {
		this.driver = driver;
	}

	public void navigate(String baseUrl) {
		driver.get(baseUrl);
	}

	public void searchProduct(String searchBox, String product) {
		WebElement search = driver.findElement(By.id(searchBox));
		search.sendKeys(product);
		search.sendKeys(Keys.ENTER);
	}

	public void selectProduct(String productLink) {
		WebElement dress = driver.findElement(By.xpath(productLink));
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].setAttribute('target','_self')", dress);
		dress.click();
	}

	public void addProduct(String sizeOptions, int size, String cart) throws InterruptedException {
		Select options = new Select(driver.findElement(By.cssSelector(sizeOptions)));
		options.selectByIndex(size);

		Thread.sleep(4000);

		// Add to cart
		driver.findElement(By.id(cart)).click();
	}

	public void buyProduct(String total, String assertClass, String buy) {
		String haveClass = driver.findElement(By.cssSelector(total)).getAttribute("class");

		Assert.assertTrue(haveClass.equals(assertClass));

		driver.findElement(By.id(buy)).click();

	}

	public void tearDown(WebDriver driver) {
		driver.close();
	}

}
