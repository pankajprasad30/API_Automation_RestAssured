package request_Response_Specification;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Common_Request_Response 
{

	public static RequestSpecification request_Method() 
	{
		RequestSpecification req=new RequestSpecBuilder().setBaseUri("https://reqres.in/")
				.setContentType(ContentType.JSON).build();
		return req;
	}
	public static ResponseSpecification response_Method()
	{
		ResponseSpecification respec= new ResponseSpecBuilder().expectStatusCode(201)
				.expectContentType(ContentType.JSON).expectHeader("server", "cloudflare").build();
		return respec;
	}

}
