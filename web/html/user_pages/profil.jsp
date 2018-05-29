<%--
  Created by IntelliJ IDEA.
  User: Thomas
  Date: 26.04.2018
  Time: 11:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <base href="${pageContext.request.requestURI}" />
        <title>Profil bei Mathequiz</title>
    </head>
    <body>
        <header>
            <h1> Profil </h1>
        </header>
        <nav>
            <p>
                <a href="../../index.jsp">Startseite</a>
                <c:if test = "${not empty Login.benutzername}">
                    <a href="spieleseite.jsp">Spieleseite</a>
                </c:if>
                <a href="../../RefreshScoreboardServlet">Bestenliste</a>
                <c:if test="${empty Login.benutzername}">
                    <a href="../user_pages/login.jsp">Anmeldung</a>
                    <a href="../user_pages/registrierung.jsp">Registrierung</a>
                </c:if>
                <c:if test = "${not empty Login.benutzername}">
                    <a >Abmeldung</a>
                </c:if>
            </p>
        </nav>
        <aside>
            <c:if test="${not empty Login.benutzername}">
                <h3><a href="../user_pages/profil.jsp">Mein Profil</a></h3>
                <h3>Meine Ergebnisse</h3>
                <ul>
                    <li><a href="../previous_games/lastGame.jsp">Letzes Spiel</a></li>
                    <li><a href="../previous_games/lastTenGames.jsp">Letzte 10 Spiele</a></li>
                </ul>
            </c:if>
        </aside>
        <main>
        <form method = "post" enctype="multipart/dorm-data">
            <p> Profilfoto auswählen:
                <br>
                <input type = "file" name="bild" accept ="image/*">
            </p>
        </form>
        <form name="ProfilForm" action="../../ProfilServlet" method="post">
            Anrede
            <br>
            <p>
                Gender: <br>
                <input type = "checkbox" name = "extra" id  ="c1" value = "man" checked>
                <label for= "c1"> Man</label> <br>
                <input type ="checkbox" name = "extra" id = "c2" value = "woman" checked>
                <label for = "c2">Woman</label> <br>
            <p />
            <br>
            <p> Firstname  : <br><input name ="Vorname" type="text" size ="30" maxlength="30"><p/>
            <p> Lastname : <br><input name =" Nachname" type="text" size="30" maxlength="30"><p/>
            <p> Username : <br><input name ="username" type="text" size="30" maxlength="30"><p/>
            <p> E-Mail  : <br><input name ="E-Mail" type="text" size ="30" maxlength="30"><p/>
            <p> old Password : <br><input type = "password" size="10" maxlength= "10"><p/>
            <p> new Password : <br><input type = "password" size="10" maxlength= "10"><p/>
            <p> new Password confirm : <br><input type = "password" size="10" maxlength= "10"><p/>
            <input type  = "submit" name= "action" value ="Password change">
            <br>
            <br>
            <input type  = "button" name= "text 2" value ="Account delete">
        </form>
        </main>
        <footer>
            <p>
                <a href="../kontakt.jsp">Kontakt</a>
                <a href="../faq.jsp">FAQ</a>
                <a href="../impressum.jsp">Impressum</a>
            </p>
        </footer>
    </body>
</html>
