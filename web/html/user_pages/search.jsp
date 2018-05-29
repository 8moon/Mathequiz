<%--
  Created by IntelliJ IDEA.
  User: Thomas
  Date: 28.05.2018
  Time: 19:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <base href="${pageContext.request.requestURI}" />
        <title>HTML-Formular</title>
        <style>
            /* Elemente positionieren und Formular ausrichten */
            label {
                min-width: 6em;
                display: inline-block;
                text-align: left;
            }
            input {
                width: 20em;
            }
            label {
                vertical-align: top;
            }
            button {
                width: 10em;
            }
            /* Formular optisch stylen.		  *
             * Vorgehen: von innen nach außen */
            fieldset {
                width: 30em;
                padding-top: 1.5em;
                padding-left: 1.5em;
                background: #e6eeff;
                border: 1px solid #000330;
                border-radius: 5px;
            }
            legend {
                background: white;
                padding: 0.2em;
                border: 1px solid #000330;
                border-radius: 5px;
            }
            /* Interaktionen über Pseudoklassen */
            input:hover {
                background: #fffff0;
                border: 2px solid #efe816;
                box-shadow: 0 0 10px rgba(0,0,0,0.2);
            }
            button:hover {
                background: #c9c9c9;
                border: 2px solid #6c6c6c;
            }
            button:active {
                background: #8f8f8f;
            }
            /* Damit Felder nicht zu dicht folgen */
            form div {
                padding: 0.2em;
            }
        </style>
    </head>
    <body>
        <header>
            <h2>Suchen in DB</h2>
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
            <form id="myForm" method="post" action="../../SearchServlet">
                <fieldset>
                    <legend>Datenbankeinträge suchen</legend>
                    <div>
                        <label for="username">Username:</label>
                        <input type="text" name="username" id="username" placeholder="Ihr Username">
                    </div>
                    <div>
                        <button name="submit" type="submit">Absenden</button>
                        <button name="reset" type="reset">Zurücksetzen</button>
                    </div>
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

