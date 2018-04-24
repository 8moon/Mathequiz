package Mathequiz;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ProfilServlet")

public class ProfilServlet extends HttpServlet{
	public ProfilServlet() {
		super();
	}
protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
	final String vorname = request.getParameter("vorname");
	final String nachname = request.getParameter("nachname");
	final String benutzername = request.getParameter("benutzername");
	final String email = request.getParameter("email");
	final String altesPasswort = request.getParameter("altesPasswort");
	final String neuesPasswort = request.getParameter("neuesPasswort");
	final String passwortBestätigen = request.getParameter("passwortBestätigen");

	final PrintWriter out = response.getWriter();
	out.println("<!DOCTYPE html>");
	out.println("<html>"); 
	out.println("<head>");
	out.println("<title> Login </title>");
	out.println("</head>");
	out.println("<body>");
	out.println("<p>Vorname: " + vorname+ "</p>");
	out.println("<p>Nachname: " + nachname+ "</p>");
	out.println("<p>Benutzername: " + benutzername+ "</p>");
	out.println("<p>E-Mail: " + email+ "</p>");
	out.println("<p>Passwort: " + altesPasswort+ "</p>");
	out.println("<p>Passwort: " + neuesPasswort+ "</p>");
	out.println("<p>Passwort: " + passwortBestätigen+ "</p>");
	out.println("</body>");
	out.println("</html>"); 
}
}

