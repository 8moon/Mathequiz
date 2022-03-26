//Erstellt von Thomas Theinert

package servlets;

import beans.ForumTopic;
import beans.User;

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

@WebServlet("/CreateNewForumTopicServlet")
public class CreateNewForumTopicServlet extends HttpServlet {

    @Resource(lookup = "jdbc/MyTHIPool")
    private DataSource dataSource;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        User currentUser = (User) request.getSession().getAttribute("user");

        ForumTopic createForumTopic = new ForumTopic();
        createForumTopic.setTopicText(request.getParameter("newTopicText"));
        createForumTopic.setUserId(currentUser.getUserId());
        createForumTopic.setUserName(currentUser.getUsername());

        persist(createForumTopic);

        request.setAttribute("createForumTopic", createForumTopic);

        final RequestDispatcher requestDispatcher = request.getRequestDispatcher("html/forum_pages/forum_topics.jsp");
        requestDispatcher.forward(request, response);
    }

    private void persist(ForumTopic createForumTopic) throws ServletException {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO forumtopics (UserId, UserName, TopicText) VALUES (?,?,?);")){
            preparedStatement.setInt(1, createForumTopic.getUserId());
            preparedStatement.setString(2, createForumTopic.getUserName());
            preparedStatement.setString(3, createForumTopic.getTopicText());
            preparedStatement.executeUpdate();
        } catch (Exception exception) {
                 throw new ServletException(exception.getMessage());
        }
    }

}
