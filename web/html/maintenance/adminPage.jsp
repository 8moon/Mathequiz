<%--
  Created by IntelliJ IDEA.
  User: Thomas
  Date: 29.05.2018
  Time: 11:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <base href="${pageContext.request.requestURI}" />
        <title>Admin Page</title>
    </head>
    <body>
        <header>
            <h1>Verwaltungsseite für den Administrator</h1>
        </header>
        <nav>
            <p>
                <a href="../../index.jsp">Startseite</a>
                <c:if test = "${not empty user}">
                    <a >Abmeldung</a>
                </c:if>
            </p>
        </nav>
        <aside>
            <c:if test="${not empty user}">
                <h3><a href="../user_pages/profil.jsp">Mein Profil</a></h3>
            </c:if>
        </aside>
        <main>
            <article>
                <p>Folgende Listen beinhalten die Daten von registrierten Usern</p>
            </article>
            <form id="RefreshAdminPage" action="../../RefreshAdminPageServlet" method="post" accept-charset="UTF-8">
                <button name="refresh" id="refresh" type="submit">Admin Seite aktualisieren!</button>
            </form>
            <table>
                <tbody>
                <h2>Übersicht aller User</h2>
                <tr>
                    <th>User ID</th>
                    <th>User Vorname</th>
                    <th>User Nachname</th>
                    <th>Username</th>
                    <th>User E-Mail Adresse</th>
                    <th>User Geschlecht</th>
                </tr>
                <c:forEach var="userInformation" items="${userAdministrationArrayList}">
                    <tr>
                        <td>${userInformation.userIdAll}</td>
                        <td>${userInformation.userFirstNameAll}</td>
                        <td>${userInformation.userLastNameAll}</td>
                        <td>${userInformation.userNameAll}</td>
                        <td>${userInformation.userEmailAll}</td>
                        <td>${userInformation.userGenderAll}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <br>
            <table>
                <tbody>
                <h2>Spiele Übersicht</h2>
                <tr>
                    <th>Game ID</th>
                    <th>User ID</th>
                    <th>Gaming Time</th>
                    <th>Game Date</th>
                    <th>Game Type</th>
                    <th>Game Difficulty</th>
                </tr>
                <c:forEach var="userInformation" items="${userAdministrationArrayList}">
                    <tr>
                        <td>${userInformation.userGameId}</td>
                        <td>${userInformation.userId}</td>
                        <td>${userInformation.userGamingTime}</td>
                        <td>${userInformation.userGameDate}</td>
                        <td>${userInformation.userGameType}</td>
                        <td>${userInformation.userGameDifficulty}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <br>
            <table>
                <tbody>
                <h2>User mit Spiele</h2>
                <tr>
                    <th>User ID</th>
                    <th>User Vorname</th>
                    <th>User Nachname</th>
                    <th>Username</th>
                    <th>User E-Mail Adresse</th>
                    <th>User Geschlecht</th>
                    <th>Game ID</th>
                    <th>Gaming Time</th>
                    <th>Game Date</th>
                    <th>Game Type</th>
                    <th>Game Difficulty</th>
                </tr>
                <c:forEach var="userInformation" items="${userAdministrationArrayList}">
                    <tr>
                        <td>${userInformation.userId}</td>
                        <td>${userInformation.userFirstName}</td>
                        <td>${userInformation.userLastName}</td>
                        <td>${userInformation.userName}</td>
                        <td>${userInformation.userEmail}</td>
                        <td>${userInformation.userGender}</td>
                        <td>${userInformation.userGameId}</td>
                        <td>${userInformation.userGamingTime}</td>
                        <td>${userInformation.userGameDate}</td>
                        <td>${userInformation.userGameType}</td>
                        <td>${userInformation.userGameDifficulty}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </main>
        <footer>
            <p>
                <a href="html/kontakt.jsp">Kontakt</a>
                <a href="html/faq.jsp">FAQ</a>
                <a href="html/impressum.jsp">Impressum</a>
            </p>
        </footer>
    </body>
</html>
