package post_Basics;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;;

public class Map_Prog {

	public static void main(String[] args) 
	{
		RestAssured.baseURI="https://httpbin.org/";
		
		Map<String, Object> mp=new LinkedHashMap<String, Object>();
		mp.put("Name", "Pankaj");
		mp.put("Job", "QA_Lead");
		mp.put("id", 7890);
		mp.put("Status", "Active");
		
		Map<String, Object> pp=new LinkedHashMap<String, Object>();
		pp.put("Name", "Pankaj1");
		pp.put("Job", "QA_Lead1");
		pp.put("id", 78901);
		pp.put("Status", "Active1");
		
		List<Map> li=new ArrayList<Map>();
		li.add(pp);
		li.add(mp);

		String response=given().log().all().header("Content-Type","application/json")
		.body(li)
		.when().post("post")
		.then().log().all().assertThat().statusCode(200)// need to check status code, why 200 ?
		.extract().response().asString();
		
		System.out.println(response);
		

	}

}
