<%--
  Created by IntelliJ IDEA.
  User: Thomas
  Date: 11.05.2018
  Time: 19:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <base href="${pageContext.request.requestURI}" />
        <title>Forward</title>
    </head>
    <body>
        <h1><a href="../../index.jsp">Startseite</a></h1>
        <h2>Welcome</h2>
        <p>Dear: ${tb.getBenutzername()}</p>
        <p>Ihre Nummer: ${tb.getZahl()}</p>
        <p>Ihre Aufgabe: ${tb.getAufgabe()}</p>
        <p>Das Ergebis: ${tb.getErgebnis()}</p>
    </body>
</html>
