package DatenBean;

import java.io.Serializable;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class Login
 */
@Stateless
@LocalBean
public class Login implements Serializable {
	private String username;
	private String password;
		private static final long serialVersionUID = 1L;
		public Login(String username, String passwort) {
			super();
			this.username = username;
			this.password = passwort;
		}
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		
}