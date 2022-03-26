//Erstellt von Thomas Theinert

package servlets;

import beans.User;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/UpdateUserAdminPageAJAXServlet")
public class UpdateUserAdminPageAJAXServlet extends HttpServlet {

    @Resource(lookup = "jdbc/MyTHIPool")
    private DataSource dataSource;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        Map<String, String> sendMap = new HashMap<String, String>();

        String info = "", select = "";

        User updateUserAdministrationAjax = new User();
        updateUserAdministrationAjax.setUserId(Integer.valueOf(request.getParameter("userId")));
        updateUserAdministrationAjax.setFirstname(request.getParameter("firstName"));
        updateUserAdministrationAjax.setLastname(request.getParameter("lastName"));
        updateUserAdministrationAjax.setUsername(request.getParameter("userName"));
        updateUserAdministrationAjax.setEmail(request.getParameter("eMail"));
        updateUserAdministrationAjax.setGender(request.getParameter("gender"));
        updateUserAdministrationAjax.setUserGroup(request.getParameter("userGroup"));

        sendMap.put(updateUserAdministrationAjax.getFirstname(), "UPDATE user SET FirstName = ? WHERE UserId = ?;");
        sendMap.put(updateUserAdministrationAjax.getLastname(), "UPDATE user SET LastName = ? WHERE UserId = ?;");
        sendMap.put(updateUserAdministrationAjax.getUsername(), "UPDATE user SET UserName = ? WHERE UserId = ?;");
        sendMap.put(updateUserAdministrationAjax.getEmail(), "UPDATE user SET Email = ? WHERE UserId = ?;");
        sendMap.put(updateUserAdministrationAjax.getGender(), "UPDATE user SET Gender = ? WHERE UserId = ?;");
        sendMap.put(updateUserAdministrationAjax.getUserGroup(), "UPDATE user SET UserGroup = ? WHERE UserId = ?;");

        for (Map.Entry<String, String> entry : sendMap.entrySet()) {
            if (entry.getKey() != null && entry.getKey() != "") {
                info = entry.getKey();
                select = entry.getValue();
                break;
            }
        }

        persist(updateUserAdministrationAjax, info, select);

        request.setAttribute("updateUserAdministrationAjax", updateUserAdministrationAjax);

        final RequestDispatcher requestDispatcher = request.getRequestDispatcher("html/maintenance/last_updated_user.jsp");
        requestDispatcher.forward(request, response);
    }

    private void persist(User updateUserAdministrationAjax, String info, String select) throws ServletException {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(select)){
            preparedStatement.setString(1, info);
            preparedStatement.setInt(2, updateUserAdministrationAjax.getUserId());
            preparedStatement.executeUpdate();
        } catch (Exception exception) {
            throw new ServletException(exception.getMessage());
        }
    }

}
