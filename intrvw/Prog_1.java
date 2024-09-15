package intrvw;

import io.restassured.path.json.JsonPath;

public class Prog_1 
{
	

	public static void main(String[] args) 
	{
		{
			String data1="{ \"users\": [ { \"id\": 1, \"name\" : \"mike\", \"platform\": \"mobile\", \"active\": true }, { \"id\": 2, \"name\" : \"Drew\", \"platform\": \"desktop\", \"active\": false } ], \"totalUsers\" : 100 }";
			
			System.out.println(data1);
			
			JsonPath js=new JsonPath(data1);
			String s1=js.getString("users[0].name]");
			//String s2=js.getString("users[1].name]");
			System.out.println(s1);
		//	System.out.println(s2);
			 
			}
			 
	

	}

}
