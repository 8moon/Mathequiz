//Erstellt von Kahraman Ali

package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import beans.Leaderboard;
import beans.User;
import beans.saveGame;

@WebServlet("/SpielErgebnisCheckServlet")
public class SpielErgebnisCheckServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Resource(lookup = "jdbc/MyTHIPool")
	private DataSource ds;

	private int anzRichtigeErgebnisse = 0;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		saveGame savegame1 = (saveGame) request.getSession().getAttribute("savegame1");

		Leaderboard leaderboard = (Leaderboard) request.getSession().getAttribute("leaderboard");

		User currentUser = (User) request.getSession().getAttribute("user");

		savegame1.setUserErgebnis_01(Integer.valueOf(request.getParameter("loesungUser1")));
		savegame1.setUserErgebnis_02(Integer.valueOf(request.getParameter("loesungUser2")));
		savegame1.setUserErgebnis_03(Integer.valueOf(request.getParameter("loesungUser3")));
		savegame1.setUserErgebnis_04(Integer.valueOf(request.getParameter("loesungUser4")));
		savegame1.setUserErgebnis_05(Integer.valueOf(request.getParameter("loesungUser5")));
		savegame1.setUserErgebnis_06(Integer.valueOf(request.getParameter("loesungUser6")));
		savegame1.setUserErgebnis_07(Integer.valueOf(request.getParameter("loesungUser7")));
		savegame1.setUserErgebnis_08(Integer.valueOf(request.getParameter("loesungUser8")));
		savegame1.setUserErgebnis_09(Integer.valueOf(request.getParameter("loesungUser9")));
		savegame1.setUserErgebnis_10(Integer.valueOf(request.getParameter("loesungUser10")));
		savegame1.setUserid(currentUser.getUserId());

		anzRichtigeErgebnisse = 0;
		if (savegame1.getUserErgebnis_01() == savegame1.getLoesung_01()) {
			anzRichtigeErgebnisse++;
		}
		if (savegame1.getUserErgebnis_02() == savegame1.getLoesung_02()) {
			anzRichtigeErgebnisse++;
		}
		if (savegame1.getUserErgebnis_03() == savegame1.getLoesung_03()) {
			anzRichtigeErgebnisse++;
		}
		if (savegame1.getUserErgebnis_04() == savegame1.getLoesung_04()) {
			anzRichtigeErgebnisse++;
		}
		if (savegame1.getUserErgebnis_05() == savegame1.getLoesung_05()) {
			anzRichtigeErgebnisse++;
		}
		if (savegame1.getUserErgebnis_06() == savegame1.getLoesung_06()) {
			anzRichtigeErgebnisse++;
		}
		if (savegame1.getUserErgebnis_07() == savegame1.getLoesung_07()) {
			anzRichtigeErgebnisse++;
		}
		if (savegame1.getUserErgebnis_08() == savegame1.getLoesung_08()) {
			anzRichtigeErgebnisse++;
		}
		if (savegame1.getUserErgebnis_09() == savegame1.getLoesung_09()) {
			anzRichtigeErgebnisse++;
		}
		if (savegame1.getUserErgebnis_10() == savegame1.getLoesung_10()) {
			anzRichtigeErgebnisse++;
		}

		savegame1.setUserErgebnis_richtig(anzRichtigeErgebnisse);
		leaderboard.setRightUserSolutions(leaderboard.getRightUserSolutions() + anzRichtigeErgebnisse);
		leaderboard.setPlayedGames(leaderboard.getPlayedGames() + 1);

		long diffInMillies = new Date().getTime() - savegame1.getDatetime().getTime();
		savegame1.setErgebnisTime(diffInMillies);

		persist(currentUser, savegame1);
		int avgTime = read(currentUser, leaderboard);
		leaderboard.setAverageGamingTime(avgTime);
		saveIntoLeaderboard(leaderboard);

		final HttpSession session = request.getSession();
		session.setAttribute("savegame1", savegame1);
		session.setAttribute("leaderboard", leaderboard);

		RequestDispatcher dispatcher = request.getRequestDispatcher("html/gaming_pages/user_game_result.jsp");
		dispatcher.forward(request, response);

	}

	private void persist(User currentUser, saveGame savegame1) throws ServletException {

		try (Connection con = ds.getConnection();

			 PreparedStatement pstmt = con.prepareStatement(
					 "INSERT INTO game (UserId, GamingTime, GameDate, GameType, GameDifficulty, Exercise_01, ExerciseSolution_01, UserSolution_01, RightUserSolutions, Exercise_02, ExerciseSolution_02, UserSolution_02, Exercise_03, ExerciseSolution_03, UserSolution_03, Exercise_04, ExerciseSolution_04, UserSolution_04, Exercise_05, ExerciseSolution_05, UserSolution_05, Exercise_06, ExerciseSolution_06, UserSolution_06, Exercise_07, ExerciseSolution_07, UserSolution_07, Exercise_08, ExerciseSolution_08, UserSolution_08, Exercise_09, ExerciseSolution_09, UserSolution_09, Exercise_10, ExerciseSolution_10, UserSolution_10) "
							 + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);")) {
//			pstmt.setInt(1, savegame1.getUserid());
			pstmt.setInt(1, currentUser.getUserId());
			pstmt.setLong(2, savegame1.getErgebnisTime());
			pstmt.setTimestamp(3, new java.sql.Timestamp(savegame1.getDatetime().getTime()));
			pstmt.setString(4, savegame1.getSpieltyp());
			pstmt.setString(5, savegame1.getSchwierigkeit());

			pstmt.setString(6, savegame1.getAufgabe_01());
			pstmt.setInt(7, savegame1.getLoesung_01());
			pstmt.setInt(8, savegame1.getUserErgebnis_01());

			pstmt.setInt(9, savegame1.getUserErgebnis_richtig());

			pstmt.setString(10, savegame1.getAufgabe_02());
			pstmt.setInt(11, savegame1.getLoesung_02());
			pstmt.setInt(12, savegame1.getUserErgebnis_02());

			pstmt.setString(13, savegame1.getAufgabe_03());
			pstmt.setInt(14, savegame1.getLoesung_03());
			pstmt.setInt(15, savegame1.getUserErgebnis_03());

			pstmt.setString(16, savegame1.getAufgabe_04());
			pstmt.setInt(17, savegame1.getLoesung_04());
			pstmt.setInt(18, savegame1.getUserErgebnis_04());

			pstmt.setString(19, savegame1.getAufgabe_05());
			pstmt.setInt(20, savegame1.getLoesung_05());
			pstmt.setInt(21, savegame1.getUserErgebnis_05());

			pstmt.setString(22, savegame1.getAufgabe_06());
			pstmt.setInt(23, savegame1.getLoesung_06());
			pstmt.setInt(24, savegame1.getUserErgebnis_06());

			pstmt.setString(25, savegame1.getAufgabe_07());
			pstmt.setInt(26, savegame1.getLoesung_07());
			pstmt.setInt(27, savegame1.getUserErgebnis_07());

			pstmt.setString(28, savegame1.getAufgabe_08());
			pstmt.setInt(29, savegame1.getLoesung_08());
			pstmt.setInt(30, savegame1.getUserErgebnis_08());

			pstmt.setString(31, savegame1.getAufgabe_09());
			pstmt.setInt(32, savegame1.getLoesung_09());
			pstmt.setInt(33, savegame1.getUserErgebnis_09());

			pstmt.setString(34, savegame1.getAufgabe_10());
			pstmt.setInt(35, savegame1.getLoesung_10());
			pstmt.setInt(36, savegame1.getUserErgebnis_10());

			pstmt.executeUpdate();

		} catch (Exception e) {
			throw new ServletException(e.getMessage());
		}

	}

	private int read(User currentUser, Leaderboard leaderboard) throws ServletException {
		int searchAvgtime = 0;

		try (Connection connection = ds.getConnection();
			 PreparedStatement preparedStatement = connection.prepareStatement("SELECT AVG(GamingTime) AS AverageGamingTime FROM game WHERE UserId LIKE ? AND GameDifficulty LIKE ? AND GameType LIKE ?;")){

			preparedStatement.setInt(1, currentUser.getUserId());
			preparedStatement.setString(2, leaderboard.getGameDifficulty());
			preparedStatement.setString(3, leaderboard.getGameType());

			try (ResultSet resultSet = preparedStatement.executeQuery()){
				if (resultSet!= null && resultSet.next()) {
					searchAvgtime = Integer.valueOf(resultSet.getInt("AverageGamingTime"));
				}
			}
		} catch (Exception exception) {
			throw new ServletException(exception.getMessage());
		}
		return searchAvgtime;
	}

	private void saveIntoLeaderboard(Leaderboard leaderboard) throws ServletException {
		try (Connection connection = ds.getConnection();
			 PreparedStatement preparedStatement = connection.prepareStatement("UPDATE leaderboard SET RightUserSolutions = ?"
					 +", PlayedGames = ?, AverageGamingTime = ? WHERE UserName LIKE ? AND GameDifficulty LIKE ? AND GameType LIKE ?;")){

			preparedStatement.setInt(1, leaderboard.getRightUserSolutions());
			preparedStatement.setInt(2, leaderboard.getPlayedGames());
			preparedStatement.setInt(3, leaderboard.getAverageGamingTime());
			preparedStatement.setString(4, leaderboard.getUserName());
			preparedStatement.setString(5, leaderboard.getGameDifficulty());
			preparedStatement.setString(6, leaderboard.getGameType());
			preparedStatement.executeUpdate();
		} catch (Exception exception) {
			throw new ServletException(exception.getMessage());
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);

	}
}