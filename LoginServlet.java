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
import javax.sql.DataSource;

import com.sun.research.ws.wadl.Request;

import DatenBean.Login;
import DatenBean.Registrierung;


/**
 * Servlet implementation class createServlet
 */
@WebServlet("/RegistrierungServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(lookup = "jdbc/MyTHIPool")
	private DataSource ds;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
		final String id = request.getParameter("id");
		final String benutzername = request.getParameter("benutzername");
		final String passwort = request.getParameter("passwort");
		
		// neues Objekt wo die Daten gespeichert werden in der Methode speichern
		Login proto = new Login(benutzername,passwort);
		speichern(proto);
		
		//weiterleiten an die jsp
		final RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
		dispatcher.forward(request,response);
	}
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			
	}
		// Methode zum speichern in der datenbank
	private void speichern(Login form) throws ServletException{
		try(Connection con = ds.getConnection();
			PreparedStatement pstmt = con.prepareStatement("Insert into login(benutzername, passwort)VALUES(?,?)")){
			pstmt.setString(1, form.getBenutzername());
			pstmt.setString(2, form.getPasswort());
			pstmt.executeUpdate();
			
			
		}catch (Exception ex) {
			throw new ServletException(ex.getMessage());
		}
		;
	}
	}