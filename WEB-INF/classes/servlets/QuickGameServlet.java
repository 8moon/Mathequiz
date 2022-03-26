//Erstellt von Kahraman Ali und Theinert Thomas

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

import beans.QuickGameExercises;

@WebServlet("/QuickGameServlet")
public class QuickGameServlet extends HttpServlet {

	private Random random = new Random();
	private int wert1, wert2, wert3, wert4, wert5, wert6, wert7, wert8, wert9, wert10, wert11, wert12, wert13, wert14,
			wert15, wert16, wert17, wert18, wert19, wert20;

	public void init() {
		wert1 = random.nextInt(50);
		wert2 = random.nextInt(50);

		wert3 = random.nextInt(50);
		wert4 = random.nextInt(50);

		wert5 = random.nextInt(50);
		wert6 = random.nextInt(50);

		wert7 = random.nextInt(50);
		wert8 = random.nextInt(50);

		wert9 = random.nextInt(50);
		wert10 = random.nextInt(50);

		wert11 = random.nextInt(50);
		wert12 = random.nextInt(50);

		wert13 = random.nextInt(50);
		wert14 = random.nextInt(50);

		wert15 = random.nextInt(50);
		wert16 = random.nextInt(50);

		wert17 = random.nextInt(50);
		wert18 = random.nextInt(50) + 1;

		wert19 = random.nextInt(50);
		wert20 = random.nextInt(50) + 1;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		init();

		QuickGameExercises quickGameExercises1 = new QuickGameExercises();
		quickGameExercises1.setExercise_01(wert1 + " + " + wert2);
		quickGameExercises1.setSolution_01(wert1 + wert2);
		quickGameExercises1.setExercise_02(wert3 + " + " + wert4);
		quickGameExercises1.setSolution_02(wert3 + wert4);
		quickGameExercises1.setExercise_03(wert5 + " + " + wert6);
		quickGameExercises1.setSolution_03(wert5 + wert6);

		quickGameExercises1.setExercise_04(wert7 + " - " + wert8);
		quickGameExercises1.setSolution_04(wert7 - wert8);
		quickGameExercises1.setExercise_05(wert9 + " - " + wert10);
		quickGameExercises1.setSolution_05(wert9 - wert10);
		quickGameExercises1.setExercise_06(wert11 + " - " + wert12);
		quickGameExercises1.setSolution_06(wert11 - wert12);

		quickGameExercises1.setExercise_07(wert13 + " * " + wert14);
		quickGameExercises1.setSolution_07(wert13 * wert14);
		quickGameExercises1.setExercise_08(wert15 + " * " + wert16);
		quickGameExercises1.setSolution_08(wert15 * wert16);

		quickGameExercises1.setExercise_09(wert17 + " / " + wert18);
		quickGameExercises1.setSolution_09(wert17 / wert18);
		quickGameExercises1.setExercise_10(wert19 + " / " + wert20);
		quickGameExercises1.setSolution_10(wert19 / wert20);

		quickGameExercises1.setDatetime(new Date());

		HttpSession session = request.getSession();
		session.setAttribute("quickGameExercises1", quickGameExercises1);

		final RequestDispatcher dispatcher = request.getRequestDispatcher("html/gaming_pages/quick_game_output.jsp");
		dispatcher.forward(request, response);
	}

}
