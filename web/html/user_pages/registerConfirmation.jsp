<%--
  Created by IntelliJ IDEA.
  User: Thomas
  Date: 28.05.2018
  Time: 19:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <base href="${pageContext.request.requestURI}" />
        <title>Bestätigung der erfolgreichen Speicherung</title>
    </head>
    <body>
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
            <h2>Bestätigung der erfolgreichen Speicherung</h2>
            <h3>Ihre Formulareingaben wurden erfolgreich gespeichert</h3>
            <br>
            <b>Vorname: </b>${form.firstname}
            <br>
            <b>Nachname: </b>${form.lastname}
            <br>
            <b>Benutzername: </b>${form.username}
            <br>
            <b>Email: </b>${form.email}
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