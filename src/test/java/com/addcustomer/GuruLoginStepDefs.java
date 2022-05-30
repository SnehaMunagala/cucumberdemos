package com.addcustomer;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.calculator.Calculator;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class GuruLoginStepDefs {
	
	WebDriver driver;
	String uName, pwd;
	
	@Given("I am registered user with following details")
	public void iAmRegisteredUserWithFollowingDetails(DataTable data) {
		
		  List<String> dataList = data.values(); 
		  uName = dataList.get(0); 
		  pwd =  dataList.get(1);
		 
		/*
		 * List<Map<String,String>>dataList = data.asMaps(String.class, String.class);
		 * uName = dataList.get(0).get("userName"); pwd =
		 * dataList.get(0).get("password");
		 */
		
		/*
		 * List<Employee> emp = data.asList(Employee.class); uName =
		 * emp.get(0).getUserName(); pwd = emp.get(0).getPwd();
		 */
	}

	@When("I login with above credentials")
	public void iLoginWithAboveCredentials() {
	    driver.findElement(By.name("uid")).sendKeys(uName);
	    driver.findElement(By.name("password")).sendKeys(pwd);
	    driver.findElement(By.name("btnLogin")).click();
	}

	@Then("I should see my home page")
	public void iShouldSeeMyHomePage() {
		WebElement heading = driver.findElement(By.xpath("//tr[@class='heading3']/td"));
	    Assert.assertTrue(heading.isDisplayed());
	    Assert.assertTrue(heading.getText().contains(uName),"Header doesn't contains id");
	}
	
	@Before("@UI")
	public void initialize() {
		System.out.println("calling browser");
		WebDriverManager.chromedriver().setup();
		driver = WebDriverManager.chromedriver().create();
		driver.get("https://demo.guru99.com/V4/index.php");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
	}
	
	@After("@UI")
	public void close() {
		System.out.println("quiting browser");
		driver.close();
		driver.quit();
	}
	
	
	Calculator cal;
	int result;
	
	@Given("I have a Calculator")
	@Given("I have a calculator")
	public void i_have_a_calculator() {
	    System.out.println("creating calculator object");
		cal = new Calculator();
	}

	@When("I add {int} and {int}")
	public void i_add_and(Integer one, Integer two) {
	    System.out.println("calling add function");
		result = cal.add(one, two);
	}

	@Then("I should get {int} as result")
	public void i_should_get_as_result(Integer total) {
		System.out.println("Result is "+result+" and total is "+total);
		Assert.assertTrue(result == total, "Total and result are not same");   
	}
	
}
