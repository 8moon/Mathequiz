<%--
  Created by IntelliJ IDEA.
  User: Thomas
  Date: 26.04.2018
  Time: 11:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="de">
    <head>
        <base href="${pageContext.request.requestURI}" />
        <title>Mathequiz Bestenliste</title>
    </head>
    <body>
        <header>
            <h1>Bestenliste vom Mathequiz</h1>
            <img src="../../img/mathepic.jpg" width="300" height="272" alt="Logo Mathequiz Homepage">
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
        <aside>
            <c:if test="${not empty Login.benutzername}">
                <h3><a href="../user_pages/profil.jsp">Mein Profil</a></h3>
                <h3>Meine Ergebnisse</h3>
                <ul>
                    <li><a href="../previous_games/lastGame.jsp">Letzes Spiel</a></li>
                    <li><a href="../previous_games/lastTenGames.jsp">Letzte 10 Spiele</a></li>
                </ul>
            </c:if>
        </aside>
        <main>
            <article>
                <p>Hier seht ihr alle Spieler eines jeweiligen Schwierigkeitsgrades sortiert in einer Bestenliste.</p>
            </article>
            <form id="RefreshScoreboard" action="../../RefreshScoreboardServlet" method="post" accept-charset="UTF-8">
                <button name="refresh" id="refresh" type="submit">Bestenliste aktualisieren!</button>
            </form>
            <h2>Bestenliste</h2>
            <table>
                <tbody>
                <tr>
                    <th rowspan="2">Platz</th>
                    <th colspan="3">Schwierigkeitsgrad</th>
                </tr>
                <tr>
                    <td rowspan="2">leicht</td>
                    <td>mittel</td>
                    <td>schwer</td>
                </tr>
                <c:forEach var="user" items="${scoreboard}" varStatus="status">
                    <tr>
                        <td>${status.count}</td>
                        <td>${user.username}</td>
                        <td>${user.rightUserSolutions}</td>
                        <td>${user.getAverageGamingTime}</td>
                        <td>${user.gameType}</td>
                        <td>${user.gameDifficulty}</td>
                    </tr>
                </c:forEach>
                </tbody>
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
