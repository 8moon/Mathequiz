<%--
  Created by IntelliJ IDEA.
  User: Thomas
  Date: 24.04.2018
  Time: 17:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
                  <a href="html/spieleseite.jsp">Spieleseite</a>
                  <a href="html/bestenliste.jsp">Bestenliste</a>
                  <a href="html/login.jsp">Anmeldung</a>
                  <a href="html/registrierung.jsp">Registrierung</a>
              </p>
          </nav>
      <aside>
          <h3><a href="html/profil.jsp">Mein Profil</a></h3>
          <h3>Meine Ergebnisse</h3>
          <ul>
              <li><a href="html/lastGame.jsp">Letzes Spiel</a></li>
              <li><a href="html/lastTenGames.jsp">Letzte 10 Spiele</a></li>
              <li>Bester Spieler des jeweiligen Schwierigkeitsgrades:
                  <ul>
                      <li>leicht: Max Mustermann</li>
                      <li>mittel: Susi Süß</li>
                      <li>schwer: Mini Musterfrau</li>
                  </ul>
              </li>
          </ul>
      </aside>
      <main>
          <h2>Teste deine Matheskills!</h2>
          <article>
              <p>Hier könnt Ihr Matheaufgaben rechnen und testen wie gut Ihr seit. Außerdem könnt ihr euch mittels der Bestenliste mit anderen Spielern vergleichen.</p>
          </article>
          <ul>
              <li>Als angemeldeter User können Sie in 3 verschiedenen Schwierigkeitsgraden verschiedene Aufgabenstellungen bearbeiten:
                  <ul>
                      <li>Schwierigkeitsgrad: einfach (zufällige Zahlen zwischen 0-10)
                          <ul>
                              <li>+/&minus; Aufgaben</li>
                              <li>*/&divide; Aufgaben</li>
                              <li>+/&minus;/*/&divide; Aufgaben</li>
                          </ul>
                      </li>
                      <li>Schwierigkeitsgrad: mittel (zufällige Zahlen zwischen 0-100)
                          <ul>
                              <li>+/&minus; Aufgaben</li>
                              <li>*/&divide; Aufgaben</li>
                              <li>+/&minus;/*/&divide; Aufgaben</li>
                          </ul>
                      </li>
                      <li>Schwierigkeitsgrad: schwer (zufällige Zahlen zwischen (-100)-100)
                          <ul>
                              <li>+/&minus; Aufgaben</li>
                              <li>+/&minus;/*/&divide; Aufgaben</li>
                              <li>Funktionen</li>
                          </ul>
                      </li>
                  </ul>
              </li>
              <li>Als Gast kann man ein schnelles Spiel spielen. Dort kann man keinen Schwierigkeitsgrad einstellen und die Lösungen werden nicht gespeichert! </li>
              <li><a href="html/schnellesSpiel.jsp">Schnelles Spiel</a></li>
          </ul>
      </main>
      <footer>
          <p>
              <a href="html/kontakt.jsp">Kontakt</a>
              <a href="html/faq.html">FAQ</a>
              <a href="html/impressum.html">Impressum</a>
          </p>
      </footer>
      </body>
</html>
