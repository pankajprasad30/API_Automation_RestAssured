package dataBase_Connection_SQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

public class DataBase_Connection 
{
	@Test
	public static  void getConnection() throws SQLException
	{
		Connection mycon=null;
		Statement mystm=null;
		ResultSet myrs=null;
		Object obj=null;
		
		
		mycon=DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","Darshika_@09");
		System.out.println("Connection is successful");
		
		mystm=mycon.createStatement();
		myrs=mystm.executeQuery(SQL_Querry_1.SelectQuerry1());
		
		while(myrs.next())
		{
			obj=myrs.getString(2);
	

		}
		System.out.println(obj);
		
	}

}
