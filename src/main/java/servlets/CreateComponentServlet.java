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

import beans.Component;

/**
 * Servlet implementation class CreateComponentServlet
 */
@WebServlet("/createcomponentservlet")
public class CreateComponentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Resource(lookup="java:jboss/datasources/MySqlThidbDS")
	private DataSource ds;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		Component form = new Component();
		form.setCompName(request.getParameter("compName"));
		form.setCompDesc(request.getParameter("compDesc"));
		form.setComp_type(request.getParameter("comp_type"));
		form.setComp_unit(request.getParameter("comp_unit"));
		form.setComp_value(request.getParameter("comp_value"));
		
		// DB-Zugriff
		persist(form);
		
		// Scope "Request"
		request.setAttribute("form", form);
		
		// Weiterleiten an JSP
		final RequestDispatcher dispatcher = request.getRequestDispatcher("html/compoutput.jsp");
		dispatcher.forward(request, response);
		
	}
	
	private void persist(Component form) throws ServletException {
		// DB-Zugriff
		String[] generatedKeys = new String[] {"comp_id"};	// Name der Spalte(n), die automatisch generiert wird(werden)
		
		try (Connection con = ds.getConnection();
			PreparedStatement pstmt = con.prepareStatement(
					"INSERT INTO component (comp_name,comp_description,comp_type,comp_unit,comp_value) VALUES (?,?,?,?,?)", 
					generatedKeys)){

			// Zugriff über Klasse java.sql.PreparedStatement
			pstmt.setString(1, form.getCompName());
			pstmt.setString(2, form.getCompDesc());
			pstmt.setString(3, form.getComp_type());
			pstmt.setString(4, form.getComp_unit());
			pstmt.setString(5, form.getComp_value());
			pstmt.executeUpdate();
			
			// Generierten Schlüssel auslesen
			try (ResultSet rs = pstmt.getGeneratedKeys()) {
				while (rs.next()) {
					form.setCompId(rs.getLong(1));
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
