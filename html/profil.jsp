<%--
  Created by IntelliJ IDEA.
  User: Thomas
  Date: 26.04.2018
  Time: 11:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<<html>
<head>
    <title>Profil bei Mathequiz</title>
</head>
<body>
<header>
    <h1> Profil </h1>
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
<form method = "post" enctype="multipart/dorm-data">
    <p> Profilfoto auswählen:
        <br>
        <input type = "file" name="bild" accept ="image/*">
    </p>
</form>
<form name="ProfilForm" action="ProfilServlet" method="post">
    Anrede
    <br>
    <input type="radio" name="room" id="r1" value="Herr"checked>
    <label for="r1">Herr</label><br>
    <input type="radio" name="room" id="r2" value="Frau">
    <label for="r2">Frau</label><br>
    <p> Vorname  : <br><input name ="Vorname" type="text" size ="30" maxlength="30"><p/>
    <p> Nachname : <br><input name =" Nachname" type="text" size="30" maxlength="30"><p/>
    <p> Username : <br><input name ="username" type="text" size="30" maxlength="30"><p/>
    <p> E-Mail  : <br><input name ="E-Mail" type="text" size ="30" maxlength="30"><p/>
    <p> Altes Passwort : <br><input type = "password" size="10" maxlength= "10"><p/>
    <p> Neues Passwort : <br><input type = "password" size="10" maxlength= "10"><p/>
    <p> Neues Passwort bestaetigen : <br><input type = "password" size="10" maxlength= "10"><p/>
    <input type  = "button" name= "text 1" value ="Passwort ändern">
    <br>
    <br>
    <input type  = "button" name= "text 2" value ="Account löschen">
</form>
<br>
<footer>
    <p>
        <a href="kontakt.jsp">Kontakt</a>
        <a href="faq.html">FAQ</a>
        <a href="impressum.html">Impressum</a>
    </p>
</footer>
</body>
</html>
