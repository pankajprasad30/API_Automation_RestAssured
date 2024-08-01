package rest_Assured_1;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

public class Prog_1 
{

	public static void main(String[] args) 
	{
		RestAssured.baseURI="https://reqres.in/";
		String Response= 
				given().log().all().headers("Connection","keep-alive").
				when().get("/api/users/2").
				then().log().all().
				extract().response().asString();
		
		System.out.println(Response);
		

	}

	

}
