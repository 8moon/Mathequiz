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

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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
                <b>${quickGameExercises1.getExercise_01()}</b>
            </th>
            <th>
            </th>
            <th>
                <b>${quickGameUserSolutions1.getUserSolution_01()}</b>
            </th>
            <th>
                <b>${quickGameExercises1.getSolution_01()}</b>
            </th>
        <tr>
            <th>
                <b>Aufgabe 2: </b>
            </th>
            <th>
                <b>${quickGameExercises1.getExercise_02()}</b>
            </th>
            <th>
            </th>
            <th>
                <b>${quickGameUserSolutions1.getUserSolution_02()}</b>
            </th>
            <th>
                <b>${quickGameExercises1.getSolution_02()}</b>
            </th>
        </tr>
        <tr>
            <th>
                <b>Aufgabe 3: </b>
            </th>
            <th>
                <b>${quickGameExercises1.getExercise_03()}</b>
            </th>
            <th>
            </th>
            <th>
                <b>${quickGameUserSolutions1.getUserSolution_03()}</b>
            </th>
            <th>
                <b>${quickGameExercises1.getSolution_03()}</b>
            </th>
        </tr>
        <tr>
            <th>
                <b>Aufgabe 4: </b>
            </th>
            <th>
                <b>${quickGameExercises1.getExercise_04()}</b>
            </th>
            <th>
            </th>
            <th>
                <b>${quickGameUserSolutions1.getUserSolution_04()}</b>
            </th>
            <th>
                <b>${quickGameExercises1.getSolution_04()}</b>
            </th>
        </tr>
        <tr>
            <th>
                <b>Aufgabe 5: </b>
            </th>
            <th>
                <b>${quickGameExercises1.getExercise_05()}</b>
            </th>
            <th>
            </th>
            <th>
                <b>${quickGameUserSolutions1.getUserSolution_05()}</b>
            </th>
            <th>
                <b>${quickGameExercises1.getSolution_05()}</b>
            </th>
        </tr>
        <tr>
            <th>
                <b>Aufgabe 6: </b>
            </th>
            <th>
                <b>${quickGameExercises1.getExercise_06()}</b>
            </th>
            <th>
            </th>
            <th>
                <b>${quickGameUserSolutions1.getUserSolution_06()}</b>
            </th>
            <th>
                <b>${quickGameExercises1.getSolution_06()}</b>
            </th>
        </tr>
        <tr>
            <th>
                <b>Aufgabe 7: </b>
            </th>
            <th>
                <b>${quickGameExercises1.getExercise_07()}</b>
            </th>
            <th>
            </th>
            <th>
                <b>${quickGameUserSolutions1.getUserSolution_07()}</b>
            </th>
            <th>
                <b>${quickGameExercises1.getSolution_07()}</b>
            </th>
        </tr>
        <tr>
            <th>
                <b>Aufgabe 8: </b>
            </th>
            <th>
                <b>${quickGameExercises1.getExercise_08()}</b>
            </th>
            <th>
            </th>
            <th>
                <b>${quickGameUserSolutions1.getUserSolution_08()}</b>
            </th>
            <th>
                <b>${quickGameExercises1.getSolution_08()}</b>
            </th>
        </tr>
        <tr>
            <th>
                <b>Aufgabe 9: </b>
            </th>
            <th>
                <b>${quickGameExercises1.getExercise_09()}</b>
            </th>
            <th>
            </th>
            <th>
                <b>${quickGameUserSolutions1.getUserSolution_09()}</b>
            </th>
            <th>
                <b>${quickGameExercises1.getSolution_09()}</b>
            </th>
        </tr>
        <tr>
            <th>
                <b>Aufgabe 10: </b>
            </th>
            <th>
                <b>${quickGameExercises1.getExercise_10()}</b>
            </th>
            <th>
            </th>
            <th>
                <b>${quickGameUserSolutions1.getUserSolution_10()}</b>
            </th>
            <th>
                <b>${quickGameExercises1.getSolution_10()}</b>
            </th>
        </tr>
    </table>
    <b>${quickGameUserSolutions1.getRightUserSolutions()} Ergebnisse von 10 richtig!</b>
<%--    <b>Benötigte Zeit: ${quickGameUserSolutions1.getSolutionDateTime()-quickGameExercises1.getDatetime()}</b> --%>
    <b>Benötigte Zeit in Millisekunden: ${quickGameUserSolutions1.getSolutionTime()}</b>
    <form id="NewQuickGame" method="post" action="schnellesSpiel.jsp" accept-charset="UTF-8">
        <button name="neuesSchnellesSpiel" type="submit">Neues Spiel</button>
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
