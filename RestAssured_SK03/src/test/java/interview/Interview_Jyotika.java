package interview;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
public class Interview_Jyotika {

	public static void main(String[] args) 
	{
		RestAssured.baseURI="https://jsonplaceholder.typicode.com/";
		String response=given().log().all()
		.when().get("posts")
		.then().log().all().assertThat().statusCode(200).extract().response().asString();
		
		System.out.println(response);
		
		JsonPath js=new JsonPath(response);
		
		String id_value=js.getString("ID");
		
		System.out.println(id_value);

	}

}
