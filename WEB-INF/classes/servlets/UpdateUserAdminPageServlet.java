//Erstellt von Thomas Theinert

package servlets;

import beans.User;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.sql.DataSource;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;

@WebServlet("/UpdateUserAdminPageServlet")
@MultipartConfig(maxFileSize=1024*1024*5,
        maxRequestSize=1024*1024*5*5,
        location= "/tmp",
        fileSizeThreshold=1024*1024)
public class UpdateUserAdminPageServlet extends HttpServlet {

    @Resource(lookup = "jdbc/MyTHIPool")
    private DataSource dataSource;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        User updateUserAdministration = new User();
        updateUserAdministration.setUserId(Integer.valueOf(request.getParameter("searchUpdateUserId")));
        updateUserAdministration.setUsername(request.getParameter("updateUserName"));
        updateUserAdministration.setFirstname(request.getParameter("updateUserFirstName"));
        updateUserAdministration.setLastname(request.getParameter("updateUserLastName"));
        updateUserAdministration.setEmail(request.getParameter("updateUserEmail"));
        updateUserAdministration.setGender(request.getParameter("updateUserGender"));
        Part filepart = request.getPart("updateUserProfilePicture");
        updateUserAdministration.setFilename(filepart.getSubmittedFileName());
        try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
             InputStream inputStream = filepart.getInputStream()){
            int i = 0;
            while ((i = inputStream.read()) != -1) {
                byteArrayOutputStream.write(i);
            }
            updateUserAdministration.setImage(byteArrayOutputStream.toByteArray());
            byteArrayOutputStream.flush();
        } catch (IOException exception) {
                 throw new ServletException(exception.getMessage());
        }

        persist(updateUserAdministration);

        request.setAttribute("updateUserAdministration", updateUserAdministration);

        final RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/user_administration.jsp");
        requestDispatcher.forward(request, response);
    }

    private void persist(User updateUserAdministration) throws ServletException {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("UPDATE user "
             + "SET UserName = ?, FirstName = ?, LastName = ?, Email = ?, Gender = ?, ProfilePictureName = ?, ProfilePictureFile = ? WHERE UserId = ?;")){
            preparedStatement.setString(1, updateUserAdministration.getUsername());
            preparedStatement.setString(2, updateUserAdministration.getFirstname());
            preparedStatement.setString(3, updateUserAdministration.getLastname());
            preparedStatement.setString(4, updateUserAdministration.getEmail());
            preparedStatement.setString(5, updateUserAdministration.getGender());
            preparedStatement.setString(6, updateUserAdministration.getFilename());
            preparedStatement.setBytes(7, updateUserAdministration.getImage());
            preparedStatement.setInt(8, updateUserAdministration.getUserId());
            preparedStatement.executeUpdate();
        } catch (Exception exception) {
                 throw new ServletException(exception.getMessage());
        }
    }

}
