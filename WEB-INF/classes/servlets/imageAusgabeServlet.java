// erstellt von Hoan Lu

package servlets;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import beans.User;

/**
 * Servlet implementation class ImageAusgabeServlet
 */
@WebServlet("/imageAusgabeServlet")
public class imageAusgabeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource(lookup = "jdbc/MyTHIPool")
	private DataSource ds;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8"); // In diesem Format erwartet das Servlet jetzt die Formulardaten
		User form = new User();
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		form.setUsername(user.getUsername());

		// DB-Zugriff
		try (Connection con = ds.getConnection();
			 PreparedStatement pstmt = con
					 .prepareStatement("SELECT ProfilePictureFile FROM user WHERE username = ?;")) {
			pstmt.setString(1, form.getUsername());
			try (ResultSet rs = pstmt.executeQuery()) {

				if (rs != null && rs.next()) {
					Blob bild = rs.getBlob("ProfilePictureFile");
					response.reset();
					long length = bild.length();
					response.setHeader("Content-Length", String.valueOf(length));

					try (InputStream in = bild.getBinaryStream()) {
						final int bufferSize = 256;
						byte[] buffer = new byte[bufferSize];

						ServletOutputStream out = response.getOutputStream();
						while ((length = in.read(buffer)) != -1) {
							out.write(buffer, 0, (int) length);
						}
						out.flush();
					}
				}
			}
		} catch (Exception ex) {
			throw new ServletException(ex.getMessage());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}