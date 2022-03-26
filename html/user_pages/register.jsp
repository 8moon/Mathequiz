<%--
Erstellt von Lu Hoan
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="de">
<head>
<base href="${pageContext.request.requestURI}"/>
<meta charset="UTF-8">
<title>Registrierung</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/default_grid.css"
	type="text/css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/user_pages/register.css"
	type="text/css">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/confirm_reset.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/register_check_password.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/cookie_check.js"></script>
		<script type="text/javascript"
			src="${pageContext.request.contextPath}/js/go_to_top.js"></script>
</head>
<body>
	<header>
		<h1>Registrierung</h1>
	</header>
	<nav>
		<%@include file="../jspf/navigation.jspf"%>
	</nav>
	<div id="flex_main_container">
		<aside>
			<%@include file="../jspf/aside.jspf"%>
		</aside>
		<main>
		<form id="registrieren" method="post"
			action="${pageContext.request.contextPath}/RegistrierungServlet">
			<img id="pandaRegi" class="pandaRegi"
				src="${pageContext.request.contextPath}/img/pandaRegi.jpg"
				alt="Regilogo">
			<div class="divregi">
				<fieldset>
					<legend>Registrierungsdaten</legend>
					<div>
						<label for="firstname"> Vorname :</label> <br> <input
							type="text" id="firstname" name="firstname" size="30"
							maxlength="30" placeholder="Ihr Vorname"
							pattern="[a-z0-9A-ZäüöÄÜÖ._%+-]{2,}" title="Mindestens 2 Zeichen"
							required> <label for="firstname"></label>
					</div>
					<div>
						<label for="lastname"> Lastname :</label> <br> <input
							type="text" name="lastname" size="30" id="lastname"
							maxlength="30" placeholder="Ihr Nachname" pattern="[a-z0-9A-ZäüöÄÜÖ._%+-]{2,}" title="Mindestens 2 Zeichen" required> <label
							for="lastname"></label>
					</div>
					<div>
						<label for="username"> Username :</label> <br> <input
							type="text" id="username" name="username"
							placeholder="Ihr Username" size="30" maxlength="30"
							pattern="[a-z0-9A-ZäüöÄÜÖ._%+-]{2,}" title="Mindestens 2 Zeichen"
							required> <label for="username"></label>
					</div>
					<div>
						<label> Gender:</label> <br> <input type="radio"
							name="gender" id="male" value="Mann" checked> <label
							for="male"> Man</label> <br> <input type="radio"
							name="gender" id="frau" value="Frau"> <label for="frau">Woman</label>
						<br>
					</div>
					<div>
						<label for="mail"> Email :</label> <br> <input type="email"
							id="mail" name="mail" size="30" maxlength="30"
							placeholder="Ihre Email "
							pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$" required>
						<label for="mail"></label>
					</div>
					<div>
						<label for="pwRegi">Password :</label> <br> <input
							type="password" name="password" id="pwRegi" size="30"
							maxlength="30" placeholder="Ihr Passwort"
							pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{4,}"
							title="Das Passwort muss mindestens ein Großbuchstabe,ein Kleinbuchstabe und eine Zahl enthalten und die Länge des Passwort ist mindestens 4 Zeichen lang"
							required> <label for="pwRegi"></label>
					</div>
					<div>
						<label for="pwRegiC">Password confirmed:</label> <br> <input
							type="password" id="pwRegiC" name="passwordConfirmation"
							size="30" maxlength="30"
							pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{4,}"
							title="Das Passwort muss mindestens ein Großbuchstabe,ein Kleinbuchstabe und eine Zahl enthalten und die Länge des Passwort ist mindestens 4 Zeichen lang"
							placeholder="Passwort bitte nochmal wiederholen" required>
						<label for="pwRegiC"></label>
					</div>
					<div>
						<button type="submit" name="action">Registrieren</button>
						<button name="Reset" type="reset">Zurücksetzen</button>
					</div>
					<br>
					<br>
					<p>(*) Das Eingabefeld ist ein Pflichtfeld</p>
				</fieldset>
			</div>
		</form>
		</main>
		                <button class="goToTopButton" id="goToTopButton">Seitenanfang</button>
		
	</div>
	<footer>
		<%@include file="../jspf/footer.jspf"%>
	</footer>
</body>
</html>