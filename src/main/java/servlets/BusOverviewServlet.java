package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import beans.BusBean;

/**
 * Servlet implementation class BusOverviewServlet
 * author: Sabine Ramp
 */
@WebServlet("/BusOverviewServlet")
public class BusOverviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@Resource(lookup="java:jboss/datasources/MySqlThidbDS")
	private DataSource ds;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		List<BusBean> buslist = new ArrayList<>();
		
		// DB-Zugriff
		try(Connection con = ds.getConnection();
			Statement s = con.createStatement();
			ResultSet r = s.executeQuery("SELECT * from bus")){
			while(r != null && r.next()) {
				BusBean b = new BusBean();
				Integer id = Integer.valueOf(r.getInt("bus_id"));
				b.setBusId(id);
				
				Integer nr = Integer.valueOf(r.getInt("bus_nr"));
				b.setBusNr(nr);
				
				String name = r.getString("bus_name");
				b.setBusName(name);
				
				String description = r.getString("bus_description");
				b.setBusDescription(description);
				
				String requestor = r.getString("requestor");
				b.setRequestor(requestor);
				
				buslist.add(b);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		request.setAttribute("busses", buslist);
		final RequestDispatcher dispatcher = request.getRequestDispatcher("html/busOverview.jsp");
		dispatcher.forward(request, response);

	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
