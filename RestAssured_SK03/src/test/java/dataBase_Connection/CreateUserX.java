package dataBase_Connection;

import static io.restassured.RestAssured.given;

import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
public class CreateUserX {

	public static void main(String[] args) throws SQLException 
	{
		Map<String,Object> mp=new LinkedHashMap<String,Object>();
		mp.put("PersonID", DB_Connection.getConnection(1));
		mp.put("LastName", DB_Connection.getConnection(2));
		mp.put("FirstName", DB_Connection.getConnection(3));
		mp.put("Address", DB_Connection.getConnection(4));
		mp.put("City", DB_Connection.getConnection(5));
		System.out.println(mp);
		//Request and response specification
		RequestSpecification req= new RequestSpecBuilder().setBaseUri("https://reqres.in/")
				.setContentType(ContentType.JSON).build();
		
		RequestSpecification re1=given().log().all().spec(req).body(mp);
		
		ResponseSpecification res=new ResponseSpecBuilder().build();
		
		Response response=re1.when().post("api/users").then().log().all().spec(res)
				.extract().response();
        System.out.println(response);//serialization
		

	}

}
