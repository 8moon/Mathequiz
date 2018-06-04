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

import beans.saveGame;

@WebServlet("/LetztesSpielAnzeigenServlet")
public class LetztesSpielAnzeigenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource(lookup = "jdbc/MyMathematikquizdbPool")
	private DataSource ds;

	public LetztesSpielAnzeigenServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Servlet zur Entgegennahme von Formularinhalten, Lesen der Daten in
		// einer DB und Generierung
		// eines Beans zur Weitergabe der Formulardaten an eine JSP
		request.setCharacterEncoding("UTF-8"); // In diesem Format erwartet das
												// Servlet jetzt die
												// Formulardaten

		// DB-Zugriff
		saveGame savegame1 = read();

		// Scope "Request"
		request.setAttribute("savegame1", savegame1);

		// Weiterleiten an JSP
		final RequestDispatcher dispatcher = request.getRequestDispatcher("home/html/lastGame.jsp");
		dispatcher.forward(request, response);

	}

	private saveGame read() throws ServletException {
		saveGame savegame1 = new saveGame();

		// DB-Zugriff
		try (Connection con = ds.getConnection();
				PreparedStatement pstmt = con.prepareStatement("SELECT * FROM exercise "
						+ "WHERE GameId = (SELECT max(GameId) FROM exercise) AND ExerciseNumber = 1")) {

			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs != null && rs.next()) {

					savegame1.setAufgabennummer_01(rs.getInt("ExerciseNumber"));
					savegame1.setAufgabe_01(rs.getString("Exercise"));
					savegame1.setLoesung_01(rs.getInt("ExerciseSolution"));
					savegame1.setUserErgebnis_01(rs.getInt("UserSolution"));
				}
			}
		} catch (Exception ex) {
			throw new ServletException(ex.getMessage());
		}
		try (Connection con = ds.getConnection();
				PreparedStatement pstmt = con.prepareStatement("SELECT * FROM exercise "
						+ "WHERE GameId = (SELECT max(GameId) FROM exercise) AND ExerciseNumber = 2")) {

			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs != null && rs.next()) {

					savegame1.setAufgabennummer_02(rs.getInt("ExerciseNumber"));
					savegame1.setAufgabe_02(rs.getString("Exercise"));
					savegame1.setLoesung_02(rs.getInt("ExerciseSolution"));
					savegame1.setUserErgebnis_02(rs.getInt("UserSolution"));

				}
			}
		} catch (Exception ex) {
			throw new ServletException(ex.getMessage());
		}
		try (Connection con = ds.getConnection();
				PreparedStatement pstmt = con.prepareStatement("SELECT * FROM exercise "
						+ "WHERE GameId = (SELECT max(GameId) FROM exercise) AND ExerciseNumber = 3")) {

			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs != null && rs.next()) {

					savegame1.setAufgabennummer_03(rs.getInt("ExerciseNumber"));
					savegame1.setAufgabe_03(rs.getString("Exercise"));
					savegame1.setLoesung_03(rs.getInt("ExerciseSolution"));
					savegame1.setUserErgebnis_03(rs.getInt("UserSolution"));

				}
			}
		} catch (Exception ex) {
			throw new ServletException(ex.getMessage());
		}
		try (Connection con = ds.getConnection();
				PreparedStatement pstmt = con.prepareStatement("SELECT * FROM exercise "
						+ "WHERE GameId = (SELECT max(GameId) FROM exercise) AND ExerciseNumber = 4")) {

			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs != null && rs.next()) {

					savegame1.setAufgabennummer_04(rs.getInt("ExerciseNumber"));
					savegame1.setAufgabe_04(rs.getString("Exercise"));
					savegame1.setLoesung_04(rs.getInt("ExerciseSolution"));
					savegame1.setUserErgebnis_04(rs.getInt("UserSolution"));

				}
			}
		} catch (Exception ex) {
			throw new ServletException(ex.getMessage());
		}
		try (Connection con = ds.getConnection();
				PreparedStatement pstmt = con.prepareStatement("SELECT * FROM exercise "
						+ "WHERE GameId = (SELECT max(GameId) FROM exercise) AND ExerciseNumber = 5")) {

			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs != null && rs.next()) {

					savegame1.setAufgabennummer_05(rs.getInt("ExerciseNumber"));
					savegame1.setAufgabe_05(rs.getString("Exercise"));
					savegame1.setLoesung_05(rs.getInt("ExerciseSolution"));
					savegame1.setUserErgebnis_05(rs.getInt("UserSolution"));

				}
			}
		} catch (Exception ex) {
			throw new ServletException(ex.getMessage());
		}
		try (Connection con = ds.getConnection();
				PreparedStatement pstmt = con.prepareStatement("SELECT * FROM exercise "
						+ "WHERE GameId = (SELECT max(GameId) FROM exercise) AND ExerciseNumber = 6")) {

			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs != null && rs.next()) {

					savegame1.setAufgabennummer_06(rs.getInt("ExerciseNumber"));
					savegame1.setAufgabe_06(rs.getString("Exercise"));
					savegame1.setLoesung_06(rs.getInt("ExerciseSolution"));
					savegame1.setUserErgebnis_06(rs.getInt("UserSolution"));

				}
			}
		} catch (Exception ex) {
			throw new ServletException(ex.getMessage());
		}
		try (Connection con = ds.getConnection();
				PreparedStatement pstmt = con.prepareStatement("SELECT * FROM exercise "
						+ "WHERE GameId = (SELECT max(GameId) FROM exercise) AND ExerciseNumber = 7")) {

			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs != null && rs.next()) {

					savegame1.setAufgabennummer_07(rs.getInt("ExerciseNumber"));
					savegame1.setAufgabe_07(rs.getString("Exercise"));
					savegame1.setLoesung_07(rs.getInt("ExerciseSolution"));
					savegame1.setUserErgebnis_07(rs.getInt("UserSolution"));

				}
			}
		} catch (Exception ex) {
			throw new ServletException(ex.getMessage());
		}
		try (Connection con = ds.getConnection();
				PreparedStatement pstmt = con.prepareStatement("SELECT * FROM exercise "
						+ "WHERE GameId = (SELECT max(GameId) FROM exercise) AND ExerciseNumber = 8")) {

			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs != null && rs.next()) {

					savegame1.setAufgabennummer_08(rs.getInt("ExerciseNumber"));
					savegame1.setAufgabe_08(rs.getString("Exercise"));
					savegame1.setLoesung_08(rs.getInt("ExerciseSolution"));
					savegame1.setUserErgebnis_08(rs.getInt("UserSolution"));

				}
			}
		} catch (Exception ex) {
			throw new ServletException(ex.getMessage());
		}
		try (Connection con = ds.getConnection();
				PreparedStatement pstmt = con.prepareStatement("SELECT * FROM exercise "
						+ "WHERE GameId = (SELECT max(GameId) FROM exercise) AND ExerciseNumber = 9")) {

			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs != null && rs.next()) {

					savegame1.setAufgabennummer_09(rs.getInt("ExerciseNumber"));
					savegame1.setAufgabe_09(rs.getString("Exercise"));
					savegame1.setLoesung_09(rs.getInt("ExerciseSolution"));
					savegame1.setUserErgebnis_09(rs.getInt("UserSolution"));

				}
			}
		} catch (Exception ex) {
			throw new ServletException(ex.getMessage());
		}
		try (Connection con = ds.getConnection();
				PreparedStatement pstmt = con.prepareStatement("SELECT * FROM exercise "
						+ "WHERE GameId = (SELECT max(GameId) FROM exercise) AND ExerciseNumber = 10")) {

			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs != null && rs.next()) {

					savegame1.setAufgabennummer_10(rs.getInt("ExerciseNumber"));
					savegame1.setAufgabe_10(rs.getString("Exercise"));
					savegame1.setLoesung_10(rs.getInt("ExerciseSolution"));
					savegame1.setUserErgebnis_10(rs.getInt("UserSolution"));

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
