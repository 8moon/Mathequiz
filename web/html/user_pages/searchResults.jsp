<%--
  Created by IntelliJ IDEA.
  User: Thomas
  Date: 28.05.2018
  Time: 19:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <base href="${pageContext.request.requestURI}" />
        <title>Erfolgreiches Suchen in DB</title>
        <style>
            table, th, td {
                border: 1px solid;
                border-collapse: collapse;
                padding: 5px;
                text-align: center;
            }
        </style>
    </head>
    <body>
        <header>
            <h2>Erfolgreiches Suchen in DB</h2>
        </header>
            <nav>
                <p>
                    <a href="../../index.jsp">Startseite</a>
                    <c:if test = "${not empty Login.benutzername}">
                        <a href="spieleseite.jsp">Spieleseite</a>
                    </c:if>
                    <a href="../../RefreshScoreboardServlet">Bestenliste</a>
                    <c:if test="${empty Login.benutzername}">
                        <a href="../user_pages/login.jsp">Anmeldung</a>
                        <a href="../user_pages/registrierung.jsp">Registrierung</a>
                    </c:if>
                    <c:if test = "${not empty Login.benutzername}">
                        <a >Abmeldung</a>
                    </c:if>
                </p>
            </nav>
        <main>
            <h3>Gelesene Daten</h3>
            <table>
                <tr>
                    <th>Firstname</th>
                    <th>Lastname</th>
                    <th>Email</th>
                </tr>
                <c:forEach var="item" items="${user}" varStatus="status">
                    <tr>
                        <td>${item.firstname}</td>
                        <td>${item.lastname}</td>
                        <td>${item.email}</td>
                    </tr>
                </c:forEach>
            </table>
        </main>
        <footer>
            <p>
                <a href="../kontakt.jsp">Kontakt</a>
                <a href="../faq.jsp">FAQ</a>
                <a href="../impressum.jsp">Impressum</a>
            </p>
        </footer>
    </body>
</html>
