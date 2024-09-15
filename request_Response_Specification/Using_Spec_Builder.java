package request_Response_Specification;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import payload_data.Payload_1;

public class Using_Spec_Builder 
{
	@Test
	public void GetRequest()
	{
		RequestSpecification res=given().log().all().spec(Common_Request_Response.request_Method())
				.body(Payload_1.addData("Darshika", "Manager"));
		Response response=res.when().post("api/users").then().log().all()
				.spec(Common_Request_Response.response_Method()).extract().response();
		
		System.out.println(response);
	}

}
