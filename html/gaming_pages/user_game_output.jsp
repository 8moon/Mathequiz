<%--
Erstellt von Kahraman Ali
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="de">
<head>
<base href="${pageContext.request.requestURI}" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/default_grid.css"
	type="text/css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/gaming_pages/gaming_tables.css"
	type="text/css">

<title>Mathequiz Spiel</title>

<script
	src="${pageContext.request.contextPath}/js/timer_gaming_pages.js"
	type="text/javascript">
	
</script>
<script src="${pageContext.request.contextPath}/js/zuruecksetzen.js"
	type="text/javascript">
	
</script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/go_to_top.js"></script>


</head>
<body>
	<header>
		<h1>Viel Glück!</h1>


	</header>
	<nav>
		<%@include file="../jspf/navigation.jspf"%>
	</nav>
	<div id="flex_main_container">
		<aside>
			<%@include file="../jspf/aside.jspf"%>
		</aside>
		<main>
		<article>
			<p>Hier können User ihr ausgewähltes Spiel spielen und
				anschließend die Ergebnisse überprüfen</p>
		</article>
		<article>
			<p>Lösungen der Aufgaben mit Division werden auf ganze Zahlen
				abgerundet - Beispiel: 5 / 2 = 2</p>
		</article>
		<form id="SpielErgebnis" method="post"
			action="${pageContext.request.contextPath}/SpielErgebnisCheckServlet"
			accept-charset="UTF-8">
			<table>
				<thead>
					<tr>
						<th>Aufgabennummer</th>
						<th>Aufgabe ${savegame1.aufgabeUndSchwierigkeit}</th>
						<th>Userlösung</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>Aufgabe 1:</td>
						<td>${savegame1.aufgabe_01}</td>
						<td><input type="number" name="loesungUser1"
							placeholder="Ihr Ergebnis" size="6" required></td>
					</tr>
					<tr>
						<td>Aufgabe 2:</td>
						<td>${savegame1.aufgabe_02}</td>
						<td><input type="number" name="loesungUser2"
							placeholder="Ihr Ergebnis" size="6" required></td>
					</tr>
					<tr>
						<td>Aufgabe 3:</td>
						<td>${savegame1.aufgabe_03}</td>
						<td><input type="number" name="loesungUser3"
							placeholder="Ihr Ergebnis" size="6" required></td>
					</tr>
					<tr>
						<td>Aufgabe 4:</td>
						<td>${savegame1.aufgabe_04}</td>
						<td><input type="number" name="loesungUser4"
							placeholder="Ihr Ergebnis" size="6" required></td>
					</tr>
					<tr>
						<td>Aufgabe 5:</td>
						<td>${savegame1.aufgabe_05}</td>
						<td><input type="number" name="loesungUser5"
							placeholder="Ihr Ergebnis" size="6" required></td>
					</tr>
					<tr>
						<td>Aufgabe 6:</td>
						<td>${savegame1.aufgabe_06}</td>
						<td><input type="number" name="loesungUser6"
							placeholder="Ihr Ergebnis" size="6" required></td>
					</tr>
					<tr>
						<td>Aufgabe 7:</td>
						<td>${savegame1.aufgabe_07}</td>
						<td><input type="number" name="loesungUser7"
							placeholder="Ihr Ergebnis" size="6" required></td>
					</tr>
					<tr>
						<td>Aufgabe 8:</td>
						<td>${savegame1.aufgabe_08}</td>
						<td><input type="number" name="loesungUser8"
							placeholder="Ihr Ergebnis" size="6" required></td>
					</tr>
					<tr>
						<td>Aufgabe 9:</td>
						<td>${savegame1.aufgabe_09}</td>
						<td><input type="number" name="loesungUser9"
							placeholder="Ihr Ergebnis" size="6" required></td>
					</tr>
					<tr>
						<td>Aufgabe 10:</td>
						<td>${savegame1.aufgabe_10}</td>
						<td><input type="number" name="loesungUser10"
							placeholder="Ihr Ergebnis" size="6" required></td>
					</tr>
				</tbody>
			</table>
			<p>Startzeit: ${savegame1.datetime}</p>
			<div>
				Spielzeit in Sekunden: <span id="minutes"></span>:<span id="seconds"></span>
			</div>
			<button id="pruefen" name="ueberpruefen" type="submit">Lösungen
				überprüfen</button>
			<button name="Reset" type="reset">Zurücksetzen</button>
		</form>
		<button class="goToTopButton" id="goToTopButton">Seitenanfang</button>

		</main>
	</div>
	<footer>
		<%@include file="../jspf/footer.jspf"%>
	</footer>

</body>
</html>
