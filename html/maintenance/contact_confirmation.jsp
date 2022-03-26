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
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/maintenance/maintenance_pages_tables.css" type="text/css">
        	<script type="text/javascript"
			src="${pageContext.request.contextPath}/js/go_to_top.js"></script>
        <title>Kontaktticket Bestätigung</title>
    </head>
    <body>
        <header>
            <h1>Bestätigungsseite für ein Kontaktticket</h1>
        </header>
        <nav>
            <%@include file="../jspf/navigation.jspf"%>
        </nav>
        <div id="flex_main_container">
            <aside>
                <%@include file="../jspf/aside.jspf"%>
            </aside>
        <main>
            <h1>Ihre Kontaktanfrage wurde erfolgreich entgegengenommen</h1>
            <p>Ein Support Mitarbeiter wird sich so bald wie möglich um Ihre Anfrage kümmern.</p>
            <form action="${pageContext.request.contextPath}/index.jsp">
                <button type="submit">Weiter zur Startseite</button>
            </form>
                    <button class="goToTopButton" id="goToTopButton">Seitenanfang</button>
            
        </main>
        </div>
        <footer>
            <%@include file="../jspf/footer.jspf"%>
        </footer>
    </body>
</html>
