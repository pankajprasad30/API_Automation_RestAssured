package mISC_Topic;

import java.io.File;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

public class File_Upload {

	public static void main(String[] args) 
	{
		File f1= new File("D:\\pankaj.txt");
		//File f2= new File("‪‪‪C:\\Users\\Pankaj Prasad\\Pictures\\Untitled.png");
		
		
		RestAssured.baseURI=("https://httpbin.org/");
		
		String Response=given().relaxedHTTPSValidation()// when firewall block we can use relaxed https
				.log().all()
				.headers("Content-Type","multipart/form-data")
				.multiPart("file",f1)
				//.multiPart("file",f2)
		.when().post("post")
		.then().log().all().extract().response().asString();
		
		System.out.println(Response);
		
		JsonPath js=new JsonPath(Response);
		String File_Content=js.getString("files.file");
		System.out.println(File_Content);
		
		if(File_Content.contains("c"))
		{
			System.out.println("Test case is pass");
		}
		else
		{
			System.out.println("Test case is fail");
		}
		
	}

}
