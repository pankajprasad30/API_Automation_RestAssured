package post_Basics;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;

public class Prog_1 {

	public static void main(String[] args) 
	{
		RestAssured.baseURI="https://reqres.in/";
		
		String response=given().log().all().header("Content-Type","application/json")
		.body("{\r\n"
				+ "    \"name\": \"morpheus\",\r\n"
				+ "    \"job\": \"leader\"\r\n"
				+ "}")
		.when().post("api/users")
		.then().log().all().extract().response().asString();
		
		System.out.println(response);

	}

}
