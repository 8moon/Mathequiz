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
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/go_to_top.js"></script>
<title>Mathequiz Schnelles Spiel</title>

</head>
<body>
	<header>
		<h1>Schnelles Spiel bei Mathequiz</h1>
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
		
		<form id="QuickGameForm"
			action="${pageContext.request.contextPath}/QuickGameServlet"
			method="post" accept-charset="UTF-8">
			<button name="spielen" id="spielen" type="submit">Spielen!</button>
		</form>
		<button class="goToTopButton" id="goToTopButton">Seitenanfang</button>

		</main>
	</div>
	<footer>
		<%@include file="../jspf/footer.jspf"%>
	</footer>
</body>
</html>
