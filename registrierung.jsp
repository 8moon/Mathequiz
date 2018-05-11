
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
        Firstname : <br>
        <input type="text" name="firstname" size="30" maxlength="30" required>
    <p />
    <p>
        Lastname : <br>
        <input type="text" name="lastname" size="30" maxlength="30" required>
    <p />
    <p>
        Username : <br>
        <input type="text" name="username" size="30" maxlength="30" required>
    <p>
    	Gender : <br>
    	<input type = "checkbox" name = "extra" id  ="c1" value = "man" checked>
    	<label for= "c1"> Man</label> <br>
    	<input type ="checkbox" name = "extra" id = "c2" value = "woman" checked>
    	<label for = "c2">Woman</label> <br>
    <p />
    <p>
        E-Mail : <br>
        <input type="text" name="email" size="30" maxlength="30" required>
    <p />
    <p>
        Password : <br>
        <input type="password" name="passwort" size="30" maxlength="30" required required pattern = "123kHz">
    <p />
    <p> Password confirmed : <br>
    <input type = "password" name = "password confirm" size="30" maxlength= "30" required required pattern = "123kHz."><p/>
    
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
