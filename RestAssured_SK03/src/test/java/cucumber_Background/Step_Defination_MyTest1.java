package cucumber_Background;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Step_Defination_MyTest1 
{
	@Given("Website is launch and user navigated to application.")
	public void website_is_launch_and_user_navigated_to_application() {
	   System.out.println("Given Section");
	}

	@When("User enter UserName and Password")
	public void user_enter_user_name_and_password() {
	    System.out.println("When Section");
	}

	@Then("User click on login button.")
	public void user_click_on_login_button() {
	    System.out.println("Then Section");
	}

}
