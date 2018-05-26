
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Login</title>
    </head>
    <body>
        <h1>Login</h1>
        <header>
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
        <form name="LoginForm" action="../../LoginServlet" method="post">
            <p>
                Benutzername : <br> <input type="text" name="benutzername"
                                           size="30" maxlength="30" required>
            <p />
            <p>
                Passwort : <br> <input type="password" name="passwort" size="30"
                                       maxlength="30" required>
            <p />
            <button type="submit" name="action">anmelden</button>
            <footer>
                <p>
                    <a href="kontakt.jsp">Kontakt</a>
                    <a href="faq.html">FAQ</a>
                    <a href="impressum.html">Impressum</a>
                </p>
            </footer>
        </form>
    </body>
</html>
