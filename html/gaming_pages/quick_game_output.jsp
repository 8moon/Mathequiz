<%--
Erstellt von Kahraman Ali und Theinert Thomas
--%>
<%@page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/timer_gaming_pages.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/go_to_top.js"></script>
<title>Mathequiz Schnelles Spiel</title>
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
			<p>Hier können Gast-User ein schnelles Spiel spielen.</p>
		</article>
		<article>

			<p>Lösungen der Aufgaben mit Division werden auf ganze Zahlen
				abgerundet - Beispiel: 5 / 2 = 2</p>
		</article>
		<form id="QuickGameCheckSolutions" method="post"
			action="${pageContext.request.contextPath}/QuickGameCheckSolutionsServlet"
			accept-charset="UTF-8">
			<h3>Spielfeld</h3>
			<div class="responsive_table">
				<table>
					<thead>
						<tr>
							<th>Aufgabennummer</th>
							<th>Aufgabe</th>
							<th>Userlösung</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>Aufgabe 1:</td>
							<td>${quickGameExercises1.exercise_01}</td>
							<td><input type="number" name="userSolution1"
								id="userSolution1" placeholder="Ihr Ergebnis" size="6" required></td>
						</tr>
						<tr>
							<td>Aufgabe 2:</td>
							<td>${quickGameExercises1.exercise_02}</td>
							<td><input type="number" name="userSolution2"
								id="userSolution2" placeholder="Ihr Ergebnis" size="6" required></td>
						</tr>
						<tr>
							<td>Aufgabe 3:</td>
							<td>${quickGameExercises1.exercise_03}</td>
							<td><input type="number" name="userSolution3"
								id="userSolution3" placeholder="Ihr Ergebnis" size="6" required></td>
						</tr>
						<tr>
							<td>Aufgabe 4:</td>
							<td>${quickGameExercises1.exercise_04}</td>
							<td><input type="number" name="userSolution4"
								id="userSolution4" placeholder="Ihr Ergebnis" size="6" required></td>
						</tr>
						<tr>
							<td>Aufgabe 5:</td>
							<td>${quickGameExercises1.exercise_05}</td>
							<td><input type="number" name="userSolution5"
								id="userSolution5" placeholder="Ihr Ergebnis" size="6" required></td>
						</tr>
						<tr>
							<td>Aufgabe 6:</td>
							<td>${quickGameExercises1.exercise_06}</td>
							<td><input type="number" name="userSolution6"
								id="userSolution6" placeholder="Ihr Ergebnis" size="6" required></td>
						</tr>
						<tr>
							<td>Aufgabe 7:</td>
							<td>${quickGameExercises1.exercise_07}</td>
							<td><input type="number" name="userSolution7"
								id="userSolution7" placeholder="Ihr Ergebnis" size="6" required></td>
						</tr>
						<tr>
							<td>Aufgabe 8:</td>
							<td>${quickGameExercises1.exercise_08}</td>
							<td><input type="number" name="userSolution8"
								id="userSolution8" placeholder="Ihr Ergebnis" size="6" required></td>
						</tr>
						<tr>
							<td>Aufgabe 9:</td>
							<td>${quickGameExercises1.exercise_09}</td>
							<td><input type="number" name="userSolution9"
								id="userSolution9" placeholder="Ihr Ergebnis" size="6" required></td>
						</tr>
						<tr>
							<td>Aufgabe 10:</td>
							<td>${quickGameExercises1.exercise_10}</td>
							<td><input type="number" name="userSolution10"
								id="userSolution10" placeholder="Ihr Ergebnis" size="6" required></td>
						</tr>
					</tbody>
				</table>
			</div>
			<p>Startzeit: ${quickGameExercises1.datetime}</p>
			<div>
				Spielzeit in Sekunden: <span id="minutes"></span>:<span id="seconds"></span>
			</div>
			<button name="überprüfen" type="submit">Lösungen überprüfen</button>
		</form>
		<button class="goToTopButton" id="goToTopButton">Seitenanfang</button>
		</main>
	</div>
	<footer>
		<%@include file="../jspf/footer.jspf"%>
	</footer>
</body>
</html>
