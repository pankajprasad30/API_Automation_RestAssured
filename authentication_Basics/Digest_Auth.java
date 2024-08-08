package authentication_Basics;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.given;

import org.testng.Assert;

public class Digest_Auth {

	public static void main(String[] args) 
	{
		RestAssured.baseURI="https://httpbin.org/";
		
		String response=given().log().all().auth().digest("pankaj07", "pankaj07")
		.when().get("digest-auth/undefined/pankaj07/pankaj07")
		.then().log().all().assertThat().statusCode(200)
		.extract().response().asString();
		
		System.out.println(response);
		
		JsonPath js= new JsonPath(response);
		String Expected_Auth=js.getString("authenticated");
		String Expected_user=js.getString("user");
		
		Assert.assertEquals("true", Expected_Auth);
		Assert.assertEquals("pankaj07", Expected_user);
		System.out.println("Test case is pass");

	}

}
