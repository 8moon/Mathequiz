<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Profil</title>
</head>
<body>
	<nav>
		<p>
			<a href="index.jsp">Startseite</a> <a href="spieleseite.jsp">Spieleseite</a>
			<a href="bestenliste.jsp">Bestenliste</a> <a href="login.jsp">Anmeldung</a>
			<a href="registrierung.jsp">Registrierung</a>
			<a href ="profil.jsp">Profil</a>
			<form method = "post" action = "Logout">
			<div id ="ausloggen">
			<button type ="submit" id = "ausloggen"> Ausloggen</button></div></form>
		
	</nav>
	<h2>Mein Profil</h2>
	<br>
	<b>Vorname: </b>${form.firstname}
	<br>
	<b>Nachname: </b>${form.lastname}
	<br>
	<b>Benutzername: </b>${form.username}
	<br>
	<b>Email: </b>${form.email}
	<footer>
		<p>
			<a href="kontakt.jsp">Kontakt</a> <a href="faq.html">FAQ</a> <a
				href="impressum.html">Impressum</a>
		</p>
	</footer>
</body>
</html>