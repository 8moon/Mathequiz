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
	private String lastname;
	private String username;
	private String email;
	private String password;
	private String passwordConfirmation;

	public Registrierung() {
		super();
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
	


}
