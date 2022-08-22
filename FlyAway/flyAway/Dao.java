package flyAway;
import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.servlet.annotation.WebServlet;


public class Dao {
	public Connection con=null;
	public Statement st=null;

	public Dao() throws ClassNotFoundException, SQLException{
		Connection con=DbConnection.initializeDatabase();
		System.out.println("connection established with database");
		st=con.createStatement();
	}
public List<String[]> getAvailableFlights(String f, String t, String d) {
		
		List<String[]> flights=new ArrayList<>();
		String query="SELECT * FROM flyaway.flights where fromf='"+f+"' and tof='"+t+"' and datef='"+d+"'";
		
		try {
			ResultSet rs=st.executeQuery(query);
			
			if(rs.next()) {
				String[] flight=new String[3];
				flight[0]=rs.getString("name");
				flight[1]=rs.getString("timef");
				flight[2]=rs.getString("price");
				flights.add(flight);
				return flights;
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

public HashMap<String, String> checkUser(String email, String password) {
	
	HashMap<String,String> user=null;
	String query="select * from users where email='"+email+"' and password='"+password+"'";
	try {
		ResultSet rs=st.executeQuery(query);
		if(rs.next()) {
			user=new HashMap<>();
			user.put("name", rs.getString("name"));
			user.put("email",rs.getString("email"));
			user.put("phno",rs.getString("phno"));
			user.put("adno",rs.getString("adno"));
		}
		return user;
	} catch (SQLException e) {
		e.printStackTrace();
	}

	return user;
}

public boolean insertUser(HashMap<String, String> user) {

	String query="INSERT INTO user (email, password, name, phno, adno) values('"+user.get("email")+"','"+user.get("password")+"','"+user.get("name")+"','"+user.get("phno")+"','"+user.get("adno")+"')";                   
	
	try {
		st.execute(query);
		return true;
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return false;
}

public boolean checkAdmin(String email, String password) {
	
	try {
		ResultSet rs=st.executeQuery("select * from admin where email='"+email+"' and password='"+password+"'");
		if(rs.next())
			return true;
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return false;
}

public boolean changeAdminPassword(String email, String password) {

	try {
		ResultSet rs=st.executeQuery("select * from admin where email='"+email+"'");
		if(!rs.next()) {
			return false;
		}
		st.execute("update admin set password='"+password+"' where email='"+email+"'");
		return true;
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return false;
}

public boolean insertFlight(HashMap<String, String> flight) throws SQLException {
	Insertflight fl=new Insertflight();
	
	String query1 = "INSERT INTO flights (name, fromf, tof, datef, timef, price) VALUES ";
	System.out.println(flight.get("datef"));
	System.out.println(flight.get("timef"));

	try {
	
		st.execute(query1);
		return true;
	} catch (SQLException e) {
		System.out.print("error");
		e.printStackTrace();
	}
	return false;
}
}
