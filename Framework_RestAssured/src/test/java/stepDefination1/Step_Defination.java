package stepDefination1;

import org.testng.Assert;
import static io.restassured.RestAssured.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojoMapper1.CreateUser1;
import utility1.FetchDataFromPropertyFile;
import utility1.TestData;

public class Step_Defination 
{
	RequestSpecification req;
	RequestSpecification resp;
	ResponseSpecification respon1;
	Response response;
	String URL_Value1= FetchDataFromPropertyFile.readDataFromProperty().getProperty("baseURI");
	String URL_Value2= FetchDataFromPropertyFile.readDataFromProperty().getProperty("baseURI2");
	String auth_token= FetchDataFromPropertyFile.readDataFromProperty().getProperty("token");
	
	@Given("User will launch application URL.")
	public void user_will_launch_application_url() {
		req= new RequestSpecBuilder().setBaseUri(URL_Value1).setContentType(ContentType.JSON).build();
	}

	@And("User will send the payload with proper details.")
	public void user_will_send_the_payload_with_proper_details() {
		resp=given().log().all().spec(req).body(CreateUser1.Create_User());
		
	}

	@When("User will hit specific {string}.")
	public void user_will_hit_specific(String endpoint) {
		respon1=new ResponseSpecBuilder().expectStatusCode(200).build();
		response=resp.when().post(endpoint).then().log().all().spec(respon1).extract().response();
	    
	}

	@Then("User will validate the response body and {string}.")
	public void user_will_validate_the_response_body_and(String status_code) {
		String s=status_code;
		int status_code_1=Integer.parseInt(s);
		int status_code_2=response.getStatusCode();
		Assert.assertEquals(status_code_2, status_code_1);
	    
	}
	//Part: 2
	@Given("User is requested to hit an app URL.")
	public void user_is_requested_to_hit_an_app_url() {
		req= new RequestSpecBuilder().setBaseUri(URL_Value2).setContentType(ContentType.JSON).build();
	   
	}

	@And("User will pass the payload with authentication details.")
	public void user_will_pass_the_payload_with_authentication_details() {
		resp=given().log().all().headers("Authorization",auth_token).relaxedHTTPSValidation()
				.spec(req).body(TestData.palyLoadData());
	   
	}

	@When("User will hit the endpoint of the api as {string}.")
	public void user_will_hit_the_endpoint_of_the_api_as(String endpoint) {
		respon1=new ResponseSpecBuilder().expectStatusCode(201).build();
		response=resp.when().post(endpoint).then().log().all().spec(respon1).extract().response();
	   
	}

	@Then("User is going to verify the response body with a specific {string} .")
	public void user_is_going_to_verify_the_response_body_with_a_specific(String StatusCode) {
		String s=StatusCode;
		int status_code_1=Integer.parseInt(s);
		int status_code_2=response.getStatusCode();
		Assert.assertEquals(status_code_2, status_code_1);
	    
	}



}
