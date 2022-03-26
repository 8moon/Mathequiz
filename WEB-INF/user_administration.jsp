<%--
Erstellt von Theinert Thomas
--%>
<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="de">
    <head>
        <base href="${pageContext.request.requestURI}"/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/default_grid.css" type="text/css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/maintenance/maintenance_pages_tables.css" type="text/css">
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/go_to_top.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/search_user.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/update_user.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/confirm_administration.js"></script>
        <title>Admin Page</title>
        	<script type="text/javascript"
			src="${pageContext.request.contextPath}/js/go_to_top.js"></script>
    </head>
    <body>
        <header>
            <h1>Verwaltungsseite für den Administrator</h1>
        </header>
        <nav>
            <%@include file="../html/jspf/navigation.jspf"%>
        </nav>
        <div id="flex_main_container">
            <aside>
                <%@include file="../html/jspf/aside.jspf"%>
            </aside>
            <main>
                <article>
                    <p>Folgende Listen beinhalten die Daten von registrierten Usern</p>
                </article>
                <article>
                    <form id="RefreshAdminPage" action="${pageContext.request.contextPath}/RefreshAdminPageServlet" method="post" accept-charset="UTF-8">
                        <button name="refreshPage" id="refreshPage" type="submit">Admin Seite aktualisieren!</button>
                        <br><br><br>
                    </form>
                </article>
                <article>
                    <h3>Nach einem bestehenden User suchen - Mit Profilbild</h3>
                    <form id="searchUserOnAdminPage">
                        <fieldset>
                            <legend>Usersuche</legend>
                            <div>
                                <label for="username">Username:</label>
                                <input type="text" name="username" id="username" placeholder="Username">
                            </div>
                        </fieldset>
                    </form>
                    <br>
                    <h3>Ergebnisliste</h3>
                    <div id="searchUserList">Keine Treffer</div>
                    <br>
                </article>
                <article>
                    <form id="CreateNewUserOnAdminPage" action="${pageContext.request.contextPath}/CreateUserAdminPageServlet" method="post" enctype="multipart/form-data" accept-charset="UTF-8">
                        <fieldset>
                            <legend>Einen neuen User anlegen</legend>
                            <div>
                                <label for="createNewUsername">Neuer Username:</label>
                                <input type="text" name="createNewUsername" id="createNewUsername" size="50" maxlength="15" required placeholder="New Username">
                            </div>
                            <div>
                                <label for="createNewUserFirstName">Neuer Vorname:</label>
                                <input type="text" name="createNewUserFirstName" id="createNewUserFirstName" size="50" maxlength="20" required placeholder="New Firstname">
                            </div>
                            <div>
                                <label for="createNewUserLastName">Neuer Nachname:</label>
                                <input type="text" name="createNewUserLastName" id="createNewUserLastName" size="50" maxlength="20" required placeholder="New Lastname">
                            </div>
                            <div>
                                <label for="createNewUserPassword">Neues Passwort:</label>
                                <input type="text" name="createNewUserPassword" id="createNewUserPassword" size="50" maxlength="50" required placeholder="New Password">
                            </div>
                            <div>
                                <label for="createNewUserGroup">Zuweisung der Usergruppe:</label>
                                <input type="text" name="createNewUserGroup" id="createNewUserGroup" size="50" maxlength="50" required placeholder="Usergruppe">
                            </div>
                            <div>
                                <label for="createNewUserEmail">Neue E-Mail Adresse:</label>
                                <input type="email" name="createNewUserEmail" id="createNewUserEmail" size="50" maxlength="100" required placeholder="New Email">
                            </div>
                            <div>
                                <label for="createNewUserGender">Neues Geschlecht:</label>
                                <input type="text" name="createNewUserGender" id="createNewUserGender" size="50" maxlength="10" required placeholder="New Gender">
                            </div>
                            <div>
                                <label for="createNewUserProfilePicture">Neues Profilbild:</label>
                                <input type="file" name="createNewUserProfilePicture" id="createNewUserProfilePicture" accept="image/*">
                            </div>
                            <div>
                                <button name="createUser" id="createUser" type="submit">Benutzer anlegen</button>
                                <button name="resetCreateUser" id="resetCreateUser" type="reset">Eingegebene Daten zurücksetzen</button>
                            </div>
                        </fieldset>
                    </form>
                    <c:if test="${not empty createUserAdministration}">
                        <p>User mit dem Username ${createUserAdministration.username} wurde erfolgreich angelegt</p>
                    </c:if>
                </article>
                <article>
                    <form id="UpdateUserOnAdminPage" action="${pageContext.request.contextPath}/UpdateUserAdminPageServlet" method="post" enctype="multipart/form-data" accept-charset="UTF-8">
                        <fieldset>
                            <legend>Daten eines bestehenden Users ändern</legend>
                            <div>
                                <label for="searchUpdateUserId">Zu ändernder User (Suche nach ID):</label>
                                <input type="number" name="searchUpdateUserId" id="searchUpdateUserId" size="50" required placeholder="User ID">
                            </div>
                            <div>
                                <label for="updateUserName">Username ändern:</label>
                                <input type="text" name="updateUserName" id="updateUserName" size="50" maxlength="15" required placeholder="Username">
                            </div>
                            <div>
                                <label for="updateUserFirstName">User Vorname ändern:</label>
                                <input type="text" name="updateUserFirstName" id="updateUserFirstName" size="50" maxlength="20" required placeholder="Vorname">
                            </div>
                            <div>
                                <label for="updateUserLastName">User Nachname ändern:</label>
                                <input type="text" name="updateUserLastName" id="updateUserLastName" size="50" maxlength="20" required placeholder="Nachname">
                            </div>
                            <div>
                                <label for="updateUserEmail">User E-Mail Adresse ändern:</label>
                                <input type="email" name="updateUserEmail" id="updateUserEmail" size="50" maxlength="100" required placeholder="E-Mail Adresse">
                            </div>
                            <div>
                                <label for="updateUserGender">User Geschlecht ändern:</label>
                                <input type="text" name="updateUserGender" id="updateUserGender" size="50" maxlength="10" required placeholder="Geschlecht">
                            </div>
                            <div>
                                <label for="updateUserProfilePicture">User Profilbild ändern:</label>
                                <input type="file" name="updateUserProfilePicture" id="updateUserProfilePicture" accept="image/*">
                            </div>
                            <div>
                                <button name="updateUser" id="updateUser" type="submit">Benutzerdaten ändern</button>
                                <button name="resetUpdateUser" id="resetUpdateUser" type="reset">Eingegebene Daten zurücksetzen</button>
                            </div>
                        </fieldset>
                    </form>
                    <c:if test="${not empty updateUserAdministration}">
                        <p>Letzter verändeter User: ${updateUserAdministration.updateUserName}</p>
                    </c:if>
                </article>
                <article>
                    <form id="DeleteUserOnAdminPage" action="${pageContext.request.contextPath}/DeleteUserAdminPageServlet" method="post" accept-charset="UTF-8">
                        <fieldset><legend>Einen bestehenden User über dessen ID löschen</legend>
                            <div>
                                <label for="DeleteUserID">User löschen:</label>
                                <input type="number" name="DeleteUserID" id="DeleteUserID" size="50" required placeholder="User ID">
                            </div>
                            <div>
                                <button name="deleteUser" id="deleteUser" type="submit">Benutzer löschen</button>
                            </div>
                        </fieldset>
                    </form>
                    <c:if test="${deleteUserId != null}">
                        <p>Letzter gelöschter User: ${deleteUserId}</p>
                    </c:if>
                </article>
                <article>
                    <h2>AJAX Userverwaltung</h2>
                    <p>User wird sofort nach Feldwechsel oder drücken der ENTER-Tast automatisch in der Datenbank aktualisiert</p>
                    <form id="updateUserOnAdminPageAjax">
                        <div class="responsive_table">
                            <table>
                                <thead>
                                <tr>
                                    <th>User ID</th>
                                    <th>User Vorname</th>
                                    <th>User Nachname</th>
                                    <th>Username</th>
                                    <th>Usergroup</th>
                                    <th>User E-Mail Adresse</th>
                                    <th>User Geschlecht</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="userWithoutGamesInformation" items="${userWithoutGamesAdministrationList}">
                                    <tr>
                                        <td><input type="hidden" class="selectUserId" name="${userWithoutGamesInformation.userIdAll}" id="${userWithoutGamesInformation.userIdAll}userId" value="${userWithoutGamesInformation.userIdAll}">${userWithoutGamesInformation.userIdAll}</td>
                                        <td><input type="text" class="selectUserFirstName" name="${userWithoutGamesInformation.userIdAll}" id="${userWithoutGamesInformation.userIdAll}firstName" value="${userWithoutGamesInformation.userFirstNameAll}"></td>
                                        <td><input type="text" class="selectUserLastName" name="${userWithoutGamesInformation.userIdAll}" id="${userWithoutGamesInformation.userIdAll}lastName" value="${userWithoutGamesInformation.userLastNameAll}"></td>
                                        <td><input type="text" class="selectUserName" name="${userWithoutGamesInformation.userIdAll}" id="${userWithoutGamesInformation.userIdAll}userName" value="${userWithoutGamesInformation.userNameAll}"></td>
                                        <td>
                                            <select class="selectUserGroup" name="${userWithoutGamesInformation.userIdAll}" id="${userWithoutGamesInformation.userIdAll}userGroup">
                                                <option selected>${userWithoutGamesInformation.userGroupAll}</option>
                                                <option value="user">user</option>
                                                <option value="admin">administration</option>
                                                <option value="support">support</option>
                                                <option value="disabled">disabled</option>
                                            </select>
                                        </td>
                                        <td><input type="email" class="selectUserEMail" name="${userWithoutGamesInformation.userIdAll}" id="${userWithoutGamesInformation.userIdAll}eMail" value="${userWithoutGamesInformation.userEmailAll}"></td>
                                        <td>
                                            <select class="selectUserGender" name="${userWithoutGamesInformation.userIdAll}" id="${userWithoutGamesInformation.userIdAll}userGender">
                                                <option selected>${userWithoutGamesInformation.userGenderAll}</option>
                                                <option value="male">male</option>
                                                <option value="female">female</option>
                                            </select>
                                        </td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </form>
                    <br>
                    <h3>Letze Änderung</h3>
                    <div id="lastUpdatedUser">Keine Änderungen vorgenommen</div>
                    <br>
                </article>
                <article>
                    <h2>Übersicht aller User - Ohne Profilbild</h2>
                    <div class="responsive_table">
                        <table>
                            <thead>
                            <tr>
                                <th>User ID</th>
                                <th>User Vorname</th>
                                <th>User Nachname</th>
                                <th>Username</th>
                                <th>Usergroup</th>
                                <th>User E-Mail Adresse</th>
                                <th>User Geschlecht</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="userWithoutGamesInformation" items="${userWithoutGamesAdministrationList}">
                                <tr>
                                    <td>${userWithoutGamesInformation.userIdAll}</td>
                                    <td>${userWithoutGamesInformation.userFirstNameAll}</td>
                                    <td>${userWithoutGamesInformation.userLastNameAll}</td>
                                    <td>${userWithoutGamesInformation.userNameAll}</td>
                                    <td>${userWithoutGamesInformation.userGroupAll}</td>
                                    <td>${userWithoutGamesInformation.userEmailAll}</td>
                                    <td>${userWithoutGamesInformation.userGenderAll}</td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </article>
                <br>
                <article>
                    <h2>Spiele Übersicht</h2>
                    <div class="responsive_table">
                        <table>
                            <thead>
                            <tr>
                                <th>Game ID</th>
                                <th>User ID</th>
                                <th>Gaming Time</th>
                                <th>Game Date</th>
                                <th>Game Type</th>
                                <th>Game Difficulty</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="userGamesInformation" items="${userGamesAdministrationArrayList}">
                                <tr>
                                    <td>${userGamesInformation.userGameId}</td>
                                    <td>${userGamesInformation.userId}</td>
                                    <td>${userGamesInformation.userGamingTime}</td>
                                    <td>${userGamesInformation.userGameDate}</td>
                                    <td>${userGamesInformation.userGameType}</td>
                                    <td>${userGamesInformation.userGameDifficulty}</td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </article>
                <br>
                <article>
                    <h2>User mit Spiele - Ohne Profilbild</h2>
                    <div class="responsive_table">
                        <table>
                            <thead>
                            <tr>
                                <th>User ID</th>
                                <th>User Vorname</th>
                                <th>User Nachname</th>
                                <th>Username</th>
                                <th>User E-Mail Adresse</th>
                                <th>User Geschlecht</th>
                                <th>Game ID</th>
                                <th>Gaming Time</th>
                                <th>Game Date</th>
                                <th>Game Type</th>
                                <th>Game Difficulty</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="userGamesInformation" items="${userGamesAdministrationArrayList}">
                                <tr>
                                    <td>${userGamesInformation.userId}</td>
                                    <td>${userGamesInformation.userFirstName}</td>
                                    <td>${userGamesInformation.userLastName}</td>
                                    <td>${userGamesInformation.userName}</td>
                                    <td>${userGamesInformation.userEmail}</td>
                                    <td>${userGamesInformation.userGender}</td>
                                    <td>${userGamesInformation.userGameId}</td>
                                    <td>${userGamesInformation.userGamingTime}</td>
                                    <td>${userGamesInformation.userGameDate}</td>
                                    <td>${userGamesInformation.userGameType}</td>
                                    <td>${userGamesInformation.userGameDifficulty}</td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </article>
                        <button class="goToTopButton" id="goToTopButton">Seitenanfang</button>
                
            </main>
        </div>
        <footer>
            <%@include file="../html/jspf/footer.jspf"%>
        </footer>
    </body>
</html>