
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Abmelden</title>
</head>
<body>
<header>
    <h1>Abmelden</h1>
</header>
<nav>
    <p>
        <a href="../../index.jsp">Startseite</a>
        <a href="spieleseite.jsp">Spieleseite</a>
        <a href="bestenliste.jsp">Bestenliste</a>
        <a href="login.jsp">Anmeldung</a>
        <a href="registrierung.jsp">Registrierung</a>
    </p>
</nav>
<form method = "post" action="../../LogoutServlet" >
<fieldset><legend>Sie haben sich erfolgreich ausgeloggt</legend>

    <footer>
        <p>
            <a href="kontakt.jsp">Kontakt</a>
            <a href="faq.html">FAQ</a>
            <a href="impressum.html">Impressum</a>
        </p>
    </footer>
    </fieldset>
</form>
</body>
</html>
