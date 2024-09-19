package get_Basics;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class Prog_1 {

	public static void main(String[] args) 
	{
		RestAssured.baseURI="https://reqres.in/";
		
		String response=given().log().all()
		.when().get("api/users?page=2")
		.then().log().all().assertThat().statusCode(200).body("size()", is(6))
		.extract().response().asString();
		
		System.out.println(response);
		
		JsonPath js=new JsonPath(response);
		
		System.out.println("....................");
		System.out.println(js.getString("page"));
		System.out.println(js.getShort("data[1].id"));
		System.out.println(js.getString("data[5].first_name"));
		System.out.println(js.getString("support.text"));
		System.out.println(js.getString("support.url"));
		
		

	}

}
