<%--
  Created by IntelliJ IDEA.
  User: Thomas
  Date: 26.04.2018
  Time: 11:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <base href="${pageContext.request.requestURI}" />
        <title>Registrierung</title>
    </head>
    <body>
        <header>
            <h1>Registrierung</h1>
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
        <main>
            <form method = "post" action="../../RegistrierungServlet" >
                <fieldset>
                    <legend>Registrierungsdaten</legend>
                    <p>Firstname: <br><input type="text" name="firstname" size="30" maxlength="30" required></p>
                    <p>Lastname: <br><input type="text" name="lastname" size="30" maxlength="30" required></p>
                    <p>Username: <br><input type="text" name="username" size="30" maxlength="30" required></p>
                    <p>Gender: <br>
                        <input type = "checkbox" name = "extra" id  ="c1" value = "man" checked>
                        <label for= "c1"> Man</label>
                        <br>
                        <input type ="checkbox" name = "extra" id = "c2" value = "woman">
                        <label for = "c2">Woman</label>
                        <br>
                    </p>
                    <p>E-Mail: <br><input type="email" name="email" size="30" maxlength="30" required></p>
                    <p>Password: <br>
                        <input type="password" name="password" size="30" maxlength="30"></p>
                    <p>Password confirmed: <br><input type = "password" name = "passwordConfirmation" size="30" maxlength= "30" ></p>
                    <button type="submit" name="action">Registrieren</button>
                </fieldset>
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