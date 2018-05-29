package servlets;

import beans.UserAdministration;

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
import java.util.Date;
import java.util.List;

@WebServlet(name = "RefreshAdminPageServlet")
public class RefreshAdminPageServlet extends HttpServlet {

    @Resource(lookup = "jdbc/MyMathemathikquizPool")
    private DataSource dataSource;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        List<UserAdministration> userAdministrationArrayList = readUserWithGames();

        request.setAttribute("userAdministrationArrayList", userAdministrationArrayList);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("html/maintenance/adminPage.jsp");
        requestDispatcher.forward(request, response);
    }

    private List<UserAdministration> readUserWithGames() throws ServletException {
        List<UserAdministration> userAdministrationArrayList = new ArrayList<UserAdministration>();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT UserId, FirstName, LastName, UserName, Email, Gender, "
                     +"GameId, GamingTime, GameDate, GameType, GameDifficulty "
                     + "FROM user NATURAL JOIN game;");
             PreparedStatement preparedStatement1 = connection.prepareStatement("SELECT UserId, FirstName, LastName, UserName, Email, Gender FROM user;")) {
            UserAdministration userInformation = new UserAdministration();
            try (ResultSet resultSet = preparedStatement.executeQuery()){
                while (resultSet.next()) {
//                    UserAdministration userInformation = new UserAdministration();

                    int userId = resultSet.getInt("UserId");
                    userInformation.setUserId(userId);

                    String userFirstName = resultSet.getString("FirstName");
                    userInformation.setUserFirstName(userFirstName);

                    String userLastName = resultSet.getString("LastName");
                    userInformation.setUserLastName(userLastName);

                    String userName = resultSet.getString("UserName");
                    userInformation.setUserName(userName);

                    String userEmail = resultSet.getString("Email");
                    userInformation.setUserEmail(userEmail);

                    String userGender = resultSet.getString("Gender");
                    userInformation.setUserGender(userGender);

                    int userGameId = resultSet.getInt("GameId");
                    userInformation.setUserGameId(userGameId);

                    int userGamingTime = resultSet.getInt("GamingTime");
                    userInformation.setUserGamingTime(userGamingTime);

                    Date userGameDate = resultSet.getDate("GameDate");
                    userInformation.setUserGameDate(userGameDate);

                    String userGameType = resultSet.getString("GameType");
                    userInformation.setUserGameType(userGameType);

                    String userGameDifficulty = resultSet.getString("GameDifficulty");
                    userInformation.setUserGameDifficulty(userGameDifficulty);

                    userAdministrationArrayList.add(userInformation);
                }
            } try (ResultSet resultSet = preparedStatement1.executeQuery()){
                while (resultSet.next()) {

                    int userIdAll = resultSet.getInt("UserId");
                    userInformation.setUserIdAll(userIdAll);

                    String userFirstNameAll = resultSet.getString("FirstName");
                    userInformation.setUserFirstNameAll(userFirstNameAll);

                    String userLastNameAll = resultSet.getString("LastName");
                    userInformation.setUserLastNameAll(userLastNameAll);

                    String userNameAll = resultSet.getString("UserName");
                    userInformation.setUserNameAll(userNameAll);

                    String userEmailAll = resultSet.getString("Email");
                    userInformation.setUserEmailAll(userEmailAll);

                    String userGenderAll = resultSet.getString("Gender");
                    userInformation.setUserGenderAll(userGenderAll);

                    userAdministrationArrayList.add(userInformation);
                }
            }
        } catch (Exception exception) {
            throw new ServletException(exception.getMessage());
        }
        return userAdministrationArrayList;
    }

}
