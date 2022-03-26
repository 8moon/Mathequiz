<%--
  Created by  Hoan Lu
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="de">
<head>
<base href="${pageContext.request.requestURI}" />
<title>Profil bei Mathequiz</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/default_grid.css"
	type="text/css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/user_pages/profile.css"
	type="text/css">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/check_password.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/confirm_profile_reset.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/cookie_check.js"></script>
		<script type="text/javascript"
			src="${pageContext.request.contextPath}/js/go_to_top.js"></script>
</head>
<body>
	<header>
		<h1>Profil</h1>
	</header>
	<nav>
		<%@include file="../jspf/navigation.jspf"%>
	</nav>
	<div id="flex_main_container">
		<aside>
			<%@include file="../jspf/aside.jspf"%>
		</aside>
		<main>
		<fieldset>
			<legend> Profilfoto </legend>
			<div>
				<img id="profilpic"
					src="${pageContext.request.contextPath}/imageAusgabeServlet?id=${user.username}"
					alt="Profilbild">
			</div>
			<div>
				<form id="myForm"
					action="${pageContext.request.contextPath}/ImageServlet"
					method="post" enctype="multipart/form-data">
					<label for="image"> Bild hochladen :</label> <input type="file"
						name="image" id="image" accept="image/*" required>
					<div>
						<button type="submit">Profilfoto hochladen</button>
					</div>
				</form>
			</div>
		</fieldset>
		<form id="profil"
			action="${pageContext.request.contextPath}/ProfilServlet"
			method="post">
			<fieldset>
				<legend> Persönliche Daten bearbeiten</legend>
				<img id="panda" class="panda"
					src="${pageContext.request.contextPath}/img/panda.jpg" alt="Panda">
				<label>Username :${user.username}<br></label>
				<div>
					<label for="firstname"> Vorname </label><br> <input
						name="firstname" id="firstname" type="text" size="30"
						maxlength="30" value="${user.firstname}"
						pattern="[a-z0-9A-ZäüöÄÜÖ._%+-]{2,}" title="Mindestens 2 Zeichen"
						required> <label for="firstname"></label>
				</div>
				<div>
					<label for="lastname">Lastname: </label> <br> <input
						name="lastname" type="text" size="30" maxlength="30" id="lastname"
						value="${user.lastname}" pattern="[a-z0-9A-ZäüöÄÜÖ._%+-]{2,}"
						title="Mindestens 2 Zeichen" required> <label
						for="lastname"></label>
				</div>
				<div>
					<label for="mail"> E-Mail : </label> <br> <input name="mail"
						type="email" id="mail" size="30" maxlength="30"
						pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$"
						value="${user.email}" required> <label for="mail"></label>
				</div>
				<div>
					<label> Gender: ${user.gender} </label> <br> <input
						type="radio" name="gender" id="man" value="Mann" checked>
					<label for="man"> Man</label> <br> <input type="radio"
						name="gender" id="frau" value="Frau"> <label for="frau">Woman</label>
					<br>
				</div>
				<div>
					<button name="submit" type="submit">Daten ändern und
						speichern</button>
					<button name="reset" type="reset">Zurücksetzten</button>
				</div>
			</fieldset>
		</form>
		<form id="password"
			action="${pageContext.request.contextPath}/passwordServlet"
			method="post">
			<fieldset>
				<legend>Passwort ändern oder Account löschen</legend>
				<div>
					<label for="pw"> old Password : </label> <br> <input
						type="password" name="oldPassword" id="pw" size="10"
						maxlength="10" required> <label for="pw"></label>
				</div>
				<div>
					<label for="newPassword"> new Password : </label> <br> <input
						type="password" name="newPassword" id="newPassword" size="10"
						maxlength="10" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,}"
						title="Das Passwort muss mindestens ein Großbuchstabe,ein Kleinbuchstabe und eine Zahl enthalten und die Länge des Passwort ist mindestens 6 Zeichen lang"
						required> <label for="newPassword"></label>
				</div>
				<div>
					<label for="passwordConfirmation"> new Password
						Confirmation: </label><br> <input type="password"
						id="passwordConfirmation" name="passwordConfirmation" size="10"
						maxlength="10" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,}"
						title="Das Passwort muss mindestens ein Großbuchstabe,ein Kleinbuchstabe und eine Zahl enthalten und die Länge des Passwort ist mindestens 6 Zeichen lang"
						required><label for="passwordConfirmation"></label>
				</div>
				<div>
					<button name="submit" type="submit">Passwort ändern</button>
				</div>
			</fieldset>
		</form>
		<form id="delete" method="post"
			action="${pageContext.request.contextPath}/DeleteServlet">
			<fieldset>
			<legend> Account löschen</legend>
				<div>
					<label for="username"> Account löschen :</label> <input type="text"
						name="username" id="username"
						placeholder="Bitte ihren Username eingeben"
						pattern="[a-z0-9A-Z._%+-]{2,}" title="Mindestens 2 Zeichen"
						required> <label for="username"></label>
				</div>
				<div>
					<button name="submit" type="submit">Löschen</button>
					<button name="Reset" type="reset">Zurücksetzen</button>
				</div>
			</fieldset>
		</form>
		<br>   
		             <button class="goToTopButton" id="goToTopButton">Seitenanfang</button>
		
		</main>
	</div>
	<footer>
		<%@include file="../jspf/footer.jspf"%>
	</footer>
</body>
</html>
