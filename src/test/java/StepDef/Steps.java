package StepDef;

import java.util.ResourceBundle;
import java.util.logging.LogManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.util.Assert;
import com.mongodb.diagnostics.logging.Logger;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;

public class Steps {
	WebDriver driver; 
	MyAccountPage myac;
	LoginPage lp;
	Logger logger;
	//String url="https://tutorialsninja.com/demo";
	
	@Before
	public void setup()
	{
		//for logging
		logger=LogManager.getLogger(this.getClass());
		rb=ResourceBundle.getBundle("config");
		br=rb.getString("browser");
		
	}
	@After
	public void teardown()
	{
		
	}
	@Given("User Launch browser")
	public void user_launch_browser() {
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		logger.info("browser is launched");
	   
	}

	@And("opens URL {string}")
	public void opens_url(String url) {
		driver.get(url);
		logger.info("Application is launched"+url);
	   
	}

	@When("User navigate to MyAccount menu")
	public void user_navigate_to_my_account_menu() {
		driver.findElement(By.xpath("//*[@id=\'top-links\']/ul/li[2]/a/span[1]")).click();
	   
	}

	@And("click on Login")
	public void click_on_login() {
		driver.findElement(By.linkText("Login")).click();
		
		logger.info("Click on login button");
	   }

	

	@And("User enters Email as {string} and Password as {string}")
	public void email_and_password(String email,String pwd) {
	//driver.findElement(By.name("email")).sendKeys(email);
	//driver.findElement(By.name("password")).sendKeys(pwd);
		lp.txtusername(driver).sendKeys(email);
		lp.txtpassword(driver).sendKeys(pwd);
		logger.info("enter email and password");

	}

	@And("Click on Login button")
	public void click_on_login_button() {
	//driver.findElement(By.xpath("//*[@id=\'content\']/div/div[2]/div/form/input")).click();
		lp.btnlogin(driver).click();
		logger.info("click on login button");
	   
	}

	@Then("User navigates to MyAccount Page")
	public void user_navigates_to_my_account_page() {
		System.out.println("It open welcome screen..");
		myac=new MyAccountPage(driver);
		boolean targetpage=myac.isMyAccountPageExists();
		if(targetpage)
		{
			Assert.assertTrue(true);
			logger.info("Welcome to my account page");
		}
		else
		{
			Assert.assertTrue(false);
			logger.error("Failed");
		}
		driver.close();
		logger.info("browser closed");
	}



}
