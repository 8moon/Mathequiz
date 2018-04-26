<%--
  Created by IntelliJ IDEA.
  User: Thomas
  Date: 26.04.2018
  Time: 11:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="de">
    <head>
        <title>Mathequiz Bestenliste</title>
    </head>
    <body>
        <header>
            <h1>Bestenliste vom Mathequiz</h1>
            <img src="../img/mathepic.jpg" width="300" height="272" alt="Logo Mathequiz Homepage">
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
            <article>
                <p>Hier seht ihr alle Spieler eines jeweiligen Schwierigkeitsgrades sortiert in einer Bestenliste.</p>
            </article>
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
                <tr>
                    <td>1.</td>
                    <td>Max Mustermann</td>
                    <td>Susi Süß</td>
                    <td>Mini Musterfrau</td>
                </tr>
                <tr>
                    <td>2.</td>
                    <td>Mini Musterfrau</td>
                    <td>Max Mustermann</td>
                    <td>Susi süß</td>
                </tr>
                </tbody>
            </table>
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
