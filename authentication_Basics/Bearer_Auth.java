package authentication_Basics;

import io.restassured.RestAssured;
import payload_data.Payload_gorest;

import static io.restassured.RestAssured.given;

import java.util.LinkedHashMap;
import java.util.Map;

public class Bearer_Auth {

	public static void main(String[] args) 
	{
		Map<String,Object> mp=new LinkedHashMap<String,Object>();
		mp.put("name", "pankaj");
		mp.put("gender", "male");
		mp.put("email", "pankaj4678689@gmail.com");
		mp.put("status", "Active");
		
		
		RestAssured.baseURI="https://gorest.co.in/";
		
		String Authorization_1="Bearer f3ca159ede4eb0b1ba2f6f7142b85360031ff4ebeaea7bafc480792646318256";
		
		String response=given().log().all().header("Content-Type","application/json").header("Authorization",Authorization_1)
				//.body(Payload_gorest.gorest())
				.body(mp)
		.when().post("public/v2/users")
		.then().log().all().assertThat().statusCode(201)
		.extract().response().asString();
		
		System.out.println(response);

	}

}
