//Erstellt von Thomas Theinert

package servlets;

import beans.ForumTopic;

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
import java.util.ArrayList;
import java.util.List;

@WebServlet("/RefreshForumTopicsPageServlet")
public class RefreshForumTopicsPageServlet extends HttpServlet {

    @Resource(lookup = "jdbc/MyTHIPool")
    private DataSource dataSource;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        List<ForumTopic> forumTopicList = read();

        request.setAttribute("forumTopicList", forumTopicList);

        HttpSession session = request.getSession();
        session.setAttribute("forumTopicList", forumTopicList);

        final RequestDispatcher requestDispatcher = request.getRequestDispatcher("html/forum_pages/forum_topics.jsp");
        requestDispatcher.forward(request, response);
    }

    private List<ForumTopic> read() throws ServletException {
        List<ForumTopic> forumTopicList = new ArrayList<ForumTopic>();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM forumtopics;")){
            try (ResultSet resultSet = preparedStatement.executeQuery()){
                while (resultSet.next()) {
                    ForumTopic forumTopic = new ForumTopic();

                    int topicId = resultSet.getInt("TopicId");
                    forumTopic.setTopicId(topicId);

                    int userId = resultSet.getInt("UserId");
                    forumTopic.setUserId(userId);

                    String userName = resultSet.getString("UserName");
                    forumTopic.setUserName(userName);

                    String topicText = resultSet.getString("TopicText");
                    forumTopic.setTopicText(topicText);

                    forumTopicList.add(forumTopic);
                }
            }
        } catch (Exception exception) {
                 throw new ServletException(exception.getMessage());
        }
        return forumTopicList;
    }

}
