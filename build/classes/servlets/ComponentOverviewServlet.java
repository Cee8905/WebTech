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

import beans.Component;

/**
 * Servlet implementation class ComponentOverviewServlet
 * author: Sabine Ramp
 */
@WebServlet("/componentOverviewServlet")
public class ComponentOverviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@Resource(lookup="java:jboss/datasources/MySqlThidbDS")
	private DataSource ds;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		List<Component> compList = new ArrayList<>();
		
		// DB-Zugriff
		try(Connection con = ds.getConnection();
			Statement s = con.createStatement();
			ResultSet r = s.executeQuery("SELECT * from component")){
			while(r != null && r.next()) {
				Component c = new Component();
				Long id = Long.valueOf(r.getLong("comp_id"));
				c.setCompId(id);
				
				String name = r.getString("comp_name");
				c.setCompName(name);
				
				String desc = r.getString("comp_description");
				c.setCompDesc(desc);
				
				String type = r.getString("comp_type");
				c.setCompType(type);
				
				String unit = r.getString("comp_unit");
				c.setCompUnit(unit);
				
				String value = r.getString("comp_value");
				c.setCompValue(value);
				
				// fehlt in Klasse Component....
				// String requestor = r.getString("requestor");
				// c.setRequestor(requestor);
				
				// fehlt in Klasse Component....
				// String busId = r.getString("bus_id");
				// c.setbusId(busId);
				
				compList.add(c);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		request.setAttribute("components", compList);
		final RequestDispatcher dispatcher = request.getRequestDispatcher("html/componentOverview.jsp");
		dispatcher.forward(request, response);

	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
