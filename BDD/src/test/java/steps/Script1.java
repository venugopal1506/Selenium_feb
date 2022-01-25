package steps;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Script1 {
	WebDriver d1;
@Given("Open CHROME browser and URL of the application")
public void open_chrome_browser_and_url_of_the_application() {
	System.setProperty("webdriver.chrome.driver","C:\\Users\\vennapu.venugopal\\Downloads\\chromedriver_win32\\chromedriver.exe");
	  
	  d1=new ChromeDriver();
	  
	  d1.get("https://ksrtc.in/oprs-web/");
	  System.out.println("Given done");
   
}
@When("Enter UserName , password and click on login button")
public void enter_user_name_password_and_click_on_login_button() throws AWTException {
	d1.findElement(By.xpath("//a[@href='/oprs-web/login/show.do']")).click();
	//d1.findElement(By.xpath("//a[@href='/oprs-web/user/add.do']")).click();
	//d1.findElement(By.id("email")).sendKeys("alwaysvenu96@gmail.com");
	//d1.findElement(By.id("fullName")).sendKeys("Venu Gopal");
	//d1.findElement(By.id("mobileNo")).sendKeys("8688343205");
	//d1.findElement(By.name("SaveBtn")).click();
	d1.findElement(By.id("userName")).sendKeys("alwaysvenu96@gmail.com");
	d1.findElement(By.id("password")).sendKeys("venuvg1506!");
	d1.findElement(By.id("submitBtn")).click();
	d1.findElement(By.id("fromPlaceName")).sendKeys("Hyderabad");
	Robot r1=new Robot();
	r1.keyPress(KeyEvent.VK_ENTER);
	r1.keyRelease(KeyEvent.VK_ENTER);
	d1.findElement(By.id("toPlaceName")).sendKeys("Bangalore");
	Robot r2=new Robot();
	r2.keyPress(KeyEvent.VK_ENTER);
	r2.keyRelease(KeyEvent.VK_ENTER);
	JavascriptExecutor jse=(JavascriptExecutor) d1;
	jse.executeScript("document.getElementById('txtJourneyDate').value='20/01/2022'");
	jse.executeScript("document.getElementById('txtReturnJourneyDate').value='25/01/2022'");
	d1.findElement(By.xpath("//*[@id='bookingsForm']/div[1]/div/div[2]/div[3]/button")).click();

	
	
	System.out.println("When done");
}
@Then("Success in login")
public void success_in_login() {
	System.out.println("Then done");
  
}


}
