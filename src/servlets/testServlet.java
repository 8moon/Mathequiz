package servlets;

import beans.TestBean;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

@WebServlet(name = "testServlet")
public class testServlet extends HttpServlet {
    Random random = new Random();
    int wert1, wert2;

    public void init() throws ServletException{
        wert1 = random.nextInt(50);
        wert2 = random.nextInt(50);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

//        request.setAttribute("username", request.getParameter("name"));
//        request.getRequestDispatcher("html/forwardServlet.jsp").forward(request, response);



        TestBean tb = new TestBean();
        tb.setBenutzername(request.getParameter("name"));
        tb.setZahl(Integer.valueOf(request.getParameter("nummer")));
        tb.setAufgabe(wert1 + " + " + wert2);
        tb.setErgebnis(wert1 + wert2);

        final HttpSession session = request.getSession();
        session.setAttribute("tb", tb);

        final RequestDispatcher dispatcher = request.getRequestDispatcher("html/examples/forwardServlet.jsp");
        dispatcher.forward(request, response);

    }
}
