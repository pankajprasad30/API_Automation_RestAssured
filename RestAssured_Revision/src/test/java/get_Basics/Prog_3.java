package get_Basics;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matcher.*;
import static org.hamcrest.Matchers.is;

public class Prog_3 {

	public static void main(String[] args) 
	{
		RestAssured.baseURI="https://reqres.in";
		given().log().all()
		.when().get("/api/users?page=2")
		.then().log().all().assertThat().statusCode(200).body("size()", is(6))
		.extract().response().asString();

	}

}
