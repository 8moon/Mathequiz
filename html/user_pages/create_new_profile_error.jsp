<%--
  Created by  Hoan Lu
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="de">
	<head>
		<base href="${pageContext.request.requestURI}"/>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<meta charset="UTF-8">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/default_grid.css" type="text/css">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/user_pages/output.css" type="text/css">
			<script type="text/javascript"
			src="${pageContext.request.contextPath}/js/go_to_top.js"></script>
		<title>Fehlermeldung</title>
	</head>
	<body>
		<header>
			<h1>Fehlermeldung</h1>
		</header>
		<nav>
			<%@include file="../jspf/navigation.jspf"%>
		</nav>
		<div id="flex_main_container">
			<aside>
				<%@include file="../jspf/aside.jspf"%>
			</aside>
			<main>
			<img id="fehlermeldungPic" class="fehlermeldungPic"
					src="${pageContext.request.contextPath}/img/fehlermeldung.jpg" alt="Fehlermeldung">
				<h3>Fehler : Fehlermeldung</h3>
				<h2>Der Email/Username ist schon vergeben oder das Passwort ist falsch</h2>
				<br>
				<c:if test="${empty user}">
					<br>
					<div>
					<form action="${pageContext.request.contextPath}/html/user_pages/register.jsp">
						<button type="submit">Zur Registrierung</button>
					</form>
					<form action="${pageContext.request.contextPath}/html/user_pages/login.jsp">
						<button type="submit">Zurück zum Login</button>
					</form>
					</div>
				</c:if>
                <c:if test="${not empty user}">
					<form action="${pageContext.request.contextPath}/html/user_pages/profile.jsp">
						<button type="submit">Zurück zum Profil</button>
					</form>
				</c:if>
				                <button class="goToTopButton" id="goToTopButton">Seitenanfang</button>
				
			</main>
		</div>
		<footer>
			<%@include file="../jspf/footer.jspf"%>
		</footer>
	</body>
</html>
