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

@WebServlet("/RegistrierungServlet")
public class RegistrierungServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    @Resource(lookup = "jdbc/MyTHIPool")
    private DataSource ds;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        User form = new User();
        form.setFirstname(request.getParameter("firstname"));
        form.setLastname(request.getParameter("lastname"));
        form.setUsername(request.getParameter("username"));
        form.setEmail(request.getParameter("mail"));
        form.setPassword(request.getParameter("password"));
        form.setPasswordConfirmation(request.getParameter("passwordConfirmation"));
        form.setGender(request.getParameter("gender"));

        if (emailCheck(form.getEmail())) {
            final RequestDispatcher dispatcher = request
                    .getRequestDispatcher("html/user_pages/create_new_profile_error.jsp");
            dispatcher.forward(request, response);
        } else if ((usernameUeberpruefen(form.getUsername()) == false)
                && (passwordCheck(form.getPassword(), form.getPasswordConfirmation()) == false)) {
            speichern(form);
            User user = read(form.getUsername());
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            final RequestDispatcher dispatcher = request
                    .getRequestDispatcher("html/user_pages/register_confirmation.jsp");
            dispatcher.forward(request, response);
        } else {
            final RequestDispatcher dispatcher = request
                    .getRequestDispatcher("html/user_pages/create_new_profile_error.jsp");
            dispatcher.forward(request, response);
        }

    }

    private void speichern(User form) throws ServletException {
        String[] generatedKeys = new String[] { "UserId" };

        try (Connection con = ds.getConnection();
             PreparedStatement pstmt = con.prepareStatement(
                     "INSERT INTO user(FirstName, LastName, UserName,Email, Password,gender)VALUES(?,?,?,?,?,?);",
                     generatedKeys);
             PreparedStatement pstmt1 = con.prepareStatement(
                     "INSERT INTO leaderboard(UserName, GameType, GameDifficulty) VALUES (?,?,?);");
             PreparedStatement pstmt2 = con.prepareStatement(
                     "INSERT INTO leaderboard(UserName, GameType, GameDifficulty) VALUES (?,?,?);");
             PreparedStatement pstmt3 = con.prepareStatement(
                     "INSERT INTO leaderboard(UserName, GameType, GameDifficulty) VALUES (?,?,?);");
             PreparedStatement pstmt4 = con.prepareStatement(
                     "INSERT INTO leaderboard(UserName, GameType, GameDifficulty) VALUES (?,?,?);");
             PreparedStatement pstmt5 = con.prepareStatement(
                     "INSERT INTO leaderboard(UserName, GameType, GameDifficulty) VALUES (?,?,?);");
             PreparedStatement pstmt6 = con.prepareStatement(
                     "INSERT INTO leaderboard(UserName, GameType, GameDifficulty) VALUES (?,?,?);");
             PreparedStatement pstmt7 = con.prepareStatement(
                     "INSERT INTO leaderboard(UserName, GameType, GameDifficulty) VALUES (?,?,?);");
             PreparedStatement pstmt8 = con.prepareStatement(
                     "INSERT INTO leaderboard(UserName, GameType, GameDifficulty) VALUES (?,?,?);");
             PreparedStatement pstmt9 = con.prepareStatement(
                     "INSERT INTO leaderboard(UserName, GameType, GameDifficulty) VALUES (?,?,?);")) {

            pstmt.setString(1, form.getFirstname());
            pstmt.setString(2, form.getLastname());
            pstmt.setString(3, form.getUsername());
            pstmt.setString(4, form.getEmail());
            pstmt.setString(5, form.getPassword());
            pstmt.setString(6, form.getGender());
            pstmt.executeUpdate();

            pstmt1.setString(1, form.getUsername());
            pstmt1.setString(2, "Addition/Subtraktion");
            pstmt1.setString(3, "Leicht");
            pstmt1.executeUpdate();

            pstmt2.setString(1, form.getUsername());
            pstmt2.setString(2, "Addition/Subtraktion");
            pstmt2.setString(3, "Mittel");
            pstmt2.executeUpdate();

            pstmt3.setString(1, form.getUsername());
            pstmt3.setString(2, "Addition/Subtraktion");
            pstmt3.setString(3, "Schwer");
            pstmt3.executeUpdate();

            pstmt4.setString(1, form.getUsername());
            pstmt4.setString(2, "Multiplikation/Division");
            pstmt4.setString(3, "Leicht");
            pstmt4.executeUpdate();

            pstmt5.setString(1, form.getUsername());
            pstmt5.setString(2, "Multiplikation/Division");
            pstmt5.setString(3, "Mittel");
            pstmt5.executeUpdate();

            pstmt6.setString(1, form.getUsername());
            pstmt6.setString(2, "Multiplikation/Division");
            pstmt6.setString(3, "Schwer");
            pstmt6.executeUpdate();

            pstmt7.setString(1, form.getUsername());
            pstmt7.setString(2, "Addition/Subtraktion/Multiplikation/Division");
            pstmt7.setString(3, "Leicht");
            pstmt7.executeUpdate();

            pstmt8.setString(1, form.getUsername());
            pstmt8.setString(2, "Addition/Subtraktion/Multiplikation/Division");
            pstmt8.setString(3, "Mittel");
            pstmt8.executeUpdate();

            pstmt9.setString(1, form.getUsername());
            pstmt9.setString(2, "Addition/Subtraktion/Multiplikation/Division");
            pstmt9.setString(3, "Schwer");
            pstmt9.executeUpdate();

        } catch (Exception ex) {
            System.out.println(ex);
            throw new ServletException(ex.getMessage());
        }
    }

    private User read(String username) throws ServletException {
        User user = new User();
        user.setUsername(username);

        try (Connection connection = ds.getConnection();
             PreparedStatement preparedStatement = connection
                     .prepareStatement("SELECT * FROM user WHERE UserName LIKE ?;")) {
            preparedStatement.setString(1, username);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet != null && resultSet.next()) {
                    user.setUserId(Integer.valueOf(resultSet.getInt("UserId")));
                    user.setFirstname(resultSet.getString("FirstName"));
                    user.setLastname(resultSet.getString("LastName"));
                    user.setEmail(resultSet.getString("Email"));
                    user.setPassword(resultSet.getString("Password"));
                    user.setGender(resultSet.getString("Gender"));
                    user.setUserGroup(resultSet.getString("UserGroup"));
                }
            }
        } catch (Exception exception) {
            throw new ServletException(exception.getMessage());
        }
        return user;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected boolean usernameUeberpruefen(String username) throws ServletException {
        try (Connection con = ds.getConnection();
             PreparedStatement pstmt = con.prepareStatement("SELECT * FROM user WHERE UserName = ?;")) {
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

    protected boolean emailCheck(String email) throws ServletException {
        try (Connection con = ds.getConnection();
             PreparedStatement pstmt = con.prepareStatement("SELECT * FROM user WHERE email = ?;")) {
            pstmt.setString(1, email);
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