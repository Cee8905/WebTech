package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import beans.User;

/**
 * Servlet implementation class loginServlet
 */
@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource(lookup = "java:jboss/datasources/thidb")
	private DataSource ds;

	// Change the return to 4 options
	// 1. Username doesn't exist
	// 2. Password is wrong
	// 3. Login Credentials are right
	private boolean persist(User login) throws ServletException {
		// DB input is put into dbuser
		User dbuser = new User();
		// outsource code into a methode
		// Connection to db is created
		try (Connection con = ds.getConnection();
				// SQL Statement prepared
				PreparedStatement pstmt = con.prepareStatement("SELECT * FROM `user` WHERE username = ? AND password = ?")) {
			pstmt.setString(1, login.getUsername());
			pstmt.setString(2, login.getPassword());
			System.out.println("SQL done login:");
			System.out.println(login.getUsername());
			System.out.println(login.getPassword());

			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs != null && rs.next()) {
					dbuser.setUsername(rs.getString("username"));
					dbuser.setPassword(rs.getString("password"));
					System.out.println("DBUser done login:");
					System.out.println(dbuser.getUsername());
					System.out.println(dbuser.getPassword());
				}
			}
		} catch (Exception ex) {
			throw new ServletException(ex.getMessage());
		}
		// Compare login input with db entry
		if (dbuser.getUsername() == login.getUsername() && dbuser.getPassword() == login.getPassword()) {
			return true;
		} else
			return false;

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Form input is put into login
		User login = new User();
		login.setUsername(request.getParameter("username"));
		login.setPassword(request.getParameter("password"));

		boolean outcome = persist(login);

		// Persist == true forward to welcome page with login details
		if (outcome == true) {
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", login);
			response.sendRedirect("index.html");

		} else {
			
			// Change this with JS !!
			response.sendRedirect("login.html");
		}
		// persist() == false show login page with error
		// Scope
	}

}
