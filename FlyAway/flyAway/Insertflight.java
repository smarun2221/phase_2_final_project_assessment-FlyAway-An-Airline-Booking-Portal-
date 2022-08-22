package flyAway;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 * Servlet implementation class Insertflight
 */
//@WebServlet("/Insertflight")
public class Insertflight extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Insertflight() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//"INSERT INTO flights (name, fromf, tof, datef, timef, price) VALUES"
		String name=request.getParameter("name");
		String fromf=request.getParameter("fromf");
		String tof=request.getParameter("tof");
		String departure=request.getParameter("datef");
		String timef=request.getParameter("timef");
		String price=request.getParameter("price");
		
		HashMap<String,String> flight=new HashMap<>();
		flight.put("name", name);
		flight.put("fromf", fromf);
		flight.put("tof", tof);
		flight.put("datef", departure);
		flight.put("timef", timef);
		flight.put("price", price);
		
		try {
			Dao dao=new Dao();
			HttpSession session=request.getSession();
			if(dao.insertFlight(flight)) {
				
				session.setAttribute("message", "Flight Added Successfully");
			}
			else {
				session.setAttribute("message", "Invalid Details");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			System.out.print("error");
			e.printStackTrace();
		}
		response.sendRedirect("Adminhome.jsp");
		doGet(request, response);
	}

}
