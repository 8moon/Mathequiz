<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Falscher Username</title>
</head>
<body>
	<nav>
		<p>
			<a href="../index.jsp">Startseite</a> <a href="spieleseite.jsp">Spieleseite</a>
			<a href="bestenliste.jsp">Bestenliste</a> <a href="login.jsp">Anmeldung</a>
			<a href="registrierung.jsp">Registrierung</a>
		</p>
	</nav>
	<h2>Fehler : Falscher Username</h2>

	<br>
	<b> Username oder das Passwort ist falsch </b>${user.username}
	
	<footer>
		<p>
			<a href="kontakt.jsp">Kontakt</a> <a href="faq.html">FAQ</a> <a
				href="impressum.html">Impressum</a>
		</p>
	</footer>
</body>
</html>