// erstellt von Hoan Lu

package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import beans.User;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    @Resource(lookup = "jdbc/MyTHIPool")
    private DataSource ds;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        anmelden(request, response);
    }

    protected void anmelden(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        User user = new User();
        user.setUsername(request.getParameter("username"));
        user.setPassword(request.getParameter("password"));

        if (passwortPruefen(user.getUsername(), user.getPassword()) == true) {
            try (Connection con = ds.getConnection();
                 PreparedStatement pstmt = con.prepareStatement("SELECT * FROM user WHERE UserName =? ")) {
                pstmt.setString(1, user.getUsername());
                try (ResultSet rs = pstmt.executeQuery()) {
                    if (rs != null && rs.next()) {
                        User form = new User();
                        String firstname = rs.getString("FirstName");
                        form.setFirstname(firstname);
                        String username = (rs.getString("username"));
                        form.setUsername(username);
                        String lastname = rs.getString("LastName");
                        form.setLastname(lastname);
                        String email = rs.getString("Email");
                        form.setEmail(email);
                        int userId = rs.getInt("UserId");
                        String gender = rs.getString("gender");
                        form.setGender(gender);
                        String password = rs.getString("password");
                        form.setPassword(password);
                        String userGroup = rs.getString("UserGroup");
                        user.setUserGroup(userGroup);
                        form.setUserGroup(userGroup);
                        user.setUserId(userId);
                        form.setUserId(userId);
                        request.setAttribute("form", form);
                        session.setAttribute("user", form);
                        if (user.getUserGroup().equals("disabled")) {
                            session.removeAttribute("user");
                            session.removeAttribute("form");
                            final RequestDispatcher dispatcher = request.getRequestDispatcher("html/user_pages/create_new_profile_error.jsp");
                            dispatcher.forward(request, response);
                        } else {
                            final RequestDispatcher dispatcher = request
                                    .getRequestDispatcher("index.jsp");
                            dispatcher.forward(request, response);
                        }
                    }
                }
            } catch (Exception e) {
                throw new ServletException(e.getMessage());
            }
        } else {
            final RequestDispatcher dispatcher = request.getRequestDispatcher("html/user_pages/create_new_profile_error.jsp");
            dispatcher.forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    private boolean passwortPruefen(String username, String password) throws ServletException {
        boolean status = false;
        boolean isOk;

        try (Connection conn = ds.getConnection();
             PreparedStatement pstmt = conn.prepareStatement("SELECT Password FROM user WHERE UserName = ?")) {
            pstmt.setString(1, username);
            try (ResultSet rs = pstmt.executeQuery()) {
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