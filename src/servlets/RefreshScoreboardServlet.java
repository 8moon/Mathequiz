package servlets;

import beans.Scoreboard;

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

@WebServlet(name = "RefreshScoreboardServlet")
public class RefreshScoreboardServlet extends HttpServlet {

    @Resource(lookup = "jdbc/MyMathemathikquizPool")
    private DataSource dataSource;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        List<Scoreboard> scoreboard = read();

        request.setAttribute("scoreboard", scoreboard);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("html/previous_games/bestenliste.jsp");
        requestDispatcher.forward(request, response);
    }

    private List<Scoreboard> read() throws ServletException {
        List<Scoreboard> scoreboard = new ArrayList<Scoreboard>();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT user.UserName, COUNT(exercise.ExerciseSolution = exercise.UserSolution) AS RightUserSolution, "
                     +"AVG(game.GamingTime) AS AverageGamingTime, game.GameType, game.GameDifficulty " +
                     "FROM user NATURAL JOIN (game NATURAL JOIN exercise);")) {
            try (ResultSet resultSet = preparedStatement.executeQuery()){
                while (resultSet.next()) {
                    Scoreboard user = new Scoreboard();

                    String username = resultSet.getString("UserName");
                    user.setUsername(username);

                    int rightUserSolution = resultSet.getInt("RightUserSolution");
                    user.setRightUserSolutions(rightUserSolution);

                    Long averageGamingTime = resultSet.getLong("AverageGamingTime");
                    user.setAverageGamingTime(averageGamingTime);

                    String gameType = resultSet.getString("GameType");
                    user.setGameType(gameType);

                    String gameDifficulty = resultSet.getString("GameDifficulty");
                    user.setGameDifficulty(gameDifficulty);

                    scoreboard.add(user);
                } // while rs.next()
            }
        } catch (Exception exception) {
            throw new ServletException(exception.getMessage());
        }
        return scoreboard;
    }

}
