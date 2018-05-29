<%--
  Created by IntelliJ IDEA.
  User: Thomas
  Date: 26.04.2018
  Time: 10:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
    <html lang="de">
    <head>
        <title>Mathequiz Kontakt</title>
    </head>
    <body>
        <header>
            <h1>Hier können Sie Kontakt zu uns aufnehmen:</h1>
        </header>
        <nav>
            <p>
                <a href="../index.jsp">Startseite</a>
                <c:if test = "${not empty Login.benutzername}">
                    <a href="gaming_pages/spieleseite.jsp">Spieleseite</a>
                </c:if>
                <a href="../RefreshScoreboardServlet">Bestenliste</a>
                <c:if test="${empty Login.benutzername}">
                    <a href="user_pages/login.jsp">Anmeldung</a>
                    <a href="user_pages/registrierung.jsp">Registrierung</a>
                </c:if>
                <c:if test = "${not empty Login.benutzername}">
                    <a >Abmeldung</a>
                </c:if>
            </p>
        </nav>
        <aside>
            <c:if test="${not empty Login.benutzername}">
                <h3><a href="user_pages/profil.jsp">Mein Profil</a></h3>
                <h3>Meine Ergebnisse</h3>
                <ul>
                    <li><a href="previous_games/lastGame.jsp">Letzes Spiel</a></li>
                    <li><a href="previous_games/lastTenGames.jsp">Letzte 10 Spiele</a></li>
                </ul>
            </c:if>
        </aside>
        <article>
            <h2>Kontaktformular</h2>
            <form id="ContactForm" action="../ContactContentServlet" method="post" accept-charset="UTF-8">
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
                <button name="sendContactContent" id="sendContactContent" type="submit">Absenden</button>
                <button name="reset" type="reset">Eingaben zurücksetzen</button>
            </form>
        </article>
        <footer>
            <p>
                <a href="kontakt.jsp">Kontakt</a>
                <a href="faq.jsp">FAQ</a>
                <a href="impressum.jsp">Impressum</a>
            </p>
        </footer>
    </body>
</html>
