package cucumberEx;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinations 
{
	@Before
	public void test1()
	{
		System.out.println("Precondition");
	}
	@Before("@Smoke")
	public void test11()
	{
		System.out.println("Precondition Tagged hooks");
	}
	@Given("Launch the amazon website in we browser.")
	public void launch_the_amazon_website_in_we_browser() {
	    System.out.println(" Precondition Scenario");
	}
	@When("User user enters {string} and {string}.")
	public void user_user_enters_and(String string, String string2) {
	    System.out.println("User after entering credentials");
	}

	@Then("User will be logged into the application.")
	public void user_will_be_logged_into_the_application() {
	   System.out.println("expected result");
	}
	@After
	public void test2()
	{
		System.out.println("I am after method");
	}
	
		
	
}