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
        <script>
            var seconds = 0;
            function pad ( val ) { return val > 9 ? val : "0" + val; }
            setInterval( function(){
                document.getElementById("seconds").innerHTML=pad(++seconds%60);
                document.getElementById("minutes").innerHTML=pad(parseInt(seconds/60,10));
            }, 1000);
        </script>
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
            <form id="QuickGameCheckSolutions" method="post" action="../../QuickGameCheckSolutionsServlet" accept-charset="UTF-8">
            <table>
                <b>Spielfeld</b>
                <tr>
                    <th>
                        <b>Aufgabennummer</b>
                    </th>
                    <th>
                        <b>Aufgabe</b>
                    </th>
                    <th>
                    </th>
                    <th>
                        Userlösung
                    </th>
                </tr>
                <tr>
                    <th>
                        <b>Aufgabe 1: </b>
                    </th>
                    <th>
                        <b>${quickGameExercises1.exercise_01}</b>
                    </th>
                    <th>
                    </th>
                    <th>
                        <input type="number" name="userSolution1" id="userSolution1" placeholder="Ihr Ergebnis" size="6" maxlength="6">
                    </th>
                <tr>
                    <th>
                        <b>Aufgabe 2: </b>
                    </th>
                    <th>
                        <b>${quickGameExercises1.exercise_02}</b>
                    </th>
                    <th>
                    </th>
                    <th>
                        <input type="number" name="userSolution2" id="userSolution2" placeholder="Ihr Ergebnis" size="6" maxlength="6">
                    </th>
                </tr>
                <tr>
                    <th>
                        <b>Aufgabe 3: </b>
                    </th>
                    <th>
                        <b>${quickGameExercises1.exercise_03}</b>
                    </th>
                    <th>
                    </th>
                    <th>
                        <input type="number" name="userSolution3" id="userSolution3" placeholder="Ihr Ergebnis" size="6" maxlength="6">
                    </th>
                </tr>
                <tr>
                    <th>
                        <b>Aufgabe 4: </b>
                    </th>
                    <th>
                        <b>${quickGameExercises1.exercise_04}</b>
                    </th>
                    <th>
                    </th>
                    <th>
                        <input type="number" name="userSolution4" id="userSolution4" placeholder="Ihr Ergebnis" size="6" maxlength="6">
                    </th>
                <tr>
                <tr>
                    <th>
                        <b>Aufgabe 5: </b>
                    </th>
                    <th>
                        <b>${quickGameExercises1.exercise_05}</b>
                    </th>
                    <th>
                    </th>
                    <th>
                        <input type="number" name="userSolution5" id="userSolution5" placeholder="Ihr Ergebnis" size="6" maxlength="6">
                    </th>
                <tr>
                <tr>
                    <th>
                        <b>Aufgabe 6: </b>
                    </th>
                    <th>
                        <b>${quickGameExercises1.exercise_06}</b>
                    </th>
                    <th>
                    </th>
                    <th>
                        <input type="number" name="userSolution6" id="userSolution6" placeholder="Ihr Ergebnis" size="6" maxlength="6">
                    </th>
                <tr>
                <tr>
                    <th>
                        <b>Aufgabe 7: </b>
                    </th>
                    <th>
                        <b>${quickGameExercises1.exercise_07}</b>
                    </th>
                    <th>
                    </th>
                    <th>
                        <input type="number" name="userSolution7" id="userSolution7" placeholder="Ihr Ergebnis" size="6" maxlength="6">
                    </th>
                <tr>
                <tr>
                    <th>
                        <b>Aufgabe 8: </b>
                    </th>
                    <th>
                        <b>${quickGameExercises1.exercise_08}</b>
                    </th>
                    <th>
                    </th>
                    <th>
                        <input type="number" name="userSolution8" id="userSolution8" placeholder="Ihr Ergebnis" size="6" maxlength="6">
                    </th>
                <tr>
                <tr>
                    <th>
                        <b>Aufgabe 9: </b>
                    </th>
                    <th>
                        <b>${quickGameExercises1.exercise_09}</b>
                    </th>
                    <th>
                    </th>
                    <th>
                        <input type="number" name="userSolution9" id="userSolution9" placeholder="Ihr Ergebnis" size="6" maxlength="6">
                    </th>
                <tr>
                <tr>
                    <th>
                        <b>Aufgabe 10: </b>
                    </th>
                    <th>
                        <b>${quickGameExercises1.exercise_10}</b>
                    </th>
                    <th>
                    </th>
                    <th>
                        <input type="number" name="userSolution10" id="userSolution10" placeholder="Ihr Ergebnis" size="6" maxlength="6">
                    </th>
                <tr>
            </table>
            <p>Startzeit: ${quickGameExercises1.datetime}</p>
            <div>Spielzeit in Sekunden: <span id="minutes"></span>:<span id="seconds"></span></div>
<%--            <form id="QuickGameCheckSolutions" method="post" action="../QuickGameCheckSolutionsServlet" accept-charset="UTF-8"> --%>
                <button name="überprüfen" type="submit">Lösungen überprüfen</button>
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
