package pOJO_Example;

import static io.restassured.RestAssured.given;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class New_Employee {

	public static void main(String[] args) throws JsonProcessingException 
	{
		Employee_POJO emp=new Employee_POJO();
		emp.setName("Pankaj");
		emp.setJob("QA_Lead");
		emp.setSalary(150000.76);
		emp.setLocation("Bangalore");
		
		ObjectMapper obj=new ObjectMapper();
		String empJSON=obj.writerWithDefaultPrettyPrinter().writeValueAsString(emp);
		
		RequestSpecification req=new RequestSpecBuilder().setBaseUri("https://httpbin.org/").setContentType(ContentType.JSON)
				.build();
		RequestSpecification reqst=given().log().all().spec(req).body(empJSON);
		
		ResponseSpecification res=new ResponseSpecBuilder().expectStatusCode(200).build();
		
		Response response=reqst.when().post("post").then().log().all().spec(res).extract().response();
		System.out.println(response);
		
		String ResponseString=response.asString();
		System.out.println(ResponseString);
		
		Employee_POJO emp1=obj.readValue(empJSON, Employee_POJO.class);
		System.out.println(emp1.getName());
		System.out.println(emp1.getJob());
		System.out.println(emp1.getSalary());
		System.out.println(emp1.getLocation());

	}

}
