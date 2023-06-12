package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MainScript {
	public static void main(String[] args)throws InterruptedException{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://tutorialsninja.com/demo/index.php?route=account/login");
		
		//Login
		LoginPage.txtusername(driver).sendKeys("shinde.shweta93@gmail.com");
		LoginPage.txtpassword(driver).sendKeys("Demo@123");
		LoginPage.btnlogin(driver).click();
		Thread.sleep(2000);
		driver.close();
	}

}
