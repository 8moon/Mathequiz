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

import beans.saveGame;

@WebServlet("/SpielErgebnisCheck")
public class SpielErgebnisCheck extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Resource(lookup = "jdbc/MyMathematikquizdbPool")
	private DataSource ds;

	private int anzRichtigeErgebnisse = 0;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		saveGame savegame1 = (saveGame) request.getSession().getAttribute("savegame1");

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

		long diffInMillies = new Date().getTime() - savegame1.getDtime().getTime();
		savegame1.setErgebnisTime(diffInMillies);

		// DB-Zugriff
		saveGame savegame2 = read1();
		saveGame savegame3 = read();

		// Scope "Request"
		request.setAttribute("savegame2", savegame2);
		request.setAttribute("savegame3", savegame3);
		persist(savegame1, savegame2, savegame3);

		final HttpSession session = request.getSession();
		session.setAttribute("savegame1", savegame1);
		session.setAttribute("savegame2", savegame2);
		session.setAttribute("savegame3", savegame3);
		RequestDispatcher dispatcher = request.getRequestDispatcher("home/html/spieleSeitePrüfung.jsp");
		dispatcher.forward(request, response);

	}

	private saveGame read() throws ServletException {
		saveGame savegame3 = new saveGame();

		try (Connection con = ds.getConnection();
				PreparedStatement pstmt = con.prepareStatement("SELECT * FROM user " + "WHERE UserId = 1")) {

			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs != null && rs.next()) {

					savegame3.setUserid(rs.getInt("UserId"));

				}
			}
		} catch (Exception ex) {
			throw new ServletException(ex.getMessage());
		}

		return savegame3;
	}

	private saveGame read1() throws ServletException {
		saveGame savegame2 = new saveGame();

		try (Connection con = ds.getConnection();
				PreparedStatement pstmt = con
						.prepareStatement("SELECT * FROM game " + "WHERE GameId = (SELECT max(GameId) FROM game)")) {

			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs != null && rs.next()) {

					savegame2.setGameid(rs.getInt("GameId"));

				}
			}
		} catch (Exception ex) {
			throw new ServletException(ex.getMessage());
		}

		return savegame2;
	}

	private void persist(saveGame savegame1, saveGame savegame2, saveGame savegame3) throws ServletException {

		try (Connection con = ds.getConnection();

				PreparedStatement pstmt = con.prepareStatement(
						"INSERT INTO game (GameType,GamingTime,GameDate,UserId,GameDifficulty,RightUserSolutions) VALUES (?,?,?,?,?,?)")) {

			pstmt.setLong(2, savegame1.getErgebnisTime());
			pstmt.setString(1, savegame1.getAufgabeUndSchwierigkeit());
			pstmt.setTimestamp(3, new java.sql.Timestamp(savegame1.getDtime().getTime()));
			pstmt.setInt(4, savegame3.getUserid());

			pstmt.setString(5, savegame1.getAufgabeUndSchwierigkeit());
			pstmt.setInt(6, savegame1.getUserErgebnis_richtig());

		}

		catch (Exception e) {
			throw new ServletException(e.getMessage());
		}

		try (Connection con = ds.getConnection();
				PreparedStatement pstmt = con.prepareStatement(
						"INSERT INTO exercise (UserSolution,ExerciseSolution,Exercise,ExerciseNumber,GameId) VALUES(?,?,?,?,?)")) {

			pstmt.setInt(1, savegame1.getUserErgebnis_01());
			pstmt.setInt(2, savegame1.getLoesung_01());
			pstmt.setString(3, savegame1.getAufgabe_01());
			pstmt.setInt(4, 1);
			pstmt.setInt(5, savegame2.getMaxGameId() + 1);
			pstmt.executeUpdate();

			pstmt.setInt(1, savegame1.getUserErgebnis_02());
			pstmt.setInt(2, savegame1.getLoesung_02());
			pstmt.setString(3, savegame1.getAufgabe_02());
			pstmt.setInt(4, 2);
			pstmt.setInt(5, savegame2.getMaxGameId() + 1);
			pstmt.executeUpdate();

			pstmt.setInt(1, savegame1.getUserErgebnis_03());
			pstmt.setInt(2, savegame1.getLoesung_03());
			pstmt.setString(3, savegame1.getAufgabe_03());
			pstmt.setInt(4, 3);
			pstmt.setInt(5, savegame2.getMaxGameId() + 1);
			pstmt.executeUpdate();

			pstmt.setInt(1, savegame1.getUserErgebnis_04());
			pstmt.setInt(2, savegame1.getLoesung_04());
			pstmt.setString(3, savegame1.getAufgabe_04());
			pstmt.setInt(4, 4);
			pstmt.setInt(5, savegame2.getMaxGameId() + 1);
			pstmt.executeUpdate();

			pstmt.setInt(1, savegame1.getUserErgebnis_05());
			pstmt.setInt(2, savegame1.getLoesung_05());
			pstmt.setString(3, savegame1.getAufgabe_05());
			pstmt.setInt(4, 5);
			pstmt.setInt(5, savegame2.getMaxGameId() + 1);
			pstmt.executeUpdate();

			pstmt.setInt(1, savegame1.getUserErgebnis_06());
			pstmt.setInt(2, savegame1.getLoesung_06());
			pstmt.setString(3, savegame1.getAufgabe_06());
			pstmt.setInt(4, 6);
			pstmt.setInt(5, savegame2.getMaxGameId() + 1);
			pstmt.executeUpdate();

			pstmt.setInt(1, savegame1.getUserErgebnis_07());
			pstmt.setInt(2, savegame1.getLoesung_07());
			pstmt.setString(3, savegame1.getAufgabe_07());
			pstmt.setInt(4, 7);
			pstmt.setInt(5, savegame2.getMaxGameId() + 1);
			pstmt.executeUpdate();

			pstmt.setInt(1, savegame1.getUserErgebnis_08());
			pstmt.setInt(2, savegame1.getLoesung_08());
			pstmt.setString(3, savegame1.getAufgabe_08());
			pstmt.setInt(4, 8);
			pstmt.setInt(5, savegame2.getMaxGameId() + 1);
			pstmt.executeUpdate();

			pstmt.setInt(1, savegame1.getUserErgebnis_09());
			pstmt.setInt(2, savegame1.getLoesung_09());
			pstmt.setString(3, savegame1.getAufgabe_09());
			pstmt.setInt(4, 9);
			pstmt.setInt(5, savegame2.getMaxGameId() + 1);
			pstmt.executeUpdate();

			pstmt.setInt(1, savegame1.getUserErgebnis_10());
			pstmt.setInt(2, savegame1.getLoesung_10());
			pstmt.setString(3, savegame1.getAufgabe_10());
			pstmt.setInt(4, 10);
			pstmt.setInt(5, savegame2.getMaxGameId() + 1);
			pstmt.executeUpdate();

		} catch (Exception e) {
			throw new ServletException(e.getMessage());
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);

	}
}