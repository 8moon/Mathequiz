<%--
Erstellt von Lu Hoan
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="de">
	<head>
		<base href="${pageContext.request.requestURI}"/>
		<title>Erfolgreiche Aktualisierung eines Eintrags in DB</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<meta charset="UTF-8">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/default_grid.css" type="text/css">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/user_pages/output.css" type="text/css">
			<script type="text/javascript"
			src="${pageContext.request.contextPath}/js/go_to_top.js"></script>
	</head>
	<body>
		<header>
			<h1>Erfolgreiche Aktualisierung eines Eintrags in DB</h1>
		</header>
		<nav>
			<%@include file="../jspf/navigation.jspf"%>
		</nav>
		<div id="flex_main_container">
			<aside>
				<%@include file="../jspf/aside.jspf"%>
			</aside>
			<main>
				<div>
					<h3>Daten wurden aktualisiert</h3>
					<br>
					<label>Username: </label>${user.username} <br> <br>
					<label>Vorname : </label>${user.firstname} <br> <br>
					<label>Nachname: </label>${user.lastname} <br><br>
					<label>Email : </label>${user.email} <br><br>
					<label>Geschlecht:</label>${user.gender} <br><br>
					<form action="${pageContext.request.contextPath}/html/user_pages/login.jsp">
						<button type="submit">Zurück zum Login</button>
					</form>
				</div>
				                <button class="goToTopButton" id="goToTopButton">Seitenanfang</button>
				
			</main>
		</div>
		<footer>
			<%@include file="../jspf/footer.jspf"%>
		</footer>
	</body>
</html>