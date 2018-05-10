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
		final String vorname = request.getParameter("vorname");
		final String nachname = request.getParameter("nachname");
		final String benutzername = request.getParameter("benutzername");
		final String email = request.getParameter("email");
		final String altesPasswort = request.getParameter("altesPasswort");
		final String neuesPasswort = request.getParameter("neuesPasswort");
		final String passwortBestätigen = request.getParameter("passwortBestätigen");

		// neues Objekt wo die Daten gespeichert werden in der Methode speichern
		Profil proto = new Profil(vorname, nachname, benutzername, email, altesPasswort, neuesPasswort,
				passwortBestätigen);
		speichern(proto);

		// weiterleiten an die jsp
		final RequestDispatcher dispatcher = request.getRequestDispatcher("profil.jsp");
		dispatcher.forward(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

	// Methode zum speichern in der datenbank
	private void speichern(Profil form) throws ServletException{
			String [] generatedKeys = new String[] {"id"};
			try(Connection con = ds.getConnection();
				PreparedStatement pstmt = con.prepareStatement("Insert into profil(vorname, nachname, benutzername,email, neuesPasswort,altesPasswort, passwortBesätigen)VALUES(?,?,?,?,?,?,?)",generatedKeys)){
				pstmt.setString(1, form.getVorname());
				pstmt.setString(2, form.getNachname());
				pstmt.setString(3, form.getBenutzername());
				pstmt.setString(4, form.getEmail());
				pstmt.setString(5, form.getAltesPasswort());
				pstmt.setString(6, form.getNeuesPasswort());
				pstmt.setString(7, form.getPasswortBestätigen());
				pstmt.executeUpdate();
				
		
				try(ResultSet rs= pstmt.getGeneratedKeys()){
					while(rs.next()) {
						form.setId(rs.getInt(1));
					}
				}
			}catch(Exception ex)
	{
		throw new ServletException(ex.getMessage());
	};
}
}