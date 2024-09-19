package authentication_Basics;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;

public class Basic_Auth {

	public static void main(String[] args) 
	{
		RestAssured.baseURI="http://postman-echo.com/";
		
		String response=given().log().all().auth().preemptive().basic("postman", "password")
		.when().get("basic-auth")
		.then().log().all().assertThat().statusCode(200)
		.extract().response().asString();
		
		System.out.println(response);
		
		

	}

}
