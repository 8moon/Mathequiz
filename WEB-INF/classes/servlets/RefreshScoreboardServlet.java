//Erstellt von Kahraman Ali und Theinert Thomas

package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import beans.Leaderboard;

@WebServlet("/RefreshScoreboardServlet")
public class RefreshScoreboardServlet extends HttpServlet {

    @Resource(lookup = "jdbc/MyTHIPool")
    private DataSource dataSource;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        List<Leaderboard> plusMinusMalGeteiltleicht = plusMinusMalGeteiltleicht();
        List<Leaderboard> plusMinusMalGeteiltnormal = plusMinusMalGeteiltnormal();
        List<Leaderboard> plusMinusMalGeteiltschwer = plusMinusMalGeteiltschwer();
        List<Leaderboard> plusMinusleicht = plusMinusleicht();
        List<Leaderboard> plusMinusnormal = plusMinusnormal();
        List<Leaderboard> plusMinusschwer = plusMinusschwer();
        List<Leaderboard> malGeteiltleicht = malGeteiltleicht();
        List<Leaderboard> malGeteiltnormal = malGeteiltnormal();
        List<Leaderboard> malGeteiltschwer = malGeteiltschwer();

        request.setAttribute("plusMinusMalGeteiltleicht", plusMinusMalGeteiltleicht);
        request.setAttribute("plusMinusMalGeteiltnormal", plusMinusMalGeteiltnormal);
        request.setAttribute("plusMinusMalGeteiltschwer", plusMinusMalGeteiltschwer);

        request.setAttribute("plusMinusleicht", plusMinusleicht);
        request.setAttribute("plusMinusnormal", plusMinusnormal);
        request.setAttribute("plusMinusschwer", plusMinusschwer);

        request.setAttribute("malGeteiltleicht", malGeteiltleicht);
        request.setAttribute("malGeteiltnormal", malGeteiltnormal);
        request.setAttribute("malGeteiltschwer", malGeteiltschwer);

