package vtiger.Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;
import com.mysql.cj.xdevapi.Statement;

public class SampleDBCExecuteQuery {
	@Test
	public void SampleExecuteQuery() throws Exception
	{
		Driver driver=new Driver();
		// Register the database
		DriverManager.registerDriver(driver);
		//
		Connection con=DriverManager.getConnection("dbc:mysql://localhost:3306/wcse14db","root","root");
	
		Statement state=con.createStatement();
		
		
	}

}
