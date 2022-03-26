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

@WebServlet("/LetztesSpielAnzeigenServlet")
public class LetztesSpielAnzeigenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource(lookup = "jdbc/MyTHIPool")
	private DataSource ds;

	public LetztesSpielAnzeigenServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		saveGame savegame1 = new saveGame();

		User currentUser = (User) request.getSession().getAttribute("user");

		savegame1.setUserid(currentUser.getUserId());
		// DB-Zugriff
		read(savegame1);
		request.setAttribute("savegame1", savegame1);
		if (savegame1.getAufgabe_01() == null) {

			final RequestDispatcher dispatcher = request
					.getRequestDispatcher("html/previous_games/no_games_played.jsp");
			dispatcher.forward(request, response);
		} else {

			// Weiterleiten an JSP
			final RequestDispatcher dispatcher = request.getRequestDispatcher("html/previous_games/last_game.jsp");
			dispatcher.forward(request, response);
		}

	}

	private saveGame read(saveGame savegame1) throws ServletException, IOException {

		// DB-Zugriff
		try (Connection con = ds.getConnection(); PreparedStatement pstmt = con

				.prepareStatement("SELECT * FROM game WHERE UserId = ? ORDER BY GameId DESC LIMIT 1;")) {
			pstmt.setInt(1, savegame1.getUserid());

			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs != null && rs.next()) {

					String aufgabe01 = rs.getString("Exercise_01");
					savegame1.setAufgabe_01(aufgabe01);
					int loesung01 = rs.getInt("ExerciseSolution_01");
					savegame1.setLoesung_01(loesung01);
					int userErgebnis01 = rs.getInt("UserSolution_01");
					savegame1.setUserErgebnis_01(userErgebnis01);

					String aufgabe02 = rs.getString("Exercise_02");
					savegame1.setAufgabe_02(aufgabe02);
					int loesung02 = rs.getInt("ExerciseSolution_02");
					savegame1.setLoesung_02(loesung02);
					int userErgebnis02 = rs.getInt("UserSolution_02");
					savegame1.setUserErgebnis_02(userErgebnis02);

					String aufgabe03 = rs.getString("Exercise_03");
					savegame1.setAufgabe_03(aufgabe03);
					int loesung03 = rs.getInt("ExerciseSolution_03");
					savegame1.setLoesung_03(loesung03);
					int userErgebnis03 = rs.getInt("UserSolution_03");
					savegame1.setUserErgebnis_03(userErgebnis03);

					String aufgabe04 = rs.getString("Exercise_04");
					savegame1.setAufgabe_04(aufgabe04);
					int loesung04 = rs.getInt("ExerciseSolution_04");
					savegame1.setLoesung_04(loesung04);
					int userErgebnis04 = rs.getInt("UserSolution_04");
					savegame1.setUserErgebnis_04(userErgebnis04);

					String aufgabe05 = rs.getString("Exercise_05");
					savegame1.setAufgabe_05(aufgabe05);
					int loesung05 = rs.getInt("ExerciseSolution_05");
					savegame1.setLoesung_05(loesung05);
					int userErgebnis05 = rs.getInt("UserSolution_05");
					savegame1.setUserErgebnis_05(userErgebnis05);

					String aufgabe06 = rs.getString("Exercise_06");
					savegame1.setAufgabe_06(aufgabe06);
					int loesung06 = rs.getInt("ExerciseSolution_06");
					savegame1.setLoesung_06(loesung06);
					int userErgebnis06 = rs.getInt("UserSolution_06");
					savegame1.setUserErgebnis_06(userErgebnis06);

					String aufgabe07 = rs.getString("Exercise_07");
					savegame1.setAufgabe_07(aufgabe07);
					int loesung07 = rs.getInt("ExerciseSolution_07");
					savegame1.setLoesung_07(loesung07);
					int userErgebnis07 = rs.getInt("UserSolution_07");
					savegame1.setUserErgebnis_07(userErgebnis07);

					String aufgabe08 = rs.getString("Exercise_08");
					savegame1.setAufgabe_08(aufgabe08);
					int loesung08 = rs.getInt("ExerciseSolution_08");
					savegame1.setLoesung_08(loesung08);
					int userErgebnis08 = rs.getInt("UserSolution_08");
					savegame1.setUserErgebnis_08(userErgebnis08);

					String aufgabe09 = rs.getString("Exercise_09");
					savegame1.setAufgabe_09(aufgabe09);
					int loesung09 = rs.getInt("ExerciseSolution_09");
					savegame1.setLoesung_09(loesung09);
					int userErgebnis09 = rs.getInt("UserSolution_09");
					savegame1.setUserErgebnis_09(userErgebnis09);

					String aufgabe10 = rs.getString("Exercise_10");
					savegame1.setAufgabe_10(aufgabe10);
					int loesung10 = rs.getInt("ExerciseSolution_10");
					savegame1.setLoesung_10(loesung10);
					int userErgebnis10 = rs.getInt("UserSolution_10");
					savegame1.setUserErgebnis_10(userErgebnis10);

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