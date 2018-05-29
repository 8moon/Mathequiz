<%--
  Created by IntelliJ IDEA.
  User: Thomas
  Date: 26.04.2018
  Time: 11:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="de">
    <head>
        <title>Mathequiz letztes Spiel</title>
    </head>
    <body>
        <header>
            <h1>Ihr letztes Spiel</h1>
            <img src="../../img/mathepic.jpg" width="300" height="272" alt="Logo Mathequiz Homepage">
            <h2>Hier können Sie Ihr letztes Spiel mit den dazugehörigen 10 Aufgabenstellungen sowie deren Lösungen einsehen</h2>
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
        <table>
            <tr> 										<th colspan="3"> Username: </th> 	</tr>
            <tr>		<th>Aufgabenstellung: </th>		<th>Ihr Ergebnis: </th>		<th>Richtiges Ergebnis:</th>	</tr>
            <tr>		<td>1..				  </td>		<td>			  </td>		<td>				  </td>		</tr>
            <tr>		<td>2..				  </td>		<td>			  </td>		<td>				  </td>		</tr>
            <tr>		<td>3..				  </td>		<td>			  </td>		<td>				  </td>		</tr>
            <tr>		<td>4..				  </td>		<td>			  </td>		<td>				  </td>		</tr>
            <tr>		<td>5..				  </td>		<td>			  </td>		<td>				  </td>		</tr>
            <tr>		<td>6..				  </td>		<td>			  </td>		<td>				  </td>		</tr>
            <tr>		<td>7..				  </td>		<td>			  </td>		<td>				  </td>		</tr>
            <tr>		<td>8..				  </td>		<td>			  </td>		<td>				  </td>		</tr>
            <tr>		<td>9..				  </td>		<td>			  </td>		<td>				  </td>		</tr>
            <tr>		<td>10..			  </td>		<td>			  </td>		<td>				  </td>		</tr>
            <tr>									    <th colspan="3"> Anzahl richtiger Ergebnisse: x </th>	</tr>
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
