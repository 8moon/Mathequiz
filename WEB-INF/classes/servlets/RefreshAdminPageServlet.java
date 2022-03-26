//Erstellt von Thomas Theinert

package servlets;

import beans.UserGamesAdministration;
import beans.UserWithoutGamesAdministration;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet("/RefreshAdminPageServlet")
public class RefreshAdminPageServlet extends HttpServlet {

    @Resource(lookup = "jdbc/MyTHIPool")
    private DataSource dataSource;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        List<UserWithoutGamesAdministration>userWithoutGamesAdministrationList = readUserWithoutGamesAdministration();
        List<UserGamesAdministration>userGamesAdministrationArrayList = readUserGamesAdministration();

        request.setAttribute("userWithoutGamesAdministrationList", userWithoutGamesAdministrationList);
        request.setAttribute("userGamesAdministrationArrayList", userGamesAdministrationArrayList);

        HttpSession session = request.getSession();
        session.setAttribute("userWithoutGamesAdministrationList", userWithoutGamesAdministrationList);
        session.setAttribute("userGamesAdministrationArrayList", userGamesAdministrationArrayList);

        final RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/user_administration.jsp");
        requestDispatcher.forward(request, response);
    }

    private List<UserWithoutGamesAdministration> readUserWithoutGamesAdministration() throws ServletException {
        List<UserWithoutGamesAdministration> userWithoutGamesAdministrationList = new ArrayList<UserWithoutGamesAdministration>();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT UserId, FirstName, LastName, UserName, UserGroup, Email, Gender FROM user;")) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    UserWithoutGamesAdministration userWithoutGamesInformation = new UserWithoutGamesAdministration();

                    int userIdAll = resultSet.getInt("UserId");
                    userWithoutGamesInformation.setUserIdAll(userIdAll);

                    String userFirstNameAll = resultSet.getString("FirstName");
                    userWithoutGamesInformation.setUserFirstNameAll(userFirstNameAll);

                    String userLastNameAll = resultSet.getString("LastName");
                    userWithoutGamesInformation.setUserLastNameAll(userLastNameAll);

                    String userNameAll = resultSet.getString("UserName");
                    userWithoutGamesInformation.setUserNameAll(userNameAll);

                    String userGroupAll = resultSet.getString("UserGroup");
                    userWithoutGamesInformation.setUserGroupAll(userGroupAll);

                    String userEmailAll = resultSet.getString("Email");
                    userWithoutGamesInformation.setUserEmailAll(userEmailAll);

                    String userGenderAll = resultSet.getString("Gender");
                    userWithoutGamesInformation.setUserGenderAll(userGenderAll);

                    userWithoutGamesAdministrationList.add(userWithoutGamesInformation);

                }
            }
        } catch (Exception exception) {
            throw new ServletException(exception.getMessage());
        }
        return userWithoutGamesAdministrationList;
    }

    private List<UserGamesAdministration> readUserGamesAdministration() throws ServletException {
        List<UserGamesAdministration>userGamesAdministrationArrayList = new ArrayList<UserGamesAdministration>();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT UserId, FirstName, LastName, UserName, UserGroup, Email, Gender, "
                     +"GameId, GamingTime, GameDate, GameType, GameDifficulty "
                     + "FROM user NATURAL JOIN game;")) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {

                    UserGamesAdministration userGamesInformation = new UserGamesAdministration();

                    int userId = resultSet.getInt("UserId");
                    userGamesInformation.setUserId(userId);

                    String userFirstName = resultSet.getString("FirstName");
                    userGamesInformation.setUserFirstName(userFirstName);

                    String userLastName = resultSet.getString("LastName");
                    userGamesInformation.setUserLastName(userLastName);

                    String userName = resultSet.getString("UserName");
                    userGamesInformation.setUserName(userName);

                    String userGroup = resultSet.getString("UserGroup");
                    userGamesInformation.setUserGroup(userGroup);

                    String userEmail = resultSet.getString("Email");
                    userGamesInformation.setUserEmail(userEmail);

                    String userGender = resultSet.getString("Gender");
                    userGamesInformation.setUserGender(userGender);

                    int userGameId = resultSet.getInt("GameId");
                    userGamesInformation.setUserGameId(userGameId);

                    int userGamingTime = resultSet.getInt("GamingTime");
                    userGamesInformation.setUserGamingTime(userGamingTime);

                    Date userGameDate = resultSet.getDate("GameDate");
                    userGamesInformation.setUserGameDate(userGameDate);

                    String userGameType = resultSet.getString("GameType");
                    userGamesInformation.setUserGameType(userGameType);

                    String userGameDifficulty = resultSet.getString("GameDifficulty");
                    userGamesInformation.setUserGameDifficulty(userGameDifficulty);

                    userGamesAdministrationArrayList.add(userGamesInformation);
                }
            }
        }catch (Exception exception) {
            throw new ServletException(exception.getMessage());
        }
        return userGamesAdministrationArrayList;
    }

}
