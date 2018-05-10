<%--
  Created by IntelliJ IDEA.
  User: Thomas
  Date: 26.04.2018
  Time: 11:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Registrierung</title>
</head>
<body>
<header>
    <h1>Registrierung</h1>
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
<form name="RegistrierungForm" action="RegistrierungServlet" method="post">
    <p>
        Vorname : <br>
        <input type="text" name="vorname" size="30" maxlength="30" required>
    <p />
    <p>
        Nachname : <br>
        <input type="text" name="nachname" size="30" maxlength="30" required>
    <p />
    <p>
        Benutzername : <br>
        <input type="text" name="benutzername" size="30" maxlength="30" required>
    <p />
    <p>
        E-Mail : <br>
        <input type="text" name="email" size="30" maxlength="30" required>
    <p />
    <p>
        Passwort : <br>
        <input type="password" name="passwort" size="30" maxlength="30" required required pattern = "123kHz">
    <p />
    <p> Passwort bestätigen : <br>
    <input type = "password" size="30" maxlength= "30" required required pattern = "123kHz."><p/>
    
    <button type="submit" name="action">registrieren</button>
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
