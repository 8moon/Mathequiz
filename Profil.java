package DatenBean;

import java.io.Serializable;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class Profil
 */
@Stateless
@LocalBean
public class Profil implements Serializable {


	private static final long serialVersionUID = 1L;
	int id;
	private String firstname;
	private String lastname;
	private String username;
	private String email;
	private String oldPassword;
	private String newPassword;
	private String passwortConfirmation;

	public Profil(String firstname, String lastname, String username, String email, String oldPassword,
			String newPassword, String passwortConfirmation) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.email = email;
		this.oldPassword = oldPassword;
		this.newPassword = newPassword;
		this.passwortConfirmation = passwortConfirmation;
	}

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

	public String getPasswortConfirmation() {
		return passwortConfirmation;
	}

	public void setPasswortConfirmation(String passwortConfirmation) {
		this.passwortConfirmation = passwortConfirmation;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}