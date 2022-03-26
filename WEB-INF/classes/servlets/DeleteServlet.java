// erstellt von Hoan Lu

package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import beans.User;

@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource(lookup = "jdbc/MyTHIPool")
	private DataSource ds;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); // In diesem Format erwartet das Servlet jetzt die Formulardaten
		HttpSession session = request.getSession();
		User user =  (User) session.getAttribute("user");
		String username = user.getUsername();
		User form = new User();
		form.setUsername(request.getParameter("username"));
		String benutzer = form.getUsername();

		// DB-Zugriff;
		if (username.equals(benutzer)) {
			delete(form);
		} else{
			final RequestDispatcher dispatcher = request.getRequestDispatcher("html/user_pages/create_new_profile_error.jsp");
			dispatcher.forward(request, response);
			return;
		}
		session.invalidate();

		// Weiterleiten an JSP
		final RequestDispatcher dispatcher = request.getRequestDispatcher("html/user_pages/delete_profile.jsp");
		dispatcher.forward(request, response);

	}

	private void delete(User form) throws ServletException {
		try (Connection con = ds.getConnection();
			 PreparedStatement pstmt = con.prepareStatement("DELETE FROM user WHERE UserName = ?;")) {
			pstmt.setString(1, form.getUsername());
			pstmt.executeUpdate();
		} catch (Exception ex) {
			throw new ServletException(ex.getMessage());
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
