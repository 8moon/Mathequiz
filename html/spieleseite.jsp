<%--
  Created by IntelliJ IDEA.
  User: Thomas
  Date: 26.04.2018
  Time: 10:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="de">
    <head>
        <title>Mathequiz Spieleseite</title>
    </head>
    <body>
        <header>
            <h1>Spieleseite vom Mathequiz</h1>
            <img src="../img/mathepic.jpg" width="300" height="272" alt="Logo Mathequiz Homepage">
            <h2>Hier können eingeloggte User ein Spiel ihrer Wahl auswählen und dabei die Schwierigkeit bestimmen.</h2>
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
        <table>
            <tr>
                <th>Leicht</th>
                <th>Mittel</th>
                <th>Schwer</th>
            </tr>

            <tr>
                <td>
                    <input type="radio" id="pm_leicht" name="Spiel" value="1">
                    <label for="pm_leicht"> Addition/Subtraktion</label>
                </td>

                <td>
                    <input type="radio" id="pm_mittel" name="Spiel" value="2">
                    <label for="pm_mittel"> Addition/Subtraktion</label>
                </td>

                <td>
                    <input type="radio" id="pm_schwer" name="Spiel" value="3">
                    <label for="pm_schwer"> Addition/Subtraktion</label>
                </td>

            </tr>

            <tr>
                <td>
                    <input type="radio" id="mg_leicht" name="Spiel" value="4">
                    <label for="mg_leicht"> Multiplikation/Division</label>
                </td>

                <td>
                    <input type="radio" id="mg_mittel" name="Spiel" value="5">
                    <label for="mg_mittel"> Multiplikation/Division</label>
                </td>

                <td>
                    <input type="radio" id="mg_schwer" name="Spiel" value="6">
                    <label for="mg_schwer"> Multiplikation/Division</label>  <br>
                </td>

            </tr>

            <tr>
                <td>
                    <input type="radio" id="pmmg_leicht" name="Spiel" value="7">
                    <label for="pmmg_leicht"> Addition/Subtraktion/Multiplikation/Division</label>
                </td>

                <td>
                    <input type="radio" id="pmmg_mittel" name="Spiel" value="8">
                    <label for="pmmg_mittel"> Addition/Subtraktion/Multiplikation/Division</label>
                </td>

                <td>
                    <input type="radio" id="pmmg_schwer" name="Spiel" value="9">
                    <label for="pmmg_schwer"> Addition/Subtraktion/Multiplikation/Division</label>
                </td>
        </table>

        <br>
        <button type="button">Spielen!</button>

        <table>
            <tr>
                <th>Spielfeld </th>
            </tr>
            <tr>
                <th> Ergebnis: 9 von 10 richtig! </th>
            </tr>
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