package jSON_Data;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import io.restassured.RestAssured;

public class JSON_SelfCreated 
{
	public static void main(String[]args)
	{
	
		Map<String,Object> mp1=new HashMap<String,Object>();
		mp1.put("Name", "Pankaj");
		mp1.put("Profession", "JOb");
		mp1.put("Current Location", "Bangalore");
		
		ArrayList<String> ar1=new ArrayList<String>();
		ar1.add("Video Games");
		ar1.add("Electronic Gadgets");
		ar1.add("Painting");
		
		mp1.put("Hobbies", ar1);
		
		Map<String,String> mp2=new HashMap<String,String>();
		mp2.put("Programming Language", "Java");
		mp2.put("Automation Framework", "Test NG");
		mp2.put("API Testing", "Rest Assured");
		
		mp1.put("Technical Skills", mp2);
		
		
		
		
		RestAssured.baseURI="https://httpbin.org/";
		
		
		
		String Response=given().log().all().header("Content-Type","application/json").body(mp1)
		.when().post("post")
		.then().log().all().extract().response().asString();
		
		System.out.println(Response);
	}

}
