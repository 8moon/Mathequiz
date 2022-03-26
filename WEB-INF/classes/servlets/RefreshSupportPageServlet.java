//Erstellt von Thomas Theinert

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
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/RefreshSupportPageServlet")
public class RefreshSupportPageServlet extends HttpServlet {

    @Resource(lookup = "jdbc/MyTHIPool")
    private DataSource dataSource;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        List<SupportTickets> openSupportTicketsList = readOpenSupportTickets();
        List<SupportTickets> closedSupportTicketsList = readClosedSupportTickets();

        request.setAttribute("openSupportTicketsList", openSupportTicketsList);
        request.setAttribute("closedSupportTicketsList", closedSupportTicketsList);

        final RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/support_administration.jsp");
        requestDispatcher.forward(request, response);
    }

    private List<SupportTickets> readOpenSupportTickets() throws ServletException {
        List<SupportTickets> openSupportTicketsList = new ArrayList<SupportTickets>();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT CaseId, ContactMail, ContactFirstName, ContactLastName, ContactMessage, SupportComment FROM contactcase WHERE Status='open';")){
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

                    String supportComment = resultSet.getString("SupportComment");
                    supportTicket.setSupportComment(supportComment);

                    openSupportTicketsList.add(supportTicket);
                }
            }
        } catch (Exception exception) {
                 throw new ServletException(exception.getMessage());
        }
        return openSupportTicketsList;
    }

    private List<SupportTickets> readClosedSupportTickets() throws ServletException {
        List<SupportTickets> closedSupportTicketsList = new ArrayList<SupportTickets>();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT CaseId, ContactMail, ContactFirstName, ContactLastName, ContactMessage, SupportComment FROM contactcase WHERE Status='closed';")){
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

                    String supportComment = resultSet.getString("SupportComment");
                    supportTicket.setSupportComment(supportComment);

                    closedSupportTicketsList.add(supportTicket);
                }
            }
        } catch (Exception exception) {
            throw new ServletException(exception.getMessage());
        }
        return closedSupportTicketsList;
    }

}
