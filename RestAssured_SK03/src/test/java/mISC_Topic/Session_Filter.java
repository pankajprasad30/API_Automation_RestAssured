package mISC_Topic;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import io.restassured.filter.session.SessionFilter;

public class Session_Filter 
{
	@BeforeSuite
	public  SessionFilter prereq()
	{
		SessionFilter s=new SessionFilter();
		return s;
	}
	@Test
	public void display()
	{
		SessionFilter s=new SessionFilter();
		
		RestAssured.basePath="https://reqres.in/";
		
		String response=given().log().all().filter(s)
		.when().get("api/users/2")
		.then().log().all()//.assertThat().statusCode(200)
		.extract().response().asString();
		
		System.out.println(response);
		
	}

	

}
