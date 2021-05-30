package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.annotation.Resource;
import javax.sql.DataSource;

import beans.Ticket;

/**
 * Servlet implementation class CreateTicketServlet
 */
@WebServlet("/createticketservlet")
public class CreateTicketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Resource(lookup="java:jboss/datasources/MySqlThidbDS")
	private DataSource ds;
	
	private void persist(Ticket form) throws ServletException {
		// DB-Zugriff
		String[] generatedKeys = new String[] {"ticket_id"};	// Name der Spalte(n), die automatisch generiert wird(werden)
		
		try (Connection con = ds.getConnection();
			PreparedStatement pstmt = con.prepareStatement(
					"INSERT INTO ticket (category,parameters,fb_oc) VALUES (?,?,?)", 
					generatedKeys)){

			// Zugriff über Klasse java.sql.PreparedStatement
			pstmt.setString(1, form.getCategory());
			pstmt.setString(2, form.getParameters());
			pstmt.setString(3, form.getFb_oc());
			pstmt.executeUpdate();
			
			// Generierten Schlüssel auslesen
			try (ResultSet rs = pstmt.getGeneratedKeys()) {
				while (rs.next()) {
					form.setTicket_id(rs.getLong(1));
				}
			}
		} catch (Exception ex) {
			throw new ServletException(ex.getMessage());
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		request.setCharacterEncoding("UTF-8");
		Ticket form = new Ticket();
		form.setCategory(request.getParameter("category"));
		form.setParameters(request.getParameter("parameters"));
		form.setFb_oc(request.getParameter("fb_oc"));
		
		// DB-Zugriff
		persist(form);
		
		// Scope "Session"
		HttpSession session = request.getSession();
		session.setAttribute("form", form);
		
		// Weiterleiten an JSP
		response.sendRedirect("html/registration.jsp");
		
		// Test: Option forward
		//final RequestDispatcher dispatcher = request.getRequestDispatcher("html/ticketoutput.jsp");
		//dispatcher.forward(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

}
