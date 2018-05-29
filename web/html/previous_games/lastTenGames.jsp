<%--
  Created by IntelliJ IDEA.
  User: Thomas
  Date: 26.04.2018
  Time: 11:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="de">
    <head>
        <title>Mathequiz letzte 10 Spiele</title>
    </head>
    <body>
        <header>
            <h1>Ihre letzten 10 Spiele</h1>
            <img src="../../img/mathepic.jpg" width="300" height="272" alt="Logo Mathequiz Homepage">
            <h2>Hier können Sie auf Ihre letzten 10 Spiele zugreifen und bei Klick auf eine beliebige Spielnummer <br>
                werden die Aufgaben und Lösungen des ausgewählten Spiels angezeigt</h2>
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
        <aside>
            <c:if test="${not empty Login.benutzername}">
                <h3><a href="../user_pages/profil.jsp">Mein Profil</a></h3>
                <h3>Meine Ergebnisse</h3>
                <ul>
                    <li><a href="../previous_games/lastGame.jsp">Letzes Spiel</a></li>
                    <li><a href="../previous_games/lastTenGames.jsp">Letzte 10 Spiele</a></li>
                </ul>
            </c:if>
        </aside>
        <main>
        <table>
            <tr> 										<th colspan="3"> Username: 	</th> 							</tr>

            <tr>		<th>Spielnummer:  	 		    </th>		<th>Datum: 		  </th>		<th>Anzahl richtiger Ergebnisse:</th>	</tr>
            <tr>		<td> <a href="lastGame.jsp">1	</a>				  </td>		<td>			  </td>		<td>				  			</td>		</tr>
            <tr>		<td><a href="lastGame.jsp">2	</a>			  			</td>		<td>			  </td>		<td>				  			</td>		</tr>
            <tr>		<td><a href="lastGame.jsp">3	</a>			  			</td>		<td>			  </td>		<td>				  			</td>		</tr>
            <tr>		<td><a href="lastGame.jsp">4	</a>			  			</td>		<td>			  </td>		<td>				  			</td>		</tr>
            <tr>		<td><a href="lastGame.jsp">5	</a>			 			</td>		<td>			  </td>		<td>				  			</td>		</tr>
            <tr>		<td><a href="lastGame.jsp">6	</a>	  		 			</td>		<td>			  </td>		<td>						    </td>		</tr>
            <tr>		<td><a href="lastGame.jsp">7	</a>		  	  			</td>		<td>			  </td>		<td>						    </td>		</tr>
            <tr>		<td><a href="lastGame.jsp">8	</a>		 	  			</td>		<td>			  </td>		<td>							</td>		</tr>
            <tr>		<td><a href="lastGame.jsp">9	</a>		  	  			</td>		<td>			  </td>		<td>							</td>		</tr>
            <tr>		<td><a href="lastGame.jsp">10	</a>		 	  			</td>		<td>			  </td>		<td>						    </td>		</tr>

            <tr>		<th colspan="3">        x Spiele mit mehr als 7/10 richtigen Ergebnissen! 					</th>	    </tr>
        </table>

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
