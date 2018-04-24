package Mathequiz;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")

public class LoginServlet extends HttpServlet{
	public LoginServlet() {
		super();
	}
protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
	final String benutzername = request.getParameter("benutzername");
	final String passwort = request.getParameter("passwort");

	final PrintWriter out = response.getWriter();
	out.println("<!DOCTYPE html>");
	out.println("<html>"); 
	out.println("<head>");
	out.println("<title> Login </title>");
	out.println("</head>");
	out.println("<body>");
	out.println("<p>Benutzername: " + benutzername+ "</p>");
	out.println("<p>Passwort: " + passwort+ "</p>");
	out.println("</body>");
	out.println("</html>"); 
}
}

