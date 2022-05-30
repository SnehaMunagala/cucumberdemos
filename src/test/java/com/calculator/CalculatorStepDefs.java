package com.calculator;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CalculatorStepDefs {

	Calculator cal;
	int result;
	
	/*
	 * @Given("I have a Calculator")
	 * 
	 * @Given("I have a calculator") public void i_have_a_calculator() {
	 * System.out.println("creating calculator object"); cal = new Calculator(); }
	 * 
	 * @When("I add {int} and {int}") public void i_add_and(Integer one, Integer
	 * two) { System.out.println("calling add function"); result = cal.add(one,
	 * two); }
	 * 
	 * @Then("I should get {int} as result") public void
	 * i_should_get_as_result(Integer total) {
	 * System.out.println("Result is "+result+" and total is "+total);
	 * Assert.assertTrue(result == total, "Total and result are not same"); }
	 */
	
	@When("I perform {string} between {int} and {int}")
	public void i_perform_between_and(String operator, Integer one, Integer two) {
	    System.out.println("operator is "+operator);
		switch(operator) {
		
		case "Add" : result = cal.add(one, two);
					break;
		case "-" : result = cal.diff(one, two);
					break;
		case "*" : result = cal.prod(one, two);
					break;
		case "/" : result = cal.div(one, two);
					break;
		default : throw new RuntimeException("Invalid symbol");				
					
		}
	}
	
}
