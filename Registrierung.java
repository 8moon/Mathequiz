package DatenBean;

import java.io.Serializable;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class Registrierung
 */
@Stateless
@LocalBean
public class Registrierung implements Serializable {
	private static final long serialVersionUID = 1L; 
	private int id;
	private String firstname;
	private String Lastname;
	private String username;
	public Registrierung(String firstname, String lastname, String username, String email,
			String password, String passwordConfirmation) {
		super();
		this.firstname = firstname;
		Lastname = lastname;
		this.username = username;
		this.email = email;
		this.password = password;
		this.passwordConfirmation = passwordConfirmation;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return Lastname;
	}
	public void setLastname(String lastname) {
		Lastname = lastname;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}
	public void setPasswordConfirmation(String passwortConfirmation) {
		this.passwordConfirmation = passwortConfirmation;
	}
	private String email;
	private String password;
	private String passwordConfirmation;
	


}
