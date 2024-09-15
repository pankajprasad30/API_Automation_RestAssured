package serialization_DeSerialization;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

import static io.restassured.RestAssured.*;
import net.minidev.json.JSONObject;

public class CreateNewUser 
{
	@Test
	public void Create_User() throws InterruptedException
	{
		JSONObject payload= new JSONObject();
		payload.put("name", "pankaj");
		payload.put("job", "Manager");
		
		RestAssured.baseURI="https://reqres.in/";
		
		Response resp= given().log().all().body(payload.toJSONString())
				.header("Content-Type","application/json")
		.when().post("api/users")
		.then().log().all().extract().response();
		
		int Status_Code=resp.getStatusCode();
		System.out.println(Status_Code);
		
		Thread.sleep(1000);
		String Session_ID=resp.getSessionId();
		System.out.println(Session_ID);
		
		String Server_Name=resp.getHeader("Server");
		System.out.println(Server_Name);
		
		System.out.println("Response in form of JSON");
		ResponseBody rb=resp.getBody();
		System.out.println(rb);
		
		JSON_ProcessingEx jsp1=rb.as(JSON_ProcessingEx.class);
		String name=jsp1.name;
		String job=jsp1.job;
		
		System.out.println("Java data is : "+name);
		System.out.println("Java data is : "+job);
		
		Assert.assertEquals( "pankaj",name, "Validating the 1st test case");
		Assert.assertEquals( "Manager",job, "Validating the 2nd test case");
		
		
		System.out.println("*************All test cases are passed***********");
		
		
	}

}
