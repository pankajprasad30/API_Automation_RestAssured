package mISC_Topic;

import static io.restassured.RestAssured.given;

import java.io.File;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class PassingFileData 
{

	public static void main(String[] args) {
		
		
		File f=new File("‪D:\\API_Automation\\Payload_New.txt");
		//File f1=new File("C:\\Users\\saura\\OneDrive\\Pictures\\Test123.png");
		
		RestAssured.baseURI="https://httpbin.org";
		
		String Response=		given().relaxedHTTPSValidation().
				log().all().headers("Content-Type","multipart/form-data")
				
				.multiPart("file",f)
				//.multiPart("file2",f1)
				.when().post("post").then().log().all().extract()
				.response().asString();
		
		System.out.println(Response);
		
		JsonPath js=new JsonPath(Response);
		String Content_file=	js.getString("files.file");
		System.out.println(Content_file);
		if(Content_file.contains("submit"))
		{
			System.out.println("Test case passed");
		}
	}
}
