package dataBase_Connection;

import org.testng.annotations.Test;

import java.sql.*;

public class DB_Connection 
{
	@Test
	public static Object getConnection(int x)throws SQLException
	{
		Connection mycon=null;
		Statement mystmt=null;
		ResultSet myrs=null;
		Object obj=null;
		
		mycon=DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","Darshika_@09");
		System.out.println("Connection is successful");
		
		mystmt=mycon.createStatement();
		myrs=mystmt.executeQuery(SQL_Querry.SQL_Querry1());
		
		while(myrs.next())
		{
			obj=myrs.getString(x);
	

		}
		System.out.println(obj);
		return obj;
	}

}
