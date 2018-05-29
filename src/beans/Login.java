package beans;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.servlet.http.HttpServletRequest;

/**
 * Session Bean implementation class Login
 */
@Stateless
@LocalBean
public class Login implements Serializable {
    private static final long serialVersionUID = 1L;
    private String username;
    private String password;
    private String firstname;
    private String lastname;
    private String email;
    private HttpServletRequest request;

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
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Login() {
        super();
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