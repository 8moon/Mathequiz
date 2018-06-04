
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="de">
<head>
<base href="${pageContext.request.requestURI}" />
<title>Mathequiz Schnelles Spiel</title>
</head>
<body>
	<header>
		<h1>Schnelles Spiel bei Mathequiz</h1>
		<img src="../img/mathepic.jpg" width="300" height="272"
			alt="Logo Mathequiz Homepage">
		<h2>Hier können User ihr ausgewähltes Spiel spielen und
			anschließend die Ergebnisse überprüfen</h2>
	</header>
	<nav>
		<p>
			<a href="../index.jsp">Startseite</a> <a href="spieleseite.jsp">Spieleseite</a>
			<a href="bestenliste.jsp">Bestenliste</a> <a href="login.jsp">Anmeldung</a>
			<a href="registrierung.jsp">Registrierung</a>
		</p>
	</nav>
	<aside>
		<h3>
			<a href="profil.jsp">Mein Profil</a>
		</h3>
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


	 <form id="SpielErgebnis" method="post" action="../../SpielErgebnisCheck" accept-charset="UTF-8">
		<table>


		<tr>
			<th><b>Aufgabennummer</b></th>
			<th><b>Aufgabe</b> <br>${savegame1.getAufgabeUndSchwierigkeit()}
			</th>
			<th></th>
			<th>Userlösung</th>
		</tr>
		<tr>
			<th><b>Aufgabe 1: </b></th>
			<th><b>${savegame1.getAufgabe_01()}</b></th>
			<th></th>
			<th><input type="number" name="loesungUser1" size="6" maxlength="6">
			</th>
		</tr>
		<tr>
			<th><b>Aufgabe 2: </b></th>
			<th><b>${savegame1.getAufgabe_02()}</b></th>
			<th></th>
			<th><input type="number" name="loesungUser2" size="6" maxlength="6">
			</th>
		</tr>
		<tr>
			<th><b>Aufgabe 3: </b></th>
			<th><b>${savegame1.getAufgabe_03()}</b></th>
			<th></th>
			<th><input type="number" name="loesungUser3" size="6" maxlength="6">
			</th>
		</tr>
		<tr>
			<th><b>Aufgabe 4: </b></th>
			<th><b>${savegame1.getAufgabe_04()}</b></th>
			<th></th>
			<th><input type="number" name="loesungUser4" size="6" maxlength="6">
			</th>
		</tr>
		<tr>
			<th><b>Aufgabe 5: </b></th>
			<th><b>${savegame1.getAufgabe_05()}</b></th>
			<th></th>
			<th><input type="number" name="loesungUser5" size="6" maxlength="6">
			</th>
		</tr>
		<tr>
			<th><b>Aufgabe 6: </b></th>
			<th><b>${savegame1.getAufgabe_06()}</b></th>
			<th></th>
			<th><input type="number" name="loesungUser6" size="6" maxlength="6">
			</th>
		</tr>
		<tr>
			<th><b>Aufgabe 7: </b></th>
			<th><b>${savegame1.getAufgabe_07()}</b></th>
			<th></th>
			<th><input type="number" name="loesungUser7" size="6" maxlength="6">
			</th>
		</tr>
		<tr>
			<th><b>Aufgabe 8: </b></th>
			<th><b>${savegame1.getAufgabe_08()}</b></th>
			<th></th>
			<th><input type="number" name="loesungUser8" size="6" maxlength="6">
			</th>
		</tr>
		<tr>
			<th><b>Aufgabe 9: </b></th>
			<th><b>${savegame1.getAufgabe_09()}</b></th>
			<th></th>
			<th><input type="number" name="loesungUser9" size="6" maxlength="6">
			</th>
		</tr>
		<tr>
			<th><b>Aufgabe 10: </b></th>
			<th><b>${savegame1.getAufgabe_10()}</b></th>
			<th></th>
			<th><input type="number" name="loesungUser10" size="6"
				maxlength="6"></th>
		</tr>
	</table>
		
		<button name="überprüfen" type="submit">Lösungen überprüfen</button>
	</form>

	<footer>
		<p>
			<a href="kontakt.jsp">Kontakt</a> <a href="faq.html">FAQ</a> <a
				href="impressum.html">Impressum</a>
		</p>
	</footer>
</body>
</html>
