package post_Basics;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import payload_data.Payload_1;

public class Prog_2 {

	public static void main(String[] args) 
	{
        RestAssured.baseURI="https://reqres.in/";
		
		String response=given().log().all().header("Content-Type","application/json")
		.body(Payload_1.addData("Prasad","QA_Manager"))
		.when().post("api/users")
		.then().log().all().extract().response().asString();
		
		System.out.println(response);

	}

}
