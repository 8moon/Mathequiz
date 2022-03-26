//Erstellt von Thomas Theinert

package servlets;

import beans.ForumContent;

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

@WebServlet("/ContributeContentTextServlet")
public class ContributeContentTextServlet extends HttpServlet {

    @Resource(lookup = "jdbc/MyTHIPool")
    private DataSource dataSource;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        ForumContent newForumContent = new ForumContent();
        newForumContent.setTopicId(Integer.valueOf(request.getParameter("contributionTopicId")));
        newForumContent.setUserId(Integer.valueOf(request.getParameter("contributionUserId")));
        newForumContent.setUserName(request.getParameter("contributionUserName"));
        newForumContent.setContentText(request.getParameter("contributionMessage"));

        persist(newForumContent);

        request.setAttribute("newForumContent", newForumContent);

        final RequestDispatcher requestDispatcher = request.getRequestDispatcher("html/forum_pages/forum_content.jsp");
        requestDispatcher.forward(request, response);
    }

    private void persist(ForumContent newForumContent) throws ServletException {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO forumcontent (TopicId, UserId, UserName, ContentText) VALUES (?,?,?,?);")){
            preparedStatement.setInt(1, newForumContent.getTopicId());
            preparedStatement.setInt(2, newForumContent.getUserId());
            preparedStatement.setString(3, newForumContent.getUserName());
            preparedStatement.setString(4, newForumContent.getContentText());
            preparedStatement.executeUpdate();
        } catch (Exception exception) {
                 throw new ServletException(exception.getMessage());
        }
    }

}