        final RequestDispatcher requestDispatcher = request.getRequestDispatcher("html/previous_games/leaderboard.jsp");
        requestDispatcher.forward(request, response);
    }

    private List<Leaderboard> plusMinusMalGeteiltleicht() throws ServletException {
        List<Leaderboard> leaderboardListEasy = new ArrayList<Leaderboard>();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM leaderboard"
                     + " WHERE GameDifficulty LIKE 'Leicht' AND GameType LIKE 'Addition/Subtraktion/Multiplikation/Division'"
                     + "ORDER BY RightUserSolutions DESC, PlayedGames ASC, AverageGamingTime ASC;")) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Leaderboard leaderboard = new Leaderboard();

                    String userName = resultSet.getString("UserName");
                    leaderboard.setUserName(userName);

                    int rightUserSolutions = resultSet.getInt("RightUserSolutions");
                    leaderboard.setRightUserSolutions(rightUserSolutions);

                    int playedGames = resultSet.getInt("PlayedGames");
                    leaderboard.setPlayedGames(playedGames);

                    int averageGamingTime = resultSet.getInt("AverageGamingTime");
                    leaderboard.setAverageGamingTime(averageGamingTime);

                    String gameDifficulty = resultSet.getString("GameDifficulty");
                    leaderboard.setGameDifficulty(gameDifficulty);

                    String gameType = resultSet.getString("GameType");
                    leaderboard.setGameType(gameType);

                    leaderboardListEasy.add(leaderboard);
                }
            }
        } catch (Exception exception) {
            throw new ServletException(exception.getMessage());
        }
        return leaderboardListEasy;
    }

    private List<Leaderboard> plusMinusMalGeteiltnormal() throws ServletException {
        List<Leaderboard> leaderboardListNormal = new ArrayList<Leaderboard>();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM leaderboard"
                     + " WHERE GameDifficulty LIKE 'Mittel' AND GameType LIKE 'Addition/Subtraktion/Multiplikation/Division'"
                     + "ORDER BY RightUserSolutions DESC, PlayedGames ASC, AverageGamingTime ASC;")) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Leaderboard leaderboard = new Leaderboard();

                    String userName = resultSet.getString("UserName");
                    leaderboard.setUserName(userName);

                    int rightUserSolutions = resultSet.getInt("RightUserSolutions");
                    leaderboard.setRightUserSolutions(rightUserSolutions);

                    int playedGames = resultSet.getInt("PlayedGames");
                    leaderboard.setPlayedGames(playedGames);

                    int averageGamingTime = resultSet.getInt("AverageGamingTime");
                    leaderboard.setAverageGamingTime(averageGamingTime);

                    String gameDifficulty = resultSet.getString("GameDifficulty");
                    leaderboard.setGameDifficulty(gameDifficulty);

                    String gameType = resultSet.getString("GameType");
                    leaderboard.setGameType(gameType);

                    leaderboardListNormal.add(leaderboard);
                }
            }
        } catch (Exception exception) {
            throw new ServletException(exception.getMessage());
        }
        return leaderboardListNormal;
    }

    private List<Leaderboard> plusMinusMalGeteiltschwer() throws ServletException {
        List<Leaderboard> leaderboardListHard = new ArrayList<Leaderboard>();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM leaderboard"
                     + " WHERE GameDifficulty LIKE 'Schwer' AND GameType LIKE 'Addition/Subtraktion/Multiplikation/Division'"
                     + "ORDER BY RightUserSolutions DESC, PlayedGames ASC, AverageGamingTime ASC;")) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Leaderboard leaderboard = new Leaderboard();

                    String userName = resultSet.getString("UserName");
                    leaderboard.setUserName(userName);

                    int rightUserSolutions = resultSet.getInt("RightUserSolutions");
                    leaderboard.setRightUserSolutions(rightUserSolutions);

                    int playedGames = resultSet.getInt("PlayedGames");
                    leaderboard.setPlayedGames(playedGames);

                    int averageGamingTime = resultSet.getInt("AverageGamingTime");
                    leaderboard.setAverageGamingTime(averageGamingTime);

                    String gameDifficulty = resultSet.getString("GameDifficulty");
                    leaderboard.setGameDifficulty(gameDifficulty);

                    String gameType = resultSet.getString("GameType");
                    leaderboard.setGameType(gameType);

                    leaderboardListHard.add(leaderboard);
                }
            }
        } catch (Exception exception) {
            throw new ServletException(exception.getMessage());
        }
        return leaderboardListHard;
    }

    private List<Leaderboard> plusMinusleicht() throws ServletException {
        List<Leaderboard> leaderboardListHard = new ArrayList<Leaderboard>();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM leaderboard"
                     + " WHERE GameDifficulty LIKE 'Leicht' AND GameType LIKE 'Addition/Subtraktion'"
                     + "ORDER BY RightUserSolutions DESC, PlayedGames ASC, AverageGamingTime ASC;")) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Leaderboard leaderboard = new Leaderboard();

                    String userName = resultSet.getString("UserName");
                    leaderboard.setUserName(userName);

                    int rightUserSolutions = resultSet.getInt("RightUserSolutions");
                    leaderboard.setRightUserSolutions(rightUserSolutions);

                    int playedGames = resultSet.getInt("PlayedGames");
                    leaderboard.setPlayedGames(playedGames);

                    int averageGamingTime = resultSet.getInt("AverageGamingTime");
                    leaderboard.setAverageGamingTime(averageGamingTime);

                    String gameDifficulty = resultSet.getString("GameDifficulty");
                    leaderboard.setGameDifficulty(gameDifficulty);

                    String gameType = resultSet.getString("GameType");
                    leaderboard.setGameType(gameType);

                    leaderboardListHard.add(leaderboard);
                }
            }
        } catch (Exception exception) {
            throw new ServletException(exception.getMessage());
        }
        return leaderboardListHard;
    }

    private List<Leaderboard> plusMinusnormal() throws ServletException {
        List<Leaderboard> leaderboardListHard = new ArrayList<Leaderboard>();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM leaderboard"
                     + " WHERE GameDifficulty LIKE 'Mittel' AND GameType LIKE 'Addition/Subtraktion'"
                     + "ORDER BY RightUserSolutions DESC, PlayedGames ASC, AverageGamingTime ASC;")) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Leaderboard leaderboard = new Leaderboard();

                    String userName = resultSet.getString("UserName");
                    leaderboard.setUserName(userName);

                    int rightUserSolutions = resultSet.getInt("RightUserSolutions");
                    leaderboard.setRightUserSolutions(rightUserSolutions);

                    int playedGames = resultSet.getInt("PlayedGames");
                    leaderboard.setPlayedGames(playedGames);

                    int averageGamingTime = resultSet.getInt("AverageGamingTime");
                    leaderboard.setAverageGamingTime(averageGamingTime);

                    String gameDifficulty = resultSet.getString("GameDifficulty");
                    leaderboard.setGameDifficulty(gameDifficulty);

                    String gameType = resultSet.getString("GameType");
                    leaderboard.setGameType(gameType);

                    leaderboardListHard.add(leaderboard);
                }
            }
        } catch (Exception exception) {
            throw new ServletException(exception.getMessage());
        }
        return leaderboardListHard;
    }

    private List<Leaderboard> plusMinusschwer() throws ServletException {
        List<Leaderboard> leaderboardListHard = new ArrayList<Leaderboard>();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM leaderboard"
                     + " WHERE GameDifficulty LIKE 'Schwer' AND GameType LIKE 'Addition/Subtraktion'"
                     + "ORDER BY RightUserSolutions DESC, PlayedGames ASC, AverageGamingTime ASC;")) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Leaderboard leaderboard = new Leaderboard();

                    String userName = resultSet.getString("UserName");
                    leaderboard.setUserName(userName);

                    int rightUserSolutions = resultSet.getInt("RightUserSolutions");
                    leaderboard.setRightUserSolutions(rightUserSolutions);

                    int playedGames = resultSet.getInt("PlayedGames");
                    leaderboard.setPlayedGames(playedGames);

                    int averageGamingTime = resultSet.getInt("AverageGamingTime");
                    leaderboard.setAverageGamingTime(averageGamingTime);

                    String gameDifficulty = resultSet.getString("GameDifficulty");
                    leaderboard.setGameDifficulty(gameDifficulty);

                    String gameType = resultSet.getString("GameType");
                    leaderboard.setGameType(gameType);

                    leaderboardListHard.add(leaderboard);
                }
            }
        } catch (Exception exception) {
            throw new ServletException(exception.getMessage());
        }
        return leaderboardListHard;
    }

    private List<Leaderboard> malGeteiltleicht() throws ServletException {
        List<Leaderboard> leaderboardListHard = new ArrayList<Leaderboard>();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM leaderboard"
                     + " WHERE GameDifficulty LIKE 'Leicht' AND GameType LIKE 'Multiplikation/Division'"
                     + "ORDER BY RightUserSolutions DESC, PlayedGames ASC, AverageGamingTime ASC;")) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Leaderboard leaderboard = new Leaderboard();

                    String userName = resultSet.getString("UserName");
                    leaderboard.setUserName(userName);

                    int rightUserSolutions = resultSet.getInt("RightUserSolutions");
                    leaderboard.setRightUserSolutions(rightUserSolutions);

                    int playedGames = resultSet.getInt("PlayedGames");
                    leaderboard.setPlayedGames(playedGames);

                    int averageGamingTime = resultSet.getInt("AverageGamingTime");
                    leaderboard.setAverageGamingTime(averageGamingTime);

                    String gameDifficulty = resultSet.getString("GameDifficulty");
                    leaderboard.setGameDifficulty(gameDifficulty);

                    String gameType = resultSet.getString("GameType");
                    leaderboard.setGameType(gameType);

                    leaderboardListHard.add(leaderboard);
                }
            }
        } catch (Exception exception) {
            throw new ServletException(exception.getMessage());
        }
        return leaderboardListHard;
    }

    private List<Leaderboard> malGeteiltnormal() throws ServletException {
        List<Leaderboard> leaderboardListHard = new ArrayList<Leaderboard>();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM leaderboard"
                     + " WHERE GameDifficulty LIKE 'Mittel' AND GameType LIKE 'Multiplikation/Division'"
                     + "ORDER BY RightUserSolutions DESC, PlayedGames ASC, AverageGamingTime ASC;")) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Leaderboard leaderboard = new Leaderboard();

                    String userName = resultSet.getString("UserName");
                    leaderboard.setUserName(userName);

                    int rightUserSolutions = resultSet.getInt("RightUserSolutions");
                    leaderboard.setRightUserSolutions(rightUserSolutions);

                    int playedGames = resultSet.getInt("PlayedGames");
                    leaderboard.setPlayedGames(playedGames);

                    int averageGamingTime = resultSet.getInt("AverageGamingTime");
                    leaderboard.setAverageGamingTime(averageGamingTime);

                    String gameDifficulty = resultSet.getString("GameDifficulty");
                    leaderboard.setGameDifficulty(gameDifficulty);

                    String gameType = resultSet.getString("GameType");
                    leaderboard.setGameType(gameType);

                    leaderboardListHard.add(leaderboard);
                }
            }
        } catch (Exception exception) {
            throw new ServletException(exception.getMessage());
        }
        return leaderboardListHard;
    }

    private List<Leaderboard> malGeteiltschwer() throws ServletException {
        List<Leaderboard> leaderboardListHard = new ArrayList<Leaderboard>();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM leaderboard"
                     + " WHERE GameDifficulty LIKE 'Schwer' AND GameType LIKE 'Multiplikation/Division'"
                     + "ORDER BY RightUserSolutions DESC, PlayedGames ASC, AverageGamingTime ASC;")) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Leaderboard leaderboard = new Leaderboard();

                    String userName = resultSet.getString("UserName");
                    leaderboard.setUserName(userName);

                    int rightUserSolutions = resultSet.getInt("RightUserSolutions");
                    leaderboard.setRightUserSolutions(rightUserSolutions);

                    int playedGames = resultSet.getInt("PlayedGames");
                    leaderboard.setPlayedGames(playedGames);

                    int averageGamingTime = resultSet.getInt("AverageGamingTime");
                    leaderboard.setAverageGamingTime(averageGamingTime);

                    String gameDifficulty = resultSet.getString("GameDifficulty");
                    leaderboard.setGameDifficulty(gameDifficulty);

                    String gameType = resultSet.getString("GameType");
                    leaderboard.setGameType(gameType);

                    leaderboardListHard.add(leaderboard);
                }
            }
        } catch (Exception exception) {
            throw new ServletException(exception.getMessage());
        }
        return leaderboardListHard;
    }

}