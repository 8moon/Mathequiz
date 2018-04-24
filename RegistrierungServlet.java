package Mathequiz;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RegistrierungServlet")

public class RegistrierungServlet extends HttpServlet{
	public RegistrierungServlet() {
		super();
	}
protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
	final String vorname = request.getParameter("vorname");
	final String nachname = request.getParameter("nachname");
	final String email = request.getParameter("email");
	final String passwort = request.getParameter("passwort");
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
	out.println("<p>E-Mail: " + email+ "</p>");
	out.println("<p>Passwort: " + passwort+ "</p>");
	out.println("</body>");
	out.println("</html>"); 
}
}

