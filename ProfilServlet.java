package servlets;

import java.io.IOException;
import java.io.PrintWriter;
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
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import DatenBean.Profil;
import DatenBean.Registrierung;

@WebServlet("/ProfilServlet")

public class ProfilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(lookup = "jdbc/MyTHIPool")
	private DataSource ds;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		final String firstname = request.getParameter("firstname");
		final String lastname = request.getParameter("lastname");
		final String username = request.getParameter("username");
		final String email = request.getParameter("email");
		final String oldPassword = request.getParameter("oldPassword");
		final String newPassword = request.getParameter("newPassword");
		final String passwortConfirmation = request.getParameter("passwortConfirmation");

		
		// neues Objekt wo die Daten gespeichert werden in der Methode speichern
		Profil proto = new Profil(firstname, lastname, username, email, oldPassword, newPassword,passwortConfirmation);
		speichern(proto);

		// weiterleiten an die jsp
		final RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		HttpSession session = request.getSession(false);
//		if(session!=null) {
//			String username = (String)session.getAttribute("Username");
//			System.out.print("Hallo"+username+"Welcome to Profil");
//		}else {
//			System.out.print("Please log in first");
//			request.getRequestDispatcher("login.jsp").include(request, response);
//		}

	}

	// Methode zum speichern in der datenbank
	private void speichern(Profil form) throws ServletException{
			try(Connection con = ds.getConnection();
				PreparedStatement pstmt = con.prepareStatement("Insert into user(firstname, lastname, username,email, newPassword,oldPassword, passwordConfirmation)VALUES(?,?,?,?,?,?,?)")){
				pstmt.setString(1, form.getFirstname());
				pstmt.setString(2, form.getLastname());
				pstmt.setString(3, form.getUsername());
				pstmt.setString(4, form.getEmail());
				pstmt.setString(5, form.getOldPassword());
				pstmt.setString(6, form.getNewPassword());
				pstmt.setString(7, form.getPasswortConfirmation());
				pstmt.executeUpdate();
				
		
			}catch(Exception ex)
	{
		throw new ServletException(ex.getMessage());
	};
}
}