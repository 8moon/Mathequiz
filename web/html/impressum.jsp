<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="de">
    <head>
        <meta charset="UTF-8">
        <title>Mathequiz Impressum</title>
    </head>
    <body>
        <header>
            <h1>Impressum</h1>
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
        <main>
            <article>
                <h3>Betreiber der Homepage</h3>
                <ul>
                    <li>Thomas</li>
                    <li>Hoan</li>
                    <li>Ali</li>
                </ul>
            </article>
        </main>
        <footer>
            <p>
                <a href="kontakt.jsp">Kontakt</a>
                <a href="faq.jsp">FAQ</a>
                <a href="impressum.jsp">Impressum</a>
            </p>
        </footer>
    </body>
</html>