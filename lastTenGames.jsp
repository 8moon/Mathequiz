
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="de">
    <head>
         <base href="${pageContext.request.requestURI}" />
        <title>Mathequiz letzte 10 Spiele</title>
    </head>
    <body>
        <header>
            <h1>Ihre letzten 10 Spiele</h1>
            <img src="../img/mathepic.jpg" width="300" height="272" alt="Logo Mathequiz Homepage">
            <h2>Hier können Sie auf Ihre letzten 10 Spiele zugreifen und bei Klick auf eine beliebige Spielnummer <br>
                werden die Aufgaben und Lösungen des ausgewählten Spiels angezeigt</h2>
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
            <tr> 										<th colspan="3"> Username: 	</th> 							</tr>

            <tr>		<th>Spielnummer:  	 		    </th>		<th>Datum: 		  </th>		<th>Anzahl richtiger Ergebnisse:</th>	</tr>
            <tr>		<td>1				  	    </td>		<td>${savegame1.getDtime()}		  </td>		<td>		${savegame1.getUserErgebnis_richtig()}		</td>		</tr>
            <tr>		<td>2				  		</td>		<td>${savegame1.getDtime2()}			  </td>		<td>${savegame1.getUserErgebnis_richtig2()}				  			</td>		</tr>
            <tr>		<td>3			  			</td>		<td>${savegame1.getDtime3()}		  </td>		<td>	${savegame1.getUserErgebnis_richtig3()}		  			</td>		</tr>
            <tr>		<td>4			  			</td>		<td>${savegame1.getDtime4()}			  </td>		<td>${savegame1.getUserErgebnis_richtig4()}		  			</td>		</tr>
            <tr>		<td>5			 			</td>		<td>${savegame1.getDtime5()}			  </td>		<td>${savegame1.getUserErgebnis_richtig5()}			  			</td>		</tr>
            <tr>		<td>6	  		 			</td>		<td>${savegame1.getDtime6()}			  </td>		<td>${savegame1.getUserErgebnis_richtig6()}					    </td>		</tr>
            <tr>		<td>7	  	  			    </td>		<td>${savegame1.getDtime7()}			  </td>		<td>${savegame1.getUserErgebnis_richtig7()}						    </td>		</tr>
            <tr>		<td>8		 	  			</td>		<td>${savegame1.getDtime8()}		  </td>		<td>	${savegame1.getUserErgebnis_richtig8()}						</td>		</tr>
            <tr>		<td>9		  	  			</td>		<td>${savegame1.getDtime9()}			  </td>		<td>${savegame1.getUserErgebnis_richtig9()}							</td>		</tr>
            <tr>		<td>10		 	  			</td>		<td>${savegame1.getDtime10()}			  </td>		<td>${savegame1.getUserErgebnis_richtig10()}						    </td>		</tr>

            <tr>		<th colspan="3">         					</th>	    </tr>
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
