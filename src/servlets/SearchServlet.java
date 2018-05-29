package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.sql.DataSource;
import beans.SucheBean;

@WebServlet(name = "SearchServlet")
public class SearchServlet extends HttpServlet {

    @Resource(lookup="jdbc/MyMathemathikquizPool")
    private DataSource ds;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Servlet zur Entgegennahme von Formularinhalten, Lesen der Daten in einer DB und Generierung
        // eines Beans zur Weitergabe der Formulardaten an eine JSP

        request.setCharacterEncoding("UTF-8");	// In diesem Format erwartet das Servlet jetzt die Formulardaten
        String username = request.getParameter("username");

        // DB-Zugriff
        List<SucheBean> user = search(username);

        // Scope "Request"
        request.setAttribute("user", user);

        // Weiterleiten an JSP
        final RequestDispatcher dispatcher = request.getRequestDispatcher("html/user_pages/searchResults.jsp");
        dispatcher.forward(request, response);
    }

    private List<SucheBean> search(String username) throws ServletException {
        username = (username == null || username == "") ? "%" : "%" + username + "%";
        List<SucheBean> item = new ArrayList<SucheBean>();
        // Liste wo da var ist  und die liste die es enthält(item)
        // DB-Zugriff
        try (Connection con = ds.getConnection();
             PreparedStatement pstmt = con.prepareStatement("SELECT * FROM mathemathikquizdb.user WHERE username LIKE ?")) {
            pstmt.setString(1, username);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    SucheBean gesuchter = new SucheBean();

                    String firstname = rs.getString("FirstName");
                    gesuchter.setFirstname(firstname);

                    String lastname = rs.getString("LastName");
                    gesuchter.setLastname(lastname);

                    String email = rs.getString("Email");
                    gesuchter.setEmail(email);

                    item.add(gesuchter);
                } // while rs.next()
            }
        } catch (Exception ex) {
            throw new ServletException(ex.getMessage());
        }
        return item;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
