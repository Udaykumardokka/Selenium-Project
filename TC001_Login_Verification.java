package demowebshop_login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC001_Login_Verification {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		//launch chrome
		driver.get("https://demowebshop.tricentis.com/");
		
		//Maximize chrome
		driver.manage().window().maximize();
		
		//invalid password
		driver.findElement(By.xpath("//a[text()='Log in']")).click();
		driver.findElement(By.id("Email")).sendKeys("udaykumardokka@gmail.com");
		driver.findElement(By.id("Password")).sendKeys("Tosca");
		driver.findElement(By.xpath("//input[@value=\"Log in\"]")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Login was unsuccessful. Please correct the errors ')]")).isDisplayed();
		driver.findElement(By.xpath("//li[normalize-space()='The credentials provided are incorrect']")).isDisplayed();
		
		//Wrong Email
		driver.findElement(By.id("Email")).clear();
		driver.findElement(By.id("Email")).sendKeys("sdasdsadas@gmail.com");
		driver.findElement(By.id("Password")).sendKeys("Tosca@1131");
		driver.findElement(By.xpath("//input[@value=\"Log in\"]")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Login was unsuccessful. Please correct the errors ')]")).isDisplayed();
		driver.findElement(By.xpath("//li[normalize-space()='No customer account found']")).isDisplayed();
		
		// Invalid Email
		driver.findElement(By.id("Email")).clear();
		driver.findElement(By.id("Email")).sendKeys("udaykumardokka");
		driver.findElement(By.xpath("//input[@value=\"Log in\"]")).click();
		driver.findElement(By.xpath("//span[@for=\"Email\"]")).isDisplayed();
		String s1 = driver.findElement(By.xpath("//span[@for=\"Email\"]")).getText();
		System.out.println(s1);
		
		
		driver.findElement(By.id("Email")).clear();
		driver.findElement(By.id("Email")).sendKeys("udaykumardokka@gmail.com");
		driver.findElement(By.id("Password")).sendKeys("Tosca@1131");
		driver.findElement(By.xpath("//input[@value=\"Log in\"]")).click();
		driver.findElement(By.xpath("//a[normalize-space()='udaykumardokka@gmail.com']")).isDisplayed();
		driver.findElement(By.xpath("//a[normalize-space()='Log out']")).click();
		driver.close();		
	}

}
