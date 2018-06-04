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

@WebServlet("/LetztenZehnSpieleServlet")
public class LetztenZehnSpieleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource(lookup = "jdbc/MyMathematikquizdbPool")
	private DataSource ds;

	public LetztenZehnSpieleServlet() {
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
		final RequestDispatcher dispatcher = request.getRequestDispatcher("home/html/lastTenGames.jsp");
		dispatcher.forward(request, response);

	}

	private saveGame read() throws ServletException {
		saveGame savegame1 = new saveGame();

		// DB-Zugriff
		try (Connection con = ds.getConnection();
				PreparedStatement pstmt = con.prepareStatement("SELECT * FROM game ORDER BY GameId DESC LIMIT 9, 10")) {

			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs != null && rs.next()) {

					savegame1.setAufgabeUndSchwierigkeit10(rs.getString("GameType"));
					savegame1.setDtime10(rs.getTimestamp("GameDate"));
					savegame1.setErgebnisTime(rs.getLong("GamingTime"));
					savegame1.setUserErgebnis_richtig10(rs.getInt("RightUserSolutions"));

				}
			}
		} catch (Exception ex) {
			throw new ServletException(ex.getMessage());
		}

		try (Connection con = ds.getConnection();
				PreparedStatement pstmt = con.prepareStatement("SELECT * FROM game ORDER BY GameId DESC LIMIT 8, 9")) {

			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs != null && rs.next()) {

					savegame1.setAufgabeUndSchwierigkeit9(rs.getString("GameType"));
					savegame1.setDtime9(rs.getTimestamp("GameDate"));
					savegame1.setErgebnisTime(rs.getLong("GamingTime"));
					savegame1.setUserErgebnis_richtig9(rs.getInt("RightUserSolutions"));

				}
			}
		} catch (Exception ex) {
			throw new ServletException(ex.getMessage());
		}

		try (Connection con = ds.getConnection();
				PreparedStatement pstmt = con.prepareStatement("SELECT * FROM game ORDER BY GameId DESC LIMIT 7, 8")) {

			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs != null && rs.next()) {

					savegame1.setAufgabeUndSchwierigkeit8(rs.getString("GameType"));
					savegame1.setDtime8(rs.getTimestamp("GameDate"));
					savegame1.setErgebnisTime(rs.getLong("GamingTime"));
					savegame1.setUserErgebnis_richtig8(rs.getInt("RightUserSolutions"));

				}
			}
		} catch (Exception ex) {
			throw new ServletException(ex.getMessage());
		}

		try (Connection con = ds.getConnection();
				PreparedStatement pstmt = con.prepareStatement("SELECT * FROM game ORDER BY GameId DESC LIMIT 6, 7")) {

			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs != null && rs.next()) {

					savegame1.setAufgabeUndSchwierigkeit7(rs.getString("GameType"));
					savegame1.setDtime7(rs.getTimestamp("GameDate"));
					savegame1.setErgebnisTime(rs.getLong("GamingTime"));
					savegame1.setUserErgebnis_richtig7(rs.getInt("RightUserSolutions"));

				}
			}
		} catch (Exception ex) {
			throw new ServletException(ex.getMessage());
		}

		try (Connection con = ds.getConnection();
				PreparedStatement pstmt = con.prepareStatement("SELECT * FROM game ORDER BY GameId DESC LIMIT 5, 6")) {

			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs != null && rs.next()) {

					savegame1.setAufgabeUndSchwierigkeit6(rs.getString("GameType"));
					savegame1.setDtime6(rs.getTimestamp("GameDate"));
					savegame1.setErgebnisTime(rs.getLong("GamingTime"));
					savegame1.setUserErgebnis_richtig6(rs.getInt("RightUserSolutions"));

				}
			}
		} catch (Exception ex) {
			throw new ServletException(ex.getMessage());
		}

		try (Connection con = ds.getConnection();
				PreparedStatement pstmt = con.prepareStatement("SELECT * FROM game ORDER BY GameId DESC LIMIT 4, 5")) {

			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs != null && rs.next()) {

					savegame1.setAufgabeUndSchwierigkeit5(rs.getString("GameType"));
					savegame1.setDtime5(rs.getTimestamp("GameDate"));
					savegame1.setErgebnisTime(rs.getLong("GamingTime"));
					savegame1.setUserErgebnis_richtig5(rs.getInt("RightUserSolutions"));

				}
			}
		} catch (Exception ex) {
			throw new ServletException(ex.getMessage());
		}

		try (Connection con = ds.getConnection();
				PreparedStatement pstmt = con.prepareStatement("SELECT * FROM game ORDER BY GameId DESC LIMIT 3, 4")) {

			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs != null && rs.next()) {

					savegame1.setAufgabeUndSchwierigkeit4(rs.getString("GameType"));
					savegame1.setDtime4(rs.getTimestamp("GameDate"));
					savegame1.setErgebnisTime(rs.getLong("GamingTime"));
					savegame1.setUserErgebnis_richtig4(rs.getInt("RightUserSolutions"));

				}
			}
		} catch (Exception ex) {
			throw new ServletException(ex.getMessage());
		}

		try (Connection con = ds.getConnection();
				PreparedStatement pstmt = con.prepareStatement("SELECT * FROM game ORDER BY GameId DESC LIMIT 2, 3")) {

			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs != null && rs.next()) {

					savegame1.setAufgabeUndSchwierigkeit3(rs.getString("GameType"));
					savegame1.setDtime3(rs.getTimestamp("GameDate"));
					savegame1.setErgebnisTime(rs.getLong("GamingTime"));
					savegame1.setUserErgebnis_richtig3(rs.getInt("RightUserSolutions"));

				}
			}
		} catch (Exception ex) {
			throw new ServletException(ex.getMessage());
		}

		try (Connection con = ds.getConnection();
				PreparedStatement pstmt = con.prepareStatement("SELECT * FROM game ORDER BY GameId DESC LIMIT 1, 2")) {

			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs != null && rs.next()) {

					savegame1.setAufgabeUndSchwierigkeit2(rs.getString("GameType"));
					savegame1.setDtime2(rs.getTimestamp("GameDate"));
					savegame1.setErgebnisTime(rs.getLong("GamingTime"));
					savegame1.setUserErgebnis_richtig2(rs.getInt("RightUserSolutions"));

				}
			}
		} catch (Exception ex) {
			throw new ServletException(ex.getMessage());
		}

		try (Connection con = ds.getConnection();
				PreparedStatement pstmt = con.prepareStatement("SELECT * FROM game ORDER BY GameId DESC LIMIT 0, 1")) {

			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs != null && rs.next()) {

					savegame1.setAufgabeUndSchwierigkeit(rs.getString("GameType"));
					savegame1.setDtime(rs.getTimestamp("GameDate"));
					savegame1.setErgebnisTime(rs.getLong("GamingTime"));
					savegame1.setUserErgebnis_richtig(rs.getInt("RightUserSolutions"));

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
