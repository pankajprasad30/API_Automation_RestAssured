package authentication_Basics;

import static io.restassured.RestAssured.given;

import org.junit.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class Auth2_0_Auth 
{
	String Bearer_Token;
	@BeforeMethod
	public void commonURI()
	{
		RestAssured.baseURI="https://api-m.sandbox.paypal.com/";
	}

	@Test(priority=1)
	public void generateAccessToken() 
	{
		//RestAssured.baseURI="https://api-m.sandbox.paypal.com/";
		
		String username="AdbT3f756y74Yj5bWwYTDTfJFacMjNhrx8157MQsEwNBzSDKbUQTeLtmhDkoXV-V_G6UbMdCmYRdupB2";
		String password="EOpfMLgSIdgChsqx_YGoS3ADqLf0tfL8PcEh1X9xiUf5AKg-UgcS_EoMTeWMfeonJuA45pWCNzjkFQJI";
		String response=given().log().all().header("Content-Type","application/x-www-form-urlencoded")
				.auth().preemptive().basic(username,password).param("grant_type", "client_credentials")//here passing body as param
				
		.when().post("v1/oauth2/token")
		.then().log().all().assertThat().statusCode(200)
		.extract().response().asString();
		
		System.out.println(response);
		
		JsonPath js=new JsonPath(response);
		Bearer_Token=js.getString("access_token");
		System.out.println(Bearer_Token);

	}
	
	
	@Test(priority=2)
	public void UserAccessToken() throws InterruptedException
	{
		//Thread.sleep(2000);
		//RestAssured.baseURI="https://api-m.sandbox.paypal.com/";
		String response1=given().log().all().queryParam("page", 3).queryParam("page_size", 4).queryParam("total_count_required", "true")
				.auth().oauth2(Bearer_Token)
		.when().get("v1/invoicing/invoices")
		.then().log().all().assertThat().statusCode(200)
		.extract().response().asString();
		System.out.println(response1);
	}

}
