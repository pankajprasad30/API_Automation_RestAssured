package mock_Basics;

import org.testng.Assert;

import io.restassured.path.json.JsonPath;
import payload_data.Mock_Response;

public class Mock_Validation {

	public static void main(String[] args) 
	{
		// 1. Print No of courses returned by API
		JsonPath js=new JsonPath(Mock_Response.Courses());
		int size=js.getInt("courses.size()");
		System.out.println(size);
		
		//2.Print Purchase Amount
		int purchase_amount=js.getInt("dashboard.purchaseAmount");
		System.out.println(purchase_amount);
		
		//3. Print Title of the first course
		String First_Title=js.getString("courses[0].title");
		System.out.println(First_Title);
		
		//4. Print All course titles and their respective Prices
		
		
		for(int i=0;i<size;i++)
		{
			//String courses_name=js.getString("courses[0].title");
			System.out.println("Title of courses are : "+js.getString("courses["+i+"].title"));
			System.out.println("Title of courses are : "+js.getString("courses["+i+"].price"));
			
		}
		
		//5. Print no of copies sold by RPA Course
		int copies=js.getInt("courses[2].copies");
		System.out.println(copies);
		
		//6. Verify if Sum of all Course prices matches with Purchase Amount
		int sum=0;
		for(int i=0;i<size;i++)
		{
			int each_price=js.getInt("courses["+i+"].price");
			int each_copy=js.getInt("courses["+i+"].copies");
			int each_amount=each_price*each_copy;
			sum=each_amount+sum;//300,
			
		}
		System.out.println(sum);
		
		Assert.assertEquals(purchase_amount, sum);
		
		System.out.println("*********** Test case is pass***********");
	
		
		

	}

}
