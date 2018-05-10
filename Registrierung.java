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
	private String vorname;
	private String nachname;
	private String benutzername;
	private String email;
	private String passwort;
	private String passwortBest�tigen;
	
	public String getBenutzername() {
		return benutzername;
	}

	public void setBenutzername(String benutzername) {
		this.benutzername = benutzername;
	}



    /**#
     * Default constructor. 
     */
    public Registrierung() {
        // TODO Auto-generated constructor stub
    }

	public Registrierung(String vorname, String nachname, String benutzername,String email, String passwort,
			String passwortBest�tigen) {
		super();
		this.vorname = vorname;
		this.nachname = nachname;
		this.benutzername = benutzername;
		this.email = email;
		this.passwort = passwort;
		this.passwortBest�tigen = passwortBest�tigen;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPasswort() {
		return passwort;
	}

	public void setPasswort(String passwort) {
		this.passwort = passwort;
	}

	public String getPasswortBest�tigen() {
		return passwortBest�tigen;
	}

	public void setPasswortBest�tigen(String passwortBest�tigen) {
		this.passwortBest�tigen = passwortBest�tigen;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
