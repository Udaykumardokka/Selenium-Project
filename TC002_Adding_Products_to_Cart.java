package demowebshop_login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC002_Adding_Products_to_Cart {

	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		// launch chrome
		driver.get("https://demowebshop.tricentis.com/");
		
		// Maximize chrome
		driver.manage().window().maximize();
		
		// Login with User
		driver.findElement(By.xpath("//a[text()='Log in']")).click();
		driver.findElement(By.id("Email")).sendKeys("udaykumardokka@gmail.com");
		driver.findElement(By.id("Password")).sendKeys("Tosca@1131");
		driver.findElement(By.xpath("//input[@value=\"Log in\"]")).click();
		driver.findElement(By.xpath("//a[normalize-space()='udaykumardokka@gmail.com']")).isDisplayed();

		// Go to books category and click on Fiction Book, Add it to the Cart
	     
	     driver.findElement(By.xpath("//ul[@class='top-menu']/child::li[1]")).click();
	     driver.findElement(By.xpath("(//input[@value='Add to cart'])[2]")).click();
	     Thread.sleep(3000);
	     
	     // Go to Apparel & Shoes category and click on  Casual Golf Belt, Add it to the Cart
	     
	     driver.findElement(By.xpath("//ul[@class='list']/child::li[4]")).click();
	     driver.findElement(By.xpath("(//input[@value='Add to cart'])[4]")).click();
	     Thread.sleep(3000);
	     
	     //Go to Digital Downloads category and click on  Music 2, Add it to the Cart
	     
	     driver.findElement(By.xpath("//ul[@class='list']/child::li[5]")).click();
	     driver.findElement(By.xpath("(//input[@value='Add to cart'])[2]")).click();
	     Thread.sleep(3000);
	     
	     //Click on Shopping Cart
	     
	     driver.findElement(By.xpath("(//span[@class='cart-label'])[1]")).click(); 
	     
	     //Select all the check boxes of the items
	     
	     driver.findElement(By.xpath("(//input[@type='checkbox'])[1]")).click();
	     driver.findElement(By.xpath("(//input[@type='checkbox'])[2]")).click();
	     
	     Thread.sleep(3000);
	    
	     //Click on Update shopping Cart
	     Thread.sleep(3000);
	     
	     driver.findElement(By.xpath("//input[@name='updatecart']")).click();
	     
	     driver.findElement(By.xpath("//div[@class='order-summary-content']")).isDisplayed();
	     
	     //Click on Log out
	     
	     driver.findElement(By.xpath("//a[@class='ico-logout']")).click();
	     Thread.sleep(3000);
        
	     // Close Browser
	             driver.close(); 
	             driver.quit();
	}

}
