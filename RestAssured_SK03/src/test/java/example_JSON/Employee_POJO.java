package example_JSON;

import static io.restassured.RestAssured.given;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Employee_POJO {

	public static void main(String[] args) throws JsonProcessingException 
	{
		Child_POJO chd=new Child_POJO();
		chd.setStreet("631-B C main");
		chd.setCity("Bangalore");
		chd.setPincode(786184);
		chd.setState("Karnataka");
		
		Parent_POJO prnt=new Parent_POJO();
		prnt.setName("Pankaj");
		prnt.setJob("QA_Lead");
		prnt.setSalary(125000);
		prnt.setLocation("Arekhere");
		prnt.setChild_pojo(chd);
		
		ObjectMapper obj=new ObjectMapper();
		String empjson=obj.writerWithDefaultPrettyPrinter().writeValueAsString(prnt);
		
		RequestSpecification req=new RequestSpecBuilder().setBaseUri("https://httpbin.org/")
				.setContentType(ContentType.JSON).build();
		RequestSpecification reqsp=given().log().all().spec(req).body(empjson);
		
		ResponseSpecification res=new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON)
				.build();//serialisation
		
		Response response=reqsp.when().post("post").then().log().all().spec(res).extract().response();
		System.out.println(response);
		
		String response_in_Sting=response.asString();
		System.out.println(response_in_Sting);
		
		//Deserialisation
		Parent_POJO prntt=obj.readValue(empjson, Parent_POJO.class);
		System.out.println(prntt.getName());
		System.out.println(prntt.getJob());
		System.out.println(prntt.getSalary());
		System.out.println(prntt.getLocation());
		

	}

}
