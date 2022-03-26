// erstellt von Hoan Lu

package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import beans.User;

@WebServlet("/ProfilServlet")
@MultipartConfig
public class ProfilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(lookup = "jdbc/MyTHIPool")
	private DataSource ds;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		// aus der session
		String firstnameDb = user.getFirstname();
		String lastnameDb = user.getLastname();
		String genderDb = user.getGender();
		String emailDb = user.getEmail();
		// aus dem formular
		User benutzer = new User();
		benutzer.setUsername(user.getUsername());
		benutzer.setFirstname(request.getParameter("firstname"));
		String firstname = benutzer.getFirstname();
		benutzer.setLastname(request.getParameter("lastname"));
		String lastname = benutzer.getLastname();
		benutzer.setEmail(request.getParameter("mail"));
		String email = benutzer.getEmail();
		benutzer.setGender(request.getParameter("gender"));
		String gender = benutzer.getGender();
		request.setAttribute("user", benutzer);
		session.setAttribute("user", benutzer);

		try (Connection conn = ds.getConnection();
			PreparedStatement pstm = conn.prepareStatement(
					"UPDATE user" + " SET FirstName = ?, LastName = ? , Gender =?, Email = ? " + "WHERE UserName = ?")){
			

			pstm.setString(1, dbCheck(firstname, firstnameDb));
			pstm.setString(2, dbCheck(lastname, lastnameDb));
			pstm.setString(3, dbCheck(gender, genderDb));
			pstm.setString(4, dbCheck(email, emailDb));
			pstm.setString(5, user.getUsername());
			pstm.executeUpdate();
			conn.close();
		}


		catch (SQLException ex) {
			ex.printStackTrace();
		}
		session.removeAttribute("user");
		final RequestDispatcher dispatcher = request.getRequestDispatcher("html/user_pages/profile_update_confirmation.jsp");
		dispatcher.forward(request, response);
	}

	protected String dbCheck(String infoDaten, String dbDaten) {
		if (infoDaten != null && infoDaten.length() > 0) {
			return infoDaten;
		} else {
			return dbDaten;
		}
	}
}