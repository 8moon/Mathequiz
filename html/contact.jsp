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
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/confirm_contact_form.js"></script>
        <title>Mathequiz Kontakt</title>
        	<script type="text/javascript"
			src="${pageContext.request.contextPath}/js/go_to_top.js"></script>
    </head>
    <body>
        <header>
            <h1>Hier können Sie Kontakt zu uns aufnehmen</h1>
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
                    <form id="ContactForm" action="${pageContext.request.contextPath}/ContactContentServlet" method="post" accept-charset="UTF-8">
                        <fieldset><legend>Kontaktformular</legend>
                            <div>
                                <label for="contactEmail">Ihre E-Mail Adresse:</label>
                                <input type="email" name="contactEmail" id="contactEmail" size="50" maxlength="100" required placeholder="E-Mail Adresse">
                            </div>
                            <div>
                                <label for="contactFirstName">Ihr Vorname:</label>
                                <input type="text" name="contactFirstName" id="contactFirstName" size="50" maxlength="20" required placeholder="Vorname">
                            </div>
                            <div>
                                <label for="contactLastName">Ihr Nachname:</label>
                                <input type="text" name="contactLastName" id="contactLastName" size="50" maxlength="20" required placeholder="Nachname">
                            </div>
                            <div>
                                <label for="contactMessage">Ihre Nachricht:</label>
                                <textarea name="contactMessage" id="contactMessage" rows="15" cols="50" maxlength="2500" required placeholder="Hier Ihre Nachricht an uns eintragen..."></textarea>
                            </div>
                            <div>
                                <button name="sendContactContent" id="sendContactContent" type="submit">Absenden</button>
                                <button name="reset" type="reset">Eingaben zurücksetzen</button>
                            </div>
                        </fieldset>
                    </form>
                </article>
                        <button class="goToTopButton" id="goToTopButton">Seitenanfang</button>
                
            </main>
        </div>
        <footer>
            <%@include file="jspf/footer.jspf"%>
        </footer>
    </body>
</html>
