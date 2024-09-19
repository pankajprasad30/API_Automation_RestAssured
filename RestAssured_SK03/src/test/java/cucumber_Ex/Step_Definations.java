package cucumber_Ex;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Step_Definations 
{
	@Before("@System")
	public void pre1()
	{
		System.out.println("I am before tagged hook");
	}
	@Before
	public void pre2()
	{
		System.out.println("I am before hook");
	}
	@Given("User is launched web browser and navigated to application.")
	public void user_is_launched_web_browser_and_navigated_to_application() {
	   System.out.println("This is Given section");
	}

	@When("User enters UserName and Password.")
	public void user_enters_user_name_and_password() {
	    System.out.println("This is When section");
	}

	@Then("User clicks on login button.")
	public void user_clicks_on_login_button() {
	    System.out.println("This is Then section");
	}
	@When("User enters {string} and {string}.")
	public void user_enters_and(String string, String string2) {
	    System.out.println("user have to enter Username and Password");
	}
	@After
	public void display()
	{
		System.out.println("I am after hook");
	}
	

}
