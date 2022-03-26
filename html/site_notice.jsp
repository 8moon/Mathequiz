<%--
Erstellt von Theinert Thomas
--%>
<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="de">
    <head>
        <base href="${pageContext.request.requestURI}"/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/default_grid.css" type="text/css">
        <title>Mathequiz Impressum</title>
        	<script type="text/javascript"
			src="${pageContext.request.contextPath}/js/go_to_top.js"></script>
    </head>
    <body>
        <header>
            <h1>Impressum</h1>
        </header>
        <nav>
            <%@include file="jspf/navigation.jspf"%>
        </nav>
        <div id="flex_main_container">
            <aside>
                <%@include file="jspf/aside.jspf"%>
            </aside>
            <main>
                <article>
                    <h3>Betreiber der Homepage</h3>
                    <ul>
                        <li>Theinert Thomas</li>
                        <li>Lu Hoan</li>
                        <li>Kahraman Ali</li>
                    </ul>
                    <p>Bei Problemen erstellen Sie bitte ein Ticket auf der Kontakt-Seite</p>
                </article>
                        <button class="goToTopButton" id="goToTopButton">Seitenanfang</button>
                
            </main>
        </div>
        <footer>
            <%@include file="jspf/footer.jspf"%>
        </footer>
    </body>
</html>