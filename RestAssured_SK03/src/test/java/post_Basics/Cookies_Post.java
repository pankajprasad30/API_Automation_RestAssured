package post_Basics;

import io.restassured.RestAssured;
import payload_data.Cookies_Payload;

import static io.restassured.RestAssured.given;

public class Cookies_Post {

	public static void main(String[] args) 
	{
		RestAssured.baseURI="https://postman-echo.com/";
		
		String response=given().log().all().cookies(Cookies_Payload.SetCookiesData())
		//.header("Content-Type", "application/json")
		.when().post("cookies/set")
		.then().log().all().assertThat().statusCode(500)
		.extract().response().asString();
		
		System.out.println(response);
				
		
		

	}

}
