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
                    <th>
                        Aufgabenlösung
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
                        <b>${quickGameUserSolutions1.userSolution_01}</b>
                    </th>
                    <th>
                        <b>${quickGameExercises1.solution_01}</b>
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
                        <b>${quickGameUserSolutions1.userSolution_02}</b>
                    </th>
                    <th>
                        <b>${quickGameExercises1.solution_02}</b>
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
                        <b>${quickGameUserSolutions1.userSolution_03}</b>
                    </th>
                    <th>
                        <b>${quickGameExercises1.solution_03}</b>
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
                        <b>${quickGameUserSolutions1.userSolution_04}</b>
                    </th>
                    <th>
                        <b>${quickGameExercises1.solution_04}</b>
                    </th>
                </tr>
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
                        <b>${quickGameUserSolutions1.userSolution_05}</b>
                    </th>
                    <th>
                        <b>${quickGameExercises1.solution_05}</b>
                    </th>
                </tr>
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
                        <b>${quickGameUserSolutions1.userSolution_06}</b>
                    </th>
                    <th>
                        <b>${quickGameExercises1.solution_06}</b>
                    </th>
                </tr>
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
                        <b>${quickGameUserSolutions1.userSolution_07}</b>
                    </th>
                    <th>
                        <b>${quickGameExercises1.solution_07}</b>
                    </th>
                </tr>
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
                        <b>${quickGameUserSolutions1.userSolution_08}</b>
                    </th>
                    <th>
                        <b>${quickGameExercises1.solution_08}</b>
                    </th>
                </tr>
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
                        <b>${quickGameUserSolutions1.userSolution_09}</b>
                    </th>
                    <th>
                        <b>${quickGameExercises1.solution_09}</b>
                    </th>
                </tr>
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
                        <b>${quickGameUserSolutions1.userSolution_10}</b>
                    </th>
                    <th>
                        <b>${quickGameExercises1.solution_10}</b>
                    </th>
                </tr>
            </table>
            <b>${quickGameUserSolutions1.rightUserSolutions} Ergebnisse von 10 richtig!</b>
        <%--    <b>Benötigte Zeit: ${quickGameUserSolutions1.getSolutionDateTime()-quickGameExercises1.getDatetime()}</b> --%>
            <b>Benötigte Zeit in Sekunden: ${quickGameUserSolutions1.solutionTime / 1000}sec</b>
            <form id="NewQuickGame" method="post" action="schnellesSpiel.jsp" accept-charset="UTF-8">
                <button name="neuesSchnellesSpiel" type="submit">Neues Spiel</button>
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
