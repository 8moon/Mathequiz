package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

import DatenBean.Registrierung;


/**
 * Servlet implementation class createServlet
 */
@WebServlet("/RegistrierungServlet")
public class RegistrierungServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(lookup = "jdbc/MyTHIPool")
	private DataSource ds;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
		final String id = request.getParameter("id");
		final String firstname = request.getParameter("firstname");
		final String lastname = request.getParameter("lastname");
		final String username = request.getParameter("username");
		final String email = request.getParameter("email");
		final String password = request.getParameter("password");
		final String passwordConfirmation = request.getParameter("passwordConfirmation");
		
//		if (!(username.equals(((Registrierung) ds).getUsername()))) {
//			HttpSession session = request.getSession();
//			session.setAttribute("username", username);
//		}else {
//			System.out.print(" Username schon vergeben");
//			request.getRequestDispatcher("reigstrierung.jsp").include(request,response);
//		}
		// neues Objekt wo die Daten gespeichert werden in der Methode speichern
		Registrierung proto = new Registrierung(firstname,lastname,username,email,password,passwordConfirmation);
		speichern(proto);
		
		//weiterleiten an die jsp
		final RequestDispatcher dispatcher = request.getRequestDispatcher("registrierung.jsp");
		dispatcher.forward(request,response);
	}
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			
	}
		// Methode zum speichern in der datenbank
	private void speichern(Registrierung form) throws ServletException{
		String [] generatedKeys = new String[] {"id"};
		try(Connection con = ds.getConnection();
			PreparedStatement pstmt = con.prepareStatement("Insert into user(firstname, lastname, username,email, password, passwordConfirmation)VALUES(?,?,?,?,?,?)",generatedKeys)){
			pstmt.setString(1, form.getFirstname());
			pstmt.setString(2, form.getLastname());
			pstmt.setString(3, form.getUsername());
			pstmt.setString(4, form.getEmail());
			pstmt.setString(5, form.getPassword());
			pstmt.setString(6, form.getPasswordConfirmation());
			pstmt.executeUpdate();
			

		}catch (Exception ex) {
			throw new ServletException(ex.getMessage());
		}
		;
	}
	}
