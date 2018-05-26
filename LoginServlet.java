package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import com.sun.research.ws.wadl.Request;

import DatenBean.Login;
import DatenBean.Profil;

/**
 * Servlet implementation class createServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(lookup = "jdbc/MyMathematikQuizPool")
	private DataSource ds;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		anmelden(request,response);
		
	}
	protected void anmelden(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		Login user = new Login();
		HttpSession session = request.getSession();
		user.setUsername("username");
		user.setPassword("password");
	
		if (passwortPruefen(user.getUsername(),user.getPassword()) == true) {

				try (Connection con = ds.getConnection();
						PreparedStatement pstmt = con.prepareStatement("Select* from mathematikquiz.user Where username =?")){
					pstmt.setString(1, user.getUsername());
					try(ResultSet rs = pstmt.executeQuery()){
						if(rs != null && rs.next()) {
				Login form = new Login();
				form.setFirstname(request.getParameter("firstname"));
				form.setLastname(request.getParameter("lastname"));
				form.setUsername(request.getParameter("username"));
				form.setEmail(request.getParameter("email"));
				form.setPassword(request.getParameter("password"));
				request.setAttribute("form", form);
				session.setAttribute("user", form);
						}}}
		 catch (Exception e) {
			 throw new ServletException(e.getMessage());
		 }
					final RequestDispatcher dispatcher = request.getRequestDispatcher("home/html/MeinProfil.jsp");
					dispatcher.forward(request, response);
					}else {
					final RequestDispatcher dispatcher = request.getRequestDispatcher("home/html/index.jsp");
					dispatcher.forward(request, response);
				}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}

	private boolean passwortPruefen(String username, String password) throws ServletException {
		boolean status = false;
		boolean isOk;

		try (Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn
						.prepareStatement("SELECT password from mathematikquiz.user where username = ?")) {
			pstmt.setString(1, username);
			try (ResultSet rs = pstmt.executeQuery();){
			isOk = rs.next();

			if (isOk == true) {
				String pw = rs.getString("password");
				if (password.equals(pw)) {
					status = true;
				}
			}
			}catch (Exception ex) {
				ex.getMessage();
			}

		} catch (Exception ex) {
			ex.getMessage();
		}
		return status;
	}
}
