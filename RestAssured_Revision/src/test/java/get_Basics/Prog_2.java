package get_Basics;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import static org.hamcrest.Matchers.*;

public class Prog_2 {

	public static void main(String[] args) 
	{
		RestAssured.baseURI="https://jsonplaceholder.typicode.com/";
		
		String response=given().log().all()
				.when().get("posts")
				.then().log().all().assertThat().statusCode(200) .body("size()", is(100))// to validate array size
				.extract().response().asString();
				
				System.out.println(response);
				
				JsonPath js=new JsonPath(response);
				
				System.out.println("..............................");
				System.out.println(js.getString("[10].title"));
				

	}

}
