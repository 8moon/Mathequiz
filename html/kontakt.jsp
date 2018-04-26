<%--
  Created by IntelliJ IDEA.
  User: Thomas
  Date: 26.04.2018
  Time: 10:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
                <a href="spieleseite.jsp">Spieleseite</a>
                <a href="bestenliste.jsp">Bestenliste</a>
                <a href="login.jsp">Anmeldung</a>
                <a href="registrierung.jsp">Registrierung</a>
            </p>
        </nav>
        <aside>
            <h3><a href="profil.jsp">Mein Profil</a></h3>
            <h3>Meine Ergebnisse</h3>
            <ul>
                <li><a href="lastGame.jsp">Letzes Spiel</a></li>
                <li><a href="lastTenGames.jsp">Letzte 10 Spiele</a></li>
                <li>Bester Spieler des jeweiligen Schwierigkeitsgrades:
                    <ul>
                        <li>leicht: Max Mustermann</li>
                        <li>mittel: Susi Süß</li>
                        <li>schwer: Mini Musterfrau</li>
                    </ul>
                </li>
            </ul>
        </aside>
        <article>
            <h2>Kontaktformular</h2>
            <form action="input_text.htm">
                <p>Ihre E-Mail Adresse:<br>
                    <textarea name="user_eingabe_e-mail" cols="50" rows="1"></textarea>
                </p>
                <p>Ihr Vorname:<br>
                    <textarea name="user_eingabe_firstname" cols="50" rows="1"></textarea>
                </p>
                <p>Ihr Nachname:<br>
                    <textarea name="user_eingabe_lastname" cols="50" rows="1"></textarea>
                </p>
                <p>Ihre Nachricht an uns:<br>
                    <textarea name="user_eingabe" cols="50" rows="10"></textarea>
                </p>
                <input type="button" name="Text1" value="Absenden">
            </form>
        </article>
        <footer>
            <p>
                <a href="kontakt.jsp">Kontakt</a>
                <a href="faq.html">FAQ</a>
                <a href="impressum.html">Impressum</a>
            </p>
        </footer>
    </body>
</html>
