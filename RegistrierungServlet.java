package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import DatenBean.Registrierung;

/**
 * Servlet implementation class RegistrierungServlet
 */
@WebServlet("/RegistrierungServlet")
public class RegistrierungServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource(lookup = "jdbc/MyMathematikQuizPool")
	private DataSource ds;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Registrierung form = new Registrierung();
		form.setFirstname(request.getParameter("firstname"));
		form.setLastname(request.getParameter("lastname"));
		form.setUsername(request.getParameter("username"));
		form.setEmail(request.getParameter("email"));
		form.setPassword(request.getParameter("password"));
		form.setPasswordConfirmation(request.getParameter("passwordConfirmation"));
		String username = "hoan";
		String pw1 ="1234";
		String pw2 ="1234";
	if (usernameUeberpruefen(form.getUsername())==false && passwordCheck(form.getPassword(), form.getPasswordConfirmation())==false) {
	//	if(usernameUeberpruefen(username)==false && passwordCheck(pw1, pw2)==false) {
			speichern(form);
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("home/html/GleicherUsername.jsp");
			dispatcher.forward(request, response);
		}		speichern(form);
		HttpSession session = request.getSession();
		session.setAttribute("form", form);
		final RequestDispatcher dispatcher = request.getRequestDispatcher("home/html/RegisAusgabe.jsp");
		dispatcher.forward(request, response);
	}

	private void speichern(Registrierung form) throws ServletException {
		String[] generatedKeys = new String[] { "UserId" };

		try (Connection con = ds.getConnection();
				PreparedStatement pstmt = con.prepareStatement(
						"Insert into mathematikquiz.User(firstname, lastname, username,email, password)VALUES(?,?,?,?,?)",
						generatedKeys)) {
			pstmt.setString(1, form.getFirstname());
			pstmt.setString(2, form.getLastname());
			pstmt.setString(3, form.getUsername());
			pstmt.setString(4, form.getEmail());
			pstmt.setString(5, form.getPassword());
			pstmt.executeUpdate();


		} catch (Exception ex) {
			System.out.println(ex);
			throw new ServletException(ex.getMessage());

		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected boolean usernameUeberpruefen(String username) throws ServletException {
		try (Connection con = ds.getConnection();
				PreparedStatement pstmt = con.prepareStatement("Select * FROM mathematikquiz.user WHERE UserName = ?")) {
			pstmt.setString(1, username);
			try (ResultSet rs = pstmt.executeQuery();) {
				if (rs.next()) {
					return true;
				} else {
					return false;
				}
			} catch (Exception e) {

			}
		} catch (Exception e) {
		}
		return false;
	}

	protected boolean passwordCheck(String pw1, String pw2) throws ServletException {
		if (pw1.equals(pw2)) {
			return false;
		} else {

			return true;

		}

	}
}