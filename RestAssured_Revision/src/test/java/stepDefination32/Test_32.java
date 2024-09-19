package stepDefination32;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Test_32 {

	@Given("user launched browser and navigated to shooping URL.")
	public void user_launched_browser_and_navigated_to_shooping_url() {
	   System.out.println("Given section");
	}

	@When("user enter username and password.")
	public void user_enter_username_and_password() {
	   System.out.println("When Section");
	}

	@Then("user is navigated to home page.")
	public void user_is_navigated_to_home_page() {
	   System.out.println("Then section");
	}
	
}
