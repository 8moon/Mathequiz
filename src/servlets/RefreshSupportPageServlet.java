package servlets;

import beans.SupportTickets;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import javax.xml.crypto.Data;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "RefreshSupportPageServlet")
public class RefreshSupportPageServlet extends HttpServlet {

    @Resource(lookup = "jdbc/MyMathemathikquizPool")
    private DataSource dataSource;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        List<SupportTickets> supportTicketsList = read();

        request.setAttribute("supportTicketsList", supportTicketsList);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("html/maintenance/supportPage.jsp");
        requestDispatcher.forward(request, response);
    }

    private List<SupportTickets> read() throws ServletException {
        List<SupportTickets> supportTicketsList = new ArrayList<SupportTickets>();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT CaseId, ContactMail, ContactFirstName, ContactLastName, ContactMessage FROM contactcase;")){
            try (ResultSet resultSet = preparedStatement.executeQuery()){
                while (resultSet.next()) {
                    SupportTickets supportTicket = new SupportTickets();

                    int caseId = resultSet.getInt("CaseId");
                    supportTicket.setTicketId(caseId);

                    String contactMail = resultSet.getString("ContactMail");
                    supportTicket.setTicketMail(contactMail);

                    String contactFirstName = resultSet.getString("ContactFirstName");
                    supportTicket.setTicketFirstName(contactFirstName);

                    String contactLastName = resultSet.getString("ContactLastName");
                    supportTicket.setTicketLastName(contactLastName);

                    String contactMessage = resultSet.getString("ContactMessage");
                    supportTicket.setTicketMessage(contactMessage);

                    supportTicketsList.add(supportTicket);
                }
            }
        } catch (Exception exception) {
                 throw new ServletException(exception.getMessage());
        }
        return supportTicketsList;
    }
}
