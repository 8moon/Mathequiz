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
		final String vorname = request.getParameter("vorname");
		final String nachname = request.getParameter("nachname");
		final String benutzername = request.getParameter("benutzername");
		final String email = request.getParameter("email");
		final String passwort = request.getParameter("passwort");
		final String passwortBestätigen = request.getParameter("passwortBestätigen");
		
		// neues Objekt wo die Daten gespeichert werden in der Methode speichern
		Registrierung proto = new Registrierung(vorname,nachname,benutzername,email,passwort,passwortBestätigen);
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
			PreparedStatement pstmt = con.prepareStatement("Insert into registrierung(vorname, nachname, benutzername,email, passwort, passwortBesätigen)VALUES(?,?,?,?,?,?)",generatedKeys)){
			pstmt.setString(1, form.getVorname());
			pstmt.setString(2, form.getNachname());
			pstmt.setString(3, form.getBenutzername());
			pstmt.setString(4, form.getEmail());
			pstmt.setString(5, form.getPasswort());
			pstmt.setString(6, form.getPasswortBestätigen());
			pstmt.executeUpdate();
			
			// noch nicht ganz fertig die abfrage
			// er soll überprüfen ob der benutzername schon in der db existiert
			if(this.equals(form.getBenutzername())) {
				System.out.println(" Dieser Benutzername existiert schon");
			}else {
			try(ResultSet rs= pstmt.getGeneratedKeys()){
				while(rs.next()) {
					form.setId(rs.getInt(1));
				}
			}
				
			}
		}catch (Exception ex) {
			throw new ServletException(ex.getMessage());
		}
		;
	}
	}
