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
import beans.Login;

@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {

    @Resource(lookup = "jdbc/MyMathemathikquizPool")
    private DataSource ds;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        anmelden(request,response);
    }

    protected void anmelden(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        response.setContentType("text/html");
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        session.getAttribute("username");
        Login user = new Login();
        user.setUsername(request.getParameter("username"));
        user.setPassword(request.getParameter("password"));

        if (passwortPruefen(user.getUsername(),user.getPassword()) == true) {
            try (Connection con = ds.getConnection();
                 PreparedStatement pstmt = con.prepareStatement("SELECT * FROM mathemathikquizdb.user WHERE username =? ")){
                pstmt.setString(1, user.getUsername());
                try(ResultSet rs = pstmt.executeQuery()){
                    if(rs != null && rs.next()) {
                        Login form = new Login();
                        String firstname = rs.getString("FirstName");
                        form.setFirstname(firstname);
                        form.setUsername(request.getParameter("username"));
                        String lastname = rs.getString("LastName");
                        form.setLastname(lastname);
                        String email = rs.getString("Email");
                        form.setEmail(email);
                        request.setAttribute("form", form);
                        session.setAttribute("user", user);
                        final RequestDispatcher dispatcher = request.getRequestDispatcher("html/user_pages/myProfile.jsp");
                        dispatcher.forward(request, response);
                    }
                }
            } catch (Exception e) {
                throw new ServletException(e.getMessage());
            }
        } else {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<h3> Username oder Passwort ist falsch");
            out.println("<h3> Bitte erneut versuchen </h3>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private boolean passwortPruefen(String username, String password) throws ServletException {
        boolean status = false;
        boolean isOk;

        try (Connection conn = ds.getConnection();
             PreparedStatement pstmt = conn.prepareStatement("SELECT password FROM mathemathikquizdb.user WHERE username = ?")) {
            pstmt.setString(1, username);
            try (ResultSet rs = pstmt.executeQuery()){
                isOk = rs.next();
                if (isOk == true) {
                    String pw = rs.getString("password");
                    if (password.equals(pw)) {
                        status = true;
                    }
                }
            } catch (Exception ex) {
                ex.getMessage();
            }
        } catch (Exception ex) {
            ex.getMessage();
        }
        return status;
    }

}
