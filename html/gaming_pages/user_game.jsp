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
          	<script type="text/javascript"
			src="${pageContext.request.contextPath}/js/go_to_top.js"></script>

    <title>Mathequiz Spieleseite</title>
</head>
<body>
<header>
    <h1>Spieleseite vom Mathequiz</h1>


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
            <p>Hier können eingeloggte User ein Spiel ihrer Wahl auswählen
                und dabei die Schwierigkeit bestimmen.</p>
        </article>
        <form id="SpielForm"
              action="${pageContext.request.contextPath}/SpielServlet"
              method="post" accept-charset="UTF-8">
            <table>
                <tr>
                    <th>Leicht</th>
                    <th>Mittel</th>
                    <th>Schwer</th>
                </tr>
                <tr>
                    <td><input type="radio" id="pm_leicht" name="Spiel"
                               value="Addition/Subtraktion/Leicht"> <label
                            for="pm_leicht"> Addition/Subtraktion</label></td>

                    <td><input type="radio" id="pm_mittel" name="Spiel"
                               value="Addition/Subtraktion/Mittel"> <label
                            for="pm_mittel"> Addition/Subtraktion</label></td>

                    <td><input type="radio" id="pm_schwer" name="Spiel"
                               value="Addition/Subtraktion/Schwer"> <label
                            for="pm_schwer"> Addition/Subtraktion</label></td>
                </tr>
                <tr>
                    <td><input type="radio" id="mg_leicht" name="Spiel"
                               value="Multiplikation/Division/Leicht"> <label
                            for="mg_leicht"> Multiplikation/Division</label></td>

                    <td><input type="radio" id="mg_mittel" name="Spiel"
                               value="Multiplikation/Division/Mittel" required> <label
                            for="mg_mittel"> Multiplikation/Division</label></td>

                    <td><input type="radio" id="mg_schwer" name="Spiel"
                               value="Multiplikation/Division/Schwer"> <label
                            for="mg_schwer"> Multiplikation/Division</label> <br></td>
                </tr>
                <tr>
                    <td><input type="radio" id="pmmg_leicht" name="Spiel"
                               value="Addition/Subtraktion/Multiplikation/Division/Leicht">
                        <label for="pmmg_leicht">
                            Addition/Subtraktion/Multiplikation/Division</label></td>

                    <td><input type="radio" id="pmmg_mittel" name="Spiel"
                               value="Addition/Subtraktion/Multiplikation/Division/Mittel">
                        <label for="pmmg_mittel">
                            Addition/Subtraktion/Multiplikation/Division</label></td>

                    <td><input type="radio" id="pmmg_schwer" name="Spiel"
                               value="Addition/Subtraktion/Multiplikation/Division/Schwer">
                        <label for="pmmg_schwer">
                            Addition/Subtraktion/Multiplikation/Division</label></td>
            </table>
            <br>
            <button name="spielen" type="submit">Spielen!</button>
        </form>
                <button class="goToTopButton" id="goToTopButton">Seitenanfang</button>
        
    </main>
</div>
<footer>
    <%@include file="../jspf/footer.jspf"%>
</footer>
</body>
</html>