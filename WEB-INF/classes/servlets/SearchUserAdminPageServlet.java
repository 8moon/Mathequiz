//Erstellt von Thomas Theinert und Lu Hoan

package servlets;

import beans.SearchUserAdministration;

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
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/SearchUserAdminPageServlet")
public class SearchUserAdminPageServlet extends HttpServlet {

    @Resource(lookup = "jdbc/MyTHIPool")
    private DataSource dataSource;
/*

 */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String username = request.getParameter("username");

        List<SearchUserAdministration> userList = search(username);

        request.setAttribute("userList", userList);

        final RequestDispatcher requestDispatcher = request.getRequestDispatcher("html/maintenance/search_user_result_list.jsp");
        requestDispatcher.forward(request, response);
    }

    private List<SearchUserAdministration> search(String username) throws ServletException {
        username = (username == null || username == "") ? "%" : "%" + username + "%";
        List<SearchUserAdministration> userList = new ArrayList<SearchUserAdministration>();

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM user WHERE UserName LIKE ?;")){
            preparedStatement.setString(1, username);
            try (ResultSet resultSet = preparedStatement.executeQuery()){
                while (resultSet.next()) {
                    SearchUserAdministration userInformation = new SearchUserAdministration();

                    int userId = Integer.valueOf(resultSet.getInt("UserId"));
                    userInformation.setUserId(userId);

                    String firstName = resultSet.getString("FirstName");
                    userInformation.setFirstName(firstName);

                    String lastName = resultSet.getString("LastName");
                    userInformation.setLastName(lastName);

                    String eMail = resultSet.getString("Email");
                    userInformation.seteMail(eMail);

                    String userName = resultSet.getString("UserName");
                    userInformation.setUserName(userName);

                    String userGroup = resultSet.getString("UserGroup");
                    userInformation.setUserGroup(userGroup);

                    String gender = resultSet.getString("Gender");
                    userInformation.setGender(gender);

                    String profilePictureName = resultSet.getString("ProfilePictureName");
                    userInformation.setProfilePictureName(profilePictureName);

                    userList.add(userInformation);
                }
            }
        } catch (Exception exception) {
            throw new ServletException(exception.getMessage());
        }
        return userList;
    }

}