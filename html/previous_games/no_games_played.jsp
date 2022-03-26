<%--
Erstellt von Kahraman Ali
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="de">
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet"
		  href="${pageContext.request.contextPath}/css/default_grid.css"
		  type="text/css">
	<link rel="stylesheet"
		  href="${pageContext.request.contextPath}/css/gaming_pages/gaming_tables.css"
		  type="text/css">


	<base href="${pageContext.request.requestURI}" />
	<title>Mathequiz - Kein Spiel gefunden</title>

	<script
			src="${pageContext.request.contextPath}/js/gaming_table_result_coloring.js"
			type="text/javascript">

	</script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/go_to_top.js"></script>

</head>
<body>
<header>
	<h1>Mathequiz - Kein Spiel gefunden</h1>


</header>
<nav>
	<%@include file="../jspf/navigation.jspf"%>

</nav>
<div id="flex_main_container">
	<aside>
		<%@include file="../jspf/aside.jspf"%>
	</aside>
	<main>
		<h2>Es wurde noch kein Spiel mit diesem Account gespielt</h2>
		<h3>Kein Spiel gefunden</h3>

		<button class="goToTopButton" id="goToTopButton">Seitenanfang</button>
	</main>
</div>
<footer>
	<%@include file="../jspf/footer.jspf"%>
</footer>

</body>
</html>