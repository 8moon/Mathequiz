package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import beans.Profil;

@WebServlet(name = "ProfilServlet")
@MultipartConfig
public class ProfilServlet extends HttpServlet {

    @Resource(lookup = "jdbc/MyMathemathikquizPool")
    private DataSource ds;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Profil user = (Profil) session.getAttribute("username");
        final String firstname = request.getParameter("firstname");
        final String lastname = request.getParameter("lastname");
        final String email = request.getParameter("email");
        final String oldPassword = request.getParameter("oldPassword");
        final String newPassword = request.getParameter("newPassword");
        final String passwordConfirmation = request.getParameter("passwordConfirmation");
        String dbFirstname = user.getFirstname();
        String dbLastname = user.getLastname();
        String dbEmail = user.getEmail();
        //	String dbpassword = user.getPassword();

        try {
            Connection conn = ds.getConnection();
            if (überprüfePassword(oldPassword, newPassword, passwordConfirmation) == true) {
                PreparedStatement pstm = conn.prepareStatement("UPDATE mathemathikquizdb.user"
                        + " SET vorname = ?, nachname = ? , email = ?, password = ? " + "WHERE username = ?");
                pstm.setString(1, datenÜberprüfen(firstname, dbFirstname));
                pstm.setString(2, datenÜberprüfen(lastname, dbLastname));
                pstm.setString(3, datenÜberprüfen(email,dbEmail));
                pstm.setString(4, user.getNewPassword());
                pstm.executeUpdate();
                conn.close();
            } else {
                final RequestDispatcher dispatcher = request.getRequestDispatcher("html/user_pages/sameUsername.jsp");
                dispatcher.forward(request, response);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        final RequestDispatcher dispatcher = request.getRequestDispatcher("html/user_pages/myProfile.jsp");
        dispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected boolean überprüfePassword(String oldPassword, String newPassword, String passwordConfirmation) {
        boolean status = false;
        if (newPassword.equals(passwordConfirmation) && (!(newPassword.equals(oldPassword)))&& newPassword != null && newPassword.length()>0) {
            // dbpassword.equals(oldPassword)
            status = true;
        } else {
            status = false;
        }
        return status;
    }

    protected String datenÜberprüfen(String infoDaten, String dbDaten) {
        if (infoDaten != null && infoDaten.length() > 0) {
            return infoDaten;
        } else {
            return dbDaten;
        }
    }
}
