// erstellt von Hoan Lu

package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
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

import beans.User;


/**
 * Servlet implementation class passwordServlet
 */
@WebServlet("/passwordServlet")
public class passwordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(lookup ="jdbc/MyTHIPool")
	private DataSource ds;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String newPassword = request.getParameter("newPassword");
		String passwordConfirmation = request.getParameter("passwordConfirmation");

		// Benutzerbean laden
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		String password = user.getPassword();

		// Fehlerfaelle ueberpruefen
		boolean error = false;

		// Felder gefuellt?
		if (newPassword == null || newPassword == "" || passwordConfirmation == null || passwordConfirmation == "" || password == "" || password == null)
			error = true;
		else {

			// Stimmen neues Passwort und Passwortbestaetigung ueberein?
			if (!newPassword.equals(passwordConfirmation))
				error = true;

			// Neues und altes Passwort m�ssen unterschiedlich sein
			if (newPassword.equals(user.getPassword()))
				error = true;
			// Das Passwort, welches in der Bean gespeichert ist, muss mit den aktuellen Passwort uebereinstimmen
			// wenn nein dann error

		}

		// Fehler entdeckt? Falls ja, Umleitung zur Fehlerseite
		if (error) {
			final RequestDispatcher dispatcher = request.getRequestDispatcher("html/user_pages/create_new_profile_error.jsp");
			dispatcher.forward(request, response);
			return;
		}else if((password.equals(request.getParameter("oldPassword"))))

			// Kein Fehler entdeckt: DB-Zugriff
			try(Connection conn = ds.getConnection();
				PreparedStatement pstm = conn.prepareStatement("UPDATE user"
						+ " SET Password = ?"
						+ "WHERE UserName = ?");){

				pstm.setString(1,newPassword);
				pstm.setString(2, user.getUsername());
				pstm.executeUpdate();
				conn.close();
			}
			catch (SQLException ex) {
				ex.printStackTrace();
			}

		user.setPassword(newPassword);
		session.setAttribute("user", user);
		final RequestDispatcher dispatcher = request.getRequestDispatcher("html/user_pages/change_password.jsp");
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