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
        <title>Mathequiz FAQ</title>
        	<script type="text/javascript"
			src="${pageContext.request.contextPath}/js/go_to_top.js"></script>
    </head>
    <body>
        <header>
            <h1>Antworten auf die häufigsten Fragen</h1>
        </header>
        <nav>
            <%@include file="jspf/navigation.jspf"%>
        </nav>
        <div id="flex_main_container">
            <aside>
                <%@include file="jspf/aside.jspf"%>
            </aside>
            <main>
                <h2>FREQUENTLY ASKED QUESTIONS</h2>
                <section>
                    <h3>Wieso sehe ich meine Spiele nicht in der Bestenliste?</h3>
                    <article>
                        <h4>Antwort:</h4>
                        <p>Um Spiele zu spielen, die auf der Bestenliste angezeigt werden, müssen Sie als angemeldeter User spielen.</p>
                    </article>
                </section>
                <section>
                    <h3>Wieso kann ich nicht meine zuletzt gespielten Spiele sehen?</h3>
                    <article>
                        <h4>Antwort:</h4>
                        <p>Sie müssen als angemeldeter User spielen, damit ihre Spiele gespeichert werden.</p>
                    </article>
                </section>
                        <button class="goToTopButton" id="goToTopButton">Seitenanfang</button>
                
            </main>
        </div>
        <footer>
            <%@include file="jspf/footer.jspf"%>
        </footer>
    </body>
</html>