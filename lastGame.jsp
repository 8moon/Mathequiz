
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="de">
    <head>
     <base href="${pageContext.request.requestURI}" />
        <title>Mathequiz letztes Spiel</title>
    </head>
    <body>
        <header>
            <h1>Ihr letztes Spiel</h1>
            <img src="../img/mathepic.jpg" width="300" height="272" alt="Logo Mathequiz Homepage">
            <h2>Hier können Sie Ihr letztes Spiel mit den dazugehörigen 10 Aufgabenstellungen sowie deren Lösungen einsehen</h2>
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
               <li><a href="../../LetztesSpielAnzeigenServlet">Letztes Spiel</a></li>
                <li><a href="../../LetztenZehnSpieleServlet">Letzten 10 Spiele</a></li>
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
        <table>
            <tr> 										<th colspan="3"> Username: </th> 	</tr>
            <tr>		<th>Aufgabenstellung: </th>		<th>Ihr Ergebnis: </th>		<th>Richtiges Ergebnis:</th>	</tr>
            <tr>		<td>${savegame1.getAufgabe_01()} </td>	<td>${spieluserergebnis1.getUserErgebnis_01()} </td>		<td>${savegame1.getLoesung_01()}				  </td></tr>
            <tr>		<td>${savegame1.getAufgabe_02()} </td>		<td>${savegame1.getUserErgebnis_02()}		  </td>		<td>${savegame1.getLoesung_02()}				  </td>		</tr>
            <tr>		<td>${savegame1.getAufgabe_03()} </td>		<td>${savegame1.getUserErgebnis_03()}		  </td>		<td>${savegame1.getLoesung_03()}				  </td>		</tr>
            <tr>		<td>${savegame1.getAufgabe_04()} </td>		<td>${savegame1.getUserErgebnis_04()}		  </td>		<td>${savegame1.getLoesung_04()}				  </td>		</tr>
            <tr>		<td>${savegame1.getAufgabe_05()} </td>		<td>${savegame1.getUserErgebnis_05()}		  </td>		<td>${savegame1.getLoesung_05()}				  </td>		</tr>
            <tr>		<td>${savegame1.getAufgabe_06()} </td>		<td>${savegame1.getUserErgebnis_06()}		  </td>		<td>${savegame1.getLoesung_06()}				  </td>		</tr>
            <tr>		<td>${savegame1.getAufgabe_07()} </td>		<td>${savegame1.getUserErgebnis_07()}		  </td>		<td>${savegame1.getLoesung_07()}			  </td>		</tr>
            <tr>		<td>${savegame1.getAufgabe_08()} </td>		<td>${savegame1.getUserErgebnis_08()}	      </td>		<td>${savegame1.getLoesung_08()}			  </td>		</tr>
            <tr>		<td>${savegame1.getAufgabe_09()} </td>		<td>${savegame1.getUserErgebnis_09()}		  </td>		<td>${savegame1.getLoesung_09()}				  </td>		</tr>
            <tr>		<td>${savegame1.getAufgabe_10()} </td>		<td>${savegame1.getUserErgebnis_10()}		  </td>		<td>${savegame1.getLoesung_10()}			  </td>		</tr>
            <tr>									    <th colspan="3">  </th>	</tr>
        </table>
        
       
        
        </main>
        <footer>
            <p>
                <a href="kontakt.jsp">Kontakt</a>
                <a href="faq.html">FAQ</a>
                <a href="impressum.html">Impressum</a>
            </p>
        </footer>
    </body>
</html>
