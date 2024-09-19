package post_Basics;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import payload_data.Payload_1;

public class Prog_4 {

	public static void main(String[] args) throws IOException 
	{

		//String Act_job="QA_Manager";
		String Cureent_Date="2024-08-01";
        RestAssured.baseURI="https://reqres.in/";
		
		String response=given().log().all().header("Content-Type","application/json")
		.body(new String (Files.readAllBytes(Paths.get("‪C:\\Users\\Pankaj Prasad\\Desktop\\Pay_1.txt"))))
		.when().post("api/users")
		.then().log().all().assertThat().statusCode(201)
		.body("name", equalTo("Prasad"))
		.extract().response().asString();
		
		System.out.println(response);
		
		JsonPath js=new JsonPath(response);
		//String Exp_job=js.getString("job");
		String todays_date=js.getString("createdAt");
		String[] date_1=todays_date.split("T");
		String first_part=date_1[0];
		//String second_part=date_1[1];
		
		System.out.println(first_part);
		//System.out.println(second_part);
		
		Assert.assertEquals(first_part, Cureent_Date);
		//Assert.assertEquals(Act_job, Exp_job);
		
		System.out.println("************ Test case is pass **************");

	}

}
