<%--
  Created by IntelliJ IDEA.
  User: Thomas
  Date: 26.04.2018
  Time: 11:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="de">
    <head>
        <base href="${pageContext.request.requestURI}" />
        <title>Mathequiz Schnelles Spiel</title>
    </head>
    <body>
        <header>
            <h1>Schnelles Spiel bei Mathequiz</h1>
            <img src="../../img/mathepic.jpg" width="300" height="272" alt="Logo Mathequiz Homepage">
            <h2>Hier können Gast-User ein schnelles Spiel spielen.</h2>
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
            <form id="QuickGameForm" action="../../QuickGameServlet" method="post" accept-charset="UTF-8">
                <button name="spielen" id="spielen" type="submit">Spielen!</button>
            </form>
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
