package flyAway;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbConnection {
	protected static Connection initializeDatabase()throws SQLException, ClassNotFoundException
	{
	String url = "jdbc:mysql://localhost:3306/flyaway";
    String user = "root";
    String password = "root";
    Class.forName("com.mysql.jdbc.Driver");
    Connection con = DriverManager.getConnection(url, user, password);
	return con;
	}
}
