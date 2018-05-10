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
	private String vorname;
	private String nachname;
	private String benutzername;
	private String email;
	private String altesPasswort;
	private String neuesPasswort;
	private String passwortBest�tigen;

	public Profil(String vorname, String nachname, String benutzername, String email, String altesPasswort,
			String neuesPasswort, String passwortBest�tigen) {
		super();
		this.vorname = vorname;
		this.nachname = nachname;
		this.benutzername = benutzername;
		this.email = email;
		this.altesPasswort = altesPasswort;
		this.neuesPasswort = neuesPasswort;
		this.passwortBest�tigen = passwortBest�tigen;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public String getNachname() {
		return nachname;
	}

	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	public String getBenutzername() {
		return benutzername;
	}

	public void setBenutzername(String benutzername) {
		this.benutzername = benutzername;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAltesPasswort() {
		return altesPasswort;
	}

	public void setAltesPasswort(String altesPasswort) {
		this.altesPasswort = altesPasswort;
	}

	public String getNeuesPasswort() {
		return neuesPasswort;
	}

	public void setNeuesPasswort(String neuesPasswort) {
		this.neuesPasswort = neuesPasswort;
	}

	public String getPasswortBest�tigen() {
		return passwortBest�tigen;
	}

	public void setPasswortBest�tigen(String passwortBest�tigen) {
		this.passwortBest�tigen = passwortBest�tigen;
	}

}
