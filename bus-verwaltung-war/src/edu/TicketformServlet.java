package edu;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.thi.demo.Ticket;


/**
 * Servlet implementation class TicketformServlet
 */
@WebServlet("/ticketformservlet")
public class TicketformServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Servlet zur Entgegennahme von Formularinhalten und Generierung eines Beans zur Weitergabe
		// der Formulardaten an eine JSP
		request.setCharacterEncoding("UTF-8");	// In diesem Format erwartet das Servlet jetzt die Formulardaten
												// Alternative: GlassFish dazu bewegen, die Formulardaten gleich
												// als UTF-8 zu interpretieren. Dazu muss GlassFish auf UTF-8 umge-
												// stellt werden. Eine neue Zeile in die Datei glassfish-web.xml
												// ergänzen (zu finden im WEB-INF-Ordner des Projektes):
												// <parameter-encoding default-charset="UTF-8" />
		Ticket form = new Ticket();
		form.setCategory(request.getParameter("category"));
		form.setParameters(request.getParameter("parameters"));
		form.setFb_oc(request.getParameter("fb_oc"));
		
		// Weiterleiten an JSP per forward() --> Bean in Scope "Request" legen
		//request.setAttribute("form", form);
		
		
		// Weiterleiten an JSP per redirect() --> Bean in Scope "Session" legen
		HttpSession session = request.getSession();
		session.setAttribute("form", form);
		// response.sendRedirect("ticketausgabe.jsp");
		
		final RequestDispatcher dispatcher = request.getRequestDispatcher("ticketausgabe.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
