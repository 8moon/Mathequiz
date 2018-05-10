package DatenBean;

import java.io.IOException;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Session Bean implementation class Login
 */
@Stateless
@LocalBean
public class Login implements Serializable {
	private String benutzername;
	private String passwort;
		private static final long serialVersionUID = 1L;
		public Login(String benutzername, String passwort) {
			super();
			this.benutzername = benutzername;
			this.passwort = passwort;
		}
		public String getBenutzername() {
			return benutzername;
		}
		public void setBenutzername(String benutzername) {
			this.benutzername = benutzername;
		}
		public String getPasswort() {
			return passwort;
		}
		public void setPasswort(String passwort) {
			this.passwort = passwort;
		}
		
}