<%--
Erstellt von Theinert Thomas und Hoan Lu
--%>
<%@ page contentType="text/plain;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:choose>
	<c:when test="${userList == null || empty userList}">
		Keine Treffer!
	</c:when>
	<c:otherwise>
		<table>
		    <thead>
                <tr>
                    <th>User ID</th>
                    <th>User Vorname</th>
                    <th>User Nachname</th>
                    <th>Username</th>
                    <th>Usergroup</th>
                    <th>User E-Mail Adresse</th>
                    <th>User Geschlecht</th>
                    <th>User ProfilePicture Name</th>
                    <th>User ProfilPicture</th>
                </tr>
			</thead>
		<c:forEach var="userInformation" items="${userList}">
			<tbody>
                <tr>
                    <td>${userInformation.userId}</td>
                    <td>${userInformation.firstName}</td>
                    <td>${userInformation.lastName}</td>
                    <td>${userInformation.userName}</td>
                    <td>${userInformation.userGroup}</td>
                    <td>${userInformation.eMail}</td>
                    <td>${userInformation.gender}</td>
                    <td>${userInformation.profilePictureName}</td>
                    <td><img src="${pageContext.request.contextPath}/SearchUserProfilePictureAdminPageServlet?id=${userInformation.userId}" height="42" width="42" alt="Profilbild"></td>
                </tr>
			</tbody>
		</c:forEach>
		</table>
	</c:otherwise>
</c:choose>

