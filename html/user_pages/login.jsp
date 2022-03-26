<%--
Erstellt von Lu Hoan
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="de">
<head>
<base href="${pageContext.request.requestURI}" />
<title>Login</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta charset="UTF-8">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/default_grid.css"
	type="text/css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/user_pages/login.css"
	type="text/css">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/cookie_check.js"></script>
		<script type="text/javascript"
			src="${pageContext.request.contextPath}/js/go_to_top.js"></script>
</head>
<body>
	<header>
		<h1>Login</h1>
	</header>
	<nav>
		<%@include file="../jspf/navigation.jspf"%>
	</nav>
	<div id="flex_main_container">
		<aside>
			<%@include file="../jspf/aside.jspf"%>
		</aside>
		<main>
		<form name="LoginForm"
			action="${pageContext.request.contextPath}/LoginServlet"
			method="post">
			<img id="LogPic" class="LogPic"
				src="${pageContext.request.contextPath}/img/mathquiz.png"
				alt="loginlogo">
			<div class="divLogin">
				<div>
					<label for="un">Benutzername :</label> <br> <input type="text"
						name="username" id="un" size="30" maxlength="30"
						pattern="[a-z0-9A-ZäüöÄÜÖ._%+-]{2,}" title="Mindestens 2 Zeichen"
						required>
				</div>
				<div>
					<label for="pw"> Passwort: </label> <br> <input
						type="password" id="pw" name="password" size="30" maxlength="30"
						pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{4,}"
						title="Das Passwort muss mindestens ein Großbuchstabe,ein Kleinbuchstabe und eine Zahl enthalten und die Länge des Passwort ist mindestens 4 Zeichen lang"
						required>
				</div>
				<div>
				<button type="submit" name="action">Anmelden</button>
			</div>
			</div>
		</form>
		                <button class="goToTopButton" id="goToTopButton">Seitenanfang</button>
		
		</main>
	</div>
	<footer>
		<%@include file="../jspf/footer.jspf"%>
	</footer>
</body>
</html>
