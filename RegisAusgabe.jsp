<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Bestätigung der erfolgreichen Speicherung</title>
</head>
<body>
	<nav>
		<p>
			<a href="../index.jsp">Startseite</a> <a href="spieleseite.jsp">Spieleseite</a>
			<a href="bestenliste.jsp">Bestenliste</a> <a href="login.jsp">Anmeldung</a>
			<a href="registrierung.jsp">Registrierung</a>
		</p>
	</nav>
	<h2>Bestätigung der erfolgreichen Speicherung</h2>
	<h3>Ihre Formulareingaben wurden erfolgreich gespeichert</h3>
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