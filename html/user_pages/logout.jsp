<%--
Erstellt von Lu Hoan
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="de">
	<head>
		<base href="${pageContext.request.requestURI}"/>
		<title>Abmelden</title>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/default_grid.css" type="text/css">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/user_pages/output.css" type="text/css">
			<script type="text/javascript"
			src="${pageContext.request.contextPath}/js/go_to_top.js"></script>
	</head>
	<body>
		<header>
			<h1>Abmelden</h1>
		</header>
		<nav>
			<%@include file="../jspf/navigation.jspf"%>
		</nav>
		<div id="flex_main_container">
			<aside>
				<%@include file="../jspf/aside.jspf"%>
			</aside>
			<main>
				<form method="post" action="${pageContext.request.contextPath}/LogoutServlet">
					<h3>Sie haben sich erfolgreich ausgeloggt</h3>
					<img id="logoutPic" class="logoutPic"
					src="${pageContext.request.contextPath}/img/logout.jpeg" alt="logoutPic">
				</form>
				<form action="${pageContext.request.contextPath}/index.jsp">
					<button type="submit">Weiter zur Startseite</button>
				</form>
				                <button class="goToTopButton" id="goToTopButton">Seitenanfang</button>
				
			</main>
		</div>
		<footer>
			<%@include file="../jspf/footer.jspf"%>
		</footer>
	</body>
</html>
