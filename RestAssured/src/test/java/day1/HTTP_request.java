package day1;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

/*given()- content type, set cookies, add authentication, add parameters, set headers info etc
 
when()-get, put,post,delete

then()-validation status, extract response, extract header cookies & response body ........*/

public class HTTP_request 
{
	//@Test (priority=1)
	void get_users()
	{
		given()//get request don't have any prerequisite, so nothing is mentioned in this section
		
		.when()
		    .get("https://reqres.in/api/users?page=2")
		
		.then()//in this section we have done validation
		    .statusCode(200)// to validate response code
		    .body("page",equalTo(2))// this will come from rest assures matchers
		    .log().all();// this is for to print entire response
		    
	}
	
	void create_user()
	{
		
	}

}
