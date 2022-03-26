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

@WebServlet("/CreateUserAdminPageServlet")
@MultipartConfig(maxFileSize=1024*1024*5,
        maxRequestSize=1024*1024*5*5,
        location= "/tmp",
        fileSizeThreshold=1024*1024)
public class CreateUserAdminPageServlet extends HttpServlet {

    @Resource(lookup = "jdbc/MyTHIPool")
    private DataSource dataSource;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        User createUserAdministration = new User();
        createUserAdministration.setUsername(request.getParameter("createNewUsername"));
        createUserAdministration.setFirstname(request.getParameter("createNewUserFirstName"));
        createUserAdministration.setLastname(request.getParameter("createNewUserLastName"));
        createUserAdministration.setPassword(request.getParameter("createNewUserPassword"));
        createUserAdministration.setUserGroup(request.getParameter("createNewUserGroup"));
        createUserAdministration.setEmail(request.getParameter("createNewUserEmail"));
        createUserAdministration.setGender(request.getParameter("createNewUserGender"));
        Part filepart = request.getPart("createNewUserProfilePicture");
        createUserAdministration.setFilename(filepart.getSubmittedFileName());
        try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
             InputStream inputStream = filepart.getInputStream()){
            int i = 0;
            while ((i = inputStream.read()) != -1) {
                byteArrayOutputStream.write(i);
            }
            createUserAdministration.setImage(byteArrayOutputStream.toByteArray());
            byteArrayOutputStream.flush();
        } catch (IOException exception) {
                 throw new ServletException(exception.getMessage());
        }

        persist(createUserAdministration);

        request.setAttribute("createUserAdministration", createUserAdministration);

        final RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/user_administration.jsp");
        requestDispatcher.forward(request, response);
    }

    private void persist(User createUserAdministration) throws ServletException {

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO user (FirstName, LastName, UserName, Email, Password, UserGroup, Gender, ProfilePictureName, ProfilePictureFile) "
             + "VALUES (?,?,?,?,?,?,?,?,?);")){
            preparedStatement.setString(1, createUserAdministration.getFirstname());
            preparedStatement.setString(2, createUserAdministration.getLastname());
            preparedStatement.setString(3, createUserAdministration.getUsername());
            preparedStatement.setString(4, createUserAdministration.getEmail());
            preparedStatement.setString(5, createUserAdministration.getPassword());
            preparedStatement.setString(6, createUserAdministration.getUserGroup());
            preparedStatement.setString(7, createUserAdministration.getGender());
            preparedStatement.setString(8, createUserAdministration.getFilename());
            preparedStatement.setBytes(9, createUserAdministration.getImage());
            preparedStatement.executeUpdate();
        } catch (Exception exception) {
                 throw new ServletException(exception.getMessage());
        }
    }

}
