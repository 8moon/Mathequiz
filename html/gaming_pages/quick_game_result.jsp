<%--
Erstellt von Kahraman Ali und Theinert Thomas
--%>
<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="de">
<head>
    <base href="${pageContext.request.requestURI}"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/default_grid.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/gaming_pages/gaming_tables.css" type="text/css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/gaming_table_result_coloring.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/go_to_top.js"></script>
    <title>Mathequiz Spielergebnis</title>
</head>
<body>
<header>
    <h1>Ergebnisse des Schnellen Spiels</h1>
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
            <p>Hier sehen Sie die Ergebnisse:</p>
        </article>
        <div class="responsive_table">
            <b>Spielfeld</b>
            <table id="quick_game_result_table">
                <thead>
                <tr>
                    <th>
                        Aufgabennummer
                    </th>
                    <th>
                        Aufgabe
                    </th>
                    <th>
                        Userlösung
                    </th>
                    <th>
                        Aufgabenlösung
                    </th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>
                        Aufgabe 1:
                    </td>
                    <td>
                        ${quickGameExercises1.exercise_01}
                    </td>
                    <td>
                        ${quickGameUserSolutions1.userSolution_01}
                    </td>
                    <td>
                        ${quickGameExercises1.solution_01}
                    </td>
                </tr>
                <tr>
                    <td>
                        Aufgabe 2:
                    </td>
                    <td>
                        ${quickGameExercises1.exercise_02}
                    </td>
                    <td>
                        ${quickGameUserSolutions1.userSolution_02}
                    </td>
                    <td>
                        ${quickGameExercises1.solution_02}
                    </td>
                </tr>
                <tr>
                    <td>
                        Aufgabe 3:
                    </td>
                    <td>
                        ${quickGameExercises1.exercise_03}
                    </td>
                    <td>
                        ${quickGameUserSolutions1.userSolution_03}
                    </td>
                    <td>
                        ${quickGameExercises1.solution_03}
                    </td>
                </tr>
                <tr>
                    <td>
                        Aufgabe 4:
                    </td>
                    <td>
                        ${quickGameExercises1.exercise_04}
                    </td>
                    <td>
                        ${quickGameUserSolutions1.userSolution_04}
                    </td>
                    <td>
                        ${quickGameExercises1.solution_04}
                    </td>
                </tr>
                <tr>
                    <td>
                        Aufgabe 5:
                    </td>
                    <td>
                        ${quickGameExercises1.exercise_05}
                    </td>
                    <td>
                        ${quickGameUserSolutions1.userSolution_05}
                    </td>
                    <td>
                        ${quickGameExercises1.solution_05}
                    </td>
                </tr>
                <tr>
                    <td>
                        Aufgabe 6:
                    </td>
                    <td>
                        ${quickGameExercises1.exercise_06}
                    </td>
                    <td>
                        ${quickGameUserSolutions1.userSolution_06}
                    </td>
                    <td>
                        ${quickGameExercises1.solution_06}
                    </td>
                </tr>
                <tr>
                    <td>
                        Aufgabe 7:
                    </td>
                    <td>
                        ${quickGameExercises1.exercise_07}
                    </td>
                    <td>
                        ${quickGameUserSolutions1.userSolution_07}
                    </td>
                    <td>
                        ${quickGameExercises1.solution_07}
                    </td>
                </tr>
                <tr>
                    <td>
                        Aufgabe 8:
                    </td>
                    <td>
                        ${quickGameExercises1.exercise_08}
                    </td>
                    <td>
                        ${quickGameUserSolutions1.userSolution_08}
                    </td>
                    <td>
                        ${quickGameExercises1.solution_08}
                    </td>
                </tr>
                <tr>
                    <td>
                        Aufgabe 9:
                    </td>
                    <td>
                        ${quickGameExercises1.exercise_09}
                    </td>
                    <td>
                        ${quickGameUserSolutions1.userSolution_09}
                    </td>
                    <td>
                        ${quickGameExercises1.solution_09}
                    </td>
                </tr>
                <tr>
                    <td>
                        Aufgabe 10:
                    </td>
                    <td>
                        ${quickGameExercises1.exercise_10}
                    </td>
                    <td>
                        ${quickGameUserSolutions1.userSolution_10}
                    </td>
                    <td>
                        ${quickGameExercises1.solution_10}
                    </td>
                </tr>
                </tbody>
            </table>
        </div>
        <br>
        <br>
        <b>${quickGameUserSolutions1.rightUserSolutions} Ergebnisse von 10 richtig!</b>
        <br>
        <br>
        <b>Benötigte Zeit in Sekunden: ${quickGameUserSolutions1.solutionTime / 1000}sec</b>
        <br>
        <br>
        <br>
        <form id="NewQuickGame" method="post" action="${pageContext.request.contextPath}/html/gaming_pages/quick_game.jsp" accept-charset="UTF-8">
            <button name="neuesSchnellesSpiel" type="submit">Neues Spiel</button>
        </form>
        <button class="goToTopButton" id="goToTopButton">Seitenanfang</button>
    </main>
</div>
<footer>
    <%@include file="../jspf/footer.jspf"%>
</footer>
</body>
</html>
