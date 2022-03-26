<%--
Erstellt von Theinert Thomas
--%>
<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="de">
    <head>
        <base href="${pageContext.request.requestURI}"/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/default_grid.css" type="text/css">
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/cookie_check.js"></script>
        <title>Mathequiz Homepage</title>
        	<script type="text/javascript"
			src="${pageContext.request.contextPath}/js/go_to_top.js"></script>
    </head>
    <body>
        <header>
            <h1>Willkommen beim Mathequiz</h1>
        </header>
        <noscript>Sie haben JavaScript deaktiviert! Bitte JavaScript aktivieren</noscript>
        <nav>
            <%@include file="html/jspf/navigation.jspf"%>
        </nav>
        <div id="flex_main_container">
            <aside>
                <%@include file="html/jspf/aside.jspf"%>
            </aside>
            <main>
                  <h2>Teste deine Matheskills!</h2>
                  <article>
                      <p>Hier könnt Ihr Matheaufgaben rechnen und eure Matheskills testen. Außerdem kann man sich mittels der Bestenliste mit anderen Spielern vergleichen.</p>
                  </article>
                  <ul>
                      <li>Als angemeldeter User können Sie in 3 verschiedenen Schwierigkeitsgraden verschiedene Aufgabenstellungen bearbeiten:
                          <ul>
                              <li>Schwierigkeitsgrad: einfach (zufällige Zahlen zwischen 0 und 10)
                                  <ul>
                                      <li>+/&minus; Aufgaben</li>
                                      <li>*/&divide; Aufgaben</li>
                                      <li>+/&minus;/*/&divide; Aufgaben</li>
                                  </ul>
                              </li>
                              <li>Schwierigkeitsgrad: mittel (zufällige Zahlen zwischen 0 und 100)
                                  <ul>
                                      <li>+/&minus; Aufgaben</li>
                                      <li>*/&divide; Aufgaben</li>
                                      <li>+/&minus;/*/&divide; Aufgaben</li>
                                  </ul>
                              </li>
                              <li>Schwierigkeitsgrad: schwer (zufällige Zahlen zwischen -100 und 100)
                                  <ul>
                                      <li>+/&minus; Aufgaben</li>
                                      <li>*/&divide; Aufgaben</li>
                                      <li>+/&minus;/*/&divide; Aufgaben</li>
                                  </ul>
                              </li>
                          </ul>
                      </li>
                      <li>Als Gast kann man ein schnelles Spiel spielen. Dort gibt es nur einen Schwierigkeitsgrad und die Spiele, sowie die Lösungen werden nicht gespeichert! </li>
                  </ul>
                          <button class="goToTopButton" id="goToTopButton">Seitenanfang</button>
                  
            </main>
        </div>
        <footer>
            <%@include file="html/jspf/footer.jspf"%>
        </footer>
    </body>
</html>
