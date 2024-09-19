package post_Basics;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import io.restassured.RestAssured;

public class Prog_5 {

	public static void main(String[] args) throws IOException 
	{
        RestAssured.baseURI="https://reqres.in/";
		
		String response=given().log().all().header("Content-Type","application/json")
		.body(new String (Files.readAllBytes(Paths.get("C:\\Users\\Pankaj Prasad\\Desktop\\Pay_1.txt"))))
		.when().post("api/users")
		.then().log().all().assertThat().statusCode(201)
		.extract().response().asString();
		
		System.out.println(response);

	}

}
