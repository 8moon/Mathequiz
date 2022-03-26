<%--
Erstellt von Kahraman Ali
--%>
<%@page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="de">
<head>
    <base href="${pageContext.request.requestURI}" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/css/default_grid.css"
          type="text/css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/css/gaming_pages/gaming_tables.css"
          type="text/css">
              <link rel="stylesheet"
          href="${pageContext.request.contextPath}/css/previos_games/leaderboard_tables.css"
          type="text/css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/css/previos_games/table_show_button.css"
          type="text/css">
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/js/go_to_top.js"></script>
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/js/table_show.js"></script>
    <title>Mathequiz Bestenliste</title>
</head>
<body>
<header>
    <h1>Bestenliste vom Mathequiz</h1>
</header>
<nav>
    <%@include file="../jspf/navigation.jspf"%>
</nav>
<div id="flex_main_container">
    <aside>
        <%@include file="../jspf/aside.jspf"%>
    </aside>
    <main>
        <article>
            <p>Hier seht ihr alle Spieler eines jeweiligen
                Schwierigkeitsgrades sortiert in einer Bestenliste.</p>
        </article>
        <form id="RefreshScoreboard"
              action="${pageContext.request.contextPath}/RefreshScoreboardServlet"
              method="post" accept-charset="UTF-8">
            <button name="refresh" id="refresh" type="submit">Bestenliste
                aktualisieren!</button>
            <br><br><br>
        </form>
        <h2>Bestenlisten</h2>

        <h3>Bestenliste des Schwierigkeitsgrades LEICHT und der
            Aufgabenart Plus/Minus</h3>
        <input type=button value="LEICHT und Aufgabenart Plus/Minus" id="id1">
        <div id="hidden1">

            <table>
                <thead>
                <tr>
                    <th>Platz</th>
                    <th>Username</th>
                    <th>Insgesamt Richtig gelöste Aufgaben</th>
                    <th>Insgesamt gespielte Spiele</th>
                    <th>Durchschnittlich benötigte Zeit</th>
                </tr>
                </thead>

                <tbody>

                <c:forEach var="leaderboard" items="${plusMinusleicht}"
                           varStatus="status">
                    <tr>
                        <td>${status.count}</td>
                        <td>${leaderboard.userName}</td>
                        <td>${leaderboard.rightUserSolutions}</td>
                        <td>${leaderboard.playedGames}</td>
                        <td>${leaderboard.averageGamingTime /1000}sek</td>
                    </tr>
                </c:forEach>

                </tbody>
            </table>
        </div>
        <h3>Bestenliste des Schwierigkeitsgrades Mittel und der
            Aufgabenart Plus/Minus</h3>
        <input type=button value="MITTEL und Aufgabenart Plus/Minus" id="id2">

        <div id="hidden2">
            <table>
                <thead>
                <tr>
                    <th>Platz</th>
                    <th>Username</th>
                    <th>Insgesamt Richtig gelöste Aufgaben</th>
                    <th>Insgesamt gespielte Spiele</th>
                    <th>Durchschnittlich benötigte Zeit</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="leaderboard" items="${plusMinusnormal}"
                           varStatus="status">
                    <tr>
                        <td>${status.count}</td>
                        <td>${leaderboard.userName}</td>
                        <td>${leaderboard.rightUserSolutions}</td>
                        <td>${leaderboard.playedGames}</td>
                        <td>${leaderboard.averageGamingTime /1000}sek</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <h3>Bestenliste des Schwierigkeitsgrades Schwer und der
            Aufgabenart Plus/Minus</h3>
        <input type=button value="SCHWER und Aufgabenart Plus/Minus" id="id3">

        <div id="hidden3">
            <table>
                <thead>
                <tr>
                    <th>Platz</th>
                    <th>Username</th>
                    <th>Insgesamt Richtig gelöste Aufgaben</th>
                    <th>Insgesamt gespielte Spiele</th>
                    <th>Durchschnittlich benötigte Zeit</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="leaderboard" items="${plusMinusschwer}"
                           varStatus="status">
                    <tr>
                        <td>${status.count}</td>
                        <td>${leaderboard.userName}</td>
                        <td>${leaderboard.rightUserSolutions}</td>
                        <td>${leaderboard.playedGames}</td>
                        <td>${leaderboard.averageGamingTime /1000}sek</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <h3>Bestenliste des Schwierigkeitsgrades Leicht und der
            Aufgabenart Mal/Geteilt</h3>
        <input type=button value="LEICHT und Aufgabenart Mal/Geteilt" id="id4">

        <div id="hidden4">
            <table>
                <thead>
                <tr>
                    <th>Platz</th>
                    <th>Username</th>
                    <th>Insgesamt Richtig gelöste Aufgaben</th>
                    <th>Insgesamt gespielte Spiele</th>
                    <th>Durchschnittlich benötigte Zeit</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="leaderboard" items="${malGeteiltleicht}"
                           varStatus="status">
                    <tr>
                        <td>${status.count}</td>
                        <td>${leaderboard.userName}</td>
                        <td>${leaderboard.rightUserSolutions}</td>
                        <td>${leaderboard.playedGames}</td>
                        <td>${leaderboard.averageGamingTime /1000}sek</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <h3>Bestenliste des Schwierigkeitsgrades Mittel und der
            Aufgabenart Mal/Geteilt</h3>
        <input type=button value="Mittel und Aufgabenart Mal/Geteilt" id="id5">

        <div id="hidden5">
            <table>
                <thead>
                <tr>
                    <th>Platz</th>
                    <th>Username</th>
                    <th>Insgesamt Richtig gelöste Aufgaben</th>
                    <th>Insgesamt gespielte Spiele</th>
                    <th>Durchschnittlich benötigte Zeit</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="leaderboard" items="${malGeteiltnormal}"
                           varStatus="status">
                    <tr>
                        <td>${status.count}</td>
                        <td>${leaderboard.userName}</td>
                        <td>${leaderboard.rightUserSolutions}</td>
                        <td>${leaderboard.playedGames}</td>
                        <td>${leaderboard.averageGamingTime /1000}sek</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <h3>Bestenliste des Schwierigkeitsgrades Schwer und der
            Aufgabenart Mal/Geteilt</h3>
        <input type=button value="Schwer und Aufgabenart Mal/Geteilt" id="id6">

        <div id="hidden6">
            <table>
                <thead>
                <tr>
                    <th>Platz</th>
                    <th>Username</th>
                    <th>Insgesamt Richtig gelöste Aufgaben</th>
                    <th>Insgesamt gespielte Spiele</th>
                    <th>Durchschnittlich benötigte Zeit</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="leaderboard" items="${malGeteiltschwer}"
                           varStatus="status">
                    <tr>
                        <td>${status.count}</td>
                        <td>${leaderboard.userName}</td>
                        <td>${leaderboard.rightUserSolutions}</td>
                        <td>${leaderboard.playedGames}</td>
                        <td>${leaderboard.averageGamingTime /1000}sek</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <h3>Bestenliste des Schwierigkeitsgrades Leicht und der
            Aufgabenart Plus/Minus/Mal/Geteilt</h3>
        <input type=button value="Leicht und Aufgabenart Plus/Minus/Mal/Geteilt" id="id7">

        <div id="hidden7">
            <table>
                <thead>
                <tr>
                    <th>Platz</th>
                    <th>Username</th>
                    <th>Insgesamt Richtig gelöste Aufgaben</th>
                    <th>Insgesamt gespielte Spiele</th>
                    <th>Durchschnittlich benötigte Zeit</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="leaderboard" items="${plusMinusMalGeteiltleicht}"
                           varStatus="status">
                    <tr>
                        <td>${status.count}</td>
                        <td>${leaderboard.userName}</td>
                        <td>${leaderboard.rightUserSolutions}</td>
                        <td>${leaderboard.playedGames}</td>
                        <td>${leaderboard.averageGamingTime /1000}sek</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <h3>Bestenliste des Schwierigkeitsgrades Mittel und der
            Aufgabenart Plus/Minus/Mal/Geteilt</h3>
        <input type=button value="Mittel und Aufgabenart Plus/Minus/Mal/Geteilt" id="id8">

        <div id="hidden8">
            <table>
                <thead>
                <tr>
                    <th>Platz</th>
                    <th>Username</th>
                    <th>Insgesamt Richtig gelöste Aufgaben</th>
                    <th>Insgesamt gespielte Spiele</th>
                    <th>Durchschnittlich benötigte Zeit</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="leaderboard" items="${plusMinusMalGeteiltnormal}"
                           varStatus="status">
                    <tr>
                        <td>${status.count}</td>
                        <td>${leaderboard.userName}</td>
                        <td>${leaderboard.rightUserSolutions}</td>
                        <td>${leaderboard.playedGames}</td>
                        <td>${leaderboard.averageGamingTime /1000}sek</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>

        <h3>Bestenliste des Schwierigkeitsgrades Schwer und der
            Aufgabenart Plus/Minus/Mal/Geteilt</h3>
        <input type=button value="Schwer und Aufgabenart Plus/Minus/Mal/Geteilt" id="id9">

        <div id="hidden9">
            <table>
                <thead>
                <tr>
                    <th>Platz</th>
                    <th>Username</th>
                    <th>Insgesamt Richtig gelöste Aufgaben</th>
                    <th>Insgesamt gespielte Spiele</th>
                    <th>Durchschnittlich benötigte Zeit</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="leaderboard" items="${plusMinusMalGeteiltschwer}"
                           varStatus="status">
                    <tr>
                        <td>${status.count}</td>
                        <td>${leaderboard.userName}</td>
                        <td>${leaderboard.rightUserSolutions}</td>
                        <td>${leaderboard.playedGames}</td>
                        <td>${leaderboard.averageGamingTime /1000}sek</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <button class="goToTopButton" id="goToTopButton">Seitenanfang</button>
    </main>
</div>
<footer>
    <%@include file="../jspf/footer.jspf"%>
</footer>
</body>
</html>
