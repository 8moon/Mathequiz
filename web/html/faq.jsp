<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="de">
    <head>
        <meta charset="UTF-8">
        <title>Mathequiz FAQ</title>
    </head>
    <body>
        <header>
            <h1>Hier finden Sie Antworten auf die meist gestelltesten Fragen:</h1>
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
            <h2>FREQUENTLY ASKED QUESTIONS</h2>
            <section>
                <h3>Why can't I play on a harder difficulty?</h3>
                <article>
                    <h4>Answer:</h4>
                    <p>You first have to play 10 games on your highest available difficulty to unlock the next harder difficulty</p>
                </article>
            </section>
            <section>
                <h3>Why can't I see my last played games?</h3>
                <article>
                    <h4>Answer:</h4>
                    <p>You have to log into your User-account before you start playing</p>
                </article>
            </section>
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