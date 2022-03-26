//Erstellt von Thomas Theinert

package servlets;

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

@WebServlet("/DeleteForumContentServlet")
public class DeleteForumContentServlet extends HttpServlet {

    @Resource(lookup = "jdbc/MyTHIPool")
    private DataSource dataSource;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        int deleteContentId = Integer.valueOf(request.getParameter("deleteContentId"));

        delete(deleteContentId);

        request.setAttribute("deleteContentId", deleteContentId);

        final RequestDispatcher requestDispatcher = request.getRequestDispatcher("html/forum_pages/forum_content.jsp");
        requestDispatcher.forward(request, response);
    }

    private void delete(int deleteContentId) throws ServletException {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM forumcontent WHERE ContentId = ?;")){
            preparedStatement.setInt(1, deleteContentId);
            preparedStatement.executeUpdate();
        } catch (Exception exception) {
                 throw new ServletException(exception.getMessage());
        }
    }

}
