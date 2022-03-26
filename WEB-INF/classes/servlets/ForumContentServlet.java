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
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/ForumContentServlet")
public class ForumContentServlet extends HttpServlet {

    @Resource(lookup = "jdbc/MyTHIPool")
    private DataSource dataSource;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        int topicId = Integer.valueOf(request.getParameter("topicId"));
        ForumContent forumContentTopicId = new ForumContent();
        forumContentTopicId.setTopicId(topicId);

        List<ForumContent> forumContentList = read(topicId);

        request.setAttribute("forumContentList", forumContentList);
        request.setAttribute("forumContentTopicId", forumContentTopicId);

        HttpSession session = request.getSession();
        session.setAttribute("forumContentTopicId", forumContentTopicId);

        final RequestDispatcher requestDispatcher = request.getRequestDispatcher("html/forum_pages/forum_content.jsp");
        requestDispatcher.forward(request, response);
    }

    private List<ForumContent> read(int topicId) throws ServletException {
        List<ForumContent> forumContentList = new ArrayList<ForumContent>();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM forumcontent WHERE TopicId = ?;")){
            preparedStatement.setInt(1, topicId);
            try (ResultSet resultSet = preparedStatement.executeQuery()){
                while (resultSet.next()) {
                    ForumContent forumContent = new ForumContent();

                    int contentId = Integer.valueOf(resultSet.getInt("ContentId"));
                    forumContent.setContentId(contentId);

                    forumContent.setTopicId(topicId);

                    int userId = Integer.valueOf(resultSet.getInt("UserId"));
                    forumContent.setUserId(userId);

                    String userName = resultSet.getString("UserName");
                    forumContent.setUserName(userName);

                    String contentText = resultSet.getString("ContentText");
                    forumContent.setContentText(contentText);

                    forumContentList.add(forumContent);
                }
            }
        } catch (Exception exception) {
                 throw new ServletException(exception.getMessage());
        }
        return forumContentList;
    }

}
