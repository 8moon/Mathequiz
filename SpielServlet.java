package servlets;

import java.io.IOException;
import java.util.Date;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.saveGame;

/**
 * Servlet implementation class SpielServlet
 */
@WebServlet("/SpielServlet")
public class SpielServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Random random = new Random();
	private int wert1, wert2, wert3, wert4, wert5, wert6, wert7, wert8, wert9, wert10, wert11, wert12, wert13, wert14,
			wert15, wert16, wert17, wert18, wert19, wert20, wert21, wert22, wert23, wert24;

	public void init() throws ServletException {
		wert1 = random.nextInt(10);
		wert2 = random.nextInt(10);

		wert3 = random.nextInt(10);
		wert4 = random.nextInt(10);

		wert5 = random.nextInt(10);
		wert6 = random.nextInt(10);
		wert7 = random.nextInt(10);
		wert8 = random.nextInt(10);

		wert9 = random.nextInt(50);
		wert10 = random.nextInt(50);

		wert11 = random.nextInt(50);
		wert12 = random.nextInt(50);
		wert13 = random.nextInt(50);
		wert14 = random.nextInt(50);

		wert15 = random.nextInt(50);
		wert16 = random.nextInt(50);

		wert17 = random.nextInt(100);
		wert18 = random.nextInt(100);
		wert19 = random.nextInt(100);
		wert20 = random.nextInt(100);

		wert21 = random.nextInt(100);
		wert22 = random.nextInt(100);
		wert23 = random.nextInt(100);
		wert24 = random.nextInt(100);

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String game = request.getParameter("Spiel");
		init();
		if (game.equals("Addition/Subtraktion/Leicht")) {

			saveGame savegame1 = new saveGame();
			savegame1.setAufgabe_01(wert1 + " + " + wert2);
			savegame1.setLoesung_01(wert1 + wert2);
			savegame1.setAufgabe_02(wert3 + " - " + wert4);
			savegame1.setLoesung_02(wert3 - wert4);
			savegame1.setAufgabe_03(wert5 + " + " + wert6);
			savegame1.setLoesung_03(wert5 + wert6);
			savegame1.setAufgabe_04(wert7 + " - " + wert8);
			savegame1.setLoesung_04(wert7 - wert8);
			savegame1.setAufgabe_05(wert8 + " + " + wert5);
			savegame1.setLoesung_05(wert8 + wert5);
			savegame1.setAufgabe_06(wert6 + " - " + wert2);
			savegame1.setLoesung_06(wert6 - wert2);
			savegame1.setAufgabe_07(wert7 + " + " + wert3);
			savegame1.setLoesung_07(wert7 + wert3);
			savegame1.setAufgabe_08(wert1 + " - " + wert4);
			savegame1.setLoesung_08(wert1 - wert4);
			savegame1.setAufgabe_09(wert2 + " + " + wert7);
			savegame1.setLoesung_09(wert2 + wert7);
			savegame1.setAufgabe_10(wert5 + " - " + wert2);
			savegame1.setLoesung_10(wert5 - wert2);
			savegame1.setAufgabeUndSchwierigkeit(game);

			savegame1.setDtime(new Date());

			final HttpSession session = request.getSession();
			session.setAttribute("savegame1", savegame1);

		} else if (game.equals("Addition/Subtraktion/Mittel")) {

			saveGame savegame1 = new saveGame();
			savegame1.setAufgabe_01(wert9 + " + " + wert10);
			savegame1.setLoesung_01(wert9 + wert10);
			savegame1.setAufgabe_02(wert11 + " - " + wert12);
			savegame1.setLoesung_02(wert11 - wert12);
			savegame1.setAufgabe_03(wert13 + " + " + wert14);
			savegame1.setLoesung_03(wert13 + wert14);
			savegame1.setAufgabe_04(wert15 + " - " + wert16);
			savegame1.setLoesung_04(wert15 - wert16);
			savegame1.setAufgabe_05(wert9 + " + " + wert13);
			savegame1.setLoesung_05(wert9 + wert13);
			savegame1.setAufgabe_06(wert12 + " -" + wert10);
			savegame1.setLoesung_06(wert12 - wert10);
			savegame1.setAufgabe_07(wert16 + " + " + wert14);
			savegame1.setLoesung_07(wert16 + wert14);
			savegame1.setAufgabe_08(wert10 + " - " + wert11);
			savegame1.setLoesung_08(wert10 - wert11);
			savegame1.setAufgabe_09(wert14 + " + " + wert15);
			savegame1.setLoesung_09(wert14 + wert15);
			savegame1.setAufgabe_10(wert15 + " - " + wert9);
			savegame1.setLoesung_10(wert15 - wert9);

			savegame1.setAufgabeUndSchwierigkeit(game);
			savegame1.setDtime(new Date());
			final HttpSession session = request.getSession();
			session.setAttribute("savegame1", savegame1);

		} else if (game.equals("Addition/Subtraktion/Schwer")) {

			saveGame savegame1 = new saveGame();
			savegame1.setAufgabe_01(wert17 + " + " + wert18);
			savegame1.setLoesung_01(wert17 + wert18);
			savegame1.setAufgabe_02(wert19 + " - " + wert20);
			savegame1.setLoesung_02(wert19 - wert20);
			savegame1.setAufgabe_03(wert21 + " + " + wert22);
			savegame1.setLoesung_03(wert21 + wert22);
			savegame1.setAufgabe_04(wert23 + " - " + wert24);
			savegame1.setLoesung_04(wert23 - wert24);
			savegame1.setAufgabe_05(wert24 + " + " + wert17);
			savegame1.setLoesung_05(wert24 + wert17);
			savegame1.setAufgabe_06(wert23 + " - " + wert18);
			savegame1.setLoesung_06(wert23 - wert18);
			savegame1.setAufgabe_07(wert22 + " + " + wert19);
			savegame1.setLoesung_07(wert22 + wert19);
			savegame1.setAufgabe_08(wert21 + " - " + wert20);
			savegame1.setLoesung_08(wert21 - wert20);
			savegame1.setAufgabe_09(wert20 + " + " + wert16);
			savegame1.setLoesung_09(wert20 + wert16);
			savegame1.setAufgabe_10(wert18 + " - " + wert23);
			savegame1.setLoesung_10(wert18 - wert23);

			savegame1.setAufgabeUndSchwierigkeit(game);
			savegame1.setDtime(new Date());
			final HttpSession session = request.getSession();
			session.setAttribute("savegame1", savegame1);

		} else if (game.equals("Multiplikation/Division/Leicht")) {

			saveGame savegame1 = new saveGame();
			savegame1.setAufgabe_01(wert1 + " * " + wert2);
			savegame1.setLoesung_01(wert1 * wert2);
			savegame1.setAufgabe_02(wert3 + " / " + wert4);
			savegame1.setLoesung_02(wert3 / wert4);
			savegame1.setAufgabe_03(wert5 + " * " + wert6);
			savegame1.setLoesung_03(wert5 * wert6);
			savegame1.setAufgabe_04(wert7 + " / " + wert8);
			savegame1.setLoesung_04(wert7 / wert8);
			savegame1.setAufgabe_05(wert8 + " * " + wert5);
			savegame1.setLoesung_05(wert8 * wert5);
			savegame1.setAufgabe_06(wert6 + " / " + wert2);
			savegame1.setLoesung_06(wert6 / wert2);
			savegame1.setAufgabe_07(wert7 + " * " + wert3);
			savegame1.setLoesung_07(wert7 * wert3);
			savegame1.setAufgabe_08(wert1 + " / " + wert4);
			savegame1.setLoesung_08(wert1 / wert4);
			savegame1.setAufgabe_09(wert2 + " * " + wert7);
			savegame1.setLoesung_09(wert2 * wert7);
			savegame1.setAufgabe_10(wert5 + " / " + wert2);
			savegame1.setLoesung_10(wert5 / wert2);

			savegame1.setAufgabeUndSchwierigkeit(game);
			savegame1.setDtime(new Date());
			final HttpSession session = request.getSession();
			session.setAttribute("savegame1", savegame1);

		} else if (game.equals("Multiplikation/Division/Mittel")) {

			saveGame savegame1 = new saveGame();
			savegame1.setAufgabe_01(wert9 + " * " + wert10);
			savegame1.setLoesung_01(wert9 * wert10);
			savegame1.setAufgabe_02(wert11 + " / " + wert12);
			savegame1.setLoesung_02(wert11 / wert12);
			savegame1.setAufgabe_03(wert13 + " * " + wert14);
			savegame1.setLoesung_03(wert13 * wert14);
			savegame1.setAufgabe_04(wert15 + " / " + wert16);
			savegame1.setLoesung_04(wert15 / wert16);
			savegame1.setAufgabe_05(wert9 + " * " + wert13);
			savegame1.setLoesung_05(wert9 * wert13);
			savegame1.setAufgabe_06(wert12 + " /" + wert10);
			savegame1.setLoesung_06(wert12 / wert10);
			savegame1.setAufgabe_07(wert16 + " * " + wert14);
			savegame1.setLoesung_07(wert16 * wert14);
			savegame1.setAufgabe_08(wert10 + " / " + wert11);
			savegame1.setLoesung_08(wert10 / wert11);
			savegame1.setAufgabe_09(wert14 + " * " + wert15);
			savegame1.setLoesung_09(wert14 * wert15);
			savegame1.setAufgabe_10(wert15 + " / " + wert9);
			savegame1.setLoesung_10(wert15 / wert9);

			savegame1.setAufgabeUndSchwierigkeit(game);
			savegame1.setDtime(new Date());
			final HttpSession session = request.getSession();
			session.setAttribute("savegame1", savegame1);

		} else if (game.equals("Multiplikation/Division/Schwer")) {

			saveGame savegame1 = new saveGame();

			savegame1.setAufgabe_01(wert17 + " * " + wert18);
			savegame1.setLoesung_01(wert17 * wert18);
			savegame1.setAufgabe_02(wert19 + " / " + wert20);
			savegame1.setLoesung_02(wert19 / wert20);
			savegame1.setAufgabe_03(wert21 + " * " + wert22);
			savegame1.setLoesung_03(wert21 * wert22);
			savegame1.setAufgabe_04(wert23 + " / " + wert24);
			savegame1.setLoesung_04(wert23 / wert24);
			savegame1.setAufgabe_05(wert24 + " * " + wert17);
			savegame1.setLoesung_05(wert24 * wert17);
			savegame1.setAufgabe_06(wert23 + " / " + wert18);
			savegame1.setLoesung_06(wert23 / wert18);
			savegame1.setAufgabe_07(wert22 + " * " + wert19);
			savegame1.setLoesung_07(wert22 * wert19);
			savegame1.setAufgabe_08(wert21 + " / " + wert20);
			savegame1.setLoesung_08(wert21 / wert20);
			savegame1.setAufgabe_09(wert20 + " * " + wert16);
			savegame1.setLoesung_09(wert20 * wert16);
			savegame1.setAufgabe_10(wert18 + " / " + wert23);
			savegame1.setLoesung_10(wert18 / wert23);

			savegame1.setAufgabeUndSchwierigkeit(game);
			savegame1.setDtime(new Date());
			final HttpSession session = request.getSession();
			session.setAttribute("savegame1", savegame1);

		} else if (game.equals("Addition/Subtraktion/Multiplikation/Division/Leicht")) {

			saveGame savegame1 = new saveGame();
			savegame1.setAufgabe_01(wert1 + " + " + wert2);
			savegame1.setLoesung_01(wert1 + wert2);
			savegame1.setAufgabe_02(wert3 + " - " + wert4);
			savegame1.setLoesung_02(wert3 - wert4);
			savegame1.setAufgabe_03(wert5 + " * " + wert6);
			savegame1.setLoesung_03(wert5 * wert6);
			savegame1.setAufgabe_04(wert7 + " / " + wert8);
			savegame1.setLoesung_04(wert7 / wert8);
			savegame1.setAufgabe_05(wert8 + " + " + wert5);
			savegame1.setLoesung_05(wert8 + wert5);
			savegame1.setAufgabe_06(wert6 + " - " + wert2);
			savegame1.setLoesung_06(wert6 - wert2);
			savegame1.setAufgabe_07(wert7 + " * " + wert3);
			savegame1.setLoesung_07(wert7 * wert3);
			savegame1.setAufgabe_08(wert1 + " / " + wert4);
			savegame1.setLoesung_08(wert1 / wert4);
			savegame1.setAufgabe_09(wert2 + " * " + wert7);
			savegame1.setLoesung_09(wert2 * wert7);
			savegame1.setAufgabe_10(wert5 + " / " + wert2);
			savegame1.setLoesung_10(wert5 / wert2);

			savegame1.setAufgabeUndSchwierigkeit(game);
			savegame1.setDtime(new Date());
			final HttpSession session = request.getSession();
			session.setAttribute("savegame1", savegame1);

		} else if (game.equals("Addition/Subtraktion/Multiplikation/Division/Mittel")) {

			saveGame savegame1 = new saveGame();
			savegame1.setAufgabe_01(wert9 + " + " + wert10);
			savegame1.setLoesung_01(wert9 + wert10);
			savegame1.setAufgabe_02(wert11 + " - " + wert12);
			savegame1.setLoesung_02(wert11 - wert12);
			savegame1.setAufgabe_03(wert13 + " * " + wert14);
			savegame1.setLoesung_03(wert13 * wert14);
			savegame1.setAufgabe_04(wert15 + " / " + wert16);
			savegame1.setLoesung_04(wert15 / wert16);
			savegame1.setAufgabe_05(wert9 + " + " + wert13);
			savegame1.setLoesung_05(wert9 + wert13);
			savegame1.setAufgabe_06(wert12 + " -" + wert10);
			savegame1.setLoesung_06(wert12 - wert10);
			savegame1.setAufgabe_07(wert16 + " * " + wert14);
			savegame1.setLoesung_07(wert16 * wert14);
			savegame1.setAufgabe_08(wert10 + " / " + wert11);
			savegame1.setLoesung_08(wert10 / wert11);
			savegame1.setAufgabe_09(wert14 + " * " + wert15);
			savegame1.setLoesung_09(wert14 * wert15);
			savegame1.setAufgabe_10(wert15 + " / " + wert9);
			savegame1.setLoesung_10(wert15 / wert9);

			savegame1.setAufgabeUndSchwierigkeit(game);
			savegame1.setDtime(new Date());
			final HttpSession session = request.getSession();
			session.setAttribute("savegame1", savegame1);

		} else {

			saveGame savegame1 = new saveGame();

			savegame1.setAufgabe_01(wert17 + " + " + wert18);
			savegame1.setLoesung_01(wert17 + wert18);
			savegame1.setAufgabe_02(wert19 + " - " + wert20);
			savegame1.setLoesung_02(wert19 - wert20);
			savegame1.setAufgabe_03(wert21 + " * " + wert22);
			savegame1.setLoesung_03(wert21 * wert22);
			savegame1.setAufgabe_04(wert23 + " / " + wert24);
			savegame1.setLoesung_04(wert23 / wert24);
			savegame1.setAufgabe_05(wert24 + " + " + wert17);
			savegame1.setLoesung_05(wert24 + wert17);
			savegame1.setAufgabe_06(wert23 + " - " + wert18);
			savegame1.setLoesung_06(wert23 - wert18);
			savegame1.setAufgabe_07(wert22 + " * " + wert19);
			savegame1.setLoesung_07(wert22 * wert19);
			savegame1.setAufgabe_08(wert21 + " / " + wert20);
			savegame1.setLoesung_08(wert21 / wert20);
			savegame1.setAufgabe_09(wert20 + " * " + wert16);
			savegame1.setLoesung_09(wert20 * wert16);
			savegame1.setAufgabe_10(wert18 + " / " + wert23);
			savegame1.setLoesung_10(wert18 / wert23);
			savegame1.setDtime(new Date());
			savegame1.setAufgabeUndSchwierigkeit(game);

			final HttpSession session = request.getSession();
			session.setAttribute("savegame1", savegame1);

		}

		final RequestDispatcher dispatcher = request.getRequestDispatcher("home/html/spieleseiteAusgabe.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);

	}

}
