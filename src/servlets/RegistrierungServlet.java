package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import beans.Registrierung;

@WebServlet(name = "RegistrierungServlet")
public class RegistrierungServlet extends HttpServlet {

    @Resource(lookup = "jdbc/MyMathemathikquizPool")
    private DataSource ds;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final PrintWriter out = response.getWriter();
        request.setCharacterEncoding("UTF-8");
        Registrierung form = new Registrierung();
        form.setFirstname(request.getParameter("firstname"));
        form.setLastname(request.getParameter("lastname"));
        form.setUsername(request.getParameter("username"));
        form.setEmail(request.getParameter("email"));
        form.setPassword(request.getParameter("password"));
        form.setPasswordConfirmation(request.getParameter("passwordConfirmation"));

        if ((usernameUeberpruefen(form.getUsername())==false) && (passwordCheck(form.getPassword(), form.getPasswordConfirmation())==false)) {
            speichern(form);
            HttpSession session = request.getSession();
            session.setAttribute("form", form);
            final RequestDispatcher dispatcher = request.getRequestDispatcher("html/user_pages/registerConfirmation.jsp");
            dispatcher.forward(request, response);
        } else {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<h3> Username ist leider schon vergeben!");
            out.println("<h3> Bitte neu versuchen </h3>");
            out.println("</body>");
            out.println("</html>");
        }

    }

    private void speichern(Registrierung form) throws ServletException {
        String[] generatedKeys = new String[] { "UserId" };

        try (Connection con = ds.getConnection();
             PreparedStatement pstmt = con.prepareStatement(
                     "INSERT INTO mathemathikquizdb.user(firstname, lastname, username,email, password)VALUES(?,?,?,?,?)",
                     generatedKeys)) {
            pstmt.setString(1, form.getFirstname());
            pstmt.setString(2, form.getLastname());
            pstmt.setString(3, form.getUsername());
            pstmt.setString(4, form.getEmail());
            pstmt.setString(5, form.getPassword());
            pstmt.executeUpdate();
        } catch (Exception ex) {
            System.out.println(ex);
            throw new ServletException(ex.getMessage());
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected boolean usernameUeberpruefen(String username) throws ServletException {
        try (Connection con = ds.getConnection();
             PreparedStatement pstmt = con.prepareStatement("SELECT * FROM mathemathikquizdb.user WHERE UserName = ?")) {
            pstmt.setString(1, username);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return true;
                } else {
                    return false;
                }
            } catch (Exception e) {
            }
        } catch (Exception e) {
        }
        return false;
    }

    protected boolean passwordCheck(String pw1, String pw2) throws ServletException {
        if (pw1.equals(pw2)) {
            return false;
        } else {
            return true;
        }
    }

}
