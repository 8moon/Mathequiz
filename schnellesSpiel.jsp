<%--
  Created by IntelliJ IDEA.
  User: Thomas
  Date: 26.04.2018
  Time: 11:38
  To change this template use File | Settings | File Templates.
--%>

<%--
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="de">
    <head>
        <base href="${pageContext.request.requestURI}" />
        <title>Mathequiz Schnelles Spiel</title>
    </head>
    <body>
        <header>
            <h1>Schnelles Spiel bei Mathequiz</h1>
            <img src="../img/mathepic.jpg" width="300" height="272" alt="Logo Mathequiz Homepage">
            <h2>Hier können Gast-User ein schnelles Spiel spielen.</h2>
        </header>
        <nav>
            <p>
                <a href="../index.jsp">Startseite</a>
                <a href="spieleseite.jsp">Spieleseite</a>
                <a href="bestenliste.jsp">Bestenliste</a>
                <a href="login.jsp">Anmeldung</a>
                <a href="registrierung.jsp">Registrierung</a>
            </p>
        </nav>
        <aside>
            <h3><a href="profil.jsp">Mein Profil</a></h3>
            <h3>Meine Ergebnisse</h3>
            <ul>
                <li><a href="lastGame.jsp">Letzes Spiel</a></li>
                <li><a href="lastTenGames.jsp">Letzte 10 Spiele</a></li>
                <li>Bester Spieler des jeweiligen Schwierigkeitsgrades:
                    <ul>
                        <li>leicht: Max Mustermann</li>
                        <li>mittel: Susi Süß</li>
                        <li>schwer: Mini Musterfrau</li>
                    </ul>
                </li>
            </ul>
        </aside>
        <main>
            <form id="QuickGameForm" action="../QuickGameServlet" method="post" accept-charset="UTF-8">
                <button name="spielen" id="spielen" type="submit">Spielen!</button>
            </form>
        </main>
        <footer>
            <p>
                <a href="kontakt.jsp">Kontakt</a>
                <a href="faq.html">FAQ</a>
                <a href="impressum.html">Impressum</a>
            </p>
        </footer>
    </body>
</html>
