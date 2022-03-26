//Erstellt von Kahraman Ali

package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

@WebServlet("/LetztenZehnSpieleServlet")
public class LetztenZehnSpieleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource(lookup = "jdbc/MyTHIPool")
	private DataSource ds;

	public LetztenZehnSpieleServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		saveGame savegame1 = new saveGame();
		User currentUser = (User) request.getSession().getAttribute("user");
		savegame1.setUserid(currentUser.getUserId());

		// DB-Zugriff
		List<saveGame> savegame2 = read(savegame1);

		// Scope "Request"
		request.setAttribute("savegame2", savegame2);
		// Weiterleiten an JSP

		if (savegame2.isEmpty()) {
			final RequestDispatcher dispatcher = request
					.getRequestDispatcher("html/previous_games/no_games_played.jsp");
			dispatcher.forward(request, response);

		} else {
			final RequestDispatcher dispatcher = request.getRequestDispatcher("html/previous_games/last_ten_games.jsp");
			dispatcher.forward(request, response);
		}

	}

	private List<saveGame> read(saveGame savegame1) throws ServletException {

		List<saveGame> savegame2 = new ArrayList<>();

		// DB-Zugriff
		try (Connection con = ds.getConnection();
			 PreparedStatement pstmt = con
					 .prepareStatement("SELECT * FROM game WHERE UserId =? ORDER BY GameId DESC LIMIT 10")) {
			pstmt.setInt(1, savegame1.getUserid());

			try (ResultSet rs = pstmt.executeQuery()) {
				while (rs.next()) {
					saveGame savegame3 = new saveGame();

					String gameType = rs.getString("GameType");
					savegame3.setAufgabeUndSchwierigkeit(gameType);

					Date gamedate = rs.getTimestamp("GameDate");
					savegame3.setDtime(gamedate);

					long gamingTime = rs.getLong("GamingTime");
					savegame3.setErgebnisTime(gamingTime);

					int rightUserSolutions = rs.getInt("RightUserSolutions");
					savegame3.setUserErgebnis_richtig(rightUserSolutions);

					int gameId = rs.getInt("GameId");
					savegame3.setGameid(gameId);

					savegame2.add(savegame3);

				}
			}
		} catch (Exception ex) {
			throw new ServletException(ex.getMessage());

		}

		return savegame2;

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}