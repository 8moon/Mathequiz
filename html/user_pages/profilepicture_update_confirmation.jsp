<%--
Erstellt von Lu Hoan
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="de">
	<head>
		<base href="${pageContext.request.requestURI}"/>
		<title>Erfolgreiche Anlage eines Eintrags in DB</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<meta charset="UTF-8">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/default_grid.css" type="text/css">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/user_pages/output.css" type="text/css">
			<script type="text/javascript"
			src="${pageContext.request.contextPath}/js/go_to_top.js"></script>
	</head>
	<body>
		<header>
			<h1>Erfolgreiche Anlage eines Eintrags in DB</h1>
		</header>
		<nav>
			<%@include file="../jspf/navigation.jspf"%>
		</nav>
		<div id="flex_main_container">
			<aside>
				<%@include file="../jspf/aside.jspf"%>
			</aside>
			<main>
				<h3>Ihre Eingaben</h3>
				<br>
				<label> Username : </label>${user.username} <br><br>
				<label>Firstname: </label>${user.firstname} <br><br>
				<label>Lastname: </label>${user.lastname} <br><br>
				<label>Email: </label>${user.email} <br><br>
				<label>Gender: </label>${user.gender} <br><br>
				<label> Profilbild: </label> <img src="${pageContext.request.contextPath}/imageAusgabeServlet?id=${user.username}" height="42" width="42" alt="Profilbild">
				<form action="${pageContext.request.contextPath}/html/user_pages/profile.jsp">
					<button type="submit">Weiter zur Profil</button>
				</form>
			</main>
			                <button class="goToTopButton" id="goToTopButton">Seitenanfang</button>
			
		</div>
		<footer>
			<%@include file="../jspf/footer.jspf"%>
		</footer>
	</body>
</html>