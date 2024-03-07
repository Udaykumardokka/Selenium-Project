package demowebshop_login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC005_Check_Out {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String url="https://demowebshop.tricentis.com"; 
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();  
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get(url );
// Click on Login 
		driver.findElement(By.xpath("//a[@class='ico-login']")).click();   
		
// Login with the Valid credentials
	       
         driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("udaykumardokka@gmail.com");
		 driver.findElement(By.id("Password")).sendKeys("Tosca@1131");
	     driver.findElement(By.xpath("//input[@class='button-1 login-button']")).click();
	     
//Go to books category and click on Health Book, Add it to the Cart
	 
	   
	     driver.findElement(By.xpath("//ul[@class='top-menu']//a[normalize-space()='Books']")).click();
	     Thread.sleep(3000);
	     driver.findElement(By.xpath("//h2[@class='product-title']//a[normalize-space()='Fiction']")).click();
	     WebElement element=driver.findElement(By.xpath("//input[@class='qty-input']"));
	     element.clear();
	     element.sendKeys("2");
	     driver.findElement(By.xpath("//div[@class='add-to-cart']")).click();

	     //  Go to Apparel & Shoes category and click on Blue jeans, Add it to the Cart
	     
	     driver.findElement(By.xpath("//ul[@class='top-menu']//a[normalize-space()='Apparel & Shoes']")).click();
	     Thread.sleep(3000);
	     driver.findElement(By.xpath("//h2[@class='product-title']//a[normalize-space()='Blue Jeans']")).click();
	     WebElement element1=driver.findElement(By.xpath("//input[@data-val='true']"));
	     element1.clear();
	     element1.sendKeys("3");
	     driver.findElement(By.xpath("//input[@class='button-1 add-to-cart-button']")).click();
	     Thread.sleep(3000);
	     
	    
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
	    // Click on accepting terms and conditions check box
     	driver.findElement(By.xpath("//input[@id='termsofservice']")).click();
     	//click on check out
     	driver.findElement(By.xpath("//button[@id='checkout']")).click();
     	boolean BillingAdress = driver.findElement(By.xpath("//input[@id='BillingNewAddress_FirstName']")).isDisplayed();
     	System.out.println(BillingAdress);
     	if (BillingAdress==true) {
     		driver.findElement(By.xpath("//input[@id='BillingNewAddress_Company']")).sendKeys("Rrootshell Technologies");
     		driver.findElement(By.xpath("//option[normalize-space(.)='India']")).click();
     		driver.findElement(By.xpath("//input[@id='BillingNewAddress_City']")).sendKeys("Hyderabad");
     		driver.findElement(By.xpath("//input[@id='BillingNewAddress_Address1']")).sendKeys("Hyderabad");
     		driver.findElement(By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']")).sendKeys("500038");
     		driver.findElement(By.xpath("//input[@id='BillingNewAddress_PhoneNumber']")).sendKeys("9182353304");
     		driver.findElement(By.xpath("//input[@onclick='Billing.save()']")).click();
     		
     	}else {
     		driver.findElement(By.xpath("//input[@onclick='Billing.save()']")).click();
     	}
     	Thread.sleep(4000);
     	driver.findElement(By.cssSelector("input[onclick='Shipping.save()']")).click();
     	
     	Thread.sleep(3000);
     	driver.findElement(By.xpath("//input[@id='shippingoption_1']")).click();
     	Thread.sleep(3000);
     	driver.findElement(By.cssSelector("input[class='button-1 shipping-method-next-step-button']")).click();
     	Thread.sleep(3000);
     	driver.findElement(By.cssSelector("input[class='button-1 payment-method-next-step-button']")).click();
     	Thread.sleep(3000);
     	driver.findElement(By.cssSelector("input[class='button-1 payment-info-next-step-button']")).click();
     	Thread.sleep(3000);
     	driver.findElement(By.xpath("//input[@value='Confirm']")).click();
     	Thread.sleep(5000);
     	boolean Thankyou = driver.findElement(By.xpath("//h1[normalize-space()='Thank you']")).isDisplayed();
     	System.out.println(Thankyou);
     	if(Thankyou==true) {
     		System.out.println("Thank you message is Visible");
     	}else {
     		System.out.println("Thank you message is not Visible");
     	}
     	String OrderNumber = driver.findElement(By.xpath("//li[contains(text(), 'Order number')]")).getText();
     	String OrderNo = (OrderNumber.replace("Order number: ", ""));
     	System.out.println("The order number in the Cart Section :"+OrderNo);
        driver.findElement(By.xpath("//a[normalize-space()='udaykumardokka@gmail.com']")).click();
     	Thread.sleep(3000);
     	driver.findElement(By.xpath("//a[@class='inactive'][normalize-space()='Orders']")).click();
     	Thread.sleep(3000);
     	String OrderNumber1 = driver.findElement(By.xpath("(//div[@class='section order-item'])[1]//Strong[contains(text(), 'Order Number')]")).getText();
     	
     	String OrderNo1 = (OrderNumber1.replace("Order Number: ", ""));
     	System.out.println("The order number in the Orders Section : "+OrderNo1);
     	
     	int NmericOrderNoCart = Integer.parseInt(OrderNo);
     	int NumericOrderNoOrders = Integer.parseInt(OrderNo1);
     	
     	if (NmericOrderNoCart==NumericOrderNoOrders) {
     		System.out.println("Order Number in the cart is Updated in the orders section");
      
     	}else {
     		System.out.println("Order Number in the cart is not Updated in the orders section");
     	}
     	driver.findElement(By.xpath("//a[normalize-space()='Log out']")).click();
	    Thread.sleep(3000);
	        
	     // Close Browser
	             driver.close(); 
	             driver.quit();
}
}