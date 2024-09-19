package post_Basics;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class JSON_Body_Parshing {

	public static void main(String[] args) 
	{
		Map<String,Object> mp=new LinkedHashMap<String,Object>();
		mp.put("FirstName", "Pankaj");
		mp.put("LastName", "Prasad");
		mp.put("EmpID", 760070);
		
		ArrayList<String> arr=new ArrayList<String>();
		arr.add("Bike_Riding");
		arr.add("Playing_PC_Games");
		arr.add("Listening_Songs");
		
		mp.put("Hobbies", arr);
		
		Map<String,String> mp1=new LinkedHashMap<String,String>();
		mp1.put("Programming_Language", "Java");
		mp1.put("WebAutomation", "Selenium");
		mp1.put("Frameword", "TestNG");
		
		mp.put("Tech_Skills", mp1);
		
		
		
		
		RestAssured.baseURI="https://httpbin.org/";
		
		String response=given().log().all().header("Content-Type","application/json")
		.body(mp)
		.when().post("post")
		.then().log().all().assertThat().statusCode(200)
		.extract().response().asString();
		
		System.out.println(response);

	}

}
