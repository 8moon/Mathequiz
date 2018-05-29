<%--
  Created by IntelliJ IDEA.
  User: Thomas
  Date: 24.04.2018
  Time: 17:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="de">
    <head>
        <title>Mathequiz Homepage</title>
        <base href="${pageContext.request.requestURI}" />
    </head>
    <body>
        <header>
            <h1>Willkommen beim Mathequiz</h1>
            <img src="img/mathepic.jpg" width="300" height="272" alt="Logo Mathequiz Homepage">
        </header>
          <nav>
              <p>
                  <a href="index.jsp">Startseite</a>
                  <c:if test = "${not empty user}">
                      <a href="html/gaming_pages/spieleseite.jsp">Spieleseite</a>
                  </c:if>
                  <a href="RefreshScoreboardServlet">Bestenliste</a>
                  <c:if test="${empty user}">
                      <a href="html/user_pages/login.jsp">Anmeldung</a>
                      <a href="html/user_pages/registrierung.jsp">Registrierung</a>
                  </c:if>
                  <c:if test = "${not empty user}">
                      <a href="html/user_pages/logout.jsp">Abmeldung</a>
                  </c:if>
                  <c:if test = "${user.username eq 'Support' || user.username eq 'Admin'}">
                      <a href="RefreshSupportPageServlet">Support Tickets</a>
                  </c:if>
                  <c:if test = "${user.username eq 'Admin'}">
                      <a href="RefreshAdminPageServlet">Admin Page</a>
                  </c:if>
              </p>
          </nav>
      <aside>
          <c:if test="${not empty Login.benutzername}">
              <h3><a href="html/user_pages/profil.jsp">Mein Profil</a></h3>
              <h3>Meine Ergebnisse</h3>
              <ul>
                  <li><a href="html/previous_games/lastGame.jsp">Letzes Spiel</a></li>
                  <li><a href="html/previous_games/lastTenGames.jsp">Letzte 10 Spiele</a></li>
              </ul>
          </c:if>
      </aside>
      <main>
          <h2>Teste deine Matheskills!</h2>
          <article>
              <p>Hier könnt Ihr Matheaufgaben rechnen und testen wie gut Ihr seit. Außerdem könnt ihr euch mittels der Bestenliste mit anderen Spielern vergleichen.</p>
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
                      <li>Schwierigkeitsgrad: schwer (zufällige Zahlen zwischen (-100) und 100)
                          <ul>
                              <li>+/&minus; Aufgaben</li>
                              <li>+/&minus;/*/&divide; Aufgaben</li>
                              <li>Funktionen</li>
                          </ul>
                      </li>
                  </ul>
              </li>
              <li>Als Gast kann man ein schnelles Spiel spielen. Dort kann man keinen Schwierigkeitsgrad einstellen und die Lösungen werden nicht gespeichert! </li>
              <li><a href="html/gaming_pages/schnellesSpiel.jsp">Schnelles Spiel</a></li>
              <li><a href="html/examples/callServlet.jsp">Call Servlet</a> </li>
          </ul>
      </main>
      <footer>
          <p>
              <a href="html/kontakt.jsp">Kontakt</a>
              <a href="html/faq.jsp">FAQ</a>
              <a href="html/impressum.jsp">Impressum</a>
          </p>
      </footer>
      </body>
</html>
