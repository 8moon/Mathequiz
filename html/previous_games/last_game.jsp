<%--
Erstellt von Kahraman Ali
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

    <title>Mathequiz letztes Spiel</title>
    <script
            src="${pageContext.request.contextPath}/js/gaming_table_result_coloring.js"
            type="text/javascript">
    </script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/go_to_top.js"></script>
</head>
<body>
<header>
    <h1>Ihr letztes Spiel</h1>

</header>
<nav>
    <%@include file="../jspf/navigation.jspf"%>
</nav>
<div id="flex_main_container">
    <aside>
        <%@include file="../jspf/aside.jspf"%>
    </aside>
    <main>

        <h2>Hier können Sie Ihr letztes Spiel mit den dazugehörigen 10
            Aufgabenstellungen sowie deren Lösungen einsehen</h2>
        <h3>Letzes Spiel</h3>
        <table id="quick_game_result_table">
            <thead>
            <tr>
                <th></th>
                <th>Aufgabenstellung:</th>
                <th>Ihr Ergebnis:</th>
                <th>Richtiges Ergebnis:</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>Aufgabe 1:</td>
                <td>${savegame1.aufgabe_01}</td>
                <td>${savegame1.userErgebnis_01}</td>
                <td>${savegame1.loesung_01}</td>
            </tr>
            <tr>
                <td>Aufgabe 2:</td>
                <td>${savegame1.aufgabe_02}</td>
                <td>${savegame1.userErgebnis_02}</td>
                <td>${savegame1.loesung_02}</td>
            </tr>
            <tr>
                <td>Aufgabe 3:</td>
                <td>${savegame1.aufgabe_03}</td>
                <td>${savegame1.userErgebnis_03}</td>
                <td>${savegame1.loesung_03}</td>
            </tr>
            <tr>
                <td>Aufgabe 4:</td>
                <td>${savegame1.aufgabe_04}</td>
                <td>${savegame1.userErgebnis_04}</td>
                <td>${savegame1.loesung_04}</td>
            </tr>
            <tr>
                <td>Aufgabe 5:</td>
                <td>${savegame1.aufgabe_05}</td>
                <td>${savegame1.userErgebnis_05}</td>
                <td>${savegame1.loesung_05}</td>
            </tr>
            <tr>
                <td>Aufgabe 6:</td>
                <td>${savegame1.aufgabe_06}</td>
                <td>${savegame1.userErgebnis_06}</td>
                <td>${savegame1.loesung_06}</td>
            </tr>
            <tr>
                <td>Aufgabe 7:</td>
                <td>${savegame1.aufgabe_07}</td>
                <td>${savegame1.userErgebnis_07}</td>
                <td>${savegame1.loesung_07}</td>
            </tr>
            <tr>
                <td>Aufgabe 8:</td>
                <td>${savegame1.aufgabe_08}</td>
                <td>${savegame1.userErgebnis_08}</td>
                <td>${savegame1.loesung_08}</td>
            </tr>
            <tr>
                <td>Aufgabe 9:</td>
                <td>${savegame1.aufgabe_09}</td>
                <td>${savegame1.userErgebnis_09}</td>
                <td>${savegame1.loesung_09}</td>
            </tr>
            <tr>
                <td>Aufgabe 10:</td>
                <td>${savegame1.aufgabe_10}</td>
                <td>${savegame1.userErgebnis_10}</td>
                <td>${savegame1.loesung_10}</td>
            </tr>
            <tr>
                <th colspan="4"></th>
            </tr>
            </tbody>
        </table>
		<button class="goToTopButton" id="goToTopButton">Seitenanfang</button>
    </main>
</div>
<footer>
    <%@include file="../jspf/footer.jspf"%>
</footer>
</body>
</html>
