//Erstellt von Thomas Theinert

package servlets;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;

@WebServlet("/SearchUserProfilePictureAdminPageServlet")
public class SearchUserProfilePictureAdminPageServlet extends HttpServlet {

    @Resource(lookup = "jdbc/MyTHIPool")
    private DataSource dataSource;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        int userId = Integer.valueOf(request.getParameter("id"));

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT ProfilePictureFile FROM user WHERE UserId = ?;")){
                 preparedStatement.setInt(1, userId);
             try (ResultSet resultSet = preparedStatement.executeQuery()){
                if (resultSet != null && resultSet.next()) {
                    Blob profilePicture = resultSet.getBlob("ProfilePictureFile");
                    response.reset();
                    long lengthProfilePicture = profilePicture.length();
                    response.setHeader("Content-Length", String.valueOf(lengthProfilePicture));
                    try (InputStream inputStream = profilePicture.getBinaryStream()){
                        final int bufferSize = 256;
                        byte[] buffer = new byte[bufferSize];
                        ServletOutputStream servletOutputStream = response.getOutputStream();
                        while ((lengthProfilePicture = inputStream.read(buffer)) != -1) {
                            servletOutputStream.write(buffer,0,(int) lengthProfilePicture);
                        }
                        servletOutputStream.flush();
                    }
                }
             }
        } catch (Exception exception){
            throw new ServletException(exception.getMessage());
        }
    }

}
