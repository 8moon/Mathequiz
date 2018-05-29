<%--
  Created by IntelliJ IDEA.
  User: Thomas
  Date: 11.05.2018
  Time: 19:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <base href="${pageContext.request.requestURI}" />
        <title>Call Servlet</title>
    </head>
    <body>
        <form id="testForm" action="../../testServlet" method="post" accept-charset="UTF-8">
            <div>
                <label for="name">Name:</label>
                <input type="text" name="name" id="name" placeholder="Ihr Name">
            </div>
            <div>
                <label for="nummer">Nummer:</label>
                <input type="number" name="nummer" id="nummer">
            </div>
            <div>
                <button name="absenden" type="submit" >Absenden</button>
            </div>
        </form>
    </body>
</html>
