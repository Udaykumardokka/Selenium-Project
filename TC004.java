package demowebshop_login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC004 {
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String url="https://demowebshop.tricentis.com"; 
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();  
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get(url);
// Click on Login 
		driver.findElement(By.xpath("//a[@class='ico-login']")).click();   
		
// Login with the Valid credentials
	       
         driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("udaykumardokka@gmail.com");
		 driver.findElement(By.id("Password")).sendKeys("Tosca@1131");
	     driver.findElement(By.xpath("//input[@class='button-1 login-button']")).click();
	     
//Go to books category and click on Health Book, Add it to the Cart
	 
	   
	   driver.findElement(By.xpath("//a[normalize-space()='udaykumardokka@gmail.com']")).click();
	     Thread.sleep(3000);
	     driver.findElement(By.xpath("(//div[@class='picture'])[3]")).click();
	     WebElement element=driver.findElement(By.xpath("//input[@class='qty-input']"));
	     element.clear();
	     element.sendKeys("4");
	     driver.findElement(By.xpath("//div[@class='add-to-cart']")).click();

	     //  Go to Apparel & Shoes category and click on  genuine leather, Add it to the Cart
	     
	     driver.findElement(By.xpath("//ul[@class='list']/child::li[4]")).click();
	     driver.findElement(By.xpath("(//div[@class='product-item'])[7]")).click();
	     WebElement element1=driver.findElement(By.xpath("//input[@data-val='true']"));
	     element1.clear();
	     element1.sendKeys("3");
	     driver.findElement(By.xpath("//input[@id='add-to-cart-button-29']")).click();
	     
	    
//Click on Shopping Cart
  	     
      	 driver.findElement(By.xpath("(//span[@class='cart-label'])[1]")).click(); 
      	 
  // Retrieve price and quantity values
     	String priceString = driver.findElement(By.xpath("//span[@class='product-unit-price']")).getText();
     	String quantityString = driver.findElement(By.xpath("(//input[@class='qty-input'])[1]")).getAttribute("value");
     	double price = Double.parseDouble(priceString.replace("$", "")); 
     	int quantity = Integer.parseInt(quantityString);
      
// Calculate total price by multiplying price and quantity
     	double totalPrice = price * quantity;
     	System.out.println("The details of first product");
     	System.out.println("Price of first product: Rs = " + price);
     	System.out.println("Quantity of first product = " + quantity);
     	System.out.println("Total Price of first product: Rs = " + totalPrice);
        System.out.println("--------------------------------------------");  
  
 // Retrieve price and quantity values
     	String priceString1 = driver.findElement(By.xpath("(//span[@class='product-unit-price'])[2]")).getText();  
     	String quantityString1 = driver.findElement(By.xpath("(//input[@class='qty-input'])[2]")).getAttribute("value");
      
 // Convert the retrieved strings to numerical types
     	double price1 = Double.parseDouble(priceString1.replace("$", ""));
     	int quantity1 = Integer.parseInt(quantityString1);
      
// Calculate total price by multiplying price and quantity
     	double totalPrice1 = price1 * quantity1;
     	System.out.println("The details of second product");
     	System.out.println("Price of second product: Rs = " + price1);
     	System.out.println("Quantity of second product = " + quantity1);
     	System.out.println("Total Price	of second product: Rs = " + totalPrice1);
     	
     	double totalPrice3 = totalPrice + totalPrice1;
     	System.out.println("--------------------------------------------");
     	System.out.println("Total Price of Two Products : Rs = "+(totalPrice3));
     	
     	
     	
     	
     	String subprice = driver.findElement(By.xpath("//span[@class='product-price order-total']")).getText();
     	double SubTotal = Double.parseDouble(subprice.replace("$", ""));
     	System.out.println("Sub total price present at end : Rs = " + SubTotal);
     	 System.out.println("--------------------------------------------");
     	if(totalPrice3==SubTotal){
     		System.out.println("Sub Total price and sum of prices of 2 products are equal");
     	}else {
			System.out.println("Sub Total price and sum of prices of 2 products are not equal");
		}
	     

	}

}
