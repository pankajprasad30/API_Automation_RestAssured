package post_Basics;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import payload_data.Payload_2;

public class Prog_6 
{
	@DataProvider(name="BooksData")
	public Object[][] getData()
	{
		return new Object[][]
				{
			{"qqqweqwe","1233221"},
			{"yqqqwieuy","2312223"}
			
				};
	}
	
	@Test(dataProvider="BooksData")
	public void addBook(String isbn, String aisle)
	{
		String Actual_msg="successfully added";
		RestAssured.baseURI="http://216.10.245.166";
		
		String response=given().log().all().header("Content-Type","application/json")
		.body(Payload_2.addBook(isbn, aisle))
		.when().post("Library/Addbook.php")
		.then().log().all().assertThat().statusCode(200)
		.extract().response().asString();
		
		System.out.println(response);
		
		JsonPath js=new JsonPath(response);
		String Expected_msg=js.getString("Msg");
		
		Assert.assertEquals(Actual_msg, Expected_msg);
		
		System.out.println("*********** Test case is pass ***********");
	}

}
