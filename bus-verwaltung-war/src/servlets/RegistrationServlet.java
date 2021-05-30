package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import beans.User;

@WebServlet("/registrationservlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource(lookup="java:jboss/datasources/MySqlThidbDS")
	private DataSource ds;
	
	private void persist(User user) throws ServletException {
		// DB-Zugriff
		// evtl. fuer die Zukunft mit neuer Spalte user_id
		//String[] generatedKeys = new String[] {"user_id"};	// Name der Spalte(n), die automatisch generiert wird(werden)
		
		try (Connection con = ds.getConnection();
			PreparedStatement pstmt = con.prepareStatement(
					"INSERT INTO user (username, email, password, departement, isadmin, verified) VALUES (?,?,?,?,?,?)")){ 
					//generatedKeys)){

			// Zugriff über Klasse java.sql.PreparedStatement
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getEmail());
			pstmt.setString(3, user.getPassword());
			pstmt.setString(4, user.getDepartement());
			pstmt.setBoolean(5, user.getIsadmin());
			pstmt.setBoolean(6, false);
			pstmt.executeUpdate();
			
			// Generierten Schlüssel auslesen --> Zukunft user_id
			/*try (ResultSet rs = pstmt.getGeneratedKeys()) {
				while (rs.next()) {
					user.setUserId(rs.getInt(1));
				}
			}*/
			
		} catch (Exception ex) {
			throw new ServletException(ex.getMessage());
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		User user = new User();
		user.setUsername(request.getParameter("username"));
		user.setPassword(request.getParameter("password"));
		user.setEmail(request.getParameter("email"));
		user.setDepartement(request.getParameter("departement"));
		user.setIsadmin(Boolean.valueOf(request.getParameter("isadmin")));
		
		//DB-Zugriff
		persist(user);
		
		// Session Scope
		HttpSession session = request.getSession();
		session.setAttribute("myuser", user);
		response.sendRedirect("html/registration.jsp");
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

}
