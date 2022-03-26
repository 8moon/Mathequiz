//Erstellt von Thomas Theinert

package servlets;

import beans.ContactContent;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

@WebServlet("/ContactContentServlet")
public class ContactContentServlet extends HttpServlet {

    @Resource(lookup = "jdbc/MyTHIPool")
    private DataSource dataSource;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        ContactContent contactContent = new ContactContent();
        contactContent.setContactEmail(request.getParameter("contactEmail"));
        contactContent.setContactFirstName(request.getParameter("contactFirstName"));
        contactContent.setContactLastName(request.getParameter("contactLastName"));
        contactContent.setContactMessage(request.getParameter("contactMessage"));

        persist(contactContent);

        request.setAttribute("contactContent", contactContent);

        final RequestDispatcher requestDispatcher = request.getRequestDispatcher("html/maintenance/contact_confirmation.jsp");
        requestDispatcher.forward(request, response);
    }

    private void persist(ContactContent contactContent) throws ServletException {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO contactcase (ContactMail, ContactFirstName, ContactLastName, ContactMessage, SupportComment) VALUES (?,?,?,?,?);")){
            preparedStatement.setString(1, contactContent.getContactEmail());
            preparedStatement.setString(2, contactContent.getContactFirstName());
            preparedStatement.setString(3, contactContent.getContactLastName());
            preparedStatement.setString(4, contactContent.getContactMessage());
            preparedStatement.setString(5, "");
            preparedStatement.executeUpdate();
        } catch (Exception exception) {
                 throw new ServletException(exception.getMessage());
        }
    }

}
