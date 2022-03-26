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

@WebServlet("/SaveEditSupportTicketServlet")
public class SaveEditSupportTicketServlet extends HttpServlet {

    @Resource(lookup = "jdbc/MyTHIPool")
    private DataSource dataSource;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        SupportTickets editSupportTicket = (SupportTickets) request.getSession().getAttribute("editSupportTicket");
        SupportTickets saveEditSupportTicket = new SupportTickets();
        saveEditSupportTicket.setTicketId(editSupportTicket.getTicketId());
        saveEditSupportTicket.setSupportComment(editSupportTicket.getSupportComment() + request.getParameter("latestSupportComment"));
        saveEditSupportTicket.setTicketStatus(request.getParameter("newStatus"));

        persist(saveEditSupportTicket);

        request.setAttribute("editSupportTicket", editSupportTicket);
        request.setAttribute("saveEditSupportTicket", saveEditSupportTicket);

        final RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/support_administration.jsp");
        requestDispatcher.forward(request, response);
    }

    private void persist(SupportTickets saveEditSupportTicket) throws ServletException {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("UPDATE contactcase "
             + "SET SupportComment = ?, Status = ? WHERE CaseId = ?;")){
            preparedStatement.setString(1, "\n" + saveEditSupportTicket.getSupportComment());
            preparedStatement.setString(2, saveEditSupportTicket.getTicketStatus());
            preparedStatement.setInt(3, saveEditSupportTicket.getTicketId());
            preparedStatement.executeUpdate();
        } catch (Exception exception) {
                 throw new ServletException(exception.getMessage());
        }
    }

}
