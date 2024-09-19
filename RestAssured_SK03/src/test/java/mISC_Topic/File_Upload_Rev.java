package mISC_Topic;

import static io.restassured.RestAssured.given;

import java.io.File;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;;

public class File_Upload_Rev {

	public static void main(String[] args) 
	{
		File f=new File("D:\\pankaj_data.txt");
		
		RestAssured.baseURI="https://www.httpbin.org/";
		
		String response=given().relaxedHTTPSValidation().log().all().headers("Content-Type","multipart/form-data")
		.multiPart("file",f)
		.when().post("post")
		.then().log().all().extract().response().asString();
		
		System.out.println(response);
		
		JsonPath js=new JsonPath(response);
		String data_json=js.getString("files.file");
		System.out.println(data_json);
		
		if (data_json.contains("pankaj"))
		{
			System.out.println("Test case is passed");
		}
		
		
		
	}

}
