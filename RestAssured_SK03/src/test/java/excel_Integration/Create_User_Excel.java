package excel_Integration;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import constants_Path.Constants_Path;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import payload_data.Payload_1;

public class Create_User_Excel {

	public static void main(String[] args) throws IOException 
	{
		FetchData_Excel obj=new FetchData_Excel(Constants_Path.ExcelPath, Constants_Path.SheetName);
		
		Map<String, Object> mp=new LinkedHashMap<String, Object>();
		mp.put("FirstName",FetchData_Excel.getTestData(1,0) );
		mp.put("LastName",FetchData_Excel.getTestData(1, 1) );
		mp.put("ID",FetchData_Excel.getTestData(1, 2) );
		//mp.put("FirstName1",FetchData_Excel.getTestData(2,0) );
		
		
		RequestSpecification req=new RequestSpecBuilder().setBaseUri("https://reqres.in/")
				.setContentType(ContentType.JSON).build();
		
		RequestSpecification res=given().log().all().spec(req).body(mp);
		
		ResponseSpecification respec= new ResponseSpecBuilder().expectStatusCode(201)
				.expectContentType(ContentType.JSON).expectHeader("server", "cloudflare").build();
		
		Response response=res.when().post("api/users").then().log().all().spec(respec).extract().response();
		
		System.out.println(response);
		
		

	}

}
