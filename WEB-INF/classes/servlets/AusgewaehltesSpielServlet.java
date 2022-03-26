//Erstellt von Kahraman Ali

package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import beans.User;
import beans.saveGame;

@WebServlet("/AusgewaehltesSpielServlet")
public class AusgewaehltesSpielServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(lookup = "jdbc/MyTHIPool")
	private DataSource ds;

	public AusgewaehltesSpielServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		saveGame savegame1 = new saveGame();

		User currentUser = (User) request.getSession().getAttribute("user");
		savegame1.setUserid(currentUser.getUserId());

		Integer id = Integer.valueOf(request.getParameter("id"));

		read(savegame1, id);

		request.setAttribute("savegame1", savegame1);
		final RequestDispatcher dispatcher = request.getRequestDispatcher("html/previous_games/chosen_game.jsp");
		dispatcher.forward(request, response);
	}

	private saveGame read(saveGame savegame1, Integer id) throws ServletException {

		savegame1.setGameid(id);

		// DB-Zugriff
		try (Connection con = ds.getConnection();
			 PreparedStatement pstmt = con.prepareStatement("SELECT * FROM game WHERE UserId =? AND GameId =?")) {
			pstmt.setInt(1, savegame1.getUserid());
			pstmt.setInt(2, savegame1.getGameid());
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {

					String exercise01 = rs.getString("Exercise_01");
					savegame1.setAufgabe_01(exercise01);

					int exerciseSolution01 = rs.getInt("ExerciseSolution_01");
					savegame1.setLoesung_01(exerciseSolution01);

					int userSolution01 = rs.getInt("UserSolution_01");
					savegame1.setUserErgebnis_01(userSolution01);

					String exercise02 = rs.getString("Exercise_02");
					savegame1.setAufgabe_02(exercise02);

					int exerciseSolution02 = rs.getInt("ExerciseSolution_02");
					savegame1.setLoesung_02(exerciseSolution02);

					int userSolution02 = rs.getInt("UserSolution_02");
					savegame1.setUserErgebnis_02(userSolution02);

					String exercise03 = rs.getString("Exercise_03");
					savegame1.setAufgabe_03(exercise03);

					int exerciseSolution03 = rs.getInt("ExerciseSolution_03");
					savegame1.setLoesung_03(exerciseSolution03);

					int userSolution03 = rs.getInt("UserSolution_03");
					savegame1.setUserErgebnis_03(userSolution03);

					String exercise04 = rs.getString("Exercise_04");
					savegame1.setAufgabe_04(exercise04);

					int exerciseSolution04 = rs.getInt("ExerciseSolution_04");
					savegame1.setLoesung_04(exerciseSolution04);

					int userSolution04 = rs.getInt("UserSolution_04");
					savegame1.setUserErgebnis_04(userSolution04);

					String exercise05 = rs.getString("Exercise_05");
					savegame1.setAufgabe_05(exercise05);

					int exerciseSolution05 = rs.getInt("ExerciseSolution_05");
					savegame1.setLoesung_05(exerciseSolution05);

					int userSolution05 = rs.getInt("UserSolution_05");
					savegame1.setUserErgebnis_05(userSolution05);

					String exercise06 = rs.getString("Exercise_06");
					savegame1.setAufgabe_06(exercise06);

					int exerciseSolution06 = rs.getInt("ExerciseSolution_06");
					savegame1.setLoesung_06(exerciseSolution06);

					int userSolution06 = rs.getInt("UserSolution_06");
					savegame1.setUserErgebnis_06(userSolution06);

					String exercise07 = rs.getString("Exercise_07");
					savegame1.setAufgabe_07(exercise07);

					int exerciseSolution07 = rs.getInt("ExerciseSolution_07");
					savegame1.setLoesung_07(exerciseSolution07);

					int userSolution07 = rs.getInt("UserSolution_07");
					savegame1.setUserErgebnis_07(userSolution07);

					String exercise08 = rs.getString("Exercise_08");
					savegame1.setAufgabe_08(exercise08);

					int exerciseSolution08 = rs.getInt("ExerciseSolution_08");
					savegame1.setLoesung_08(exerciseSolution08);

					int userSolution08 = rs.getInt("UserSolution_08");
					savegame1.setUserErgebnis_08(userSolution08);

					String exercise09 = rs.getString("Exercise_09");
					savegame1.setAufgabe_09(exercise09);

					int exerciseSolution09 = rs.getInt("ExerciseSolution_09");
					savegame1.setLoesung_09(exerciseSolution09);

					int userSolution09 = rs.getInt("UserSolution_09");
					savegame1.setUserErgebnis_09(userSolution09);

					String exercise10 = rs.getString("Exercise_10");
					savegame1.setAufgabe_10(exercise10);

					int exerciseSolution10 = rs.getInt("ExerciseSolution_10");
					savegame1.setLoesung_10(exerciseSolution10);

					int userSolution10 = rs.getInt("UserSolution_10");
					savegame1.setUserErgebnis_10(userSolution10);
				}
			}
		} catch (Exception ex) {
			throw new ServletException(ex.getMessage());
		}
		return savegame1;

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}