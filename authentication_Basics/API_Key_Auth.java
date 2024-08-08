package authentication_Basics;

import static io.restassured.RestAssured.given;

import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class API_Key_Auth {

	public static void main(String[] args) 
	{
        RestAssured.baseURI="https://api.openweathermap.org";
		
		String response=given().log().all().queryParam("q", "Kolkata").queryParam("appid", "d425704730e91a1a26b83b61aea7ea59")
		.when().get("data/2.5/weather")
		.then().log().all().assertThat().statusCode(200)
		.extract().response().asString();
		
		System.out.println(response);
		
		JsonPath js=new JsonPath(response);
		String Base_Value=js.getString("base");
		System.out.println(Base_Value);
		
		Assert.assertEquals("stations", Base_Value);
		
		System.out.println("Test case is pass");

	}

}
