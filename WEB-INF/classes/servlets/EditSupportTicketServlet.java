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
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet("/EditSupportTicketServlet")
public class EditSupportTicketServlet extends HttpServlet {

    @Resource(lookup = "jdbc/MyTHIPool")
    private DataSource dataSource;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        int editTicketId = Integer.valueOf(request.getParameter("editTicket"));

        SupportTickets editSupportTicket = read(editTicketId);

        request.setAttribute("editSupportTicket", editSupportTicket);
        HttpSession session = request.getSession();
        session.setAttribute("editSupportTicket", editSupportTicket);

        final RequestDispatcher requestDispatcher = request.getRequestDispatcher("html/maintenance/process_support_ticket.jsp");
        requestDispatcher.forward(request, response);
    }

    private SupportTickets read(int editTicketId) throws ServletException {
        SupportTickets editSupportTicket = new SupportTickets();
        editSupportTicket.setTicketId(editTicketId);
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM contactcase WHERE CaseId = ?;")){
            preparedStatement.setInt(1, editTicketId);
            try (ResultSet resultSet = preparedStatement.executeQuery()){
                if (resultSet != null && resultSet.next()) {
                    editSupportTicket.setTicketId(Integer.valueOf(resultSet.getInt("CaseId")));
                    editSupportTicket.setTicketMail(resultSet.getString("ContactMail"));
                    editSupportTicket.setTicketFirstName(resultSet.getString("ContactFirstName"));
                    editSupportTicket.setTicketLastName(resultSet.getString("ContactLastName"));
                    editSupportTicket.setTicketMessage(resultSet.getString("ContactMessage"));
                    editSupportTicket.setSupportComment(resultSet.getString("SupportComment"));
                    editSupportTicket.setTicketStatus(resultSet.getString("Status"));
                }
            }
        } catch (Exception exception) {
                 throw new ServletException(exception.getMessage());
        }
        return editSupportTicket;
    }

}
