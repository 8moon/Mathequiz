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

    <title>Mathequiz letzte 10 Spiele</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/go_to_top.js"></script>
</head>
<body>
<header>
    <h1>Ihre letzten 10 Spiele</h1>


</header>

<nav>
    <%@include file="../jspf/navigation.jspf"%>
</nav>
<div id="flex_main_container">
    <aside>
        <%@include file="../jspf/aside.jspf"%>
    </aside>
    <main>
        <h2>
            Hier können Sie auf Ihre letzten 10 Spiele zugreifen und bei Klick
            auf eine beliebige Spielnummer werden die Aufgaben und
            Lösungen des ausgewählten Spiels angezeigt
        </h2>
        <table>
            <thead>
            <tr>
                <th>Aufgabennummer</th>
                <th>Datum:</th>
                <th>Anzahl richtiger Ergebnisse:</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="savegame1" items="${savegame2}">
                <tr>
                    <td>
                        <form
                                action="${pageContext.request.contextPath}/AusgewaehltesSpielServlet?id=${savegame1.gameid}"
                                method="post" accept-charset="UTF-8">
                            <button name="ausgewaehltesSpiel" value="spiel" type="submit">Spiel
                                Anzeigen</button>
                        </form>
                    </td>
                    <td>${savegame1.dtime}</td>
                    <td>${savegame1.userErgebnis_richtig}</td>
                </tr>
            </c:forEach>
            <tr>
                <th colspan="3"></th>
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
