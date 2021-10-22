package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
 * Servlet implementation class CreateTicketServlet
 */
@WebServlet("/createbusservlet")
public class CreateBusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Resource(lookup="java:jboss/datasources/MySqlThidbDS")
	private DataSource ds;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		BusBean form = new BusBean();
		form.setBusNr(Integer.valueOf(request.getParameter("busNr")));
		form.setBusName(request.getParameter("busName"));
		form.setBusDescription(request.getParameter("busDescription"));
		
		// DB-Zugriff
		persist(form);
		
		// Scope "Request"
		request.setAttribute("form", form);
		
		// Weiterleiten an JSP
		final RequestDispatcher dispatcher = request.getRequestDispatcher("html/busoutput.jsp");
		dispatcher.forward(request, response);
		
	}
	
	private void persist(BusBean form) throws ServletException {
		// DB-Zugriff
		String[] generatedKeys = new String[] {"bus_id"};	// Name der Spalte(n), die automatisch generiert wird(werden)
		
		try (Connection con = ds.getConnection();
			PreparedStatement pstmt = con.prepareStatement(
					"INSERT INTO bus (bus_nr,bus_name,bus_description) VALUES (?,?,?)", 
					generatedKeys)){

			// Zugriff über Klasse java.sql.PreparedStatement
			pstmt.setInt(1, form.getBusNr());
			pstmt.setString(2, form.getBusName());
			pstmt.setString(3, form.getBusDescription());
			pstmt.executeUpdate();
			
			// Generierten Schlüssel auslesen
			try (ResultSet rs = pstmt.getGeneratedKeys()) {
				while (rs.next()) {
					form.setBusId(rs.getLong(1));
				}
			}
		} catch (Exception ex) {
			throw new ServletException(ex.getMessage());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
