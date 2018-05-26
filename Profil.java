package DatenBean;

import java.io.Serializable;
import java.sql.Connection;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.servlet.http.HttpServletRequest;

/**
 * Session Bean implementation class Profile
 */
@Stateless
@LocalBean
public class Profil implements Serializable {
	private static final long serialVersionUID = 1L;
	private String firstname;
	private String lastname;
	private String username;
	private String email;
	private String oldPassword;
	private String newPassword;
	private String passwordConfirmation;
	

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}

	public void setPasswordConfirmation(String passwordConfirmation) {
		this.passwordConfirmation = passwordConfirmation;
	}

	public Profil() {
		super();
	}

	public Profil(String username2, HttpServletRequest request, Connection conn) {
		super();
	}
	
}