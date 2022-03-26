//Erstellt von Kahraman Ali und Theinert Thomas

package servlets;

import beans.QuickGameExercises;
import beans.QuickGameUserSolutions;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;

@WebServlet("/QuickGameCheckSolutionsServlet")
public class QuickGameCheckSolutionsServlet extends HttpServlet {
    private int rightUserSolutions = 0;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        QuickGameUserSolutions quickGameUserSolutions1 = new QuickGameUserSolutions();
        quickGameUserSolutions1.setUserSolution_01(Integer.valueOf(request.getParameter("userSolution1")));
        quickGameUserSolutions1.setUserSolution_02(Integer.valueOf(request.getParameter("userSolution2")));
        quickGameUserSolutions1.setUserSolution_03(Integer.valueOf(request.getParameter("userSolution3")));
        quickGameUserSolutions1.setUserSolution_04(Integer.valueOf(request.getParameter("userSolution4")));
        quickGameUserSolutions1.setUserSolution_05(Integer.valueOf(request.getParameter("userSolution5")));
        quickGameUserSolutions1.setUserSolution_06(Integer.valueOf(request.getParameter("userSolution6")));
        quickGameUserSolutions1.setUserSolution_07(Integer.valueOf(request.getParameter("userSolution7")));
        quickGameUserSolutions1.setUserSolution_08(Integer.valueOf(request.getParameter("userSolution8")));
        quickGameUserSolutions1.setUserSolution_09(Integer.valueOf(request.getParameter("userSolution9")));
        quickGameUserSolutions1.setUserSolution_10(Integer.valueOf(request.getParameter("userSolution10")));

        QuickGameExercises quickGameExercises1 = (QuickGameExercises) request.getSession().getAttribute("quickGameExercises1");

        rightUserSolutions = 0;
        if (quickGameUserSolutions1.getUserSolution_01() == quickGameExercises1.getSolution_01()) {
            rightUserSolutions ++;
        }
        if (quickGameUserSolutions1.getUserSolution_02() == quickGameExercises1.getSolution_02()) {
            rightUserSolutions ++;
        }
        if (quickGameUserSolutions1.getUserSolution_03() == quickGameExercises1.getSolution_03()) {
            rightUserSolutions ++;
        }
        if (quickGameUserSolutions1.getUserSolution_04() == quickGameExercises1.getSolution_04()) {
            rightUserSolutions ++;
        }
        if (quickGameUserSolutions1.getUserSolution_05() == quickGameExercises1.getSolution_05()) {
            rightUserSolutions ++;
        }
        if (quickGameUserSolutions1.getUserSolution_06() == quickGameExercises1.getSolution_06()) {
            rightUserSolutions ++;
        }
        if (quickGameUserSolutions1.getUserSolution_07() == quickGameExercises1.getSolution_07()) {
            rightUserSolutions ++;
        }
        if (quickGameUserSolutions1.getUserSolution_08() == quickGameExercises1.getSolution_08()) {
            rightUserSolutions ++;
        }
        if (quickGameUserSolutions1.getUserSolution_09() == quickGameExercises1.getSolution_09()) {
            rightUserSolutions ++;
        }
        if (quickGameUserSolutions1.getUserSolution_10() == quickGameExercises1.getSolution_10()) {
            rightUserSolutions ++;
        }

        quickGameUserSolutions1.setRightUserSolutions(rightUserSolutions);

        long diffInMillies = new Date().getTime() - quickGameExercises1.getDatetime().getTime();
        quickGameUserSolutions1.setSolutionTime(diffInMillies);

        HttpSession session = request.getSession();

        session.setAttribute("quickGameExercises1", quickGameExercises1);
        session.setAttribute("quickGameUserSolutions1", quickGameUserSolutions1);

        final RequestDispatcher dispatcher = request.getRequestDispatcher("html/gaming_pages/quick_game_result.jsp");
        dispatcher.forward(request, response);
    }

}
